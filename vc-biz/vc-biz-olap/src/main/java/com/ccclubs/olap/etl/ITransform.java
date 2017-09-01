package com.ccclubs.olap.etl;

//转换接口
public interface ITransform<T,R> {
    public R doTransform(T input);
}
