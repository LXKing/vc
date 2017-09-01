package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class JT_8106 implements IMessageBody {

    /**
     * 参数个数
     */
    private byte parametersCount;

    public final byte getParametersCount() {
        return parametersCount;
    }

    public final void setParametersCount(byte value) {
        parametersCount = value;
    }

    /**
     * 参数列表
     */
    private java.util.ArrayList<ParameterId> parameters;

    public ArrayList<ParameterId> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<ParameterId> parameters) {
        this.parameters = parameters;
    }

    private String GetFieldType(int paramField) {
        return "" + JT808Common.GetParamType(paramField);
    }

    public final byte[] WriteToBytes() {

        MyBuffer buff = new MyBuffer();

        buff.put(getParametersCount());
        for (ParameterId item : getParameters()) {
            buff.put(item.getParameterId());

        }
        return buff.array();
    }

    public final void ReadFromBytes(byte[] bytes) {

        MyBuffer buff = new MyBuffer(bytes);

        setParametersCount(buff.get());
        setParameters(new java.util.ArrayList<ParameterId>(
                getParametersCount()));
        int pos = 1;
        while (buff.hasRemain()) {
            ParameterId item = new ParameterId();
            item.setParameterId(buff.getInt());

            getParameters().add(item);

        }

    }

}


