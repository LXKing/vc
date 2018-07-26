package com.ccclubs.upgrade.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/24
 * @Time: 14:46
 * Email:  yeanzhi@ccclubs.com
 * 特定的升级车型类型
 */
public enum VehicleModelType {

    // 长安逸动15款
    CHANGAN_YD_15(12),
    // 长安移动精英款
    CHANGAN_YD_JY(26),
    // 长安逸动豪华款
    CHANGAN_YD_HH(27),
    // 长安奔奔汽油车
    CHANGAN_BENBEN(28);

    private int code;
    VehicleModelType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VehicleModelType getByCode(int code) {
        for (VehicleModelType t : VehicleModelType.values()) {
            if (t.getCode() == code) {
                return t;
            }
        }
        return null;
    }
}
