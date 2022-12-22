<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<link rel="stylesheet" href="wrap.css">
<link rel="stylesheet" href="alertarea.css">
<script src="userReisterConfirm.js"></script>

<body>
<!-- java.util.ArrayLisクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- tes.QuestionBeanクラスをインポートする -->
<%@ page import="tes.UsersBean"%>

<form action="UserRegisterItem" method="post" name="form">
<p>
	ユーザー名                             
	<input type="text" name="userName"required placeholder="ユーザー名(半角英数字のみ)" >
	</p>
	<p>
	PW                                       
	<input type="password"name="usersPass">
	</p>
	<p>
	PW再確認
	<input type="password"name="userPassCheck">
	</p>
	<p>
	管理者
	<input type="checkbox"name="admin_flag"value="1">
	</p>
	<input type="submit" value="確認" onClick="return false;">
	
	<input type="submit"value="戻る">
</form>

</body>
</html>

