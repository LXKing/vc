package com.ccclubs.quota.inf;

import com.ccclubs.quota.vo.UserInput;
import com.ccclubs.quota.vo.UserOutput;

public interface UserInf {
	UserOutput login(UserInput input);
}
