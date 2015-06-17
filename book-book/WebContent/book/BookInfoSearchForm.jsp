<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>책정보 검색 페이지</title>
</head>
<body>
	<div>
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
			
		</div>
			
		<% 
		int count=0;
		
			if(request.getAttribute("count")!=null&&(String)request.getAttribute("search")!=null){ 
				String count1=(String)request.getAttribute("count");
				count=Integer.parseInt(count1);
				%><table>
				<% String[][] searchList=new String[count+1][6];
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
</body>
</html>