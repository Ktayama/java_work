<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="answerList.css">
<link rel="stylesheet" href="common_center.css">
<link rel="stylesheet" href="questions_border.css">
<link rel="stylesheet" href="wrap.css">

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
	<div class="boxwrap">
		<div class="questionDeploy">
		<p><font size="5"> 問題</font></p>
		<!-- type="text"では文字列を入力できるテキストボックスを生成している。 入れ物の名前をname="questions_text"と指定している -->
		<input type="text"class="box11"name="questions_text"><br>
		</div>
		
		<div class="deploy">
		<!-- type="text"では文字列を入力できるテキストボックスを生成している。 入れ物の名前をname="answer_text"と指定している -->
		<label>答え :</label><input type="text"class="boxA" name="answer_text"><br>
		</div>
		
		<!-- jsの方でテーブルを取得した値をjspに渡す -->
		<!-- border="1"は罫線 -->
		<table id="answer_text" border="1">
		
		</table>
		
		<div class="center">
		<!-- type="submit"では送信ボタンとしての機能、value="確認"で初期値を指定している-->
		<button type="submit"name="prm" value="確認">確認</button>
		<button type="submit"name="prm" value="戻る">戻る</button>
		<!-- <input type="submit"  name="prm" value="確認"> -->
		<!-- <input type="submit" name="prm"  value="戻る"> -->
		<!-- type="submit"では送信ボタンとしての機能、value="戻る"で初期値を指定している-->
		
		</div>
	</div>
</form>
<div class="deploy">
		<!-- 追加ボタンで表示onclickイベント設定 -->
		<button type="button" class="boxA" id="coladd" onclick="coladd()">追加</button>
</div>	
</body>
</html>