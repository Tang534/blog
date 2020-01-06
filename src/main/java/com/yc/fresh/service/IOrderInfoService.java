package com.yc.fresh.service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.OrderInfo;

public interface IOrderInfoService {
	/**
	 * 下单
	 * @param cnos
	 * @return
	 */
	public int order(String cnos, String ono, Integer mno);

	public List<OrderInfo> getHistory(int mno);
	
	public List<Map<String, Object>> getOrder(String ono);

	/**
	 * 下单支付操作
	 * @param ano 收货地址
	 * @param price 总价
	 * @param ono 订单编号
	 * @return
	 */
	public int toOrder(String ano, Double price, String ono, String inos);
}
