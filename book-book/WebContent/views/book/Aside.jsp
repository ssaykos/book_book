<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="<%=request.getContextPath() %>"></c:set>
<style>
	 @import url("<%=request.getContextPath()%>/css/book/Aside.css");
</style>

	
<aside class="aside">
	<table class="center">
		<tr>
			<td><a href="${context}/book/Aside/BookInfoSearch.soso"><b style="font-size: 32px">통합검색</b></a></td>
		</tr>
		
		<tr>
			<td><a href="${context}/book/Aside/BookGroupSearch.soso"><b style="font-size: 32px">분류별검색</b></a></td>
		</tr>
		<tr>
			<td><a href="${context}/book/Aside/OverdueBookSearch.soso"><b style="font-size: 32px">연체도서검색</b></a></td>
		</tr>
		<tr>
			<td><a href="${context}/book/Aside/BookInfoAddForm.soso"><b style="font-size: 32px">책정보 입력</b></a></td>
		</tr>
	</table>
</aside>
	

