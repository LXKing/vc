package com.ccclubs.usr.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author jianghaiyang
 * @create 2017-08-29
 **/
@RefreshScope
@RestController
public class UsrApi {

    @GetMapping("www")
    public String ccc(){
        return "123";
    }
}
