String.prototype.Trim = function () {
    return this.replace(/^\s+/g, "").replace(/\s+$/g, "");
}

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
    // 获取cookie
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
    // 删除cookie
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

var getSrvlimit = function (path) {
    var datas = "";
    var userid = cookieUtil.get("userId");
    var token = cookieUtil.get("token");
    if (typeof(token) ==="undefined" || token === ""||typeof(userid) ==="undefined" || userid === "") {
        layer.msg('登录已失效', function () {
            // window.location.href = authUrl + "/lockscreen.html?userid=" + userid;
          toLogin();
        });
    }
    $.ajax({
        type: "POST",
        url: getServUrl("/oauth/getSrvlimit"),
        dataType: "json",
        async: false,
        cache: false,
        data: {
            userid: userid,
            path: path
        },
        success: function (data) {
            console.log(data);
            if (data.status) {
                datas = data.data;
                return datas;
            } else {
                if (data.code == "20006") {
                    layer.msg('登录已失效', function () {
                      toLogin();
                    });
                } else {
                    layer.msg('系统繁忙', function () {
                    });
                }
            }
        },
        beforeSend: function (xhr) {
            token = cookieUtil.get(userid + "token");
            console.log("1" + token);
            xhr.setRequestHeader("Authorization", "bearer " + token);
        },
        error: function (result) {
            layer.msg('系统繁忙', function () {
                //关闭后的操作
            });
        }
    });
    return datas;
}


var authUtil = {
    //获取当前页面的权限
    get: function (path) {
        var userid = cookieUtil.get("userId");
        var token = cookieUtil.get("token");
        if (typeof(userid) ==="undefined" || userid == "" || typeof(token) ==="undefined" || token == "") {
            layer.msg('登录已失效', function () {
                // window.location.href = "lockscreen.html?userid=" + userid;
              toLogin();
            });
        } else {

           // var limit = JSON.parse(LocalStorage.get(userid + path));
            var limit = LocalStorage.get(userid + path);
            if (limit == "" || userid == "0")//如果本地缓存为空,请求服务器查询
            {
                return getSrvlimit(path);
            } else {
                return JSON.parse(limit);
            }

        }

    },
    /**
     * 检查当前操作是否有权限,实时校验
     * @param path
     * @param oper
     */
    checkOut: function (path, oper) {

        var jsonObj = getSrvlimit(path);
        if (jsonObj == "") {
            layer.msg('您没有操作该功能的权限', function () {
                //关闭后的操作
            });
            return false;
        }
        var eValue = eval('jsonObj.' + oper);
        if (eValue == "") {
            layer.msg('您没有操作该功能的权限', function () {
                //关闭后的操作
            });
            return false;
        } else if (eValue == "0") {
            layer.msg('您没有操作该功能的权限', function () {
                //关闭后的操作
            });
            return false
        } else {
            return true;
        }
    }
}


var LocalStorage = {

    get: function (key) {
        if (storage.getItem(key) != null) {
            return storage.getItem(key);
        } else if (cookieUtil.get(key) != null) {
            return cookieUtil.get(key);
        }else
        {
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

//封装过期控制代码
function set(key, value) {
    var curTime = new Date().getTime();
    localStorage.setItem(key, JSON.stringify({data: value, time: curTime}));
}

function get(key, exp) {
    var data = localStorage.getItem(key);
    var dataObj = JSON.parse(data);
    if (new Date().getTime() - dataObj.time > exp) {
        console.log('信息已过期');
    } else {
        var dataObjDatatoJson = JSON.parse(dataObj.data)
        return dataObjDatatoJson;
    }
}


function getAllAuth(userid, token) {
    var limit = "";
    $.ajax({
        type: "POST",
        url: getServUrl("/oauth/getUserLimit"),
        data: {
            userid: userid
        },
        dataType: "json",
        cache: false,
        async:false,
        headers: {'Authorization': 'bearer ' + token},
        success: function (data) {
            datas = data;
            if (data.status) {
                    for (var i in data.data) {
                        LocalStorage.set(userid + i, JSON.stringify(data.data[i]));
                    }
                    window.location.href = authUrl;//重新指向首頁
                    // console.log("加入缓存");
            } else {//登陆失效
                layer.confirm('初始化加载失败', {
                    btn: ['重新登陆'] //按钮
                }, function () {
                    window.location.href = authUrl + "/login_v2.html";
                });
            }
        },
//        beforeSend: function (xhr) {
//            console.log(token);
//            xhr.setRequestHeader("Authorization", "bearer " + token);
//        },
        error: function (result) {
            layer.msg('系统繁忙', function () {
                //关闭后的操作
            });
        }
    });
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg); //获取url中"?"符后的字符串并正则匹配
    var context = "";
    if (r != null)
        context = r[2];
    reg = null;
    r = null;
    return context == null || context == "" || context == "undefined" ? "" : context;
}

function loadIndex() {
    storage.clear();//清楚本地缓存
    console.log("清楚缓存");
    var url = window.location.href;	  //获取当前页面的url
    if (url.indexOf("?") != -1) {
        var userid = getQueryString("userid");
        var token = getQueryString("access_token");
        if (userid != "" && token != "") {
            //保存相关信息
            cookieUtil.set(userid + "token", token, cookieUtil.setTime("2100s"));
            cookieUtil.set("userid", userid, cookieUtil.setTime("2100s"));
            var data = getAllAuth(userid, token);
        }
    }
}