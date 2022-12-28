<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.UsersBean"%>
<script src="Delete_Insert_items.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="wrap.css">
<script src="UserEditCheck.js"></script>
<body>

<%UsersBean userBean = (UsersBean)request.getAttribute("UsersBean"); %>

<script src="item.js"></script>
<form action="UserEditItem"method="post"name="form">
<p>
番号
<input type="text"name="userId"readonly="readonly"value=<%=userBean.getId()%>>
</p>
<p>
ユーザー名
<input type="text"name="userName"readonly="readonly"value="<%=userBean.getName() %>">
</p>
<p>
PW
<input type="password"name="userPass" value="<%=userBean.getPassword() %>">
</p>
<p>
PW再確認
<input type="password" name="userPassCheck"value="<%=userBean.getPassword()%>">
</p>
<p>
管理者
<input type="checkbox"name="admin_flag"value=<%=userBean.getId() %>>
</p>
<input type="submit"value="確認"onClick="return EditCheck();">

<input type="submit"value="戻る">

</form>
</body>
</html>