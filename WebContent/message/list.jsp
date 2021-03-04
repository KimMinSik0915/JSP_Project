<%@page import="com.webjjang.message.vo.MessageVO"%>
<%@page import="com.webjjang.util.PageObject"%>
<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

// long curPage = 1;

// String strCurPage = request.getParameter("page");

// if(strCurPage != null) {
	
// 	curPage = Long.parseLong(strCurPage);
	
// }

// long perPageNum = 10;

// String strPerPageNum = request.getParameter("perPageNum");

// if(strPerPageNum != null) {
	
// 	perPageNum = Long.parseLong(strPerPageNum);
	
// }

// PageObject pageObject = new PageObject();

// pageObject.setPage(curPage);
// pageObject.setPerPageNum(perPageNum);

List<MessageVO> list = (List<MessageVO>) ExeService.execute(Beans.get(AuthorityFilter.url), null);

request.setAttribute("list", list);
// request.setAttribute("pageObject", pageObject);

%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 리스트</title>
</head>
<body>
 <div class="container">
  <h1>메시지 리스트</h1>
  <table class="table">
   <tr>
    <th>번호</th>
    <th>보낸 사람</th>
    <th>보낸 날짜</th>
    <th>받는 사람</th>
    <th>받은 날짜</th>
   </tr>
   
   <c:forEach items="${list }" var="vo" >
    <tr>
     <td>${vo.no }</td>
     <td>${vo.sender }</td>
     <td>${vo.sendDate }</td>
     <td>${vo.accepter }</td>
     <td>${vo.acceptDate }</td>
    </tr>
   </c:forEach>
   
  </table>
 </div>
</body>
</html>