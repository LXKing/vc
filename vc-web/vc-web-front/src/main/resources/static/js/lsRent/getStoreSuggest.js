/**
 * Created by jianghaiyang on 2017/11/14 0014.
 */
$(function () {
    /*城市初始化*/
    $("#city").bsSuggest({
        idField: "shId",        //每组数据的哪个字段作为 data-id，优先级高于 indexId 设置（推荐）
        keyField: "shName",     //每组数据的哪个字段作为输入框内容，优先级高于 indexKey 设置（推荐）
        allowNoKeyword: true,   //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
        multiWord: true,        //以分隔符号分割的多关键字支持
        separator: ",",         //多关键字支持时的分隔符，默认为空格
        getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
        showHeader: false,      //显示多个字段的表头
        //autoDropup: true,       //自动判断菜单向上展开
        effectiveFields: ["shName"],
        url: getServUrl("crback/common/getCities?shName="),
        processData: function (json) {
            if (!json || !json.data || !json.data.value.length) {
                return false;
            }
            return json.data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
    }).on('onSetSelectValue', function (e, keyword, data) {
        console.log('选择的城市:->', keyword);
        $("#storeCityId").val(keyword.id);
        /*城市区域初始化*/
        $("#area").bsSuggest({
            idField: "csaId",
            keyField: "csaName",
            allowNoKeyword: true,
            multiWord: true,        //以分隔符号分割的多关键字支持
            separator: ",",         //多关键字支持时的分隔符，默认为空格
            getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
            showHeader: false,       //显示多个字段的表头
            effectiveFields: ["csaName"],
            url: getServUrl("crback/common/getCityAreas?cityId=" + keyword.id + "&shName="),
            processData: function (json) {
                if (!json || !json.data || !json.data.value.length) {
                    return false;
                }
                return json.data;
            }
        }).on('onDataRequestSuccess', function (e, result) {
        }).on('onSetSelectValue', function (e, keyword, data) {
            console.log('选择的区域:->', keyword);
            $("#storeCityRegionId").val(keyword.id);
        }).on('onUnsetSelectValue', function () {
            $("#storeCityRegionId").val("");
            console.log("onUnsetSelectValue");
        });
        /*运营商初始化*/
        $("#operator").bsSuggest({
            idField: "csdId",
            keyField: "csdName",
            allowNoKeyword: true,
            multiWord: true,        //以分隔符号分割的多关键字支持
            separator: ",",         //多关键字支持时的分隔符，默认为空格
            getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
            showHeader: false,       //显示多个字段的表头
            effectiveFields: ["csdName"],
            url: getServUrl("crback/common/getCityOperators?cityId=" + keyword.id + "&csdName="),
            processData: function (json) {
                if (!json || !json.data || !json.data.value.length) {
                    return false;
                }
                return json.data;
            }
        }).on('onDataRequestSuccess', function (e, result) {
        }).on('onSetSelectValue', function (e, keyword, data) {
            console.log('选择的运营商:->', keyword);
            $("#storeOperatorId").val(keyword.id);
        }).on('onUnsetSelectValue', function () {
            $("#storeOperatorId").val("");
            console.log("onUnsetSelectValue");
        });
    }).on('onUnsetSelectValue', function () {
        $("#storeCityId").val("");
        console.log("cityId  --> ", cityId);
        $("#storeOperatorId").val("");
        $("#storeCityRegionId").val("");
        /*文本框清除*/
        $("#operator").val("");
        $("#area").val("");

        $("#operator").bsSuggest("destroy");
        $("#area").bsSuggest("destroy");
    });



});
