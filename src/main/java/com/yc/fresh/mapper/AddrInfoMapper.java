package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entity.AddrInfo;

public interface AddrInfoMapper {

	public int add(AddrInfo af);

	public List<AddrInfo> finds(Integer mno);
}
