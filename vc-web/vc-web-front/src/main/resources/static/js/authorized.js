String.prototype.Trim = function () {
    return this.replace(/^\s+/g, "").replace(/\s+$/g, "");
}
var authUrl = "http://116.62.31.211:8081";

var storage = window.localStorage;
var cookieUtil = {
    // 设置cookie "haveSave","yes","5000s"
    set: function (name, value, expires, domain, path, secure) {
        var cookieText = "";
        cookieText += encodeURIComponent(name) + "=" + encodeURIComponent(value);
        if (expires instanceof Date) {
            cookieText += "; expires=" + expires.toGMTString();
        }
        if (path) {
            cookieText += "; path=" + path;
        }
        if (domain) {
            cookieText += "; domain=" + domain;
        }
        if (secure) {
            cookieText += "; secure";
        }
        document.cookie = cookieText;
    },
    get: function (name) {
        var cookieName = encodeURIComponent(name) + "=",
            cookieStart = document.cookie.indexOf(cookieName),
            cookieValue = "";
        if (cookieStart > -1) {
            var cookieEnd = document.cookie.indexOf(";", cookieStart);
            if (cookieEnd == -1) {
                cookieEnd = document.cookie.length;
            }
            cookieValue = decodeURIComponent(document.cookie.substring(cookieStart + cookieName.length, cookieEnd));
        }
        return cookieValue;
    },
    unset: function (name, domain, path, secure) {
        this.set(name, "", Date(0), domain, path, secure);
    },

    setTime: function (str) {
        var strsec;
        var str1 = str.substring(1, str.length) * 1;
        var str2 = str.substring(0, 1);
        if (str2 == "s") {
            strsec = str1 * 1000;
        } else if (str2 == "h") {
            strsec = str1 * 60 * 60 * 1000;
        } else if (str2 == "d") {
            strsec = str1 * 24 * 60 * 60 * 1000;
        }
        var exp = new Date();
        return exp.setTime(exp.getTime() + str1 * 1);
    }
};

var LocalStorage = {

    get: function (key) {
        if (storage.getItem(key) != null) {
            return storage.getItem(key);
        } else if (cookieUtil.get(key) != null) {
            return cookieUtil.get(key);
        } else {
            "{}";
        }
    },

    set: function (key, value) {
        var strValue = value;
        if (storage) {
            storage.setItem(key, strValue);
        } else {
            cookieUtil.set(key, strValue);
        }
    }

}

function set(key, value) {
    var curTime = new Date().getTime();
    localStorage.setItem(key, JSON.stringify({data: value, time: curTime}));
}

function get(key, exp) {
    var data = localStorage.getItem(key);
    var dataObj = JSON.parse(data);
    if (new Date().getTime() - dataObj.time > exp) {
        layer.msg('信息已过期', function () {
            //关闭后的操作
        });
    } else {
        var dataObjDatatoJson = JSON.parse(dataObj.data)
        return dataObjDatatoJson;
    }
}




function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    var context = "";
    if (r != null)
        context = r[2];
    reg = null;
    r = null;
    return context == null || context == "" || context == "undefined" ? "" : context;
}

(function(){ 
    var url = window.location.href;
    if (url.indexOf("?") != -1) {
        storage.clear();
        var userId = getQueryString("userId");
        var token = getQueryString("access_token");
        if (userId != "" && token != "") {
            cookieUtil.set("token", token, cookieUtil.setTime("10000s"));
            cookieUtil.set("userId", userId, cookieUtil.setTime("10000s"));
            LocalStorage.set("userId",userId);
            window.location.href = "index.html";
        }
    }
})();
