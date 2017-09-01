package com.ccclubs.olap.protocol.protocolmodel.gb;


import com.ccclubs.olap.protocol.protocolmodel.IMessageBody;

public interface IRealTimeAdditionalItem extends IMessageBody {

    int getMessageId();
    /**
     * 返回-1表示变长
     * @return
     */
    int getMessageLength();


}
