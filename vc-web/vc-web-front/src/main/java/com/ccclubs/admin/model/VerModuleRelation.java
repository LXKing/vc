package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 版本模块关系
 * @author Joel
 */
public class VerModuleRelation implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]版本模块编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [ver_id]版本ID
	 */
	
	private   Integer verId;
	/**
	 * [module_id]模块ID
	 */
	
	private   Integer moduleId;
	/**
	 * [module_val]模块对应值
	 */
	
	private   String moduleVal;
	/**
	 * [is_sup]是否支持0:不支持 1:支持
	 */
	
	private   Short isSup;
	
	//默认构造函数
	public VerModuleRelation(){
	
	}
	
	//主键构造函数
	public VerModuleRelation(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerModuleRelation setNotNull(Integer id, Integer verId, Integer moduleId, Short isSup){
		this.id=id;
		this.verId=verId;
		this.moduleId=moduleId;
		this.isSup=isSup;
		return this;
	}
	
	public Object getIsSupText(){
		return resolve("isSupText");
	}
	public Object getModuleValText(){
		return resolve("moduleValText");
	}
	
	@Transient
	Map<String, Resolver<VerModuleRelation>> resolvers = new HashMap<String, Resolver<VerModuleRelation>>();
	
	public void registResolver(Resolver<VerModuleRelation> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************版本模块编号**********************************/	
	/**
	* 版本模块编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 版本模块编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************版本ID**********************************/	
	/**
	* 版本ID [非空]      
	**/
	public Integer getVerId(){
		return this.verId;
	}
	
	/**
	* 版本ID [非空]     
	**/
	public void setVerId(Integer verId){
		this.verId = verId;
	}
	/*******************************模块ID**********************************/	
	/**
	* 模块ID [非空]      
	**/
	public Integer getModuleId(){
		return this.moduleId;
	}
	
	/**
	* 模块ID [非空]     
	**/
	public void setModuleId(Integer moduleId){
		this.moduleId = moduleId;
	}
	/*******************************模块对应值**********************************/	
	/**
	* 模块对应值 [可空]      
	**/
	public String getModuleVal(){
		return this.moduleVal;
	}
	
	/**
	* 模块对应值 [可空]     
	**/
	public void setModuleVal(String moduleVal){
		this.moduleVal = moduleVal;
	}
	/*******************************是否支持**********************************/	
	/**
	* 是否支持 [非空]      
	**/
	public Short getIsSup(){
		return this.isSup;
	}
	
	/**
	* 是否支持 [非空]     
	**/
	public void setIsSup(Short isSup){
		this.isSup = isSup;
	}
}