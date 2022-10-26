<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- リクエストスコープからエラーメッセージを受け取る -->
 <%String failureMessage = (String)request.getAttribute("loginFailure");%>
 
<!-- エラーメッセージが存在するときだけ表示する -->
<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>
<form action="TOP" method="post">
<!-- hiddenで隠して渡したいパラメータを設定する -->
<!-- valueで1の初期値をしている -->
		<input type="hidden" name="param" value="1">
		<!-- submitでは送信ボタンとしての機能、value="問題と答えを確認・登録する"で初期値を指定している  -->
		<input type="submit"value="問題と答えを確認・登録する >"/>
</form>
<form action="TOP"method="post">
<!-- hiddenでかくして渡したいパラメータを設定する -->
<!-- valueで２の初期値している -->
		<input type= "hidden" name="param" value=”2”>
		<!-- submitでは送信ボタンとしての機能、value="テストする"で初期値を指定している -->
		<input type="submit" value="テストをする ＞" >
</form>
<form action="TOP" method="post">
<!-- hiddenでかくして渡したいパラメータを設定する -->
		<input type="hidden" name="param" value="3">
		<!-- sumbitでは送信ボタンとしての機能、value="ユーザーを追加する・編集する"で初期値を指定している -->
		<input type="submit" value="ユーザーを追加する・編集する" >
</form>
</body>
</html>