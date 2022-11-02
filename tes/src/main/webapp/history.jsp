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

<%ArrayList<HistoriesBean> Questions_list = (ArrayList<HistoriesBean>)request.getAttribute("Qusertions_list"); %>

<%System.out.println((ArrayList<HistoriesBean>)request.getAttribute("Qusertions_list")) ;%>

<form action="top.jsp" method="post">
		
		<input type="hidden" name="pram">
		
		<input type="submit" name="top" value="top">
</form>
<form action="logout.jsp">
		
		<input type="hidden" name="pram">
		
		<input type="submit" name="logout" value="logout"><br>
		
</form>
<form>
		
		履歴<br>
		
		<%for (HistoriesBean historiesBean : Questions_list) {%>
		
				名前<br>
				<%=historiesBean.getUserId() %>
				点数<br>
				<%=historiesBean.getPoint() %>
				現在時刻
				<%=historiesBean.getCreatedAt() %>
				
				
		<%} %>
		
		
</form>
</body>
</html>