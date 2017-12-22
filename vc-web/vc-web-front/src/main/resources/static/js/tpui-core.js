/**
 * 应用服务地址
 */
// var servUrl = "http://118.178.230.105:7004";
var servUrl 	= "http://localhost:9009";
/**
 * 统一认证地址
 */
var authUrl = "http://localhost:9009";

function getServUrl(path) {
    // if (path.indexOf("crback/") != -1) {
    //     servUrl = "http://118.178.230.105:7004";
    // }
    // else if (path.indexOf("/base/") != -1) {
    //     servUrl = "http://118.178.230.105:8085";
    // } else if (path.indexOf("/user/") != -1) {
    //     servUrl = "http://118.178.230.105:8081";
    // } else if (path.indexOf("/vehicle/") != -1) {
    //     servUrl = "http://118.178.230.105:8082";
    // } else if (path.indexOf("/carshare/") != -1) {
    //     servUrl = "http://118.178.230.105:8086";
    //     servUrl = "http://localhost:8086";
    // }
    if(!path.startsWith("/")){
        path = "/" + path;
    }
    return servUrl + path ;//+ "?oauth=" + cookieUtil.get("token");
}

function toLogin() {
    top.window.location.href = authUrl + "/login_v2.html?referer=" + top.window.location.href;
}

/**
 * cookie存储
 */
cookieUtil = {
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

/**
 * 权限校验
 * @param path
 * @returns
 */
var getSrvlimit = function (path) {
    var datas = "";
    var userId = cookieUtil.get("userId");
    if (userId == "") {
      layer.msg('登录已失效', function () {
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
            userid: userId,
            path: path
        },
        success: function (data) {
            console.log(data.data);
            if (data.success) {
                datas = data.data;
                return datas;
            } else {
                if (data.code == "20006") {
                  layer.msg('登录已失效', function () {
                    toLogin();
                  });
                } else if (data.code == "20008") {
                    layer.msg('您没有操作该功能的权限');

                } else {
                    layer.msg('系统繁忙');
                }
            }
        },
        beforeSend: function (xhr) {
            token = cookieUtil.get("token");
            xhr.setRequestHeader("Authorization", token);
        },
        error: function (result) {
            layer.msg('系统繁忙');
        }
    });
    return datas;
}

/**
 * 权限
 */
authUtil = {
    limits: {},
    /**
     * 页面按钮权限
     * @param path 项目地址
     * @returns
     */
    get: function (path) {
        var token = cookieUtil.get("token");
        if (typeof(token) ==="undefined" || token === "") {
          layer.msg('登录已失效', function () {
            toLogin();
          });
        } else {
            this.limits = getSrvlimit(path);
            return this.limits;
        }

    },

    checkOut: function (path, oper) {
        if (path == "" || oper == "") {
            return false;
        }
        var jsonObj = getSrvlimit(path);
        if (jsonObj == "") {
            layer.msg('您没有操作该功能的权限');
            return false;
        }
        var eValue = eval('jsonObj.' + oper);
        if (eValue == "") {
            layer.msg('您没有操作该功能的权限');
            return false;
        } else if (eValue == "0") {
            layer.msg('您没有操作该功能的权限');
            return false
        } else {
            return true;
        }
    },

    initSctl: function () {
        var p = this.limits;

        for (r in p) {
            if (p[r] instanceof Array) {
                for (var i = 0; i < p[r].length; i++) {
                    if (p[r][i] !== 1) {
                        $("[sctl='exp-" + i + "']").remove();
                    }
                }
                continue;
            }
            if (p[r] !== 1) {
                $("[sctl='" + r + "']").remove();
            }
        }
    }
}


/**
 * 显示顶级弹窗
 * @param options_
 */
function showTopWin(options_) {
    var options = options_;
    options._end = options.end || function () {
    };
    /**
     * 重写layer.open参数
     */
    options.end = function () {
        var result = top["layerWinResult"] || {success: false};
        options._end(result);
        top["layerWinResult"] = {success: false};
    };
    top.layer.open(options);
}

/**
 * 关闭顶级弹窗
 * @param success
 * @param data_
 */
function closeTopWin(success, data_) {
    var data = data_ || {};
    data.success = success || false;
    top["layerWinResult"] = data;
    var index = top.layer.getFrameIndex(window.name);
    top.layer.close(index);
}

function resetForm(form) {
    $(form)[0].reset();
    $("input:hidden", $(form)).val("");
}

var imageField = {
    toUpload: function (input) {
        var imgInput = $(input).parent().prev(".imgfiletext");
        var imgUrl = imgInput.val();
        showTopWin({
            type: 2,
            shade: 0.4,
            maxmin: true,
            area: ['650px', '535px'],
            content: '/imageField.html?imgUrl=' + imgUrl + '&uuid=' + (new Date().getTime()),
            zIndex: top.layer.zIndex, //重点1
            success: function (layero) {
                //layer.setTop(layero); //重点2
            },
            end: function (result) {
                if (result.success) {
                    imgInput.val(result.url);
                }
            }
        });
    },
    remove: function (input) {
        var imgInput = $(input).parent().prev(".imgfiletext");
        imgInput.val("");
    }
};

showOperMenu = function(t, menus){
  if(menus.length==0)return;

  $(".gridToolBar").show();
  var menuDIV = $(".optionMenu");
  menuDIV.children(".MenuCon").html("");
  for(var i=0;i<menus.length;i++){
    var menu = $("<li><a href=\"javascript:;\">"+menus[i].text+"</a></li>");
    menu.bind("click", menus[i].data||{}, menus[i].handler);
    menuDIV.children(".MenuCon").append(menu);
  }
  var top = $(t).offset().top+22, left = $(t).offset().left;
  menuDIV.css({
    top:top,
    left:left
  }).click(function(){
    $(this).hide();
  }).show();
};

var mapAreaField = {
    set: function (input, type) {
        var input = $(input).parent().prev(".mapAreaField");
        var data = input.val();
        showTopWin({
            type: 2,
            shade: 0.4,
            maxmin: true,
            area: ['650px', '535px'],
            content: '/mapAreaField.html?data=' + data + "&type=" + type + '&uuid=' + (new Date().getTime()),
            zIndex: top.layer.zIndex, //重点1
            success: function (layero) {
                //layer.setTop(layero); //重点2
            },
            end: function (result) {
                if (result.success) {
                    input.val(result.polygonArr);
                }
            }
        });
    },
    remove: function (input) {
        var input = $(input).parent().prev(".mapAreaField");
        input.val("");
    }
};

function getFormData(form) {
    var queryJson = {};
    var fields = form.serializeArray();
    $.each(fields, function () {
        //if(this.value == "")return;
        if (queryJson[this.name] !== undefined) {
            if (!queryJson[this.name].push) {
                queryJson[this.name] = [queryJson[this.name]];
            }
            queryJson[this.name].push(this.value || '');
        } else {
            queryJson[this.name] = this.value || '';
        }
    });
    for (var k in queryJson) {
        if (queryJson[k] instanceof Array && queryJson[k].length > 1) {
            var s = "";
            for (var i = 0; i < queryJson[k].length; i++) {
                if (queryJson[k][i] != "")
                    s += (i == 0 ? "" : ",") + queryJson[k][i];
            }
            queryJson[k] = s;
        } else if (queryJson[k] == "") {
            queryJson[k] = undefined;
        }
    }
    return queryJson;
}

function dateFormatter(cellvalue, options, rowObject) {
    if (!cellvalue || cellvalue == "") return "";
    return dateFormat(cellvalue, "yyyy-MM-dd");
}

function datetimeFormatter(cellvalue, options, rowObject) {
    if (!cellvalue || cellvalue == "") return "";
    return dateFormat(cellvalue);
}

function getIds(ids, split) {
    var idstr = "";
    if (ids && ids.length > 0) {
        for (var i = 0; i < ids.length; i++) {
            idstr += (i == 0 ? "" : split || ",") + ids[i];
        }
    }
    return idstr;
}

/**
 * 将json对象 或 某一具体参数转化为URL  get 参数形式
 * //调用：
 var obj={name:'tom','class':{className:'class1'},classMates:[{name:'lily'}]};
 parseParam(obj);
 结果："name=tom&class.className=class1&classMates[0].name=lily"
 parseParam(obj,'stu');
 结果："stu.name=tom&stu.class.className=class1&stu.classMates[0].name=lily"
 * @param param
 * @param key
 * @returns {string}
 */
function jsonToUri(param){
  var paramStr="";
    $.each(param,function(i,val){
      paramStr+=paramToUri(val, i);
    });
  return paramStr.substr(1);
};

function paramToUri(param, key){
  var paramS="";
  if(typeof(param) === 'undefined'){
    //paramS+="&"+key+"=";

  }
  else {
    paramS+="&"+key+"="+encodeURIComponent(param);
  }

  return paramS;
};

/**
 * 将现有条件附加上排序
 * @param params
 * @param key
 * @param sort
 * @returns {*}
 */
function transferParamsWithSort (params,key,sort) {
  sort = sort||"desc";
  if(typeof(params) === 'undefined' || typeof(params.where) === 'undefined'){
    params = $.extend(params,{where:{
      sidx:key,
      sord:sort
    }})
  }else if( params.where.sidx === null || typeof(params.where.sidx) === 'undefined' ||params.where.sord === null || typeof(params.where.sord) === 'undefined')
  {
    params.where=$.extend(params.where,{
      sidx:key,
      sord:sort
    })
  }
  return params;
}

function transferParamsWithSortExport (params,key,sort) {
  sort = sort||"desc";
  if(typeof(params) === 'undefined'){
    params = $.extend(params,{
      sidx:key,
      sord:sort
    })
  }else if( params.sidx === null || typeof(params.sidx) === 'undefined' ||params.sord === null || typeof(params.sord) === 'undefined')
  {
    params=$.extend(params,{
      sidx:key,
      sord:sort
    })
  }
  return params;
}


/**
 * 发起Ajax请求
 * @param url    请求地址
 * @param type    方法：GET/POST/DELETE...
 * @param data  传递数据JSON格式
 * @param callback    回调函数
 * @param async 是否异步，默认异步
 */
function ajaxRequest(url, type, data, callback, async) {
    var token = cookieUtil.get("token");
    $.ajax({
        url: url,
        type: type || "POST",
        data: data,
        async: async || false,
        dataType: "json",
        headers: {'Authorization': token},
        success: function (json) {
            if (json.success) {
                callback(json);
            } else {
                if (json.code == "20006") {
                  layer.msg('登录已失效', function () {
                    toLogin();
                  });
                } else if (json.code == "20008") {
                    layer.msg('您没有操作该功能的权限');

                }else if (json.message != null && json.message != "") {
                    layer.msg(json.message);
                }else {
                  layer.msg('系统繁忙');
                }
            }

        },
        error: function (xhr, textStatus) {
            console.log(JSON.stringify(xhr) + "--" + textStatus);
            layer.msg('系统繁忙');
            return false;
        }
    });
}

/**
 * 获取url参数
 * @param name
 * @returns
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    return null;
}

/**
 * 日期反格式化
 * @param time
 * @param fmt
 * @returns {String}
 */
dateFormat = function (time, fmt) {
    if (null == fmt || typeof fmt == "undefined" || $.trim(fmt).length == 0) {
        fmt = "yyyy-MM-dd HH:mm:ss";
    }
    if (typeof time == "number") {
        time = new Date(time);
    } else {
        return time;
    }

    var o = {
        "M+": time.getMonth() + 1, // 月份
        "d+": time.getDate(), // 日
        "h+": time.getHours(), // 小时
        "H+": time.getHours(), // 小时
        "m+": time.getMinutes(), // 分
        "s+": time.getSeconds(), // 秒
        "q+": Math.floor((time.getMonth() + 3) / 3), // 季度
        "S": time.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};

function initCheckBoxValue(name, vals) {
    if (vals == undefined) return;
    var checkBoxArray = (vals + "").split(",");
    for (var i = 0; i < checkBoxArray.length; i++) {
        $("input[name='" + name + "']").each(function () {
            if ($(this).val() == checkBoxArray[i]) {
                $(this).attr("checked", "true");
                $(this).parent().addClass("checked");
            }
        });
    }
}

/**
 * 加载表单数据
 * @param obj
 */
function loadFormData(obj) {
    var key, value, tagName, type, arr;
    for (x in obj) {
        key = x;
        value = obj[x] || "";

        $("[name='" + key + "'],[name='" + key + "[]']").each(function () {
            tagName = $(this)[0].tagName;
            type = $(this).attr('type');

            if (tagName == 'INPUT') {
                if (type == 'radio') {
                    $(this).attr('checked', $(this).val() == obj[key]);
                } else if (type == 'checkbox') {
                    initCheckBoxValue(key, obj[key]);
                } else {
                    $(this).val(obj[key]);
                }
            } else if (tagName == 'SELECT') {
                $(this).val(obj[key]);
            } else if (tagName == 'TEXTAREA') {
                $(this).val(obj[key]);
            }

            //缺乏自定义扩展属性
            if ($("[name='" + key + "_txt']").hasClass("searchinput")) {
                var dataKey = $("[name='" + key + "_txt']");
                $("[name='" + key + "_txt']").val(obj[key + "Text"]);
            }
        });

    }

    var ext = obj || {};
    for (x in ext) {
        $("[initText='{" + x + "}']").each(function () {
            $(this).attr("initText", ext[x]);
        });
    }
}

(function (root, factory, plugin) {
    root[plugin] = factory(root.jQuery, plugin);
})(window, function ($, plugin) {
    var _def_ = {
        name: ""
    };
    var _prop_ = {
        _init: function () {
            var element = $(this)[0];
            if (!element) {
                element = $('<input name="' + this.name + '_txt" placeholder="' + this.placeholder + '"  class="form-control" type="text">');
            } else {
                this.url = getServUrl($(element).attr("dataUrl"));
                this.where = $(element).attr("dataWhere") || "";
                this.id = $(element).attr("id") || "";
                this.name = $(element).attr("name") || "";
                this.initText = $(element).attr("initText") || "";
                this.val = $(element).val();
                $(element).attr("id", "");
                $(element).attr("name", this.name + "_txt");
                $(element).val(this.initText);
            }
            this.showText = $(element).attr("readonly", true).css("background-color", "white");
            this.showWrapper = $('<div class="searchWrapper" id="' + this.name + 'Wrapper"></div>');
            this.$value = $('<input type="hidden" name="' + this.name + '" id="' + this.id + '" value="' + this.val + '" />');
            this.$ul = $("<ul></ul>");
            this.$input = $("<input type='text' class='searchtext' />");
            this.clearBtn = $("<button type='button' class='clearBtn btn btn-default btn-xs' style='float:right;'>清空</button>");
            this.countText = $("<span style='float:left;'></span>");
            this.after(this.showWrapper);

            var O = this;
            O.showWrapper.append(O.$value);
            O.showText.click(function () {
                //O.$input.val(O.showText.val());
                O.load(O.$input.val(),O.where);

                O.showWrapper.append(O.$input);
                O.showWrapper.width(O.showText.css('width'));
                O.showWrapper.append(O.$ul).show();
                O.$input[0].focus();
                O.$input[0].select();

                O.$input.on("blur", function () {
                    setTimeout(function () {
                        // input框失去焦点，隐藏下拉框
                        O.showWrapper.hide();
                    }, 300);
                    //O.showWrapper.slideUp(550);
                });
            });

            O.$input.keyup(function () {
                O.load(O.$input.val(),O.where);
            });
        },
        load: function (pvalue,where) {
            var O = this;
            ajaxRequest(O.url, "GET", {text: pvalue,where:where}, function (json) {
                O.$ul.html("");
                var count = ((json.value || {length: 0}) || json.value).length;
                if (json && json.value && json.value.length) {
                    for (var i = 0; i < Math.min(json.value.length, 10); i++) {
                        var txt = json.value[i].text;
                        var $li = $("<li title='" + txt + "'></li>");
                        $li.text(txt);
                        $li.attr("value", json.value[i].value);
                        O.$ul.append($li);
                    }
                    O.$ul.find("li").each(function () {
                        $(this).click(function () {
                            O.showText.val($(this).text());
                            O.$value.val($(this).attr("value"));
                            O.$value.trigger("input");
                            O.showWrapper.hide();
                        });
                    });
                    O.clearBtn.click(function () {
                        O.showText.val("");
                        O.$value.val("");
                        O.$value.trigger("input");
                        O.showWrapper.hide();
                    });
                }
                var container = $("<div></div>").append(O.countText.text("总计匹配" + count + "条")).append(O.clearBtn);
                O.$ul.append(container);

            }, true);
        }
    };
    $.fn[plugin] = function (options) {
        $.extend(this, _def_, options, _prop_);
        this._init();
    };
    return function () {
        var dom = option.dom;
        $(dom)[plugin].call($(dom), options);
    };
}, "searchinput");

var browser = {
    // 检测是否是IE浏览器
    isIE: function () {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'msie') {
            return true;
        } else {
            return false;
        }
    },
    // 检测是否是chrome浏览器
    isChrome: function () {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'chrome') {
            return true;
        } else {
            return false;
        }
    },
    // 检测是否是Firefox浏览器
    isMozila: function () {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'mozilla') {
            return true;
        } else {
            return false;
        }
    },
    // 检测是否是Firefox浏览器
    isOpera: function () {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'webkit') {
            return true;
        } else {
            return false;
        }
    }
}; 	