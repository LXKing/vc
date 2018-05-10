package com.ccclubs.gateway.gb.inf;

/**
 * @Author: yeanzi
 * @Date: 2018/3/30
 * @Time: 10:18
 * Email:  yeanzhi@ccclubs.com
 * 状态枚举：
 *      所有跟状态相关的（提供一个状态code）的Enum应该实现该接口
 *      方便反射调用
 */
public interface ICodedStatus {
    int getCode();
}
