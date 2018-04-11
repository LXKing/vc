package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.GbStateCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class GbStateQuery {
	
	private Integer gsIdEquals;
	private Integer[] gsIdIn;
	private Boolean gsIdIsNull;
	private Boolean gsIdIsNotNull;
	
	private Integer gsIdStart;
	
	private Integer gsIdEnd;
	
	private Integer gsIdLess;
	
	private Integer gsIdGreater;
	private String vinLike;
	
	private String vinEquals;
	private String[] vinIn;
	private Boolean vinIsNull;
	private Boolean vinIsNotNull;
	
	private String vinStart;
	
	private String vinEnd;
	
	private String vinLess;
	
	private String vinGreater;
	private String timeTextLike;
	
	private String timeTextEquals;
	private String[] timeTextIn;
	private Boolean timeTextIsNull;
	private Boolean timeTextIsNotNull;
	
	private String timeTextStart;
	
	private String timeTextEnd;
	
	private String timeTextLess;
	
	private String timeTextGreater;
	private String vehicleStatusStringLike;
	
	private String vehicleStatusStringEquals;
	private String[] vehicleStatusStringIn;
	private Boolean vehicleStatusStringIsNull;
	private Boolean vehicleStatusStringIsNotNull;
	
	private String vehicleStatusStringStart;
	
	private String vehicleStatusStringEnd;
	
	private String vehicleStatusStringLess;
	
	private String vehicleStatusStringGreater;
	private String chargingStringLike;
	
	private String chargingStringEquals;
	private String[] chargingStringIn;
	private Boolean chargingStringIsNull;
	private Boolean chargingStringIsNotNull;
	
	private String chargingStringStart;
	
	private String chargingStringEnd;
	
	private String chargingStringLess;
	
	private String chargingStringGreater;
	private String runningModeStringLike;
	
	private String runningModeStringEquals;
	private String[] runningModeStringIn;
	private Boolean runningModeStringIsNull;
	private Boolean runningModeStringIsNotNull;
	
	private String runningModeStringStart;
	
	private String runningModeStringEnd;
	
	private String runningModeStringLess;
	
	private String runningModeStringGreater;
	private String speedStringLike;
	
	private String speedStringEquals;
	private String[] speedStringIn;
	private Boolean speedStringIsNull;
	private Boolean speedStringIsNotNull;
	
	private String speedStringStart;
	
	private String speedStringEnd;
	
	private String speedStringLess;
	
	private String speedStringGreater;
	private String mileageStringLike;
	
	private String mileageStringEquals;
	private String[] mileageStringIn;
	private Boolean mileageStringIsNull;
	private Boolean mileageStringIsNotNull;
	
	private String mileageStringStart;
	
	private String mileageStringEnd;
	
	private String mileageStringLess;
	
	private String mileageStringGreater;
	private String voltageStringLike;
	
	private String voltageStringEquals;
	private String[] voltageStringIn;
	private Boolean voltageStringIsNull;
	private Boolean voltageStringIsNotNull;
	
	private String voltageStringStart;
	
	private String voltageStringEnd;
	
	private String voltageStringLess;
	
	private String voltageStringGreater;
	private String currentStringLike;
	
	private String currentStringEquals;
	private String[] currentStringIn;
	private Boolean currentStringIsNull;
	private Boolean currentStringIsNotNull;
	
	private String currentStringStart;
	
	private String currentStringEnd;
	
	private String currentStringLess;
	
	private String currentStringGreater;
	private String socStringLike;
	
	private String socStringEquals;
	private String[] socStringIn;
	private Boolean socStringIsNull;
	private Boolean socStringIsNotNull;
	
	private String socStringStart;
	
	private String socStringEnd;
	
	private String socStringLess;
	
	private String socStringGreater;
	private String dcDcStatusStringLike;
	
	private String dcDcStatusStringEquals;
	private String[] dcDcStatusStringIn;
	private Boolean dcDcStatusStringIsNull;
	private Boolean dcDcStatusStringIsNotNull;
	
	private String dcDcStatusStringStart;
	
	private String dcDcStatusStringEnd;
	
	private String dcDcStatusStringLess;
	
	private String dcDcStatusStringGreater;
	private String gearStringLike;
	
	private String gearStringEquals;
	private String[] gearStringIn;
	private Boolean gearStringIsNull;
	private Boolean gearStringIsNotNull;
	
	private String gearStringStart;
	
	private String gearStringEnd;
	
	private String gearStringLess;
	
	private String gearStringGreater;
	private String insulationResistanceStringLike;
	
	private String insulationResistanceStringEquals;
	private String[] insulationResistanceStringIn;
	private Boolean insulationResistanceStringIsNull;
	private Boolean insulationResistanceStringIsNotNull;
	
	private String insulationResistanceStringStart;
	
	private String insulationResistanceStringEnd;
	
	private String insulationResistanceStringLess;
	
	private String insulationResistanceStringGreater;
	private String acceleratedPedalStrokeValueStringLike;
	
	private String acceleratedPedalStrokeValueStringEquals;
	private String[] acceleratedPedalStrokeValueStringIn;
	private Boolean acceleratedPedalStrokeValueStringIsNull;
	private Boolean acceleratedPedalStrokeValueStringIsNotNull;
	
	private String acceleratedPedalStrokeValueStringStart;
	
	private String acceleratedPedalStrokeValueStringEnd;
	
	private String acceleratedPedalStrokeValueStringLess;
	
	private String acceleratedPedalStrokeValueStringGreater;
	private String brakePedalStateStringLike;
	
	private String brakePedalStateStringEquals;
	private String[] brakePedalStateStringIn;
	private Boolean brakePedalStateStringIsNull;
	private Boolean brakePedalStateStringIsNotNull;
	
	private String brakePedalStateStringStart;
	
	private String brakePedalStateStringEnd;
	
	private String brakePedalStateStringLess;
	
	private String brakePedalStateStringGreater;
	private String positionStatusStringLike;
	
	private String positionStatusStringEquals;
	private String[] positionStatusStringIn;
	private Boolean positionStatusStringIsNull;
	private Boolean positionStatusStringIsNotNull;
	
	private String positionStatusStringStart;
	
	private String positionStatusStringEnd;
	
	private String positionStatusStringLess;
	
	private String positionStatusStringGreater;
	
	private Long longitudeStringEquals;
	private Long[] longitudeStringIn;
	private Boolean longitudeStringIsNull;
	private Boolean longitudeStringIsNotNull;
	
	private Long longitudeStringStart;
	
	private Long longitudeStringEnd;
	
	private Long longitudeStringLess;
	
	private Long longitudeStringGreater;
	
	private Long latitudeStringEquals;
	private Long[] latitudeStringIn;
	private Boolean latitudeStringIsNull;
	private Boolean latitudeStringIsNotNull;
	
	private Long latitudeStringStart;
	
	private Long latitudeStringEnd;
	
	private Long latitudeStringLess;
	
	private Long latitudeStringGreater;
	private String sidx;
	private String sord;

	public GbStateQuery setGsIdEquals(Integer gsIdEquals){
		this.gsIdEquals = gsIdEquals;
		return this;
	}
	public Integer getGsIdEquals(){
		return this.gsIdEquals;
	}
	public GbStateQuery setGsIdIn(Integer[] gsIdIn){
		this.gsIdIn = gsIdIn;
		return this;
	}
	public Integer[] getGsIdIn(){
		return this.gsIdIn;
	}
	public GbStateQuery setGsIdIsNull(Boolean gsIdIsNull){
		this.gsIdIsNull = gsIdIsNull;
		return this;
	}
	public Boolean getGsIdIsNull(){
		return this.gsIdIsNull;
	}
	public GbStateQuery setGsIdIsNotNull(Boolean gsIdIsNotNull){
		this.gsIdIsNotNull = gsIdIsNotNull;
		return this;
	}
	public Boolean getGsIdIsNotNull(){
		return this.gsIdIsNotNull;
	}
	public GbStateQuery setGsIdStart(Integer gsIdStart){
		this.gsIdStart = gsIdStart;
		return this;
	}
	public Integer getGsIdStart(){
		return this.gsIdStart;
	}
	public GbStateQuery setGsIdEnd(Integer gsIdEnd){
		this.gsIdEnd = gsIdEnd;
		return this;
	}
	public Integer getGsIdEnd(){
		return this.gsIdEnd;
	}
	public GbStateQuery setGsIdLess(Integer gsIdLess){
		this.gsIdLess = gsIdLess;
		return this;
	}
	public Integer getGsIdLess(){
		return this.gsIdLess;
	}
	public GbStateQuery setGsIdGreater(Integer gsIdGreater){
		this.gsIdGreater = gsIdGreater;
		return this;
	}
	public Integer getGsIdGreater(){
		return this.gsIdGreater;
	}
	public GbStateQuery setvinLike(String vinLike){
		this.vinLike = vinLike;
		return this;
	}
	public String getvinLike(){
		return this.vinLike;
	}
	public GbStateQuery setvinEquals(String vinEquals){
		this.vinEquals = vinEquals;
		return this;
	}
	public String getvinEquals(){
		return this.vinEquals;
	}
	public GbStateQuery setvinIn(String[] vinIn){
		this.vinIn = vinIn;
		return this;
	}
	public String[] getvinIn(){
		return this.vinIn;
	}
	public GbStateQuery setvinIsNull(Boolean vinIsNull){
		this.vinIsNull = vinIsNull;
		return this;
	}
	public Boolean getvinIsNull(){
		return this.vinIsNull;
	}
	public GbStateQuery setvinIsNotNull(Boolean vinIsNotNull){
		this.vinIsNotNull = vinIsNotNull;
		return this;
	}
	public Boolean getvinIsNotNull(){
		return this.vinIsNotNull;
	}
	public GbStateQuery setvinStart(String vinStart){
		this.vinStart = vinStart;
		return this;
	}
	public String getvinStart(){
		return this.vinStart;
	}
	public GbStateQuery setvinEnd(String vinEnd){
		this.vinEnd = vinEnd;
		return this;
	}
	public String getvinEnd(){
		return this.vinEnd;
	}
	public GbStateQuery setvinLess(String vinLess){
		this.vinLess = vinLess;
		return this;
	}
	public String getvinLess(){
		return this.vinLess;
	}
	public GbStateQuery setvinGreater(String vinGreater){
		this.vinGreater = vinGreater;
		return this;
	}
	public String getvinGreater(){
		return this.vinGreater;
	}
	public GbStateQuery setTimeTextLike(String timeTextLike){
		this.timeTextLike = timeTextLike;
		return this;
	}
	public String getTimeTextLike(){
		return this.timeTextLike;
	}
	public GbStateQuery setTimeTextEquals(String timeTextEquals){
		this.timeTextEquals = timeTextEquals;
		return this;
	}
	public String getTimeTextEquals(){
		return this.timeTextEquals;
	}
	public GbStateQuery setTimeTextIn(String[] timeTextIn){
		this.timeTextIn = timeTextIn;
		return this;
	}
	public String[] getTimeTextIn(){
		return this.timeTextIn;
	}
	public GbStateQuery setTimeTextIsNull(Boolean timeTextIsNull){
		this.timeTextIsNull = timeTextIsNull;
		return this;
	}
	public Boolean getTimeTextIsNull(){
		return this.timeTextIsNull;
	}
	public GbStateQuery setTimeTextIsNotNull(Boolean timeTextIsNotNull){
		this.timeTextIsNotNull = timeTextIsNotNull;
		return this;
	}
	public Boolean getTimeTextIsNotNull(){
		return this.timeTextIsNotNull;
	}
	public GbStateQuery setTimeTextStart(String timeTextStart){
		this.timeTextStart = timeTextStart;
		return this;
	}
	public String getTimeTextStart(){
		return this.timeTextStart;
	}
	public GbStateQuery setTimeTextEnd(String timeTextEnd){
		this.timeTextEnd = timeTextEnd;
		return this;
	}
	public String getTimeTextEnd(){
		return this.timeTextEnd;
	}
	public GbStateQuery setTimeTextLess(String timeTextLess){
		this.timeTextLess = timeTextLess;
		return this;
	}
	public String getTimeTextLess(){
		return this.timeTextLess;
	}
	public GbStateQuery setTimeTextGreater(String timeTextGreater){
		this.timeTextGreater = timeTextGreater;
		return this;
	}
	public String getTimeTextGreater(){
		return this.timeTextGreater;
	}
	public GbStateQuery setVehicleStatusStringLike(String vehicleStatusStringLike){
		this.vehicleStatusStringLike = vehicleStatusStringLike;
		return this;
	}
	public String getVehicleStatusStringLike(){
		return this.vehicleStatusStringLike;
	}
	public GbStateQuery setVehicleStatusStringEquals(String vehicleStatusStringEquals){
		this.vehicleStatusStringEquals = vehicleStatusStringEquals;
		return this;
	}
	public String getVehicleStatusStringEquals(){
		return this.vehicleStatusStringEquals;
	}
	public GbStateQuery setVehicleStatusStringIn(String[] vehicleStatusStringIn){
		this.vehicleStatusStringIn = vehicleStatusStringIn;
		return this;
	}
	public String[] getVehicleStatusStringIn(){
		return this.vehicleStatusStringIn;
	}
	public GbStateQuery setVehicleStatusStringIsNull(Boolean vehicleStatusStringIsNull){
		this.vehicleStatusStringIsNull = vehicleStatusStringIsNull;
		return this;
	}
	public Boolean getVehicleStatusStringIsNull(){
		return this.vehicleStatusStringIsNull;
	}
	public GbStateQuery setVehicleStatusStringIsNotNull(Boolean vehicleStatusStringIsNotNull){
		this.vehicleStatusStringIsNotNull = vehicleStatusStringIsNotNull;
		return this;
	}
	public Boolean getVehicleStatusStringIsNotNull(){
		return this.vehicleStatusStringIsNotNull;
	}
	public GbStateQuery setVehicleStatusStringStart(String vehicleStatusStringStart){
		this.vehicleStatusStringStart = vehicleStatusStringStart;
		return this;
	}
	public String getVehicleStatusStringStart(){
		return this.vehicleStatusStringStart;
	}
	public GbStateQuery setVehicleStatusStringEnd(String vehicleStatusStringEnd){
		this.vehicleStatusStringEnd = vehicleStatusStringEnd;
		return this;
	}
	public String getVehicleStatusStringEnd(){
		return this.vehicleStatusStringEnd;
	}
	public GbStateQuery setVehicleStatusStringLess(String vehicleStatusStringLess){
		this.vehicleStatusStringLess = vehicleStatusStringLess;
		return this;
	}
	public String getVehicleStatusStringLess(){
		return this.vehicleStatusStringLess;
	}
	public GbStateQuery setVehicleStatusStringGreater(String vehicleStatusStringGreater){
		this.vehicleStatusStringGreater = vehicleStatusStringGreater;
		return this;
	}
	public String getVehicleStatusStringGreater(){
		return this.vehicleStatusStringGreater;
	}
	public GbStateQuery setChargingStringLike(String chargingStringLike){
		this.chargingStringLike = chargingStringLike;
		return this;
	}
	public String getChargingStringLike(){
		return this.chargingStringLike;
	}
	public GbStateQuery setChargingStringEquals(String chargingStringEquals){
		this.chargingStringEquals = chargingStringEquals;
		return this;
	}
	public String getChargingStringEquals(){
		return this.chargingStringEquals;
	}
	public GbStateQuery setChargingStringIn(String[] chargingStringIn){
		this.chargingStringIn = chargingStringIn;
		return this;
	}
	public String[] getChargingStringIn(){
		return this.chargingStringIn;
	}
	public GbStateQuery setChargingStringIsNull(Boolean chargingStringIsNull){
		this.chargingStringIsNull = chargingStringIsNull;
		return this;
	}
	public Boolean getChargingStringIsNull(){
		return this.chargingStringIsNull;
	}
	public GbStateQuery setChargingStringIsNotNull(Boolean chargingStringIsNotNull){
		this.chargingStringIsNotNull = chargingStringIsNotNull;
		return this;
	}
	public Boolean getChargingStringIsNotNull(){
		return this.chargingStringIsNotNull;
	}
	public GbStateQuery setChargingStringStart(String chargingStringStart){
		this.chargingStringStart = chargingStringStart;
		return this;
	}
	public String getChargingStringStart(){
		return this.chargingStringStart;
	}
	public GbStateQuery setChargingStringEnd(String chargingStringEnd){
		this.chargingStringEnd = chargingStringEnd;
		return this;
	}
	public String getChargingStringEnd(){
		return this.chargingStringEnd;
	}
	public GbStateQuery setChargingStringLess(String chargingStringLess){
		this.chargingStringLess = chargingStringLess;
		return this;
	}
	public String getChargingStringLess(){
		return this.chargingStringLess;
	}
	public GbStateQuery setChargingStringGreater(String chargingStringGreater){
		this.chargingStringGreater = chargingStringGreater;
		return this;
	}
	public String getChargingStringGreater(){
		return this.chargingStringGreater;
	}
	public GbStateQuery setRunningModeStringLike(String runningModeStringLike){
		this.runningModeStringLike = runningModeStringLike;
		return this;
	}
	public String getRunningModeStringLike(){
		return this.runningModeStringLike;
	}
	public GbStateQuery setRunningModeStringEquals(String runningModeStringEquals){
		this.runningModeStringEquals = runningModeStringEquals;
		return this;
	}
	public String getRunningModeStringEquals(){
		return this.runningModeStringEquals;
	}
	public GbStateQuery setRunningModeStringIn(String[] runningModeStringIn){
		this.runningModeStringIn = runningModeStringIn;
		return this;
	}
	public String[] getRunningModeStringIn(){
		return this.runningModeStringIn;
	}
	public GbStateQuery setRunningModeStringIsNull(Boolean runningModeStringIsNull){
		this.runningModeStringIsNull = runningModeStringIsNull;
		return this;
	}
	public Boolean getRunningModeStringIsNull(){
		return this.runningModeStringIsNull;
	}
	public GbStateQuery setRunningModeStringIsNotNull(Boolean runningModeStringIsNotNull){
		this.runningModeStringIsNotNull = runningModeStringIsNotNull;
		return this;
	}
	public Boolean getRunningModeStringIsNotNull(){
		return this.runningModeStringIsNotNull;
	}
	public GbStateQuery setRunningModeStringStart(String runningModeStringStart){
		this.runningModeStringStart = runningModeStringStart;
		return this;
	}
	public String getRunningModeStringStart(){
		return this.runningModeStringStart;
	}
	public GbStateQuery setRunningModeStringEnd(String runningModeStringEnd){
		this.runningModeStringEnd = runningModeStringEnd;
		return this;
	}
	public String getRunningModeStringEnd(){
		return this.runningModeStringEnd;
	}
	public GbStateQuery setRunningModeStringLess(String runningModeStringLess){
		this.runningModeStringLess = runningModeStringLess;
		return this;
	}
	public String getRunningModeStringLess(){
		return this.runningModeStringLess;
	}
	public GbStateQuery setRunningModeStringGreater(String runningModeStringGreater){
		this.runningModeStringGreater = runningModeStringGreater;
		return this;
	}
	public String getRunningModeStringGreater(){
		return this.runningModeStringGreater;
	}
	public GbStateQuery setSpeedStringLike(String speedStringLike){
		this.speedStringLike = speedStringLike;
		return this;
	}
	public String getSpeedStringLike(){
		return this.speedStringLike;
	}
	public GbStateQuery setSpeedStringEquals(String speedStringEquals){
		this.speedStringEquals = speedStringEquals;
		return this;
	}
	public String getSpeedStringEquals(){
		return this.speedStringEquals;
	}
	public GbStateQuery setSpeedStringIn(String[] speedStringIn){
		this.speedStringIn = speedStringIn;
		return this;
	}
	public String[] getSpeedStringIn(){
		return this.speedStringIn;
	}
	public GbStateQuery setSpeedStringIsNull(Boolean speedStringIsNull){
		this.speedStringIsNull = speedStringIsNull;
		return this;
	}
	public Boolean getSpeedStringIsNull(){
		return this.speedStringIsNull;
	}
	public GbStateQuery setSpeedStringIsNotNull(Boolean speedStringIsNotNull){
		this.speedStringIsNotNull = speedStringIsNotNull;
		return this;
	}
	public Boolean getSpeedStringIsNotNull(){
		return this.speedStringIsNotNull;
	}
	public GbStateQuery setSpeedStringStart(String speedStringStart){
		this.speedStringStart = speedStringStart;
		return this;
	}
	public String getSpeedStringStart(){
		return this.speedStringStart;
	}
	public GbStateQuery setSpeedStringEnd(String speedStringEnd){
		this.speedStringEnd = speedStringEnd;
		return this;
	}
	public String getSpeedStringEnd(){
		return this.speedStringEnd;
	}
	public GbStateQuery setSpeedStringLess(String speedStringLess){
		this.speedStringLess = speedStringLess;
		return this;
	}
	public String getSpeedStringLess(){
		return this.speedStringLess;
	}
	public GbStateQuery setSpeedStringGreater(String speedStringGreater){
		this.speedStringGreater = speedStringGreater;
		return this;
	}
	public String getSpeedStringGreater(){
		return this.speedStringGreater;
	}
	public GbStateQuery setMileageStringLike(String mileageStringLike){
		this.mileageStringLike = mileageStringLike;
		return this;
	}
	public String getMileageStringLike(){
		return this.mileageStringLike;
	}
	public GbStateQuery setMileageStringEquals(String mileageStringEquals){
		this.mileageStringEquals = mileageStringEquals;
		return this;
	}
	public String getMileageStringEquals(){
		return this.mileageStringEquals;
	}
	public GbStateQuery setMileageStringIn(String[] mileageStringIn){
		this.mileageStringIn = mileageStringIn;
		return this;
	}
	public String[] getMileageStringIn(){
		return this.mileageStringIn;
	}
	public GbStateQuery setMileageStringIsNull(Boolean mileageStringIsNull){
		this.mileageStringIsNull = mileageStringIsNull;
		return this;
	}
	public Boolean getMileageStringIsNull(){
		return this.mileageStringIsNull;
	}
	public GbStateQuery setMileageStringIsNotNull(Boolean mileageStringIsNotNull){
		this.mileageStringIsNotNull = mileageStringIsNotNull;
		return this;
	}
	public Boolean getMileageStringIsNotNull(){
		return this.mileageStringIsNotNull;
	}
	public GbStateQuery setMileageStringStart(String mileageStringStart){
		this.mileageStringStart = mileageStringStart;
		return this;
	}
	public String getMileageStringStart(){
		return this.mileageStringStart;
	}
	public GbStateQuery setMileageStringEnd(String mileageStringEnd){
		this.mileageStringEnd = mileageStringEnd;
		return this;
	}
	public String getMileageStringEnd(){
		return this.mileageStringEnd;
	}
	public GbStateQuery setMileageStringLess(String mileageStringLess){
		this.mileageStringLess = mileageStringLess;
		return this;
	}
	public String getMileageStringLess(){
		return this.mileageStringLess;
	}
	public GbStateQuery setMileageStringGreater(String mileageStringGreater){
		this.mileageStringGreater = mileageStringGreater;
		return this;
	}
	public String getMileageStringGreater(){
		return this.mileageStringGreater;
	}
	public GbStateQuery setVoltageStringLike(String voltageStringLike){
		this.voltageStringLike = voltageStringLike;
		return this;
	}
	public String getVoltageStringLike(){
		return this.voltageStringLike;
	}
	public GbStateQuery setVoltageStringEquals(String voltageStringEquals){
		this.voltageStringEquals = voltageStringEquals;
		return this;
	}
	public String getVoltageStringEquals(){
		return this.voltageStringEquals;
	}
	public GbStateQuery setVoltageStringIn(String[] voltageStringIn){
		this.voltageStringIn = voltageStringIn;
		return this;
	}
	public String[] getVoltageStringIn(){
		return this.voltageStringIn;
	}
	public GbStateQuery setVoltageStringIsNull(Boolean voltageStringIsNull){
		this.voltageStringIsNull = voltageStringIsNull;
		return this;
	}
	public Boolean getVoltageStringIsNull(){
		return this.voltageStringIsNull;
	}
	public GbStateQuery setVoltageStringIsNotNull(Boolean voltageStringIsNotNull){
		this.voltageStringIsNotNull = voltageStringIsNotNull;
		return this;
	}
	public Boolean getVoltageStringIsNotNull(){
		return this.voltageStringIsNotNull;
	}
	public GbStateQuery setVoltageStringStart(String voltageStringStart){
		this.voltageStringStart = voltageStringStart;
		return this;
	}
	public String getVoltageStringStart(){
		return this.voltageStringStart;
	}
	public GbStateQuery setVoltageStringEnd(String voltageStringEnd){
		this.voltageStringEnd = voltageStringEnd;
		return this;
	}
	public String getVoltageStringEnd(){
		return this.voltageStringEnd;
	}
	public GbStateQuery setVoltageStringLess(String voltageStringLess){
		this.voltageStringLess = voltageStringLess;
		return this;
	}
	public String getVoltageStringLess(){
		return this.voltageStringLess;
	}
	public GbStateQuery setVoltageStringGreater(String voltageStringGreater){
		this.voltageStringGreater = voltageStringGreater;
		return this;
	}
	public String getVoltageStringGreater(){
		return this.voltageStringGreater;
	}
	public GbStateQuery setCurrentStringLike(String currentStringLike){
		this.currentStringLike = currentStringLike;
		return this;
	}
	public String getCurrentStringLike(){
		return this.currentStringLike;
	}
	public GbStateQuery setCurrentStringEquals(String currentStringEquals){
		this.currentStringEquals = currentStringEquals;
		return this;
	}
	public String getCurrentStringEquals(){
		return this.currentStringEquals;
	}
	public GbStateQuery setCurrentStringIn(String[] currentStringIn){
		this.currentStringIn = currentStringIn;
		return this;
	}
	public String[] getCurrentStringIn(){
		return this.currentStringIn;
	}
	public GbStateQuery setCurrentStringIsNull(Boolean currentStringIsNull){
		this.currentStringIsNull = currentStringIsNull;
		return this;
	}
	public Boolean getCurrentStringIsNull(){
		return this.currentStringIsNull;
	}
	public GbStateQuery setCurrentStringIsNotNull(Boolean currentStringIsNotNull){
		this.currentStringIsNotNull = currentStringIsNotNull;
		return this;
	}
	public Boolean getCurrentStringIsNotNull(){
		return this.currentStringIsNotNull;
	}
	public GbStateQuery setCurrentStringStart(String currentStringStart){
		this.currentStringStart = currentStringStart;
		return this;
	}
	public String getCurrentStringStart(){
		return this.currentStringStart;
	}
	public GbStateQuery setCurrentStringEnd(String currentStringEnd){
		this.currentStringEnd = currentStringEnd;
		return this;
	}
	public String getCurrentStringEnd(){
		return this.currentStringEnd;
	}
	public GbStateQuery setCurrentStringLess(String currentStringLess){
		this.currentStringLess = currentStringLess;
		return this;
	}
	public String getCurrentStringLess(){
		return this.currentStringLess;
	}
	public GbStateQuery setCurrentStringGreater(String currentStringGreater){
		this.currentStringGreater = currentStringGreater;
		return this;
	}
	public String getCurrentStringGreater(){
		return this.currentStringGreater;
	}
	public GbStateQuery setSocStringLike(String socStringLike){
		this.socStringLike = socStringLike;
		return this;
	}
	public String getSocStringLike(){
		return this.socStringLike;
	}
	public GbStateQuery setSocStringEquals(String socStringEquals){
		this.socStringEquals = socStringEquals;
		return this;
	}
	public String getSocStringEquals(){
		return this.socStringEquals;
	}
	public GbStateQuery setSocStringIn(String[] socStringIn){
		this.socStringIn = socStringIn;
		return this;
	}
	public String[] getSocStringIn(){
		return this.socStringIn;
	}
	public GbStateQuery setSocStringIsNull(Boolean socStringIsNull){
		this.socStringIsNull = socStringIsNull;
		return this;
	}
	public Boolean getSocStringIsNull(){
		return this.socStringIsNull;
	}
	public GbStateQuery setSocStringIsNotNull(Boolean socStringIsNotNull){
		this.socStringIsNotNull = socStringIsNotNull;
		return this;
	}
	public Boolean getSocStringIsNotNull(){
		return this.socStringIsNotNull;
	}
	public GbStateQuery setSocStringStart(String socStringStart){
		this.socStringStart = socStringStart;
		return this;
	}
	public String getSocStringStart(){
		return this.socStringStart;
	}
	public GbStateQuery setSocStringEnd(String socStringEnd){
		this.socStringEnd = socStringEnd;
		return this;
	}
	public String getSocStringEnd(){
		return this.socStringEnd;
	}
	public GbStateQuery setSocStringLess(String socStringLess){
		this.socStringLess = socStringLess;
		return this;
	}
	public String getSocStringLess(){
		return this.socStringLess;
	}
	public GbStateQuery setSocStringGreater(String socStringGreater){
		this.socStringGreater = socStringGreater;
		return this;
	}
	public String getSocStringGreater(){
		return this.socStringGreater;
	}
	public GbStateQuery setDcDcStatusStringLike(String dcDcStatusStringLike){
		this.dcDcStatusStringLike = dcDcStatusStringLike;
		return this;
	}
	public String getDcDcStatusStringLike(){
		return this.dcDcStatusStringLike;
	}
	public GbStateQuery setDcDcStatusStringEquals(String dcDcStatusStringEquals){
		this.dcDcStatusStringEquals = dcDcStatusStringEquals;
		return this;
	}
	public String getDcDcStatusStringEquals(){
		return this.dcDcStatusStringEquals;
	}
	public GbStateQuery setDcDcStatusStringIn(String[] dcDcStatusStringIn){
		this.dcDcStatusStringIn = dcDcStatusStringIn;
		return this;
	}
	public String[] getDcDcStatusStringIn(){
		return this.dcDcStatusStringIn;
	}
	public GbStateQuery setDcDcStatusStringIsNull(Boolean dcDcStatusStringIsNull){
		this.dcDcStatusStringIsNull = dcDcStatusStringIsNull;
		return this;
	}
	public Boolean getDcDcStatusStringIsNull(){
		return this.dcDcStatusStringIsNull;
	}
	public GbStateQuery setDcDcStatusStringIsNotNull(Boolean dcDcStatusStringIsNotNull){
		this.dcDcStatusStringIsNotNull = dcDcStatusStringIsNotNull;
		return this;
	}
	public Boolean getDcDcStatusStringIsNotNull(){
		return this.dcDcStatusStringIsNotNull;
	}
	public GbStateQuery setDcDcStatusStringStart(String dcDcStatusStringStart){
		this.dcDcStatusStringStart = dcDcStatusStringStart;
		return this;
	}
	public String getDcDcStatusStringStart(){
		return this.dcDcStatusStringStart;
	}
	public GbStateQuery setDcDcStatusStringEnd(String dcDcStatusStringEnd){
		this.dcDcStatusStringEnd = dcDcStatusStringEnd;
		return this;
	}
	public String getDcDcStatusStringEnd(){
		return this.dcDcStatusStringEnd;
	}
	public GbStateQuery setDcDcStatusStringLess(String dcDcStatusStringLess){
		this.dcDcStatusStringLess = dcDcStatusStringLess;
		return this;
	}
	public String getDcDcStatusStringLess(){
		return this.dcDcStatusStringLess;
	}
	public GbStateQuery setDcDcStatusStringGreater(String dcDcStatusStringGreater){
		this.dcDcStatusStringGreater = dcDcStatusStringGreater;
		return this;
	}
	public String getDcDcStatusStringGreater(){
		return this.dcDcStatusStringGreater;
	}
	public GbStateQuery setGearStringLike(String gearStringLike){
		this.gearStringLike = gearStringLike;
		return this;
	}
	public String getGearStringLike(){
		return this.gearStringLike;
	}
	public GbStateQuery setGearStringEquals(String gearStringEquals){
		this.gearStringEquals = gearStringEquals;
		return this;
	}
	public String getGearStringEquals(){
		return this.gearStringEquals;
	}
	public GbStateQuery setGearStringIn(String[] gearStringIn){
		this.gearStringIn = gearStringIn;
		return this;
	}
	public String[] getGearStringIn(){
		return this.gearStringIn;
	}
	public GbStateQuery setGearStringIsNull(Boolean gearStringIsNull){
		this.gearStringIsNull = gearStringIsNull;
		return this;
	}
	public Boolean getGearStringIsNull(){
		return this.gearStringIsNull;
	}
	public GbStateQuery setGearStringIsNotNull(Boolean gearStringIsNotNull){
		this.gearStringIsNotNull = gearStringIsNotNull;
		return this;
	}
	public Boolean getGearStringIsNotNull(){
		return this.gearStringIsNotNull;
	}
	public GbStateQuery setGearStringStart(String gearStringStart){
		this.gearStringStart = gearStringStart;
		return this;
	}
	public String getGearStringStart(){
		return this.gearStringStart;
	}
	public GbStateQuery setGearStringEnd(String gearStringEnd){
		this.gearStringEnd = gearStringEnd;
		return this;
	}
	public String getGearStringEnd(){
		return this.gearStringEnd;
	}
	public GbStateQuery setGearStringLess(String gearStringLess){
		this.gearStringLess = gearStringLess;
		return this;
	}
	public String getGearStringLess(){
		return this.gearStringLess;
	}
	public GbStateQuery setGearStringGreater(String gearStringGreater){
		this.gearStringGreater = gearStringGreater;
		return this;
	}
	public String getGearStringGreater(){
		return this.gearStringGreater;
	}
	public GbStateQuery setInsulationResistanceStringLike(String insulationResistanceStringLike){
		this.insulationResistanceStringLike = insulationResistanceStringLike;
		return this;
	}
	public String getInsulationResistanceStringLike(){
		return this.insulationResistanceStringLike;
	}
	public GbStateQuery setInsulationResistanceStringEquals(String insulationResistanceStringEquals){
		this.insulationResistanceStringEquals = insulationResistanceStringEquals;
		return this;
	}
	public String getInsulationResistanceStringEquals(){
		return this.insulationResistanceStringEquals;
	}
	public GbStateQuery setInsulationResistanceStringIn(String[] insulationResistanceStringIn){
		this.insulationResistanceStringIn = insulationResistanceStringIn;
		return this;
	}
	public String[] getInsulationResistanceStringIn(){
		return this.insulationResistanceStringIn;
	}
	public GbStateQuery setInsulationResistanceStringIsNull(Boolean insulationResistanceStringIsNull){
		this.insulationResistanceStringIsNull = insulationResistanceStringIsNull;
		return this;
	}
	public Boolean getInsulationResistanceStringIsNull(){
		return this.insulationResistanceStringIsNull;
	}
	public GbStateQuery setInsulationResistanceStringIsNotNull(Boolean insulationResistanceStringIsNotNull){
		this.insulationResistanceStringIsNotNull = insulationResistanceStringIsNotNull;
		return this;
	}
	public Boolean getInsulationResistanceStringIsNotNull(){
		return this.insulationResistanceStringIsNotNull;
	}
	public GbStateQuery setInsulationResistanceStringStart(String insulationResistanceStringStart){
		this.insulationResistanceStringStart = insulationResistanceStringStart;
		return this;
	}
	public String getInsulationResistanceStringStart(){
		return this.insulationResistanceStringStart;
	}
	public GbStateQuery setInsulationResistanceStringEnd(String insulationResistanceStringEnd){
		this.insulationResistanceStringEnd = insulationResistanceStringEnd;
		return this;
	}
	public String getInsulationResistanceStringEnd(){
		return this.insulationResistanceStringEnd;
	}
	public GbStateQuery setInsulationResistanceStringLess(String insulationResistanceStringLess){
		this.insulationResistanceStringLess = insulationResistanceStringLess;
		return this;
	}
	public String getInsulationResistanceStringLess(){
		return this.insulationResistanceStringLess;
	}
	public GbStateQuery setInsulationResistanceStringGreater(String insulationResistanceStringGreater){
		this.insulationResistanceStringGreater = insulationResistanceStringGreater;
		return this;
	}
	public String getInsulationResistanceStringGreater(){
		return this.insulationResistanceStringGreater;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringLike(String acceleratedPedalStrokeValueStringLike){
		this.acceleratedPedalStrokeValueStringLike = acceleratedPedalStrokeValueStringLike;
		return this;
	}
	public String getAcceleratedPedalStrokeValueStringLike(){
		return this.acceleratedPedalStrokeValueStringLike;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringEquals(String acceleratedPedalStrokeValueStringEquals){
		this.acceleratedPedalStrokeValueStringEquals = acceleratedPedalStrokeValueStringEquals;
		return this;
	}
	public String getAcceleratedPedalStrokeValueStringEquals(){
		return this.acceleratedPedalStrokeValueStringEquals;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringIn(String[] acceleratedPedalStrokeValueStringIn){
		this.acceleratedPedalStrokeValueStringIn = acceleratedPedalStrokeValueStringIn;
		return this;
	}
	public String[] getAcceleratedPedalStrokeValueStringIn(){
		return this.acceleratedPedalStrokeValueStringIn;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringIsNull(Boolean acceleratedPedalStrokeValueStringIsNull){
		this.acceleratedPedalStrokeValueStringIsNull = acceleratedPedalStrokeValueStringIsNull;
		return this;
	}
	public Boolean getAcceleratedPedalStrokeValueStringIsNull(){
		return this.acceleratedPedalStrokeValueStringIsNull;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringIsNotNull(Boolean acceleratedPedalStrokeValueStringIsNotNull){
		this.acceleratedPedalStrokeValueStringIsNotNull = acceleratedPedalStrokeValueStringIsNotNull;
		return this;
	}
	public Boolean getAcceleratedPedalStrokeValueStringIsNotNull(){
		return this.acceleratedPedalStrokeValueStringIsNotNull;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringStart(String acceleratedPedalStrokeValueStringStart){
		this.acceleratedPedalStrokeValueStringStart = acceleratedPedalStrokeValueStringStart;
		return this;
	}
	public String getAcceleratedPedalStrokeValueStringStart(){
		return this.acceleratedPedalStrokeValueStringStart;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringEnd(String acceleratedPedalStrokeValueStringEnd){
		this.acceleratedPedalStrokeValueStringEnd = acceleratedPedalStrokeValueStringEnd;
		return this;
	}
	public String getAcceleratedPedalStrokeValueStringEnd(){
		return this.acceleratedPedalStrokeValueStringEnd;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringLess(String acceleratedPedalStrokeValueStringLess){
		this.acceleratedPedalStrokeValueStringLess = acceleratedPedalStrokeValueStringLess;
		return this;
	}
	public String getAcceleratedPedalStrokeValueStringLess(){
		return this.acceleratedPedalStrokeValueStringLess;
	}
	public GbStateQuery setAcceleratedPedalStrokeValueStringGreater(String acceleratedPedalStrokeValueStringGreater){
		this.acceleratedPedalStrokeValueStringGreater = acceleratedPedalStrokeValueStringGreater;
		return this;
	}
	public String getAcceleratedPedalStrokeValueStringGreater(){
		return this.acceleratedPedalStrokeValueStringGreater;
	}
	public GbStateQuery setBrakePedalStateStringLike(String brakePedalStateStringLike){
		this.brakePedalStateStringLike = brakePedalStateStringLike;
		return this;
	}
	public String getBrakePedalStateStringLike(){
		return this.brakePedalStateStringLike;
	}
	public GbStateQuery setBrakePedalStateStringEquals(String brakePedalStateStringEquals){
		this.brakePedalStateStringEquals = brakePedalStateStringEquals;
		return this;
	}
	public String getBrakePedalStateStringEquals(){
		return this.brakePedalStateStringEquals;
	}
	public GbStateQuery setBrakePedalStateStringIn(String[] brakePedalStateStringIn){
		this.brakePedalStateStringIn = brakePedalStateStringIn;
		return this;
	}
	public String[] getBrakePedalStateStringIn(){
		return this.brakePedalStateStringIn;
	}
	public GbStateQuery setBrakePedalStateStringIsNull(Boolean brakePedalStateStringIsNull){
		this.brakePedalStateStringIsNull = brakePedalStateStringIsNull;
		return this;
	}
	public Boolean getBrakePedalStateStringIsNull(){
		return this.brakePedalStateStringIsNull;
	}
	public GbStateQuery setBrakePedalStateStringIsNotNull(Boolean brakePedalStateStringIsNotNull){
		this.brakePedalStateStringIsNotNull = brakePedalStateStringIsNotNull;
		return this;
	}
	public Boolean getBrakePedalStateStringIsNotNull(){
		return this.brakePedalStateStringIsNotNull;
	}
	public GbStateQuery setBrakePedalStateStringStart(String brakePedalStateStringStart){
		this.brakePedalStateStringStart = brakePedalStateStringStart;
		return this;
	}
	public String getBrakePedalStateStringStart(){
		return this.brakePedalStateStringStart;
	}
	public GbStateQuery setBrakePedalStateStringEnd(String brakePedalStateStringEnd){
		this.brakePedalStateStringEnd = brakePedalStateStringEnd;
		return this;
	}
	public String getBrakePedalStateStringEnd(){
		return this.brakePedalStateStringEnd;
	}
	public GbStateQuery setBrakePedalStateStringLess(String brakePedalStateStringLess){
		this.brakePedalStateStringLess = brakePedalStateStringLess;
		return this;
	}
	public String getBrakePedalStateStringLess(){
		return this.brakePedalStateStringLess;
	}
	public GbStateQuery setBrakePedalStateStringGreater(String brakePedalStateStringGreater){
		this.brakePedalStateStringGreater = brakePedalStateStringGreater;
		return this;
	}
	public String getBrakePedalStateStringGreater(){
		return this.brakePedalStateStringGreater;
	}
	public GbStateQuery setPositionStatusStringLike(String positionStatusStringLike){
		this.positionStatusStringLike = positionStatusStringLike;
		return this;
	}
	public String getPositionStatusStringLike(){
		return this.positionStatusStringLike;
	}
	public GbStateQuery setPositionStatusStringEquals(String positionStatusStringEquals){
		this.positionStatusStringEquals = positionStatusStringEquals;
		return this;
	}
	public String getPositionStatusStringEquals(){
		return this.positionStatusStringEquals;
	}
	public GbStateQuery setPositionStatusStringIn(String[] positionStatusStringIn){
		this.positionStatusStringIn = positionStatusStringIn;
		return this;
	}
	public String[] getPositionStatusStringIn(){
		return this.positionStatusStringIn;
	}
	public GbStateQuery setPositionStatusStringIsNull(Boolean positionStatusStringIsNull){
		this.positionStatusStringIsNull = positionStatusStringIsNull;
		return this;
	}
	public Boolean getPositionStatusStringIsNull(){
		return this.positionStatusStringIsNull;
	}
	public GbStateQuery setPositionStatusStringIsNotNull(Boolean positionStatusStringIsNotNull){
		this.positionStatusStringIsNotNull = positionStatusStringIsNotNull;
		return this;
	}
	public Boolean getPositionStatusStringIsNotNull(){
		return this.positionStatusStringIsNotNull;
	}
	public GbStateQuery setPositionStatusStringStart(String positionStatusStringStart){
		this.positionStatusStringStart = positionStatusStringStart;
		return this;
	}
	public String getPositionStatusStringStart(){
		return this.positionStatusStringStart;
	}
	public GbStateQuery setPositionStatusStringEnd(String positionStatusStringEnd){
		this.positionStatusStringEnd = positionStatusStringEnd;
		return this;
	}
	public String getPositionStatusStringEnd(){
		return this.positionStatusStringEnd;
	}
	public GbStateQuery setPositionStatusStringLess(String positionStatusStringLess){
		this.positionStatusStringLess = positionStatusStringLess;
		return this;
	}
	public String getPositionStatusStringLess(){
		return this.positionStatusStringLess;
	}
	public GbStateQuery setPositionStatusStringGreater(String positionStatusStringGreater){
		this.positionStatusStringGreater = positionStatusStringGreater;
		return this;
	}
	public String getPositionStatusStringGreater(){
		return this.positionStatusStringGreater;
	}
	public GbStateQuery setLongitudeStringEquals(Long longitudeStringEquals){
		this.longitudeStringEquals = longitudeStringEquals;
		return this;
	}
	public Long getLongitudeStringEquals(){
		return this.longitudeStringEquals;
	}
	public GbStateQuery setLongitudeStringIn(Long[] longitudeStringIn){
		this.longitudeStringIn = longitudeStringIn;
		return this;
	}
	public Long[] getLongitudeStringIn(){
		return this.longitudeStringIn;
	}
	public GbStateQuery setLongitudeStringIsNull(Boolean longitudeStringIsNull){
		this.longitudeStringIsNull = longitudeStringIsNull;
		return this;
	}
	public Boolean getLongitudeStringIsNull(){
		return this.longitudeStringIsNull;
	}
	public GbStateQuery setLongitudeStringIsNotNull(Boolean longitudeStringIsNotNull){
		this.longitudeStringIsNotNull = longitudeStringIsNotNull;
		return this;
	}
	public Boolean getLongitudeStringIsNotNull(){
		return this.longitudeStringIsNotNull;
	}
	public GbStateQuery setLongitudeStringStart(Long longitudeStringStart){
		this.longitudeStringStart = longitudeStringStart;
		return this;
	}
	public Long getLongitudeStringStart(){
		return this.longitudeStringStart;
	}
	public GbStateQuery setLongitudeStringEnd(Long longitudeStringEnd){
		this.longitudeStringEnd = longitudeStringEnd;
		return this;
	}
	public Long getLongitudeStringEnd(){
		return this.longitudeStringEnd;
	}
	public GbStateQuery setLongitudeStringLess(Long longitudeStringLess){
		this.longitudeStringLess = longitudeStringLess;
		return this;
	}
	public Long getLongitudeStringLess(){
		return this.longitudeStringLess;
	}
	public GbStateQuery setLongitudeStringGreater(Long longitudeStringGreater){
		this.longitudeStringGreater = longitudeStringGreater;
		return this;
	}
	public Long getLongitudeStringGreater(){
		return this.longitudeStringGreater;
	}
	public GbStateQuery setLatitudeStringEquals(Long latitudeStringEquals){
		this.latitudeStringEquals = latitudeStringEquals;
		return this;
	}
	public Long getLatitudeStringEquals(){
		return this.latitudeStringEquals;
	}
	public GbStateQuery setLatitudeStringIn(Long[] latitudeStringIn){
		this.latitudeStringIn = latitudeStringIn;
		return this;
	}
	public Long[] getLatitudeStringIn(){
		return this.latitudeStringIn;
	}
	public GbStateQuery setLatitudeStringIsNull(Boolean latitudeStringIsNull){
		this.latitudeStringIsNull = latitudeStringIsNull;
		return this;
	}
	public Boolean getLatitudeStringIsNull(){
		return this.latitudeStringIsNull;
	}
	public GbStateQuery setLatitudeStringIsNotNull(Boolean latitudeStringIsNotNull){
		this.latitudeStringIsNotNull = latitudeStringIsNotNull;
		return this;
	}
	public Boolean getLatitudeStringIsNotNull(){
		return this.latitudeStringIsNotNull;
	}
	public GbStateQuery setLatitudeStringStart(Long latitudeStringStart){
		this.latitudeStringStart = latitudeStringStart;
		return this;
	}
	public Long getLatitudeStringStart(){
		return this.latitudeStringStart;
	}
	public GbStateQuery setLatitudeStringEnd(Long latitudeStringEnd){
		this.latitudeStringEnd = latitudeStringEnd;
		return this;
	}
	public Long getLatitudeStringEnd(){
		return this.latitudeStringEnd;
	}
	public GbStateQuery setLatitudeStringLess(Long latitudeStringLess){
		this.latitudeStringLess = latitudeStringLess;
		return this;
	}
	public Long getLatitudeStringLess(){
		return this.latitudeStringLess;
	}
	public GbStateQuery setLatitudeStringGreater(Long latitudeStringGreater){
		this.latitudeStringGreater = latitudeStringGreater;
		return this;
	}
	public Long getLatitudeStringGreater(){
		return this.latitudeStringGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("gsId")){
			return "gs_id";
		}
		else if(this.sidx.equals("vin")){
			return "vin";
		}
		else if(this.sidx.equals("timeText")){
			return "time_text";
		}
		else if(this.sidx.equals("vehicleStatusString")){
			return "vehicle_status_string";
		}
		else if(this.sidx.equals("chargingString")){
			return "charging_string";
		}
		else if(this.sidx.equals("runningModeString")){
			return "running_mode_string";
		}
		else if(this.sidx.equals("speedString")){
			return "speed_string";
		}
		else if(this.sidx.equals("mileageString")){
			return "mileage_string";
		}
		else if(this.sidx.equals("voltageString")){
			return "voltage_string";
		}
		else if(this.sidx.equals("currentString")){
			return "current_string";
		}
		else if(this.sidx.equals("socString")){
			return "soc_string";
		}
		else if(this.sidx.equals("dcDcStatusString")){
			return "dc_dc_status_string";
		}
		else if(this.sidx.equals("gearString")){
			return "gear_string";
		}
		else if(this.sidx.equals("insulationResistanceString")){
			return "insulation_resistance_string";
		}
		else if(this.sidx.equals("acceleratedPedalStrokeValueString")){
			return "accelerated_pedal_stroke_value_string";
		}
		else if(this.sidx.equals("brakePedalStateString")){
			return "brake_pedal_state_string";
		}
		else if(this.sidx.equals("positionStatusString")){
			return "position_status_string";
		}
		else if(this.sidx.equals("longitudeString")){
			return "longitude_string";
		}
		else if(this.sidx.equals("latitudeString")){
			return "latitude_string";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public GbStateCrieria getCrieria(){
		GbStateCrieria q = new GbStateCrieria();
		GbStateCrieria.Criteria c = q.createCriteria();
		
		if(this.getGsIdEquals()!=null){
			c.andgsIdEqualTo(this.getGsIdEquals());
		}else if(this.getGsIdIsNull()!=null && this.getGsIdIsNull()){
			c.andgsIdIsNull();
		}else if(this.getGsIdIsNotNull()!=null && this.getGsIdIsNotNull()){
			c.andgsIdIsNotNull();
		}else if(this.getGsIdIn()!=null){
			c.andgsIdIn(java.util.Arrays.asList(this.getGsIdIn()));
		}else if(this.getGsIdStart()!=null && this.getGsIdEnd()!=null){
			c.andgsIdBetween(this.getGsIdStart(), this.getGsIdEnd());
		}else if(this.getGsIdGreater()!=null){
			c.andgsIdGreaterThan(this.getGsIdGreater());
		}else if(this.getGsIdLess()!=null){
			c.andgsIdLessThan(this.getGsIdLess());
		}
		if(this.getvinEquals()!=null){
			c.andvinEqualTo(this.getvinEquals());
		}else if(this.getvinIsNull()!=null && this.getvinIsNull()){
			c.andvinIsNull();
		}else if(this.getvinIsNotNull()!=null && this.getvinIsNotNull()){
			c.andvinIsNotNull();
		}else if(this.getvinLike()!=null){
			c.andvinLike(this.getvinLike());
		}else if(this.getvinIn()!=null){
			c.andvinIn(java.util.Arrays.asList(this.getvinIn()));
		}else if(this.getvinStart()!=null && this.getvinEnd()!=null){
			c.andvinBetween(this.getvinStart(), this.getvinEnd());
		}else if(this.getvinGreater()!=null){
			c.andvinGreaterThan(this.getvinGreater());
		}else if(this.getvinLess()!=null){
			c.andvinLessThan(this.getvinLess());
		}
		if(this.getTimeTextEquals()!=null){
			c.andtimeTextEqualTo(this.getTimeTextEquals());
		}else if(this.getTimeTextIsNull()!=null && this.getTimeTextIsNull()){
			c.andtimeTextIsNull();
		}else if(this.getTimeTextIsNotNull()!=null && this.getTimeTextIsNotNull()){
			c.andtimeTextIsNotNull();
		}else if(this.getTimeTextLike()!=null){
			c.andtimeTextLike(this.getTimeTextLike());
		}else if(this.getTimeTextIn()!=null){
			c.andtimeTextIn(java.util.Arrays.asList(this.getTimeTextIn()));
		}else if(this.getTimeTextStart()!=null && this.getTimeTextEnd()!=null){
			c.andtimeTextBetween(this.getTimeTextStart(), this.getTimeTextEnd());
		}else if(this.getTimeTextGreater()!=null){
			c.andtimeTextGreaterThan(this.getTimeTextGreater());
		}else if(this.getTimeTextLess()!=null){
			c.andtimeTextLessThan(this.getTimeTextLess());
		}
		if(this.getVehicleStatusStringEquals()!=null){
			c.andvehicleStatusStringEqualTo(this.getVehicleStatusStringEquals());
		}else if(this.getVehicleStatusStringIsNull()!=null && this.getVehicleStatusStringIsNull()){
			c.andvehicleStatusStringIsNull();
		}else if(this.getVehicleStatusStringIsNotNull()!=null && this.getVehicleStatusStringIsNotNull()){
			c.andvehicleStatusStringIsNotNull();
		}else if(this.getVehicleStatusStringLike()!=null){
			c.andvehicleStatusStringLike(this.getVehicleStatusStringLike());
		}else if(this.getVehicleStatusStringIn()!=null){
			c.andvehicleStatusStringIn(java.util.Arrays.asList(this.getVehicleStatusStringIn()));
		}else if(this.getVehicleStatusStringStart()!=null && this.getVehicleStatusStringEnd()!=null){
			c.andvehicleStatusStringBetween(this.getVehicleStatusStringStart(), this.getVehicleStatusStringEnd());
		}else if(this.getVehicleStatusStringGreater()!=null){
			c.andvehicleStatusStringGreaterThan(this.getVehicleStatusStringGreater());
		}else if(this.getVehicleStatusStringLess()!=null){
			c.andvehicleStatusStringLessThan(this.getVehicleStatusStringLess());
		}
		if(this.getChargingStringEquals()!=null){
			c.andchargingStringEqualTo(this.getChargingStringEquals());
		}else if(this.getChargingStringIsNull()!=null && this.getChargingStringIsNull()){
			c.andchargingStringIsNull();
		}else if(this.getChargingStringIsNotNull()!=null && this.getChargingStringIsNotNull()){
			c.andchargingStringIsNotNull();
		}else if(this.getChargingStringLike()!=null){
			c.andchargingStringLike(this.getChargingStringLike());
		}else if(this.getChargingStringIn()!=null){
			c.andchargingStringIn(java.util.Arrays.asList(this.getChargingStringIn()));
		}else if(this.getChargingStringStart()!=null && this.getChargingStringEnd()!=null){
			c.andchargingStringBetween(this.getChargingStringStart(), this.getChargingStringEnd());
		}else if(this.getChargingStringGreater()!=null){
			c.andchargingStringGreaterThan(this.getChargingStringGreater());
		}else if(this.getChargingStringLess()!=null){
			c.andchargingStringLessThan(this.getChargingStringLess());
		}
		if(this.getRunningModeStringEquals()!=null){
			c.andrunningModeStringEqualTo(this.getRunningModeStringEquals());
		}else if(this.getRunningModeStringIsNull()!=null && this.getRunningModeStringIsNull()){
			c.andrunningModeStringIsNull();
		}else if(this.getRunningModeStringIsNotNull()!=null && this.getRunningModeStringIsNotNull()){
			c.andrunningModeStringIsNotNull();
		}else if(this.getRunningModeStringLike()!=null){
			c.andrunningModeStringLike(this.getRunningModeStringLike());
		}else if(this.getRunningModeStringIn()!=null){
			c.andrunningModeStringIn(java.util.Arrays.asList(this.getRunningModeStringIn()));
		}else if(this.getRunningModeStringStart()!=null && this.getRunningModeStringEnd()!=null){
			c.andrunningModeStringBetween(this.getRunningModeStringStart(), this.getRunningModeStringEnd());
		}else if(this.getRunningModeStringGreater()!=null){
			c.andrunningModeStringGreaterThan(this.getRunningModeStringGreater());
		}else if(this.getRunningModeStringLess()!=null){
			c.andrunningModeStringLessThan(this.getRunningModeStringLess());
		}
		if(this.getSpeedStringEquals()!=null){
			c.andspeedStringEqualTo(this.getSpeedStringEquals());
		}else if(this.getSpeedStringIsNull()!=null && this.getSpeedStringIsNull()){
			c.andspeedStringIsNull();
		}else if(this.getSpeedStringIsNotNull()!=null && this.getSpeedStringIsNotNull()){
			c.andspeedStringIsNotNull();
		}else if(this.getSpeedStringLike()!=null){
			c.andspeedStringLike(this.getSpeedStringLike());
		}else if(this.getSpeedStringIn()!=null){
			c.andspeedStringIn(java.util.Arrays.asList(this.getSpeedStringIn()));
		}else if(this.getSpeedStringStart()!=null && this.getSpeedStringEnd()!=null){
			c.andspeedStringBetween(this.getSpeedStringStart(), this.getSpeedStringEnd());
		}else if(this.getSpeedStringGreater()!=null){
			c.andspeedStringGreaterThan(this.getSpeedStringGreater());
		}else if(this.getSpeedStringLess()!=null){
			c.andspeedStringLessThan(this.getSpeedStringLess());
		}
		if(this.getMileageStringEquals()!=null){
			c.andmileageStringEqualTo(this.getMileageStringEquals());
		}else if(this.getMileageStringIsNull()!=null && this.getMileageStringIsNull()){
			c.andmileageStringIsNull();
		}else if(this.getMileageStringIsNotNull()!=null && this.getMileageStringIsNotNull()){
			c.andmileageStringIsNotNull();
		}else if(this.getMileageStringLike()!=null){
			c.andmileageStringLike(this.getMileageStringLike());
		}else if(this.getMileageStringIn()!=null){
			c.andmileageStringIn(java.util.Arrays.asList(this.getMileageStringIn()));
		}else if(this.getMileageStringStart()!=null && this.getMileageStringEnd()!=null){
			c.andmileageStringBetween(this.getMileageStringStart(), this.getMileageStringEnd());
		}else if(this.getMileageStringGreater()!=null){
			c.andmileageStringGreaterThan(this.getMileageStringGreater());
		}else if(this.getMileageStringLess()!=null){
			c.andmileageStringLessThan(this.getMileageStringLess());
		}
		if(this.getVoltageStringEquals()!=null){
			c.andvoltageStringEqualTo(this.getVoltageStringEquals());
		}else if(this.getVoltageStringIsNull()!=null && this.getVoltageStringIsNull()){
			c.andvoltageStringIsNull();
		}else if(this.getVoltageStringIsNotNull()!=null && this.getVoltageStringIsNotNull()){
			c.andvoltageStringIsNotNull();
		}else if(this.getVoltageStringLike()!=null){
			c.andvoltageStringLike(this.getVoltageStringLike());
		}else if(this.getVoltageStringIn()!=null){
			c.andvoltageStringIn(java.util.Arrays.asList(this.getVoltageStringIn()));
		}else if(this.getVoltageStringStart()!=null && this.getVoltageStringEnd()!=null){
			c.andvoltageStringBetween(this.getVoltageStringStart(), this.getVoltageStringEnd());
		}else if(this.getVoltageStringGreater()!=null){
			c.andvoltageStringGreaterThan(this.getVoltageStringGreater());
		}else if(this.getVoltageStringLess()!=null){
			c.andvoltageStringLessThan(this.getVoltageStringLess());
		}
		if(this.getCurrentStringEquals()!=null){
			c.andcurrentStringEqualTo(this.getCurrentStringEquals());
		}else if(this.getCurrentStringIsNull()!=null && this.getCurrentStringIsNull()){
			c.andcurrentStringIsNull();
		}else if(this.getCurrentStringIsNotNull()!=null && this.getCurrentStringIsNotNull()){
			c.andcurrentStringIsNotNull();
		}else if(this.getCurrentStringLike()!=null){
			c.andcurrentStringLike(this.getCurrentStringLike());
		}else if(this.getCurrentStringIn()!=null){
			c.andcurrentStringIn(java.util.Arrays.asList(this.getCurrentStringIn()));
		}else if(this.getCurrentStringStart()!=null && this.getCurrentStringEnd()!=null){
			c.andcurrentStringBetween(this.getCurrentStringStart(), this.getCurrentStringEnd());
		}else if(this.getCurrentStringGreater()!=null){
			c.andcurrentStringGreaterThan(this.getCurrentStringGreater());
		}else if(this.getCurrentStringLess()!=null){
			c.andcurrentStringLessThan(this.getCurrentStringLess());
		}
		if(this.getSocStringEquals()!=null){
			c.andsocStringEqualTo(this.getSocStringEquals());
		}else if(this.getSocStringIsNull()!=null && this.getSocStringIsNull()){
			c.andsocStringIsNull();
		}else if(this.getSocStringIsNotNull()!=null && this.getSocStringIsNotNull()){
			c.andsocStringIsNotNull();
		}else if(this.getSocStringLike()!=null){
			c.andsocStringLike(this.getSocStringLike());
		}else if(this.getSocStringIn()!=null){
			c.andsocStringIn(java.util.Arrays.asList(this.getSocStringIn()));
		}else if(this.getSocStringStart()!=null && this.getSocStringEnd()!=null){
			c.andsocStringBetween(this.getSocStringStart(), this.getSocStringEnd());
		}else if(this.getSocStringGreater()!=null){
			c.andsocStringGreaterThan(this.getSocStringGreater());
		}else if(this.getSocStringLess()!=null){
			c.andsocStringLessThan(this.getSocStringLess());
		}
		if(this.getDcDcStatusStringEquals()!=null){
			c.anddcDcStatusStringEqualTo(this.getDcDcStatusStringEquals());
		}else if(this.getDcDcStatusStringIsNull()!=null && this.getDcDcStatusStringIsNull()){
			c.anddcDcStatusStringIsNull();
		}else if(this.getDcDcStatusStringIsNotNull()!=null && this.getDcDcStatusStringIsNotNull()){
			c.anddcDcStatusStringIsNotNull();
		}else if(this.getDcDcStatusStringLike()!=null){
			c.anddcDcStatusStringLike(this.getDcDcStatusStringLike());
		}else if(this.getDcDcStatusStringIn()!=null){
			c.anddcDcStatusStringIn(java.util.Arrays.asList(this.getDcDcStatusStringIn()));
		}else if(this.getDcDcStatusStringStart()!=null && this.getDcDcStatusStringEnd()!=null){
			c.anddcDcStatusStringBetween(this.getDcDcStatusStringStart(), this.getDcDcStatusStringEnd());
		}else if(this.getDcDcStatusStringGreater()!=null){
			c.anddcDcStatusStringGreaterThan(this.getDcDcStatusStringGreater());
		}else if(this.getDcDcStatusStringLess()!=null){
			c.anddcDcStatusStringLessThan(this.getDcDcStatusStringLess());
		}
		if(this.getGearStringEquals()!=null){
			c.andgearStringEqualTo(this.getGearStringEquals());
		}else if(this.getGearStringIsNull()!=null && this.getGearStringIsNull()){
			c.andgearStringIsNull();
		}else if(this.getGearStringIsNotNull()!=null && this.getGearStringIsNotNull()){
			c.andgearStringIsNotNull();
		}else if(this.getGearStringLike()!=null){
			c.andgearStringLike(this.getGearStringLike());
		}else if(this.getGearStringIn()!=null){
			c.andgearStringIn(java.util.Arrays.asList(this.getGearStringIn()));
		}else if(this.getGearStringStart()!=null && this.getGearStringEnd()!=null){
			c.andgearStringBetween(this.getGearStringStart(), this.getGearStringEnd());
		}else if(this.getGearStringGreater()!=null){
			c.andgearStringGreaterThan(this.getGearStringGreater());
		}else if(this.getGearStringLess()!=null){
			c.andgearStringLessThan(this.getGearStringLess());
		}
		if(this.getInsulationResistanceStringEquals()!=null){
			c.andinsulationResistanceStringEqualTo(this.getInsulationResistanceStringEquals());
		}else if(this.getInsulationResistanceStringIsNull()!=null && this.getInsulationResistanceStringIsNull()){
			c.andinsulationResistanceStringIsNull();
		}else if(this.getInsulationResistanceStringIsNotNull()!=null && this.getInsulationResistanceStringIsNotNull()){
			c.andinsulationResistanceStringIsNotNull();
		}else if(this.getInsulationResistanceStringLike()!=null){
			c.andinsulationResistanceStringLike(this.getInsulationResistanceStringLike());
		}else if(this.getInsulationResistanceStringIn()!=null){
			c.andinsulationResistanceStringIn(java.util.Arrays.asList(this.getInsulationResistanceStringIn()));
		}else if(this.getInsulationResistanceStringStart()!=null && this.getInsulationResistanceStringEnd()!=null){
			c.andinsulationResistanceStringBetween(this.getInsulationResistanceStringStart(), this.getInsulationResistanceStringEnd());
		}else if(this.getInsulationResistanceStringGreater()!=null){
			c.andinsulationResistanceStringGreaterThan(this.getInsulationResistanceStringGreater());
		}else if(this.getInsulationResistanceStringLess()!=null){
			c.andinsulationResistanceStringLessThan(this.getInsulationResistanceStringLess());
		}
		if(this.getAcceleratedPedalStrokeValueStringEquals()!=null){
			c.andacceleratedPedalStrokeValueStringEqualTo(this.getAcceleratedPedalStrokeValueStringEquals());
		}else if(this.getAcceleratedPedalStrokeValueStringIsNull()!=null && this.getAcceleratedPedalStrokeValueStringIsNull()){
			c.andacceleratedPedalStrokeValueStringIsNull();
		}else if(this.getAcceleratedPedalStrokeValueStringIsNotNull()!=null && this.getAcceleratedPedalStrokeValueStringIsNotNull()){
			c.andacceleratedPedalStrokeValueStringIsNotNull();
		}else if(this.getAcceleratedPedalStrokeValueStringLike()!=null){
			c.andacceleratedPedalStrokeValueStringLike(this.getAcceleratedPedalStrokeValueStringLike());
		}else if(this.getAcceleratedPedalStrokeValueStringIn()!=null){
			c.andacceleratedPedalStrokeValueStringIn(java.util.Arrays.asList(this.getAcceleratedPedalStrokeValueStringIn()));
		}else if(this.getAcceleratedPedalStrokeValueStringStart()!=null && this.getAcceleratedPedalStrokeValueStringEnd()!=null){
			c.andacceleratedPedalStrokeValueStringBetween(this.getAcceleratedPedalStrokeValueStringStart(), this.getAcceleratedPedalStrokeValueStringEnd());
		}else if(this.getAcceleratedPedalStrokeValueStringGreater()!=null){
			c.andacceleratedPedalStrokeValueStringGreaterThan(this.getAcceleratedPedalStrokeValueStringGreater());
		}else if(this.getAcceleratedPedalStrokeValueStringLess()!=null){
			c.andacceleratedPedalStrokeValueStringLessThan(this.getAcceleratedPedalStrokeValueStringLess());
		}
		if(this.getBrakePedalStateStringEquals()!=null){
			c.andbrakePedalStateStringEqualTo(this.getBrakePedalStateStringEquals());
		}else if(this.getBrakePedalStateStringIsNull()!=null && this.getBrakePedalStateStringIsNull()){
			c.andbrakePedalStateStringIsNull();
		}else if(this.getBrakePedalStateStringIsNotNull()!=null && this.getBrakePedalStateStringIsNotNull()){
			c.andbrakePedalStateStringIsNotNull();
		}else if(this.getBrakePedalStateStringLike()!=null){
			c.andbrakePedalStateStringLike(this.getBrakePedalStateStringLike());
		}else if(this.getBrakePedalStateStringIn()!=null){
			c.andbrakePedalStateStringIn(java.util.Arrays.asList(this.getBrakePedalStateStringIn()));
		}else if(this.getBrakePedalStateStringStart()!=null && this.getBrakePedalStateStringEnd()!=null){
			c.andbrakePedalStateStringBetween(this.getBrakePedalStateStringStart(), this.getBrakePedalStateStringEnd());
		}else if(this.getBrakePedalStateStringGreater()!=null){
			c.andbrakePedalStateStringGreaterThan(this.getBrakePedalStateStringGreater());
		}else if(this.getBrakePedalStateStringLess()!=null){
			c.andbrakePedalStateStringLessThan(this.getBrakePedalStateStringLess());
		}
		if(this.getPositionStatusStringEquals()!=null){
			c.andpositionStatusStringEqualTo(this.getPositionStatusStringEquals());
		}else if(this.getPositionStatusStringIsNull()!=null && this.getPositionStatusStringIsNull()){
			c.andpositionStatusStringIsNull();
		}else if(this.getPositionStatusStringIsNotNull()!=null && this.getPositionStatusStringIsNotNull()){
			c.andpositionStatusStringIsNotNull();
		}else if(this.getPositionStatusStringLike()!=null){
			c.andpositionStatusStringLike(this.getPositionStatusStringLike());
		}else if(this.getPositionStatusStringIn()!=null){
			c.andpositionStatusStringIn(java.util.Arrays.asList(this.getPositionStatusStringIn()));
		}else if(this.getPositionStatusStringStart()!=null && this.getPositionStatusStringEnd()!=null){
			c.andpositionStatusStringBetween(this.getPositionStatusStringStart(), this.getPositionStatusStringEnd());
		}else if(this.getPositionStatusStringGreater()!=null){
			c.andpositionStatusStringGreaterThan(this.getPositionStatusStringGreater());
		}else if(this.getPositionStatusStringLess()!=null){
			c.andpositionStatusStringLessThan(this.getPositionStatusStringLess());
		}
		if(this.getLongitudeStringEquals()!=null){
			c.andlongitudeStringEqualTo(this.getLongitudeStringEquals());
		}else if(this.getLongitudeStringIsNull()!=null && this.getLongitudeStringIsNull()){
			c.andlongitudeStringIsNull();
		}else if(this.getLongitudeStringIsNotNull()!=null && this.getLongitudeStringIsNotNull()){
			c.andlongitudeStringIsNotNull();
		}else if(this.getLongitudeStringIn()!=null){
			c.andlongitudeStringIn(java.util.Arrays.asList(this.getLongitudeStringIn()));
		}else if(this.getLongitudeStringStart()!=null && this.getLongitudeStringEnd()!=null){
			c.andlongitudeStringBetween(this.getLongitudeStringStart(), this.getLongitudeStringEnd());
		}else if(this.getLongitudeStringGreater()!=null){
			c.andlongitudeStringGreaterThan(this.getLongitudeStringGreater());
		}else if(this.getLongitudeStringLess()!=null){
			c.andlongitudeStringLessThan(this.getLongitudeStringLess());
		}
		if(this.getLatitudeStringEquals()!=null){
			c.andlatitudeStringEqualTo(this.getLatitudeStringEquals());
		}else if(this.getLatitudeStringIsNull()!=null && this.getLatitudeStringIsNull()){
			c.andlatitudeStringIsNull();
		}else if(this.getLatitudeStringIsNotNull()!=null && this.getLatitudeStringIsNotNull()){
			c.andlatitudeStringIsNotNull();
		}else if(this.getLatitudeStringIn()!=null){
			c.andlatitudeStringIn(java.util.Arrays.asList(this.getLatitudeStringIn()));
		}else if(this.getLatitudeStringStart()!=null && this.getLatitudeStringEnd()!=null){
			c.andlatitudeStringBetween(this.getLatitudeStringStart(), this.getLatitudeStringEnd());
		}else if(this.getLatitudeStringGreater()!=null){
			c.andlatitudeStringGreaterThan(this.getLatitudeStringGreater());
		}else if(this.getLatitudeStringLess()!=null){
			c.andlatitudeStringLessThan(this.getLatitudeStringLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
