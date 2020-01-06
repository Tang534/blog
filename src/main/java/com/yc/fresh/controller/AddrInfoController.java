package com.yc.fresh.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.entity.MemberInfo;
import com.yc.fresh.service.IAddrInfoService;

@RestController
@RequestMapping("/addr")
public class AddrInfoController {
	@Autowired
	private IAddrInfoService addrInfoService;
	
	@RequestMapping("/add")
	public int add(AddrInfo af, HttpSession session) {
		Object obj = session.getAttribute("currenrLoginUser");
		if (obj == null) {
			return -2;
		}
		MemberInfo mf = (MemberInfo) obj;
		af.setMno(mf.getMno());
		return addrInfoService.add(af);
	}
	
	
	@RequestMapping("/finds")
	public List<AddrInfo> finds(HttpSession session) {
		Object obj = session.getAttribute("currenrLoginUser");
		if (obj == null) {
			return Collections.emptyList();
		}
		MemberInfo mf = (MemberInfo) obj;
		return addrInfoService.finds(mf.getMno());
	}
}
