<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// 0. 한글 처리
request.setCharacterEncoding("UTF-8");

// 1. 넘어오는 데이터 수집
String strNo = request.getParameter("no");

long no = Long.parseLong(strNo);

String title = request.getParameter("title");

String content = request.getParameter("content");

String writer = request.getParameter("writer");

// 넘어온 데이터 세팅 ---------------------------------

BoardVO vo = new BoardVO();

vo.setNo(no);
vo.setTitle(title);
vo.setContent(content); 
vo.setWriter(writer);

// DB에 저장하는 쿼리 : update.jsp -> service -> dao
String url = request.getServletPath();
int result = (Integer) ExeService.execute(Beans.get(url), vo);


// 3. view로 이동
response.sendRedirect("view.jsp?no=" + no + "&inc=0");

%>

<%= vo %>