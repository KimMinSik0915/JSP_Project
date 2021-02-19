<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 쓰기</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

 <div class="container">
  <h1>글 쓰기</h1>
  <form action="write.jsp" method="post" onsubmit="">
  
   <div class="form-group">
    <label for="title">제목</label>
    <input class="form-control" id="title" name="title">
   </div>
   
   <div class="form-group">
    <label for="content">내용</label>
    <textarea cols="5" class="form-control" id="content" name="content"></textarea>
   </div>
   
   <div class="form-group">
    <label for="writer">작성자</label>
    <input class="form-control" id="writer" name="writer">
   </div>
   
   <button type="submit" class="btn btn-default">등록</button>
   <a href="list.jsp" class="btn btn-default"> 리스트</a>
   
  </form>
 </div>
</body>
</html>