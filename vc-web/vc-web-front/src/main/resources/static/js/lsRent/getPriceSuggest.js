/**
 * Created by jianghaiyang on 2017/11/17 0017.
 */

$("#city").bsSuggest("init", {
    url: getServUrl("crback/common/getCities?shName="),
    idField: "shId",
    keyField: "shName",
    getDataMethod: "url",
    effectiveFields: ["shName"],
    processData: function (json) {
        var data = {value: []};
        if (!json || !json.data || !json.data.value.length) {
            return data;
        }
        data = json.data;
        return data;
    }
}).on("onDataRequestSuccess", function (e, result) {
    console.log("onDataRequestSuccess: 城市", result)
}).on("onSetSelectValue", function (e, keyword) {
    console.log('选择的城市:->', keyword);
    debugger
    $("input[name='cityId']").val(keyword.id);
    /*运营商初始化*/
    $("#operator").bsSuggest({
        url: getServUrl("crback/common/getCityOperators?cityId=" + keyword.id + "&csdName="),
        idField: "csdId",
        keyField: "csdName",
        getDataMethod: "url",
        effectiveFields: ["csdName"],
        processData: function (json) {
            if (!json || !json.data || !json.data.value.length) {
                return false;
            }
            return json.data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        console.log("onDataRequestSuccess: 运营商", result)
    }).on('onSetSelectValue', function (e, keyword, data) {
        console.log('选择的运营商:->', keyword);
        $("input[name='operatorId']").val(keyword.id);
        /*门店初始化*/
        $("#store").bsSuggest({
            url: getServUrl("crback/common/getStores?storeCityId=" + $("input[name='cityId']").val() + "&storeOperatorId=" + keyword.id +"&storeStatus=1&storeName="),
            idField: "storeId",
            keyField: "storeName",
            getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
            effectiveFields: ["storeName"],
            processData: function (json) {
                if (!json || !json.data || !json.data.value.length) {
                    return false;
                }
                return json.data;
            }
        }).on('onDataRequestSuccess', function (e, result) {
            console.log("onDataRequestSuccess: 门店", result)
        }).on('onSetSelectValue', function (e, keyword, data) {
            console.log('选择的门店:->', keyword);
            $("input[name='storeId']").val(keyword.id);
            /*车型*/
            $("#model").bsSuggest({
                url: getServUrl("crback/common/getStoreModels?storeId=" + keyword.id + "&modelName="),
                idField: "cscmId",
                keyField: "modelName",
                getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
                effectiveFields: ["modelName"],
                processData: function (json) {
                    if (!json || !json.data || !json.data.value.length) {
                        return false;
                    }
                    return json.data;
                }
            }).on('onDataRequestSuccess', function (e, result) {
                console.log("onDataRequestSuccess: 车型", result)
            }).on('onSetSelectValue', function (e, keyword, data) {
                console.log('选择的车型:->', keyword);
                $("input[name='modelsId']").val(keyword.id);
                /*计费策略*/
                $("#strategy").bsSuggest({
                    url: getServUrl("crback/common/getPriceStrategies?strategyModelId=" + keyword.id + "&strategyStatus=1&strategyStoreId="
                    + $("input[name='storeId']").val() + "&strategyName="),
                    idField: "strategyId",
                    keyField: "strategyName",
                    getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
                    effectiveFields: ["strategyName"],
                    processData: function (json) {
                        if (!json || !json.data || !json.data.value.length) {
                            return false;
                        }
                        return json.data;
                    }
                }).on('onDataRequestSuccess', function (e, result) {
                    console.log("onDataRequestSuccess: 计费策略", result)
                }).on('onSetSelectValue', function (e, keyword, data) {
                    console.log('选择的计费策略:->', keyword);
                    $("input[name='strategyId']").val(keyword.id);

                }).on('onUnsetSelectValue', function () {
                    $("input[name='strategyId']").val("");
                    console.log("onUnsetSelectValue---strategyId");
                });

            }).on('onUnsetSelectValue', function () {
                $("input[name='modelsId']").val("");
                $("input[name='strategyId']").val("");
                $("#strategy").val("");
                $("#strategy").bsSuggest("destroy");
                console.log("onUnsetSelectValue---modelsId");
            });

        }).on('onUnsetSelectValue', function () {
            $("input[name='storeId']").val("");
            $("input[name='modelsId']").val("");
            $("#model").val("");
            $("#model").bsSuggest("destroy");
            console.log("onUnsetSelectValue---storeId");
        });
    }).on('onUnsetSelectValue', function () {
        $("input[name='operatorId']").val("");
        $("input[name='storeId']").val("");
        $("#store").val("");
        $("#store").bsSuggest("destroy");
        console.log("onUnsetSelectValue---operatorId");
    });
}).on("onUnsetSelectValue", function (e) {
    console.log("onUnsetSelectValue---cityId");
    $("input[name='cityId']").val("");
    $("input[name='operatorId']").val("");
    $("input[name='storeId']").val("");
    /*文本框清除*/
    $("#operator").val("");
    $("#store").val("");

    $("#operator").bsSuggest("destroy");
    $("#store").bsSuggest("destroy");
});