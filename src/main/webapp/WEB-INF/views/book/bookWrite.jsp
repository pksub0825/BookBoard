<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mainstyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/clear.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/formLayout.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mystyle.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.5.1.min.js'/>"></script>
<title>책 등록</title>
</head>
<body>
	<h2>책 등록</h2>
	<form action='<c:url value="/book/bookWrite.do" />' 
	name="frmWrite" method="post">
	<label for="title">책 제목</label> 
	<input type="text" name="title" id="title"><br>
	
	<label for="price">가격</label> 
	<input type="text" name="price" id="price"><br>
	
	<label for="publisher">출판사</label> 
	<input type="text" name="publisher" id="publisher"><br><br>
	
	<input type="submit" value="전송">
	<hr>
	<a href='<c:url value="/book/bookList.do" /> '>목록</a>
	
	
	</form>
</body>
</html>