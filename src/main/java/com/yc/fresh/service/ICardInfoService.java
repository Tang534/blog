package com.yc.fresh.service;

import java.util.List;

import com.yc.fresh.entity.CartInfo;

public interface ICardInfoService {
	public List<CartInfo> findByMno(int mno);

	public String add(CartInfo cf);

	public int update(String cno, int num);

	public List<CartInfo> finds(int mno);

	public int del(String cno);
	
	/**
	 * 同时删除多个的方法
	 * @param cnos
	 * @return
	 */
	public int dels(String[] cnos);
}
