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


<body>
<!-- java.util.ArrayLisクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- tes.QuestionBeanクラスをインポートする -->
<%@ page import="tes.UsersBean"%>


<form onSubmit="returnCheck()"action="UserRegisterItem" method="post">
	<p>
	<label for="userName">ユーザ名</label>
	</p>
	<p>
	<input type="text" name="userName"id="userName"required placeholder="ユーザー名(半角英数字のみ)" >
	<p>
	<label for="usersPass">PW</label>
	</p>
	<p>
	<input type="password"name="usersPass"id="usersPass" required>
	</p>
	<p>
	<label for="userPassCheck">PW再確認</label>
	</p>
	<p>
	<input type="password"name="userPassCheck"id="userPassCheck" required>
	</p>
	<p>
	管理者
	<input type="checkbox"name="admin_flag"id="admin_flag"value="1">
	</p>
	<input type="submit"id="submit">
	
</form>
<script src="userReisterConfirm.js"></script>
</body>
</html>

