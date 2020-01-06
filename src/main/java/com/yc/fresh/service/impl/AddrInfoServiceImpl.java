package com.yc.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.mapper.AddrInfoMapper;
import com.yc.fresh.service.IAddrInfoService;
import com.yc.fresh.util.StringUtil;

@Service
public class AddrInfoServiceImpl implements IAddrInfoService{
	@Autowired
	private AddrInfoMapper addrInfoMapper;
		
	@Override
	public int add(AddrInfo af) {
		if (StringUtil.checkNull(af.getAno(), af.getProvince(), af.getCity(), af.getArea(), af.getName(), af.getTel())) {
			return -2;
		}
		return addrInfoMapper.add(af);
	}

	@Override
	public List<AddrInfo> finds(Integer mno) {
		return addrInfoMapper.finds(mno);
	}

}
