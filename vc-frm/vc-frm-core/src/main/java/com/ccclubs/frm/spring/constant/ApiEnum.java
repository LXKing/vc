package com.ccclubs.frm.spring.constant;

/**
 * 约定信息码
 * 正常：100000（六位数表示六六大顺）
 * 系统异常：100001-101000,约定为框架级别、系统级别或者公用级别
 * 接口异常：一个接口错误码范围为增量100，比如getAppKey接口的约定信息码范围，101001-101100
 * @author cheji
 *
 */
public enum ApiEnum {
	SUCCESS(100000, "SUCCESS", "成功"), 
	FAIL(100001, "FAIL", "失败"),
	SIGN_CHECK_FAILED(100002, "sign check failed", "签名校验失败"),
	REQUEST_PARAMS_VALID_FAILED(100003, "request params valid failed", "请求参数校验失败"),
	DUBBOX_SERVICE_ERROR(100004, "dubbo service error", "dubbo服务出错"),
	RUNTIME_ERROR(100005, "runtime error", "运行时异常"),
	SYSTEM_ERROR(100006, "system error", "发生异常，请联系管理员"),
	DATE_FORMAT_ERROR(100007, "date format error", "日期转换出错"),
	SIGN_CHECK_APPID_ISNULL(100008, "appId is null", "appId不能为空"),
	SIGN_CHECK_APPKEY_ISNULL(100009, "appKey is null", "appKey不能为空"),
	DATA_ACCESS_CHECK_FAILED(100010, "data access check failed", "数据权限校验失败"),
	UPDATE_ID_NOT_SET(100011, "update obj can not be null", "更新ID不能为空"),
	API_RATE_LIMIT(100012, "api call too many times in one minute", "一分钟内调用API太多次"),
	VEHICLE_NOT_FOUND(101001, "vehicle not found", "未查询到车辆"),
	TERMINAL_NOT_FOUND(101002, "terminal not found", "未查询到终端"),
	TERMINAL_NOT_TL(101003, "terminal not tongling", "此终端不是通领类型，暂不支持升级"),
	UNKNOWN_TERMINAL(101004, "unknown terminal", "未查询到该终端类型，当前支持终端类型:车厘子,中导,慧翰,通领"),
	VEHICLE_STATE_NOT_FOUND(101005, "vehicle state not found", "未查询到车辆实时状态信息"),
	TERMINAL_BINDING_EXISTS(101006, "terminal has aready bound to vin:{}", "该终端已存在绑定关系，vin码:{}"),
	VEHICLE_BINDING_EXISTS(101007, "vehicle has aready bound to teNo:{}", "该车辆已存在绑定关系，终端序列号:{}"),
	NO_BINDING_EXISTS(101008, "No binding found vin:{} teNo:{}", "车辆与终端不存在绑定关系，VIN:{} 终端序列号:{}"),
	COMMAND_NOT_FOUND(101009, "command not found", "没有对应的指令"),
	COMMAND_TIMEOUT(101010, "command timeout", "终端掉线或通讯异常，请稍候重试"),
	COMMAND_REQUIRED_TERMINAL_MISSING(101011, "command required terminal missing", "csRemote 依据车机号:{} 未找到对应终端信息"),
	TERMINAL_PROTOCOL_NOT_SUPPORT(101012, "terminal protocol not support", "终端设置的协议不在支持范围内"),
	TERMINAL_TOPIC_NOT_SET(101013, "terminal topic not set", "终端下发topic未设置"),
	POWER_MODE_NOT_FOUND(101014, "power mode not found", "省电模式不支持"),
	TERMINAL_VERSION_LATEST(101015, "aready latest version", "已经是最新版本"),
	AIR_CTRL_CIRCULAR_ERROR(101016, "circular mode must in [0,1]", "循环模式0:内循环 1:外循环"),
	AIR_CTRL_PTC_ERROR(101017, "pct mode must in [0,1]", "PTC启停0:OFF 1:ON"),
	AIR_CTRL_COMPRESS_ERROR(101018, "compress mode must in [0,1]", "压缩机启停0:OFF 1:ON"),
	AIR_CTRL_FAN_ERROR(101019, "fan mode must in [0,1,2,3,4]", "风量0:OFF 1:1档 2:2档 3:3档 4:4档"),
	VEHICLE_MODEL_EXISTS(101020, "vehicle model aready exists", "车型均已经注册过"),
	ALL_VEHICLE_VALIDATE_FAILED(101021, "all validate failed", "车辆及终端校验失败"),
	COMMAND_EXECUTE_FAILED(101022, "command execute failed", "指令执行失败"),
	OLD_VERSION_DETECTED(101023, "Old terminal version detected, please update your terminal to {} or higher", "终端版本过低，请升级到{}以上"),
	;
	private int code;
	private String msg;
	private String memo;

	ApiEnum(int code, String msg, String memo) {
		this.code = code;
		this.msg = msg;
		this.memo = memo;
	}

	public int code() {
		return code;
	}

	public String msg() {
		return msg;
	}

	public String memo() {
		return memo;
	}

	public static ApiEnum apiByCode(int code) {

		for (ApiEnum api : ApiEnum.values()) {
			if (api.code() == code) {
				return api;
			}
		}

		return FAIL;
	}
}
