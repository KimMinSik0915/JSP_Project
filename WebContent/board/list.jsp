<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 여기가 java 코드 입니다. JSP - Service - DAO
String url = request.getServletPath();

@SuppressWarnings("unchecked")
List<BoardVO> list = (List<BoardVO>)ExeService.execute(Beans.get(url), null);

request.setAttribute("list", list);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>

 <h1>게시판 리스트</h1>
 ${list } 
 
</body>
</html>