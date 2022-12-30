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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="answerList.css">
<link rel="stylesheet" href="common_center.css">
<link rel="stylesheet" href="questions_border.css">
<link rel="stylesheet" href="wrap.css">

<body>
<!-- java.util.ArrayLisクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- tes.UsersBeanクラスをインポートする -->
<%@ page import="tes.UsersBean"%>

<script src="item.js"></script>
   <p></p>
<form action="UserRegisterItem" method="post" name="form">
	<div class="boxwrap">
	<p>
	ユーザー名
	<!-- type="text"では文字列を入力できるテキストボックスを生成している。placeholderでユーザ名(半角英数字のみ)っと記載 -->
	<input type="text" class="boxA"name="userName"required placeholder="ユーザー名(半角英数字のみ)" >
	</p>
	<p>
	PW
	<!-- パスワード入力欄作成 -->                                 
	<input type="password"class="boxA"name="userPass">
	</p>
	<p>
	PW再確認
	<!-- パスワードの再確認用に入力欄を作成 -->
	<input type="password"class="boxA"name="userPassCheck">
	</p>
	<p>
	管理者
	<!-- type="checkbox"で一般か管理者か分けるために用意 -->
	<input type="checkbox"class="boxA"name="admin_flag">
	</p>
	</div>
	<div class="center">
	<!-- type="submit"では送信ボタンとしての機能、onClick="return check()"でUserDeleteCheck.jsで行った処理が実行される-->
	<button type="submit" onClick="return check();">確認</button>
	</div>
	
</form>
<form action="UserConnection" method="post">
<div class="center">
<!-- type="submit"では送信ボタンとしての機能-->
<button type="submit">戻る</button>

</div>
</form>
</body>
</html>

