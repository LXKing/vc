var connect = "http://catest.app.ccclubs.com";
//模糊查询
var seacheinput = function(companyname, showCompanyname, url, name) {
	var timer = "";
	$("#" + companyname).keyup(function() {
		clearTimeout(timer);
		$("#" + showCompanyname).empty();
		var companynames = $("#" + companyname).val();
		if(companynames) {
			var o = {};
			o[name] = companynames
			timer = setTimeout(function() {
				ajaxRequest(url, o, mycallback);

				function mycallback(json) {
					if(json && json.data.tbody && json.data.tbody.length) {
						var $ul = $("<ul></ul>");
						for(var i = 0; i < json.data.tbody.length; i++) {
							var $li = $("<li></li>");
							$li.text(json.data.tbody[i].text);
							$ul.append($li);
						}
						$("#" + showCompanyname).html($ul).show();
						$("ul li").each(function() {
							$(this).click(function() {
								$("#" + companyname).val($(this).text());
								$("#" + showCompanyname).hide();
							});
						});
					}
				}
			}, 1);
		} else {
			$("#" + showCompanyname).hide();
		}
	});
}
var requiredTempl = function(required) {
	if(required)
		return "：*";
	else
		return "：";
}
//input框的解析
var inputTempl = function(data) {
	return '<div class="form-group"><label class="col-sm-4 control-label">' + (data.labelname + requiredTempl(data.required)) + '</label><div class="col-sm-8"><input data-type="' + data.required + '" data-tips="' + data.labelname + '" name="' + data.name + '" placeholder="' + data.placeholder + '" type="text" value="' + data.value + '" class="form-control"></div></div>';
}
//input框的解析
var inputdisabledTempl = function(data) {
	return '<div class="form-group"><label class="col-sm-4 control-label">' + (data.labelname + requiredTempl(data.required)) + '</label><div class="col-sm-8"><input data-type="' + data.required + '" data-tips="' + data.labelname + '" readonly="readonly" name="' + data.name + '" placeholder="' + data.placeholder + '" type="text" value="' + data.value + '" class="form-control"></div></div>';
}
//textarea框的解析
var textareaTempl = function(data) {
	return '<div class="form-group"><label class="col-sm-4 control-label">' + (data.labelname + requiredTempl(data.required)) + '</label><div class="col-sm-8"><textarea data-type="' + data.required + '" data-tips="' + data.labelname + '" class="form-control" rows="3" name="' + data.name + '" placeholder="' + data.placeholder + '" type="text" value="' + data.value + '">' + data.value + '</textarea></div></div>';
}
//chebox的解析
var checkboxTempl = function(data) {
	var temple = '';
	for(var i = 0; i < data.checkbox.length; i++) {
		if(data.checkbox[i].checked) {
			temple += '<label class="checkbox-inline"><div><input data-type="' + data.required + '" data-tips="' + data.labelname + '" name="' + data.checkbox[i].name + '" checked="' + data.checkbox[i].checked + '" type="checkbox"></div>' + data.checkbox[i].title + '</label>'
		} else {
			temple += '<label class="checkbox-inline"><div><input data-type="' + data.required + '" data-tips="' + data.labelname + '" name="' + data.checkbox[i].name + '" type="checkbox"></div>' + data.checkbox[i].title + '</label>'
		}
	}
	return '<div class="form-group"><label class="col-sm-4 control-label">' + (data.labelname + requiredTempl(data.required)) + '</label><div class="col-sm-8 form-group" style="border: solid 1px #e5e6e7;padding:3px 22px;margin-left: 14px;width: 64%;">' + temple + '</div></div>';
}
//选择框的解析
var selectTempl = function(selectJson) {
	var st = '';
	for(var i = 0; i < selectJson.selectData.length; i++) {
		if(selectJson.value == selectJson.selectData[i].value) {
			st += '<option selected = "selected" value="' + selectJson.selectData[i].value + '">' + selectJson.selectData[i].text + '</option>';
		} else {
			st += '<option value="' + selectJson.selectData[i].value + '">' + selectJson.selectData[i].text + '</option>';
		}

	}
	return '<div class="form-group"><label class="col-sm-4 control-label">' + (selectJson.labelname + requiredTempl(selectJson.required)) + '</label><div class="col-sm-8"><select data-type="' + selectJson.required + '" data-tips="' + selectJson.labelname + '" class="form-control m-b" name="' + selectJson.name + '"><option value="' + selectJson.value + '">' + selectJson.placeholder + '</option>' + st + '</select></div></div>';
};
//键入搜索的解析
var typingTempl = function(data) {
	var templ = '<div class="form-group"><label class="col-sm-4 control-label">' + data.labelname + '</label><div class="col-sm-8"><input name="' + data.name + '" id="' + data.id + '" placeholder="' + data.placeholder + '" type="text" value="' + data.value + '" class="form-control search_input" onblur = "blurhide()"><div class="bdsug" id="' + data.id + 'input"></div></div></div>';
	return templ;
}
//筛选条件的解析
var conditionTempl = function(data, id) {
	var templ = '';
	for(var d = 0; d < data.length; d++) {
		if(data[d].type == "input") {
			templ += inputTempl(data[d]);
		} else if(data[d].type == "select") {
			templ += selectTempl(data[d]);
		} else if(data[d].type == "inputdisabled") {
			templ += inputdisabledTempl(data[d]);
		} else if(data[d].type == "checkbox") {
			templ += checkboxTempl(data[d]);
		} else if(data[d].type == "textarea") {
			templ += textareaTempl(data[d]);
		} else if(data[d].type == "typing") {
			templ += typingTempl(data[d]);
		}
	};
	jQuery("#" + id).html(templ);
	for(var d = 0; d < data.length; d++) {
		if(data[d].type == "typing") {
			templ += typingTempl(data[d]);
			seacheinput(data[d].id, data[d].id + "input", data[d].ajaxUrl, data[d].name);
		}
	}
}
//iframe及title展示
var iframeTempl = function(data, id) {
	var item = '';
	var itemtitle = '';
	for(var i = 0; i < data.length; i++) {
		item += '<iframe class="J_iframe" name="iframe0" width="100%" height="300" src="' + data[i].url + '?id=' + id + '" frameborder="0" data-id="' + data[i].url + '" seamless="" style="display: none;"></iframe>';
		itemtitle += '<a class="J_menuTab" href="javascript:;" data-id="' + data[i].url + '">' + data[i].name + '</a>';
	};
	jQuery("#bottom_title").html(itemtitle);
	jQuery("#bottom_iframe").html(item);
}
//调用模板数据信息
/*
 * jsid:script的ID信息
 * jsonresult:返回数据的结果集
 * htmlid:传入页面的id
 */
function apptemplate(jsid, jsonresult, htmlid) {
	var tempFn = doT.template(jQuery('#' + jsid + '').html());
	var rentText = tempFn(jsonresult);
	jQuery('#' + htmlid + '').html(rentText);
}
//
var ajaxRequest = function(url, data, callback) {
	$.ajax({
		url: connect + url,
		type: "POST",
		data: data,
		async: false,
		dataType: "json",
		success: function(json) {
			callback(json);
		},
		error: function(xhr, textStatus) {
			layer.msg(JSON.stringify(xhr) + "--" + textStatus);
			return false;
		}
	});
}
//table内容解析
var tableTbodyTempl = function(data) {
	var templ = '';
	for(var i = 0; i < data.tbody.length; i++) {
		var id = data.tbody[i][data.thead[0].name.toString()];
		templ += '<tr><td><div class="th-inner "><input value="' + id + '" type="checkbox"></div></td>';
		for(var s = 0; s < data.thead.length; s++) {
			if(data.thead[s].type != "checkbox") {
				var name = data.tbody[i][data.thead[s].name.toString()];
				if(name != '' && name != null && name != "undefined") {
					templ += '<td>' + name + '</td>';
				} else {
					templ += '<td> </td>';
				}
			}
		};
		templ += tableThtempl(data.tbody[i].operation, id);
		templ += '<td class="operation">'+listAuthority(data.authority,id)+'</td>';
		templ += '</tr>';
	};
	var resultReturn = '<table class="table table-bordered" data-resizable-columns-id="demo-table" id="tableList">' + theadTempl(data.thead) + '<tbody>' + templ + '</tbody></table>';
	jQuery("#tableId").html(resultReturn);
	pageSizeTempl(data.pageList); //分页模板
};
//增删改查权限控制
var listAuthority=function(data,id){
	var s='';
	if(data.update){
		s+='<span><a data-toggle="modal" onclick="update(' + id + ')">修改</a></span>';
	}
	if(data.select){
		s+='<span><a onclick="detial(' + id + ')">详情</a></span>';
	}
	if(data.del){
		s+='<span><a onclick="deleteItem(' + id + ')">删除</a></span>';
	}
	var templBtnHtml = '<button class="btn btn-primary col-sm-2" type="button" id="queryBtn">查询</button>';
	templBtnHtml += '<button class="btn btn-white col-sm-2 col-sm-offset-2" type="reset">重置</button>';
	if(data.add){
		templBtnHtml += '<button class="btn btn-primary col-sm-2 col-sm-offset-2" type="button" id="addBtn" onclick="addList()">新增</button>';
	};
	jQuery("#queryBtns").html('<div class="col-sm-10 col-sm-offset-1" >' + templBtnHtml + '</div>');
	return s;
	
}
//table头部解析
var theadTempl = function(theadJson) {
	var menuTempl = '';
	var thTempl = '<thead><tr><th data-resizable-column-id="#"><div class="th-inner"><label id="checkall"><a>全选</a></label>&nbsp;/&nbsp;<label id="checkrev"><a>全部取消</a></label></div></th>';
	for(var t = 0; t < theadJson.length; t++) {
		if(theadJson[t].type != "checkbox") {
			thTempl += '<th data-resizable-column-id="#">' + theadJson[t].title + '</th>'; //表头的循环
			menuTempl += '<li><label><input type="checkbox" value="' + (t + 1) + '" checked="checked">' + theadJson[t].title + '</label></li>';
		}
	};
	jQuery("#tableMenu").html(menuTempl);
	//控制列的展示和隐藏
	jQuery(".dropdown-menu input").click(function() {
		$("td:eq(" + $(this).val() + ")", $("tr")).toggle(500); //设置为0表示不用动画
		$("th:eq(" + $(this).val() + ")", $("tr")).toggle(500); //设置为0表示不用动画
	});
	return thTempl + '<th class="operations" data-resizable-column-id="#">操作</th><th class="operation" data-resizable-column-id="#"></th></tr></thead>';
}
//table当前记录操作展示
var tableThtempl = function(data, id) {
	var templ = '';
	if(data != '' && data != null && data != "undefined") {
		for(var i = 0; i < data.length; i++) {
			templ += '<li data-url="' + data[i].ajaxurl + '" data-id="' + id + '"><a href="javascript:;">' + data[i].name + '</a></li>';
		}
	}
	return '<th class="operations" data-resizable-column-id="wwwww"><div class="input-group-btn"><button data-toggle="dropdown" class="btn btn-white dropdown-toggle" type="button">操作 <span class="caret"></span></button><ul class="dropdown-menu">' + templ + '</ul></div></th>';
}
//table分页处理
var pageSizeTempl = function(data) {
	var templ = '<div class="pull-left pagination-detail"><span class="pagination-info">一共' + data.total + '页，每页' + data.size + '条记录，当前在第' + data.index + '页，一共有' + data.count + '条记录</span></div>'
	templ += '<div class="pull-right pagination" style="margin: 0 !important;"><nav aria-label="Page navigation"><ul class="pagination" id="pageclick">';
	if(data.index == 1) {
		templ += '<li class="disabled" data-page="1">';
	} else {
		templ += '<li data-page="1">';
	}
	templ += '<a href="javascript:;" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
	if(data.index - 1 > 0) {
		templ += '<li data-page="' + (data.index - 1) + '"><a href="javascript:;">' + (data.index - 1) + '</a></li>';
	}
	templ += '<li data-page="' + data.index + '" class="active"><a href="javascript:;">' + data.index + '</a></li>';
	if(data.total != data.index) {
		templ += '<li data-page="' + (data.index + 1) + '"><a href="javascript:;">' + (data.index + 1) + '</a></li>';
	}
	if(data.total == data.index) {
		templ += '<li data-page="' + data.total + '">';
	} else {
		templ += '<li class="disabled" data-page="' + data.total + '">';
	}
	templ += '<a href="javascript:;" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
	jQuery("#tablepageId").html(templ);
}

//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}
//非正常内容判断
var isEmpty = function(p) {
	if(p != '' && p != 'undefined' && p != null && p != '{}' && p != '[]') {
		return true;
	} else {
		return false;
	}
};
//程序生成input、select、checkbox
var autoFrombox = function(tbody) {
	var s = '[';
	for(var i = 0; i < tableJson.thead.length; i++) {
		if(i == 0) {
			s += '{"type":"' + tableJson.thead[i].type + '","labelname":"' + tableJson.thead[i].title + '","name":"' + tableJson.thead[i].name + '","placeholder":"' + tableJson.thead[i].placeholder + '","value":"' + autoFromboxNone(tbody[tableJson.thead[i].name.toString()], tbody) + '","required": ' + tableJson.thead[i].required + '}';
		} else {
			if(isEmpty(JSON.stringify(tableJson.thead[i].selectData))) {
				s += ',{"type":"' + tableJson.thead[i].type + '","labelname":"' + tableJson.thead[i].title + '","name":"' + tableJson.thead[i].name + '","placeholder":"' + tableJson.thead[i].placeholder + '","value":"' + autoFromboxNone(tbody[tableJson.thead[i].name.toString()], tbody) + '","required": ' + tableJson.thead[i].required + ',"selectData":' + JSON.stringify(tableJson.thead[i].selectData) + '}';
			} else {
				if(isEmpty(JSON.stringify(tableJson.thead[i].checkbox))) {
					s += ',{"type":"' + tableJson.thead[i].type + '","labelname":"' + tableJson.thead[i].title + '","name":"' + tableJson.thead[i].name + '","placeholder":"' + tableJson.thead[i].placeholder + '","required": ' + tableJson.thead[i].required + ',"checkbox":' + JSON.stringify(tableJson.thead[i].checkbox) + '}';
				} else {
					s += ',{"type":"' + tableJson.thead[i].type + '","labelname":"' + tableJson.thead[i].title + '","name":"' + tableJson.thead[i].name + '","placeholder":"' + tableJson.thead[i].placeholder + '","value":"' + autoFromboxNone(tbody[tableJson.thead[i].name.toString()], tbody) + '","required": ' + tableJson.thead[i].required + '}'
				}
			}
		}
	};
	s = s + ']';
	return eval('(' + s + ')');
};
var autoFromboxNone = function(value, tbody) {
	if(tbody == 'none') {
		return '';
	}
	if(isEmpty(value)) {
		return value;
	} else {
		return '';
	}

}
//获取键值对信息
var requestSelectJson = function(url) {
	var sendjson = null;
	ajaxRequest(url, {}, mycallback);
	//数据返回
	function mycallback(json) {
		sendjson = json.data.tbody;
	};
	return sendjson;
}
//修改当前记录
function update(id) {
	//iframeTempl(iframeJson, id);
	$(".change_title").html("修改用户信息")
	$(".content-tabs").show()
	jQuery("#save_form").show();
	jQuery(".formBtn button").css("width", "30%");
	jQuery(".J_menuTabs a").removeClass("active");
	jQuery(".J_mainContent iframe").css("display", "none");
	$('#myModal').modal({
		backdrop: 'static',
		keyboard: false
	});
	ajaxRequest(urlJson.particulars, {
		"id": id
	}, detailBack);

	function detailBack(json) {
		conditionTempl(autoFrombox(json.data.tbody), "detialfrom");
	}
	$("#detialfrom select").remove("disabled");
	$("#detialfrom input").remove("disabled");
	$("#detialfrom textarea").remove("disabled");
	//获取form表单的数据
	jQuery("#save_form").click(function() {
		var resultType = true;
		var o = {};
		var a = $("#fromId").serializeArray();
		$.each(a, function() {
			if(o[this.name] !== undefined) {
				if(!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			};

			var valuedata = $("#fromId [name='" + this.name + "']");
			var tipsdata = valuedata.parent("div").siblings("label").html();
			if(valuedata.data("type")) {
				if(valuedata.val() == '' || valuedata.val() == null || valuedata.val() == "undefined") {
					layer.msg("请填写正确的" + valuedata.data("tips"));
					resultType = false;
					return resultType;
				}
			};
		});
		//checkbox获取对应的值
		$('#fromId input:checkbox:not(:checked)').each(function() {
			o[this.name] = $(this).is(':checked');
		})
		$('#fromId input:checkbox:checked').each(function() {
			o[this.name] = $(this).is(':checked');
		});
		if(resultType) {
			ajaxRequest(urlJson.update, o, mycallback);
			//数据返回
			function mycallback(json) {
				layer.msg("修改成功！");
				getQueryData(); //刷新table
				setTimeout(function() {
					$('#myModal').modal("hide");
				}, 400);
			}
		}
	});
};
//查看当前记录详情
function detial(id) {
	iframeTempl(iframeJson, id);
	jQuery("#save_form").hide();
	$(".content-tabs").show()
	jQuery(".formBtn button").css("width", "60%");
	jQuery(".J_menuTabs a").removeClass("active");
	jQuery(".J_mainContent iframe").css("display", "none");
	$('#myModal').modal({
		backdrop: 'static',
		keyboard: false
	});
	//详情加载
	ajaxRequest(urlJson.particulars, {
		"id": id
	}, detailBack);

	function detailBack(json) {
		var tbody = json.data.tbody;
		conditionTempl(autoFrombox(json.data.tbody), "detialfrom");
		$("#detialfrom select").attr("disabled", "disabled");
		$("#detialfrom input").attr("disabled", "disabled");
		$("#detialfrom textarea").attr("disabled", "disabled");
	};
};
// 新增用户数据
function addList(id) {
	$(".change_title").html("新增用户信息");
	jQuery("#save_form").show();
	$(".content-tabs").hide();
	jQuery(".formBtn button").css("width", "30%");
	jQuery(".J_menuTabs a").removeClass("active");
	jQuery(".J_mainContent iframe").css("display", "none");
	$('#myModal').modal({
		backdrop: 'static',
		keyboard: false
	});
	//添加加载
	conditionTempl(autoFrombox("none"), "detialfrom");
	$("#detialfrom select").remove("disabled");
	$("#detialfrom input").remove("disabled");
	$("#detialfrom textarea").remove("disabled");
	//获取form表单的数据
	jQuery("#save_form").click(function() {
		var resultType = true;
		var o = {};
		var a = $("#fromId").serializeArray();
		$.each(a, function() {
			if(o[this.name] !== undefined) {
				if(!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			};
			var valuedata = $("#fromId [name='" + this.name + "']");
			var tipsdata = valuedata.parent("div").siblings("label").html();
			if(valuedata.data("type")) {
				if(valuedata.val() == '' || valuedata.val() == null || valuedata.val() == "undefined") {
					layer.msg("请填写正确的" + valuedata.data("tips"));
					resultType = false;
					return resultType;
				}
			};
		});
		//checkbox获取对应的值
		$('#fromId input:checkbox:not(:checked)').each(function() {
			o[this.name] = $(this).is(':checked');
		})
		$('#fromId input:checkbox:checked').each(function() {
			o[this.name] = $(this).is(':checked');
		});
		if(resultType) {
			ajaxRequest(urlJson.add, o, mycallback);
			//数据返回
			function mycallback(json) {
				layer.msg("添加成功！");
				getQueryData(); //刷新table
				setTimeout(function() {
					$('#myModal').modal("hide");
				}, 400);
			}
		}
	});
};
//删除按钮事件
jQuery("#exampleToolbar").click(function() {
	jQuery.each($('#tableList tbody input:checkbox'), function() {
		if(this.checked) {
			deleteItem(jQuery(this).val());
		}
	});
});
//删除当前记录提交
var deleteItem = function(id) {
	swal({
		title: "您确定要删除这条信息吗",
		text: "删除后将无法恢复，请谨慎操作！",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "删除",
		closeOnConfirm: false
	}, function() {
		ajaxRequest(urlJson.delete, {
			"id": id
		}, mycallback);
		//数据返回
		function mycallback(json) {
			swal("删除成功！", "您已经永久删除了这条信息。");
			getQueryData(); //刷新table当前数据
		}
	});
};
//失去焦点事件
function blurhide(){
		setTimeout(function(){
				$(".bdsug").hide()
		},500)
}