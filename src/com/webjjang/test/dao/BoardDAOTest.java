package com.webjjang.test.dao;

import com.webjjang.board.dao.BoardDAO;

public class BoardDAOTest {

	public static void main(String[] args) throws Exception {

		// BoardDAO 테스팅
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		System.out.println(dao.write(null));	// boardDAO 테스트
		
	}

}
