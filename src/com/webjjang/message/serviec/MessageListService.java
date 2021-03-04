package com.webjjang.message.serviec;

import com.webjjang.main.controller.Service;
import com.webjjang.message.dao.MessageDAO;

public class MessageListService implements Service{

	private MessageDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.list();
		
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		
		this.dao = (MessageDAO) dao;
		
	}

}
