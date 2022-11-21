<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="wrap.css">
<body>
<!-- リクエストスコープからエラーメッセージを受け取る -->
 <%String failureMessage = (String)request.getAttribute("loginFailure");%>
 
<!-- エラーメッセージが存在するときだけ表示する -->
<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>
<form action="./Top_item" method="post">
<!-- hiddenで隠して渡したいパラメータを設定する -->
<!-- valueで1の初期値をしている -->

	<div class="buttonA">
		
		<button type="submit" >問題と答えを確認・登録する</button>
		<input type="hidden" name="param" value="1">
	</div>
		<!-- submitでは送信ボタンとしての機能、value="問題と答えを確認・登録する"で初期値を指定している  -->
		<%//input type="submit"value="問題と答えを確認・登録する >"/> %>
</form>

<form action="./Top_item"method="post">
		<!-- hiddenでかくして渡したいパラメータを設定する -->
		<!-- valueで２の初期値している -->
	<div class="buttonA">
		<button type="submit" >テストをする</button>
		<input type="hidden" name="param" value="2">
	</div>
		<%//input type="submit" value="テストをする" > %>
		<!-- submitでは送信ボタンとしての機能、value="テストする"で初期値を指定している -->
		
</form>

<form action="./Top_item" method="post">
		<!-- hiddenでかくして渡したいパラメータを設定する -->
		<%//input type="submit" value="過去の採点結果をみる" >%>
	<div class="buttonA">
		<button type="submit" >過去の採点結果をみる</button>
		<input type="hidden" name="param" value="3">
		<!-- sumbitでは送信ボタンとしての機能、value="ユーザーを追加する・編集する"で初期値を指定している -->
	</div>
</form>

</body>
</html>