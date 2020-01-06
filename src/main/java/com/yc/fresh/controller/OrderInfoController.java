package com.yc.fresh.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.fresh.entity.MemberInfo;
import com.yc.fresh.entity.OrderInfo;
import com.yc.fresh.service.IOrderInfoService;

@RestController
@RequestMapping("/order")
public class OrderInfoController {
	@Autowired
	private IOrderInfoService orderInfoService;

	@RequestMapping("/getOrder")
	public List<Map<String, Object>> getOrder(HttpSession session) {
		Object obj = session.getAttribute("currentOrder");
		if (obj == null) {
			return Collections.emptyList();
		}
		return orderInfoService.getOrder(String.valueOf(obj));
	}
	
	@RequestMapping("/order")
	public int order(String cnos, HttpSession session) {
		Object obj = session.getAttribute("currenrLoginUser");
		if (obj == null) {
			return -1;
		}
		MemberInfo mf= (MemberInfo) obj;
		String ono = new Date().getTime() + "" + new Random().nextInt(10000);
		session.setAttribute("currentOrder", ono);
		return orderInfoService.order(cnos, ono, mf.getMno());
	}
	
	@RequestMapping("/history")
	public List<OrderInfo> history(HttpSession session) { // 我偷懒，不做分页
		Object obj = session.getAttribute("currenrLoginUser");
		if (obj == null) {
			return Collections.emptyList();
		}
		MemberInfo mf= (MemberInfo) obj;
		return orderInfoService.getHistory(mf.getMno());
	}
	
	@RequestMapping("/pay")
	public int pay(HttpSession session, String ono) {
		Object obj = session.getAttribute("currenrLoginUser");
		if (obj == null) {
			return -1;
		}
		session.setAttribute("currentOrder", ono);
		return 1;
	}
	
	@RequestMapping("/toorder")
	public int toOrder(String ano, Double price, HttpSession session, String inos) {
		Object obj = session.getAttribute("currentOrder");
		if (obj == null) {
			return -1;
		}
		String ono = String.valueOf(obj);
		return orderInfoService.toOrder(ano, price, ono, inos);
	}
}
