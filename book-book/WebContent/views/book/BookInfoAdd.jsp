<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="<%=request.getContextPath() %>"></c:set>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> 책 정보 입력 확인 페이지</title>
	<style>
		@import url("${context}/css/book/Book.css");
	</style>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div><jsp:include page="../main/header.jsp"/></div>
<br /><br />
<jsp:include page="Aside.jsp"></jsp:include>
	<article class="book">
	<div>
		<form action="${context}/lib/BookInfoAddition.soso" style="min-height: 600px">
			<table>
				<tr>
					<td>고유식별번호</td>
					<td><%= request.getAttribute("일련번호") %></td>
					<td></td>
				</tr>
				<tr>
					<td>책제목</td>
					<td><%= request.getAttribute("책제목") %></td>
					<td></td>
				</tr>
				<tr>
					<td>저자명</td>
					<td><%= request.getAttribute("저자명") %></td>
					<td></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><%= request.getAttribute("출판사") %></td>
					<td></td>
				</tr>
				<tr>
					<td>출판일</td>
					<td><%= request.getAttribute("출판일") %></td>
					<td></td>
				</tr>
				<tr>
					<td>입고일</td>
					<td><%= request.getAttribute("입고일") %></td>
					<td></td>
				</tr>
				<tr>
					<td>책분류</td>
					<td><%= request.getAttribute("책분류") %></td>
					<td></td>
				</tr>
				<tr>
					<td>책분류 코드</td>
					<td><%= request.getAttribute("책분류코드") %></td>
					<td></td>
				</tr>
				<tr>
					<td>KDC</td>
					<td><%if(request.getAttribute("KDC")==null)
				{ %>미구현입니다.<%}else {%>${request.getAttribute("KDC")}<%}%></td>
					<td></td>
				</tr>
				<tr>
					<td>KDC코드</td>
					<td><%if(request.getAttribute("KDC코드")==null)
				{ %>미구현입니다.<%}else {%>${request.getAttribute("KDC코드")}<%}%></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="확  인"></td>				
				</tr>
			</table>
		</form>
	</div>
	</article>
	<div><jsp:include page="../main/footer.jsp"/></div>	
</body>
</html>