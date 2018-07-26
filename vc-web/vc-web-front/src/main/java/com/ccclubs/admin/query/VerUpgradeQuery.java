package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VerUpgradeCrieria;

public class VerUpgradeQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	
	private Integer softVerIdEquals;
	private Integer[] softVerIdIn;
	private Boolean softVerIdIsNull;
	private Boolean softVerIdIsNotNull;
	
	private Integer softVerIdStart;
	
	private Integer softVerIdEnd;
	
	private Integer softVerIdLess;
	
	private Integer softVerIdGreater;
	
	private Integer hardVerIdEquals;
	private Integer[] hardVerIdIn;
	private Boolean hardVerIdIsNull;
	private Boolean hardVerIdIsNotNull;
	
	private Integer hardVerIdStart;
	
	private Integer hardVerIdEnd;
	
	private Integer hardVerIdLess;
	
	private Integer hardVerIdGreater;
	
	private Integer modelIdEquals;
	private Integer[] modelIdIn;
	private Boolean modelIdIsNull;
	private Boolean modelIdIsNotNull;
	
	private Integer modelIdStart;
	
	private Integer modelIdEnd;
	
	private Integer modelIdLess;
	
	private Integer modelIdGreater;
	
	private Integer telTypeEquals;
	private Integer[] telTypeIn;
	private Boolean telTypeIsNull;
	private Boolean telTypeIsNotNull;
	
	private Integer telTypeStart;
	
	private Integer telTypeEnd;
	
	private Integer telTypeLess;
	
	private Integer telTypeGreater;
	private String innerVerLike;
	
	private String innerVerEquals;
	private String[] innerVerIn;
	private Boolean innerVerIsNull;
	private Boolean innerVerIsNotNull;
	
	private String innerVerStart;
	
	private String innerVerEnd;
	
	private String innerVerLess;
	
	private String innerVerGreater;
	
	private Short isOpenEquals;
	private Short[] isOpenIn;
	private Boolean isOpenIsNull;
	private Boolean isOpenIsNotNull;
	
	private Short isOpenStart;
	
	private Short isOpenEnd;
	
	private Short isOpenLess;
	
	private Short isOpenGreater;
	private String desLike;
	
	private String desEquals;
	private String[] desIn;
	private Boolean desIsNull;
	private Boolean desIsNotNull;
	
	private String desStart;
	
	private String desEnd;
	
	private String desLess;
	
	private String desGreater;
	private String upVerNoLike;
	
	private String upVerNoEquals;
	private String[] upVerNoIn;
	private Boolean upVerNoIsNull;
	private Boolean upVerNoIsNotNull;
	
	private String upVerNoStart;
	
	private String upVerNoEnd;
	
	private String upVerNoLess;
	
	private String upVerNoGreater;
	
	private Integer serFtpIdEquals;
	private Integer[] serFtpIdIn;
	private Boolean serFtpIdIsNull;
	private Boolean serFtpIdIsNotNull;
	
	private Integer serFtpIdStart;
	
	private Integer serFtpIdEnd;
	
	private Integer serFtpIdLess;
	
	private Integer serFtpIdGreater;
	
	private Integer perTimeoutEquals;
	private Integer[] perTimeoutIn;
	private Boolean perTimeoutIsNull;
	private Boolean perTimeoutIsNotNull;
	
	private Integer perTimeoutStart;
	
	private Integer perTimeoutEnd;
	
	private Integer perTimeoutLess;
	
	private Integer perTimeoutGreater;
	
	private Integer perMaxVehicleEquals;
	private Integer[] perMaxVehicleIn;
	private Boolean perMaxVehicleIsNull;
	private Boolean perMaxVehicleIsNotNull;
	
	private Integer perMaxVehicleStart;
	
	private Integer perMaxVehicleEnd;
	
	private Integer perMaxVehicleLess;
	
	private Integer perMaxVehicleGreater;
	private String fileNameLike;
	
	private String fileNameEquals;
	private String[] fileNameIn;
	private Boolean fileNameIsNull;
	private Boolean fileNameIsNotNull;
	
	private String fileNameStart;
	
	private String fileNameEnd;
	
	private String fileNameLess;
	
	private String fileNameGreater;
	
	private Short turnOffFlagEquals;
	private Short[] turnOffFlagIn;
	private Boolean turnOffFlagIsNull;
	private Boolean turnOffFlagIsNotNull;
	
	private Short turnOffFlagStart;
	
	private Short turnOffFlagEnd;
	
	private Short turnOffFlagLess;
	
	private Short turnOffFlagGreater;
	private String sidx;
	private String sord;

	public VerUpgradeQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public VerUpgradeQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public VerUpgradeQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public VerUpgradeQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public VerUpgradeQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public VerUpgradeQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public VerUpgradeQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public VerUpgradeQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public VerUpgradeQuery setSoftVerIdEquals(Integer softVerIdEquals){
		this.softVerIdEquals = softVerIdEquals;
		return this;
	}
	public Integer getSoftVerIdEquals(){
		return this.softVerIdEquals;
	}
	public VerUpgradeQuery setSoftVerIdIn(Integer[] softVerIdIn){
		this.softVerIdIn = softVerIdIn;
		return this;
	}
	public Integer[] getSoftVerIdIn(){
		return this.softVerIdIn;
	}
	public VerUpgradeQuery setSoftVerIdIsNull(Boolean softVerIdIsNull){
		this.softVerIdIsNull = softVerIdIsNull;
		return this;
	}
	public Boolean getSoftVerIdIsNull(){
		return this.softVerIdIsNull;
	}
	public VerUpgradeQuery setSoftVerIdIsNotNull(Boolean softVerIdIsNotNull){
		this.softVerIdIsNotNull = softVerIdIsNotNull;
		return this;
	}
	public Boolean getSoftVerIdIsNotNull(){
		return this.softVerIdIsNotNull;
	}
	public VerUpgradeQuery setSoftVerIdStart(Integer softVerIdStart){
		this.softVerIdStart = softVerIdStart;
		return this;
	}
	public Integer getSoftVerIdStart(){
		return this.softVerIdStart;
	}
	public VerUpgradeQuery setSoftVerIdEnd(Integer softVerIdEnd){
		this.softVerIdEnd = softVerIdEnd;
		return this;
	}
	public Integer getSoftVerIdEnd(){
		return this.softVerIdEnd;
	}
	public VerUpgradeQuery setSoftVerIdLess(Integer softVerIdLess){
		this.softVerIdLess = softVerIdLess;
		return this;
	}
	public Integer getSoftVerIdLess(){
		return this.softVerIdLess;
	}
	public VerUpgradeQuery setSoftVerIdGreater(Integer softVerIdGreater){
		this.softVerIdGreater = softVerIdGreater;
		return this;
	}
	public Integer getSoftVerIdGreater(){
		return this.softVerIdGreater;
	}
	public VerUpgradeQuery setHardVerIdEquals(Integer hardVerIdEquals){
		this.hardVerIdEquals = hardVerIdEquals;
		return this;
	}
	public Integer getHardVerIdEquals(){
		return this.hardVerIdEquals;
	}
	public VerUpgradeQuery setHardVerIdIn(Integer[] hardVerIdIn){
		this.hardVerIdIn = hardVerIdIn;
		return this;
	}
	public Integer[] getHardVerIdIn(){
		return this.hardVerIdIn;
	}
	public VerUpgradeQuery setHardVerIdIsNull(Boolean hardVerIdIsNull){
		this.hardVerIdIsNull = hardVerIdIsNull;
		return this;
	}
	public Boolean getHardVerIdIsNull(){
		return this.hardVerIdIsNull;
	}
	public VerUpgradeQuery setHardVerIdIsNotNull(Boolean hardVerIdIsNotNull){
		this.hardVerIdIsNotNull = hardVerIdIsNotNull;
		return this;
	}
	public Boolean getHardVerIdIsNotNull(){
		return this.hardVerIdIsNotNull;
	}
	public VerUpgradeQuery setHardVerIdStart(Integer hardVerIdStart){
		this.hardVerIdStart = hardVerIdStart;
		return this;
	}
	public Integer getHardVerIdStart(){
		return this.hardVerIdStart;
	}
	public VerUpgradeQuery setHardVerIdEnd(Integer hardVerIdEnd){
		this.hardVerIdEnd = hardVerIdEnd;
		return this;
	}
	public Integer getHardVerIdEnd(){
		return this.hardVerIdEnd;
	}
	public VerUpgradeQuery setHardVerIdLess(Integer hardVerIdLess){
		this.hardVerIdLess = hardVerIdLess;
		return this;
	}
	public Integer getHardVerIdLess(){
		return this.hardVerIdLess;
	}
	public VerUpgradeQuery setHardVerIdGreater(Integer hardVerIdGreater){
		this.hardVerIdGreater = hardVerIdGreater;
		return this;
	}
	public Integer getHardVerIdGreater(){
		return this.hardVerIdGreater;
	}
	public VerUpgradeQuery setModelIdEquals(Integer modelIdEquals){
		this.modelIdEquals = modelIdEquals;
		return this;
	}
	public Integer getModelIdEquals(){
		return this.modelIdEquals;
	}
	public VerUpgradeQuery setModelIdIn(Integer[] modelIdIn){
		this.modelIdIn = modelIdIn;
		return this;
	}
	public Integer[] getModelIdIn(){
		return this.modelIdIn;
	}
	public VerUpgradeQuery setModelIdIsNull(Boolean modelIdIsNull){
		this.modelIdIsNull = modelIdIsNull;
		return this;
	}
	public Boolean getModelIdIsNull(){
		return this.modelIdIsNull;
	}
	public VerUpgradeQuery setModelIdIsNotNull(Boolean modelIdIsNotNull){
		this.modelIdIsNotNull = modelIdIsNotNull;
		return this;
	}
	public Boolean getModelIdIsNotNull(){
		return this.modelIdIsNotNull;
	}
	public VerUpgradeQuery setModelIdStart(Integer modelIdStart){
		this.modelIdStart = modelIdStart;
		return this;
	}
	public Integer getModelIdStart(){
		return this.modelIdStart;
	}
	public VerUpgradeQuery setModelIdEnd(Integer modelIdEnd){
		this.modelIdEnd = modelIdEnd;
		return this;
	}
	public Integer getModelIdEnd(){
		return this.modelIdEnd;
	}
	public VerUpgradeQuery setModelIdLess(Integer modelIdLess){
		this.modelIdLess = modelIdLess;
		return this;
	}
	public Integer getModelIdLess(){
		return this.modelIdLess;
	}
	public VerUpgradeQuery setModelIdGreater(Integer modelIdGreater){
		this.modelIdGreater = modelIdGreater;
		return this;
	}
	public Integer getModelIdGreater(){
		return this.modelIdGreater;
	}
	public VerUpgradeQuery setTelTypeEquals(Integer telTypeEquals){
		this.telTypeEquals = telTypeEquals;
		return this;
	}
	public Integer getTelTypeEquals(){
		return this.telTypeEquals;
	}
	public VerUpgradeQuery setTelTypeIn(Integer[] telTypeIn){
		this.telTypeIn = telTypeIn;
		return this;
	}
	public Integer[] getTelTypeIn(){
		return this.telTypeIn;
	}
	public VerUpgradeQuery setTelTypeIsNull(Boolean telTypeIsNull){
		this.telTypeIsNull = telTypeIsNull;
		return this;
	}
	public Boolean getTelTypeIsNull(){
		return this.telTypeIsNull;
	}
	public VerUpgradeQuery setTelTypeIsNotNull(Boolean telTypeIsNotNull){
		this.telTypeIsNotNull = telTypeIsNotNull;
		return this;
	}
	public Boolean getTelTypeIsNotNull(){
		return this.telTypeIsNotNull;
	}
	public VerUpgradeQuery setTelTypeStart(Integer telTypeStart){
		this.telTypeStart = telTypeStart;
		return this;
	}
	public Integer getTelTypeStart(){
		return this.telTypeStart;
	}
	public VerUpgradeQuery setTelTypeEnd(Integer telTypeEnd){
		this.telTypeEnd = telTypeEnd;
		return this;
	}
	public Integer getTelTypeEnd(){
		return this.telTypeEnd;
	}
	public VerUpgradeQuery setTelTypeLess(Integer telTypeLess){
		this.telTypeLess = telTypeLess;
		return this;
	}
	public Integer getTelTypeLess(){
		return this.telTypeLess;
	}
	public VerUpgradeQuery setTelTypeGreater(Integer telTypeGreater){
		this.telTypeGreater = telTypeGreater;
		return this;
	}
	public Integer getTelTypeGreater(){
		return this.telTypeGreater;
	}
	public VerUpgradeQuery setInnerVerLike(String innerVerLike){
		this.innerVerLike = innerVerLike;
		return this;
	}
	public String getInnerVerLike(){
		return this.innerVerLike;
	}
	public VerUpgradeQuery setInnerVerEquals(String innerVerEquals){
		this.innerVerEquals = innerVerEquals;
		return this;
	}
	public String getInnerVerEquals(){
		return this.innerVerEquals;
	}
	public VerUpgradeQuery setInnerVerIn(String[] innerVerIn){
		this.innerVerIn = innerVerIn;
		return this;
	}
	public String[] getInnerVerIn(){
		return this.innerVerIn;
	}
	public VerUpgradeQuery setInnerVerIsNull(Boolean innerVerIsNull){
		this.innerVerIsNull = innerVerIsNull;
		return this;
	}
	public Boolean getInnerVerIsNull(){
		return this.innerVerIsNull;
	}
	public VerUpgradeQuery setInnerVerIsNotNull(Boolean innerVerIsNotNull){
		this.innerVerIsNotNull = innerVerIsNotNull;
		return this;
	}
	public Boolean getInnerVerIsNotNull(){
		return this.innerVerIsNotNull;
	}
	public VerUpgradeQuery setInnerVerStart(String innerVerStart){
		this.innerVerStart = innerVerStart;
		return this;
	}
	public String getInnerVerStart(){
		return this.innerVerStart;
	}
	public VerUpgradeQuery setInnerVerEnd(String innerVerEnd){
		this.innerVerEnd = innerVerEnd;
		return this;
	}
	public String getInnerVerEnd(){
		return this.innerVerEnd;
	}
	public VerUpgradeQuery setInnerVerLess(String innerVerLess){
		this.innerVerLess = innerVerLess;
		return this;
	}
	public String getInnerVerLess(){
		return this.innerVerLess;
	}
	public VerUpgradeQuery setInnerVerGreater(String innerVerGreater){
		this.innerVerGreater = innerVerGreater;
		return this;
	}
	public String getInnerVerGreater(){
		return this.innerVerGreater;
	}
	public VerUpgradeQuery setIsOpenEquals(Short isOpenEquals){
		this.isOpenEquals = isOpenEquals;
		return this;
	}
	public Short getIsOpenEquals(){
		return this.isOpenEquals;
	}
	public VerUpgradeQuery setIsOpenIn(Short[] isOpenIn){
		this.isOpenIn = isOpenIn;
		return this;
	}
	public Short[] getIsOpenIn(){
		return this.isOpenIn;
	}
	public VerUpgradeQuery setIsOpenIsNull(Boolean isOpenIsNull){
		this.isOpenIsNull = isOpenIsNull;
		return this;
	}
	public Boolean getIsOpenIsNull(){
		return this.isOpenIsNull;
	}
	public VerUpgradeQuery setIsOpenIsNotNull(Boolean isOpenIsNotNull){
		this.isOpenIsNotNull = isOpenIsNotNull;
		return this;
	}
	public Boolean getIsOpenIsNotNull(){
		return this.isOpenIsNotNull;
	}
	public VerUpgradeQuery setIsOpenStart(Short isOpenStart){
		this.isOpenStart = isOpenStart;
		return this;
	}
	public Short getIsOpenStart(){
		return this.isOpenStart;
	}
	public VerUpgradeQuery setIsOpenEnd(Short isOpenEnd){
		this.isOpenEnd = isOpenEnd;
		return this;
	}
	public Short getIsOpenEnd(){
		return this.isOpenEnd;
	}
	public VerUpgradeQuery setIsOpenLess(Short isOpenLess){
		this.isOpenLess = isOpenLess;
		return this;
	}
	public Short getIsOpenLess(){
		return this.isOpenLess;
	}
	public VerUpgradeQuery setIsOpenGreater(Short isOpenGreater){
		this.isOpenGreater = isOpenGreater;
		return this;
	}
	public Short getIsOpenGreater(){
		return this.isOpenGreater;
	}
	public VerUpgradeQuery setdesLike(String desLike){
		this.desLike = desLike;
		return this;
	}
	public String getdesLike(){
		return this.desLike;
	}
	public VerUpgradeQuery setdesEquals(String desEquals){
		this.desEquals = desEquals;
		return this;
	}
	public String getdesEquals(){
		return this.desEquals;
	}
	public VerUpgradeQuery setdesIn(String[] desIn){
		this.desIn = desIn;
		return this;
	}
	public String[] getdesIn(){
		return this.desIn;
	}
	public VerUpgradeQuery setdesIsNull(Boolean desIsNull){
		this.desIsNull = desIsNull;
		return this;
	}
	public Boolean getdesIsNull(){
		return this.desIsNull;
	}
	public VerUpgradeQuery setdesIsNotNull(Boolean desIsNotNull){
		this.desIsNotNull = desIsNotNull;
		return this;
	}
	public Boolean getdesIsNotNull(){
		return this.desIsNotNull;
	}
	public VerUpgradeQuery setdesStart(String desStart){
		this.desStart = desStart;
		return this;
	}
	public String getdesStart(){
		return this.desStart;
	}
	public VerUpgradeQuery setdesEnd(String desEnd){
		this.desEnd = desEnd;
		return this;
	}
	public String getdesEnd(){
		return this.desEnd;
	}
	public VerUpgradeQuery setdesLess(String desLess){
		this.desLess = desLess;
		return this;
	}
	public String getdesLess(){
		return this.desLess;
	}
	public VerUpgradeQuery setdesGreater(String desGreater){
		this.desGreater = desGreater;
		return this;
	}
	public String getdesGreater(){
		return this.desGreater;
	}
	public VerUpgradeQuery setUpVerNoLike(String upVerNoLike){
		this.upVerNoLike = upVerNoLike;
		return this;
	}
	public String getUpVerNoLike(){
		return this.upVerNoLike;
	}
	public VerUpgradeQuery setUpVerNoEquals(String upVerNoEquals){
		this.upVerNoEquals = upVerNoEquals;
		return this;
	}
	public String getUpVerNoEquals(){
		return this.upVerNoEquals;
	}
	public VerUpgradeQuery setUpVerNoIn(String[] upVerNoIn){
		this.upVerNoIn = upVerNoIn;
		return this;
	}
	public String[] getUpVerNoIn(){
		return this.upVerNoIn;
	}
	public VerUpgradeQuery setUpVerNoIsNull(Boolean upVerNoIsNull){
		this.upVerNoIsNull = upVerNoIsNull;
		return this;
	}
	public Boolean getUpVerNoIsNull(){
		return this.upVerNoIsNull;
	}
	public VerUpgradeQuery setUpVerNoIsNotNull(Boolean upVerNoIsNotNull){
		this.upVerNoIsNotNull = upVerNoIsNotNull;
		return this;
	}
	public Boolean getUpVerNoIsNotNull(){
		return this.upVerNoIsNotNull;
	}
	public VerUpgradeQuery setUpVerNoStart(String upVerNoStart){
		this.upVerNoStart = upVerNoStart;
		return this;
	}
	public String getUpVerNoStart(){
		return this.upVerNoStart;
	}
	public VerUpgradeQuery setUpVerNoEnd(String upVerNoEnd){
		this.upVerNoEnd = upVerNoEnd;
		return this;
	}
	public String getUpVerNoEnd(){
		return this.upVerNoEnd;
	}
	public VerUpgradeQuery setUpVerNoLess(String upVerNoLess){
		this.upVerNoLess = upVerNoLess;
		return this;
	}
	public String getUpVerNoLess(){
		return this.upVerNoLess;
	}
	public VerUpgradeQuery setUpVerNoGreater(String upVerNoGreater){
		this.upVerNoGreater = upVerNoGreater;
		return this;
	}
	public String getUpVerNoGreater(){
		return this.upVerNoGreater;
	}
	public VerUpgradeQuery setSerFtpIdEquals(Integer serFtpIdEquals){
		this.serFtpIdEquals = serFtpIdEquals;
		return this;
	}
	public Integer getSerFtpIdEquals(){
		return this.serFtpIdEquals;
	}
	public VerUpgradeQuery setSerFtpIdIn(Integer[] serFtpIdIn){
		this.serFtpIdIn = serFtpIdIn;
		return this;
	}
	public Integer[] getSerFtpIdIn(){
		return this.serFtpIdIn;
	}
	public VerUpgradeQuery setSerFtpIdIsNull(Boolean serFtpIdIsNull){
		this.serFtpIdIsNull = serFtpIdIsNull;
		return this;
	}
	public Boolean getSerFtpIdIsNull(){
		return this.serFtpIdIsNull;
	}
	public VerUpgradeQuery setSerFtpIdIsNotNull(Boolean serFtpIdIsNotNull){
		this.serFtpIdIsNotNull = serFtpIdIsNotNull;
		return this;
	}
	public Boolean getSerFtpIdIsNotNull(){
		return this.serFtpIdIsNotNull;
	}
	public VerUpgradeQuery setSerFtpIdStart(Integer serFtpIdStart){
		this.serFtpIdStart = serFtpIdStart;
		return this;
	}
	public Integer getSerFtpIdStart(){
		return this.serFtpIdStart;
	}
	public VerUpgradeQuery setSerFtpIdEnd(Integer serFtpIdEnd){
		this.serFtpIdEnd = serFtpIdEnd;
		return this;
	}
	public Integer getSerFtpIdEnd(){
		return this.serFtpIdEnd;
	}
	public VerUpgradeQuery setSerFtpIdLess(Integer serFtpIdLess){
		this.serFtpIdLess = serFtpIdLess;
		return this;
	}
	public Integer getSerFtpIdLess(){
		return this.serFtpIdLess;
	}
	public VerUpgradeQuery setSerFtpIdGreater(Integer serFtpIdGreater){
		this.serFtpIdGreater = serFtpIdGreater;
		return this;
	}
	public Integer getSerFtpIdGreater(){
		return this.serFtpIdGreater;
	}
	public VerUpgradeQuery setPerTimeoutEquals(Integer perTimeoutEquals){
		this.perTimeoutEquals = perTimeoutEquals;
		return this;
	}
	public Integer getPerTimeoutEquals(){
		return this.perTimeoutEquals;
	}
	public VerUpgradeQuery setPerTimeoutIn(Integer[] perTimeoutIn){
		this.perTimeoutIn = perTimeoutIn;
		return this;
	}
	public Integer[] getPerTimeoutIn(){
		return this.perTimeoutIn;
	}
	public VerUpgradeQuery setPerTimeoutIsNull(Boolean perTimeoutIsNull){
		this.perTimeoutIsNull = perTimeoutIsNull;
		return this;
	}
	public Boolean getPerTimeoutIsNull(){
		return this.perTimeoutIsNull;
	}
	public VerUpgradeQuery setPerTimeoutIsNotNull(Boolean perTimeoutIsNotNull){
		this.perTimeoutIsNotNull = perTimeoutIsNotNull;
		return this;
	}
	public Boolean getPerTimeoutIsNotNull(){
		return this.perTimeoutIsNotNull;
	}
	public VerUpgradeQuery setPerTimeoutStart(Integer perTimeoutStart){
		this.perTimeoutStart = perTimeoutStart;
		return this;
	}
	public Integer getPerTimeoutStart(){
		return this.perTimeoutStart;
	}
	public VerUpgradeQuery setPerTimeoutEnd(Integer perTimeoutEnd){
		this.perTimeoutEnd = perTimeoutEnd;
		return this;
	}
	public Integer getPerTimeoutEnd(){
		return this.perTimeoutEnd;
	}
	public VerUpgradeQuery setPerTimeoutLess(Integer perTimeoutLess){
		this.perTimeoutLess = perTimeoutLess;
		return this;
	}
	public Integer getPerTimeoutLess(){
		return this.perTimeoutLess;
	}
	public VerUpgradeQuery setPerTimeoutGreater(Integer perTimeoutGreater){
		this.perTimeoutGreater = perTimeoutGreater;
		return this;
	}
	public Integer getPerTimeoutGreater(){
		return this.perTimeoutGreater;
	}
	public VerUpgradeQuery setPerMaxVehicleEquals(Integer perMaxVehicleEquals){
		this.perMaxVehicleEquals = perMaxVehicleEquals;
		return this;
	}
	public Integer getPerMaxVehicleEquals(){
		return this.perMaxVehicleEquals;
	}
	public VerUpgradeQuery setPerMaxVehicleIn(Integer[] perMaxVehicleIn){
		this.perMaxVehicleIn = perMaxVehicleIn;
		return this;
	}
	public Integer[] getPerMaxVehicleIn(){
		return this.perMaxVehicleIn;
	}
	public VerUpgradeQuery setPerMaxVehicleIsNull(Boolean perMaxVehicleIsNull){
		this.perMaxVehicleIsNull = perMaxVehicleIsNull;
		return this;
	}
	public Boolean getPerMaxVehicleIsNull(){
		return this.perMaxVehicleIsNull;
	}
	public VerUpgradeQuery setPerMaxVehicleIsNotNull(Boolean perMaxVehicleIsNotNull){
		this.perMaxVehicleIsNotNull = perMaxVehicleIsNotNull;
		return this;
	}
	public Boolean getPerMaxVehicleIsNotNull(){
		return this.perMaxVehicleIsNotNull;
	}
	public VerUpgradeQuery setPerMaxVehicleStart(Integer perMaxVehicleStart){
		this.perMaxVehicleStart = perMaxVehicleStart;
		return this;
	}
	public Integer getPerMaxVehicleStart(){
		return this.perMaxVehicleStart;
	}
	public VerUpgradeQuery setPerMaxVehicleEnd(Integer perMaxVehicleEnd){
		this.perMaxVehicleEnd = perMaxVehicleEnd;
		return this;
	}
	public Integer getPerMaxVehicleEnd(){
		return this.perMaxVehicleEnd;
	}
	public VerUpgradeQuery setPerMaxVehicleLess(Integer perMaxVehicleLess){
		this.perMaxVehicleLess = perMaxVehicleLess;
		return this;
	}
	public Integer getPerMaxVehicleLess(){
		return this.perMaxVehicleLess;
	}
	public VerUpgradeQuery setPerMaxVehicleGreater(Integer perMaxVehicleGreater){
		this.perMaxVehicleGreater = perMaxVehicleGreater;
		return this;
	}
	public Integer getPerMaxVehicleGreater(){
		return this.perMaxVehicleGreater;
	}
	public VerUpgradeQuery setFileNameLike(String fileNameLike){
		this.fileNameLike = fileNameLike;
		return this;
	}
	public String getFileNameLike(){
		return this.fileNameLike;
	}
	public VerUpgradeQuery setFileNameEquals(String fileNameEquals){
		this.fileNameEquals = fileNameEquals;
		return this;
	}
	public String getFileNameEquals(){
		return this.fileNameEquals;
	}
	public VerUpgradeQuery setFileNameIn(String[] fileNameIn){
		this.fileNameIn = fileNameIn;
		return this;
	}
	public String[] getFileNameIn(){
		return this.fileNameIn;
	}
	public VerUpgradeQuery setFileNameIsNull(Boolean fileNameIsNull){
		this.fileNameIsNull = fileNameIsNull;
		return this;
	}
	public Boolean getFileNameIsNull(){
		return this.fileNameIsNull;
	}
	public VerUpgradeQuery setFileNameIsNotNull(Boolean fileNameIsNotNull){
		this.fileNameIsNotNull = fileNameIsNotNull;
		return this;
	}
	public Boolean getFileNameIsNotNull(){
		return this.fileNameIsNotNull;
	}
	public VerUpgradeQuery setFileNameStart(String fileNameStart){
		this.fileNameStart = fileNameStart;
		return this;
	}
	public String getFileNameStart(){
		return this.fileNameStart;
	}
	public VerUpgradeQuery setFileNameEnd(String fileNameEnd){
		this.fileNameEnd = fileNameEnd;
		return this;
	}
	public String getFileNameEnd(){
		return this.fileNameEnd;
	}
	public VerUpgradeQuery setFileNameLess(String fileNameLess){
		this.fileNameLess = fileNameLess;
		return this;
	}
	public String getFileNameLess(){
		return this.fileNameLess;
	}
	public VerUpgradeQuery setFileNameGreater(String fileNameGreater){
		this.fileNameGreater = fileNameGreater;
		return this;
	}
	public String getFileNameGreater(){
		return this.fileNameGreater;
	}
	public VerUpgradeQuery setTurnOffFlagEquals(Short turnOffFlagEquals){
		this.turnOffFlagEquals = turnOffFlagEquals;
		return this;
	}
	public Short getTurnOffFlagEquals(){
		return this.turnOffFlagEquals;
	}
	public VerUpgradeQuery setTurnOffFlagIn(Short[] turnOffFlagIn){
		this.turnOffFlagIn = turnOffFlagIn;
		return this;
	}
	public Short[] getTurnOffFlagIn(){
		return this.turnOffFlagIn;
	}
	public VerUpgradeQuery setTurnOffFlagIsNull(Boolean turnOffFlagIsNull){
		this.turnOffFlagIsNull = turnOffFlagIsNull;
		return this;
	}
	public Boolean getTurnOffFlagIsNull(){
		return this.turnOffFlagIsNull;
	}
	public VerUpgradeQuery setTurnOffFlagIsNotNull(Boolean turnOffFlagIsNotNull){
		this.turnOffFlagIsNotNull = turnOffFlagIsNotNull;
		return this;
	}
	public Boolean getTurnOffFlagIsNotNull(){
		return this.turnOffFlagIsNotNull;
	}
	public VerUpgradeQuery setTurnOffFlagStart(Short turnOffFlagStart){
		this.turnOffFlagStart = turnOffFlagStart;
		return this;
	}
	public Short getTurnOffFlagStart(){
		return this.turnOffFlagStart;
	}
	public VerUpgradeQuery setTurnOffFlagEnd(Short turnOffFlagEnd){
		this.turnOffFlagEnd = turnOffFlagEnd;
		return this;
	}
	public Short getTurnOffFlagEnd(){
		return this.turnOffFlagEnd;
	}
	public VerUpgradeQuery setTurnOffFlagLess(Short turnOffFlagLess){
		this.turnOffFlagLess = turnOffFlagLess;
		return this;
	}
	public Short getTurnOffFlagLess(){
		return this.turnOffFlagLess;
	}
	public VerUpgradeQuery setTurnOffFlagGreater(Short turnOffFlagGreater){
		this.turnOffFlagGreater = turnOffFlagGreater;
		return this;
	}
	public Short getTurnOffFlagGreater(){
		return this.turnOffFlagGreater;
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
		else if(this.sidx.equals("softVerId")){
			return "soft_ver_id";
		}
		else if(this.sidx.equals("hardVerId")){
			return "hard_ver_id";
		}
		else if(this.sidx.equals("modelId")){
			return "model_id";
		}
		else if(this.sidx.equals("telType")){
			return "tel_type";
		}
		else if(this.sidx.equals("innerVer")){
			return "inner_ver";
		}
		else if(this.sidx.equals("isOpen")){
			return "is_open";
		}
		else if(this.sidx.equals("des")){
			return "des";
		}
		else if(this.sidx.equals("upVerNo")){
			return "up_ver_no";
		}
		else if(this.sidx.equals("serFtpId")){
			return "ser_ftp_id";
		}
		else if(this.sidx.equals("perTimeout")){
			return "per_timeout";
		}
		else if(this.sidx.equals("perMaxVehicle")){
			return "per_max_vehicle";
		}
		else if(this.sidx.equals("fileName")){
			return "file_name";
		}
		else if(this.sidx.equals("turnOffFlag")){
			return "turn_off_flag";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public VerUpgradeCrieria getCrieria(){
		VerUpgradeCrieria q = new VerUpgradeCrieria();
		VerUpgradeCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getSoftVerIdEquals()!=null){
			c.andsoftVerIdEqualTo(this.getSoftVerIdEquals());
		}else if(this.getSoftVerIdIsNull()!=null && this.getSoftVerIdIsNull()){
			c.andsoftVerIdIsNull();
		}else if(this.getSoftVerIdIsNotNull()!=null && this.getSoftVerIdIsNotNull()){
			c.andsoftVerIdIsNotNull();
		}else if(this.getSoftVerIdIn()!=null){
			c.andsoftVerIdIn(java.util.Arrays.asList(this.getSoftVerIdIn()));
		}else if(this.getSoftVerIdStart()!=null && this.getSoftVerIdEnd()!=null){
			c.andsoftVerIdBetween(this.getSoftVerIdStart(), this.getSoftVerIdEnd());
		}else if(this.getSoftVerIdGreater()!=null){
			c.andsoftVerIdGreaterThan(this.getSoftVerIdGreater());
		}else if(this.getSoftVerIdLess()!=null){
			c.andsoftVerIdLessThan(this.getSoftVerIdLess());
		}
		if(this.getHardVerIdEquals()!=null){
			c.andhardVerIdEqualTo(this.getHardVerIdEquals());
		}else if(this.getHardVerIdIsNull()!=null && this.getHardVerIdIsNull()){
			c.andhardVerIdIsNull();
		}else if(this.getHardVerIdIsNotNull()!=null && this.getHardVerIdIsNotNull()){
			c.andhardVerIdIsNotNull();
		}else if(this.getHardVerIdIn()!=null){
			c.andhardVerIdIn(java.util.Arrays.asList(this.getHardVerIdIn()));
		}else if(this.getHardVerIdStart()!=null && this.getHardVerIdEnd()!=null){
			c.andhardVerIdBetween(this.getHardVerIdStart(), this.getHardVerIdEnd());
		}else if(this.getHardVerIdGreater()!=null){
			c.andhardVerIdGreaterThan(this.getHardVerIdGreater());
		}else if(this.getHardVerIdLess()!=null){
			c.andhardVerIdLessThan(this.getHardVerIdLess());
		}
		if(this.getModelIdEquals()!=null){
			c.andmodelIdEqualTo(this.getModelIdEquals());
		}else if(this.getModelIdIsNull()!=null && this.getModelIdIsNull()){
			c.andmodelIdIsNull();
		}else if(this.getModelIdIsNotNull()!=null && this.getModelIdIsNotNull()){
			c.andmodelIdIsNotNull();
		}else if(this.getModelIdIn()!=null){
			c.andmodelIdIn(java.util.Arrays.asList(this.getModelIdIn()));
		}else if(this.getModelIdStart()!=null && this.getModelIdEnd()!=null){
			c.andmodelIdBetween(this.getModelIdStart(), this.getModelIdEnd());
		}else if(this.getModelIdGreater()!=null){
			c.andmodelIdGreaterThan(this.getModelIdGreater());
		}else if(this.getModelIdLess()!=null){
			c.andmodelIdLessThan(this.getModelIdLess());
		}
		if(this.getTelTypeEquals()!=null){
			c.andtelTypeEqualTo(this.getTelTypeEquals());
		}else if(this.getTelTypeIsNull()!=null && this.getTelTypeIsNull()){
			c.andtelTypeIsNull();
		}else if(this.getTelTypeIsNotNull()!=null && this.getTelTypeIsNotNull()){
			c.andtelTypeIsNotNull();
		}else if(this.getTelTypeIn()!=null){
			c.andtelTypeIn(java.util.Arrays.asList(this.getTelTypeIn()));
		}else if(this.getTelTypeStart()!=null && this.getTelTypeEnd()!=null){
			c.andtelTypeBetween(this.getTelTypeStart(), this.getTelTypeEnd());
		}else if(this.getTelTypeGreater()!=null){
			c.andtelTypeGreaterThan(this.getTelTypeGreater());
		}else if(this.getTelTypeLess()!=null){
			c.andtelTypeLessThan(this.getTelTypeLess());
		}
		if(this.getInnerVerEquals()!=null){
			c.andinnerVerEqualTo(this.getInnerVerEquals());
		}else if(this.getInnerVerIsNull()!=null && this.getInnerVerIsNull()){
			c.andinnerVerIsNull();
		}else if(this.getInnerVerIsNotNull()!=null && this.getInnerVerIsNotNull()){
			c.andinnerVerIsNotNull();
		}else if(this.getInnerVerLike()!=null){
			c.andinnerVerLike(this.getInnerVerLike());
		}else if(this.getInnerVerIn()!=null){
			c.andinnerVerIn(java.util.Arrays.asList(this.getInnerVerIn()));
		}else if(this.getInnerVerStart()!=null && this.getInnerVerEnd()!=null){
			c.andinnerVerBetween(this.getInnerVerStart(), this.getInnerVerEnd());
		}else if(this.getInnerVerGreater()!=null){
			c.andinnerVerGreaterThan(this.getInnerVerGreater());
		}else if(this.getInnerVerLess()!=null){
			c.andinnerVerLessThan(this.getInnerVerLess());
		}
		if(this.getIsOpenEquals()!=null){
			c.andisOpenEqualTo(this.getIsOpenEquals());
		}else if(this.getIsOpenIsNull()!=null && this.getIsOpenIsNull()){
			c.andisOpenIsNull();
		}else if(this.getIsOpenIsNotNull()!=null && this.getIsOpenIsNotNull()){
			c.andisOpenIsNotNull();
		}else if(this.getIsOpenIn()!=null){
			c.andisOpenIn(java.util.Arrays.asList(this.getIsOpenIn()));
		}else if(this.getIsOpenStart()!=null && this.getIsOpenEnd()!=null){
			c.andisOpenBetween(this.getIsOpenStart(), this.getIsOpenEnd());
		}else if(this.getIsOpenGreater()!=null){
			c.andisOpenGreaterThan(this.getIsOpenGreater());
		}else if(this.getIsOpenLess()!=null){
			c.andisOpenLessThan(this.getIsOpenLess());
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
		if(this.getUpVerNoEquals()!=null){
			c.andupVerNoEqualTo(this.getUpVerNoEquals());
		}else if(this.getUpVerNoIsNull()!=null && this.getUpVerNoIsNull()){
			c.andupVerNoIsNull();
		}else if(this.getUpVerNoIsNotNull()!=null && this.getUpVerNoIsNotNull()){
			c.andupVerNoIsNotNull();
		}else if(this.getUpVerNoLike()!=null){
			c.andupVerNoLike(this.getUpVerNoLike());
		}else if(this.getUpVerNoIn()!=null){
			c.andupVerNoIn(java.util.Arrays.asList(this.getUpVerNoIn()));
		}else if(this.getUpVerNoStart()!=null && this.getUpVerNoEnd()!=null){
			c.andupVerNoBetween(this.getUpVerNoStart(), this.getUpVerNoEnd());
		}else if(this.getUpVerNoGreater()!=null){
			c.andupVerNoGreaterThan(this.getUpVerNoGreater());
		}else if(this.getUpVerNoLess()!=null){
			c.andupVerNoLessThan(this.getUpVerNoLess());
		}
		if(this.getSerFtpIdEquals()!=null){
			c.andserFtpIdEqualTo(this.getSerFtpIdEquals());
		}else if(this.getSerFtpIdIsNull()!=null && this.getSerFtpIdIsNull()){
			c.andserFtpIdIsNull();
		}else if(this.getSerFtpIdIsNotNull()!=null && this.getSerFtpIdIsNotNull()){
			c.andserFtpIdIsNotNull();
		}else if(this.getSerFtpIdIn()!=null){
			c.andserFtpIdIn(java.util.Arrays.asList(this.getSerFtpIdIn()));
		}else if(this.getSerFtpIdStart()!=null && this.getSerFtpIdEnd()!=null){
			c.andserFtpIdBetween(this.getSerFtpIdStart(), this.getSerFtpIdEnd());
		}else if(this.getSerFtpIdGreater()!=null){
			c.andserFtpIdGreaterThan(this.getSerFtpIdGreater());
		}else if(this.getSerFtpIdLess()!=null){
			c.andserFtpIdLessThan(this.getSerFtpIdLess());
		}
		if(this.getPerTimeoutEquals()!=null){
			c.andperTimeoutEqualTo(this.getPerTimeoutEquals());
		}else if(this.getPerTimeoutIsNull()!=null && this.getPerTimeoutIsNull()){
			c.andperTimeoutIsNull();
		}else if(this.getPerTimeoutIsNotNull()!=null && this.getPerTimeoutIsNotNull()){
			c.andperTimeoutIsNotNull();
		}else if(this.getPerTimeoutIn()!=null){
			c.andperTimeoutIn(java.util.Arrays.asList(this.getPerTimeoutIn()));
		}else if(this.getPerTimeoutStart()!=null && this.getPerTimeoutEnd()!=null){
			c.andperTimeoutBetween(this.getPerTimeoutStart(), this.getPerTimeoutEnd());
		}else if(this.getPerTimeoutGreater()!=null){
			c.andperTimeoutGreaterThan(this.getPerTimeoutGreater());
		}else if(this.getPerTimeoutLess()!=null){
			c.andperTimeoutLessThan(this.getPerTimeoutLess());
		}
		if(this.getPerMaxVehicleEquals()!=null){
			c.andperMaxVehicleEqualTo(this.getPerMaxVehicleEquals());
		}else if(this.getPerMaxVehicleIsNull()!=null && this.getPerMaxVehicleIsNull()){
			c.andperMaxVehicleIsNull();
		}else if(this.getPerMaxVehicleIsNotNull()!=null && this.getPerMaxVehicleIsNotNull()){
			c.andperMaxVehicleIsNotNull();
		}else if(this.getPerMaxVehicleIn()!=null){
			c.andperMaxVehicleIn(java.util.Arrays.asList(this.getPerMaxVehicleIn()));
		}else if(this.getPerMaxVehicleStart()!=null && this.getPerMaxVehicleEnd()!=null){
			c.andperMaxVehicleBetween(this.getPerMaxVehicleStart(), this.getPerMaxVehicleEnd());
		}else if(this.getPerMaxVehicleGreater()!=null){
			c.andperMaxVehicleGreaterThan(this.getPerMaxVehicleGreater());
		}else if(this.getPerMaxVehicleLess()!=null){
			c.andperMaxVehicleLessThan(this.getPerMaxVehicleLess());
		}
		if(this.getFileNameEquals()!=null){
			c.andfileNameEqualTo(this.getFileNameEquals());
		}else if(this.getFileNameIsNull()!=null && this.getFileNameIsNull()){
			c.andfileNameIsNull();
		}else if(this.getFileNameIsNotNull()!=null && this.getFileNameIsNotNull()){
			c.andfileNameIsNotNull();
		}else if(this.getFileNameLike()!=null){
			c.andfileNameLike(this.getFileNameLike());
		}else if(this.getFileNameIn()!=null){
			c.andfileNameIn(java.util.Arrays.asList(this.getFileNameIn()));
		}else if(this.getFileNameStart()!=null && this.getFileNameEnd()!=null){
			c.andfileNameBetween(this.getFileNameStart(), this.getFileNameEnd());
		}else if(this.getFileNameGreater()!=null){
			c.andfileNameGreaterThan(this.getFileNameGreater());
		}else if(this.getFileNameLess()!=null){
			c.andfileNameLessThan(this.getFileNameLess());
		}
		if(this.getTurnOffFlagEquals()!=null){
			c.andturnOffFlagEqualTo(this.getTurnOffFlagEquals());
		}else if(this.getTurnOffFlagIsNull()!=null && this.getTurnOffFlagIsNull()){
			c.andturnOffFlagIsNull();
		}else if(this.getTurnOffFlagIsNotNull()!=null && this.getTurnOffFlagIsNotNull()){
			c.andturnOffFlagIsNotNull();
		}else if(this.getTurnOffFlagIn()!=null){
			c.andturnOffFlagIn(java.util.Arrays.asList(this.getTurnOffFlagIn()));
		}else if(this.getTurnOffFlagStart()!=null && this.getTurnOffFlagEnd()!=null){
			c.andturnOffFlagBetween(this.getTurnOffFlagStart(), this.getTurnOffFlagEnd());
		}else if(this.getTurnOffFlagGreater()!=null){
			c.andturnOffFlagGreaterThan(this.getTurnOffFlagGreater());
		}else if(this.getTurnOffFlagLess()!=null){
			c.andturnOffFlagLessThan(this.getTurnOffFlagLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
