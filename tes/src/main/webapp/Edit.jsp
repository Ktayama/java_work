<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.QuestionsBean"%>
<%@ page import="tes.Correct_answersBean"%>
<!DOCTYPE html>
<html>
<head>
<script src="Delete_Insert_items.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="answerList.css">
<link rel="stylesheet" href="common_center.css">
<link rel="stylesheet" href="questions_border.css">
<link rel="stylesheet" href="wrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<body>


<!-- Edit_item.javaで定義した値をgetAttributeでQusertions_listを取得してArrayList<QuestionBean>型のquestion_listに代入している -->
<!-- Edit_item.javaからのパラメータをArrayList<QuestionBean>型の変数に取得する -->
<%
QuestionsBean questionsBean= (QuestionsBean)request.getAttribute("Qusertions_list");
%>
<!-- Edit_item.javaからのパラメータをArrayList<Correct_answersBaen>型の変数に取得する -->
<%
ArrayList<Correct_answersBean> Correct_anser_list = (ArrayList<Correct_answersBean>)request.getAttribute("Correct_anser_list");
%>
<!-- リクエストスコープからエラーメッセージを受け取る -->
<%String a_text = (String)request.getAttribute("a_text"); %>

<%String pram= (String)request.getAttribute("pram");%>


<script src="item.js"></script>
<form action="Edit_List" method="post"> 
		
		<div class="boxwrap">
		<div class="questionDeploy">
		番号<%=questionsBean.getId()%><br>
		
		
		<!-- input type="text"でテキストボックスを生成している。 value="=questionsBean.getQuestion()"ではLIst.jspで入力の値を表示 -->
		<p><br><font size="5">問題</font>
		
		<br><input type="text"name="questions_text" class="box11"value="<%=questionsBean.getQuestion()%>"></p>
		
		<input type="hidden" name="questions_id" value="<%=questionsBean.getId()%>">
		
		</div>
		<div class="deploy">
		<%//listは0からだから1番目からCorrect_anser_listをloopして一件づつ表示させる%>
		<%int question_no =0; %>
		<!-- size()でCorrect_anser_listの要素数を調べている -->
		<%for (int i = 0; i < Correct_anser_list.size(); i++) 
			{%>              
<!-- input type="text"でテキストボックスを生成している。 value="=Correct_anser_list.get(i).getAnswer()"ではLIst.jspで入力の値配列分を表示 -->                                         
		<p>答え :<input type="text"name="answer_text" class="boxA"value="<%=Correct_anser_list.get(i).getAnswer()%>" ></p>        
		<!-- hiddenで隠して渡したいパラメータを設定する。value="Correct_anser_list.get(i).getId()"では問題のidを指定している -->
		<!--  get(i)でCorrect_anser_listの要素を増やす
		 -->
		<input type="hidden"name="answer_id" value="<%=Correct_anser_list.get(i).getId()%>" >
		<% }%> 
		</div>
		<!-- jsの方でテーブルを取得した値をjspに渡す -->
		<!-- border="1"は罫線 -->
		<!-- jsの方でテーブルを取得した値をjspに渡す -->
		<!-- border="1"は罫線 -->
		<table id="answer_text" border="1">
		

		</table>
		</div>
		<div class="center">
		
		
		<!-- type="submit"では送信ボタンとしての機能、value="確認"で初期値を指定している-->
		<!-- <input type="submit" name="edit_prm_confirm" value="確認" > -->
		<!-- type="submit"では送信ボタンとしての機能、value="戻る"で初期値を指定している-->
		<!-- <input type="submit" name="edit_prm_confirm" value="戻る" >  -->
		<button type="submit"name="edit_prm_confirm" value="確認">確認</button>
		
		</div>
</form>
<form action="List_Connection" method="post">
<div class="center">
	<button type="submit" name="edit_prm_confirm" value="戻る">戻る</button>
</div>
</form>
<div class="deploy">
	<!-- 追加ボタンで表示onclickイベント設定 -->
	<button type="submit" class="boxA" id="coladd" onclick="coladd()">追加</button>
</div>
</body>
</html>