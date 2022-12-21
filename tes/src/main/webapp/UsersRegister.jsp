<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="userReisterConfirm.js"></script>


<link rel="stylesheet" href="wrap.css">
<link rel="stylesheet" href="alertarea.css">

<script src="Delete_Insert_items.js"></script>

<body>
<!-- java.util.ArrayLisクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- tes.QuestionBeanクラスをインポートする -->
<%@ page import="tes.UsersBean"%>

<form class="checkform" name="formCheck"action="UserRegisterItem" method="post">
	<p>
	ユーザー名                             
	<input type="text"class="alpha" name="userName"required placeholder="ユーザー名(半角英数字のみ)" >
	<span class="alertarea"></span>
	</p>
	<p>
	PW                                       
	<input type="password"class="chars8"name="usersPass">
	<span class="alertarea"></span>
	</p>
	<p>
	PW再確認
	<input type="password" id="userPassCheck"class="chars8"name="userPassCheck">
	<span class="alertarea"></span>
	</p>
	<p>
	管理者
	<input type="checkbox"name="admin_flag"value="1">
	</p>
	<input type="submit"value="確認"onclick="myCheck">
	
	<input type="submit"value="戻る">
</form>
</body>
</html>

