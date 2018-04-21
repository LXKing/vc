package com.ccclubs.protocol.util;

/**
 * 利用Java位运算符，完成Unsigned转换
 * @author qsxiaogang
 * @create 2018-04-19
 **/
public class UnsignedUtil {

  /**
   * java byte (1 byte == 8 bit) (-2^7~2^7-1 : -128~127) to unsigned short(0~2^8-1 : 0~255)
   */
  public static int getUnsignedByte(byte data) {
    return data & 0x0FF;
  }

  /**
   * java short (1 short == 2 byte == 16 bit) (-2^15~2^15-1 : -32768~32767) to unsigned
   * short(0~2^16-1 : 0~65535)
   */
  public static int getUnsignedShort(short data) {
    return data & 0x0FFFF;
  }

  /**
   * java int (1 int == 4 byte == 32 bit)(-2^31~2^31-1 : -2147483648~2147483647) to unsigned
   * short(0~2^32-1 : 0~4294967295)
   */
  public static long getUnsignedInt(int data) {
    return data & 0x0FFFFFFFF;
  }

}
