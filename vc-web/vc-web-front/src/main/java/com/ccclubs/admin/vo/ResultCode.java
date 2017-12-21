package com.ccclubs.admin.vo;
/*
 * 相应结果枚举类
 */
public enum ResultCode {
	OK(200, "OK"),
	USER_NAME_IS_EMPTY(20001, "输入账号为空"),
	PASSWORD_IS_EMPTY(20002, "密码输入为空"),
	INVALID_USERNAME(20003, "对不起,账号已经失效"),
	USER_DOES_NOT_EXIST(20004, "对不起,账号不存在"),
	INVALID_PASSWORD(20005, "密码错误"),
	INVALID_TOKEN(20006,"登录失效,请重新登录"),
	USER_IS_UNAVAILABLE(20007,"对不起,用户不可用"),
	SYSTEM_ERR(9999, "系统错误"),
	PERMISSION_DENIED(20008, "用户未授权"),

	INVALID_CLIENTID(30003, "Invalid clientid"),
	INVALID_CAPTCHA(30005, "Invalid captcha or captcha overdue"),
	INVALID_OLD_PASSWORD(20009, "旧密码输入错误"),
	PARAMETER_VERIFICATION_ERROR(20010,"参数校验错误。"),
	PASSWORD_VALID_INFO(30000,"密码格式错误，必须是8到16位字符，不能为纯数字或纯字母"),
    PASSWORD_UPDATE_SECCESS(30001,"密码修改成功");


	private int errorCode;
	private String errorMsg;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	private ResultCode(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
}
