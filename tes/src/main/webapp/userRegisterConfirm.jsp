<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String userName=(String)request.getAttribute("UserName");%>
<%String userPass=(String)request.getAttribute("UserPass");%>
<%String userPassCheck=(String)request.getAttribute("UserPassCheck");%>
<%byte adminFlag =(byte)request.getAttribute("adminFlagByte");%>

<form action="UserRegisterConfirmItem" method="post">
	<p>
	ユーザ名
	<input type="text"name="userName"value="<%=userName%>">
	</p>
	<p>
	PW
	<input type="password"name="userPass"value="<%=userPass%>">
	</p>
	<p>
	PW確認
	<input type="password"name="userPassCheck"value="<%=userPassCheck%>">
	</p>
	<p>
	管理者<input type="text"name="adminFlag"value="<%=adminFlag%>">
	</p>
	<button type="submit"name="prm_confirm"value="登録"></button>
	
	<button type="submit"name="prm_confirm"value="戻る"></button>
	
</form>

</body>
</html>

