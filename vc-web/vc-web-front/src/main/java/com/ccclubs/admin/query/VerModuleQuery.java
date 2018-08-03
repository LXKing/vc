package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VerModuleCrieria;

public class VerModuleQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	
	private Short typeEquals;
	private Short[] typeIn;
	private Boolean typeIsNull;
	private Boolean typeIsNotNull;
	
	private Short typeStart;
	
	private Short typeEnd;
	
	private Short typeLess;
	
	private Short typeGreater;
	private String nameLike;
	
	private String nameEquals;
	private String[] nameIn;
	private Boolean nameIsNull;
	private Boolean nameIsNotNull;
	
	private String nameStart;
	
	private String nameEnd;
	
	private String nameLess;
	
	private String nameGreater;
	private String desLike;
	
	private String desEquals;
	private String[] desIn;
	private Boolean desIsNull;
	private Boolean desIsNotNull;
	
	private String desStart;
	
	private String desEnd;
	
	private String desLess;
	
	private String desGreater;
	private String versionLike;
	
	private String versionEquals;
	private String[] versionIn;
	private Boolean versionIsNull;
	private Boolean versionIsNotNull;
	
	private String versionStart;
	
	private String versionEnd;
	
	private String versionLess;
	
	private String versionGreater;
	
	private Long dataTypeEquals;
	private Long[] dataTypeIn;
	private Boolean dataTypeIsNull;
	private Boolean dataTypeIsNotNull;
	
	private Long dataTypeStart;
	
	private Long dataTypeEnd;
	
	private Long dataTypeLess;
	
	private Long dataTypeGreater;
	
	private Long dataItemTypeEquals;
	private Long[] dataItemTypeIn;
	private Boolean dataItemTypeIsNull;
	private Boolean dataItemTypeIsNotNull;
	
	private Long dataItemTypeStart;
	
	private Long dataItemTypeEnd;
	
	private Long dataItemTypeLess;
	
	private Long dataItemTypeGreater;
	private String dataValueLike;
	
	private String dataValueEquals;
	private String[] dataValueIn;
	private Boolean dataValueIsNull;
	private Boolean dataValueIsNotNull;
	
	private String dataValueStart;
	
	private String dataValueEnd;
	
	private String dataValueLess;
	
	private String dataValueGreater;
	
	private Integer sortEquals;
	private Integer[] sortIn;
	private Boolean sortIsNull;
	private Boolean sortIsNotNull;
	
	private Integer sortStart;
	
	private Integer sortEnd;
	
	private Integer sortLess;
	
	private Integer sortGreater;
	private String sidx;
	private String sord;

	public VerModuleQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public VerModuleQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public VerModuleQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public VerModuleQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public VerModuleQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public VerModuleQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public VerModuleQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public VerModuleQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public VerModuleQuery settypeEquals(Short typeEquals){
		this.typeEquals = typeEquals;
		return this;
	}
	public Short gettypeEquals(){
		return this.typeEquals;
	}
	public VerModuleQuery settypeIn(Short[] typeIn){
		this.typeIn = typeIn;
		return this;
	}
	public Short[] gettypeIn(){
		return this.typeIn;
	}
	public VerModuleQuery settypeIsNull(Boolean typeIsNull){
		this.typeIsNull = typeIsNull;
		return this;
	}
	public Boolean gettypeIsNull(){
		return this.typeIsNull;
	}
	public VerModuleQuery settypeIsNotNull(Boolean typeIsNotNull){
		this.typeIsNotNull = typeIsNotNull;
		return this;
	}
	public Boolean gettypeIsNotNull(){
		return this.typeIsNotNull;
	}
	public VerModuleQuery settypeStart(Short typeStart){
		this.typeStart = typeStart;
		return this;
	}
	public Short gettypeStart(){
		return this.typeStart;
	}
	public VerModuleQuery settypeEnd(Short typeEnd){
		this.typeEnd = typeEnd;
		return this;
	}
	public Short gettypeEnd(){
		return this.typeEnd;
	}
	public VerModuleQuery settypeLess(Short typeLess){
		this.typeLess = typeLess;
		return this;
	}
	public Short gettypeLess(){
		return this.typeLess;
	}
	public VerModuleQuery settypeGreater(Short typeGreater){
		this.typeGreater = typeGreater;
		return this;
	}
	public Short gettypeGreater(){
		return this.typeGreater;
	}
	public VerModuleQuery setnameLike(String nameLike){
		this.nameLike = nameLike;
		return this;
	}
	public String getnameLike(){
		return this.nameLike;
	}
	public VerModuleQuery setnameEquals(String nameEquals){
		this.nameEquals = nameEquals;
		return this;
	}
	public String getnameEquals(){
		return this.nameEquals;
	}
	public VerModuleQuery setnameIn(String[] nameIn){
		this.nameIn = nameIn;
		return this;
	}
	public String[] getnameIn(){
		return this.nameIn;
	}
	public VerModuleQuery setnameIsNull(Boolean nameIsNull){
		this.nameIsNull = nameIsNull;
		return this;
	}
	public Boolean getnameIsNull(){
		return this.nameIsNull;
	}
	public VerModuleQuery setnameIsNotNull(Boolean nameIsNotNull){
		this.nameIsNotNull = nameIsNotNull;
		return this;
	}
	public Boolean getnameIsNotNull(){
		return this.nameIsNotNull;
	}
	public VerModuleQuery setnameStart(String nameStart){
		this.nameStart = nameStart;
		return this;
	}
	public String getnameStart(){
		return this.nameStart;
	}
	public VerModuleQuery setnameEnd(String nameEnd){
		this.nameEnd = nameEnd;
		return this;
	}
	public String getnameEnd(){
		return this.nameEnd;
	}
	public VerModuleQuery setnameLess(String nameLess){
		this.nameLess = nameLess;
		return this;
	}
	public String getnameLess(){
		return this.nameLess;
	}
	public VerModuleQuery setnameGreater(String nameGreater){
		this.nameGreater = nameGreater;
		return this;
	}
	public String getnameGreater(){
		return this.nameGreater;
	}
	public VerModuleQuery setdesLike(String desLike){
		this.desLike = desLike;
		return this;
	}
	public String getdesLike(){
		return this.desLike;
	}
	public VerModuleQuery setdesEquals(String desEquals){
		this.desEquals = desEquals;
		return this;
	}
	public String getdesEquals(){
		return this.desEquals;
	}
	public VerModuleQuery setdesIn(String[] desIn){
		this.desIn = desIn;
		return this;
	}
	public String[] getdesIn(){
		return this.desIn;
	}
	public VerModuleQuery setdesIsNull(Boolean desIsNull){
		this.desIsNull = desIsNull;
		return this;
	}
	public Boolean getdesIsNull(){
		return this.desIsNull;
	}
	public VerModuleQuery setdesIsNotNull(Boolean desIsNotNull){
		this.desIsNotNull = desIsNotNull;
		return this;
	}
	public Boolean getdesIsNotNull(){
		return this.desIsNotNull;
	}
	public VerModuleQuery setdesStart(String desStart){
		this.desStart = desStart;
		return this;
	}
	public String getdesStart(){
		return this.desStart;
	}
	public VerModuleQuery setdesEnd(String desEnd){
		this.desEnd = desEnd;
		return this;
	}
	public String getdesEnd(){
		return this.desEnd;
	}
	public VerModuleQuery setdesLess(String desLess){
		this.desLess = desLess;
		return this;
	}
	public String getdesLess(){
		return this.desLess;
	}
	public VerModuleQuery setdesGreater(String desGreater){
		this.desGreater = desGreater;
		return this;
	}
	public String getdesGreater(){
		return this.desGreater;
	}
	public VerModuleQuery setversionLike(String versionLike){
		this.versionLike = versionLike;
		return this;
	}
	public String getversionLike(){
		return this.versionLike;
	}
	public VerModuleQuery setversionEquals(String versionEquals){
		this.versionEquals = versionEquals;
		return this;
	}
	public String getversionEquals(){
		return this.versionEquals;
	}
	public VerModuleQuery setversionIn(String[] versionIn){
		this.versionIn = versionIn;
		return this;
	}
	public String[] getversionIn(){
		return this.versionIn;
	}
	public VerModuleQuery setversionIsNull(Boolean versionIsNull){
		this.versionIsNull = versionIsNull;
		return this;
	}
	public Boolean getversionIsNull(){
		return this.versionIsNull;
	}
	public VerModuleQuery setversionIsNotNull(Boolean versionIsNotNull){
		this.versionIsNotNull = versionIsNotNull;
		return this;
	}
	public Boolean getversionIsNotNull(){
		return this.versionIsNotNull;
	}
	public VerModuleQuery setversionStart(String versionStart){
		this.versionStart = versionStart;
		return this;
	}
	public String getversionStart(){
		return this.versionStart;
	}
	public VerModuleQuery setversionEnd(String versionEnd){
		this.versionEnd = versionEnd;
		return this;
	}
	public String getversionEnd(){
		return this.versionEnd;
	}
	public VerModuleQuery setversionLess(String versionLess){
		this.versionLess = versionLess;
		return this;
	}
	public String getversionLess(){
		return this.versionLess;
	}
	public VerModuleQuery setversionGreater(String versionGreater){
		this.versionGreater = versionGreater;
		return this;
	}
	public String getversionGreater(){
		return this.versionGreater;
	}
	public VerModuleQuery setDataTypeEquals(Long dataTypeEquals){
		this.dataTypeEquals = dataTypeEquals;
		return this;
	}
	public Long getDataTypeEquals(){
		return this.dataTypeEquals;
	}
	public VerModuleQuery setDataTypeIn(Long[] dataTypeIn){
		this.dataTypeIn = dataTypeIn;
		return this;
	}
	public Long[] getDataTypeIn(){
		return this.dataTypeIn;
	}
	public VerModuleQuery setDataTypeIsNull(Boolean dataTypeIsNull){
		this.dataTypeIsNull = dataTypeIsNull;
		return this;
	}
	public Boolean getDataTypeIsNull(){
		return this.dataTypeIsNull;
	}
	public VerModuleQuery setDataTypeIsNotNull(Boolean dataTypeIsNotNull){
		this.dataTypeIsNotNull = dataTypeIsNotNull;
		return this;
	}
	public Boolean getDataTypeIsNotNull(){
		return this.dataTypeIsNotNull;
	}
	public VerModuleQuery setDataTypeStart(Long dataTypeStart){
		this.dataTypeStart = dataTypeStart;
		return this;
	}
	public Long getDataTypeStart(){
		return this.dataTypeStart;
	}
	public VerModuleQuery setDataTypeEnd(Long dataTypeEnd){
		this.dataTypeEnd = dataTypeEnd;
		return this;
	}
	public Long getDataTypeEnd(){
		return this.dataTypeEnd;
	}
	public VerModuleQuery setDataTypeLess(Long dataTypeLess){
		this.dataTypeLess = dataTypeLess;
		return this;
	}
	public Long getDataTypeLess(){
		return this.dataTypeLess;
	}
	public VerModuleQuery setDataTypeGreater(Long dataTypeGreater){
		this.dataTypeGreater = dataTypeGreater;
		return this;
	}
	public Long getDataTypeGreater(){
		return this.dataTypeGreater;
	}
	public VerModuleQuery setDataItemTypeEquals(Long dataItemTypeEquals){
		this.dataItemTypeEquals = dataItemTypeEquals;
		return this;
	}
	public Long getDataItemTypeEquals(){
		return this.dataItemTypeEquals;
	}
	public VerModuleQuery setDataItemTypeIn(Long[] dataItemTypeIn){
		this.dataItemTypeIn = dataItemTypeIn;
		return this;
	}
	public Long[] getDataItemTypeIn(){
		return this.dataItemTypeIn;
	}
	public VerModuleQuery setDataItemTypeIsNull(Boolean dataItemTypeIsNull){
		this.dataItemTypeIsNull = dataItemTypeIsNull;
		return this;
	}
	public Boolean getDataItemTypeIsNull(){
		return this.dataItemTypeIsNull;
	}
	public VerModuleQuery setDataItemTypeIsNotNull(Boolean dataItemTypeIsNotNull){
		this.dataItemTypeIsNotNull = dataItemTypeIsNotNull;
		return this;
	}
	public Boolean getDataItemTypeIsNotNull(){
		return this.dataItemTypeIsNotNull;
	}
	public VerModuleQuery setDataItemTypeStart(Long dataItemTypeStart){
		this.dataItemTypeStart = dataItemTypeStart;
		return this;
	}
	public Long getDataItemTypeStart(){
		return this.dataItemTypeStart;
	}
	public VerModuleQuery setDataItemTypeEnd(Long dataItemTypeEnd){
		this.dataItemTypeEnd = dataItemTypeEnd;
		return this;
	}
	public Long getDataItemTypeEnd(){
		return this.dataItemTypeEnd;
	}
	public VerModuleQuery setDataItemTypeLess(Long dataItemTypeLess){
		this.dataItemTypeLess = dataItemTypeLess;
		return this;
	}
	public Long getDataItemTypeLess(){
		return this.dataItemTypeLess;
	}
	public VerModuleQuery setDataItemTypeGreater(Long dataItemTypeGreater){
		this.dataItemTypeGreater = dataItemTypeGreater;
		return this;
	}
	public Long getDataItemTypeGreater(){
		return this.dataItemTypeGreater;
	}
	public VerModuleQuery setDataValueLike(String dataValueLike){
		this.dataValueLike = dataValueLike;
		return this;
	}
	public String getDataValueLike(){
		return this.dataValueLike;
	}
	public VerModuleQuery setDataValueEquals(String dataValueEquals){
		this.dataValueEquals = dataValueEquals;
		return this;
	}
	public String getDataValueEquals(){
		return this.dataValueEquals;
	}
	public VerModuleQuery setDataValueIn(String[] dataValueIn){
		this.dataValueIn = dataValueIn;
		return this;
	}
	public String[] getDataValueIn(){
		return this.dataValueIn;
	}
	public VerModuleQuery setDataValueIsNull(Boolean dataValueIsNull){
		this.dataValueIsNull = dataValueIsNull;
		return this;
	}
	public Boolean getDataValueIsNull(){
		return this.dataValueIsNull;
	}
	public VerModuleQuery setDataValueIsNotNull(Boolean dataValueIsNotNull){
		this.dataValueIsNotNull = dataValueIsNotNull;
		return this;
	}
	public Boolean getDataValueIsNotNull(){
		return this.dataValueIsNotNull;
	}
	public VerModuleQuery setDataValueStart(String dataValueStart){
		this.dataValueStart = dataValueStart;
		return this;
	}
	public String getDataValueStart(){
		return this.dataValueStart;
	}
	public VerModuleQuery setDataValueEnd(String dataValueEnd){
		this.dataValueEnd = dataValueEnd;
		return this;
	}
	public String getDataValueEnd(){
		return this.dataValueEnd;
	}
	public VerModuleQuery setDataValueLess(String dataValueLess){
		this.dataValueLess = dataValueLess;
		return this;
	}
	public String getDataValueLess(){
		return this.dataValueLess;
	}
	public VerModuleQuery setDataValueGreater(String dataValueGreater){
		this.dataValueGreater = dataValueGreater;
		return this;
	}
	public String getDataValueGreater(){
		return this.dataValueGreater;
	}
	public VerModuleQuery setsortEquals(Integer sortEquals){
		this.sortEquals = sortEquals;
		return this;
	}
	public Integer getsortEquals(){
		return this.sortEquals;
	}
	public VerModuleQuery setsortIn(Integer[] sortIn){
		this.sortIn = sortIn;
		return this;
	}
	public Integer[] getsortIn(){
		return this.sortIn;
	}
	public VerModuleQuery setsortIsNull(Boolean sortIsNull){
		this.sortIsNull = sortIsNull;
		return this;
	}
	public Boolean getsortIsNull(){
		return this.sortIsNull;
	}
	public VerModuleQuery setsortIsNotNull(Boolean sortIsNotNull){
		this.sortIsNotNull = sortIsNotNull;
		return this;
	}
	public Boolean getsortIsNotNull(){
		return this.sortIsNotNull;
	}
	public VerModuleQuery setsortStart(Integer sortStart){
		this.sortStart = sortStart;
		return this;
	}
	public Integer getsortStart(){
		return this.sortStart;
	}
	public VerModuleQuery setsortEnd(Integer sortEnd){
		this.sortEnd = sortEnd;
		return this;
	}
	public Integer getsortEnd(){
		return this.sortEnd;
	}
	public VerModuleQuery setsortLess(Integer sortLess){
		this.sortLess = sortLess;
		return this;
	}
	public Integer getsortLess(){
		return this.sortLess;
	}
	public VerModuleQuery setsortGreater(Integer sortGreater){
		this.sortGreater = sortGreater;
		return this;
	}
	public Integer getsortGreater(){
		return this.sortGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("id")){
			return "id";
		}
		else if(this.sidx.equals("type")){
			return "type";
		}
		else if(this.sidx.equals("name")){
			return "name";
		}
		else if(this.sidx.equals("des")){
			return "des";
		}
		else if(this.sidx.equals("version")){
			return "version";
		}
		else if(this.sidx.equals("dataType")){
			return "data_type";
		}
		else if(this.sidx.equals("dataItemType")){
			return "data_item_type";
		}
		else if(this.sidx.equals("dataValue")){
			return "data_value";
		}
		else if(this.sidx.equals("sort")){
			return "sort";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public VerModuleCrieria getCrieria(){
		VerModuleCrieria q = new VerModuleCrieria();
		VerModuleCrieria.Criteria c = q.createCriteria();
		
		if(this.getidEquals()!=null){
			c.andidEqualTo(this.getidEquals());
		}else if(this.getidIsNull()!=null && this.getidIsNull()){
			c.andidIsNull();
		}else if(this.getidIsNotNull()!=null && this.getidIsNotNull()){
			c.andidIsNotNull();
		}else if(this.getidIn()!=null){
			c.andidIn(java.util.Arrays.asList(this.getidIn()));
		}else if(this.getidStart()!=null && this.getidEnd()!=null){
			c.andidBetween(this.getidStart(), this.getidEnd());
		}else if(this.getidGreater()!=null){
			c.andidGreaterThan(this.getidGreater());
		}else if(this.getidLess()!=null){
			c.andidLessThan(this.getidLess());
		}
		if(this.gettypeEquals()!=null){
			c.andtypeEqualTo(this.gettypeEquals());
		}else if(this.gettypeIsNull()!=null && this.gettypeIsNull()){
			c.andtypeIsNull();
		}else if(this.gettypeIsNotNull()!=null && this.gettypeIsNotNull()){
			c.andtypeIsNotNull();
		}else if(this.gettypeIn()!=null){
			c.andtypeIn(java.util.Arrays.asList(this.gettypeIn()));
		}else if(this.gettypeStart()!=null && this.gettypeEnd()!=null){
			c.andtypeBetween(this.gettypeStart(), this.gettypeEnd());
		}else if(this.gettypeGreater()!=null){
			c.andtypeGreaterThan(this.gettypeGreater());
		}else if(this.gettypeLess()!=null){
			c.andtypeLessThan(this.gettypeLess());
		}
		if(this.getnameEquals()!=null){
			c.andnameEqualTo(this.getnameEquals());
		}else if(this.getnameIsNull()!=null && this.getnameIsNull()){
			c.andnameIsNull();
		}else if(this.getnameIsNotNull()!=null && this.getnameIsNotNull()){
			c.andnameIsNotNull();
		}else if(this.getnameLike()!=null){
			c.andnameLike(this.getnameLike());
		}else if(this.getnameIn()!=null){
			c.andnameIn(java.util.Arrays.asList(this.getnameIn()));
		}else if(this.getnameStart()!=null && this.getnameEnd()!=null){
			c.andnameBetween(this.getnameStart(), this.getnameEnd());
		}else if(this.getnameGreater()!=null){
			c.andnameGreaterThan(this.getnameGreater());
		}else if(this.getnameLess()!=null){
			c.andnameLessThan(this.getnameLess());
		}
		if(this.getdesEquals()!=null){
			c.anddesEqualTo(this.getdesEquals());
		}else if(this.getdesIsNull()!=null && this.getdesIsNull()){
			c.anddesIsNull();
		}else if(this.getdesIsNotNull()!=null && this.getdesIsNotNull()){
			c.anddesIsNotNull();
		}else if(this.getdesLike()!=null){
			c.anddesLike(this.getdesLike());
		}else if(this.getdesIn()!=null){
			c.anddesIn(java.util.Arrays.asList(this.getdesIn()));
		}else if(this.getdesStart()!=null && this.getdesEnd()!=null){
			c.anddesBetween(this.getdesStart(), this.getdesEnd());
		}else if(this.getdesGreater()!=null){
			c.anddesGreaterThan(this.getdesGreater());
		}else if(this.getdesLess()!=null){
			c.anddesLessThan(this.getdesLess());
		}
		if(this.getversionEquals()!=null){
			c.andversionEqualTo(this.getversionEquals());
		}else if(this.getversionIsNull()!=null && this.getversionIsNull()){
			c.andversionIsNull();
		}else if(this.getversionIsNotNull()!=null && this.getversionIsNotNull()){
			c.andversionIsNotNull();
		}else if(this.getversionLike()!=null){
			c.andversionLike(this.getversionLike());
		}else if(this.getversionIn()!=null){
			c.andversionIn(java.util.Arrays.asList(this.getversionIn()));
		}else if(this.getversionStart()!=null && this.getversionEnd()!=null){
			c.andversionBetween(this.getversionStart(), this.getversionEnd());
		}else if(this.getversionGreater()!=null){
			c.andversionGreaterThan(this.getversionGreater());
		}else if(this.getversionLess()!=null){
			c.andversionLessThan(this.getversionLess());
		}
		if(this.getDataTypeEquals()!=null){
			c.anddataTypeEqualTo(this.getDataTypeEquals());
		}else if(this.getDataTypeIsNull()!=null && this.getDataTypeIsNull()){
			c.anddataTypeIsNull();
		}else if(this.getDataTypeIsNotNull()!=null && this.getDataTypeIsNotNull()){
			c.anddataTypeIsNotNull();
		}else if(this.getDataTypeIn()!=null){
			c.anddataTypeIn(java.util.Arrays.asList(this.getDataTypeIn()));
		}else if(this.getDataTypeStart()!=null && this.getDataTypeEnd()!=null){
			c.anddataTypeBetween(this.getDataTypeStart(), this.getDataTypeEnd());
		}else if(this.getDataTypeGreater()!=null){
			c.anddataTypeGreaterThan(this.getDataTypeGreater());
		}else if(this.getDataTypeLess()!=null){
			c.anddataTypeLessThan(this.getDataTypeLess());
		}
		if(this.getDataItemTypeEquals()!=null){
			c.anddataItemTypeEqualTo(this.getDataItemTypeEquals());
		}else if(this.getDataItemTypeIsNull()!=null && this.getDataItemTypeIsNull()){
			c.anddataItemTypeIsNull();
		}else if(this.getDataItemTypeIsNotNull()!=null && this.getDataItemTypeIsNotNull()){
			c.anddataItemTypeIsNotNull();
		}else if(this.getDataItemTypeIn()!=null){
			c.anddataItemTypeIn(java.util.Arrays.asList(this.getDataItemTypeIn()));
		}else if(this.getDataItemTypeStart()!=null && this.getDataItemTypeEnd()!=null){
			c.anddataItemTypeBetween(this.getDataItemTypeStart(), this.getDataItemTypeEnd());
		}else if(this.getDataItemTypeGreater()!=null){
			c.anddataItemTypeGreaterThan(this.getDataItemTypeGreater());
		}else if(this.getDataItemTypeLess()!=null){
			c.anddataItemTypeLessThan(this.getDataItemTypeLess());
		}
		if(this.getDataValueEquals()!=null){
			c.anddataValueEqualTo(this.getDataValueEquals());
		}else if(this.getDataValueIsNull()!=null && this.getDataValueIsNull()){
			c.anddataValueIsNull();
		}else if(this.getDataValueIsNotNull()!=null && this.getDataValueIsNotNull()){
			c.anddataValueIsNotNull();
		}else if(this.getDataValueLike()!=null){
			c.anddataValueLike(this.getDataValueLike());
		}else if(this.getDataValueIn()!=null){
			c.anddataValueIn(java.util.Arrays.asList(this.getDataValueIn()));
		}else if(this.getDataValueStart()!=null && this.getDataValueEnd()!=null){
			c.anddataValueBetween(this.getDataValueStart(), this.getDataValueEnd());
		}else if(this.getDataValueGreater()!=null){
			c.anddataValueGreaterThan(this.getDataValueGreater());
		}else if(this.getDataValueLess()!=null){
			c.anddataValueLessThan(this.getDataValueLess());
		}
		if(this.getsortEquals()!=null){
			c.andsortEqualTo(this.getsortEquals());
		}else if(this.getsortIsNull()!=null && this.getsortIsNull()){
			c.andsortIsNull();
		}else if(this.getsortIsNotNull()!=null && this.getsortIsNotNull()){
			c.andsortIsNotNull();
		}else if(this.getsortIn()!=null){
			c.andsortIn(java.util.Arrays.asList(this.getsortIn()));
		}else if(this.getsortStart()!=null && this.getsortEnd()!=null){
			c.andsortBetween(this.getsortStart(), this.getsortEnd());
		}else if(this.getsortGreater()!=null){
			c.andsortGreaterThan(this.getsortGreater());
		}else if(this.getsortLess()!=null){
			c.andsortLessThan(this.getsortLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
