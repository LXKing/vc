package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 软硬件版本管理
 * @author Joel
 */
public class VerSoftHardware implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]版本编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [ver_no]版本号
	 */
	
	private   String verNo;
	/**
	 * [des]版本描述
	 */
	
	private   String des;
	/**
	 * [type]版本类型0:硬件 1:软件
	 */
	
	private   Short type;
	
	//默认构造函数
	public VerSoftHardware(){
	
	}
	
	//主键构造函数
	public VerSoftHardware(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerSoftHardware setNotNull(Integer id, String verNo, Short type){
		this.id=id;
		this.verNo=verNo;
		this.type=type;
		return this;
	}
	
	public Object gettypeText(){
		return resolve("typeText");
	}
	
	@Transient
	Map<String, Resolver<VerSoftHardware>> resolvers = new HashMap<String, Resolver<VerSoftHardware>>();
	
	public void registResolver(Resolver<VerSoftHardware> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************版本编号**********************************/	
	/**
	* 版本编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 版本编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************版本号**********************************/	
	/**
	* 版本号 [非空]      
	**/
	public String getVerNo(){
		return this.verNo;
	}
	
	/**
	* 版本号 [非空]     
	**/
	public void setVerNo(String verNo){
		this.verNo = verNo;
	}
	/*******************************版本描述**********************************/	
	/**
	* 版本描述 [可空]      
	**/
	public String getdes(){
		return this.des;
	}
	
	/**
	* 版本描述 [可空]     
	**/
	public void setdes(String des){
		this.des = des;
	}
	/*******************************版本类型**********************************/	
	/**
	* 版本类型 [非空]      
	**/
	public Short gettype(){
		return this.type;
	}
	
	/**
	* 版本类型 [非空]     
	**/
	public void settype(Short type){
		this.type = type;
	}
}