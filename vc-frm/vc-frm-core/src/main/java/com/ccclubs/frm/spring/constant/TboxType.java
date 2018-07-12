package com.ccclubs.frm.spring.constant;

/**
 * 终端类型:0:车厘子,1:中导,2:慧翰,3:通领;
 * @author jianghaiyang
 * @create 2018-07-04
 **/
public enum TboxType {

    CLZ((byte) 0, "车厘子"),
    ZD((byte) 1, "中导"),
    HH((byte) 2, "慧翰"),
    TL((byte) 3, "通领");

    private Byte value;
    private String name;

    TboxType(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static TboxType getSource(Byte v) {
        TboxType type = null;
        switch (v) {
            case 1:
                type = TboxType.CLZ;
                break;
            case 2:
                type = TboxType.ZD;
                break;
            case 3:
                type = TboxType.HH;
                break;
            case 4:
                type = TboxType.TL;
                break;
        }
        return type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the value
     */
    public Byte getValue() {
        return value;
    }
}
