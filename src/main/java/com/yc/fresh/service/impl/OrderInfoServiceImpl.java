package com.yc.fresh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.fresh.entity.OrderInfo;
import com.yc.fresh.mapper.CartInfoMapper;
import com.yc.fresh.mapper.OrderInfoMapper;
import com.yc.fresh.mapper.OrderItemInfoMapper;
import com.yc.fresh.service.IOrderInfoService;
import com.yc.fresh.util.StringUtil;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService{
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Autowired
	private OrderItemInfoMapper orderItemInfoMapper;
	
	@Autowired
	private CartInfoMapper cartInfoMapper;
	
	@Transactional
	@Override
	public int order(String cnos, String ono, Integer mno) {
		if (StringUtil.checkNull(cnos)) {
			return -1;
		}
		
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ono", ono);
		param.put("mno", mno);
		result = orderInfoMapper.add(param); // 添加订单
		
		// 添加订单详细
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ono", ono);
		map.put("cnos", cnos.split(";"));
		result = orderItemInfoMapper.add(map);
		
		// 删除购物车
		result = cartInfoMapper.dels(cnos.split(";"));
		return result;
	}

	@Override
	public List<OrderInfo> getHistory(int mno) {
		return orderInfoMapper.getHistory(mno);
	}
	
	@Override
	public List<Map<String, Object>> getOrder(String ono) {
		return orderItemInfoMapper.getOrder(ono);
	}

	@Transactional
	@Override
	public int toOrder(String ano, Double price, String ono, String inos) {
		if (StringUtil.checkNull(ano, ono)) {
			return -1;
		}
		
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ono", ono);
		map.put("price", price);
		map.put("ano", ano);
		result = orderInfoMapper.update(map); // 更新订单信息
		result = orderInfoMapper.updateStore(inos.split(",")); // 根据订单编号修改商品的库存信息
		return result;
	}

}
