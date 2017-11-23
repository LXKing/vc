package com.ccclubs.manage.api;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.jwt.AuthenticationService;
import com.ccclubs.manage.model.JwtManage;
import com.ccclubs.manage.dto.EvLoginInput;
import com.ccclubs.manage.dto.EvLoginOutput;
import com.ccclubs.manage.inf.CsManageInf;
import com.ccclubs.manage.model.CsManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/20
 * Time: 20:07
 * Email:fengjun@ccclubs.com
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/vc")
public class PermissionsApi {




    @Autowired
    private CsManageInf csManageService;
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(path = "/login/v1", method={RequestMethod.POST})
    public ApiMessage<EvLoginOutput> loginSystem(@RequestBody EvLoginInput evLoginInput){
        CsManage csManage=null;
        JwtManage jwtManage=null;
        String token=null;
        ApiMessage<EvLoginOutput> result;
        EvLoginOutput evLoginOutput=new EvLoginOutput();
        csManage=csManageService.checkUserPassword(evLoginInput.getUsername(),evLoginInput.getPassword());
        if (null !=csManage){
            jwtManage=new JwtManage(csManage.getCsmId().longValue(),
                    csManage.getCsmUsername(),
                    true,
                    csManage.getCsmUpdateTime(),
                    csManage.getCsmName(),
                    csManage.getCsmId());
            token=authenticationService.createAuthenticationToken(jwtManage);
            result=new ApiMessage<EvLoginOutput>(ApiEnum.SUCCESS.code(),"登录成功。");
            evLoginOutput.setToken(token);
            result.setData(evLoginOutput);
            return result;
        }
        result=new ApiMessage<EvLoginOutput>(ApiEnum.FAIL.code(),"用户名或密码错误。");
        return result;
    }




    @RequestMapping(path = "/logout/v1", method={RequestMethod.POST})
    public ApiMessage<String> logoutSystem(@RequestBody EvLoginInput evLoginInput){
        boolean done=false;
        ApiMessage<String> result;
        done=authenticationService.deleteAuthenticationToken(evLoginInput.getUsername());

        if (done){
            result=new ApiMessage<>(ApiEnum.SUCCESS);
            return result;
        }
        result=new ApiMessage<>(ApiEnum.FAIL);
        result.setData("登出状态未知，请重新登陆。");
        return result;
    }



    @RequestMapping(path = "/refresh/v1", method={RequestMethod.POST})
    public ApiMessage<String> refreshSystem(HttpServletRequest request,@RequestBody EvLoginInput evLoginInput){
        String token= authenticationService.refreshAndGetAuthenticationToken(request);

        if (token!=null){
            ApiMessage<String> result=new ApiMessage<String>(ApiEnum.SUCCESS);
            result.setData(token);
            return result;
        }
        return new ApiMessage<>(ApiEnum.FAIL);
    }


}
