package com.ccclubs.protocol.util;


import com.ccclubs.protocol.dto.jt808.JT_0900;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.transform.TerminalStatus;

/**
 * @author qsxiaogang
 * @create 2017-12-17
 **/
public class TerminalStatusUtils {

    private static final String SEPARATOR = ",";
    public static final String ALL_OK = "全关";

    /**
     * 获取车门详细信息
     */
    public static String getDoorString(short doorStatus) {
        // 取高字节
        byte doorMask = (byte) (doorStatus >> 8);
        // 取低字节
        byte doorValue = (byte) (doorStatus & 0x0FF);

        StringBuilder stringBuilder = new StringBuilder();
        // Bit0 所有门状态有效位：0-无效，1-有效
        if ((doorMask & 0x1) == 0x1) {
            if ((doorValue & 0x1) == 0x01) {
                // 排除 "所有门状态" 外，其他所有门的状态位都为0，那么直接返回有车门未关
                if (((doorValue >> 1) & 0xF) == 0) {
                    return "有车门未关";
                }
            } else {
                return ALL_OK;
            }
        }

        // Bit1 左前门有效位：0-无效，1-有效
        if (((doorMask >> 1) & 0x1) == 0x01) {
            if (((doorValue >> 1) & 0x1) == 0x01) {
                stringBuilder.append("驾驶员门");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit2 右前门有效位：0-无效，1-有效
        if (((doorMask >> 2) & 0x1) == 0x01) {
            if (((doorValue >> 2) & 0x1) == 0x01) {
                stringBuilder.append("副驾驶员门");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit3 左后门有效位：0-无效，1-有效
        if (((doorMask >> 3) & 0x1) == 0x01) {
            if (((doorValue >> 3) & 0x1) == 0x01) {
                stringBuilder.append("驾驶员后门");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit4 右后门有效位：0-无效，1-有效
        if (((doorMask >> 4) & 0x1) == 0x01) {
            if (((doorValue >> 4) & 0x1) == 0x01) {
                stringBuilder.append("副驾驶员后门");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit5 行李舱门有效位：0-无效，1-有效
        if (((doorMask >> 5) & 0x1) == 0x01) {
            if (((doorValue >> 5) & 0x1) == 0x01) {
                stringBuilder.append("后备箱门");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit6 前机舱有效位：0-无效，1-有效
        if (((doorMask >> 6) & 0x1) == 0x01) {
            if (((doorValue >> 6) & 0x1) == 0x01) {
                stringBuilder.append("引擎盖门");
                stringBuilder.append(SEPARATOR);
            }
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关";
        } else {
            return ALL_OK;
        }
    }


    /**
     * 获取车锁详细信息
     */
    public static String getDoorLockString(short doorLockStatus) {
        // 取高字节
        byte doorLockMask = (byte) (doorLockStatus >> 8);
        // 取低字节
        byte doorLockValue = (byte) (doorLockStatus & 0x0FF);

        StringBuilder stringBuilder = new StringBuilder();
        // Bit0 所有锁状态有效位：0-无效，1-有效
        if ((doorLockMask & 0x1) == 0x1) {
            if ((doorLockValue & 0x1) == 0x01) {
                // 排除 "所有锁状态" 外，其他所有锁的状态位都为0，那么直接返回有车锁未落下
                if (((doorLockValue >> 1) & 0xF) == 0) {
                    return "有车锁未落";
                }
            } else {
                return ALL_OK;
            }
        }

        // Bit1 左前门锁有效位：0-无效，1-有效
        if (((doorLockMask >> 1) & 0x1) == 0x01) {
            if (((doorLockValue >> 1) & 0x1) == 0x01) {
                stringBuilder.append("驾驶员门锁");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit2 右前门锁有效位：0-无效，1-有效
        if (((doorLockMask >> 2) & 0x1) == 0x01) {
            if (((doorLockValue >> 2) & 0x1) == 0x01) {
                stringBuilder.append("副驾驶员门锁");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit3 左后门有效位：0-无效，1-有效
        if (((doorLockMask >> 3) & 0x1) == 0x01) {
            if (((doorLockValue >> 3) & 0x1) == 0x01) {
                stringBuilder.append("驾驶员后门锁");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit4 右后门锁有效位：0-无效，1-有效
        if (((doorLockMask >> 4) & 0x1) == 0x01) {
            if (((doorLockValue >> 4) & 0x1) == 0x01) {
                stringBuilder.append("副驾驶员后门锁");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit5 行李舱门锁有效位：0-无效，1-有效
        if (((doorLockMask >> 5) & 0x1) == 0x01) {
            if (((doorLockValue >> 5) & 0x1) == 0x01) {
                stringBuilder.append("后备箱锁");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit6 前机舱锁有效位：0-无效，1-有效
        if (((doorLockMask >> 6) & 0x1) == 0x01) {
            if (((doorLockValue >> 6) & 0x1) == 0x01) {
                stringBuilder.append("引擎盖锁");
                stringBuilder.append(SEPARATOR);
            }
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关";
        } else {
            return ALL_OK;
        }
    }

    /**
     * 获取车辆启动控制状态【长安只用了钥匙启动控制】
     * */
    public  static  String getControlStatus(int controlStatus){
        // 取高字节
        byte controlStatusMask = (byte) (controlStatus >> 8);
        // 取低字节
        byte controlStatusValue = (byte) (controlStatus & 0x0FF);

        StringBuilder stringBuilder = new StringBuilder();

        // Bit0 钥匙启动控制： 0-禁止钥匙启动，1-允许钥匙启动
        if (((controlStatusMask >> 0) & 0x1) == 0x01) {
            if (((controlStatusValue >> 0) & 0x1) == 0x01) {
                stringBuilder.append("允许钥匙启动");
                stringBuilder.append(SEPARATOR);
            }
            else {
                stringBuilder.append("禁止钥匙启动");
                stringBuilder.append(SEPARATOR);
            }
        }

        // Bit1 按钮启动控制： 0-按钮无效    ，1-按钮有效
        if (((controlStatusMask >> 1) & 0x1) == 0x01) {
            if (((controlStatusValue >> 1) & 0x1) == 0x01) {
                stringBuilder.append("按钮启动有效");
                stringBuilder.append(SEPARATOR);
            }
            else {
                stringBuilder.append("按钮启动无效");
                stringBuilder.append(SEPARATOR);
            }
        }

        // Bit2 蓝牙电源状态： 0-开启        ，1-关闭
        if (((controlStatusMask >> 2) & 0x1) == 0x01) {
            if (((controlStatusValue >> 2) & 0x1) == 0x01) {
                stringBuilder.append("蓝牙电源关闭");
                stringBuilder.append(SEPARATOR);
            }
            else {
                stringBuilder.append("蓝牙电源开启");
                stringBuilder.append(SEPARATOR);
            }
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关";
        } else {
            return "";
        }
    }

    /**
     * 获取车灯详细信息
     */
    public static String getLightString(int lightStatus) {
        // 取高双字节
        short lightMask = (short) (lightStatus >> 16);
        // 取低双字节
        short lightValue = (short) (lightStatus & 0x0FFFF);

        StringBuilder stringBuilder = new StringBuilder();

        // Bit0 所有灯状态有效位：0-无效，1-有效
        if ((lightMask & 0x1) == 0x1) {
            if ((lightValue & 0x1) == 0x01) {
                // 排除 "所有灯状态" 外，其他所有灯的状态位都为0，那么直接返回有车灯未关
                if (((lightValue >> 1) & 0xF) == 0) {
                    return "有车灯未关";
                }
            } else {
                return ALL_OK;
            }
        }

        // Bit1 近光灯有效位： 0-OFF，1-ON
        if (((lightMask >> 1) & 0x1) == 0x01) {
            if (((lightValue >> 1) & 0x1) == 0x01) {
                stringBuilder.append("近光灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit2 远光灯有效位：0-OFF，1-ON
        if (((lightMask >> 2) & 0x1) == 0x01) {
            if (((lightValue >> 2) & 0x1) == 0x01) {
                stringBuilder.append("远光灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit3 前雾灯有效位：0-OFF，1-ON
        if (((lightMask >> 3) & 0x1) == 0x01) {
            if (((lightValue >> 3) & 0x1) == 0x01) {
                stringBuilder.append("前雾灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit4 后雾灯有效位：0-OFF，1-ON
        if (((lightMask >> 4) & 0x1) == 0x01) {
            if (((lightValue >> 4) & 0x1) == 0x01) {
                stringBuilder.append("后雾灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit5 左转向有效位：0-OFF，1-ON
        if (((lightMask >> 5) & 0x1) == 0x01) {
            if (((lightValue >> 5) & 0x1) == 0x01) {
                stringBuilder.append("左转向灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit6 右转向有效位：0-OFF，1-ON
        if (((lightMask >> 6) & 0x1) == 0x01) {
            if (((lightValue >> 6) & 0x1) == 0x01) {
                stringBuilder.append("右转向灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit7 位置灯有效位：0-OFF，1-ON
        if (((lightMask >> 7) & 0x1) == 0x01) {
            if (((lightValue >> 7) & 0x1) == 0x01) {
                stringBuilder.append("位置灯");
                stringBuilder.append(SEPARATOR);
            }
        }
        // Bit8 故障灯有效位：0-无效，1-有效
        if (((lightMask >> 8) & 0x1) == 0x01) {
            if (((lightValue >> 8) & 0x1) == 0x01) {
                stringBuilder.append("故障灯");
                stringBuilder.append(SEPARATOR);
            }
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关";
        } else {
            return ALL_OK;
        }

    }

    /**
     * 获取自动驾驶状态详细信息
     */
    public static String getAutopilotString(long autopilotState) {
        StringBuilder stringBuilder = new StringBuilder();
        //高字节无数据直接舍弃
        // 取4低字节
        long autopilotValue = (long) (autopilotState & 0x0FFFFFFFF);

        //取byte[0] 目标站点
        int targetSite = ((int) (autopilotValue >> 24)) & 0x0FF;
        //取byte[1] 当前站点
        int currentSite = ((int) (autopilotValue >> 16)) & 0x0FF;
        //int autopilotSite=(int)(autopilotValue>>8);

        //short autopilotStateByte=(short)(autopilotValue&0x0FF);
        //short currentSite=(short)(autopilotSite&0x0F);//0x0=默认值；0x1~0xD=1-13;0xE~0xF=Reserved
        //short targetSite=(short)(autopilotSite>>4);//0x0=默认值；0x1~0xD=1-13;0xE=循环行驶;0xF=维保站点；


        if (targetSite == 0x0) {
            stringBuilder.append("目标站点为默认值");
            stringBuilder.append(SEPARATOR);
        } else if (targetSite >= 0x1 && targetSite <= 0xD) {
            stringBuilder.append("目标站点为" + targetSite);
            stringBuilder.append(SEPARATOR);
        } else if (targetSite == 0xE) {
            stringBuilder.append("目标站点为循环行驶");
            stringBuilder.append(SEPARATOR);
        } else if (targetSite == 0xF) {
            stringBuilder.append("目标站点为维保站点");
            stringBuilder.append(SEPARATOR);
        } else {
            stringBuilder.append("目标站点为未知的异常值").append(targetSite);
            stringBuilder.append(SEPARATOR);
        }

        if (currentSite == 0x0) {
            stringBuilder.append("当前站点为默认值");
            stringBuilder.append(SEPARATOR);
        } else if (currentSite >= 0x1 && currentSite <= 0xD) {
            stringBuilder.append("当前站点为" + currentSite);
            stringBuilder.append(SEPARATOR);
        } else if (currentSite == 0xE || currentSite == 0xF) {
            stringBuilder.append("当前站点为Reserved");
            stringBuilder.append(SEPARATOR);
        } else {
            stringBuilder.append("当前站点为未知的异常值").append(currentSite);
            stringBuilder.append(SEPARATOR);
        }

        //取byte[2]
        int stopState = ((int) (autopilotValue >> 8)) & 0x0FF;
        //停靠状态
        short stopStatus = (short) (stopState & 0x0F);
        //站点握手状态
        short shakeHandsState = (short) ((stopState >> 4) & 0x0F);
        //取byte[3] 自动驾驶状态
        int autopilotRunState = (int) (autopilotValue & 0x0FF);
        //short stopState=(short)(autopilotStateByte>>6);// 0x0=默认值；0x1 =站点停靠; 0x2=区间停靠;0x3=非停靠状态;
        //short autopilotRunState=(short)(autopilotStateByte&0x03F);//0x0：默认值;0x1:  车辆Ready;  0x2：自动驾驶Active;  0x3:自动驾驶故障

        if (stopStatus == 0x0) {
            stringBuilder.append("停靠状态为默认值");
            stringBuilder.append(SEPARATOR);
        } else if (stopStatus == 0x1) {
            stringBuilder.append("停靠状态为站点停靠");
            stringBuilder.append(SEPARATOR);
        } else if (stopStatus == 0x2) {
            stringBuilder.append("停靠状态为区间停靠");
            stringBuilder.append(SEPARATOR);
        } else if (stopStatus == 0x3) {
            stringBuilder.append("停靠状态为非停靠状态");
            stringBuilder.append(SEPARATOR);
        } else {
            stringBuilder.append("停靠状态为未知的异常值").append(stopStatus);
            stringBuilder.append(SEPARATOR);
        }

        if (shakeHandsState == 0x0) {
            stringBuilder.append("握手状态为默认值");
            stringBuilder.append(SEPARATOR);
        } else if (shakeHandsState == 0x1) {
            stringBuilder.append("握手状态为即将到站");
            stringBuilder.append(SEPARATOR);
        } else if (shakeHandsState == 0x2) {
            stringBuilder.append("握手状态为站点停靠");
            stringBuilder.append(SEPARATOR);
        } else if (shakeHandsState == 0x3) {
            stringBuilder.append("握手状态为站点经过");
            stringBuilder.append(SEPARATOR);
        } else {
            stringBuilder.append("握手状态为未知的异常值").append(shakeHandsState);
            stringBuilder.append(SEPARATOR);
        }


        if (autopilotRunState == 0x0) {
            stringBuilder.append("自动驾驶状态为默认值");
            stringBuilder.append(SEPARATOR);
        } else if (autopilotRunState == 0x1) {
            stringBuilder.append("自动驾驶状态为车辆Ready");
            stringBuilder.append(SEPARATOR);
        } else if (autopilotRunState == 0x2) {
            stringBuilder.append("自动驾驶状态为自动驾驶Active");
            stringBuilder.append(SEPARATOR);
        } else if (autopilotRunState == 0x3) {
            stringBuilder.append("自动驾驶状态为自动驾驶故障");
            stringBuilder.append(SEPARATOR);
        } else {
            stringBuilder.append("自动驾驶状态为未知的异常值").append(autopilotRunState);
            stringBuilder.append(SEPARATOR);
        }


        if (autopilotValue == 0) {
            return "车辆维保中";
        }


        return stringBuilder.toString();
    }

    public static void main(String args[]) {
        T808Message t808Message=new T808Message();
        String hexString="7E090000AA0648067742910001F1543636533335313600000000000000006803001D227236960200000729C40201CCA224000064C800000000000000000016282800000004BA7E02000000000000030200000000000000000000000000000000000000000000000000000000000000000000030107363653333531362901016801007206335500002B0576015F8E04000000009901009A04000223006F020000CA020000CC020000CE0400000000D0020302940400000000A97E";
        byte[] hexByte=Tools.HexString2Bytes(hexString);
        t808Message.ReadFromBytes(hexByte);
        JT_0900 jt0900 = (JT_0900) t808Message.getMessageContents();
        MqMessage mqMessage = new MqMessage();
        mqMessage.ReadFromBytes(jt0900.getMessageContent());

//        TerminalStatusUtils.getAutopilotString(33624834L);
    }



}
