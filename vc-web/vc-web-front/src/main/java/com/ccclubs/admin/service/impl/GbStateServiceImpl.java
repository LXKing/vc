package com.ccclubs.admin.service.impl;


import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GB_02;
import com.ccclubs.protocol.dto.gb.GB_02_01;
import com.ccclubs.protocol.dto.gb.GB_02_05;
import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.Tools;
import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.GbStateMapper;
import com.ccclubs.admin.model.GbState;
import com.ccclubs.admin.service.IGbStateService;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆国标历史信息的Service实现
 * @author Joel
 */
@Service
public class GbStateServiceImpl extends CrudService<GbStateMapper, GbState, Integer> implements IGbStateService{

    /**
     * 需要转换的GBMessage一定要包含GB0201与GB0205
     *
     * @param gbMessage
     */
    @Override
    public GbState transferGbMessageToGbState(GBMessage gbMessage) {
        GbState gbState=null;
        if (null!=gbMessage&&null!=gbMessage.getMessageContents()){
            GB_02 gb_02=(GB_02) gbMessage.getMessageContents();
            GB_02_01 gb_02_01=null;
            GB_02_05 gb_02_05=null;
            for (IRealTimeAdditionalItem iRealTimeAdditionalItem:gb_02.getAdditionals()){
                if (iRealTimeAdditionalItem.getAdditionalId()==1){
                    gb_02_01=(GB_02_01) iRealTimeAdditionalItem;
                    continue;
                }
                if (iRealTimeAdditionalItem.getAdditionalId()==5){
                    gb_02_05=(GB_02_05)iRealTimeAdditionalItem;
                    continue;
                }
            }
            if (!(gb_02_01==null&&gb_02_05==null)){
                gbState=new GbState();
                gbState.setvin(gbMessage.getVin());
                gbState.setTimeText(gbMessage.getMessageContents().getTime());
                if (gb_02_01!=null){
                    gbState.setAcceleratedPedalStrokeValueString(gb_02_01.getAcceleratedPedalStrokeValueString());
                    gbState.setBrakePedalStateString(gb_02_01.getBrakePedalStateString());
                    gbState.setChargingString(gb_02_01.getChargingString());
                    gbState.setCurrentString(gb_02_01.getCurrentString());
                    gbState.setDcDcStatusString(gb_02_01.getDcDcStatusString());
                    gbState.setGearString(gb_02_01.getGearString());
                    //gbState.setGsId();
                    gbState.setInsulationResistanceString(String.valueOf(gb_02_01.getInsulationResistance()));
                    gbState.setMileageString(gb_02_01.getMileageString());
                    gbState.setRunningModeString(gb_02_01.getRunningModeString());
                    gbState.setSocString(gb_02_01.getSocString());
                    gbState.setSpeedString(gb_02_01.getSpeedString());
                    gbState.setVehicleStatusString(gb_02_01.getVehicleStatusString());
                    gbState.setVoltageString(gb_02_01.getVoltageString());
                }
                if (gb_02_05!=null){
                    gbState.setLatitudeString(Float.valueOf(gb_02_05.getLatitude()));
                    gbState.setLongitudeString(Float.valueOf(gb_02_05.getLongitude()));
                    gbState.setPositionStatusString(gb_02_05.getPositionStatusString());
                }
            }
        }
        return gbState;
    }

    @Override
    public List<GbState> transferAllGbMessagesToGbStates(List<GBMessage> gbMessageList) {
        List<GbState> gbStateList=null;
        if (null!=gbMessageList&&gbMessageList.size()>0){
            gbStateList=new ArrayList<>();
            for (GBMessage gbMessage:gbMessageList){
                gbStateList.add(transferGbMessageToGbState(gbMessage));
            }
        }
        return gbStateList;
    }

}