<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>연체도서검색페이지</title>
	<style>
		@import url("<%=request.getContextPath()%>/css/book/Book.css");
	</style>
</head>
<body>
	<jsp:include page="Aside.jsp"></jsp:include>
	<article class="book">


	<div class="center">
		<div class="center">
			<form action="<%= request.getContextPath() %>/book/bookOverdueSearch.soso"> 
				<table>
					<tr>
						<td>
							<select name="search1" size="1">
								<option value="serialNo">책고유번호</option><!-- (쿼리로 관리자만 보이게 하기) -->
								<option value="bTitle">도서명</option>
								<option value="author">저자</option>
								<option value="publisher">출판사</option>
								<option value="overdue">연체일</option>
							</select>
						</td>
						<td><input name="search2" type="search"></td>
						<td><input type="submit" value="검색"></td>
					</tr>
				</table>
			</form>
			해당 페이지는 열자마자 연체일 검색에 따른 목록이 나와야 합니다. 현재 서블릿만으로는 구현 불가페이지 입니다. 
		</div>
		<div>
		<table class="rightSort">
			<tr>
				<td>no.</td>
				<td>일련번호</td>
				<td>책제목</td>
				<td>저자명</td>
				<td>연체일</td>
				<td>빌린이(id)</td>
			</tr>
			<tr>
				<td>1</td>
				<td>0102040021</td>
				<td>사람은무엇으로사는가?</td>
				<td>레브니콜라예비치톨스토이</td>
				<td>60일</td>
				<td>빌린이</td>
			</tr>
			<tr>
				<td>2</td>
				<td>0102040022</td>
				<td>사람은무엇으로사는가</td>
				<td>레브니콜라예비치톨스토이</td>
				<td>20일</td>
				<td>빌린이</td>
			</tr>
			<tr>
				<td>3</td>
				<td>0102030011</td>
				<td>부활</td>
				<td>레브니콜라예비치톨스토이</td>
				<td>15일</td>
				<td>빌린이</td>
			</tr>
			<tr>
				<td>4</td>
				<td>0104010022</td>
				<td>등대지기</td>
				<td>조창인</td>
				<td>12일</td>
				<td>빌린이</td>
			</tr>
			<tr>
				<td>5</td>
				<td>0101010011</td>
				<td>호질</td>
				<td>박지원</td>
				<td>9일</td>
				<td>빌린이</td>
			</tr>
			<tr>
				<td>6</td>
				<td>0101010021</td>
				<td>양반전</td>
				<td>박지원</td>
				<td>6일</td>
				<td>빌린이</td>
			</tr>
			
		</table>
		</div>	
		<%-- <% 
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
			} %> --%>
					
	</div>
	</article>
</body>
</html>