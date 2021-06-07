<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mainstyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/clear.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/formLayout.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mystyle.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.5.1.min.js'/>"></script>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>

	<h2>책 상세보기</h2>
	<p>번호 : ${param.no}</p>
	<p>책제목 : ${dto.title }</p>
	<p>가격 : ${dto.price}</p>
	<p>등록일 : ${dto.joindate}</p>
	
	<hr>
	<a href='<c:url value="/book/bookList.do" /> '>목록</a>|
	<a href='<c:url value="/book/bookEdit.do?no=${param.no}"/> '>수정</a>|
	<a href='<c:url value="bookDel.do?no=${param.no}&step=${dto.step}&groupNo=${dto.groupNo}" /> '>삭제</a> |
	
	
	
</body>
</html>












