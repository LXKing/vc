package com.ccclubs.upgrade.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/23
 * @Time: 14:27
 * Email:  yeanzhi@ccclubs.com
 */
public enum TerminalType {
    /*车厘子*/
    CCCLUB,
    /*中导*/
    ZD,
    /*慧翰*/
    HH,
    /*通领*/
    TL;

    public static TerminalType getByOrdinal(int ordinal) {
        for (TerminalType t :
                TerminalType.values()) {
            if (t.ordinal() == ordinal) {
                return t;
            }
        }
        return null;
    }
}
