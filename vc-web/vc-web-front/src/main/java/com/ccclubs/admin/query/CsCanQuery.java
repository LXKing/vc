package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsCanCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsCanQuery {
	
	private Long cscIdEquals;
	private Long[] cscIdIn;
	private Boolean cscIdIsNull;
	private Boolean cscIdIsNotNull;
	
	private Long cscIdStart;
	
	private Long cscIdEnd;
	
	private Long cscIdLess;
	
	private Long cscIdGreater;
	
	private Integer cscAccessEquals;
	private Integer[] cscAccessIn;
	private Boolean cscAccessIsNull;
	private Boolean cscAccessIsNotNull;
	
	private Integer cscAccessStart;
	
	private Integer cscAccessEnd;
	
	private Integer cscAccessLess;
	
	private Integer cscAccessGreater;
	private String cscNumberLike;
	
	private String cscNumberEquals;
	private String[] cscNumberIn;
	private Boolean cscNumberIsNull;
	private Boolean cscNumberIsNotNull;
	
	private String cscNumberStart;
	
	private String cscNumberEnd;
	
	private String cscNumberLess;
	
	private String cscNumberGreater;
	
	private Integer cscCarEquals;
	private Integer[] cscCarIn;
	private Boolean cscCarIsNull;
	private Boolean cscCarIsNotNull;
	
	private Integer cscCarStart;
	
	private Integer cscCarEnd;
	
	private Integer cscCarLess;
	
	private Integer cscCarGreater;
	
	private Short cscModelEquals;
	private Short[] cscModelIn;
	private Boolean cscModelIsNull;
	private Boolean cscModelIsNotNull;
	
	private Short cscModelStart;
	
	private Short cscModelEnd;
	
	private Short cscModelLess;
	
	private Short cscModelGreater;
	
	private Short cscTypeEquals;
	private Short[] cscTypeIn;
	private Boolean cscTypeIsNull;
	private Boolean cscTypeIsNotNull;
	
	private Short cscTypeStart;
	
	private Short cscTypeEnd;
	
	private Short cscTypeLess;
	
	private Short cscTypeGreater;
	
	private Long cscOrderEquals;
	private Long[] cscOrderIn;
	private Boolean cscOrderIsNull;
	private Boolean cscOrderIsNotNull;
	
	private Long cscOrderStart;
	
	private Long cscOrderEnd;
	
	private Long cscOrderLess;
	
	private Long cscOrderGreater;
	private String cscDataLike;
	
	private String cscDataEquals;
	private String[] cscDataIn;
	private Boolean cscDataIsNull;
	private Boolean cscDataIsNotNull;
	
	private String cscDataStart;
	
	private String cscDataEnd;
	
	private String cscDataLess;
	
	private String cscDataGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscUploadTimeEquals;
	private Date[] cscUploadTimeIn;
	private Boolean cscUploadTimeIsNull;
	private Boolean cscUploadTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscUploadTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscUploadTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscUploadTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscUploadTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscAddTimeEquals;
	private Date[] cscAddTimeIn;
	private Boolean cscAddTimeIsNull;
	private Boolean cscAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cscAddTimeGreater;
	
	private Short cscStatusEquals;
	private Short[] cscStatusIn;
	private Boolean cscStatusIsNull;
	private Boolean cscStatusIsNotNull;
	
	private Short cscStatusStart;
	
	private Short cscStatusEnd;
	
	private Short cscStatusLess;
	
	private Short cscStatusGreater;
	private String sidx;
	private String sord;

	public CsCanQuery setCscIdEquals(Long cscIdEquals){
		this.cscIdEquals = cscIdEquals;
		return this;
	}
	public Long getCscIdEquals(){
		return this.cscIdEquals;
	}
	public CsCanQuery setCscIdIn(Long[] cscIdIn){
		this.cscIdIn = cscIdIn;
		return this;
	}
	public Long[] getCscIdIn(){
		return this.cscIdIn;
	}
	public CsCanQuery setCscIdIsNull(Boolean cscIdIsNull){
		this.cscIdIsNull = cscIdIsNull;
		return this;
	}
	public Boolean getCscIdIsNull(){
		return this.cscIdIsNull;
	}
	public CsCanQuery setCscIdIsNotNull(Boolean cscIdIsNotNull){
		this.cscIdIsNotNull = cscIdIsNotNull;
		return this;
	}
	public Boolean getCscIdIsNotNull(){
		return this.cscIdIsNotNull;
	}
	public CsCanQuery setCscIdStart(Long cscIdStart){
		this.cscIdStart = cscIdStart;
		return this;
	}
	public Long getCscIdStart(){
		return this.cscIdStart;
	}
	public CsCanQuery setCscIdEnd(Long cscIdEnd){
		this.cscIdEnd = cscIdEnd;
		return this;
	}
	public Long getCscIdEnd(){
		return this.cscIdEnd;
	}
	public CsCanQuery setCscIdLess(Long cscIdLess){
		this.cscIdLess = cscIdLess;
		return this;
	}
	public Long getCscIdLess(){
		return this.cscIdLess;
	}
	public CsCanQuery setCscIdGreater(Long cscIdGreater){
		this.cscIdGreater = cscIdGreater;
		return this;
	}
	public Long getCscIdGreater(){
		return this.cscIdGreater;
	}
	public CsCanQuery setCscAccessEquals(Integer cscAccessEquals){
		this.cscAccessEquals = cscAccessEquals;
		return this;
	}
	public Integer getCscAccessEquals(){
		return this.cscAccessEquals;
	}
	public CsCanQuery setCscAccessIn(Integer[] cscAccessIn){
		this.cscAccessIn = cscAccessIn;
		return this;
	}
	public Integer[] getCscAccessIn(){
		return this.cscAccessIn;
	}
	public CsCanQuery setCscAccessIsNull(Boolean cscAccessIsNull){
		this.cscAccessIsNull = cscAccessIsNull;
		return this;
	}
	public Boolean getCscAccessIsNull(){
		return this.cscAccessIsNull;
	}
	public CsCanQuery setCscAccessIsNotNull(Boolean cscAccessIsNotNull){
		this.cscAccessIsNotNull = cscAccessIsNotNull;
		return this;
	}
	public Boolean getCscAccessIsNotNull(){
		return this.cscAccessIsNotNull;
	}
	public CsCanQuery setCscAccessStart(Integer cscAccessStart){
		this.cscAccessStart = cscAccessStart;
		return this;
	}
	public Integer getCscAccessStart(){
		return this.cscAccessStart;
	}
	public CsCanQuery setCscAccessEnd(Integer cscAccessEnd){
		this.cscAccessEnd = cscAccessEnd;
		return this;
	}
	public Integer getCscAccessEnd(){
		return this.cscAccessEnd;
	}
	public CsCanQuery setCscAccessLess(Integer cscAccessLess){
		this.cscAccessLess = cscAccessLess;
		return this;
	}
	public Integer getCscAccessLess(){
		return this.cscAccessLess;
	}
	public CsCanQuery setCscAccessGreater(Integer cscAccessGreater){
		this.cscAccessGreater = cscAccessGreater;
		return this;
	}
	public Integer getCscAccessGreater(){
		return this.cscAccessGreater;
	}
	public CsCanQuery setCscNumberLike(String cscNumberLike){
		this.cscNumberLike = cscNumberLike;
		return this;
	}
	public String getCscNumberLike(){
		return this.cscNumberLike;
	}
	public CsCanQuery setCscNumberEquals(String cscNumberEquals){
		this.cscNumberEquals = cscNumberEquals;
		return this;
	}
	public String getCscNumberEquals(){
		return this.cscNumberEquals;
	}
	public CsCanQuery setCscNumberIn(String[] cscNumberIn){
		this.cscNumberIn = cscNumberIn;
		return this;
	}
	public String[] getCscNumberIn(){
		return this.cscNumberIn;
	}
	public CsCanQuery setCscNumberIsNull(Boolean cscNumberIsNull){
		this.cscNumberIsNull = cscNumberIsNull;
		return this;
	}
	public Boolean getCscNumberIsNull(){
		return this.cscNumberIsNull;
	}
	public CsCanQuery setCscNumberIsNotNull(Boolean cscNumberIsNotNull){
		this.cscNumberIsNotNull = cscNumberIsNotNull;
		return this;
	}
	public Boolean getCscNumberIsNotNull(){
		return this.cscNumberIsNotNull;
	}
	public CsCanQuery setCscNumberStart(String cscNumberStart){
		this.cscNumberStart = cscNumberStart;
		return this;
	}
	public String getCscNumberStart(){
		return this.cscNumberStart;
	}
	public CsCanQuery setCscNumberEnd(String cscNumberEnd){
		this.cscNumberEnd = cscNumberEnd;
		return this;
	}
	public String getCscNumberEnd(){
		return this.cscNumberEnd;
	}
	public CsCanQuery setCscNumberLess(String cscNumberLess){
		this.cscNumberLess = cscNumberLess;
		return this;
	}
	public String getCscNumberLess(){
		return this.cscNumberLess;
	}
	public CsCanQuery setCscNumberGreater(String cscNumberGreater){
		this.cscNumberGreater = cscNumberGreater;
		return this;
	}
	public String getCscNumberGreater(){
		return this.cscNumberGreater;
	}
	public CsCanQuery setCscCarEquals(Integer cscCarEquals){
		this.cscCarEquals = cscCarEquals;
		return this;
	}
	public Integer getCscCarEquals(){
		return this.cscCarEquals;
	}
	public CsCanQuery setCscCarIn(Integer[] cscCarIn){
		this.cscCarIn = cscCarIn;
		return this;
	}
	public Integer[] getCscCarIn(){
		return this.cscCarIn;
	}
	public CsCanQuery setCscCarIsNull(Boolean cscCarIsNull){
		this.cscCarIsNull = cscCarIsNull;
		return this;
	}
	public Boolean getCscCarIsNull(){
		return this.cscCarIsNull;
	}
	public CsCanQuery setCscCarIsNotNull(Boolean cscCarIsNotNull){
		this.cscCarIsNotNull = cscCarIsNotNull;
		return this;
	}
	public Boolean getCscCarIsNotNull(){
		return this.cscCarIsNotNull;
	}
	public CsCanQuery setCscCarStart(Integer cscCarStart){
		this.cscCarStart = cscCarStart;
		return this;
	}
	public Integer getCscCarStart(){
		return this.cscCarStart;
	}
	public CsCanQuery setCscCarEnd(Integer cscCarEnd){
		this.cscCarEnd = cscCarEnd;
		return this;
	}
	public Integer getCscCarEnd(){
		return this.cscCarEnd;
	}
	public CsCanQuery setCscCarLess(Integer cscCarLess){
		this.cscCarLess = cscCarLess;
		return this;
	}
	public Integer getCscCarLess(){
		return this.cscCarLess;
	}
	public CsCanQuery setCscCarGreater(Integer cscCarGreater){
		this.cscCarGreater = cscCarGreater;
		return this;
	}
	public Integer getCscCarGreater(){
		return this.cscCarGreater;
	}
	public CsCanQuery setCscModelEquals(Short cscModelEquals){
		this.cscModelEquals = cscModelEquals;
		return this;
	}
	public Short getCscModelEquals(){
		return this.cscModelEquals;
	}
	public CsCanQuery setCscModelIn(Short[] cscModelIn){
		this.cscModelIn = cscModelIn;
		return this;
	}
	public Short[] getCscModelIn(){
		return this.cscModelIn;
	}
	public CsCanQuery setCscModelIsNull(Boolean cscModelIsNull){
		this.cscModelIsNull = cscModelIsNull;
		return this;
	}
	public Boolean getCscModelIsNull(){
		return this.cscModelIsNull;
	}
	public CsCanQuery setCscModelIsNotNull(Boolean cscModelIsNotNull){
		this.cscModelIsNotNull = cscModelIsNotNull;
		return this;
	}
	public Boolean getCscModelIsNotNull(){
		return this.cscModelIsNotNull;
	}
	public CsCanQuery setCscModelStart(Short cscModelStart){
		this.cscModelStart = cscModelStart;
		return this;
	}
	public Short getCscModelStart(){
		return this.cscModelStart;
	}
	public CsCanQuery setCscModelEnd(Short cscModelEnd){
		this.cscModelEnd = cscModelEnd;
		return this;
	}
	public Short getCscModelEnd(){
		return this.cscModelEnd;
	}
	public CsCanQuery setCscModelLess(Short cscModelLess){
		this.cscModelLess = cscModelLess;
		return this;
	}
	public Short getCscModelLess(){
		return this.cscModelLess;
	}
	public CsCanQuery setCscModelGreater(Short cscModelGreater){
		this.cscModelGreater = cscModelGreater;
		return this;
	}
	public Short getCscModelGreater(){
		return this.cscModelGreater;
	}
	public CsCanQuery setCscTypeEquals(Short cscTypeEquals){
		this.cscTypeEquals = cscTypeEquals;
		return this;
	}
	public Short getCscTypeEquals(){
		return this.cscTypeEquals;
	}
	public CsCanQuery setCscTypeIn(Short[] cscTypeIn){
		this.cscTypeIn = cscTypeIn;
		return this;
	}
	public Short[] getCscTypeIn(){
		return this.cscTypeIn;
	}
	public CsCanQuery setCscTypeIsNull(Boolean cscTypeIsNull){
		this.cscTypeIsNull = cscTypeIsNull;
		return this;
	}
	public Boolean getCscTypeIsNull(){
		return this.cscTypeIsNull;
	}
	public CsCanQuery setCscTypeIsNotNull(Boolean cscTypeIsNotNull){
		this.cscTypeIsNotNull = cscTypeIsNotNull;
		return this;
	}
	public Boolean getCscTypeIsNotNull(){
		return this.cscTypeIsNotNull;
	}
	public CsCanQuery setCscTypeStart(Short cscTypeStart){
		this.cscTypeStart = cscTypeStart;
		return this;
	}
	public Short getCscTypeStart(){
		return this.cscTypeStart;
	}
	public CsCanQuery setCscTypeEnd(Short cscTypeEnd){
		this.cscTypeEnd = cscTypeEnd;
		return this;
	}
	public Short getCscTypeEnd(){
		return this.cscTypeEnd;
	}
	public CsCanQuery setCscTypeLess(Short cscTypeLess){
		this.cscTypeLess = cscTypeLess;
		return this;
	}
	public Short getCscTypeLess(){
		return this.cscTypeLess;
	}
	public CsCanQuery setCscTypeGreater(Short cscTypeGreater){
		this.cscTypeGreater = cscTypeGreater;
		return this;
	}
	public Short getCscTypeGreater(){
		return this.cscTypeGreater;
	}
	public CsCanQuery setCscOrderEquals(Long cscOrderEquals){
		this.cscOrderEquals = cscOrderEquals;
		return this;
	}
	public Long getCscOrderEquals(){
		return this.cscOrderEquals;
	}
	public CsCanQuery setCscOrderIn(Long[] cscOrderIn){
		this.cscOrderIn = cscOrderIn;
		return this;
	}
	public Long[] getCscOrderIn(){
		return this.cscOrderIn;
	}
	public CsCanQuery setCscOrderIsNull(Boolean cscOrderIsNull){
		this.cscOrderIsNull = cscOrderIsNull;
		return this;
	}
	public Boolean getCscOrderIsNull(){
		return this.cscOrderIsNull;
	}
	public CsCanQuery setCscOrderIsNotNull(Boolean cscOrderIsNotNull){
		this.cscOrderIsNotNull = cscOrderIsNotNull;
		return this;
	}
	public Boolean getCscOrderIsNotNull(){
		return this.cscOrderIsNotNull;
	}
	public CsCanQuery setCscOrderStart(Long cscOrderStart){
		this.cscOrderStart = cscOrderStart;
		return this;
	}
	public Long getCscOrderStart(){
		return this.cscOrderStart;
	}
	public CsCanQuery setCscOrderEnd(Long cscOrderEnd){
		this.cscOrderEnd = cscOrderEnd;
		return this;
	}
	public Long getCscOrderEnd(){
		return this.cscOrderEnd;
	}
	public CsCanQuery setCscOrderLess(Long cscOrderLess){
		this.cscOrderLess = cscOrderLess;
		return this;
	}
	public Long getCscOrderLess(){
		return this.cscOrderLess;
	}
	public CsCanQuery setCscOrderGreater(Long cscOrderGreater){
		this.cscOrderGreater = cscOrderGreater;
		return this;
	}
	public Long getCscOrderGreater(){
		return this.cscOrderGreater;
	}
	public CsCanQuery setCscDataLike(String cscDataLike){
		this.cscDataLike = cscDataLike;
		return this;
	}
	public String getCscDataLike(){
		return this.cscDataLike;
	}
	public CsCanQuery setCscDataEquals(String cscDataEquals){
		this.cscDataEquals = cscDataEquals;
		return this;
	}
	public String getCscDataEquals(){
		return this.cscDataEquals;
	}
	public CsCanQuery setCscDataIn(String[] cscDataIn){
		this.cscDataIn = cscDataIn;
		return this;
	}
	public String[] getCscDataIn(){
		return this.cscDataIn;
	}
	public CsCanQuery setCscDataIsNull(Boolean cscDataIsNull){
		this.cscDataIsNull = cscDataIsNull;
		return this;
	}
	public Boolean getCscDataIsNull(){
		return this.cscDataIsNull;
	}
	public CsCanQuery setCscDataIsNotNull(Boolean cscDataIsNotNull){
		this.cscDataIsNotNull = cscDataIsNotNull;
		return this;
	}
	public Boolean getCscDataIsNotNull(){
		return this.cscDataIsNotNull;
	}
	public CsCanQuery setCscDataStart(String cscDataStart){
		this.cscDataStart = cscDataStart;
		return this;
	}
	public String getCscDataStart(){
		return this.cscDataStart;
	}
	public CsCanQuery setCscDataEnd(String cscDataEnd){
		this.cscDataEnd = cscDataEnd;
		return this;
	}
	public String getCscDataEnd(){
		return this.cscDataEnd;
	}
	public CsCanQuery setCscDataLess(String cscDataLess){
		this.cscDataLess = cscDataLess;
		return this;
	}
	public String getCscDataLess(){
		return this.cscDataLess;
	}
	public CsCanQuery setCscDataGreater(String cscDataGreater){
		this.cscDataGreater = cscDataGreater;
		return this;
	}
	public String getCscDataGreater(){
		return this.cscDataGreater;
	}
	public CsCanQuery setCscUploadTimeEquals(Date cscUploadTimeEquals){
		this.cscUploadTimeEquals = cscUploadTimeEquals;
		return this;
	}
	public Date getCscUploadTimeEquals(){
		return this.cscUploadTimeEquals;
	}
	public CsCanQuery setCscUploadTimeIn(Date[] cscUploadTimeIn){
		this.cscUploadTimeIn = cscUploadTimeIn;
		return this;
	}
	public Date[] getCscUploadTimeIn(){
		return this.cscUploadTimeIn;
	}
	public CsCanQuery setCscUploadTimeIsNull(Boolean cscUploadTimeIsNull){
		this.cscUploadTimeIsNull = cscUploadTimeIsNull;
		return this;
	}
	public Boolean getCscUploadTimeIsNull(){
		return this.cscUploadTimeIsNull;
	}
	public CsCanQuery setCscUploadTimeIsNotNull(Boolean cscUploadTimeIsNotNull){
		this.cscUploadTimeIsNotNull = cscUploadTimeIsNotNull;
		return this;
	}
	public Boolean getCscUploadTimeIsNotNull(){
		return this.cscUploadTimeIsNotNull;
	}
	public CsCanQuery setCscUploadTimeStart(Date cscUploadTimeStart){
		this.cscUploadTimeStart = cscUploadTimeStart;
		return this;
	}
	public Date getCscUploadTimeStart(){
		return this.cscUploadTimeStart;
	}
	public CsCanQuery setCscUploadTimeEnd(Date cscUploadTimeEnd){
		this.cscUploadTimeEnd = cscUploadTimeEnd;
		return this;
	}
	public Date getCscUploadTimeEnd(){
		return this.cscUploadTimeEnd;
	}
	public CsCanQuery setCscUploadTimeLess(Date cscUploadTimeLess){
		this.cscUploadTimeLess = cscUploadTimeLess;
		return this;
	}
	public Date getCscUploadTimeLess(){
		return this.cscUploadTimeLess;
	}
	public CsCanQuery setCscUploadTimeGreater(Date cscUploadTimeGreater){
		this.cscUploadTimeGreater = cscUploadTimeGreater;
		return this;
	}
	public Date getCscUploadTimeGreater(){
		return this.cscUploadTimeGreater;
	}
	public CsCanQuery setCscAddTimeEquals(Date cscAddTimeEquals){
		this.cscAddTimeEquals = cscAddTimeEquals;
		return this;
	}
	public Date getCscAddTimeEquals(){
		return this.cscAddTimeEquals;
	}
	public CsCanQuery setCscAddTimeIn(Date[] cscAddTimeIn){
		this.cscAddTimeIn = cscAddTimeIn;
		return this;
	}
	public Date[] getCscAddTimeIn(){
		return this.cscAddTimeIn;
	}
	public CsCanQuery setCscAddTimeIsNull(Boolean cscAddTimeIsNull){
		this.cscAddTimeIsNull = cscAddTimeIsNull;
		return this;
	}
	public Boolean getCscAddTimeIsNull(){
		return this.cscAddTimeIsNull;
	}
	public CsCanQuery setCscAddTimeIsNotNull(Boolean cscAddTimeIsNotNull){
		this.cscAddTimeIsNotNull = cscAddTimeIsNotNull;
		return this;
	}
	public Boolean getCscAddTimeIsNotNull(){
		return this.cscAddTimeIsNotNull;
	}
	public CsCanQuery setCscAddTimeStart(Date cscAddTimeStart){
		this.cscAddTimeStart = cscAddTimeStart;
		return this;
	}
	public Date getCscAddTimeStart(){
		return this.cscAddTimeStart;
	}
	public CsCanQuery setCscAddTimeEnd(Date cscAddTimeEnd){
		this.cscAddTimeEnd = cscAddTimeEnd;
		return this;
	}
	public Date getCscAddTimeEnd(){
		return this.cscAddTimeEnd;
	}
	public CsCanQuery setCscAddTimeLess(Date cscAddTimeLess){
		this.cscAddTimeLess = cscAddTimeLess;
		return this;
	}
	public Date getCscAddTimeLess(){
		return this.cscAddTimeLess;
	}
	public CsCanQuery setCscAddTimeGreater(Date cscAddTimeGreater){
		this.cscAddTimeGreater = cscAddTimeGreater;
		return this;
	}
	public Date getCscAddTimeGreater(){
		return this.cscAddTimeGreater;
	}
	public CsCanQuery setCscStatusEquals(Short cscStatusEquals){
		this.cscStatusEquals = cscStatusEquals;
		return this;
	}
	public Short getCscStatusEquals(){
		return this.cscStatusEquals;
	}
	public CsCanQuery setCscStatusIn(Short[] cscStatusIn){
		this.cscStatusIn = cscStatusIn;
		return this;
	}
	public Short[] getCscStatusIn(){
		return this.cscStatusIn;
	}
	public CsCanQuery setCscStatusIsNull(Boolean cscStatusIsNull){
		this.cscStatusIsNull = cscStatusIsNull;
		return this;
	}
	public Boolean getCscStatusIsNull(){
		return this.cscStatusIsNull;
	}
	public CsCanQuery setCscStatusIsNotNull(Boolean cscStatusIsNotNull){
		this.cscStatusIsNotNull = cscStatusIsNotNull;
		return this;
	}
	public Boolean getCscStatusIsNotNull(){
		return this.cscStatusIsNotNull;
	}
	public CsCanQuery setCscStatusStart(Short cscStatusStart){
		this.cscStatusStart = cscStatusStart;
		return this;
	}
	public Short getCscStatusStart(){
		return this.cscStatusStart;
	}
	public CsCanQuery setCscStatusEnd(Short cscStatusEnd){
		this.cscStatusEnd = cscStatusEnd;
		return this;
	}
	public Short getCscStatusEnd(){
		return this.cscStatusEnd;
	}
	public CsCanQuery setCscStatusLess(Short cscStatusLess){
		this.cscStatusLess = cscStatusLess;
		return this;
	}
	public Short getCscStatusLess(){
		return this.cscStatusLess;
	}
	public CsCanQuery setCscStatusGreater(Short cscStatusGreater){
		this.cscStatusGreater = cscStatusGreater;
		return this;
	}
	public Short getCscStatusGreater(){
		return this.cscStatusGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("cscId")){
			return "csc_id";
		}
		else if(this.sidx.equals("cscAccess")){
			return "csc_access";
		}
		else if(this.sidx.equals("cscNumber")){
			return "csc_number";
		}
		else if(this.sidx.equals("cscCar")){
			return "csc_car";
		}
		else if(this.sidx.equals("cscModel")){
			return "csc_model";
		}
		else if(this.sidx.equals("cscType")){
			return "csc_type";
		}
		else if(this.sidx.equals("cscOrder")){
			return "csc_order";
		}
		else if(this.sidx.equals("cscData")){
			return "csc_data";
		}
		else if(this.sidx.equals("cscUploadTime")){
			return "csc_upload_time";
		}
		else if(this.sidx.equals("cscAddTime")){
			return "csc_add_time";
		}
		else if(this.sidx.equals("cscStatus")){
			return "csc_status";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsCanCrieria getCrieria(){
		CsCanCrieria q = new CsCanCrieria();
		CsCanCrieria.Criteria c = q.createCriteria();
		
		if(this.getCscIdEquals()!=null){
			c.andcscIdEqualTo(this.getCscIdEquals());
		}else if(this.getCscIdIsNull()!=null && this.getCscIdIsNull()){
			c.andcscIdIsNull();
		}else if(this.getCscIdIsNotNull()!=null && this.getCscIdIsNotNull()){
			c.andcscIdIsNotNull();
		}else if(this.getCscIdIn()!=null){
			c.andcscIdIn(java.util.Arrays.asList(this.getCscIdIn()));
		}else if(this.getCscIdStart()!=null && this.getCscIdEnd()!=null){
			c.andcscIdBetween(this.getCscIdStart(), this.getCscIdEnd());
		}else if(this.getCscIdGreater()!=null){
			c.andcscIdGreaterThan(this.getCscIdGreater());
		}else if(this.getCscIdLess()!=null){
			c.andcscIdLessThan(this.getCscIdLess());
		}
		if(this.getCscAccessEquals()!=null){
			c.andcscAccessEqualTo(this.getCscAccessEquals());
		}else if(this.getCscAccessIsNull()!=null && this.getCscAccessIsNull()){
			c.andcscAccessIsNull();
		}else if(this.getCscAccessIsNotNull()!=null && this.getCscAccessIsNotNull()){
			c.andcscAccessIsNotNull();
		}else if(this.getCscAccessIn()!=null){
			c.andcscAccessIn(java.util.Arrays.asList(this.getCscAccessIn()));
		}else if(this.getCscAccessStart()!=null && this.getCscAccessEnd()!=null){
			c.andcscAccessBetween(this.getCscAccessStart(), this.getCscAccessEnd());
		}else if(this.getCscAccessGreater()!=null){
			c.andcscAccessGreaterThan(this.getCscAccessGreater());
		}else if(this.getCscAccessLess()!=null){
			c.andcscAccessLessThan(this.getCscAccessLess());
		}
		if(this.getCscNumberEquals()!=null){
			c.andcscNumberEqualTo(this.getCscNumberEquals());
		}else if(this.getCscNumberIsNull()!=null && this.getCscNumberIsNull()){
			c.andcscNumberIsNull();
		}else if(this.getCscNumberIsNotNull()!=null && this.getCscNumberIsNotNull()){
			c.andcscNumberIsNotNull();
		}else if(this.getCscNumberLike()!=null){
			c.andcscNumberLike(this.getCscNumberLike());
		}else if(this.getCscNumberIn()!=null){
			c.andcscNumberIn(java.util.Arrays.asList(this.getCscNumberIn()));
		}else if(this.getCscNumberStart()!=null && this.getCscNumberEnd()!=null){
			c.andcscNumberBetween(this.getCscNumberStart(), this.getCscNumberEnd());
		}else if(this.getCscNumberGreater()!=null){
			c.andcscNumberGreaterThan(this.getCscNumberGreater());
		}else if(this.getCscNumberLess()!=null){
			c.andcscNumberLessThan(this.getCscNumberLess());
		}
		if(this.getCscCarEquals()!=null){
			c.andcscCarEqualTo(this.getCscCarEquals());
		}else if(this.getCscCarIsNull()!=null && this.getCscCarIsNull()){
			c.andcscCarIsNull();
		}else if(this.getCscCarIsNotNull()!=null && this.getCscCarIsNotNull()){
			c.andcscCarIsNotNull();
		}else if(this.getCscCarIn()!=null){
			c.andcscCarIn(java.util.Arrays.asList(this.getCscCarIn()));
		}else if(this.getCscCarStart()!=null && this.getCscCarEnd()!=null){
			c.andcscCarBetween(this.getCscCarStart(), this.getCscCarEnd());
		}else if(this.getCscCarGreater()!=null){
			c.andcscCarGreaterThan(this.getCscCarGreater());
		}else if(this.getCscCarLess()!=null){
			c.andcscCarLessThan(this.getCscCarLess());
		}
		if(this.getCscModelEquals()!=null){
			c.andcscModelEqualTo(this.getCscModelEquals());
		}else if(this.getCscModelIsNull()!=null && this.getCscModelIsNull()){
			c.andcscModelIsNull();
		}else if(this.getCscModelIsNotNull()!=null && this.getCscModelIsNotNull()){
			c.andcscModelIsNotNull();
		}else if(this.getCscModelIn()!=null){
			c.andcscModelIn(java.util.Arrays.asList(this.getCscModelIn()));
		}else if(this.getCscModelStart()!=null && this.getCscModelEnd()!=null){
			c.andcscModelBetween(this.getCscModelStart(), this.getCscModelEnd());
		}else if(this.getCscModelGreater()!=null){
			c.andcscModelGreaterThan(this.getCscModelGreater());
		}else if(this.getCscModelLess()!=null){
			c.andcscModelLessThan(this.getCscModelLess());
		}
		if(this.getCscTypeEquals()!=null){
			c.andcscTypeEqualTo(this.getCscTypeEquals());
		}else if(this.getCscTypeIsNull()!=null && this.getCscTypeIsNull()){
			c.andcscTypeIsNull();
		}else if(this.getCscTypeIsNotNull()!=null && this.getCscTypeIsNotNull()){
			c.andcscTypeIsNotNull();
		}else if(this.getCscTypeIn()!=null){
			c.andcscTypeIn(java.util.Arrays.asList(this.getCscTypeIn()));
		}else if(this.getCscTypeStart()!=null && this.getCscTypeEnd()!=null){
			c.andcscTypeBetween(this.getCscTypeStart(), this.getCscTypeEnd());
		}else if(this.getCscTypeGreater()!=null){
			c.andcscTypeGreaterThan(this.getCscTypeGreater());
		}else if(this.getCscTypeLess()!=null){
			c.andcscTypeLessThan(this.getCscTypeLess());
		}
		if(this.getCscOrderEquals()!=null){
			c.andcscOrderEqualTo(this.getCscOrderEquals());
		}else if(this.getCscOrderIsNull()!=null && this.getCscOrderIsNull()){
			c.andcscOrderIsNull();
		}else if(this.getCscOrderIsNotNull()!=null && this.getCscOrderIsNotNull()){
			c.andcscOrderIsNotNull();
		}else if(this.getCscOrderIn()!=null){
			c.andcscOrderIn(java.util.Arrays.asList(this.getCscOrderIn()));
		}else if(this.getCscOrderStart()!=null && this.getCscOrderEnd()!=null){
			c.andcscOrderBetween(this.getCscOrderStart(), this.getCscOrderEnd());
		}else if(this.getCscOrderGreater()!=null){
			c.andcscOrderGreaterThan(this.getCscOrderGreater());
		}else if(this.getCscOrderLess()!=null){
			c.andcscOrderLessThan(this.getCscOrderLess());
		}
		if(this.getCscDataEquals()!=null){
			c.andcscDataEqualTo(this.getCscDataEquals());
		}else if(this.getCscDataIsNull()!=null && this.getCscDataIsNull()){
			c.andcscDataIsNull();
		}else if(this.getCscDataIsNotNull()!=null && this.getCscDataIsNotNull()){
			c.andcscDataIsNotNull();
		}else if(this.getCscDataLike()!=null){
			c.andcscDataLike(this.getCscDataLike());
		}else if(this.getCscDataIn()!=null){
			c.andcscDataIn(java.util.Arrays.asList(this.getCscDataIn()));
		}else if(this.getCscDataStart()!=null && this.getCscDataEnd()!=null){
			c.andcscDataBetween(this.getCscDataStart(), this.getCscDataEnd());
		}else if(this.getCscDataGreater()!=null){
			c.andcscDataGreaterThan(this.getCscDataGreater());
		}else if(this.getCscDataLess()!=null){
			c.andcscDataLessThan(this.getCscDataLess());
		}
		if(this.getCscUploadTimeEquals()!=null){
			c.andcscUploadTimeEqualTo(this.getCscUploadTimeEquals());
		}else if(this.getCscUploadTimeIsNull()!=null && this.getCscUploadTimeIsNull()){
			c.andcscUploadTimeIsNull();
		}else if(this.getCscUploadTimeIsNotNull()!=null && this.getCscUploadTimeIsNotNull()){
			c.andcscUploadTimeIsNotNull();
		}else if(this.getCscUploadTimeIn()!=null){
			c.andcscUploadTimeIn(java.util.Arrays.asList(this.getCscUploadTimeIn()));
		}else if(this.getCscUploadTimeStart()!=null && this.getCscUploadTimeEnd()!=null){
			c.andcscUploadTimeBetween(this.getCscUploadTimeStart(), this.getCscUploadTimeEnd());
		}else if(this.getCscUploadTimeGreater()!=null){
			c.andcscUploadTimeGreaterThan(this.getCscUploadTimeGreater());
		}else if(this.getCscUploadTimeLess()!=null){
			c.andcscUploadTimeLessThan(this.getCscUploadTimeLess());
		}
		if(this.getCscAddTimeEquals()!=null){
			c.andcscAddTimeEqualTo(this.getCscAddTimeEquals());
		}else if(this.getCscAddTimeIsNull()!=null && this.getCscAddTimeIsNull()){
			c.andcscAddTimeIsNull();
		}else if(this.getCscAddTimeIsNotNull()!=null && this.getCscAddTimeIsNotNull()){
			c.andcscAddTimeIsNotNull();
		}else if(this.getCscAddTimeIn()!=null){
			c.andcscAddTimeIn(java.util.Arrays.asList(this.getCscAddTimeIn()));
		}else if(this.getCscAddTimeStart()!=null && this.getCscAddTimeEnd()!=null){
			c.andcscAddTimeBetween(this.getCscAddTimeStart(), this.getCscAddTimeEnd());
		}else if(this.getCscAddTimeGreater()!=null){
			c.andcscAddTimeGreaterThan(this.getCscAddTimeGreater());
		}else if(this.getCscAddTimeLess()!=null){
			c.andcscAddTimeLessThan(this.getCscAddTimeLess());
		}
		if(this.getCscStatusEquals()!=null){
			c.andcscStatusEqualTo(this.getCscStatusEquals());
		}else if(this.getCscStatusIsNull()!=null && this.getCscStatusIsNull()){
			c.andcscStatusIsNull();
		}else if(this.getCscStatusIsNotNull()!=null && this.getCscStatusIsNotNull()){
			c.andcscStatusIsNotNull();
		}else if(this.getCscStatusIn()!=null){
			c.andcscStatusIn(java.util.Arrays.asList(this.getCscStatusIn()));
		}else if(this.getCscStatusStart()!=null && this.getCscStatusEnd()!=null){
			c.andcscStatusBetween(this.getCscStatusStart(), this.getCscStatusEnd());
		}else if(this.getCscStatusGreater()!=null){
			c.andcscStatusGreaterThan(this.getCscStatusGreater());
		}else if(this.getCscStatusLess()!=null){
			c.andcscStatusLessThan(this.getCscStatusLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
