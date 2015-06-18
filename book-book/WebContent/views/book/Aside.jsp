<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>소메뉴바</title>
	<style>
	 @import url("<%=request.getContextPath()%>/css/book/Aside.css");
	</style>
</head>
<body>
	<aside class="aside">
	<table class="center">
		<tr>
			<td><a href="<%=request.getContextPath()%>/book/Aside/BookInfoSearch.soso">통합검색</a></td>
		</tr>
		<tr>
			<td><a href="<%=request.getContextPath()%>/book/Aside/BookGroupSearch.soso">분류별검색</a></td>
		</tr>
		<tr>
			<td><a href="<%=request.getContextPath()%>/book/Aside/OverdueBookSearch.soso">연체도서검색</a></td>
		</tr>
		<tr>
			<td><a href="<%=request.getContextPath()%>/book/Aside/BookInfoAddForm.soso">책정보 입력</a></td>
		</tr>
	</table>
	</aside>
	
</body>
</html>