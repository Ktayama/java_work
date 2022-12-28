<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String userId =(String)request.getAttribute("UserId"); %>
<%String userName=(String)request.getAttribute("UserName");%>
<%String userPass=(String)request.getAttribute("UserPass");%>
<%String userPassCheck=(String)request.getAttribute("UserPassCheck");%>
<%byte adminFlag =(byte)request.getAttribute("AdminFlagByte");%>


<form action="UserEditConfirmItem" method="post">
	<p>
	ID
	<input type="text"name="userId"readonly="readonly"value="<%=userId%>">
	</p>
	<p>
	ユーザ名
	<input type="text"name="userName"readonly="readonly"value="<%=userName%>">
	</p>
	<p>
	PW
	<input type="password"name="userPass"readonly="readonly"value="<%=userPass%>">
	</p>
	<p>
	PW確認
	<input type="password"name="userPassCheck"readonly="readonly"value="<%=userPassCheck%>">
	</p>
	<p>
	管理者<input type="text"name="adminFlag"readonly="readonly"value="<%if(adminFlag ==1) {%>あり<%}else{%>なし<% }%>">
	</p>
	<input type="submit"name="prm_edit_confirm"value="更新">
	
	<input type="submit"name="prm_edit_confirm"value="戻る">
	
</form>
</body>
</html>