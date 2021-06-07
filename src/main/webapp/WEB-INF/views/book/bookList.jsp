<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mainstyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/clear.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/formLayout.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/mystyle.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.5.1.min.js'/>"></script>
<script type="text/javascript">	
$(function(){
	$('.divList table.box2 tbody tr').hover(function(){
		$(this).css('background','lightblue');
	}, function(){
		$(this).css('background','');		
	});
});

function pageFunc(curPage){
	$('input[name=currentPage]').val(curPage);
	$('form[name=frmPage]').submit();
}
</script>
<style type="text/css">
body {
	padding: 5px;
	margin: 5px;
}


</style>
</head>
<body>

<form action="<c:url value='/book/bookList.do'/>" 
	name="frmPage" method="post">
	<input type="hidden" name="currentPage">
	<input type="hidden" name="searchCondition" 
		value="${param.searchCondition }">
	<input type="hidden" name="searchKeyword"
		value="${param.searchKeyword }">	
</form>
<h2>도서 목록</h2>
<c:if test="${!empty param.searchKeyword }">
	<p>검색어 : ${param.searchKeyword}, ${pagingInfo.totalRecord } 
		건 검색되었습니다.</p>
</c:if>

	
	<div class="divList">
		<table class="box2">
			<caption>도서 목록</caption>
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 45%;" />
				<col style="width: 15%;" />
				<col style="width: 15%;" />
				<col style="width: 15%;" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">도서명</th>
					<th scope="col">가격</th>
					<th scope="col">출판사</th>
					<th scope="col">발행일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					<tr>
						<td colspan="5" class="align_center">데이터가 존재하지 않습니다..</td>
					</tr>
				</c:if>
				<c:if test="${!empty list }">
					<c:forEach var="vo" items="${list }"> 
						<tr style="text-align: center">
							<td>${vo.no }</td>
							<td>
								<a href="<c:url value='/book/bookDetail.do?no=${vo.no }'/>">
									${vo.title }
								</a>
								<c:if test="${vo.newImgTerm<24 }">
									<img alt="new" src="<c:url value='/resources/images/new.gif' />">
								</c:if>
							</td>
							<td style="text-align: right"><fmt:formatNumber value="${vo.price }" pattern="#,###" /> 원</td>
							<td>${vo.publisher }</td>
							<td><fmt:formatDate value="${vo.joindate }" pattern="yyyy-MM-dd"/> </td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<div class="divPage">
	<!-- 페이지 번호 추가 -->		
	<!-- 이전 블럭으로 이동 -->
	<c:if test="${pagingInfo.firstPage>1 }">	
		<a href="#" onclick="pageFunc(${pagingInfo.firstPage-1})">
			<img src="<c:url value='/resources/images/first.JPG'/>" alt="이전블럭으로 이동">
		</a>
	</c:if>
						
	<!-- [1][2][3][4][5][6][7][8][9][10] -->
	<c:forEach var="i" begin="${pagingInfo.firstPage}" end="${pagingInfo.lastPage}">
		<c:if test="${i==pagingInfo.currentPage }">
			<span style="color:blue;font-weight: bold">
				${i}</span>			
		</c:if>
		<c:if test="${i!=pagingInfo.currentPage }">
			<a href="#" onclick="pageFunc(${i})">
				[${i}]</a>			
		</c:if>	
	</c:forEach>
	
	<!-- 다음 블럭으로 이동 -->
	<c:if test="${pagingInfo.lastPage < pagingInfo.totalPage }">	
		<a href="#" onclick="pageFunc(${pagingInfo.lastPage+1})">
			<img src="<c:url value='/resources/images/last.JPG'/>" alt="다음 블럭으로 이동">
		</a>
	</c:if>
	
	
	<!--  페이지 번호 끝 -->
	
	</div>
	<div class="divBtn">
		<a href="<c:url value='/book/bookWrite.do'/>">도서 등록</a>
	</div>
	<div class="divSearch">
   	<form name="frmSearch" method="post" 
   		action='<c:url value="/book/bookList.do"/>'>
        <select name="searchCondition">
            <option value="title" 
            	<c:if test="${param.searchCondition == 'title'}">
            		selected="selected"
            	</c:if>
            >제목</option>
            <option value="publisher"
            	<c:if test="${param.searchCondition == 'publisher'}">
            		selected="selected"
            	</c:if>
            >출판사</option>
            
        </select>   
        <input type="text" name="searchKeyword" title="검색어 입력"
        	value="${param.searchKeyword}">   
		<input type="submit" value="검색">
    </form>
	</div>
</body>
</html>