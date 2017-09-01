package com.ccclubs.protocol.dto.beiqi;

import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/3/16.
 */
public final class BeiQiConfig {

  public final static String BASE_ENDPOINT = "http://106.14.64.61:8080/helloworld/order/";

  private final static String SING_PUBLIC_KEY = "bjev2016";
  // "8655BC8BCC8F25695592F490D7EE3EC7";
  public final static String SING_PUBLIC_KEY_MD5 = StringUtils.md5(SING_PUBLIC_KEY);

  public final static String BJEV = "bjev";

  public class Action {

    /**
     * 预定车辆接口
     */
    public static final String ACTION_BOOK_ORDER = "sendBookOrder";
    /**
     * 预定车辆接口
     */
    public static final String ACTION_CANCEL_ORDER = "cancelOrder";
    /**
     * 车辆双闪接口
     */
    public static final String ACTION_DOUBLE_FLASH = "doubleFlash";
    /**
     * 双闪和鸣笛接口
     */
    public static final String ACTION_DOUBLE_FLASH_AND_WHISTLED = "doubleFlashAndWhistled";
    /**
     * 解锁车门接口
     */
    public static final String ACTION_OPEN_DOOR = "openDoor";
    /**
     * 锁定车门接口
     */
    public static final String ACTION_LOCK_DOOR = "lockDoor";
    /**
     * 断电接口
     */
    public static final String ACTION_OUT_ELECTRIC = "outElectric";
    /**
     * 供电接口
     */
    public static final String ACTION_SUPPLY_ELECTRIC = "supplyElectric";
    /**
     * 获取设备位置和车辆状态信息接口
     */
    public static final String ACTION_GET_FINAL_LOCATION_INFO = "getFinalLocationInfo";
    /**
     * 终端上报位置和车辆状态信息接口
     */
//    private static String ACTION_UPLOAD_STATUS_INFO = "uploadStatusInfo";

  }

}
