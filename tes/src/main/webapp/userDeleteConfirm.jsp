<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.UsersBean"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="wrap.css">
<script src="UserDeleteCheck.js"></script>
<body>

<%UsersBean userBean = (UsersBean)request.getAttribute("UsersBean"); %>


<form action="UserDeleteConfirmItem"method="post"name="form">
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
<input type="password"name="userDeletePass" >
</p>
<p>
PW再確認
<input type="password"name="userPassDeleteCheck">
</p>
<!-- 正解用(非表示) -->
<input type="hidden"name="userPassCheckAnswer"value="<%=userBean.getPassword() %>">
<p>
管理者
<% if (userBean.getAdminflag() == 1) { %>
<input type="text"name="admin_flag"readonly="readonly"value=あり >
<% } else { %>
    <input type="text"name="admin_flag"readonly="readonly"value=なし>
<% }%>
</p>
<input type="submit"value="削除"onClick="return DeleteCheck">

<input type="submit"name="pram_delete"value="戻る">

</form>
</body>
</html>

