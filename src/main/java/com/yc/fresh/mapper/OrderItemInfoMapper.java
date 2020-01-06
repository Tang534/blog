package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

public interface OrderItemInfoMapper {
	/**
	 * 添加订单详细的方法
	 * @param gf
	 * @return
	 */
	public int add(Map<String, Object> map);

	/**
	 * 根据订单编号，查询订单详细
	 * @param ono
	 * @return
	 */
	public List<Map<String, Object>> getOrder(String ono);

}
