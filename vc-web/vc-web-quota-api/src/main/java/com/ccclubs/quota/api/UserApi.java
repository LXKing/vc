package com.ccclubs.quota.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.UserInf;
import com.ccclubs.quota.vo.UserInput;
import com.ccclubs.quota.vo.UserOutput;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class UserApi {

	@Reference(version = "1.0.0")
	private UserInf userInf;

	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(path = "/user/login/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<UserOutput> quotaBuilder(UserInput input) {
		UserOutput out = userInf.login(input);
		return new ApiMessage<UserOutput>(out);
	}
}
