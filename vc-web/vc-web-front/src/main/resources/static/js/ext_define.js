var validateRuleConfig = {
	 rules:{
		"tuAge":{
			"maxlength":20,
			"digits":true,
			"required":true
		},
		"tuCity":{
			"maxlength":20,
			"digits":true
		},
		"tuRegtime":{
			"date":true
		},
		"tuBirthday":{
			"date":true
		},
		"tuName":{
			"maxlength":255,
			"required":true
		},
		"tuHeadimg":{
			"maxlength":255
		},
		"tuId":{
			"maxlength":20,
			"digits":true,
			"required":true
		},
		"tuWeight":{
			"number":true
		},
		"tuAihao":{
			"maxlength":255
		},
		"tuMemo":{
			"maxlength":1025
		},
		"tuAddtime":{
			"required":true,
			"date":true
		},
		"tuGender":{
			"maxlength":255,
			"required":true
		}
	}
};

/**
 * 模块定义
 */
var modeldefine = {
	index:{
		init:function(queryform, grid, menubar){
			
		}
	},
	menubar:{
		init:function(menubar){
			
		},
		click:function(text){
			
		}
	},
	queryform:{
		init:function(){
			
		}
	},
	listgrid:{
		init:function(){
		   
		},
		beforeLoad:function(grid){
			
		},
		afterLoad:function(grid, data){
			
		}
	},
	addform:{},
	editform:{
		init:function(){
			
		},
		submit:function(){
			
		}
	},
	detailform:{
		init:function(){
			
		}
	}
};



/*jqGrid请求前*/
$.extend($.jgrid.defaults, {
    beforeRequest: function () {
        var token = cookieUtil.get("token");
        if (token == "") {
          layer.msg('登录已失效', function () {
            toLogin();
          });
        }
    },
    loadBeforeSend: function (xhr){
        xhr.setRequestHeader("Authorization",cookieUtil.get("token"));
    },
    ajaxGridOptions: {Authorization: cookieUtil.get("token")},
    loadComplete: function (xhr) {
        if (xhr.code == 20006) {
          layer.msg('登录已失效', function () {
            toLogin();
          });
        }
        else if (xhr.code > 100000) {
            layer.msg("服务异常！", {icon: 7, time: 1600});
        }
    }
});