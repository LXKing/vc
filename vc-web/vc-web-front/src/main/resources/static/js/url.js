/**
 * 应用服务地址
 */
// var servUrl = "http://118.178.230.105:7004";
const servUrl 	= "http://localhost:9009";
// var servUrl     = "http://localhost:8080"
/**
 * 统一认证地址
 */
const authUrl = "http://localhost:9009";

export const getServUrl =  function (path) {
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

export const toLogin = function () {
    top.window.location.href = authUrl + "/login_v2.html?referer=" + top.window.location.href;
}
