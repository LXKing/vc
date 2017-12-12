package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsVehicleCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsVehicleQuery {
	
	private Integer csvIdEquals;
	private Integer[] csvIdIn;
	private Boolean csvIdIsNull;
	private Boolean csvIdIsNotNull;
	
	private Integer csvIdStart;
	
	private Integer csvIdEnd;
	
	private Integer csvIdLess;
	
	private Integer csvIdGreater;
	
	private Integer csvAccessEquals;
	private Integer[] csvAccessIn;
	private Boolean csvAccessIsNull;
	private Boolean csvAccessIsNotNull;
	
	private Integer csvAccessStart;
	
	private Integer csvAccessEnd;
	
	private Integer csvAccessLess;
	
	private Integer csvAccessGreater;
	private String csvCarNoLike;
	
	private String csvCarNoEquals;
	private String[] csvCarNoIn;
	private Boolean csvCarNoIsNull;
	private Boolean csvCarNoIsNotNull;
	
	private String csvCarNoStart;
	
	private String csvCarNoEnd;
	
	private String csvCarNoLess;
	
	private String csvCarNoGreater;
	private String csvVinLike;
	
	private String csvVinEquals;
	private String[] csvVinIn;
	private Boolean csvVinIsNull;
	private Boolean csvVinIsNotNull;
	
	private String csvVinStart;
	
	private String csvVinEnd;
	
	private String csvVinLess;
	
	private String csvVinGreater;
	private String csvEngineNoLike;
	
	private String csvEngineNoEquals;
	private String[] csvEngineNoIn;
	private Boolean csvEngineNoIsNull;
	private Boolean csvEngineNoIsNotNull;
	
	private String csvEngineNoStart;
	
	private String csvEngineNoEnd;
	
	private String csvEngineNoLess;
	
	private String csvEngineNoGreater;
	private String csvCertificLike;
	
	private String csvCertificEquals;
	private String[] csvCertificIn;
	private Boolean csvCertificIsNull;
	private Boolean csvCertificIsNotNull;
	
	private String csvCertificStart;
	
	private String csvCertificEnd;
	
	private String csvCertificLess;
	
	private String csvCertificGreater;
	
	private Integer csvModelEquals;
	private Integer[] csvModelIn;
	private Boolean csvModelIsNull;
	private Boolean csvModelIsNotNull;
	
	private Integer csvModelStart;
	
	private Integer csvModelEnd;
	
	private Integer csvModelLess;
	
	private Integer csvModelGreater;
	
	private Integer csvMachineEquals;
	private Integer[] csvMachineIn;
	private Boolean csvMachineIsNull;
	private Boolean csvMachineIsNotNull;
	
	private Integer csvMachineStart;
	
	private Integer csvMachineEnd;
	
	private Integer csvMachineLess;
	
	private Integer csvMachineGreater;
	
	private Short csvColorCodeEquals;
	private Short[] csvColorCodeIn;
	private Boolean csvColorCodeIsNull;
	private Boolean csvColorCodeIsNotNull;
	
	private Short csvColorCodeStart;
	
	private Short csvColorCodeEnd;
	
	private Short csvColorCodeLess;
	
	private Short csvColorCodeGreater;
	private String csvBataccuCodeLike;
	
	private String csvBataccuCodeEquals;
	private String[] csvBataccuCodeIn;
	private Boolean csvBataccuCodeIsNull;
	private Boolean csvBataccuCodeIsNotNull;
	
	private String csvBataccuCodeStart;
	
	private String csvBataccuCodeEnd;
	
	private String csvBataccuCodeLess;
	
	private String csvBataccuCodeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd") @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date csvProdDateEquals;
	private Date[] csvProdDateIn;
	private Boolean csvProdDateIsNull;
	private Boolean csvProdDateIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd") @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date csvProdDateStart;
	@DateTimeFormat(pattern="yyyy-MM-dd") @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date csvProdDateEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd") @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date csvProdDateLess;
	@DateTimeFormat(pattern="yyyy-MM-dd") @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date csvProdDateGreater;
	private String csvLandmarkLike;
	
	private String csvLandmarkEquals;
	private String[] csvLandmarkIn;
	private Boolean csvLandmarkIsNull;
	private Boolean csvLandmarkIsNotNull;
	
	private String csvLandmarkStart;
	
	private String csvLandmarkEnd;
	
	private String csvLandmarkLess;
	
	private String csvLandmarkGreater;
	
	private Short csvDomainEquals;
	private Short[] csvDomainIn;
	private Boolean csvDomainIsNull;
	private Boolean csvDomainIsNotNull;
	
	private Short csvDomainStart;
	
	private Short csvDomainEnd;
	
	private Short csvDomainLess;
	
	private Short csvDomainGreater;
	private String csvModelCodeFullLike;
	
	private String csvModelCodeFullEquals;
	private String[] csvModelCodeFullIn;
	private Boolean csvModelCodeFullIsNull;
	private Boolean csvModelCodeFullIsNotNull;
	
	private String csvModelCodeFullStart;
	
	private String csvModelCodeFullEnd;
	
	private String csvModelCodeFullLess;
	
	private String csvModelCodeFullGreater;
	private String csvModelCodeSimpleLike;
	
	private String csvModelCodeSimpleEquals;
	private String[] csvModelCodeSimpleIn;
	private Boolean csvModelCodeSimpleIsNull;
	private Boolean csvModelCodeSimpleIsNotNull;
	
	private String csvModelCodeSimpleStart;
	
	private String csvModelCodeSimpleEnd;
	
	private String csvModelCodeSimpleLess;
	
	private String csvModelCodeSimpleGreater;
	private String csvInteriorColorCodeLike;
	
	private String csvInteriorColorCodeEquals;
	private String[] csvInteriorColorCodeIn;
	private Boolean csvInteriorColorCodeIsNull;
	private Boolean csvInteriorColorCodeIsNotNull;
	
	private String csvInteriorColorCodeStart;
	
	private String csvInteriorColorCodeEnd;
	
	private String csvInteriorColorCodeLess;
	
	private String csvInteriorColorCodeGreater;
	
	private Short csvStatusEquals;
	private Short[] csvStatusIn;
	private Boolean csvStatusIsNull;
	private Boolean csvStatusIsNotNull;
	
	private Short csvStatusStart;
	
	private Short csvStatusEnd;
	
	private Short csvStatusLess;
	
	private Short csvStatusGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvAddTimeEquals;
	private Date[] csvAddTimeIn;
	private Boolean csvAddTimeIsNull;
	private Boolean csvAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvAddTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvUpdateTimeEquals;
	private Date[] csvUpdateTimeIn;
	private Boolean csvUpdateTimeIsNull;
	private Boolean csvUpdateTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvUpdateTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvUpdateTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvUpdateTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csvUpdateTimeGreater;
	private String sidx;
	private String sord;

	public CsVehicleQuery setCsvIdEquals(Integer csvIdEquals){
		this.csvIdEquals = csvIdEquals;
		return this;
	}
	public Integer getCsvIdEquals(){
		return this.csvIdEquals;
	}
	public CsVehicleQuery setCsvIdIn(Integer[] csvIdIn){
		this.csvIdIn = csvIdIn;
		return this;
	}
	public Integer[] getCsvIdIn(){
		return this.csvIdIn;
	}
	public CsVehicleQuery setCsvIdIsNull(Boolean csvIdIsNull){
		this.csvIdIsNull = csvIdIsNull;
		return this;
	}
	public Boolean getCsvIdIsNull(){
		return this.csvIdIsNull;
	}
	public CsVehicleQuery setCsvIdIsNotNull(Boolean csvIdIsNotNull){
		this.csvIdIsNotNull = csvIdIsNotNull;
		return this;
	}
	public Boolean getCsvIdIsNotNull(){
		return this.csvIdIsNotNull;
	}
	public CsVehicleQuery setCsvIdStart(Integer csvIdStart){
		this.csvIdStart = csvIdStart;
		return this;
	}
	public Integer getCsvIdStart(){
		return this.csvIdStart;
	}
	public CsVehicleQuery setCsvIdEnd(Integer csvIdEnd){
		this.csvIdEnd = csvIdEnd;
		return this;
	}
	public Integer getCsvIdEnd(){
		return this.csvIdEnd;
	}
	public CsVehicleQuery setCsvIdLess(Integer csvIdLess){
		this.csvIdLess = csvIdLess;
		return this;
	}
	public Integer getCsvIdLess(){
		return this.csvIdLess;
	}
	public CsVehicleQuery setCsvIdGreater(Integer csvIdGreater){
		this.csvIdGreater = csvIdGreater;
		return this;
	}
	public Integer getCsvIdGreater(){
		return this.csvIdGreater;
	}
	public CsVehicleQuery setCsvAccessEquals(Integer csvAccessEquals){
		this.csvAccessEquals = csvAccessEquals;
		return this;
	}
	public Integer getCsvAccessEquals(){
		return this.csvAccessEquals;
	}
	public CsVehicleQuery setCsvAccessIn(Integer[] csvAccessIn){
		this.csvAccessIn = csvAccessIn;
		return this;
	}
	public Integer[] getCsvAccessIn(){
		return this.csvAccessIn;
	}
	public CsVehicleQuery setCsvAccessIsNull(Boolean csvAccessIsNull){
		this.csvAccessIsNull = csvAccessIsNull;
		return this;
	}
	public Boolean getCsvAccessIsNull(){
		return this.csvAccessIsNull;
	}
	public CsVehicleQuery setCsvAccessIsNotNull(Boolean csvAccessIsNotNull){
		this.csvAccessIsNotNull = csvAccessIsNotNull;
		return this;
	}
	public Boolean getCsvAccessIsNotNull(){
		return this.csvAccessIsNotNull;
	}
	public CsVehicleQuery setCsvAccessStart(Integer csvAccessStart){
		this.csvAccessStart = csvAccessStart;
		return this;
	}
	public Integer getCsvAccessStart(){
		return this.csvAccessStart;
	}
	public CsVehicleQuery setCsvAccessEnd(Integer csvAccessEnd){
		this.csvAccessEnd = csvAccessEnd;
		return this;
	}
	public Integer getCsvAccessEnd(){
		return this.csvAccessEnd;
	}
	public CsVehicleQuery setCsvAccessLess(Integer csvAccessLess){
		this.csvAccessLess = csvAccessLess;
		return this;
	}
	public Integer getCsvAccessLess(){
		return this.csvAccessLess;
	}
	public CsVehicleQuery setCsvAccessGreater(Integer csvAccessGreater){
		this.csvAccessGreater = csvAccessGreater;
		return this;
	}
	public Integer getCsvAccessGreater(){
		return this.csvAccessGreater;
	}
	public CsVehicleQuery setCsvCarNoLike(String csvCarNoLike){
		this.csvCarNoLike = csvCarNoLike;
		return this;
	}
	public String getCsvCarNoLike(){
		return this.csvCarNoLike;
	}
	public CsVehicleQuery setCsvCarNoEquals(String csvCarNoEquals){
		this.csvCarNoEquals = csvCarNoEquals;
		return this;
	}
	public String getCsvCarNoEquals(){
		return this.csvCarNoEquals;
	}
	public CsVehicleQuery setCsvCarNoIn(String[] csvCarNoIn){
		this.csvCarNoIn = csvCarNoIn;
		return this;
	}
	public String[] getCsvCarNoIn(){
		return this.csvCarNoIn;
	}
	public CsVehicleQuery setCsvCarNoIsNull(Boolean csvCarNoIsNull){
		this.csvCarNoIsNull = csvCarNoIsNull;
		return this;
	}
	public Boolean getCsvCarNoIsNull(){
		return this.csvCarNoIsNull;
	}
	public CsVehicleQuery setCsvCarNoIsNotNull(Boolean csvCarNoIsNotNull){
		this.csvCarNoIsNotNull = csvCarNoIsNotNull;
		return this;
	}
	public Boolean getCsvCarNoIsNotNull(){
		return this.csvCarNoIsNotNull;
	}
	public CsVehicleQuery setCsvCarNoStart(String csvCarNoStart){
		this.csvCarNoStart = csvCarNoStart;
		return this;
	}
	public String getCsvCarNoStart(){
		return this.csvCarNoStart;
	}
	public CsVehicleQuery setCsvCarNoEnd(String csvCarNoEnd){
		this.csvCarNoEnd = csvCarNoEnd;
		return this;
	}
	public String getCsvCarNoEnd(){
		return this.csvCarNoEnd;
	}
	public CsVehicleQuery setCsvCarNoLess(String csvCarNoLess){
		this.csvCarNoLess = csvCarNoLess;
		return this;
	}
	public String getCsvCarNoLess(){
		return this.csvCarNoLess;
	}
	public CsVehicleQuery setCsvCarNoGreater(String csvCarNoGreater){
		this.csvCarNoGreater = csvCarNoGreater;
		return this;
	}
	public String getCsvCarNoGreater(){
		return this.csvCarNoGreater;
	}
	public CsVehicleQuery setCsvVinLike(String csvVinLike){
		this.csvVinLike = csvVinLike;
		return this;
	}
	public String getCsvVinLike(){
		return this.csvVinLike;
	}
	public CsVehicleQuery setCsvVinEquals(String csvVinEquals){
		this.csvVinEquals = csvVinEquals;
		return this;
	}
	public String getCsvVinEquals(){
		return this.csvVinEquals;
	}
	public CsVehicleQuery setCsvVinIn(String[] csvVinIn){
		this.csvVinIn = csvVinIn;
		return this;
	}
	public String[] getCsvVinIn(){
		return this.csvVinIn;
	}
	public CsVehicleQuery setCsvVinIsNull(Boolean csvVinIsNull){
		this.csvVinIsNull = csvVinIsNull;
		return this;
	}
	public Boolean getCsvVinIsNull(){
		return this.csvVinIsNull;
	}
	public CsVehicleQuery setCsvVinIsNotNull(Boolean csvVinIsNotNull){
		this.csvVinIsNotNull = csvVinIsNotNull;
		return this;
	}
	public Boolean getCsvVinIsNotNull(){
		return this.csvVinIsNotNull;
	}
	public CsVehicleQuery setCsvVinStart(String csvVinStart){
		this.csvVinStart = csvVinStart;
		return this;
	}
	public String getCsvVinStart(){
		return this.csvVinStart;
	}
	public CsVehicleQuery setCsvVinEnd(String csvVinEnd){
		this.csvVinEnd = csvVinEnd;
		return this;
	}
	public String getCsvVinEnd(){
		return this.csvVinEnd;
	}
	public CsVehicleQuery setCsvVinLess(String csvVinLess){
		this.csvVinLess = csvVinLess;
		return this;
	}
	public String getCsvVinLess(){
		return this.csvVinLess;
	}
	public CsVehicleQuery setCsvVinGreater(String csvVinGreater){
		this.csvVinGreater = csvVinGreater;
		return this;
	}
	public String getCsvVinGreater(){
		return this.csvVinGreater;
	}
	public CsVehicleQuery setCsvEngineNoLike(String csvEngineNoLike){
		this.csvEngineNoLike = csvEngineNoLike;
		return this;
	}
	public String getCsvEngineNoLike(){
		return this.csvEngineNoLike;
	}
	public CsVehicleQuery setCsvEngineNoEquals(String csvEngineNoEquals){
		this.csvEngineNoEquals = csvEngineNoEquals;
		return this;
	}
	public String getCsvEngineNoEquals(){
		return this.csvEngineNoEquals;
	}
	public CsVehicleQuery setCsvEngineNoIn(String[] csvEngineNoIn){
		this.csvEngineNoIn = csvEngineNoIn;
		return this;
	}
	public String[] getCsvEngineNoIn(){
		return this.csvEngineNoIn;
	}
	public CsVehicleQuery setCsvEngineNoIsNull(Boolean csvEngineNoIsNull){
		this.csvEngineNoIsNull = csvEngineNoIsNull;
		return this;
	}
	public Boolean getCsvEngineNoIsNull(){
		return this.csvEngineNoIsNull;
	}
	public CsVehicleQuery setCsvEngineNoIsNotNull(Boolean csvEngineNoIsNotNull){
		this.csvEngineNoIsNotNull = csvEngineNoIsNotNull;
		return this;
	}
	public Boolean getCsvEngineNoIsNotNull(){
		return this.csvEngineNoIsNotNull;
	}
	public CsVehicleQuery setCsvEngineNoStart(String csvEngineNoStart){
		this.csvEngineNoStart = csvEngineNoStart;
		return this;
	}
	public String getCsvEngineNoStart(){
		return this.csvEngineNoStart;
	}
	public CsVehicleQuery setCsvEngineNoEnd(String csvEngineNoEnd){
		this.csvEngineNoEnd = csvEngineNoEnd;
		return this;
	}
	public String getCsvEngineNoEnd(){
		return this.csvEngineNoEnd;
	}
	public CsVehicleQuery setCsvEngineNoLess(String csvEngineNoLess){
		this.csvEngineNoLess = csvEngineNoLess;
		return this;
	}
	public String getCsvEngineNoLess(){
		return this.csvEngineNoLess;
	}
	public CsVehicleQuery setCsvEngineNoGreater(String csvEngineNoGreater){
		this.csvEngineNoGreater = csvEngineNoGreater;
		return this;
	}
	public String getCsvEngineNoGreater(){
		return this.csvEngineNoGreater;
	}
	public CsVehicleQuery setCsvCertificLike(String csvCertificLike){
		this.csvCertificLike = csvCertificLike;
		return this;
	}
	public String getCsvCertificLike(){
		return this.csvCertificLike;
	}
	public CsVehicleQuery setCsvCertificEquals(String csvCertificEquals){
		this.csvCertificEquals = csvCertificEquals;
		return this;
	}
	public String getCsvCertificEquals(){
		return this.csvCertificEquals;
	}
	public CsVehicleQuery setCsvCertificIn(String[] csvCertificIn){
		this.csvCertificIn = csvCertificIn;
		return this;
	}
	public String[] getCsvCertificIn(){
		return this.csvCertificIn;
	}
	public CsVehicleQuery setCsvCertificIsNull(Boolean csvCertificIsNull){
		this.csvCertificIsNull = csvCertificIsNull;
		return this;
	}
	public Boolean getCsvCertificIsNull(){
		return this.csvCertificIsNull;
	}
	public CsVehicleQuery setCsvCertificIsNotNull(Boolean csvCertificIsNotNull){
		this.csvCertificIsNotNull = csvCertificIsNotNull;
		return this;
	}
	public Boolean getCsvCertificIsNotNull(){
		return this.csvCertificIsNotNull;
	}
	public CsVehicleQuery setCsvCertificStart(String csvCertificStart){
		this.csvCertificStart = csvCertificStart;
		return this;
	}
	public String getCsvCertificStart(){
		return this.csvCertificStart;
	}
	public CsVehicleQuery setCsvCertificEnd(String csvCertificEnd){
		this.csvCertificEnd = csvCertificEnd;
		return this;
	}
	public String getCsvCertificEnd(){
		return this.csvCertificEnd;
	}
	public CsVehicleQuery setCsvCertificLess(String csvCertificLess){
		this.csvCertificLess = csvCertificLess;
		return this;
	}
	public String getCsvCertificLess(){
		return this.csvCertificLess;
	}
	public CsVehicleQuery setCsvCertificGreater(String csvCertificGreater){
		this.csvCertificGreater = csvCertificGreater;
		return this;
	}
	public String getCsvCertificGreater(){
		return this.csvCertificGreater;
	}
	public CsVehicleQuery setCsvModelEquals(Integer csvModelEquals){
		this.csvModelEquals = csvModelEquals;
		return this;
	}
	public Integer getCsvModelEquals(){
		return this.csvModelEquals;
	}
	public CsVehicleQuery setCsvModelIn(Integer[] csvModelIn){
		this.csvModelIn = csvModelIn;
		return this;
	}
	public Integer[] getCsvModelIn(){
		return this.csvModelIn;
	}
	public CsVehicleQuery setCsvModelIsNull(Boolean csvModelIsNull){
		this.csvModelIsNull = csvModelIsNull;
		return this;
	}
	public Boolean getCsvModelIsNull(){
		return this.csvModelIsNull;
	}
	public CsVehicleQuery setCsvModelIsNotNull(Boolean csvModelIsNotNull){
		this.csvModelIsNotNull = csvModelIsNotNull;
		return this;
	}
	public Boolean getCsvModelIsNotNull(){
		return this.csvModelIsNotNull;
	}
	public CsVehicleQuery setCsvModelStart(Integer csvModelStart){
		this.csvModelStart = csvModelStart;
		return this;
	}
	public Integer getCsvModelStart(){
		return this.csvModelStart;
	}
	public CsVehicleQuery setCsvModelEnd(Integer csvModelEnd){
		this.csvModelEnd = csvModelEnd;
		return this;
	}
	public Integer getCsvModelEnd(){
		return this.csvModelEnd;
	}
	public CsVehicleQuery setCsvModelLess(Integer csvModelLess){
		this.csvModelLess = csvModelLess;
		return this;
	}
	public Integer getCsvModelLess(){
		return this.csvModelLess;
	}
	public CsVehicleQuery setCsvModelGreater(Integer csvModelGreater){
		this.csvModelGreater = csvModelGreater;
		return this;
	}
	public Integer getCsvModelGreater(){
		return this.csvModelGreater;
	}
	public CsVehicleQuery setCsvMachineEquals(Integer csvMachineEquals){
		this.csvMachineEquals = csvMachineEquals;
		return this;
	}
	public Integer getCsvMachineEquals(){
		return this.csvMachineEquals;
	}
	public CsVehicleQuery setCsvMachineIn(Integer[] csvMachineIn){
		this.csvMachineIn = csvMachineIn;
		return this;
	}
	public Integer[] getCsvMachineIn(){
		return this.csvMachineIn;
	}
	public CsVehicleQuery setCsvMachineIsNull(Boolean csvMachineIsNull){
		this.csvMachineIsNull = csvMachineIsNull;
		return this;
	}
	public Boolean getCsvMachineIsNull(){
		return this.csvMachineIsNull;
	}
	public CsVehicleQuery setCsvMachineIsNotNull(Boolean csvMachineIsNotNull){
		this.csvMachineIsNotNull = csvMachineIsNotNull;
		return this;
	}
	public Boolean getCsvMachineIsNotNull(){
		return this.csvMachineIsNotNull;
	}
	public CsVehicleQuery setCsvMachineStart(Integer csvMachineStart){
		this.csvMachineStart = csvMachineStart;
		return this;
	}
	public Integer getCsvMachineStart(){
		return this.csvMachineStart;
	}
	public CsVehicleQuery setCsvMachineEnd(Integer csvMachineEnd){
		this.csvMachineEnd = csvMachineEnd;
		return this;
	}
	public Integer getCsvMachineEnd(){
		return this.csvMachineEnd;
	}
	public CsVehicleQuery setCsvMachineLess(Integer csvMachineLess){
		this.csvMachineLess = csvMachineLess;
		return this;
	}
	public Integer getCsvMachineLess(){
		return this.csvMachineLess;
	}
	public CsVehicleQuery setCsvMachineGreater(Integer csvMachineGreater){
		this.csvMachineGreater = csvMachineGreater;
		return this;
	}
	public Integer getCsvMachineGreater(){
		return this.csvMachineGreater;
	}
	public CsVehicleQuery setCsvColorCodeEquals(Short csvColorCodeEquals){
		this.csvColorCodeEquals = csvColorCodeEquals;
		return this;
	}
	public Short getCsvColorCodeEquals(){
		return this.csvColorCodeEquals;
	}
	public CsVehicleQuery setCsvColorCodeIn(Short[] csvColorCodeIn){
		this.csvColorCodeIn = csvColorCodeIn;
		return this;
	}
	public Short[] getCsvColorCodeIn(){
		return this.csvColorCodeIn;
	}
	public CsVehicleQuery setCsvColorCodeIsNull(Boolean csvColorCodeIsNull){
		this.csvColorCodeIsNull = csvColorCodeIsNull;
		return this;
	}
	public Boolean getCsvColorCodeIsNull(){
		return this.csvColorCodeIsNull;
	}
	public CsVehicleQuery setCsvColorCodeIsNotNull(Boolean csvColorCodeIsNotNull){
		this.csvColorCodeIsNotNull = csvColorCodeIsNotNull;
		return this;
	}
	public Boolean getCsvColorCodeIsNotNull(){
		return this.csvColorCodeIsNotNull;
	}
	public CsVehicleQuery setCsvColorCodeStart(Short csvColorCodeStart){
		this.csvColorCodeStart = csvColorCodeStart;
		return this;
	}
	public Short getCsvColorCodeStart(){
		return this.csvColorCodeStart;
	}
	public CsVehicleQuery setCsvColorCodeEnd(Short csvColorCodeEnd){
		this.csvColorCodeEnd = csvColorCodeEnd;
		return this;
	}
	public Short getCsvColorCodeEnd(){
		return this.csvColorCodeEnd;
	}
	public CsVehicleQuery setCsvColorCodeLess(Short csvColorCodeLess){
		this.csvColorCodeLess = csvColorCodeLess;
		return this;
	}
	public Short getCsvColorCodeLess(){
		return this.csvColorCodeLess;
	}
	public CsVehicleQuery setCsvColorCodeGreater(Short csvColorCodeGreater){
		this.csvColorCodeGreater = csvColorCodeGreater;
		return this;
	}
	public Short getCsvColorCodeGreater(){
		return this.csvColorCodeGreater;
	}
	public CsVehicleQuery setCsvBataccuCodeLike(String csvBataccuCodeLike){
		this.csvBataccuCodeLike = csvBataccuCodeLike;
		return this;
	}
	public String getCsvBataccuCodeLike(){
		return this.csvBataccuCodeLike;
	}
	public CsVehicleQuery setCsvBataccuCodeEquals(String csvBataccuCodeEquals){
		this.csvBataccuCodeEquals = csvBataccuCodeEquals;
		return this;
	}
	public String getCsvBataccuCodeEquals(){
		return this.csvBataccuCodeEquals;
	}
	public CsVehicleQuery setCsvBataccuCodeIn(String[] csvBataccuCodeIn){
		this.csvBataccuCodeIn = csvBataccuCodeIn;
		return this;
	}
	public String[] getCsvBataccuCodeIn(){
		return this.csvBataccuCodeIn;
	}
	public CsVehicleQuery setCsvBataccuCodeIsNull(Boolean csvBataccuCodeIsNull){
		this.csvBataccuCodeIsNull = csvBataccuCodeIsNull;
		return this;
	}
	public Boolean getCsvBataccuCodeIsNull(){
		return this.csvBataccuCodeIsNull;
	}
	public CsVehicleQuery setCsvBataccuCodeIsNotNull(Boolean csvBataccuCodeIsNotNull){
		this.csvBataccuCodeIsNotNull = csvBataccuCodeIsNotNull;
		return this;
	}
	public Boolean getCsvBataccuCodeIsNotNull(){
		return this.csvBataccuCodeIsNotNull;
	}
	public CsVehicleQuery setCsvBataccuCodeStart(String csvBataccuCodeStart){
		this.csvBataccuCodeStart = csvBataccuCodeStart;
		return this;
	}
	public String getCsvBataccuCodeStart(){
		return this.csvBataccuCodeStart;
	}
	public CsVehicleQuery setCsvBataccuCodeEnd(String csvBataccuCodeEnd){
		this.csvBataccuCodeEnd = csvBataccuCodeEnd;
		return this;
	}
	public String getCsvBataccuCodeEnd(){
		return this.csvBataccuCodeEnd;
	}
	public CsVehicleQuery setCsvBataccuCodeLess(String csvBataccuCodeLess){
		this.csvBataccuCodeLess = csvBataccuCodeLess;
		return this;
	}
	public String getCsvBataccuCodeLess(){
		return this.csvBataccuCodeLess;
	}
	public CsVehicleQuery setCsvBataccuCodeGreater(String csvBataccuCodeGreater){
		this.csvBataccuCodeGreater = csvBataccuCodeGreater;
		return this;
	}
	public String getCsvBataccuCodeGreater(){
		return this.csvBataccuCodeGreater;
	}
	public CsVehicleQuery setCsvProdDateEquals(Date csvProdDateEquals){
		this.csvProdDateEquals = csvProdDateEquals;
		return this;
	}
	public Date getCsvProdDateEquals(){
		return this.csvProdDateEquals;
	}
	public CsVehicleQuery setCsvProdDateIn(Date[] csvProdDateIn){
		this.csvProdDateIn = csvProdDateIn;
		return this;
	}
	public Date[] getCsvProdDateIn(){
		return this.csvProdDateIn;
	}
	public CsVehicleQuery setCsvProdDateIsNull(Boolean csvProdDateIsNull){
		this.csvProdDateIsNull = csvProdDateIsNull;
		return this;
	}
	public Boolean getCsvProdDateIsNull(){
		return this.csvProdDateIsNull;
	}
	public CsVehicleQuery setCsvProdDateIsNotNull(Boolean csvProdDateIsNotNull){
		this.csvProdDateIsNotNull = csvProdDateIsNotNull;
		return this;
	}
	public Boolean getCsvProdDateIsNotNull(){
		return this.csvProdDateIsNotNull;
	}
	public CsVehicleQuery setCsvProdDateStart(Date csvProdDateStart){
		this.csvProdDateStart = csvProdDateStart;
		return this;
	}
	public Date getCsvProdDateStart(){
		return this.csvProdDateStart;
	}
	public CsVehicleQuery setCsvProdDateEnd(Date csvProdDateEnd){
		this.csvProdDateEnd = csvProdDateEnd;
		return this;
	}
	public Date getCsvProdDateEnd(){
		return this.csvProdDateEnd;
	}
	public CsVehicleQuery setCsvProdDateLess(Date csvProdDateLess){
		this.csvProdDateLess = csvProdDateLess;
		return this;
	}
	public Date getCsvProdDateLess(){
		return this.csvProdDateLess;
	}
	public CsVehicleQuery setCsvProdDateGreater(Date csvProdDateGreater){
		this.csvProdDateGreater = csvProdDateGreater;
		return this;
	}
	public Date getCsvProdDateGreater(){
		return this.csvProdDateGreater;
	}
	public CsVehicleQuery setCsvLandmarkLike(String csvLandmarkLike){
		this.csvLandmarkLike = csvLandmarkLike;
		return this;
	}
	public String getCsvLandmarkLike(){
		return this.csvLandmarkLike;
	}
	public CsVehicleQuery setCsvLandmarkEquals(String csvLandmarkEquals){
		this.csvLandmarkEquals = csvLandmarkEquals;
		return this;
	}
	public String getCsvLandmarkEquals(){
		return this.csvLandmarkEquals;
	}
	public CsVehicleQuery setCsvLandmarkIn(String[] csvLandmarkIn){
		this.csvLandmarkIn = csvLandmarkIn;
		return this;
	}
	public String[] getCsvLandmarkIn(){
		return this.csvLandmarkIn;
	}
	public CsVehicleQuery setCsvLandmarkIsNull(Boolean csvLandmarkIsNull){
		this.csvLandmarkIsNull = csvLandmarkIsNull;
		return this;
	}
	public Boolean getCsvLandmarkIsNull(){
		return this.csvLandmarkIsNull;
	}
	public CsVehicleQuery setCsvLandmarkIsNotNull(Boolean csvLandmarkIsNotNull){
		this.csvLandmarkIsNotNull = csvLandmarkIsNotNull;
		return this;
	}
	public Boolean getCsvLandmarkIsNotNull(){
		return this.csvLandmarkIsNotNull;
	}
	public CsVehicleQuery setCsvLandmarkStart(String csvLandmarkStart){
		this.csvLandmarkStart = csvLandmarkStart;
		return this;
	}
	public String getCsvLandmarkStart(){
		return this.csvLandmarkStart;
	}
	public CsVehicleQuery setCsvLandmarkEnd(String csvLandmarkEnd){
		this.csvLandmarkEnd = csvLandmarkEnd;
		return this;
	}
	public String getCsvLandmarkEnd(){
		return this.csvLandmarkEnd;
	}
	public CsVehicleQuery setCsvLandmarkLess(String csvLandmarkLess){
		this.csvLandmarkLess = csvLandmarkLess;
		return this;
	}
	public String getCsvLandmarkLess(){
		return this.csvLandmarkLess;
	}
	public CsVehicleQuery setCsvLandmarkGreater(String csvLandmarkGreater){
		this.csvLandmarkGreater = csvLandmarkGreater;
		return this;
	}
	public String getCsvLandmarkGreater(){
		return this.csvLandmarkGreater;
	}
	public CsVehicleQuery setCsvDomainEquals(Short csvDomainEquals){
		this.csvDomainEquals = csvDomainEquals;
		return this;
	}
	public Short getCsvDomainEquals(){
		return this.csvDomainEquals;
	}
	public CsVehicleQuery setCsvDomainIn(Short[] csvDomainIn){
		this.csvDomainIn = csvDomainIn;
		return this;
	}
	public Short[] getCsvDomainIn(){
		return this.csvDomainIn;
	}
	public CsVehicleQuery setCsvDomainIsNull(Boolean csvDomainIsNull){
		this.csvDomainIsNull = csvDomainIsNull;
		return this;
	}
	public Boolean getCsvDomainIsNull(){
		return this.csvDomainIsNull;
	}
	public CsVehicleQuery setCsvDomainIsNotNull(Boolean csvDomainIsNotNull){
		this.csvDomainIsNotNull = csvDomainIsNotNull;
		return this;
	}
	public Boolean getCsvDomainIsNotNull(){
		return this.csvDomainIsNotNull;
	}
	public CsVehicleQuery setCsvDomainStart(Short csvDomainStart){
		this.csvDomainStart = csvDomainStart;
		return this;
	}
	public Short getCsvDomainStart(){
		return this.csvDomainStart;
	}
	public CsVehicleQuery setCsvDomainEnd(Short csvDomainEnd){
		this.csvDomainEnd = csvDomainEnd;
		return this;
	}
	public Short getCsvDomainEnd(){
		return this.csvDomainEnd;
	}
	public CsVehicleQuery setCsvDomainLess(Short csvDomainLess){
		this.csvDomainLess = csvDomainLess;
		return this;
	}
	public Short getCsvDomainLess(){
		return this.csvDomainLess;
	}
	public CsVehicleQuery setCsvDomainGreater(Short csvDomainGreater){
		this.csvDomainGreater = csvDomainGreater;
		return this;
	}
	public Short getCsvDomainGreater(){
		return this.csvDomainGreater;
	}
	public CsVehicleQuery setCsvModelCodeFullLike(String csvModelCodeFullLike){
		this.csvModelCodeFullLike = csvModelCodeFullLike;
		return this;
	}
	public String getCsvModelCodeFullLike(){
		return this.csvModelCodeFullLike;
	}
	public CsVehicleQuery setCsvModelCodeFullEquals(String csvModelCodeFullEquals){
		this.csvModelCodeFullEquals = csvModelCodeFullEquals;
		return this;
	}
	public String getCsvModelCodeFullEquals(){
		return this.csvModelCodeFullEquals;
	}
	public CsVehicleQuery setCsvModelCodeFullIn(String[] csvModelCodeFullIn){
		this.csvModelCodeFullIn = csvModelCodeFullIn;
		return this;
	}
	public String[] getCsvModelCodeFullIn(){
		return this.csvModelCodeFullIn;
	}
	public CsVehicleQuery setCsvModelCodeFullIsNull(Boolean csvModelCodeFullIsNull){
		this.csvModelCodeFullIsNull = csvModelCodeFullIsNull;
		return this;
	}
	public Boolean getCsvModelCodeFullIsNull(){
		return this.csvModelCodeFullIsNull;
	}
	public CsVehicleQuery setCsvModelCodeFullIsNotNull(Boolean csvModelCodeFullIsNotNull){
		this.csvModelCodeFullIsNotNull = csvModelCodeFullIsNotNull;
		return this;
	}
	public Boolean getCsvModelCodeFullIsNotNull(){
		return this.csvModelCodeFullIsNotNull;
	}
	public CsVehicleQuery setCsvModelCodeFullStart(String csvModelCodeFullStart){
		this.csvModelCodeFullStart = csvModelCodeFullStart;
		return this;
	}
	public String getCsvModelCodeFullStart(){
		return this.csvModelCodeFullStart;
	}
	public CsVehicleQuery setCsvModelCodeFullEnd(String csvModelCodeFullEnd){
		this.csvModelCodeFullEnd = csvModelCodeFullEnd;
		return this;
	}
	public String getCsvModelCodeFullEnd(){
		return this.csvModelCodeFullEnd;
	}
	public CsVehicleQuery setCsvModelCodeFullLess(String csvModelCodeFullLess){
		this.csvModelCodeFullLess = csvModelCodeFullLess;
		return this;
	}
	public String getCsvModelCodeFullLess(){
		return this.csvModelCodeFullLess;
	}
	public CsVehicleQuery setCsvModelCodeFullGreater(String csvModelCodeFullGreater){
		this.csvModelCodeFullGreater = csvModelCodeFullGreater;
		return this;
	}
	public String getCsvModelCodeFullGreater(){
		return this.csvModelCodeFullGreater;
	}
	public CsVehicleQuery setCsvModelCodeSimpleLike(String csvModelCodeSimpleLike){
		this.csvModelCodeSimpleLike = csvModelCodeSimpleLike;
		return this;
	}
	public String getCsvModelCodeSimpleLike(){
		return this.csvModelCodeSimpleLike;
	}
	public CsVehicleQuery setCsvModelCodeSimpleEquals(String csvModelCodeSimpleEquals){
		this.csvModelCodeSimpleEquals = csvModelCodeSimpleEquals;
		return this;
	}
	public String getCsvModelCodeSimpleEquals(){
		return this.csvModelCodeSimpleEquals;
	}
	public CsVehicleQuery setCsvModelCodeSimpleIn(String[] csvModelCodeSimpleIn){
		this.csvModelCodeSimpleIn = csvModelCodeSimpleIn;
		return this;
	}
	public String[] getCsvModelCodeSimpleIn(){
		return this.csvModelCodeSimpleIn;
	}
	public CsVehicleQuery setCsvModelCodeSimpleIsNull(Boolean csvModelCodeSimpleIsNull){
		this.csvModelCodeSimpleIsNull = csvModelCodeSimpleIsNull;
		return this;
	}
	public Boolean getCsvModelCodeSimpleIsNull(){
		return this.csvModelCodeSimpleIsNull;
	}
	public CsVehicleQuery setCsvModelCodeSimpleIsNotNull(Boolean csvModelCodeSimpleIsNotNull){
		this.csvModelCodeSimpleIsNotNull = csvModelCodeSimpleIsNotNull;
		return this;
	}
	public Boolean getCsvModelCodeSimpleIsNotNull(){
		return this.csvModelCodeSimpleIsNotNull;
	}
	public CsVehicleQuery setCsvModelCodeSimpleStart(String csvModelCodeSimpleStart){
		this.csvModelCodeSimpleStart = csvModelCodeSimpleStart;
		return this;
	}
	public String getCsvModelCodeSimpleStart(){
		return this.csvModelCodeSimpleStart;
	}
	public CsVehicleQuery setCsvModelCodeSimpleEnd(String csvModelCodeSimpleEnd){
		this.csvModelCodeSimpleEnd = csvModelCodeSimpleEnd;
		return this;
	}
	public String getCsvModelCodeSimpleEnd(){
		return this.csvModelCodeSimpleEnd;
	}
	public CsVehicleQuery setCsvModelCodeSimpleLess(String csvModelCodeSimpleLess){
		this.csvModelCodeSimpleLess = csvModelCodeSimpleLess;
		return this;
	}
	public String getCsvModelCodeSimpleLess(){
		return this.csvModelCodeSimpleLess;
	}
	public CsVehicleQuery setCsvModelCodeSimpleGreater(String csvModelCodeSimpleGreater){
		this.csvModelCodeSimpleGreater = csvModelCodeSimpleGreater;
		return this;
	}
	public String getCsvModelCodeSimpleGreater(){
		return this.csvModelCodeSimpleGreater;
	}
	public CsVehicleQuery setCsvInteriorColorCodeLike(String csvInteriorColorCodeLike){
		this.csvInteriorColorCodeLike = csvInteriorColorCodeLike;
		return this;
	}
	public String getCsvInteriorColorCodeLike(){
		return this.csvInteriorColorCodeLike;
	}
	public CsVehicleQuery setCsvInteriorColorCodeEquals(String csvInteriorColorCodeEquals){
		this.csvInteriorColorCodeEquals = csvInteriorColorCodeEquals;
		return this;
	}
	public String getCsvInteriorColorCodeEquals(){
		return this.csvInteriorColorCodeEquals;
	}
	public CsVehicleQuery setCsvInteriorColorCodeIn(String[] csvInteriorColorCodeIn){
		this.csvInteriorColorCodeIn = csvInteriorColorCodeIn;
		return this;
	}
	public String[] getCsvInteriorColorCodeIn(){
		return this.csvInteriorColorCodeIn;
	}
	public CsVehicleQuery setCsvInteriorColorCodeIsNull(Boolean csvInteriorColorCodeIsNull){
		this.csvInteriorColorCodeIsNull = csvInteriorColorCodeIsNull;
		return this;
	}
	public Boolean getCsvInteriorColorCodeIsNull(){
		return this.csvInteriorColorCodeIsNull;
	}
	public CsVehicleQuery setCsvInteriorColorCodeIsNotNull(Boolean csvInteriorColorCodeIsNotNull){
		this.csvInteriorColorCodeIsNotNull = csvInteriorColorCodeIsNotNull;
		return this;
	}
	public Boolean getCsvInteriorColorCodeIsNotNull(){
		return this.csvInteriorColorCodeIsNotNull;
	}
	public CsVehicleQuery setCsvInteriorColorCodeStart(String csvInteriorColorCodeStart){
		this.csvInteriorColorCodeStart = csvInteriorColorCodeStart;
		return this;
	}
	public String getCsvInteriorColorCodeStart(){
		return this.csvInteriorColorCodeStart;
	}
	public CsVehicleQuery setCsvInteriorColorCodeEnd(String csvInteriorColorCodeEnd){
		this.csvInteriorColorCodeEnd = csvInteriorColorCodeEnd;
		return this;
	}
	public String getCsvInteriorColorCodeEnd(){
		return this.csvInteriorColorCodeEnd;
	}
	public CsVehicleQuery setCsvInteriorColorCodeLess(String csvInteriorColorCodeLess){
		this.csvInteriorColorCodeLess = csvInteriorColorCodeLess;
		return this;
	}
	public String getCsvInteriorColorCodeLess(){
		return this.csvInteriorColorCodeLess;
	}
	public CsVehicleQuery setCsvInteriorColorCodeGreater(String csvInteriorColorCodeGreater){
		this.csvInteriorColorCodeGreater = csvInteriorColorCodeGreater;
		return this;
	}
	public String getCsvInteriorColorCodeGreater(){
		return this.csvInteriorColorCodeGreater;
	}
	public CsVehicleQuery setCsvStatusEquals(Short csvStatusEquals){
		this.csvStatusEquals = csvStatusEquals;
		return this;
	}
	public Short getCsvStatusEquals(){
		return this.csvStatusEquals;
	}
	public CsVehicleQuery setCsvStatusIn(Short[] csvStatusIn){
		this.csvStatusIn = csvStatusIn;
		return this;
	}
	public Short[] getCsvStatusIn(){
		return this.csvStatusIn;
	}
	public CsVehicleQuery setCsvStatusIsNull(Boolean csvStatusIsNull){
		this.csvStatusIsNull = csvStatusIsNull;
		return this;
	}
	public Boolean getCsvStatusIsNull(){
		return this.csvStatusIsNull;
	}
	public CsVehicleQuery setCsvStatusIsNotNull(Boolean csvStatusIsNotNull){
		this.csvStatusIsNotNull = csvStatusIsNotNull;
		return this;
	}
	public Boolean getCsvStatusIsNotNull(){
		return this.csvStatusIsNotNull;
	}
	public CsVehicleQuery setCsvStatusStart(Short csvStatusStart){
		this.csvStatusStart = csvStatusStart;
		return this;
	}
	public Short getCsvStatusStart(){
		return this.csvStatusStart;
	}
	public CsVehicleQuery setCsvStatusEnd(Short csvStatusEnd){
		this.csvStatusEnd = csvStatusEnd;
		return this;
	}
	public Short getCsvStatusEnd(){
		return this.csvStatusEnd;
	}
	public CsVehicleQuery setCsvStatusLess(Short csvStatusLess){
		this.csvStatusLess = csvStatusLess;
		return this;
	}
	public Short getCsvStatusLess(){
		return this.csvStatusLess;
	}
	public CsVehicleQuery setCsvStatusGreater(Short csvStatusGreater){
		this.csvStatusGreater = csvStatusGreater;
		return this;
	}
	public Short getCsvStatusGreater(){
		return this.csvStatusGreater;
	}
	public CsVehicleQuery setCsvAddTimeEquals(Date csvAddTimeEquals){
		this.csvAddTimeEquals = csvAddTimeEquals;
		return this;
	}
	public Date getCsvAddTimeEquals(){
		return this.csvAddTimeEquals;
	}
	public CsVehicleQuery setCsvAddTimeIn(Date[] csvAddTimeIn){
		this.csvAddTimeIn = csvAddTimeIn;
		return this;
	}
	public Date[] getCsvAddTimeIn(){
		return this.csvAddTimeIn;
	}
	public CsVehicleQuery setCsvAddTimeIsNull(Boolean csvAddTimeIsNull){
		this.csvAddTimeIsNull = csvAddTimeIsNull;
		return this;
	}
	public Boolean getCsvAddTimeIsNull(){
		return this.csvAddTimeIsNull;
	}
	public CsVehicleQuery setCsvAddTimeIsNotNull(Boolean csvAddTimeIsNotNull){
		this.csvAddTimeIsNotNull = csvAddTimeIsNotNull;
		return this;
	}
	public Boolean getCsvAddTimeIsNotNull(){
		return this.csvAddTimeIsNotNull;
	}
	public CsVehicleQuery setCsvAddTimeStart(Date csvAddTimeStart){
		this.csvAddTimeStart = csvAddTimeStart;
		return this;
	}
	public Date getCsvAddTimeStart(){
		return this.csvAddTimeStart;
	}
	public CsVehicleQuery setCsvAddTimeEnd(Date csvAddTimeEnd){
		this.csvAddTimeEnd = csvAddTimeEnd;
		return this;
	}
	public Date getCsvAddTimeEnd(){
		return this.csvAddTimeEnd;
	}
	public CsVehicleQuery setCsvAddTimeLess(Date csvAddTimeLess){
		this.csvAddTimeLess = csvAddTimeLess;
		return this;
	}
	public Date getCsvAddTimeLess(){
		return this.csvAddTimeLess;
	}
	public CsVehicleQuery setCsvAddTimeGreater(Date csvAddTimeGreater){
		this.csvAddTimeGreater = csvAddTimeGreater;
		return this;
	}
	public Date getCsvAddTimeGreater(){
		return this.csvAddTimeGreater;
	}
	public CsVehicleQuery setCsvUpdateTimeEquals(Date csvUpdateTimeEquals){
		this.csvUpdateTimeEquals = csvUpdateTimeEquals;
		return this;
	}
	public Date getCsvUpdateTimeEquals(){
		return this.csvUpdateTimeEquals;
	}
	public CsVehicleQuery setCsvUpdateTimeIn(Date[] csvUpdateTimeIn){
		this.csvUpdateTimeIn = csvUpdateTimeIn;
		return this;
	}
	public Date[] getCsvUpdateTimeIn(){
		return this.csvUpdateTimeIn;
	}
	public CsVehicleQuery setCsvUpdateTimeIsNull(Boolean csvUpdateTimeIsNull){
		this.csvUpdateTimeIsNull = csvUpdateTimeIsNull;
		return this;
	}
	public Boolean getCsvUpdateTimeIsNull(){
		return this.csvUpdateTimeIsNull;
	}
	public CsVehicleQuery setCsvUpdateTimeIsNotNull(Boolean csvUpdateTimeIsNotNull){
		this.csvUpdateTimeIsNotNull = csvUpdateTimeIsNotNull;
		return this;
	}
	public Boolean getCsvUpdateTimeIsNotNull(){
		return this.csvUpdateTimeIsNotNull;
	}
	public CsVehicleQuery setCsvUpdateTimeStart(Date csvUpdateTimeStart){
		this.csvUpdateTimeStart = csvUpdateTimeStart;
		return this;
	}
	public Date getCsvUpdateTimeStart(){
		return this.csvUpdateTimeStart;
	}
	public CsVehicleQuery setCsvUpdateTimeEnd(Date csvUpdateTimeEnd){
		this.csvUpdateTimeEnd = csvUpdateTimeEnd;
		return this;
	}
	public Date getCsvUpdateTimeEnd(){
		return this.csvUpdateTimeEnd;
	}
	public CsVehicleQuery setCsvUpdateTimeLess(Date csvUpdateTimeLess){
		this.csvUpdateTimeLess = csvUpdateTimeLess;
		return this;
	}
	public Date getCsvUpdateTimeLess(){
		return this.csvUpdateTimeLess;
	}
	public CsVehicleQuery setCsvUpdateTimeGreater(Date csvUpdateTimeGreater){
		this.csvUpdateTimeGreater = csvUpdateTimeGreater;
		return this;
	}
	public Date getCsvUpdateTimeGreater(){
		return this.csvUpdateTimeGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("csvId")){
			return "csv_id";
		}
		else if(this.sidx.equals("csvAccess")){
			return "csv_access";
		}
		else if(this.sidx.equals("csvCarNo")){
			return "csv_car_no";
		}
		else if(this.sidx.equals("csvVin")){
			return "csv_vin";
		}
		else if(this.sidx.equals("csvEngineNo")){
			return "csv_engine_no";
		}
		else if(this.sidx.equals("csvCertific")){
			return "csv_certific";
		}
		else if(this.sidx.equals("csvModel")){
			return "csv_model";
		}
		else if(this.sidx.equals("csvMachine")){
			return "csv_machine";
		}
		else if(this.sidx.equals("csvColorCode")){
			return "csv_color_code";
		}
		else if(this.sidx.equals("csvBataccuCode")){
			return "csv_bataccu_code";
		}
		else if(this.sidx.equals("csvProdDate")){
			return "csv_prod_date";
		}
		else if(this.sidx.equals("csvLandmark")){
			return "csv_landmark";
		}
		else if(this.sidx.equals("csvDomain")){
			return "csv_domain";
		}
		else if(this.sidx.equals("csvModelCodeFull")){
			return "csv_model_code_full";
		}
		else if(this.sidx.equals("csvModelCodeSimple")){
			return "csv_model_code_simple";
		}
		else if(this.sidx.equals("csvInteriorColorCode")){
			return "csv_interior_color_code";
		}
		else if(this.sidx.equals("csvStatus")){
			return "csv_status";
		}
		else if(this.sidx.equals("csvAddTime")){
			return "csv_add_time";
		}
		else if(this.sidx.equals("csvUpdateTime")){
			return "csv_update_time";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsVehicleCrieria getCrieria(){
		CsVehicleCrieria q = new CsVehicleCrieria();
		CsVehicleCrieria.Criteria c = q.createCriteria();
		
		if(this.getCsvIdEquals()!=null){
			c.andcsvIdEqualTo(this.getCsvIdEquals());
		}else if(this.getCsvIdIsNull()!=null && this.getCsvIdIsNull()){
			c.andcsvIdIsNull();
		}else if(this.getCsvIdIsNotNull()!=null && this.getCsvIdIsNotNull()){
			c.andcsvIdIsNotNull();
		}else if(this.getCsvIdIn()!=null){
			c.andcsvIdIn(java.util.Arrays.asList(this.getCsvIdIn()));
		}else if(this.getCsvIdStart()!=null && this.getCsvIdEnd()!=null){
			c.andcsvIdBetween(this.getCsvIdStart(), this.getCsvIdEnd());
		}else if(this.getCsvIdGreater()!=null){
			c.andcsvIdGreaterThan(this.getCsvIdGreater());
		}else if(this.getCsvIdLess()!=null){
			c.andcsvIdLessThan(this.getCsvIdLess());
		}
		if(this.getCsvAccessEquals()!=null){
			c.andcsvAccessEqualTo(this.getCsvAccessEquals());
		}else if(this.getCsvAccessIsNull()!=null && this.getCsvAccessIsNull()){
			c.andcsvAccessIsNull();
		}else if(this.getCsvAccessIsNotNull()!=null && this.getCsvAccessIsNotNull()){
			c.andcsvAccessIsNotNull();
		}else if(this.getCsvAccessIn()!=null){
			c.andcsvAccessIn(java.util.Arrays.asList(this.getCsvAccessIn()));
		}else if(this.getCsvAccessStart()!=null && this.getCsvAccessEnd()!=null){
			c.andcsvAccessBetween(this.getCsvAccessStart(), this.getCsvAccessEnd());
		}else if(this.getCsvAccessGreater()!=null){
			c.andcsvAccessGreaterThan(this.getCsvAccessGreater());
		}else if(this.getCsvAccessLess()!=null){
			c.andcsvAccessLessThan(this.getCsvAccessLess());
		}
		if(this.getCsvCarNoEquals()!=null){
			c.andcsvCarNoEqualTo(this.getCsvCarNoEquals());
		}else if(this.getCsvCarNoIsNull()!=null && this.getCsvCarNoIsNull()){
			c.andcsvCarNoIsNull();
		}else if(this.getCsvCarNoIsNotNull()!=null && this.getCsvCarNoIsNotNull()){
			c.andcsvCarNoIsNotNull();
		}else if(this.getCsvCarNoLike()!=null){
			c.andcsvCarNoLike(this.getCsvCarNoLike());
		}else if(this.getCsvCarNoIn()!=null){
			c.andcsvCarNoIn(java.util.Arrays.asList(this.getCsvCarNoIn()));
		}else if(this.getCsvCarNoStart()!=null && this.getCsvCarNoEnd()!=null){
			c.andcsvCarNoBetween(this.getCsvCarNoStart(), this.getCsvCarNoEnd());
		}else if(this.getCsvCarNoGreater()!=null){
			c.andcsvCarNoGreaterThan(this.getCsvCarNoGreater());
		}else if(this.getCsvCarNoLess()!=null){
			c.andcsvCarNoLessThan(this.getCsvCarNoLess());
		}
		if(this.getCsvVinEquals()!=null){
			c.andcsvVinEqualTo(this.getCsvVinEquals());
		}else if(this.getCsvVinIsNull()!=null && this.getCsvVinIsNull()){
			c.andcsvVinIsNull();
		}else if(this.getCsvVinIsNotNull()!=null && this.getCsvVinIsNotNull()){
			c.andcsvVinIsNotNull();
		}else if(this.getCsvVinLike()!=null){
			c.andcsvVinLike(this.getCsvVinLike());
		}else if(this.getCsvVinIn()!=null){
			c.andcsvVinIn(java.util.Arrays.asList(this.getCsvVinIn()));
		}else if(this.getCsvVinStart()!=null && this.getCsvVinEnd()!=null){
			c.andcsvVinBetween(this.getCsvVinStart(), this.getCsvVinEnd());
		}else if(this.getCsvVinGreater()!=null){
			c.andcsvVinGreaterThan(this.getCsvVinGreater());
		}else if(this.getCsvVinLess()!=null){
			c.andcsvVinLessThan(this.getCsvVinLess());
		}
		if(this.getCsvEngineNoEquals()!=null){
			c.andcsvEngineNoEqualTo(this.getCsvEngineNoEquals());
		}else if(this.getCsvEngineNoIsNull()!=null && this.getCsvEngineNoIsNull()){
			c.andcsvEngineNoIsNull();
		}else if(this.getCsvEngineNoIsNotNull()!=null && this.getCsvEngineNoIsNotNull()){
			c.andcsvEngineNoIsNotNull();
		}else if(this.getCsvEngineNoLike()!=null){
			c.andcsvEngineNoLike(this.getCsvEngineNoLike());
		}else if(this.getCsvEngineNoIn()!=null){
			c.andcsvEngineNoIn(java.util.Arrays.asList(this.getCsvEngineNoIn()));
		}else if(this.getCsvEngineNoStart()!=null && this.getCsvEngineNoEnd()!=null){
			c.andcsvEngineNoBetween(this.getCsvEngineNoStart(), this.getCsvEngineNoEnd());
		}else if(this.getCsvEngineNoGreater()!=null){
			c.andcsvEngineNoGreaterThan(this.getCsvEngineNoGreater());
		}else if(this.getCsvEngineNoLess()!=null){
			c.andcsvEngineNoLessThan(this.getCsvEngineNoLess());
		}
		if(this.getCsvCertificEquals()!=null){
			c.andcsvCertificEqualTo(this.getCsvCertificEquals());
		}else if(this.getCsvCertificIsNull()!=null && this.getCsvCertificIsNull()){
			c.andcsvCertificIsNull();
		}else if(this.getCsvCertificIsNotNull()!=null && this.getCsvCertificIsNotNull()){
			c.andcsvCertificIsNotNull();
		}else if(this.getCsvCertificLike()!=null){
			c.andcsvCertificLike(this.getCsvCertificLike());
		}else if(this.getCsvCertificIn()!=null){
			c.andcsvCertificIn(java.util.Arrays.asList(this.getCsvCertificIn()));
		}else if(this.getCsvCertificStart()!=null && this.getCsvCertificEnd()!=null){
			c.andcsvCertificBetween(this.getCsvCertificStart(), this.getCsvCertificEnd());
		}else if(this.getCsvCertificGreater()!=null){
			c.andcsvCertificGreaterThan(this.getCsvCertificGreater());
		}else if(this.getCsvCertificLess()!=null){
			c.andcsvCertificLessThan(this.getCsvCertificLess());
		}
		if(this.getCsvModelEquals()!=null){
			c.andcsvModelEqualTo(this.getCsvModelEquals());
		}else if(this.getCsvModelIsNull()!=null && this.getCsvModelIsNull()){
			c.andcsvModelIsNull();
		}else if(this.getCsvModelIsNotNull()!=null && this.getCsvModelIsNotNull()){
			c.andcsvModelIsNotNull();
		}else if(this.getCsvModelIn()!=null){
			c.andcsvModelIn(java.util.Arrays.asList(this.getCsvModelIn()));
		}else if(this.getCsvModelStart()!=null && this.getCsvModelEnd()!=null){
			c.andcsvModelBetween(this.getCsvModelStart(), this.getCsvModelEnd());
		}else if(this.getCsvModelGreater()!=null){
			c.andcsvModelGreaterThan(this.getCsvModelGreater());
		}else if(this.getCsvModelLess()!=null){
			c.andcsvModelLessThan(this.getCsvModelLess());
		}
		if(this.getCsvMachineEquals()!=null){
			c.andcsvMachineEqualTo(this.getCsvMachineEquals());
		}else if(this.getCsvMachineIsNull()!=null && this.getCsvMachineIsNull()){
			c.andcsvMachineIsNull();
		}else if(this.getCsvMachineIsNotNull()!=null && this.getCsvMachineIsNotNull()){
			c.andcsvMachineIsNotNull();
		}else if(this.getCsvMachineIn()!=null){
			c.andcsvMachineIn(java.util.Arrays.asList(this.getCsvMachineIn()));
		}else if(this.getCsvMachineStart()!=null && this.getCsvMachineEnd()!=null){
			c.andcsvMachineBetween(this.getCsvMachineStart(), this.getCsvMachineEnd());
		}else if(this.getCsvMachineGreater()!=null){
			c.andcsvMachineGreaterThan(this.getCsvMachineGreater());
		}else if(this.getCsvMachineLess()!=null){
			c.andcsvMachineLessThan(this.getCsvMachineLess());
		}
		if(this.getCsvColorCodeEquals()!=null){
			c.andcsvColorCodeEqualTo(this.getCsvColorCodeEquals());
		}else if(this.getCsvColorCodeIsNull()!=null && this.getCsvColorCodeIsNull()){
			c.andcsvColorCodeIsNull();
		}else if(this.getCsvColorCodeIsNotNull()!=null && this.getCsvColorCodeIsNotNull()){
			c.andcsvColorCodeIsNotNull();
		}else if(this.getCsvColorCodeIn()!=null){
			c.andcsvColorCodeIn(java.util.Arrays.asList(this.getCsvColorCodeIn()));
		}else if(this.getCsvColorCodeStart()!=null && this.getCsvColorCodeEnd()!=null){
			c.andcsvColorCodeBetween(this.getCsvColorCodeStart(), this.getCsvColorCodeEnd());
		}else if(this.getCsvColorCodeGreater()!=null){
			c.andcsvColorCodeGreaterThan(this.getCsvColorCodeGreater());
		}else if(this.getCsvColorCodeLess()!=null){
			c.andcsvColorCodeLessThan(this.getCsvColorCodeLess());
		}
		if(this.getCsvBataccuCodeEquals()!=null){
			c.andcsvBataccuCodeEqualTo(this.getCsvBataccuCodeEquals());
		}else if(this.getCsvBataccuCodeIsNull()!=null && this.getCsvBataccuCodeIsNull()){
			c.andcsvBataccuCodeIsNull();
		}else if(this.getCsvBataccuCodeIsNotNull()!=null && this.getCsvBataccuCodeIsNotNull()){
			c.andcsvBataccuCodeIsNotNull();
		}else if(this.getCsvBataccuCodeLike()!=null){
			c.andcsvBataccuCodeLike(this.getCsvBataccuCodeLike());
		}else if(this.getCsvBataccuCodeIn()!=null){
			c.andcsvBataccuCodeIn(java.util.Arrays.asList(this.getCsvBataccuCodeIn()));
		}else if(this.getCsvBataccuCodeStart()!=null && this.getCsvBataccuCodeEnd()!=null){
			c.andcsvBataccuCodeBetween(this.getCsvBataccuCodeStart(), this.getCsvBataccuCodeEnd());
		}else if(this.getCsvBataccuCodeGreater()!=null){
			c.andcsvBataccuCodeGreaterThan(this.getCsvBataccuCodeGreater());
		}else if(this.getCsvBataccuCodeLess()!=null){
			c.andcsvBataccuCodeLessThan(this.getCsvBataccuCodeLess());
		}
		if(this.getCsvProdDateEquals()!=null){
			c.andcsvProdDateEqualTo(this.getCsvProdDateEquals());
		}else if(this.getCsvProdDateIsNull()!=null && this.getCsvProdDateIsNull()){
			c.andcsvProdDateIsNull();
		}else if(this.getCsvProdDateIsNotNull()!=null && this.getCsvProdDateIsNotNull()){
			c.andcsvProdDateIsNotNull();
		}else if(this.getCsvProdDateIn()!=null){
			c.andcsvProdDateIn(java.util.Arrays.asList(this.getCsvProdDateIn()));
		}else if(this.getCsvProdDateStart()!=null && this.getCsvProdDateEnd()!=null){
			c.andcsvProdDateBetween(this.getCsvProdDateStart(), this.getCsvProdDateEnd());
		}else if(this.getCsvProdDateGreater()!=null){
			c.andcsvProdDateGreaterThan(this.getCsvProdDateGreater());
		}else if(this.getCsvProdDateLess()!=null){
			c.andcsvProdDateLessThan(this.getCsvProdDateLess());
		}
		if(this.getCsvLandmarkEquals()!=null){
			c.andcsvLandmarkEqualTo(this.getCsvLandmarkEquals());
		}else if(this.getCsvLandmarkIsNull()!=null && this.getCsvLandmarkIsNull()){
			c.andcsvLandmarkIsNull();
		}else if(this.getCsvLandmarkIsNotNull()!=null && this.getCsvLandmarkIsNotNull()){
			c.andcsvLandmarkIsNotNull();
		}else if(this.getCsvLandmarkLike()!=null){
			c.andcsvLandmarkLike(this.getCsvLandmarkLike());
		}else if(this.getCsvLandmarkIn()!=null){
			c.andcsvLandmarkIn(java.util.Arrays.asList(this.getCsvLandmarkIn()));
		}else if(this.getCsvLandmarkStart()!=null && this.getCsvLandmarkEnd()!=null){
			c.andcsvLandmarkBetween(this.getCsvLandmarkStart(), this.getCsvLandmarkEnd());
		}else if(this.getCsvLandmarkGreater()!=null){
			c.andcsvLandmarkGreaterThan(this.getCsvLandmarkGreater());
		}else if(this.getCsvLandmarkLess()!=null){
			c.andcsvLandmarkLessThan(this.getCsvLandmarkLess());
		}
		if(this.getCsvDomainEquals()!=null){
			c.andcsvDomainEqualTo(this.getCsvDomainEquals());
		}else if(this.getCsvDomainIsNull()!=null && this.getCsvDomainIsNull()){
			c.andcsvDomainIsNull();
		}else if(this.getCsvDomainIsNotNull()!=null && this.getCsvDomainIsNotNull()){
			c.andcsvDomainIsNotNull();
		}else if(this.getCsvDomainIn()!=null){
			c.andcsvDomainIn(java.util.Arrays.asList(this.getCsvDomainIn()));
		}else if(this.getCsvDomainStart()!=null && this.getCsvDomainEnd()!=null){
			c.andcsvDomainBetween(this.getCsvDomainStart(), this.getCsvDomainEnd());
		}else if(this.getCsvDomainGreater()!=null){
			c.andcsvDomainGreaterThan(this.getCsvDomainGreater());
		}else if(this.getCsvDomainLess()!=null){
			c.andcsvDomainLessThan(this.getCsvDomainLess());
		}
		if(this.getCsvModelCodeFullEquals()!=null){
			c.andcsvModelCodeFullEqualTo(this.getCsvModelCodeFullEquals());
		}else if(this.getCsvModelCodeFullIsNull()!=null && this.getCsvModelCodeFullIsNull()){
			c.andcsvModelCodeFullIsNull();
		}else if(this.getCsvModelCodeFullIsNotNull()!=null && this.getCsvModelCodeFullIsNotNull()){
			c.andcsvModelCodeFullIsNotNull();
		}else if(this.getCsvModelCodeFullLike()!=null){
			c.andcsvModelCodeFullLike(this.getCsvModelCodeFullLike());
		}else if(this.getCsvModelCodeFullIn()!=null){
			c.andcsvModelCodeFullIn(java.util.Arrays.asList(this.getCsvModelCodeFullIn()));
		}else if(this.getCsvModelCodeFullStart()!=null && this.getCsvModelCodeFullEnd()!=null){
			c.andcsvModelCodeFullBetween(this.getCsvModelCodeFullStart(), this.getCsvModelCodeFullEnd());
		}else if(this.getCsvModelCodeFullGreater()!=null){
			c.andcsvModelCodeFullGreaterThan(this.getCsvModelCodeFullGreater());
		}else if(this.getCsvModelCodeFullLess()!=null){
			c.andcsvModelCodeFullLessThan(this.getCsvModelCodeFullLess());
		}
		if(this.getCsvModelCodeSimpleEquals()!=null){
			c.andcsvModelCodeSimpleEqualTo(this.getCsvModelCodeSimpleEquals());
		}else if(this.getCsvModelCodeSimpleIsNull()!=null && this.getCsvModelCodeSimpleIsNull()){
			c.andcsvModelCodeSimpleIsNull();
		}else if(this.getCsvModelCodeSimpleIsNotNull()!=null && this.getCsvModelCodeSimpleIsNotNull()){
			c.andcsvModelCodeSimpleIsNotNull();
		}else if(this.getCsvModelCodeSimpleLike()!=null){
			c.andcsvModelCodeSimpleLike(this.getCsvModelCodeSimpleLike());
		}else if(this.getCsvModelCodeSimpleIn()!=null){
			c.andcsvModelCodeSimpleIn(java.util.Arrays.asList(this.getCsvModelCodeSimpleIn()));
		}else if(this.getCsvModelCodeSimpleStart()!=null && this.getCsvModelCodeSimpleEnd()!=null){
			c.andcsvModelCodeSimpleBetween(this.getCsvModelCodeSimpleStart(), this.getCsvModelCodeSimpleEnd());
		}else if(this.getCsvModelCodeSimpleGreater()!=null){
			c.andcsvModelCodeSimpleGreaterThan(this.getCsvModelCodeSimpleGreater());
		}else if(this.getCsvModelCodeSimpleLess()!=null){
			c.andcsvModelCodeSimpleLessThan(this.getCsvModelCodeSimpleLess());
		}
		if(this.getCsvInteriorColorCodeEquals()!=null){
			c.andcsvInteriorColorCodeEqualTo(this.getCsvInteriorColorCodeEquals());
		}else if(this.getCsvInteriorColorCodeIsNull()!=null && this.getCsvInteriorColorCodeIsNull()){
			c.andcsvInteriorColorCodeIsNull();
		}else if(this.getCsvInteriorColorCodeIsNotNull()!=null && this.getCsvInteriorColorCodeIsNotNull()){
			c.andcsvInteriorColorCodeIsNotNull();
		}else if(this.getCsvInteriorColorCodeLike()!=null){
			c.andcsvInteriorColorCodeLike(this.getCsvInteriorColorCodeLike());
		}else if(this.getCsvInteriorColorCodeIn()!=null){
			c.andcsvInteriorColorCodeIn(java.util.Arrays.asList(this.getCsvInteriorColorCodeIn()));
		}else if(this.getCsvInteriorColorCodeStart()!=null && this.getCsvInteriorColorCodeEnd()!=null){
			c.andcsvInteriorColorCodeBetween(this.getCsvInteriorColorCodeStart(), this.getCsvInteriorColorCodeEnd());
		}else if(this.getCsvInteriorColorCodeGreater()!=null){
			c.andcsvInteriorColorCodeGreaterThan(this.getCsvInteriorColorCodeGreater());
		}else if(this.getCsvInteriorColorCodeLess()!=null){
			c.andcsvInteriorColorCodeLessThan(this.getCsvInteriorColorCodeLess());
		}
		if(this.getCsvStatusEquals()!=null){
			c.andcsvStatusEqualTo(this.getCsvStatusEquals());
		}else if(this.getCsvStatusIsNull()!=null && this.getCsvStatusIsNull()){
			c.andcsvStatusIsNull();
		}else if(this.getCsvStatusIsNotNull()!=null && this.getCsvStatusIsNotNull()){
			c.andcsvStatusIsNotNull();
		}else if(this.getCsvStatusIn()!=null){
			c.andcsvStatusIn(java.util.Arrays.asList(this.getCsvStatusIn()));
		}else if(this.getCsvStatusStart()!=null && this.getCsvStatusEnd()!=null){
			c.andcsvStatusBetween(this.getCsvStatusStart(), this.getCsvStatusEnd());
		}else if(this.getCsvStatusGreater()!=null){
			c.andcsvStatusGreaterThan(this.getCsvStatusGreater());
		}else if(this.getCsvStatusLess()!=null){
			c.andcsvStatusLessThan(this.getCsvStatusLess());
		}
		if(this.getCsvAddTimeEquals()!=null){
			c.andcsvAddTimeEqualTo(this.getCsvAddTimeEquals());
		}else if(this.getCsvAddTimeIsNull()!=null && this.getCsvAddTimeIsNull()){
			c.andcsvAddTimeIsNull();
		}else if(this.getCsvAddTimeIsNotNull()!=null && this.getCsvAddTimeIsNotNull()){
			c.andcsvAddTimeIsNotNull();
		}else if(this.getCsvAddTimeIn()!=null){
			c.andcsvAddTimeIn(java.util.Arrays.asList(this.getCsvAddTimeIn()));
		}else if(this.getCsvAddTimeStart()!=null && this.getCsvAddTimeEnd()!=null){
			c.andcsvAddTimeBetween(this.getCsvAddTimeStart(), this.getCsvAddTimeEnd());
		}else if(this.getCsvAddTimeGreater()!=null){
			c.andcsvAddTimeGreaterThan(this.getCsvAddTimeGreater());
		}else if(this.getCsvAddTimeLess()!=null){
			c.andcsvAddTimeLessThan(this.getCsvAddTimeLess());
		}
		if(this.getCsvUpdateTimeEquals()!=null){
			c.andcsvUpdateTimeEqualTo(this.getCsvUpdateTimeEquals());
		}else if(this.getCsvUpdateTimeIsNull()!=null && this.getCsvUpdateTimeIsNull()){
			c.andcsvUpdateTimeIsNull();
		}else if(this.getCsvUpdateTimeIsNotNull()!=null && this.getCsvUpdateTimeIsNotNull()){
			c.andcsvUpdateTimeIsNotNull();
		}else if(this.getCsvUpdateTimeIn()!=null){
			c.andcsvUpdateTimeIn(java.util.Arrays.asList(this.getCsvUpdateTimeIn()));
		}else if(this.getCsvUpdateTimeStart()!=null && this.getCsvUpdateTimeEnd()!=null){
			c.andcsvUpdateTimeBetween(this.getCsvUpdateTimeStart(), this.getCsvUpdateTimeEnd());
		}else if(this.getCsvUpdateTimeGreater()!=null){
			c.andcsvUpdateTimeGreaterThan(this.getCsvUpdateTimeGreater());
		}else if(this.getCsvUpdateTimeLess()!=null){
			c.andcsvUpdateTimeLessThan(this.getCsvUpdateTimeLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
