<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 여기가 자바 부분 입니다.
// 1. 넘어오는 데이터 받기 - 글 번호
String strNo = request.getParameter("no");

long no = Long.parseLong(strNo);

// 조회수 1 증가하는 부분은 inc = 0으로 강제 세팅해서 넘겨준다.

// 2. 글 번호에 맞는 데이터 가져오기 : BoardViewService -? /board/view.jsp
String url = "/board/view.jsp"; // 현재 URL과 다르므로 강제로 세팅

BoardVO vo = (BoardVO)ExeService.execute(Beans.get(url), new Long[] { no, 0L });
		
		
// 3. 서버 객체에 넣기
request.setAttribute("vo", vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../js/formUtil.js"></script>
  <script type="text/javascript">
   // 객체 선택에 문제가 있다. 아래 document가 로딩이 되면 실행되는 스크립트 작성
   // jQuery에서 사용하는 $(function(){처리문;}) = jquery(function(){처리문;})
   $(function () {		// jQuery에서 익명함수를 전달해서 저장해 놓았다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	   //이벤트 처리
	   // 취소버튼 --> 이전 페이지(리스트)로 이동
	   $("#cancelBtn").click(function () {
		//alert("취소버튼을 눌렀습니다.");
		//이전 페이지로 이동
		history.back();
	   });
	   
	   // submit() 이벤트에 데이터 검사
	   $("#writeForm").submit(function () { 
// 			alert("이벤트가 발생하였습니다.");
			
			// 필수 입력
			//alert((!require($("#title"), "제목"))); 
			if(!require($("#title"), "제목")) return false;
			
			if(!require($("#content"), "내용")) return false;
			
			if(!require($("#writer"), "작성자")) return false;
				
			// 길이
			// 제목 : 4자 이상
			if(!checkLength($("#title"), "제목", 4)) return false;
			
			// 내용 : 4자 이상
			if(!checkLength($("#content"), "내용", 4)) return false;
			
			// 작성자 : 2자 이상
			if(!checkLength($("#writer"), "작성자", 2)) return false;
			
	   });
	   
   });
   
  </script>
</head>
<body>

 <div class="container">
  <h1>글 수정</h1>
  <form action="update.jsp" method="post" id="writeForm">
  
   <div class="form-group">
    <label for="no">번호</label>
    <input class="form-control" id="no" name="no" readonly="readonly" value="${vo.no }">
   </div>
   
   <div class="form-group">
    <label for="title">제목</label>
    <input class="form-control" id="title" name="title" required="required" value="${vo.title }">
   </div>
   
   <div class="form-group">
    <label for="content">내용</label>
    <textarea cols="5" class="form-control" id="content" name="content" required="required">${vo.content }</textarea>
   </div>
   
   <div class="form-group">
    <label for="writer">작성자</label>
    <input class="form-control" id="writer" name="writer" required="required" value="${vo.writer }">
   </div>
   
   <button class="btn btn-default">수정</button>
   <button type="reset" class="btn btn-default">새로 입력</button>
   <button type="button" id="cancelBtn" class="btn btn-default">취소</button>
   
  </form>
 </div>
</body>
</html>