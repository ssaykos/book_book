<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> 책 정보 입력 확인 페이지</title>
	<style>
		@import url("<%=request.getContextPath()%>/css/book/Book.css");
	</style>
</head>
<body>
<jsp:include page="Aside.jsp"></jsp:include>
	<article class="book">
	<div>
		<form action="<%= request.getContextPath() %>/lib/BookInfoAddition.soso">
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
					<td></td>
					<td></td>
					<td><input type="submit" value="확  인"></td>				
				</tr>
			</table>
		</form>
	</div>
	</article>
</body>
</html>