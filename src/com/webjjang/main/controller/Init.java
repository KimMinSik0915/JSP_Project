package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.service.MemberListService;
import com.webjjang.member.service.MemberLoginService;

/**
 * Servlet implementation class init
 */
@WebServlet(value = "/Init", loadOnStartup = 1)
public class Init extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("JSP Project2에서의 실행 ----------------------------");
		
		System.out.println("서버가 실행을 시작할 때 실행되는 처리--------------------------------------");
		
		// 객체를 생성후 저장 ================================= 게시판 ============================================
		// dao 생성 저장
		Beans.putDAO("boardDAO", new BoardDAO());
		
		// service 생성 후 저장
		Beans.put("/board/list.jsp", new BoardListService());
		Beans.put("/board/view.jsp", new BoardViewService());
		
		// service에 dao 넣기
		Beans.get("/board/list.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board/view.jsp").setDAO(Beans.getDAO("boardDAO"));
		
		// 생성 및 저장이 잘 되어 있는지 확인
		System.out.println(Beans.get("/board/list.jsp"));
		System.out.println(Beans.getDAO("boardDAO"));
		
		// 게시판 ============================================
		// dao 생성 저장
		Beans.putDAO("memberDAO", new MemberDAO());
		
		// service 생성 후 저장
		Beans.put("/member/login.jsp", new MemberLoginService());
		Beans.put("/member/list.jsp", new MemberListService());
		
//		System.out.println(Beans.get("/member/list.jsp"));

		// service에 DAO 넣기
		Beans.get("/member/login.jsp").setDAO(Beans.getDAO("memberDAO"));
		Beans.get("/member/list.jsp").setDAO(Beans.getDAO("memberDAO"));
		
		
		// Oracle Driver와 필요한 method 로딩 
		try {
			
			// class 안에 있는 static부분이 로딩 되고  static{}이 실행된다.
			Class.forName("com.webjjang.util.db.DBInfo");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			throw new ServletException("드라이버 확인하는 처리중 오류가 발생하였습니다.");
			
		}
		
	}

}
