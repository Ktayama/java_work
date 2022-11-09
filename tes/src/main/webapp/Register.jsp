<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="Delete_Insert_items.js"></script>

<body>
<!-- java.util.ArrayLisクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- tes.QuestionBeanクラスをインポートする -->
<%@ page import="tes.QuestionsBean"%>
<!-- tes.Correct_answersBaenクラスをインポートする -->
<%@ page import="tes.Correct_answersBean"%>

<!-- リクエストスコープからエラーメッセージを受け取る -->
<!-- LIst.jspからの入力されたパラメーターをString型の変数に取得する -->

<%//String questions_text = (String)request.getAttribute("Qusertions_text");%>
<!-- LIst.jspからの入力されたパラメーターをString型の変数に取得する -->
<%//String answer_text = (String)request.getAttribute("Correct_anser_text");%>
 
 

<%//questions_textパラメータ %>

<form action="Register_item" method="post">

		<!-- type="text"では文字列を入力できるテキストボックスを生成している。 入れ物の名前をname="questions_text"と指定している -->
		<label>問題 :</label><input type="text"name="questions_text"><br>
		<!-- type="text"では文字列を入力できるテキストボックスを生成している。 入れ物の名前をname="answer_text"と指定している -->
		<label>答え :</label><input type="text" name="answer_text"><br>
		
		
		<!-- jsの方でテーブルを取得した値をjspに渡す -->
		<!-- border="1"は罫線 -->
		<table id="answer_text" border="1">
		
		</table>
		<!-- type="submit"では送信ボタンとしての機能、value="確認"で初期値を指定している-->
		<input type="submit"  name="prm" value="確認">
		<!-- type="submit"では送信ボタンとしての機能、value="戻る"で初期値を指定している-->
		<input type="submit" name="prm"  value="戻る">
</form>
		<!-- 追加ボタンで表示onclickイベント設定 -->
		<input type="button" value="追加" id="coladd" onclick="coladd()">
		
</body>
</html>