package com.ccclubs.demo.api;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.demo.inf.DemoCacheInf;
import com.ccclubs.demo.inf.DemoDbInf;
import com.ccclubs.demo.inf.DemoInf;
import com.ccclubs.demo.inf.DemoMongoDbInf;
import com.ccclubs.demo.mod.DbInput;
import com.ccclubs.demo.mod.DbOutput;
import com.ccclubs.demo.mod.DbPageInput;
import com.ccclubs.demo.mod.DbPageOutput;
import com.ccclubs.demo.mod.DemoEntity;
import com.ccclubs.demo.mod.DemoInput;
import com.ccclubs.demo.mod.DemoOutput;
import com.ccclubs.demo.mod.IEVPOPInput;
import com.ccclubs.demo.mod.IEVPOPOutput;
import com.ccclubs.demo.mod.ListInput;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class DemoApi {
    @Value("${name:World!}")
    private String bar;
    @Value("${test.string:abcError!}")
    private String abc;
    @Value("${test.encryp:encryError!}")
    private String abcEncryp;
    @Value("${test.profile.value:profilesError!}")
    private String testProfile;
    @Reference(version="1.0.0")
    private DemoInf inf;
    @Reference(version="1.0.0")
    private DemoDbInf demoDbInf;
    @Reference(version="1.0.0")
    private DemoCacheInf demoCacheInf;
    @Reference(version="1.0.0")
    private DemoMongoDbInf demoMongoDbInf;

    @ApiOperation(value="打印hello接口", notes="读取配置文件信息的hello")
    @RequestMapping("/hello")
    String hello() {
        return "Hello " + bar + "!" + this.abc + "@encryp@"+this.abcEncryp + "@profile@"+testProfile;
    }
    @ApiOperation(value="打印hi例子", notes="正常打印hi的api例子")
    @RequestMapping("/hi")
    String hi() {
        return "Hi ";
    }
    @ApiOperation(value="Dubbox例子", notes="Dubbox调用例子")
    @RequestMapping(path="/hw", method={RequestMethod.POST, RequestMethod.GET})
    String hw() {
    	String s = inf.sayDemo("hw");
        return s;
    }
    @ApiOperation(value="Redis例子", notes="Redis缓存操作例子")
    @RequestMapping(path="/ca", method={RequestMethod.POST, RequestMethod.GET})
    String ca() {
    	String ca = demoCacheInf.sayCacheDemo("ca");
        return ca;
    }
    @ApiOperation(value="异常抛出例子", notes="异常抛出跳转例子")
    @RequestMapping(path="/ex", method={RequestMethod.POST, RequestMethod.GET})
    String ex() {
    	throw new ApiException(1000111, "error");
    }
    @ApiOperation(value="MySQL例子", notes="查询MySQL的例子")
    @RequestMapping(path="/db", method={RequestMethod.POST, RequestMethod.GET})
    String db() {
    	String firstName = demoDbInf.sayDbDemo("fisrtName");
        return firstName;
    }
    
    @ApiOperation(value="MySQL例子3", notes="查询MySQL列表的例子")
    @RequestMapping(path="/dbList", method={RequestMethod.POST, RequestMethod.GET})
    DbOutput db2(DbInput input) {
    	DbOutput out = demoDbInf.dbList(input);
    	return out;
    }
    
    @ApiOperation(value="MySQL例子分页", notes="查询MySQL分页列表的例子")
    @RequestMapping(path="/dbPageList", method={RequestMethod.POST, RequestMethod.GET})
    DbPageOutput dbPage(DbPageInput input) {
    	DbPageOutput out = demoDbInf.dbList(input);
    	return out;
    }
    
    
    @ApiOperation(value="Mongodb例子", notes="查询mongodb的例子")
    @RequestMapping(path="/mdb", method={RequestMethod.POST, RequestMethod.GET})
    String mdb() {
    	DemoEntity demo = new DemoEntity();
		demo.setMyDate(new Date());
		demo.setMyName("my mongodb");
		demo.setMyType(1);
		demo.setMyid(new BigDecimal(2));
    	String myName = demoMongoDbInf.sayMongoDemo(demo);
        return myName;
    }
    @ApiOperation(value="远程控制接口", notes="对远程下达指令")
    //@ApiImplicitParam(name = "input", value = "远程调用入参实体IEVPOPInput", required = true, dataType = "IEVPOPInput")
    @ApiSecurity
    @RequestMapping(path="/remoteIEVPOP", method=RequestMethod.POST)
    ApiMessage<IEVPOPOutput> sss(IEVPOPInput input){
    	IEVPOPOutput out = new IEVPOPOutput();
		return new ApiMessage<IEVPOPOutput>(out);
    }
    @ApiOperation(value="dubbox异常测试接口", notes="dubbox异常测试接口")
    //@ApiImplicitParam(name = "input", value = "远程调用入参实体IEVPOPInput", required = true, dataType = "IEVPOPInput")
    @RequestMapping(path="/dx", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<DemoOutput> dubboxErrorCall(DemoInput input){
    	DemoInput di = new DemoInput();
    	DemoOutput out = inf.dubboxErrorCall(di);
		return new ApiMessage<DemoOutput>(out);
    }
    @ApiSecurity
    @ApiOperation(value="列表形式入参测试接口", notes="列表形式入参测试接口")
    @RequestMapping(path="/listInput", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> listInputTest(ListInput input){
    	return new ApiMessage<String>("");
    }
}
