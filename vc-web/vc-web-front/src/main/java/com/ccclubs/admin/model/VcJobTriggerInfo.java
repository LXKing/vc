package com.ccclubs.admin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 
 * @author Joel
 */
public class VcJobTriggerInfo implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [job_id]主键
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long jobId;
	/**
	 * [job_code]任务代码
	 */
	
	private   String jobCode;
	/**
	 * [job_name]任务名称
	 */
	
	private   String jobName;
	/**
	 * [job_param]任务参数
	 */
	
	private   String jobParam;
	/**
	 * [job_desc]任务描述
	 */
	
	private   String jobDesc;
	
	//默认构造函数
	public VcJobTriggerInfo(){
	
	}
	
	//主键构造函数
	public VcJobTriggerInfo(Long id){
		this.jobId = id;
	}
	
	//设置非空字段
	public VcJobTriggerInfo setNotNull(Long jobId){
		this.jobId=jobId;
		return this;
	}
	
	
	@Transient
	Map<String, Resolver<VcJobTriggerInfo>> resolvers = new HashMap<String, Resolver<VcJobTriggerInfo>>();
	
	public void registResolver(Resolver<VcJobTriggerInfo> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************主键**********************************/	
	/**
	* 主键 [非空]      
	**/
	public Long getJobId(){
		return this.jobId;
	}
	
	/**
	* 主键 [非空]     
	**/
	public void setJobId(Long jobId){
		this.jobId = jobId;
	}
	/*******************************任务代码**********************************/	
	/**
	* 任务代码 [可空]      
	**/
	public String getJobCode(){
		return this.jobCode;
	}
	
	/**
	* 任务代码 [可空]     
	**/
	public void setJobCode(String jobCode){
		this.jobCode = jobCode;
	}
	/*******************************任务名称**********************************/	
	/**
	* 任务名称 [可空]      
	**/
	public String getJobName(){
		return this.jobName;
	}
	
	/**
	* 任务名称 [可空]     
	**/
	public void setJobName(String jobName){
		this.jobName = jobName;
	}
	/*******************************任务参数**********************************/	
	/**
	* 任务参数 [可空]      
	**/
	public String getJobParam(){
		return this.jobParam;
	}
	
	/**
	* 任务参数 [可空]     
	**/
	public void setJobParam(String jobParam){
		this.jobParam = jobParam;
	}
	/*******************************任务描述**********************************/	
	/**
	* 任务描述 [可空]      
	**/
	public String getJobDesc(){
		return this.jobDesc;
	}
	
	/**
	* 任务描述 [可空]     
	**/
	public void setJobDesc(String jobDesc){
		this.jobDesc = jobDesc;
	}
}