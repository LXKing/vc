require.config({
	paths: {
		   "jquery": "jquery.min",
　　　　　　"tpui-core": "tpui-core",
　　　　　　"bootstrap": "bootstrap.min",
　　　　　　"laydate": "plugins/layer/laydate/laydate",
　　　　　　"bootstrap-suggest": "plugins/suggest/bootstrap-suggest.min.js",
　　　　　　"icheck": "plugins/iCheck/icheck.min",
　　　　　　"chosen.jquery": "plugins/chosen/chosen.jquery",
　　　　　　"jquery.validate": "plugins/validate/jquery.validate.min",
　　　　　　"messages_zh": "plugins/validate/messages_zh.min",
　　　　　　"layer": "layer/layer"
　　　},
 	 shim: {
 	　　　　'tpui-core': {
 	　　　　　　deps: ['jquery'],
 	　　　　　　exports: 'jQuery.fn'
 	　　　　}
}});