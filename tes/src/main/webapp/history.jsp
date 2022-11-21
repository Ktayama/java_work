<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="wrap.css">
<link rel="stylesheet" href="common_center.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<body>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.HistoriesBean"%>
<%@ page import="tes.UsersBean"%>

<%ArrayList<HistoriesBean> Histories_liet = (ArrayList<HistoriesBean>)request.getAttribute("History_list"); %>
<%UsersBean Users = (UsersBean)request.getAttribute("Users"); %>

<%System.out.println((ArrayList<HistoriesBean>)request.getAttribute("History_list")) ;%>


<form>
<script src="item.js"></script>
<div class="boxwrap">
<h2>履歴</h2><br>
<%for (HistoriesBean historiesBean : Histories_liet) {%>
	

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
		
</div>		
</form>
</body>
</html>