<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// 0. 한글 처리
System.out.println("EncodingFilter에서 한글처리 : " + request.getCharacterEncoding());

// 1. 넘어오는 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");

BoardVO vo = new BoardVO();

vo.setTitle(title);
vo.setContent(content); 
vo.setWriter(writer);

// DB에 저장하는 쿼리 : write.jsp -> service -> dao
String url = request.getServletPath();
int result = (Integer) ExeService.execute(Beans.get(url), vo);


// 3. list로 이동
response.sendRedirect("list.jsp");

%>