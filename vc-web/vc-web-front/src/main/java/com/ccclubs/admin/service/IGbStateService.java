package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.GbState;
import com.ccclubs.protocol.dto.gb.GBMessage;

import java.util.List;

/**
 * 车辆国标历史信息的Service接口
 * @author Joel
 */
public interface IGbStateService extends BaseService<GbState, Integer>{
    /**
     * 需要转换的GBMessage一定要包含GB0201与GB0205
     * */
	GbState transferGbMessageToGbState(GBMessage gbMessage);
    List<GbState> transferAllGbMessagesToGbStates(List<GBMessage> gbMessageList);
}