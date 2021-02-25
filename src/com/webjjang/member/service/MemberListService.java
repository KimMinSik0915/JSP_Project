package com.webjjang.member.service;

import com.webjjang.main.controller.Service;
import com.webjjang.member.dao.MemberDAO;

public class MemberListService implements Service {
	
	MemberDAO dao;

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.list();
		
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub

		this.dao = (MemberDAO) dao;
		
	}

}
