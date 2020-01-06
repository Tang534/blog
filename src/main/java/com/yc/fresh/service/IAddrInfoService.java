package com.yc.fresh.service;

import java.util.List;

import com.yc.fresh.entity.AddrInfo;

public interface IAddrInfoService {
	public int add(AddrInfo af);
	
	public List<AddrInfo> finds(Integer mno);
}
