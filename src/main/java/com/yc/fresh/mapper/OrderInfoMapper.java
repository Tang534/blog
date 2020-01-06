package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.OrderInfo;

public interface OrderInfoMapper {
	/**
	 * 添加订单的方法
	 * @param gf
	 * @return
	 */
	public int add(Map<String, Object> map);

	/**
	 * 根据会员编号，查询历史订单
	 * @param mno
	 * @return
	 */
	public List<OrderInfo> getHistory(int mno);

	/**
	 * 更新订单的方法 总价、收货地址
	 * @param map 
	 * @return
	 */
	public int update(Map<String, Object> map);

	/**
	 * 更新库存的方法
	 * @param ono
	 * @return
	 */
	public int updateStore(String[] inos);
}
