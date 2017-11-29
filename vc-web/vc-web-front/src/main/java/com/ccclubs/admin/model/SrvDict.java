package com.ccclubs.admin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import com.ccclubs.admin.vo.Resolver;

/**
 * 字典信息管理
 * @author Joel
 */
public class SrvDict implements java.io.Serializable
{
	private static final long serialVersionUID =         1l;
	/**
	 * [id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [value]数据值
	 */
	
	private   String value;
	/**
	 * [label]标签名
	 */
	
	private   String label;
	/**
	 * [type]类型
	 */
	
	private   String type;
	/**
	 * [description]描述
	 */
	
	private   String description;
	/**
	 * [sort]排序
	 */
	
	private   Integer sort;
	/**
	 * [create_by]创建者
	 */
	
	private   String createBy;
	/**
	 * [create_date]创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date createDate;
	/**
	 * [update_by]更新者
	 */
	
	private   String updateBy;
	/**
	 * [update_date]更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date updateDate;
	/**
	 * [remarks]备注信息
	 */
	
	private   String remarks;
	/**
	 * [del_flag]删除标记0:正常 1:删除
	 */
	
	private   String delFlag;
	
	//默认构造函数
	public SrvDict(){
	
	}
	
	//主键构造函数
	public SrvDict(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public SrvDict setNotNull(Integer id,String value,String label,String type,String description,Integer sort,String createBy,Date createDate,String updateBy,Date updateDate,String delFlag){
		this.id=id;
		this.value=value;
		this.label=label;
		this.type=type;
		this.description=description;
		this.sort=sort;
		this.createBy=createBy;
		this.createDate=createDate;
		this.updateBy=updateBy;
		this.updateDate=updateDate;
		this.delFlag=delFlag;
		return this;
	}
	
	public Object getDelFlagText(){
		return resolve("delFlagText");
	}
	
	@Transient
	Map<String, Resolver<SrvDict>> resolvers = new HashMap<String, Resolver<SrvDict>>();
	
	public void registResolver(Resolver<SrvDict> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************编号**********************************/	
	/**
	* 编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************数据值**********************************/	
	/**
	* 数据值 [非空]      
	**/
	public String getvalue(){
		return this.value;
	}
	
	/**
	* 数据值 [非空]     
	**/
	public void setvalue(String value){
		this.value = value;
	}
	/*******************************标签名**********************************/	
	/**
	* 标签名 [非空]      
	**/
	public String getlabel(){
		return this.label;
	}
	
	/**
	* 标签名 [非空]     
	**/
	public void setlabel(String label){
		this.label = label;
	}
	/*******************************类型**********************************/	
	/**
	* 类型 [非空]      
	**/
	public String gettype(){
		return this.type;
	}
	
	/**
	* 类型 [非空]     
	**/
	public void settype(String type){
		this.type = type;
	}
	/*******************************描述**********************************/	
	/**
	* 描述 [非空]      
	**/
	public String getdescription(){
		return this.description;
	}
	
	/**
	* 描述 [非空]     
	**/
	public void setdescription(String description){
		this.description = description;
	}
	/*******************************排序**********************************/	
	/**
	* 排序 [非空]      
	**/
	public Integer getsort(){
		return this.sort;
	}
	
	/**
	* 排序 [非空]     
	**/
	public void setsort(Integer sort){
		this.sort = sort;
	}
	/*******************************创建者**********************************/	
	/**
	* 创建者 [非空]      
	**/
	public String getCreateBy(){
		return this.createBy;
	}
	
	/**
	* 创建者 [非空]     
	**/
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/*******************************创建时间**********************************/	
	/**
	* 创建时间 [非空]      
	**/
	public Date getCreateDate(){
		return this.createDate;
	}
	
	/**
	* 创建时间 [非空]     
	**/
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/*******************************更新者**********************************/	
	/**
	* 更新者 [非空]      
	**/
	public String getUpdateBy(){
		return this.updateBy;
	}
	
	/**
	* 更新者 [非空]     
	**/
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/*******************************更新时间**********************************/	
	/**
	* 更新时间 [非空]      
	**/
	public Date getUpdateDate(){
		return this.updateDate;
	}
	
	/**
	* 更新时间 [非空]     
	**/
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/*******************************备注信息**********************************/	
	/**
	* 备注信息 [可空]      
	**/
	public String getremarks(){
		return this.remarks;
	}
	
	/**
	* 备注信息 [可空]     
	**/
	public void setremarks(String remarks){
		this.remarks = remarks;
	}
	/*******************************删除标记**********************************/	
	/**
	* 删除标记 [非空]      
	**/
	public String getDelFlag(){
		return this.delFlag;
	}
	
	/**
	* 删除标记 [非空]     
	**/
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
}