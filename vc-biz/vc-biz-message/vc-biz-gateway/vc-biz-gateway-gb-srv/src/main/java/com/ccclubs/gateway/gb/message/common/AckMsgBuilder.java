package com.ccclubs.gateway.gb.message.common;

import com.ccclubs.gateway.gb.constant.AckType;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.constant.PackagePart;
import com.ccclubs.gateway.gb.utils.ValidUtil;
import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/3/27
 * @Time: 16:48
 * Email:  yeanzhi@ccclubs.com
 *
 *      TODO 所有应答先依照平台间通信的协议进行，即：
 *      TODO    应答时，变更应答标记->保留应答报文时间->删除其余报文内容，
 */
public class AckMsgBuilder {

    public static ByteBuf ofSuccess(ByteBuf sourceBuff) {
        int commandTypeVal = sourceBuff.getByte(PackagePart.COMMAND_MARK.getStartIndex());
        CommandType msgType = CommandType.getByCode(commandTypeVal);
        // 终端校时时，向消息体中添加时间
        if (CommandType.TIME_CHECK.equals(msgType)) {
            sourceBuff.resetReaderIndex();
            // 时间的长度为6
            sourceBuff.setShort(PackagePart.CONTENT_LENGTH.getStartIndex(), 6);
            GBDateTime nowDateTime = GBDateTime.readFromTime(System.currentTimeMillis());
            sourceBuff.writerIndex(PackagePart.CONTENT.getStartIndex());
            nowDateTime.write2Buf(sourceBuff);
            // 初始化一个校验码
            sourceBuff.writeByte(0xFF);
        }
        return changeMarkAndValidByte(sourceBuff, AckType.ACK_SUCCESS);
    }

    public static ByteBuf ofFail(ByteBuf sourceBuff) {

        return changeMarkAndValidByte(sourceBuff, AckType.ACK_FAIL);
    }

    /**
     * 将该消息 变更应答标记和重新计算校验位
     * @param sourceBuff
     * @param ackType
     * @return
     */
    private static ByteBuf changeMarkAndValidByte(ByteBuf sourceBuff, AckType ackType) {

        // 1. 变更应答标记
        sourceBuff.setByte(PackagePart.ACK_MARK.getStartIndex(), ackType.getCode());

        // 2.保留应答报文时间, 删除其余报文内容
//        int commandTypeVal = sourceBuff.getByte(PackagePart.COMMAND_MARK.getStartIndex());
//        CommandType msgType = CommandType.getByCode(commandTypeVal);
//        switch (msgType) {
//            case REALTIME_DATA:
//                // 实时数据不做应答
//                return null;
//            case VEHICLE_LOGIN:
//            case VEHICLE_LOGOUT:
//            case PLATE_LOGIN:
//            case PLATE_LOGOUT:
//                // 修改报文的长度字节(固定为6)
//                sourceBuff.setShort(PackagePart.CONTENT_LENGTH.getStartIndex(), 6);
//                // 保留报文时间，删除其他报文
//                sourceBuff.writerIndex(CONTENT_AFTER_TIME_IDX);
//                // 初始化一个校验码
//                sourceBuff.writeByte(0xFF);
//                sourceBuff.discardReadBytes();
//                break;
//
//            default:
//                // 其他类型的消息无报文时间
//                break;
//        }

        byte newValidByte = ValidUtil.caculateValidByteFromBuff(sourceBuff);
        int readableBytes = sourceBuff.readableBytes();

        // 调整指针指向末端
        sourceBuff.setByte(readableBytes - 1, newValidByte);

        sourceBuff.resetReaderIndex();
        return sourceBuff;
    }



}
