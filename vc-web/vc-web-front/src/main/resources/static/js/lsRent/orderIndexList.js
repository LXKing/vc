var operate = {
		getGrid:function(){
			return $("._grid");
		},
		getQueryForm:function(){
			return $(".queryform");
		},
		getMenuBar:function(){
			return $(".btn-group");
		},
		getQueryParamJSON:function(){
			var queryJson = getFormData(this.getQueryForm());
			console.log(queryJson);
			return this.clean(queryJson);
		},
		clean:function(param){
			var postData = this.getGrid().jqGrid("getGridParam", "postData");
	        for(var a in param){
	           	if(param[a] === ""){
	           		delete postData[a];
	           		delete param[a];
	           	}
	        }
	        return param;
		},
		query:function(){
			this.reloadData();
		},
		add:function(file){
			var o = this;
			showTopWin({
				  type: 2,
				  shade: 0.4,
				  maxmin: true,
				  area: ['770px', '580px'],
				  content: "/lsRent/"+file+"/add.html?uuid="+(new Date().getTime()),
				  zIndex: layer.zIndex, //重点1
				  end:function(result){
					  if(result.success){
						  layer.msg("操作成功！", {icon: 1, time:1600});
						  o.reloadData();
					  }
				  }
			}); 
		},
		update:function(id,file){
			var o = this;
			showTopWin({
				  type: 2,
				  shade: 0.4,
				  maxmin: true,
				  area: ['770px', '580px'],
				  content: "/lsRent/order/edit.html?id="+id,
				  zIndex: layer.zIndex, //重点1
				  end:function(result){
					  if(result.success){
						  layer.msg("操作成功！", {icon: 1, time:1600});
						  o.reloadData();
					  }
				  }
			});  
		},
		del:function(oid){
			var o = this;
			var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        var oo = {
				"orderId":id
			};
			layer.confirm("您确认删除该条数据吗？", {
			  	btn: ["删除","取消"]
			}, function(){
				ajaxRequest(getServUrl("crback/order/delete"), "POST", oo,
				function(r){
					if(r.success){
						layer.msg("操作成功！", {icon: 1, time:1600});
						o.reloadData();
					}else{
						layer.msg(r.text, {icon: 7, time:1600});
						o.reloadData();
					}
				});
			}, function(){});
		},
		rowDel:function(id){
			var o = this;
			if (null == id || id == '' || id.length == 0) {
		           layer.msg("订单主键不能为空", {icon: 7, time: 1500});
		           return;
		    }
	        var oo = {
				"orderId":id
			};
			layer.confirm("您确认删除该条数据吗？", {
			  	btn: ["删除","取消"]
			}, function(){
				ajaxRequest(getServUrl("crback/order/delete"), "POST", oo,
				function(r){
					if(r.success){
						layer.msg("操作成功！", {icon: 1, time:1600});
						o.reloadData();
					}else{
						layer.msg(r.text, {icon: 7, time:1600});
						o.reloadData();
					}
				});
			}, function(){});
		},
		batchDel:function(){
			var o = this;
			var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
			if(ids.length==0){
				layer.msg("请选中要操作的数据行！", {icon: 7, time:500});
				return;
			}
			layer.confirm("您确认删除选中数据吗？", {
			  	btn: ["删除","取消"]
			}, function(){
				ajaxRequest(getServUrl("crback/"+ids), "DELETE",{},
				function(r){
					if(r.success){
						layer.msg("操作成功！", {icon: 1, time:1600});
						o.reloadData();
					}else{
						layer.msg(r.text, {icon: 7, time:1600});
						o.reloadData();
					}
				});
			}, function(){});
		},
		detail:function(idName,file){
			var o = this;
			var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
			showTopWin({
				  type: 2,
				  shade: 0.4,
				  maxmin: true,
				  area: ['770px', '580px'],
				  content: "/lsRent/"+file+"/detail.html?id="+id,
				  zIndex: layer.zIndex //重点1
			});  
		},
		rowDetail:function(id,file){
			var o = this;
			if (null == id || id == '' || id.length == 0) {
		           layer.msg("订单主键不能为空", {icon: 7, time: 1500});
		           return;
		    }
			showTopWin({
				  type: 2,
				  shade: 0.4,
				  maxmin: true,
				  area: ['770px', '580px'],
				  content: "/lsRent/order/detail.html?id="+id,
				  zIndex: layer.zIndex //重点1
			});  
		},
		reloadData:function(){
			this.getGrid().jqGrid("setGridParam", {  
	            datatype:"json",  
	            postData:this.getQueryParamJSON(), //发送数据  
	            page:1  
	        }).trigger("reloadGrid");
		},
		dataBullet:function(file){
	    	var o = this;
			showTopWin({
				  type: 2,
				  shade: 0.4,
				  maxmin: true,
				  area: ['770px', '580px'],
				  content: "/lsRent/"+file+"/dataBullet.html?uuid="+(new Date().getTime()),
				  zIndex: layer.zIndex, //重点1
				  end:function(result){
					  if(result.success){
						  layer.msg("操作成功！", {icon: 1, time:1600});
						  o.reloadData();
					  }
				  }
			});
	    },
		sendMsg: function(file){
	        var o = this;
	        showTopWin({
	              type: 2,
	              shade: 0.4,
	              maxmin: true,
	              area: ['770px', '580px'],
	              content: "/lsRent/"+file+"/sendMsg.html?uuid="+(new Date().getTime()),
	              zIndex: layer.zIndex, //重点1
	              end:function(result){
	                  if(result.success){
	                      layer.msg("操作成功！", {icon: 1, time:1600});
	                      o.reloadData();
	                  }
	              }
	        }); 
	    },
	    pay:function(file){
	        var o = this;
	        showTopWin({
	              type: 2,
	              shade: 0.4,
	              maxmin: true,
	              area: ['770px', '580px'],
	              content: "/lsRent/"+file+"/pay.html?uuid="+(new Date().getTime()),
	              zIndex: layer.zIndex, //重点1
	              end:function(result){
	                  if(result.success){
	                      layer.msg("操作成功！", {icon: 1, time:1600});
	                      o.reloadData();
	                  }
	              }
	        }); 
	    },
	    //修改价格
	    exchangePrice:function(id,file){
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        showTopWin({
	              type: 2,
	              shade: 0.4,
	              maxmin: true,
	              area: ['770px', '580px'],
	              content: "/lsRent/"+file+"/exchangePrices.html?id="+id,
	              zIndex: layer.zIndex, //重点1
	              end:function(result){
	                  if(result.success){
	                      layer.msg("操作成功！", {icon: 1, time:1600});
	                      o.reloadData();
	                  }
	              }
	        }); 
	    },
	  //交付
	    delivery:function(id,file){
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        showTopWin({
	              type: 2,
	              shade: 0.4,
	              maxmin: true,
	              area: ['770px', '580px'],
	              content: "/lsRent/"+file+"/deliveries.html?id="+id,
	              zIndex: layer.zIndex, //重点1
	              end:function(result){
	                  if(result.success){
	                      layer.msg("操作成功！", {icon: 1, time:1600});
	                      o.reloadData();
	                  }
	              }
	        }); 
	    },
	    //换车
	    exchangeCar:function(id,file){
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        showTopWin({
	              type: 2,
	              shade: 0.4,
	              maxmin: true,
	              area: ['770px', '580px'],
	              content: "/lsRent/"+file+"/changeCar.html?id="+id,
	              zIndex: layer.zIndex, //重点1
	              end:function(result){
	                  if(result.success){
	                      layer.msg("操作成功！", {icon: 1, time:1600});
	                      o.reloadData();
	                  }
	              }
	        }); 
	    },
	    //取消
	    cancel:function(id,file){
	    	var o = this;
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        var oo = {
				"orderId":id
			};
			layer.confirm("确定要取消该订单吗？", {
			  	btn: ["确认","取消"]
			}, function(){
				ajaxRequest(getServUrl("crback/order/cancel"), "POST", oo,
				function(r){
					if(r.success){
						layer.msg("操作成功！", {icon: 1, time:1600});
						o.reloadData();
					}else{
						layer.msg(r.text, {icon: 7, time:1600});
						o.reloadData();
					}
				});
			}, function(){});
	    },
	    //待处理
	    wating:function(id,file){
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
			layer.confirm("确定要待处理该订单吗？", {
			  	btn: ["确认","取消"]
			}, function(){
				var oo = {
					"orderId":id
				};
				
				ajaxRequest(getServUrl("crback/order/pending"), "POST",oo,
				function(r){
					console.log("r:",r)
					if(r.success){
						layer.msg("操作成功！", {icon: 1, time:1600});
						o.reloadData();
					}else{
						layer.msg(r.text, {icon: 7, time:1600});
						o.reloadData();
					}
				});
			}, function(){}); 
	    },
	    //结算
	    settlement:function(id,file){
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        showTopWin({
	              type: 2,
	              shade: 0.4,
	              maxmin: true,
	              area: ['770px', '580px'],
	              content: "/lsRent/"+file+"/clearing.html?id="+id,
	              zIndex: layer.zIndex, //重点1
	              end:function(result){
	                  if(result.success){
	                      layer.msg("操作成功！", {icon: 1, time:1600});
	                      o.reloadData();
	                  }
	              }
	        });
	    },
	    //坏账处理
	    dealBad:function(id,file){
	    	var o = this;
	    	var id = $("._grid").jqGrid("getGridParam", "selrow");
	    	console.log("id;",id)
	    	if (null == id || id == '' || id.length == 0) {
	           layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	           return;
	        }
	    	var ids = jQuery("._grid").jqGrid("getGridParam", "selarrrow");
	        if (ids.length > 1) {
	            layer.msg("请选择一个订单！", {icon: 7, time: 1500});
	            return;
	        }
	        var oo = {
					"orderId":id
			};
			layer.confirm("点击坏账处理后，订单将关闭，确定要该操作吗？", {
			  	btn: ["确认","取消"]
			}, function(){
				ajaxRequest(getServUrl("crback/order/badDebt"), "POST", oo,
				function(r){
					if(r.success){
						layer.msg("操作成功！", {icon: 1, time:1600});
						o.reloadData();
					}else{
						layer.msg(r.text, {icon: 7, time:1600});
						o.reloadData();
					}
				});
			}, function(){});
	    },
	};
	showHideColumn = function(chk, name){
		var flag = $(chk).is(':checked');
		if(flag){
			$("._grid").setGridParam().showCol(name);
			resizeTab();
		}else{
			$("._grid").setGridParam().hideCol(name);
			resizeTab();
		}
	};

	resizeTab = function (){
		var width = $(".jqGrid_wrapper").width();
	    $("._grid").setGridWidth(width+15);
	};