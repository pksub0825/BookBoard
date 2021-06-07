<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mainstyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/clear.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/formLayout.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mystyle.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.5.1.min.js'/>"></script>
</head>
<body>

<form action="<c:url value='/book/bookEdit.do'/>"
	name="frmEdit" method="post">
	<input type="hidden" name="no" value="${param.no }">
	<h2>책 수정</h2>
	<label>번호  : </label>
	<input type="text" name="no" value="${param.no}"><br>
	<label>책제목 : </label>
	<input type="text" name="title" value="${dto.title}"><br>
	<label>가격  : </label>
	<input type="text" name="price" value="${dto.price}"><br>
	<label>출판사 : </label>
	<input type="text" name="publisher" value="${dto.publisher}"><br>
	<label>등록일 : </label>
	<input type="text" name="joindate" value="${dto.joindate}"><br><br>

	<input type="submit" name="edit" value="수정">
	
</form>
	<hr>
	<a href="bookList.do">목록</a>
</body>
</html>
































