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
<!-- QuestionBeanクラスをインポートする -->
<%@ page import="tes.UsersBean"%>

<!-- リクエストスコープからエラーメッセージを受け取る -->
<%String failureMessage = (String)request.getAttribute("loginFailure");%> 


<%ArrayList<UsersBean> usersList = (ArrayList<UsersBean>)request.getAttribute("UsersList"); %>
<%System.out.println((ArrayList<UsersBean>)request.getAttribute("UsersList")); %>

<!-- エラーメッセージが存在するときだけ表示する -->
<%if (failureMessage != null) {%>
	<%=failureMessage%>
<%}%>

<form action="./UserItem" method="post">

<input type="hidden" name="parem"value="1">

	
		<input type="submit"  value="新規登録" >

	
</form>

<%for (UsersBean usersBean : usersList) {%>
		
		<%=usersBean.getId()%>
	
		<% if(usersBean.getAdminflag()==1){%>
		 管理者 
		 <%}else{%>
		 一般
		 <%} %>
		
		<%=usersBean.getName()%>
		
		<form action="./UserItem" method="post">
			
			<input type="hidden" name="parem"value="2">
			
			<input type="hidden" name="user_id" value="<%=usersBean.getId()%>">
			
			<input type="submit" value="編集" >
		</form>
		
		
		<form action="./UserItem" method="post">
			
			<input type="hidden" name="parem"value="3">
			
			<input type="hidden" name="user_id" value="<%=usersBean.getId()%>">
			
			<input type="submit"  value="削除" >
			
		</form>
		
	<%} %>
	
</body>
</html>