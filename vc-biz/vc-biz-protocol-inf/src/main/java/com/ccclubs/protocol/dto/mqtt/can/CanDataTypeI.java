package com.ccclubs.protocol.dto.mqtt.can;

import com.ccclubs.protocol.dto.mqtt.CStruct;
import com.ccclubs.protocol.inf.ICanData;
import com.ccclubs.protocol.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * Can 包数据，类型I
 *
 * @author qsxiaogang
 */
public class CanDataTypeI extends CStruct implements ICanData {

  public short mCanId;

  public byte mCanLength;

  public byte mCanData1;
  public byte mCanData2;
  public byte mCanData3;
  public byte mCanData4;
  public byte mCanData5;
  public byte mCanData6;
  public byte mCanData7;
  public byte mCanData8;

  @Override
  public int getLength() {
    return CStruct.sizeof(CanDataTypeI.class);
  }

  @Override
  public void traceStruct() {
    CStruct.trace(this);
  }

  @Override
  public Map<String, Object> getMap() {
    Map<String, Object> mapResult = new HashMap<String, Object>();
    switch (this.mCanId) {
      case 0x30:
        // 0..1 共2位
        mapResult.put("SYS_Status", getSysStatus(this.mCanData1 & 0x3));
        break;
      case 0x300:
        // 0..2 共3位
        mapResult.put("档位状态", getGearPos(this.mCanData1 & 0x7));
        // 3..3 共1位
        mapResult.put("DC/DC开闭状态", ((this.mCanData1 >> 3) & 0x1) == 0x0 ? "Normal" : "Fault");
        // 4..4 共1位
        mapResult.put("主动节能模式状态", ((this.mCanData1 >> 4) & 0x1) == 0x0 ? "OFF" : "ON");
        // 5..5 共1位
        mapResult.put("被动节能模式状态", ((this.mCanData1 >> 5) & 0x1) == 0x0 ? "OFF" : "ON");
        // 6..6 共1位
        // mapResult.put("DIAGNOSIS_MODE", ((this.mCanData0 >> 1) & 0x1) ==
        // 0x0 ? "OFF" : "ON");
        // 8..15 共8位
        mapResult.put("车速信息", (this.mCanData2 & 0xff) + "Km/h");
        // 16..18 共3位
        mapResult.put("VCU故障信息", getVcuFault(this.mCanData3 & 0x7));
        // 19 共1位
        mapResult.put("车速信号有效位", ((this.mCanData3 >> 3) & 0x1) == 0x0 ? "Invalid" : "Valid");
        // 20..22 共3位
        mapResult.put("制动踏板状态", getBrakeStatus((this.mCanData3 >> 4) & 0x7));
        break;

      case 0x301:
        // 0..15 共16位 Conversion : DATA*1-32000(RPM)
        mapResult
            .put("电机转速", ((this.mCanData1 & 0xff) * 256 + (this.mCanData2 & 0xff) - 32000) + "RPM");
        // 16..31 共16位
        mapResult.put("电机功率", ((this.mCanData3 & 0xff) * 256 + (this.mCanData4 & 0xff)) + "kw");
        // 32..47 共16位 Conversion : DATA*1-50(℃)
        mapResult.put("电机温度", ((this.mCanData5 & 0xff) * 256 + (this.mCanData6 & 0xff) - 50) + "℃");
        // 48..55 共8位 Conversion : DATA*1-50(℃)
        mapResult.put("电机控制器温度", ((this.mCanData7 & 0xff) - 50) + "℃");
        // 56 共1位
        mapResult.put("电机过温报警", (this.mCanData8 & 0x1) == 0x0 ? "Normal" : "OverTemp");
        // 57..58 共2位
        mapResult.put("电机控制器报警", getMcuFault(this.mCanData8 >> 1 & 0x3));
        break;

      case 0x302:
        // 0..15 共16位 Conversion : DATA*0.1(V)
        mapResult.put("动力电池母线电压",
            StringUtils.digit(((this.mCanData1 & 0xff) * 256 + (this.mCanData2 & 0xff)) * 0.1, 2)
                + "V");
        // 16..31 共16位 Conversion : DATA*0.1-600（A）
        mapResult.put("动力电池母线电流", StringUtils
            .digit(((this.mCanData3 & 0xff) * 256 + (this.mCanData4 & 0xff)) * 0.1 - 600, 2) + "A");
        // 32..39 共8位
        mapResult.put("动力电池剩余电量", this.mCanData5 + "%");
        // 40..55 共16位
        mapResult.put("单体电池最高电压", ((this.mCanData6 & 0xff) * 256 + (this.mCanData7 & 0xff)) + "mV");
        // 56..63 共8位
        mapResult.put("单体电池最高电压编号", this.mCanData8 & 0xff);
        break;
      case 0x303:
        // 0..15 共16位
        mapResult.put("单体电池最低电压", ((this.mCanData1 & 0xff) * 256 + (this.mCanData2 & 0xff)) + "mV");
        // 16..23 共8位
        mapResult.put("单体电池最低电压编号", this.mCanData3 & 0xff);
        // 24..31 共8位
        mapResult.put("电池组最高温度", ((this.mCanData4 & 0xff) - 50) + "℃");
        // 32..39 共8位
        mapResult.put("单体电池最高温度编号", this.mCanData5 & 0xff);
        // 40..47 共8位
        mapResult.put("电池组最低温度", ((this.mCanData6 & 0xff) - 50) + "℃");
        // 48..55 共8位
        mapResult.put("单体电池最低温度编号", this.mCanData7 & 0xff);
        break;
      case 0x304:
        // 0..3 共4位
        mapResult.put("电池管理系统故障", getVcuFault(this.mCanData1 & 0xF));
        // 4..4 共1位
        mapResult.put("动力电池切断报警", (((this.mCanData1 & 0xff) >> 4) & 0x1) == 0x0 ? "正常" : "断开");
        // 5..5 共1位
        mapResult.put("充电枪连接指示", (((this.mCanData1 & 0xff) >> 5) & 0x1) == 0x0 ? "未连接" : "连接");
        // 6..7 共2位
        mapResult.put("充电指示", getChargeIndicate((this.mCanData1 & 0xff) >> 6));

        // 8..8 共1位
        mapResult.put("ABS故障报警", (this.mCanData2 & 0x1) == 0x0 ? "正常" : "故障");
        // 9..9 共1位
        mapResult.put("EBD故障报警", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 10..10 共1位
        mapResult.put("ESC故障报警", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 11..11 共1位
        mapResult.put("安全气囊故障(预留）", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 12..12 共1位
        mapResult.put("EPS故障", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 13..13 共1位
        mapResult.put("车辆碰撞信号", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "Normal" : "Crash");
        // 14..14 共1位
        mapResult.put("ESC关闭信号", (this.mCanData2 >> 6 & 0x1) == 0x0 ? "Invalid" : "Active");
        // 15..15 共1位
        mapResult.put("定速巡航状态", (this.mCanData2 >> 7 & 0x1) == 0x0 ? "OFF" : "ON");

        // 16..23 共8位
        mapResult.put("充电剩余时间小时", this.mCanData3);
        // 24..31 共8位
        mapResult.put("充电剩余时间分钟", this.mCanData4);

        // 32..32 共1位
        mapResult.put("压缩机、PTC允许信号", (this.mCanData3 & 0x1) == 0x1 ? "Unable" : "Able");
        // 33..33 共1位
        mapResult.put("EPB故障报警", (this.mCanData3 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 34..35 共2位
        mapResult.put("EPB驻车状态", getEpbParkingStatus(this.mCanData3 >> 2 & 0x3));
        // 36..37 共2位
        mapResult.put("EPB状态", getEpbStatus(this.mCanData3 >> 4 & 0x3));
        // 38..38 共1位
        mapResult
            .put("EPB紧急制动", (this.mCanData3 >> 5 & 0x1) == 0x0 ? "Normal" : "Emergency Parking");
        // 39..39 共1位
        mapResult.put("EVP故障报警", (this.mCanData3 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        break;
      case 0x305:
        // 0..7 共8位
        mapResult.put("单体电池电压发送序号", this.mCanData1 & 0xff);
        // 8..15 共8位
        mapResult.put("单体电池电压（1）", (this.mCanData2 & 0xff) * 256 + (this.mCanData3 & 0xff) + "mV");
        // 16..23 共8位
        // mapResult.put("单体电池电压低字节（1）", (this.mCanData3 & 0xff) + "mV");
        // 24..31 共8位
        mapResult.put("单体电池电压（2）", (this.mCanData4 & 0xff) * 256 + (this.mCanData5 & 0xff) + "mV");
        // 32..39 共8位
        // mapResult.put("单体电池电压低字节（2）", (this.mCanData5 & 0xff) + "mV");
        // 40..47 共8位
        mapResult.put("单体电池电压（3）", (this.mCanData6 & 0xff) * 256 + (this.mCanData7 & 0xff) + "mV");
        // 48..55 共8位
        // mapResult.put("单体电池电压低字节（3）", (this.mCanData7 & 0xff) + "mV");
        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8 & 0xff);
        break;
      case 0x306:
        // 0..7 共8位
        mapResult.put("电池温度发送序号", this.mCanData1);
        // 8..15 共8位 Conversion : DATA*1-40(℃)
        mapResult.put("电池温度（1）", ((this.mCanData2 & 0xff) - 40) + "℃");
        // 16..23 共8位 Conversion : DATA*1-40(℃)
        mapResult.put("电池温度（2）", ((this.mCanData3 & 0xff) - 40) + "℃");
        // 24..31 共8位 Conversion : DATA*1-40(℃)
        mapResult.put("电池温度（3）", ((this.mCanData4 & 0xff) - 40) + "℃");
        // 32..39 共8位 Conversion : DATA*1-40(℃)
        mapResult.put("电池温度（4）", ((this.mCanData5 & 0xff) - 40) + "℃");
        // 40..47 共8位 Conversion : DATA*1-40(℃)
        mapResult.put("电池温度（5）", ((this.mCanData6 & 0xff) - 40) + "℃");
        // 48..55 共8位 Conversion : DATA*1-40(℃)
        mapResult.put("电池温度（6）", ((this.mCanData7 & 0xff) - 40) + "℃");
        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8);
        break;

      case 0x307:
        // 0..7 共8位
        mapResult.put("加速踏板行程", this.mCanData1 + "%");
        // 8..15 共8位
        mapResult.put("制动踏板行程", this.mCanData2 + "%");
        // 16..17 共2位
        mapResult.put("充放电状态", getChargingStatus(this.mCanData3 & 0x3));
        // 24..31 共8位 DATA*1-1000
        mapResult.put("电池控制器母线电流", (this.mCanData4 & 0xff) * 256 + (this.mCanData5 & 0xff) - 1000);
        // 32..39 共8位
        // mapResult.put("电机控制器母线电流低字节", this.mCanData5 & 0xff);
        // 40..47 共8位
        mapResult.put("最高电压动力电池单体所在电池包序号", this.mCanData6 & 0xff);
        // 48..55 共8位
        mapResult.put("最低电压动力电池单体所在电池包序号", this.mCanData7 & 0xff);
        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8 & 0xff);
        break;
      case 0x308:
        // 0..7 共8位
        mapResult.put("最高温度动力电池包序号", this.mCanData1 & 0xff);
        // 8..15 共8位
        mapResult.put("最低温度动力电池包序号", (this.mCanData2 & 0xff) + "%");
        // 16..23 共8位 DATA*0.1kwh
        mapResult.put("BMS发送剩余能量", StringUtils
            .digit(((this.mCanData3 & 0xff) * 256 + (this.mCanData4 & 0xff)) * 0.1, 2) + "kwh");
        // 24..31 共8位 DATA*0.1kwh
        // mapResult.put("BMS发送剩余能量低字节", LZ.digit((this.mCanData4 & 0xff) *
        // 0.1, 2) + "kwh");
        // 32..39 -- 40..47共8位 DATA*0.1kΩ
        mapResult.put("绝缘电阻",
            StringUtils.digit(((this.mCanData5 & 0xff) * 256 + (this.mCanData6 & 0xff)) * 0.1, 2)
                + "kΩ");
        // 40..47 共8位 DATA*0.1kΩ
        // mapResult.put("绝缘电阻低字节", LZ.digit((this.mCanData6 & 0xff) * 0.1,
        // 2) + "kΩ");
        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8 & 0xff);
        break;
      case 0x309:
        // 0..0 共1位
        mapResult.put("母线欠压", (this.mCanData1 & 0x1) == 0x0 ? "正常" : "故障");
        // 1..1 共1位
        mapResult.put("母线过压", (this.mCanData1 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 2..2 共1位
        mapResult.put("低压欠压", (this.mCanData1 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 3..3 共1位
        mapResult.put("低压过压", (this.mCanData1 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 4..4 共1位
        mapResult.put("母线电流故障", (this.mCanData1 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 5..5 共1位
        mapResult.put("相电流过流", (this.mCanData1 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 6..6 共1位
        mapResult.put("D/Q轴电流超限", (this.mCanData1 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 7..7 共1位
        mapResult.put("三相接地短路", (this.mCanData1 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 8..8 共1位
        mapResult.put("U相输出故障", (this.mCanData2 & 0x1) == 0x0 ? "正常" : "故障");
        // 9..9 共1位
        mapResult.put("V相输出故障", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 10..10 共1位
        mapResult.put("W相输出故障", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 11..11 共1位
        mapResult.put("IGBT故障", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 12..12 共1位
        mapResult.put("IGBT U相过热停机", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 13..13 共1位
        mapResult.put("电机过热停机", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 14..14 共1位
        mapResult.put("驱动板过热停机", (this.mCanData2 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 15..15 共1位
        mapResult.put("散热器过热停机", (this.mCanData2 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 16..16 共1位
        mapResult.put("电机堵转", (this.mCanData3 & 0x1) == 0x0 ? "正常" : "故障");
        // 17..17 共1位
        mapResult.put("电机过速", (this.mCanData3 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 18..18 共1位
        mapResult.put("反电势错误", (this.mCanData3 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 19..19 共1位
        mapResult.put("通讯错误", (this.mCanData3 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 20..20 共1位
        mapResult.put("旋变读故障", (this.mCanData3 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 21..21 共1位
        mapResult.put("旋变信号丢失", (this.mCanData3 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 22..22 共1位
        mapResult.put("高压互锁故障", (this.mCanData3 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 23..23 共1位
        mapResult.put("EEPROM读写异常", (this.mCanData3 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 24..24 共1位
        mapResult.put("电机过热报警", (this.mCanData4 & 0x1) == 0x0 ? "正常" : "故障");
        // 25..25 共1位
        mapResult.put("驱动板过热报警", (this.mCanData4 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 26..26 共1位
        mapResult.put("IGBT过热报警", (this.mCanData4 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 27..27 共1位
        mapResult.put("电机过载报警", (this.mCanData4 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 28..28 共1位
        mapResult.put("电机过转矩报警", (this.mCanData4 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 29..29 共1位
        mapResult.put("U相过温", (this.mCanData4 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 30..30 共1位
        mapResult.put("V相过温", (this.mCanData4 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 31..31 共1位
        mapResult.put("W相过温", (this.mCanData4 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 32..32 共1位
        mapResult.put("板间温度过高", (this.mCanData5 & 0x1) == 0x0 ? "正常" : "故障");
        // 33..33 共1位
        mapResult.put("控制器温度过高", (this.mCanData5 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 34..34 共1位
        mapResult.put("U相过流", (this.mCanData5 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 35..35 共1位
        mapResult.put("V相过流", (this.mCanData5 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 36..36 共1位
        mapResult.put("W相过流", (this.mCanData5 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 37..37 共1位
        mapResult.put("U相电流正半轴故障", (this.mCanData5 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 38..38 共1位
        mapResult.put("U相电流负半轴故障", (this.mCanData5 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 39..39 共1位
        mapResult.put("V相电流正半轴故障", (this.mCanData5 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 40..40 共1位
        mapResult.put("V相电流负半轴故障", (this.mCanData6 & 0x1) == 0x0 ? "正常" : "故障");
        // 41..41 共1位
        mapResult.put("W相电流正半轴故障", (this.mCanData6 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 42..42 共1位
        mapResult.put("W相电流负半轴故障", (this.mCanData6 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 43..43 共1位
        mapResult.put("母线电压故障", (this.mCanData6 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 44..44 共1位
        mapResult.put("IGBT1故障", (this.mCanData6 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 45..45 共1位
        mapResult.put("IGBT2故障", (this.mCanData6 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 46..46 共1位
        mapResult.put("IGBT3故障", (this.mCanData6 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 47..47 共1位
        mapResult.put("IGBT4故障", (this.mCanData6 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 48..48 共1位
        mapResult.put("IGBT5故障", (this.mCanData7 & 0x1) == 0x0 ? "正常" : "故障");
        // 49..49 共1位
        mapResult.put("IGBT6故障", (this.mCanData7 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 50..50 共1位
        mapResult.put("U相温度脱线故障", (this.mCanData7 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 51..51 共1位
        mapResult.put("V相温度脱线故障", (this.mCanData7 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 52..52 共1位
        mapResult.put("W相温度脱线故障", (this.mCanData7 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 53..53 共1位
        mapResult.put("VCU指令异常", (this.mCanData7 >> 5 & 0x1) == 0x0 ? "正常" : "故障");

        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8 & 0xff);
        break;
      case 0x310:
        // 0..0 共1位
        mapResult.put("温度过低", (this.mCanData1 & 0x1) == 0x0 ? "正常" : "故障");
        // 1..1 共1位
        mapResult.put("温度过高", (this.mCanData1 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 2..2 共1位
        mapResult.put("绝缘电阻过低", (this.mCanData1 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 3..3 共1位
        mapResult.put("SOC过低", (this.mCanData1 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 4..4 共1位
        mapResult.put("总压欠压", (this.mCanData1 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 5..5 共1位
        mapResult.put("总压过压", (this.mCanData1 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 6..6 共1位
        mapResult.put("单体欠压", (this.mCanData1 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 7..7 共1位
        mapResult.put("单体过压", (this.mCanData1 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 8..8 共1位
        mapResult.put("温度传感器个数错误", (this.mCanData2 & 0x1) == 0x0 ? "正常" : "故障");
        // 9..9 共1位
        mapResult.put("电池总节数错误", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 10..10 共1位
        mapResult.put("充电预充超时", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 11..11 共1位
        mapResult.put("通讯故障", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 12..12 共1位
        mapResult.put("放电电流过大", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 13..13 共1位
        mapResult.put("充电电流过大", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        // 14..14 共1位
        mapResult.put("系统温差过大", (this.mCanData2 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        // 15..15 共1位
        mapResult.put("压差过大", (this.mCanData2 >> 7 & 0x1) == 0x0 ? "正常" : "故障");

        // 16..16 共1位
        mapResult.put("放电预充超时", (this.mCanData3 & 0x1) == 0x0 ? "正常" : "故障");
        // 17..17 共1位
        mapResult.put("电池包高压互锁故障", (this.mCanData3 >> 1 & 0x1) == 0x0 ? "正常" : "故障");

        // 24..24 共1位
        mapResult.put("制动踏板行程传感器失效", (this.mCanData4 & 0x1) == 0x0 ? "正常" : "故障");
        // 25..25 共1位
        mapResult.put("真空助力压力传感器失效", (this.mCanData4 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        // 26..26 共1位
        mapResult.put("制动踏板开关失效", (this.mCanData4 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        // 27..27 共1位
        mapResult.put("VCU硬件故障", (this.mCanData4 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        // 28..28 共1位
        mapResult.put("VCU通讯故障", (this.mCanData4 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        // 29..29 共1位
        mapResult.put("碰撞信号故障", (this.mCanData4 >> 5 & 0x1) == 0x0 ? "正常" : "故障");

        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8 & 0xff);
        break;
      case 0x360:
        // 0..0 共1位
        mapResult.put("MMS工作状态", (this.mCanData1 & 0x1) == 0x0 ? "ERROR" : "Normal");
        // 4..4 共1位
        mapResult.put("诊断状态", ((this.mCanData1 >> 4) & 0x1) == 0x0 ? "Normal" : "Diagnosis");
        // 7..7 共1位
        mapResult.put("后除霜开关", ((this.mCanData1 >> 7) & 0x1) == 0x0 ? "OFF" : "ON");

        // 8..10 共3位
        mapResult.put("吹风模式", getFanMode(this.mCanData2 & 0x3));
        // 11..11 共1位
        mapResult.put("内外循环模式", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "内循环" : "外循环");
        // 12..12 共1位
        mapResult.put("PTC启停信号", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "OFF" : "ON");
        // 13..14 共1位
        mapResult.put("压缩机启停信号", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "OFF" : "ON");

        // 16..18 共3位
        mapResult.put("风量", getFanSpeed(this.mCanData3 & 0x7));
        break;

      case 0x380:
        // 0..0 共1位
        mapResult.put("仪表工作状态", (this.mCanData1 & 0x1) == 0x0 ? "ERROR" : "Normal");
        // 4..4 共1位
        mapResult.put("诊断模式", ((this.mCanData1 >> 4) & 0x1) == 0x0 ? "OFF" : "ON");
        // 6..6 共1位
        mapResult.put("日行灯关闭", ((this.mCanData1 >> 6 & 0x1) == 0x0 ? "OFF" : "ON"));
        // 7..7 共1位
        mapResult.put("主驾驶安全带状态", ((this.mCanData1 >> 7) & 0x1) == 0x0 ? "未系" : "系");

        // 16..39 共24位
        mapResult.put("仪表总里程",
            (this.mCanData3 & 0xff) * 65536 + (this.mCanData4 & 0xff) * 256 + (this.mCanData5
                & 0xff));

        // 40..41 共2位
        mapResult.put("仪表安全气囊报警灯状态", getAirBagAlarmLampStatus(this.mCanData6 & 0x3));
        // 42..43 共2位
        mapResult.put("乘员安全带状态", getPassengerSeatBeltStatus(this.mCanData2 >> 2 & 0x3));
        break;
      case 0x381:
        // 0..7 共8位
        mapResult.put("车辆里程高字节", this.mCanData1);
        // 8..15 共8位
        mapResult.put("车辆里程中字节", this.mCanData2);
        // 16..23 共8位
        mapResult.put("车辆里程低字节", this.mCanData3);
        // 56..63 共8位
        mapResult.put("循环计数", this.mCanData8);
        break;
      case 0x400:
        // 0..0 共1位
        mapResult.put("BCM工作状态", (this.mCanData1 & 0x1) == 0x0 ? "ERROR" : "Normal");
        // 1..1 共1位
        mapResult.put("诊断模式", ((this.mCanData1 >> 1) & 0x1) == 0x0 ? "OFF" : "ON");
        // 2..2 共1位
        mapResult.put("制动液位报警指示", ((this.mCanData1 >> 2) & 0x1) == 0x0 ? "Normal" : "Fault");
        // 4..4 共1位
        mapResult.put("钥匙提醒", ((this.mCanData1 >> 4) & 0x1) == 0x0 ? "OFF" : "Active");
        // 5..5 共1位
        mapResult.put("左前门开闭状态", ((this.mCanData1 >> 5) & 0x1) == 0x0 ? "门开" : "门关");
        // 6..6 共1位
        mapResult.put("右前门开闭状态", ((this.mCanData1 >> 6) & 0x1) == 0x0 ? "门开" : "门关");
        // 7..7 共1位
        mapResult.put("左后门开闭状态", ((this.mCanData1 >> 7) & 0x1) == 0x0 ? "门开" : "门关");

        // 8..8 共1位
        mapResult.put("右后门开闭状态", (this.mCanData2 & 0x1) == 0x0 ? "门开" : "门关");
        // 9..9 共1位
        mapResult.put("左前门解锁闭锁状态", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "LOCK" : "UNLOCK");
        // 10..10 共1位
        mapResult.put("右前门解锁闭锁状态", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "LOCK" : "UNLOCK");
        // 11..11 共1位
        mapResult.put("左后门解锁闭锁状态", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "LOCK" : "UNLOCK");
        // 12..12 共1位
        mapResult.put("右后门解锁闭锁状态", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "LOCK" : "UNLOCK");
        // 13..13 共1位
        mapResult.put("后背门解锁闭锁状态", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "LOCK" : "UNLOCK");
        // 15..15 共1位
        mapResult.put("后背门开闭状态", (this.mCanData2 >> 7 & 0x1) == 0x0 ? "门开" : "门关");

        // 16..17 共2位
        mapResult.put("大灯状态", getHeadLP(this.mCanData3 & 0x3));
        // 18..18 共1位
        mapResult.put("前雾灯状态", (this.mCanData3 >> 2 & 0x1) == 0x0 ? "OFF" : "ON");
        // 19..19 共1位
        mapResult.put("后雾灯状态", (this.mCanData3 >> 3 & 0x1) == 0x0 ? "OFF" : "ON");
        // 20..20 共1位
        mapResult.put("左转向灯指示", (this.mCanData3 >> 4 & 0x1) == 0x0 ? "OFF" : "Active");
        // 21..21 共1位
        mapResult.put("右转向灯指示", (this.mCanData3 >> 5 & 0x1) == 0x0 ? "OFF" : "Active");
        // 22..22 共1位
        mapResult.put("转向灯失效指示", (this.mCanData3 >> 5 & 0x1) == 0x0 ? "Normal" : "Fail");
        // 23..23 共1位
        mapResult.put("超车灯指示", (this.mCanData3 >> 5 & 0x1) == 0x0 ? "OFF" : "Active");

        // 24..24 共1位
        mapResult.put("危险警报灯指示", (this.mCanData4 & 0x1) == 0x0 ? "OFF" : "Active");
        // 25..25 共1位
        mapResult.put("日间行车灯状态", (this.mCanData4 >> 1 & 0x1) == 0x0 ? "OFF" : "ON");
        // 26..26 共1位
        mapResult.put("机盖开闭状态指示", (this.mCanData4 >> 2 & 0x1) == 0x0 ? "OFF" : "Active");
        // 28..28 共1位
        mapResult.put("钥匙未拔提示", (this.mCanData4 >> 4 & 0x1) == 0x0 ? "OFF" : "Active");
        // 29..31 共3位
        mapResult.put("点火开关位置", getKeyPosition(this.mCanData4 >> 5 & 0x7));

        // 32..55 共24位
        mapResult.put("BCM记录里程", this.mCanData5 << 16 + this.mCanData6 << 8 + this.mCanData7);

        // 56..57 共2位
        mapResult.put("小灯未关提示", (this.mCanData8 & 0x3) == 0x1 ? "OFF" : "Active");
        // 58..58 共1位
        mapResult.put("BCM响应VRT喇叭控制标志位", (this.mCanData8 >> 2 & 0x1) == 0x0 ? "无效" : "Succeed");

        break;

      case 0x410:
        // 0..0 共1位
        mapResult.put("PEPS工作状态", (this.mCanData1 & 0x1) == 0x0 ? "ERROR" : "Normal");
        // 4..4 共1位
        mapResult.put("诊断模式", ((this.mCanData1 >> 4) & 0x1) == 0x0 ? "OFF" : "ON");

        // 8..11 共4位
        mapResult.put("遥控钥匙状态", getPepsRkeLockCmd(this.mCanData2 & 0xF));
        // 12..12 共1位
        mapResult.put("遥控钥匙不在有效区域", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "OFF" : "Active");
        // 13..13 共1位
        mapResult.put("钥匙认证", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "Invalid" : "Confirmation");
        // 14..15 共2位
        mapResult.put("PEPS_BCM报警状态", getPepsBcmAlarm(this.mCanData2 >> 6 & 0x3));

        // 16..18 共3位
        mapResult.put("PEPS_ICU报警状态", getPepsIcuAlarm(this.mCanData3 & 0x7));

        // 24..25 共2位
        mapResult.put("PEPS_ICU指示", getPepsIcuIndication(this.mCanData4 & 0x3));
        // 27..28 共2位
        mapResult.put("点火档控制状态", getPepsPduLevel(this.mCanData4 >> 3 & 0x3));
        // 30.31 共2位
        mapResult.put("钥匙配置", getPepsIdDeviceNo(this.mCanData4 >> 6 & 0x3));

        // 34..34 共1位
        mapResult
            .put("PEPS紧急停机", (this.mCanData5 >> 2 & 0x1) == 0x0 ? "Default" : "Emergency Stop");

        break;

      default:
        break;
    }
    return mapResult;
  }

  @Override
  public Map<String, Object> getErrorInfoMap() {
    Map<String, Object> mapResult = new HashMap<String, Object>();
    switch (this.mCanId) {
      case 0x301:
        // 56 共1位
        if ((this.mCanData8 & 0x1) != 0x0) {
          mapResult.put("电机过温报警", (this.mCanData8 & 0x1) == 0x0 ? "Normal" : "OverTemp");
        }

        // 57..58 共2位
        if (!getMcuFault(this.mCanData8 >> 1 & 0x3).equals("正常")) {
          mapResult.put("电机控制器报警", getMcuFault(this.mCanData8 >> 1 & 0x3));
        }

        break;
      case 0x304:
        // 0..3 共4位
        if (!getVcuFault(this.mCanData1 & 0xF).equals("正常")) {
          mapResult.put("电池管理系统故障", getVcuFault(this.mCanData1 & 0xF));
        }
        // 4..4 共1位
        if (((this.mCanData1 >> 4) & 0x1) != 0x0) {
          mapResult.put("动力电池切断报警", ((this.mCanData1 >> 4) & 0x1) == 0x0 ? "正常" : "断开");
        }
        // 5..5 共1位
        // if (((this.mCanData1 >> 5) & 0x1) != 0x0) {
        // mapResult.put("充电枪连接指示", ((this.mCanData1 >> 5) & 0x1) == 0x0 ?
        // "未连接" : "连接");
        // }

        // 8..8 共1位
        if ((this.mCanData2 & 0x1) != 0x0) {
          mapResult.put("ABS故障报警", (this.mCanData2 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 9..9 共1位
        if ((this.mCanData2 >> 1 & 0x1) != 0x0) {
          mapResult.put("EBD故障报警", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 10..10 共1位
        if ((this.mCanData2 >> 2 & 0x1) != 0x0) {
          mapResult.put("ESC故障报警", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 11..11 共1位
        if ((this.mCanData2 >> 3 & 0x1) != 0x0) {
          mapResult.put("安全气囊故障(预留）", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 12..12 共1位
        if ((this.mCanData2 >> 4 & 0x1) != 0x0) {
          mapResult.put("EPS故障", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 33..33 共1位
        if ((this.mCanData3 >> 1 & 0x1) != 0x0) {
          mapResult.put("EPB故障报警", (this.mCanData3 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 39..39 共1位
        if ((this.mCanData3 >> 6 & 0x1) != 0x0) {
          mapResult.put("EVP故障报警", (this.mCanData3 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }

        break;
      case 0x309:
        // 0..0 共1位
        if ((this.mCanData1 & 0x1) != 0x0) {
          mapResult.put("母线欠压", (this.mCanData1 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 1..1 共1位
        if ((this.mCanData1 >> 1 & 0x1) != 0x0) {
          mapResult.put("母线过压", (this.mCanData1 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 2..2 共1位
        if ((this.mCanData1 >> 2 & 0x1) != 0x0) {
          mapResult.put("低压欠压", (this.mCanData1 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 3..3 共1位
        if ((this.mCanData1 >> 3 & 0x1) != 0x0) {
          mapResult.put("低压过压", (this.mCanData1 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 4..4 共1位
        if ((this.mCanData1 >> 4 & 0x1) != 0x0) {
          mapResult.put("母线电流故障", (this.mCanData1 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 5..5 共1位
        if ((this.mCanData1 >> 5 & 0x1) != 0x0) {
          mapResult.put("相电流过流", (this.mCanData1 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 6..6 共1位
        if ((this.mCanData1 >> 6 & 0x1) != 0x0) {
          mapResult.put("D/Q轴电流超限", (this.mCanData1 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 7..7 共1位
        if ((this.mCanData1 >> 7 & 0x1) != 0x0) {
          mapResult.put("三相接地短路", (this.mCanData1 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 8..8 共1位
        if ((this.mCanData2 & 0x1) != 0x0) {
          mapResult.put("U相输出故障", (this.mCanData2 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 9..9 共1位
        if ((this.mCanData2 >> 1 & 0x1) != 0x0) {
          mapResult.put("V相输出故障", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 10..10 共1位
        if ((this.mCanData2 >> 2 & 0x1) != 0x0) {
          mapResult.put("W相输出故障", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 11..11 共1位
        if ((this.mCanData2 >> 2 & 0x1) != 0x0) {
          mapResult.put("IGBT故障", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 12..12 共1位
        if ((this.mCanData2 >> 4 & 0x1) != 0x0) {
          mapResult.put("IGBT U相过热停机", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 13..13 共1位
        if ((this.mCanData2 >> 5 & 0x1) != 0x0) {
          mapResult.put("电机过热停机", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 14..14 共1位
        if ((this.mCanData2 >> 6 & 0x1) != 0x0) {
          mapResult.put("驱动板过热停机", (this.mCanData2 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 15..15 共1位
        if ((this.mCanData2 >> 7 & 0x1) != 0x0) {
          mapResult.put("散热器过热停机", (this.mCanData2 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 16..16 共1位
        if ((this.mCanData3 & 0x1) != 0x0) {
          mapResult.put("电机堵转", (this.mCanData3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 17..17 共1位
        if ((this.mCanData3 >> 1 & 0x1) != 0x0) {
          mapResult.put("电机过速", (this.mCanData3 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 18..18 共1位
        if ((this.mCanData3 >> 2 & 0x1) != 0x0) {
          mapResult.put("反电势错误", (this.mCanData3 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 19..19 共1位
        if ((this.mCanData3 >> 3 & 0x1) != 0x0) {
          mapResult.put("通讯错误", (this.mCanData3 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 20..20 共1位
        if ((this.mCanData3 >> 4 & 0x1) != 0x0) {
          mapResult.put("旋变读故障", (this.mCanData3 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 21..21 共1位
        if ((this.mCanData3 >> 5 & 0x1) != 0x0) {
          mapResult.put("旋变信号丢失", (this.mCanData3 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 22..22 共1位
        if ((this.mCanData3 >> 6 & 0x1) != 0x0) {
          mapResult.put("高压互锁故障", (this.mCanData3 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 23..23 共1位
        if ((this.mCanData3 >> 7 & 0x1) != 0x0) {
          mapResult.put("EEPROM读写异常", (this.mCanData3 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 24..24 共1位
        if ((this.mCanData4 & 0x1) != 0x0) {
          mapResult.put("电机过热报警", (this.mCanData4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 25..25 共1位
        if ((this.mCanData4 >> 1 & 0x1) != 0x0) {
          mapResult.put("驱动板过热报警", (this.mCanData4 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 26..26 共1位
        if ((this.mCanData4 >> 2 & 0x1) != 0x0) {
          mapResult.put("IGBT过热报警", (this.mCanData4 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 27..27 共1位
        if ((this.mCanData4 >> 3 & 0x1) != 0x0) {
          mapResult.put("电机过载报警", (this.mCanData4 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 28..28 共1位
        if ((this.mCanData4 >> 4 & 0x1) != 0x0) {
          mapResult.put("电机过转矩报警", (this.mCanData4 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 29..29 共1位
        if ((this.mCanData4 >> 5 & 0x1) != 0x0) {
          mapResult.put("U相过温", (this.mCanData4 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 30..30 共1位
        if ((this.mCanData4 >> 6 & 0x1) != 0x0) {
          mapResult.put("V相过温", (this.mCanData4 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 31..31 共1位
        if ((this.mCanData4 >> 7 & 0x1) != 0x0) {
          mapResult.put("W相过温", (this.mCanData4 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 32..32 共1位
        if ((this.mCanData5 & 0x1) != 0x0) {
          mapResult.put("板间温度过高", (this.mCanData5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 33..33 共1位
        if ((this.mCanData5 >> 1 & 0x1) != 0x0) {
          mapResult.put("控制器温度过高", (this.mCanData5 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 34..34 共1位
        if ((this.mCanData5 >> 2 & 0x1) != 0x0) {
          mapResult.put("U相过流", (this.mCanData5 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 35..35 共1位
        if ((this.mCanData5 >> 3 & 0x1) != 0x0) {
          mapResult.put("V相过流", (this.mCanData5 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 36..36 共1位
        if ((this.mCanData5 >> 4 & 0x1) != 0x0) {
          mapResult.put("W相过流", (this.mCanData5 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 37..37 共1位
        if ((this.mCanData5 >> 5 & 0x1) != 0x0) {
          mapResult.put("U相电流正半轴故障", (this.mCanData5 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 38..38 共1位
        if ((this.mCanData5 >> 6 & 0x1) != 0x0) {
          mapResult.put("U相电流负半轴故障", (this.mCanData5 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 39..39 共1位
        if ((this.mCanData5 >> 7 & 0x1) != 0x0) {
          mapResult.put("V相电流正半轴故障", (this.mCanData5 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 40..40 共1位
        if ((this.mCanData6 & 0x1) != 0x0) {
          mapResult.put("V相电流负半轴故障", (this.mCanData6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 41..41 共1位
        if ((this.mCanData6 >> 1 & 0x1) != 0x0) {
          mapResult.put("W相电流正半轴故障", (this.mCanData6 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 42..42 共1位
        if ((this.mCanData6 >> 2 & 0x1) != 0x0) {
          mapResult.put("W相电流负半轴故障", (this.mCanData6 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 43..43 共1位
        if ((this.mCanData6 >> 3 & 0x1) != 0x0) {
          mapResult.put("母线电压故障", (this.mCanData6 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 44..44 共1位
        if ((this.mCanData6 >> 4 & 0x1) != 0x0) {
          mapResult.put("IGBT1故障", (this.mCanData6 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 45..45 共1位
        if ((this.mCanData6 >> 5 & 0x1) != 0x0) {
          mapResult.put("IGBT2故障", (this.mCanData6 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 46..46 共1位
        if ((this.mCanData6 >> 6 & 0x1) != 0x0) {
          mapResult.put("IGBT3故障", (this.mCanData6 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 47..47 共1位
        if ((this.mCanData6 >> 7 & 0x1) != 0x0) {
          mapResult.put("IGBT4故障", (this.mCanData6 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 48..48 共1位
        if ((this.mCanData7 & 0x1) != 0x0) {
          mapResult.put("IGBT5故障", (this.mCanData7 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 49..49 共1位
        if ((this.mCanData7 >> 1 & 0x1) != 0x0) {
          mapResult.put("IGBT6故障", (this.mCanData7 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 50..50 共1位
        if ((this.mCanData7 >> 2 & 0x1) != 0x0) {
          mapResult.put("U相温度脱线故障", (this.mCanData7 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 51..51 共1位
        if ((this.mCanData7 >> 3 & 0x1) != 0x0) {
          mapResult.put("V相温度脱线故障", (this.mCanData7 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 52..52 共1位
        if ((this.mCanData7 >> 4 & 0x1) != 0x0) {
          mapResult.put("W相温度脱线故障", (this.mCanData7 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 53..53 共1位
        if ((this.mCanData7 >> 5 & 0x1) != 0x0) {
          mapResult.put("VCU指令异常", (this.mCanData7 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        break;
      case 0x310:
        // 0..0 共1位
        if ((this.mCanData1 & 0x1) != 0x0) {
          mapResult.put("温度过低", (this.mCanData1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 1..1 共1位
        if ((this.mCanData1 >> 1 & 0x1) != 0x0) {
          mapResult.put("温度过高", (this.mCanData1 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 2..2 共1位
        if ((this.mCanData1 >> 2 & 0x1) != 0x0) {
          mapResult.put("绝缘电阻过低", (this.mCanData1 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 3..3 共1位
        if ((this.mCanData1 >> 3 & 0x1) != 0x0) {
          mapResult.put("SOC过低", (this.mCanData1 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 4..4 共1位
        if ((this.mCanData1 >> 4 & 0x1) != 0x0) {
          mapResult.put("总压欠压", (this.mCanData1 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 5..5 共1位
        if ((this.mCanData1 >> 5 & 0x1) != 0x0) {
          mapResult.put("总压过压", (this.mCanData1 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 6..6 共1位
        if ((this.mCanData1 >> 6 & 0x1) != 0x0) {
          mapResult.put("单体欠压", (this.mCanData1 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 7..7 共1位
        if ((this.mCanData1 >> 7 & 0x1) != 0x0) {
          mapResult.put("单体过压", (this.mCanData1 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 8..8 共1位
        if ((this.mCanData2 & 0x1) != 0x0) {
          mapResult.put("温度传感器个数错误", (this.mCanData2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 9..9 共1位
        if ((this.mCanData2 >> 1 & 0x1) != 0x0) {
          mapResult.put("电池总节数错误", (this.mCanData2 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 10..10 共1位
        if ((this.mCanData2 >> 2 & 0x1) != 0x0) {
          mapResult.put("充电预充超时", (this.mCanData2 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 11..11 共1位
        if ((this.mCanData2 >> 3 & 0x1) != 0x0) {
          mapResult.put("通讯故障", (this.mCanData2 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 12..12 共1位
        if ((this.mCanData2 >> 4 & 0x1) != 0x0) {
          mapResult.put("放电电流过大", (this.mCanData2 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 13..13 共1位
        if ((this.mCanData2 >> 5 & 0x1) != 0x0) {
          mapResult.put("充电电流过大", (this.mCanData2 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 14..14 共1位
        if ((this.mCanData2 >> 6 & 0x1) != 0x0) {
          mapResult.put("系统温差过大", (this.mCanData2 >> 6 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 15..15 共1位
        if ((this.mCanData2 >> 7 & 0x1) != 0x0) {
          mapResult.put("压差过大", (this.mCanData2 >> 7 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 16..16 共1位
        if ((this.mCanData3 & 0x1) != 0x0) {
          mapResult.put("放电预充超时", (this.mCanData3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 17..17 共1位
        if ((this.mCanData3 >> 1 & 0x1) != 0x0) {
          mapResult.put("电池包高压互锁故障", (this.mCanData3 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }

        // 24..24 共1位
        if ((this.mCanData4 & 0x1) != 0x0) {
          mapResult.put("制动踏板行程传感器失效", (this.mCanData4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 25..25 共1位
        if ((this.mCanData4 >> 1 & 0x1) != 0x0) {
          mapResult.put("真空助力压力传感器失效", (this.mCanData4 >> 1 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 26..26 共1位
        if ((this.mCanData4 >> 2 & 0x1) != 0x0) {
          mapResult.put("制动踏板开关失效", (this.mCanData4 >> 2 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 27..27 共1位
        if ((this.mCanData4 >> 3 & 0x1) != 0x0) {
          mapResult.put("VCU硬件故障", (this.mCanData4 >> 3 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 28..28 共1位
        if ((this.mCanData4 >> 4 & 0x1) != 0x0) {
          mapResult.put("VCU通讯故障", (this.mCanData4 >> 4 & 0x1) == 0x0 ? "正常" : "故障");
        }
        // 29..29 共1位
        if ((this.mCanData4 >> 5 & 0x1) != 0x0) {
          mapResult.put("碰撞信号故障", (this.mCanData4 >> 5 & 0x1) == 0x0 ? "正常" : "故障");
        }
        break;
      case 0x410:
        // 14..15 共2位
        // mapResult.put("PEPS_BCM报警状态", getPepsBcmAlarm(this.mCanData2 >> 6
        // & 0x3));

        // 16..18 共3位
        // mapResult.put("PEPS_ICU报警状态", getPepsIcuAlarm(this.mCanData3 &
        // 0x7));

        break;

      default:
        break;
    }
    return mapResult;
  }

  /**
   * 获取系统状态 （仪表指示）
   */
  private static String getSysStatus(int value) {
    if (value == 0x0) {
      return "Normal";
    }
    if (value == 0x1) {
      return "Fault";
    }
    if (value == 0x2) {
      return "Invalid";
    }
    return "";
  }

  /**
   * 获取VCU故障信息
   */
  private static String getVcuFault(int value) {
    if (value == 0x0) {
      return "正常";
    }
    if (value == 0x1) {
      return "一级故障";
    }
    if (value == 0x2) {
      return "二级故障";
    }
    if (value == 0x3) {
      return "三级故障";
    }
    return "";
  }

  /**
   * 获取档位信息状态
   */
  private static String getGearPos(int value) {
    if (value == 0x0) {
      return "无效";
    }
    if (value == 0x1) {
      return "P";
    }
    if (value == 0x2) {
      return "N";
    }
    if (value == 0x3) {
      return "D";
    }
    if (value == 0x4) {
      return "R";
    }
    return "";
  }

  /**
   * 获取制动踏板状态
   */
  private static String getBrakeStatus(int value) {
    if (value == 0x0) {
      return "Active";
    }
    if (value == 0x1) {
      return "Unactive";
    }
    if (value == 0x3) {
      return "Reserved";
    }
    if (value == 0x4) {
      return "Fault";
    }
    return "";
  }

  /**
   * 电机控制器报警
   */
  private static String getMcuFault(int value) {
    if (value == 0x0) {
      return "正常";
    }
    if (value == 0x1) {
      return "一级故障";
    }
    if (value == 0x2) {
      return "二级故障";
    }
    if (value == 0x3) {
      return "三级故障";
    }
    return "";
  }

  /**
   * 获取充电状态
   */
  private static String getChargeIndicate(int value) {
    if (value == 0x0) {
      return "未充电";
    }
    if (value == 0x1) {
      return "直流充电";
    }
    if (value == 0x2) {
      return "交流充电";
    }
    if (value == 0x3) {
      return "充电完成";
    }
    return "";
  }

  /**
   * EPB驻车状态
   */
  private static String getEpbParkingStatus(int value) {
    if (value == 0x0) {
      return "Not Used";
    }
    if (value == 0x1) {
      return "Parking";
    }
    if (value == 0x2) {
      return "Releasing";
    }
    if (value == 0x3) {
      return "Reserved";
    }
    return "";
  }

  /**
   * EPB状态
   */
  private static String getEpbStatus(int value) {
    if (value == 0x0) {
      return "Default";
    }
    if (value == 0x1) {
      return "During Parking";
    }
    if (value == 0x2) {
      return "During Releaseing";
    }
    if (value == 0x3) {
      return "Reserved";
    }
    return "";
  }

  /**
   * 吹风模式
   */
  private static String getFanMode(int value) {
    if (value == 0x0) {
      return "吹面";
    }
    if (value == 0x1) {
      return "吹面吹脚";
    }
    if (value == 0x2) {
      return "吹脚";
    }
    if (value == 0x3) {
      return "吹脚除霜";
    }
    if (value == 0x3) {
      return "除霜";
    }
    return "";
  }

  /**
   * 风量
   */
  private static String getFanSpeed(int value) {
    if (value == 0x0) {
      return "OFF";
    }
    if (value == 0x1) {
      return "1档风量";
    }
    if (value == 0x2) {
      return "2档风量";
    }
    if (value == 0x3) {
      return "3档风量";
    }
    if (value == 0x4) {
      return "4档风量";
    }
    return "";
  }

  private static String getAirBagAlarmLampStatus(int value) {
    if (value == 0x0) {
      return "Normal";
    }
    if (value == 0x1) {
      return "Failure";
    }
    if (value == 0x2) {
      return "Not Used";
    }
    if (value == 0x3) {
      return "Invalid";
    }
    return "";
  }

  private static String getPassengerSeatBeltStatus(int value) {
    if (value == 0x0) {
      return "未配置";
    }
    if (value == 0x1) {
      return "未系";
    }
    if (value == 0x2) {
      return "系";
    }
    return "";
  }

  private static String getHeadLP(int value) {
    if (value == 0x0) {
      return "OFF";
    }
    if (value == 0x1) {
      return "小灯开";
    }
    if (value == 0x2) {
      return "近光灯开（小灯保持）";
    }
    if (value == 0x3) {
      return "远光灯开（小灯保持、近光灯灭）";
    }
    return "";
  }

  private static String getKeyPosition(int value) {
    if (value == 0x0) {
      return "OFF";
    }
    if (value == 0x1) {
      return "ACC";
    }
    if (value == 0x2) {
      return "ON";
    }
    if (value == 0x3) {
      return "Crank+ON";
    }
    return "";
  }

  private static String getPepsRkeLockCmd(int value) {
    if (value == 0x0) {
      return "Default ";
    }
    if (value == 0x1) {
      return "Short Unlock";
    }
    if (value == 0x2) {
      return "Short Lock";
    }
    if (value == 0x3) {
      return "Long Lock（＞2s）";
    }
    if (value == 0x4) {
      return "Trunk Unlock";
    }
    if (value == 0x5) {
      return "Searching Car";
    }
    if (value == 0x6) {
      return "Long Unlock（＞2s）";
    }
    if (value == 0x7) {
      return "保留";
    }
    return "";
  }

  private static String getPepsBcmAlarm(int value) {
    if (value == 0x0) {
      return "Default ";
    }
    if (value == 0x1) {
      return "On Level Lock Alarm";
    }
    if (value == 0x2) {
      return "Key In Lock Alarm";
    }
    if (value == 0x3) {
      return "Key In Lock Trunk";
    }
    if (value == 0x4) {
      return "Trunk Unlock";
    }
    return "";
  }

  private static String getPepsIcuAlarm(int value) {
    if (value == 0x0) {
      return "Default ";
    }
    if (value == 0x1) {
      return "PEPS Failure";
    }
    if (value == 0x2) {
      return "Key Not Found When On Level Door Closed";
    }
    if (value == 0x3) {
      return "Key Not Found Indication On";
    }
    if (value == 0x4) {
      return "Key Battery Low Indication On";
    }
    return "";
  }

  private static String getPepsIcuIndication(int value) {
    if (value == 0x0) {
      return "Default ";
    }
    if (value == 0x1) {
      return "Backup Start Indication";
    }
    if (value == 0x2) {
      return "P/N Gear Position Indication";
    }
    if (value == 0x3) {
      return "Emergency Start";
    }
    return "";
  }

  private static String getPepsPduLevel(int value) {
    if (value == 0x0) {
      return "OFF ";
    }
    if (value == 0x1) {
      return "ACC";
    }
    if (value == 0x2) {
      return "ON";
    }
    return "";
  }

  private static String getPepsIdDeviceNo(int value) {
    if (value == 0x0) {
      return "Default";
    }
    if (value == 0x1) {
      return "Fob One";
    }
    if (value == 0x2) {
      return "Fob Two";
    }
    return "";
  }

  private static String getChargingStatus(int value) {
    if (value == 0x0) {
      return "放电";
    }
    if (value == 0x1) {
      return "充电";
    }
    if (value == 0x2) {
      return "预留";
    }
    if (value == 0x3) {
      return "预留";
    }
    return "";
  }

  @Override
  public Class getClassType() {
    return CanDataTypeI.class;
  }

  @Override
  public int getCanId() {
    return mCanId;
  }

}
