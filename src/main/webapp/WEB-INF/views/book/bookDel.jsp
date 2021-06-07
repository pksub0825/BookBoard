<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mainstyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/clear.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/formLayout.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mystyle.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.5.1.min.js'/>"></script>
</head>
<body>

<script type="text/javascript">
	$(function(){
		$('form[name=frmDelete]').submit(function(){
			if(!confirm('삭제하시겠습니까?')){
				event.preventDefault();
			}
		});
	});	
</script>

<div class="divForm">
<form name="frmDelete" method="post" action="<c:url value='/book/bookDel.do' /> " >
		<input type="hidden" name="no" value="${param.no}">
		<fieldset>
		<legend>글 삭제</legend>
	        <div>           
	        	<span class="sp">  ${param.no }번 글을 삭제하시겠습니까?</span>                        
	        </div>
	        
	        <div class="center">
	            <input type ="submit"  value="삭제" />
	            <a href="<c:url value='/book/bookList.do' />">
	            	<input type = "Button" value="글목록" /> 
               	</a>
	        </div>
	    </fieldset>
    </form>
</div>

</body>
</html>