package com.ccclubs.olap.protocol.protocolmodel.evnet;



import com.ccclubs.olap.protocol.protocolmodel.IMessageBody;
import com.ccclubs.olap.protocol.protocolmodel.gb.EVcan_GB;
import com.ccclubs.olap.protocol.util.FastJsonUtil;
import com.ccclubs.olap.protocol.util.MyBuffer;

import java.util.ArrayList;
import java.util.List;

/**
 * CAN 包数据
 */
public class EV_09_can implements IMessageBody {

    //车型号（1 byte,）
    private  byte carType;
    //车机时间（4 byte）
    private int time;
    //包类型（1byte ：01:CAN bus(ID:11 bit)，02:CAN bus(ID:29 bit)）
    private byte canType;
    //包的个数（1byte）
    private byte cancount;
    //
    private List<EV_09_can_item> canList;

    public byte getCarType() {
        return carType;
    }

    public void setCarType(byte carType) {
        this.carType = carType;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public byte getCanType() {
        return canType;
    }

    public void setCanType(byte canType) {
        this.canType = canType;
    }

    public byte getCancount() {
        return cancount;
    }

    public void setCancount(byte cancount) {
        this.cancount = cancount;
    }

    public List<EV_09_can_item> getCanList() {
        return canList;
    }

    public void setCanList(List<EV_09_can_item> canList) {
        this.canList = canList;
    }

    @Override
    public byte[] WriteToBytes() {

        MyBuffer buff = new MyBuffer();

        buff.put(getCarType());
        buff.put(getTime());    //呆改

        buff.put(getCanType());
        buff.put(getCancount());

        if (getCancount() > 0) {
            for (EV_09_can_item item : canList) {
                if (item != null && item.getCanId() > 0) {
                    buff.put(item.WriteToBytes());
                }
            }
        }
        return buff.array();

    }

    @Override
    public void ReadFromBytes(byte[] bytes) {

        MyBuffer buff = new MyBuffer(bytes);
        setCarType(buff.get());
        setTime(buff.getInt());//呆改
        setCanType(buff.get());
        setCancount(buff.get());
        this.canList =new ArrayList<EV_09_can_item>();
        //
        int dataLength=8;
        switch (getCanType()){
            case 0x01:
                dataLength = 3 +dataLength;
                break;
            case 0x02:
                dataLength = 5 +dataLength;
                break;
        }
        for (int m = 0; m < getCancount(); m++) {
            EV_09_can_item jt = new EV_09_can_item();
            jt.setCanType(getCanType());
            jt.ReadFromBytes(buff.gets(dataLength));
            this.canList.add(jt);

        }
        //调用Util下的包

    }

    /**
     * 包数据转换给GB格式数据
     * @return
     */

    public String getGBFromCanData(byte[] bytes ) {

        byte funCode=bytes[16]; //包功能码69
        if(funCode==0x69){

            byte cantype=bytes[22];//包类型
            byte canNum=bytes[23];//包数量

           if(canNum>=3) {//获取到的包的数量

               int len=1;
               switch (cantype){
                   case 0x01:
                       len=canNum*11;
                       break;
                   case 0x02:
                       len=canNum*13;
                       break;
               }
               //
               if(len==bytes.length-24){
                   byte[]  destBytes=new byte[bytes.length-17];
                   //去除包数据开头的部分
                   System.arraycopy(bytes,17,destBytes,0,bytes.length-17);
                   ReadFromBytes(destBytes);
                   //
                   String jsonString = EVcan_GB.getCan_gb(this.canList);
                   return jsonString;

               }
           }
            return null;
        }else{
            return null;
        }
    }

    public static  void main(String[] args ){
//
//        String str="54363655303536310000000000000000690520E65146010C03000802000400000000930301087D0000C8003232000302080E5917706410653803030810531B4B074B0305030408130000000500000003050811105D105A105D9303060800000000000000930307080000010000010193030808010100F50441009303090800000000000000930310080000000000000094040008E181000400012F00";
//            String strww="54363339303836330000000000000000690520E91B4D010D003008010000000000002C03000802000300000000B20301087D0000C8003232000302080E38175C6010362B0303081029424E064D0305030408B0000116050000000305081710301030102CB203060800000000000000B203070800000100000101B2030808010100EB042300B103090800000000000000B203100800000000000000B3040008E1810004001B1C00";
            //
//            String strCanNumError="54363339303836330000000000000000690520E91B4D0101003008010000000000002C03000802000300000000B20301087D0000C8003232000302080E38175C6010362B0303081029424E064D0305030408B0000116050000000305081710301030102CB203060800000000000000B203070800000100000101B2030808010100EB042300B103090800000000000000B203100800000000000000B3040008E1810004001B1C00";

        String strTest="474230303336363800000000000000006051ffb02e1010c03000802000300000000000301087d0000c8003232000302080e361753611035050303081026563705360300030408a1000111050000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        String out= FastJsonUtil.getCanToGb( strTest   );
        System.out.println(out);
//
//        byte[] byte1={[0x01,0x02};{0x01,0x02}};
//        System.out.println(byte1.length);
    }
}
