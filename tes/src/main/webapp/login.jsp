<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="Login.css">
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="wrap.css">
<body>
<!-- リクエストスコープからエラーメッセージを受け取る -->
 <%String failureMessage = (String)request.getAttribute("loginFailure");%>
 
<!-- エラーメッセージが存在するときだけ表示する -->
<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>
<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<form action="Login" method="post">
<div class="boxwrap">
<div class="stuff">
<div class="textBox">
	<input 
		class="text" 
		type="text"
		placeholder="UserIDを入力してください"
		name="user_id"
		onkeyup="this.setAttribute('value', this.value);"
		value=""/>
	<label class="label">UserID</label>
	<label class="error"></label>
</div>
<div class="textBox">
	<input 
		class="text" 
		type="password"
		placeholder="Passwordを入力してください"
		name="password"
		onkeyup="this.setAttribute('value', this.value);"
		value=""/>
	<label class="label">Password</label> 
	<label class="error"></label>
</div>
</div>
</div>
<!-- typeではtext、 password 、 radio、 checkbox、 file、 hidden、 submit、 image、 reset、 buttonが使用可能 -->
<!--type="text"では文字を入力できるテキストボックスを生成して、入れ物の名前をname="user_idと指定している-->

 
        <%//input type="text" name="user_id"> %>
<!-- type="password"ではpasswordを生成して、入れ物の名前をname ="password"と指定している -->
       <%//input type="password" name="password"> %> 
<!-- type="submit"では送信ボタンとしての機能、value="login"のvalueでloginの初期値を指定している -->
<div class="buttonA">
        <button type="submit">login</button>
</div>
</form>


</body>
</html>