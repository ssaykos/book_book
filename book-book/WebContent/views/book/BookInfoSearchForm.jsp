<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="<%=request.getContextPath() %>"></c:set>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>책정보 검색 페이지</title>
	<style>
		@import url("<%=request.getContextPath()%>/css/book/Book.css");
	</style>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div><jsp:include page="../main/header.jsp"/></div>
<br /><br />
	<jsp:include page="Aside.jsp"></jsp:include>
	<article class="book">
	<div style="min-height: 600px">
		<div>
			<form action="<%= request.getContextPath() %>/book/bookInfoSearch.soso"> 
				<table>
					<tr>
						<td>
							<select name="search1" size="1">
								<option value="serialNo">책고유번호</option><!-- (쿼리로 관리자만 보이게 하기) -->
								<option value="bTitle">도서명</option>
								<option value="author">저자</option>
								<option value="publisher">출판사</option>
							</select>
						</td>
						<td><input name="search2" type="search"></td>
						<td><input type="submit" value="검색"></td>
					</tr>
				</table>
			</form>
			<br /><br /><br />
			
		</div>
			
		<% 
		int count=0;
		
			if(request.getAttribute("count")!=null&&request.getAttribute("search")!=null){ 
				count=Integer.parseInt((String)request.getAttribute("count"));
				%><table>
				<% String[][] searchList = new String[count+1][6];
				searchList=(String[][])request.getAttribute("search"); 
				for(int i=0; i<searchList.length;i++){
					%> <tr><%
					for(int j=0;j<searchList[i].length;j++){
						%> <td><%= searchList[i][j] %> </td> <%
						}
						%> </tr><%
				}
				%></table><%
			}else if(count==0&&request.getAttribute("search")!=null){
					%><%= request.getAttribute("search") %><%
			} %>
					
	</div>
	</article>
	<div><jsp:include page="../main/footer.jsp"/></div>	
</body>
</html>