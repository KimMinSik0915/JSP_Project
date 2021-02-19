<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 여기가 java 코드 입니다. JSP - Service - DAO -> /board/view.jsp
String url = request.getServletPath();

// 넘어오는 data 받기 : 글번호
String strNo = request.getParameter("no");

long no = Long.parseLong(strNo);

@SuppressWarnings("unchecked")
BoardVO vo = (BoardVO)ExeService.execute(Beans.get(url), no);

request.setAttribute("vo", vo);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 보기</title>
<!-- 부트스트랩 라이브러리 등록(CDN방식) -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <script type="text/javascript">
   // 객체 선택에 문제가 있다. 아래 document가 로딩이 되면 실행되는 스크립트 작성
   // jQuery에서 사용하는 $(function(){처리문;}) = jquery(function(){처리문;})
   $(function () {		// jQuery에서 익명함수를 전달해서 저장해 놓았다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	   
   });
  </script>
  
</head>
<body>

<div class="container">
 <h1>게시판 글 보기</h1>
 <table class="table">
  
 <tbody>
  <!-- 데이터가 있는 만큼 반복이 되어지는 부분(시작) -->
   <tr class="dataRow">
    <th>글 번호</th>
    <td class="no">${vo.no }</td>
   </tr>
   
    <td>${vo.title }</td>
    <td>${vo.writer }</td>
    <td>${vo.writeDate }</td>
    <td>${vo.hit }</td>
   </tr>
  <!-- 데이터가 있는 만큼 반복이 되어지는 부분(끝) -->
 </tbody>
  
  <tfoot>
   <tr>
    <td colspan="5">
     <a href="writeForm.jsp" class="btn btn-default">글 쓰기</a>
    </td>
   </tr>
  </tfoot>
 </table>
</div>
</body>
</html>