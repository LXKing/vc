package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 版本模块管理
 * @author Joel
 */
public class VerModule implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]模块编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [type]模块类型0:硬件模块 1:软件模块
	 */
	
	private   Short type;
	/**
	 * [name]模板名称或者数据项
	 */
	
	private   String name;
	/**
	 * [des]模块描述
	 */
	
	private   String des;
	/**
	 * [version]模块版本
	 */
	
	private   String version;
	/**
	 * [data_type]数据类别
	 */
	
	private   Long dataType;
	/**
	 * [data_item_type]数据项类别
	 */
	
	private   Long dataItemType;
	/**
	 * [data_value]数据项值描述
	 */
	
	private   String dataValue;
	/**
	 * [sort]排序
	 */
	
	private   Integer sort;
	
	//默认构造函数
	public VerModule(){
	
	}
	
	//主键构造函数
	public VerModule(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerModule setNotNull(Integer id, Short type, String name){
		this.id=id;
		this.type=type;
		this.name=name;
		return this;
	}
	
	public Object gettypeText(){
		return resolve("typeText");
	}
	public Object getDataTypeText(){
		return resolve("dataTypeText");
	}
	public Object getDataItemTypeText(){
		return resolve("dataItemTypeText");
	}
	
	@Transient
	Map<String, Resolver<VerModule>> resolvers = new HashMap<String, Resolver<VerModule>>();
	
	public void registResolver(Resolver<VerModule> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************模块编号**********************************/	
	/**
	* 模块编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 模块编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************模块类型**********************************/	
	/**
	* 模块类型 [非空]      
	**/
	public Short gettype(){
		return this.type;
	}
	
	/**
	* 模块类型 [非空]     
	**/
	public void settype(Short type){
		this.type = type;
	}
	/*******************************模板名称或者数据项**********************************/	
	/**
	* 模板名称或者数据项 [非空]      
	**/
	public String getname(){
		return this.name;
	}
	
	/**
	* 模板名称或者数据项 [非空]     
	**/
	public void setname(String name){
		this.name = name;
	}
	/*******************************模块描述**********************************/	
	/**
	* 模块描述 [可空]      
	**/
	public String getdes(){
		return this.des;
	}
	
	/**
	* 模块描述 [可空]     
	**/
	public void setdes(String des){
		this.des = des;
	}
	/*******************************模块版本**********************************/	
	/**
	* 模块版本 [可空]      
	**/
	public String getversion(){
		return this.version;
	}
	
	/**
	* 模块版本 [可空]     
	**/
	public void setversion(String version){
		this.version = version;
	}
	/*******************************数据类别**********************************/	
	/**
	* 数据类别 [可空]      
	**/
	public Long getDataType(){
		return this.dataType;
	}
	
	/**
	* 数据类别 [可空]     
	**/
	public void setDataType(Long dataType){
		this.dataType = dataType;
	}
	/*******************************数据项类别**********************************/	
	/**
	* 数据项类别 [可空]      
	**/
	public Long getDataItemType(){
		return this.dataItemType;
	}
	
	/**
	* 数据项类别 [可空]     
	**/
	public void setDataItemType(Long dataItemType){
		this.dataItemType = dataItemType;
	}
	/*******************************数据项值描述**********************************/	
	/**
	* 数据项值描述 [可空]      
	**/
	public String getDataValue(){
		return this.dataValue;
	}
	
	/**
	* 数据项值描述 [可空]     
	**/
	public void setDataValue(String dataValue){
		this.dataValue = dataValue;
	}
	/*******************************排序**********************************/	
	/**
	* 排序 [可空]      
	**/
	public Integer getsort(){
		return this.sort;
	}
	
	/**
	* 排序 [可空]     
	**/
	public void setsort(Integer sort){
		this.sort = sort;
	}
}