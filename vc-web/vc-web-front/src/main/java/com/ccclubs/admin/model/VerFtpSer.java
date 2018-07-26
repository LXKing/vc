package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 升级文件服务器管理
 * @author Joel
 */
public class VerFtpSer implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]服务器编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [name]服务器名称
	 */
	
	private   String name;
	/**
	 * [ser_username]登陆用户名
	 */
	
	private   String serUsername;
	/**
	 * [ser_pwd]登陆密码
	 */
	
	private   String serPwd;
	/**
	 * [url]远程地址
	 */
	
	private   String url;
	/**
	 * [port]端口
	 */
	
	private   Integer port;
	/**
	 * [type]服务器类型0:ftp服务器 1:http服务器
	 */
	
	private   Integer type;
	
	//默认构造函数
	public VerFtpSer(){
	
	}
	
	//主键构造函数
	public VerFtpSer(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerFtpSer setNotNull(Integer id, String name, String serUsername, String serPwd, String url, Integer port, Integer type){
		this.id=id;
		this.name=name;
		this.serUsername=serUsername;
		this.serPwd=serPwd;
		this.url=url;
		this.port=port;
		this.type=type;
		return this;
	}
	
	public Object gettypeText(){
		return resolve("typeText");
	}
	
	@Transient
	Map<String, Resolver<VerFtpSer>> resolvers = new HashMap<String, Resolver<VerFtpSer>>();
	
	public void registResolver(Resolver<VerFtpSer> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************服务器编号**********************************/	
	/**
	* 服务器编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 服务器编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************服务器名称**********************************/	
	/**
	* 服务器名称 [非空]      
	**/
	public String getname(){
		return this.name;
	}
	
	/**
	* 服务器名称 [非空]     
	**/
	public void setname(String name){
		this.name = name;
	}
	/*******************************登陆用户名**********************************/	
	/**
	* 登陆用户名 [非空]      
	**/
	public String getSerUsername(){
		return this.serUsername;
	}
	
	/**
	* 登陆用户名 [非空]     
	**/
	public void setSerUsername(String serUsername){
		this.serUsername = serUsername;
	}
	/*******************************登陆密码**********************************/	
	/**
	* 登陆密码 [非空]      
	**/
	public String getSerPwd(){
		return this.serPwd;
	}
	
	/**
	* 登陆密码 [非空]     
	**/
	public void setSerPwd(String serPwd){
		this.serPwd = serPwd;
	}
	/*******************************远程地址**********************************/	
	/**
	* 远程地址 [非空]      
	**/
	public String geturl(){
		return this.url;
	}
	
	/**
	* 远程地址 [非空]     
	**/
	public void seturl(String url){
		this.url = url;
	}
	/*******************************端口**********************************/	
	/**
	* 端口 [非空]      
	**/
	public Integer getport(){
		return this.port;
	}
	
	/**
	* 端口 [非空]     
	**/
	public void setport(Integer port){
		this.port = port;
	}
	/*******************************服务器类型**********************************/	
	/**
	* 服务器类型 [非空]      
	**/
	public Integer gettype(){
		return this.type;
	}
	
	/**
	* 服务器类型 [非空]     
	**/
	public void settype(Integer type){
		this.type = type;
	}
}