package com.ccclubs.protocol.inf;

public interface IFurtherCar {
	/**
	 * 获得车牌号
	 * 
	 * @return
	 */
	public String getCarNum();

	/**
	 * 类型
	 * 
	 * @return
	 */
	public byte getFucCode();

	/**
	 * 获得当前订单号
	 * 
	 * @return
	 */
	public long getOrderId();

	/**
	 * 获得当前车辆里程
	 * 
	 * @return
	 */
	public int getMiles();

	/**
	 * 获得当前车辆油里程
	 * 
	 * @return
	 */
	public int getFurtherTime();
}
