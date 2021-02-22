<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
// 자바 부분 입니다.
// 0. 한글처리
request.setCharacterEncoding("UTF-8");

// 1. 넘어오는 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");

BoardVO vo = new BoardVO();

vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

// 2. DB에 저장하는 처리 : write.jsp로 
String url = request.getServletPath();
Integer result = (Integer)ExeService.execute(Beans.get(url), vo);


// 3. list로 자동 이동
response.sendRedirect("list.jsp");

%>
