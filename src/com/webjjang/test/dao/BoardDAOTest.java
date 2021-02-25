package com.webjjang.test.dao;


import java.util.List;

import com.webjjang.main.controller.ExeService;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.service.MemberListService;
import com.webjjang.member.vo.MemberVO;
import com.webjjang.util.db.DBSQL;

public class BoardDAOTest {

	public static void main(String[] args) throws Exception {

		// BoardDAO 테스팅
		// BoardDAO 객체 생성
//		BoardDAO dao = new BoardDAO();
		
//		System.out.println(dao.list());	// boardDAO 테스트
//		
//		List<BoardVO> list = (List<BoardVO>) ExeService.execute(new BoardListService(), null);
		
		System.out.println(DBSQL.MEMBER1_LIST);
		
//		MemberDAO dao = new MemberDAO();
//		
//		System.out.println(dao.list());
//		
	}

}
