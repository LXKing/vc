package com.ccclubs.terminal.constant;

/**
 * 升级状态
 * -1:无效 0:待升级 1:升级中 2:已升级 3:升级失败
 * @author jianghaiyang
 * @create 2018-07-25
 **/
public enum UpgradeStatus {

    INVALID((byte) -1, "无效"),
    TOUPGRADE((byte) 0, "待升级"),
    UPGRADING((byte) 1, "升级中"),
    UPGRADED((byte) 2, "已升级"),
    FAILED((byte) 3, "升级失败");

    private Byte value;
    private String name;

    UpgradeStatus(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UpgradeStatus getStatus(Byte v) {
        UpgradeStatus status = null;
        switch (v) {
            case -1:
                status = UpgradeStatus.INVALID;
                break;
            case 0:
                status = UpgradeStatus.TOUPGRADE;
                break;
            case 1:
                status = UpgradeStatus.UPGRADING;
                break;
            case 2:
                status = UpgradeStatus.UPGRADED;
                break;
            case 3:
                status = UpgradeStatus.FAILED;
                break;
        }
        return status;
    }
}
