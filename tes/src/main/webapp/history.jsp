<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.HistoriesBean"%>
<%@ page import="tes.UsersBean"%>

<%ArrayList<HistoriesBean> Histories_liet = (ArrayList<HistoriesBean>)request.getAttribute("History_list"); %>
<%UsersBean Users = (UsersBean)request.getAttribute("Users"); %>

<%System.out.println((ArrayList<HistoriesBean>)request.getAttribute("History_list")) ;%>

<form action="top.jsp" method="post">
		
		<input type="hidden" name="pram">
		
		<input type="submit" name="top" value="top">
</form>
<form action="logout.jsp" method="post">
		
		<input type="hidden" name="pram">
		
		<input type="submit" name="logout" value="logout"><br>
		
</form>
<form>
<%for (HistoriesBean historiesBean : Histories_liet) {%>
	
履歴<br>
	<table border="1">
		<tr>
			<th>名前</th>
			<th>点数</th>
			<th>現在時刻</th>
		</tr>
		<tr>
			<td><%=Users.getName()%></td>
			<td><%=historiesBean.getPoint() %></td>
			<td><%=historiesBean.getCreatedAt() %></td>
	</table>
<%} %>
		
		
</form>
</body>
</html>