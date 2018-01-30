package com.ccclubs.engine.core.util;

import com.alibaba.fastjson.JSON;
import com.ccclubs.mongo.orm.dao.CsRemoteDao;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.CommonResult;
import com.ccclubs.protocol.dto.mqtt.CCCLUBS_60;
import com.ccclubs.protocol.dto.mqtt.CommonWriter;
import com.ccclubs.protocol.dto.mqtt.RemoteOption;
import com.ccclubs.protocol.dto.mqtt.RemoteParam;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class RemoteHelper {

    public static int SUCCESS_CODE = 1000000;
    public static int FAILED_CODE = 1001022;

    @Resource
    CsRemoteDao remoteDao;

    /**
     * 获取Remote实体
     *
     * @param msgResultString 返回结果
     * @param success         1:操作成功 2:操作失败
     * @param jsonString      备注
     */
    public static CsRemote getRemote(long id, String msgResultString, String jsonString,
                                     boolean success) {
        CsRemote csRemote = new CsRemote();
        csRemote.setCsrId(id);
        csRemote.setCsrStatus(success ? 1 : 2);
        csRemote.setCsrResultCode(msgResultString);
//    csRemote.setCsrRemark("");
        csRemote.setCsrResult(jsonString);
        csRemote.setCsrUpdateTime(new Date().getTime());
        return csRemote;
    }

    /**
     * 获取远程控制操作结果
     *
     * @param remoteOption 远程控制返回内容
     */
    public CsRemote getRemote(RemoteOption remoteOption, String hexString) {
        // 同步时钟有应答就算成功，
        if (isTimeSynchronization(remoteOption)) {
            return getRemote(remoteOption.id, hexString,
                    RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", SUCCESS_CODE, true),
                    true);
        }
        // 初始化有应答就算成功
        if (isInitialization(remoteOption)) {
            return getRemote(remoteOption.id, hexString,
                    RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", SUCCESS_CODE, true),
                    true);
        }

        // 是否是空调控制
        if (isAirCondition(remoteOption)) {
            if (hexString.endsWith("00")) {
                return getRemote(remoteOption.id, hexString,
                        RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", SUCCESS_CODE, true),
                        true);
            } else {
                return getRemote(remoteOption.id, hexString,
                        RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", FAILED_CODE, false),
                        false);
            }
        }

        //其它情况，如果发送指令跟返回指令一致，则表示成功，或者返回指令是发送指令后附加“0000”
        CsRemote csRemote = remoteDao.findById(remoteOption.id);
        //CsRemote csRemote = remoteDao.get(remoteOption.id);
        if (csRemote != null && !StringUtils.empty(csRemote.getCsrCode())) {
            // 是否是空调控制
            if (isAirCondition(remoteOption)) {
                if (hexString.endsWith("00")) {
                    return getRemote(remoteOption.id, hexString,
                            RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", SUCCESS_CODE, true),
                            true);
                } else {
                    return getRemote(remoteOption.id, hexString,
                            RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", FAILED_CODE, false),
                            false);
                }
            }

            // 如果
            if (hexString.equals(csRemote.getCsrCode().toUpperCase()) || hexString
                    .equals(csRemote.getCsrCode().toUpperCase() + "0000")) {
                return getRemote(remoteOption.id, hexString,
                        RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作成功", SUCCESS_CODE, true),
                        true);
            } else {
                return getRemote(remoteOption.id, hexString,
                        RemoteHelper.getRemoteJsonMessage(remoteOption.id, "操作失败", FAILED_CODE, false),
                        false);
            }
        } else {
            return getRemote(remoteOption.id, hexString,
                    RemoteHelper.getRemoteJsonMessage(remoteOption.id),
                    true);
        }
    }

    /**
     * 获取默认远程控制回复json格式：终端已收到指令并执行，结果未知
     */
    public static String getRemoteJsonMessage(long messageId) {
        return JSON.toJSONString(CommonResult.create(messageId, true, SUCCESS_CODE, "已操作，结果未知"));
    }

    public static String getRemoteJsonMessage(long messageId, String result, int code,
                                              boolean success) {
        return JSON.toJSONString(CommonResult.create(messageId, success, code, result));
    }

    /**
     * FC Code 0x06 ，复合指令
     *
     * @param operationCode 开门，关门的指令地址
     * @param srcArray      符合{@link CCCLUBS_60} 车机属性格式的字节数组
     * @param remoteResult  操作结果位，WORD
     */
    public static String getMultipleOperationJsonMessage(long messageId, int operationCode,
                                                         byte[] srcArray,
                                                         short remoteResult) {
        String jsonString = JSON
                .toJSONString(CommonResult.create(messageId, true, SUCCESS_CODE, "已操作，结果未知"));
        if (remoteResult == 0 || remoteResult == 0x00FF) {
            return JSON.toJSONString(CommonResult.create(messageId, true, SUCCESS_CODE, "操作成功"));
        }

        switch (operationCode) {
            // 关门
            case 0x10000000:
            case 0x10210000:
                CCCLUBS_60 terminalInfo = new CCCLUBS_60();
                terminalInfo.ReadFromBytes(srcArray);

                StringBuilder stringBuilder = getMutipleResult(remoteResult, terminalInfo);
                if (stringBuilder.length() > 0) {
                    jsonString = JSON.toJSONString(CommonResult.create(messageId, false, FAILED_CODE,
                            stringBuilder.toString().substring(0, stringBuilder.length() - 1)));
                }
                break;
            default:
                // 开门
                if (remoteResult == 0 || remoteResult == 0xFF) {
                    jsonString = JSON
                            .toJSONString(CommonResult.create(messageId, true, SUCCESS_CODE, "操作成功"));
                }
                break;
        }
        return jsonString;
    }

    /**
     * 获取远程控制回复json格式：关门，
     */
    public static String getRemoteJsonMessage(CommonWriter commonWriter, byte[] srcArray) {
        String jsonString = "{}";
        try {
            if (srcArray.length < 23) {
                return jsonString;
            }
            switch (commonWriter.mFucCode) {
                // 远程开关门
                case 0x05:
                    jsonString = getDoorResultJsonString(commonWriter.mId, srcArray);
                    break;
                //0x48(操作功能码)，远程还车
                case 0x48:
                    jsonString = getReturnResultJsonString(commonWriter.mId, srcArray);
                    break;
                default:
                    jsonString = getRemoteJsonMessage(commonWriter.mId);
                    break;
            }
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
            return jsonString;
        }
    }

    /**
     * 获取远程开，关门反馈结果
     */
    private static String getDoorResultJsonString(long messageId, byte[] srcArray) {
        String jsonString = "{}";
        int value = srcArray[20 + 2] & 0xFF;
        switch (value) {
            case 0:
                jsonString = JSON.toJSONString(CommonResult.create(messageId, true, SUCCESS_CODE, "操作成功"));
                break;
            // 只有在锁门命令下，才会有01出现
            case 0x01:
                jsonString = JSON.toJSONString(CommonResult.create(messageId, false, FAILED_CODE, "有车门未关"));
                if (srcArray.length == 21 + 8) {
                    // 车门{WORD|详见批注} | 车锁{WORD|详见批注} | 控制{WORD|详见批注}
                    byte doorMask = srcArray[20 + 2 + 1];
                    byte doorValue = srcArray[20 + 2 + 2];
                    // 车门，车锁都关好或无效
                    StringBuilder stringBuilder = getDoorString(doorValue);
                    if (stringBuilder.length() > 0) {
                        jsonString = JSON.toJSONString(CommonResult.create(messageId, false, FAILED_CODE,
                                stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关"));
                    }
                } else {
                    jsonString = getRemoteJsonMessage(messageId);
                }
                break;
            case 0x02:
                jsonString = JSON
                        .toJSONString(CommonResult.create(messageId, false, FAILED_CODE, "发动机未熄火"));
                break;
            default:
                jsonString = getRemoteJsonMessage(messageId);
                break;
        }
        return jsonString;
    }

    /**
     * 获取车门详细信息
     */
    private static StringBuilder getDoorString(byte doorValue) {
        StringBuilder stringBuilder = new StringBuilder();
        // Bit1 左前门有效位：0-无效，1-有效
        if (((doorValue >> 1) & 0x1) == 0x01) {
            stringBuilder.append("驾驶员门");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit2 右前门有效位：0-无效，1-有效
        if (((doorValue >> 2) & 0x1) == 0x01) {
            stringBuilder.append("副驾驶员门");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit3 左后门有效位：0-无效，1-有效
        if (((doorValue >> 3) & 0x1) == 0x01) {
            stringBuilder.append("驾驶员后门");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit4 右后门有效位：0-无效，1-有效
        if (((doorValue >> 4) & 0x1) == 0x01) {
            stringBuilder.append("副驾驶员后门");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit5 行李舱门有效位：0-无效，1-有效
        if (((doorValue >> 5) & 0x1) == 0x01) {
            stringBuilder.append("后备箱门");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit6 前机舱有效位：0-无效，1-有效
        if (((doorValue >> 6) & 0x1) == 0x01) {
            stringBuilder.append("引擎盖门");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        return stringBuilder;
    }

    /**
     * 获取车灯详细信息
     */
    private static StringBuilder getLightString(int lightValue) {
        StringBuilder stringBuilder = new StringBuilder();
        // Bit1 近光灯有效位： 0-OFF，1-ON
        if (((lightValue >> 1) & 0x1) == 0x01) {
            stringBuilder.append("近光灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit2 远光灯有效位：0-OFF，1-ON
        if (((lightValue >> 2) & 0x1) == 0x01) {
            stringBuilder.append("远光灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit3 前雾灯有效位：0-OFF，1-ON
        if (((lightValue >> 3) & 0x1) == 0x01) {
            stringBuilder.append("前雾灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit4 后雾灯有效位：0-OFF，1-ON
        if (((lightValue >> 4) & 0x1) == 0x01) {
            stringBuilder.append("后雾灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit5 左转向有效位：0-OFF，1-ON
        if (((lightValue >> 5) & 0x1) == 0x01) {
            stringBuilder.append("左转向灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit6 右转向有效位：0-OFF，1-ON
        if (((lightValue >> 6) & 0x1) == 0x01) {
            stringBuilder.append("右转向灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit7 位置灯有效位：0-OFF，1-ON
        if (((lightValue >> 7) & 0x1) == 0x01) {
            stringBuilder.append("位置灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // Bit8 故障灯有效位：0-无效，1-有效
        if (((lightValue >> 8) & 0x1) == 0x01) {
            stringBuilder.append("故障灯");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        return stringBuilder;
    }

    /**
     * 获取远程还车反馈结果
     * 1 Bit0 0-车门关好，1-车门未关好
     * 2 Bit1 0-已熄火，1-未熄火
     * 3 Bit2 0-钥匙拔出，1-未拔出
     * 4 Bit3 0-还车信息正确，1-还车信息不对（订单号不对）
     * 5 Bit4 0-有订单还车，1-无订单还车
     * 6 Bit5 0-慢充启动，1-慢充未启动
     * 7 Bit6 0-车灯全关，1-有车灯未关
     * 16 Bit15 0-基本模式，1-扩展模式
     * 0x0000 车机正常还车
     */
    private static String getReturnResultJsonString(long messageId, byte[] srcArray) {
        String jsonString = getRemoteJsonMessage(messageId);
        int highByte = srcArray[21] & 0xFF;
        int lowByte = srcArray[22] & 0xFF;
        int value = (highByte << 8) + lowByte;
        if (value == 0) {
            return JSON.toJSONString(CommonResult.create(messageId, true, SUCCESS_CODE, "操作成功"));
        }
        // 无订单还车
        if (((value >> 4) & 0x1) == 0x01) {
            return JSON.toJSONString(CommonResult.create(messageId, false, FAILED_CODE, "当前车辆无订单，不需要还车"));
        }
        // 还车信息不对
        if (((value >> 3) & 0x1) == 0x01) {
            return JSON.toJSONString(CommonResult.create(messageId, false, FAILED_CODE, "还车订单号不对"));
        }
        StringBuilder stringBuilder = getReturnResult(value, srcArray);
        if (stringBuilder.length() > 0) {
            jsonString =
                    JSON.toJSONString(CommonResult.create(messageId, false, FAILED_CODE,
                            stringBuilder.toString().substring(0, stringBuilder.length() - 1)));
        }

        // 扩展模式
//    if (((value >> 15) & 0x1) == 0x01) {
//      return $.json($.add("message", "扩展模式").add("code", value));
//    }

        return jsonString;
    }

    private static StringBuilder getReturnResult(int value, byte[] srcArray) {
        StringBuilder stringBuilder = new StringBuilder();
        // 未熄火
        if (((value >> 1) & 0x1) == 0x01) {
            stringBuilder.append("发动机未熄火");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // 钥匙未拔出
        if (((value >> 2) & 0x1) == 0x01) {
            stringBuilder.append("钥匙未拔出");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // 有车灯未关
        if (((value >> 6) & 0x1) == 0x01) {
            if (srcArray.length == 21 + 14) {
                int lightHighValue = (srcArray[20 + 10 + 1] & 0xFF);
                int lightLowValue = (srcArray[20 + 10 + 2] & 0xFF);
                int lightValue = (lightHighValue << 8) + lightLowValue;
                StringBuilder stringBuilderLight = getLightString(lightValue);
                if (stringBuilderLight.length() > 0) {
                    stringBuilder
                            .append(
                                    stringBuilderLight.toString().substring(0, stringBuilderLight.length() - 1)
                                            + "未关");
                    stringBuilder.append(ConstantUtils.SEPARATOR);
                }
            } else {
                stringBuilder.append("有车灯未关");
                stringBuilder.append(ConstantUtils.SEPARATOR);
            }
        } else {
            if (srcArray.length == 21 + 14) {
                int lightHighValue = (srcArray[20 + 10 + 1] & 0xFF);
                int lightLowValue = (srcArray[20 + 10 + 2] & 0xFF);
                int lightValue = (lightHighValue << 8) + lightLowValue;
                StringBuilder stringBuilderLight = getLightString(lightValue);
                if (stringBuilderLight.length() > 0) {
                    stringBuilder
                            .append(
                                    stringBuilderLight.toString().substring(0, stringBuilderLight.length() - 1)
                                            + "未关");
                    stringBuilder.append(ConstantUtils.SEPARATOR);
                }
            }
        }
        // 有车门未关好
        if ((value & 0x1) == 0x01) {
            if (srcArray.length == 21 + 14) {
                byte doorValue = srcArray[20 + 2 + 2];
                StringBuilder stringBuilderDoor = getDoorString(doorValue);
                if (stringBuilderDoor.length() > 0) {
                    stringBuilder
                            .append(
                                    stringBuilderDoor.toString().substring(0, stringBuilderDoor.length() - 1) + "未关");
                    stringBuilder.append(ConstantUtils.SEPARATOR);
                }
            } else {
                stringBuilder.append("有车门未关");
                stringBuilder.append(ConstantUtils.SEPARATOR);
            }
        }
        // 慢充未启动
        if (((value >> 5) & 0x1) == 0x01) {
            stringBuilder.append("未充电");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        return stringBuilder;
    }

    /**
     * 复合指令关门操作校验
     */
    private static StringBuilder getMutipleResult(int value, CCCLUBS_60 terminalInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        // 有车门未关好
        if ((value & 0x1) == 0x01) {
          StringBuilder stringBuilderDoor = getDoorString(
              (byte) (terminalInfo.getTriggerMergeDoorStatusWithMask() & 0x00FF));
          if (stringBuilderDoor.length() > 0) {
            stringBuilder
                .append(
                    stringBuilderDoor.toString().substring(0, stringBuilderDoor.length() - 1) + "未关");
            stringBuilder.append(ConstantUtils.SEPARATOR);
          }
        }
        // 未熄火
        if (((value >> 1) & 0x1) == 0x01) {
            stringBuilder.append("发动机未熄火");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // 钥匙未拔出
        if (((value >> 2) & 0x1) == 0x01) {
            stringBuilder.append("钥匙未拔出");
            stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // 慢充未启动
        if (((value >> 5) & 0x1) == 0x01) {
          stringBuilder.append("未充电");
          stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // 有车灯未关
        if (((value >> 6) & 0x1) == 0x01) {
            StringBuilder stringBuilderLight = getLightString(
                    terminalInfo.getTriggerLightStatusWithMask());
            if (stringBuilderLight.length() > 0) {
                stringBuilder
                        .append(
                                stringBuilderLight.toString().substring(0, stringBuilderLight.length() - 1)
                                        + "未关");
                stringBuilder.append(ConstantUtils.SEPARATOR);
            }
        }
        // 钥匙未插入不允许操作
        if (((value >> 7) & 0x1) == 0x01) {
          stringBuilder.append("钥匙必须插入");
          stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        // 参数获取错误
        if (((value >> 8) & 0x1) == 0x01) {
          stringBuilder.append("参数获取错误");
          stringBuilder.append(ConstantUtils.SEPARATOR);
        }
        return stringBuilder;
    }

    /**
     * 是否是同步时间
     */
    public static boolean isTimeSynchronization(RemoteOption remoteOption) {
        boolean result = false;
        if (remoteOption.function == 0x10 && remoteOption.address ==
                (short) 0xC000 && (remoteOption.value == (short) 0x0002 || remoteOption.value == 0x00)) {
            result = true;
        }
        return result;
    }

    /**
     * 是否是空调控制
     */
    public static boolean isAirCondition(RemoteOption remoteOption) {
        boolean result = false;
        if (remoteOption.function == 0x10 && remoteOption.address ==
                (short) 0x9008 && (remoteOption.value == (short) 0x0001)) {
            result = true;
        }
        return result;
    }

    /**
     * 是否是初始化
     */
    public static boolean isInitialization(RemoteOption remoteOption) {
        boolean result = false;
        if (remoteOption.function == 0x46 && remoteOption.address ==
                (short) 0x0000 && remoteOption.value == (short) 0x0000) {
            result = true;
        }
        return result;
    }

    public static RemoteOption getLowPower(String carNumber) {
        RemoteOption remoteOption = new RemoteOption();
        remoteOption.function = 0x6F;
        remoteOption.address = 0x0473;
        remoteOption.value = 0x0001;
        remoteOption.id = 10l;
        remoteOption.subcode = new byte[]{0x10};
        remoteOption.number = carNumber;
        remoteOption.params = (new RemoteParam.PowerSavingMode((byte) 0x02, (short) (120 * 60))).getParamArray();
        return remoteOption;
    }


}
