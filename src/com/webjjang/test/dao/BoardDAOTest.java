package com.webjjang.test.dao;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.util.db.DBSQL;

public class BoardDAOTest {

	public static void main(String[] args) throws Exception {

		// BoardDAO 테스팅
		// BoardDAO 객체 생성
//		BoardDAO dao = new BoardDAO();
		
		MemberDAO dao = new MemberDAO();
		
		System.out.println(dao.view("test"));
		
//		System.out.println(dao.list());	// boardDAO 테스트
//		
//		List<BoardVO> list = (List<BoardVO>) ExeService.execute(new BoardListService(), null);
		
		System.out.println(DBSQL.MEMBER_VIEW);
		
//		MemberDAO dao = new MemberDAO();
//		
//		System.out.println(dao.list());
//		
	}

}
