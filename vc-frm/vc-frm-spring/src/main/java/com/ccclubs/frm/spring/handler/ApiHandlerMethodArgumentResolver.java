package com.ccclubs.frm.spring.handler;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.frm.spring.prop.AppIdAndKeyProp;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;

@Service
public class ApiHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String API_SIGN = "sign";              // 请求体签名
	private static final String API_VERSION = "v";              // API接口版本
	private static final String APP_ID = "appId";               // 访问ID
	private static final String API_NAME = "apiName";           // 访问接口名称

	@Resource
	private AppIdAndKeyProp appIdAndKeyProp;

	public ApiHandlerMethodArgumentResolver(AppIdAndKeyProp appIdAndKeyProp) {
		this.appIdAndKeyProp = appIdAndKeyProp;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		ApiSecurity as = parameter.getMethodAnnotation(ApiSecurity.class);
		return null != as;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
								  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		ApiSecurity annotation = parameter.getMethodAnnotation(ApiSecurity.class);
		String sign = request.getHeader(API_SIGN);
		String v = request.getHeader(API_VERSION);
		String appId = request.getHeader(APP_ID);
		String apiName = request.getHeader(API_NAME);

		logger.debug("[request] sign:{}, v:{}, apiId:{}, apiName:{}", sign, v, appId, apiName);
		InputStream is = request.getInputStream();
		String jsonContents = IOUtils.toString(is, "UTF-8");
		logger.debug("s:{}", jsonContents);
		IOUtils.closeQuietly(is);

		/*校验header*/
		String value = DigestUtils.md5Hex(jsonContents);
		if (StringUtils.isEmpty(appId)) {
			throw new ApiException(ApiEnum.SIGN_CHECK_APPID_ISNULL);
		}
		String appKey = appIdAndKeyProp.getSecurity().get(appId);
		if (StringUtils.isEmpty(appKey)) {
			throw new ApiException(ApiEnum.SIGN_CHECK_APPKEY_ISNULL);
		}

		String calc_sign = HmacUtils.hmacSha1Hex(appKey, value);
		if (StringUtils.isEmpty(sign) || StringUtils.isEmpty(calc_sign) || !calc_sign.equals(sign)) {
			throw new ApiException(ApiEnum.SIGN_CHECK_FAILED);
		}

		Class<?> cls = parameter.getParameterType();
		logger.debug("cls:{}", cls);
		ObjectReader objectReader = Jackson2ObjectMapperBuilder.json().build().reader();

		// 构建转换泛型
		JavaType secondJavaType = objectReader.getTypeFactory().constructType(cls);
		Object obj = objectReader.forType(secondJavaType).readValue(jsonContents);
		final WebDataBinder binder = binderFactory.createBinder(webRequest, obj, cls.getName());
		binder.validate(new Object[]{obj});
		BindingResult result = binder.getBindingResult();

		//检验参数条件
		List<ObjectError> el = result.getAllErrors();
		if (null != el && el.size() > 0) {
			FieldError fe;
			StringBuilder sb = new StringBuilder();
			for (ObjectError oe : el) {
				if (oe instanceof FieldError) {
					fe = (FieldError) oe;
					logger.debug("{},{},{}", fe.getField(), fe.getObjectName(), fe.getDefaultMessage());
					sb.append("字段:").append(fe.getField()).append(", 错误信息：").append(fe.getDefaultMessage());
				} else {
					logger.debug("{},{}", oe.getObjectName(), oe.getDefaultMessage());
					sb.append("对象名称：").append(oe.getObjectName()).append(", 错误信息：").append(oe.getDefaultMessage());
				}
				sb.append(";");
			}
			throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), sb.toString());
		}

		return obj;
	}

}
