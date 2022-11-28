<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">

<title>Insert title here</title>
</head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="answerList.css">
<link rel="stylesheet" href="common_center.css">
<link rel="stylesheet" href="questions_border.css">
<link rel="stylesheet" href="wrap.css">
<body>
<!-- java.util.ArrayListクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- QuestionBeanクラスをインポートする -->
<%@ page import="tes.QuestionsBean"%>
<!-- Correct_answersBeanクラスをインポートする -->
<%@ page import="tes.Correct_answersBean"%>

<!-- リクエストスコープからエラーメッセージを受け取る -->
<%String failureMessage = (String)request.getAttribute("loginFailure");%> 
<!-- List.javaで定義した値をgetAttributeでQusertions_listを取得してArrayList<QuestionBean> Question_listに代入している -->
<!-- List.javaからのパラメータをArrayList<QuestionBean>型の変数に取得する -->
<%ArrayList<QuestionsBean> Question_list = (ArrayList<QuestionsBean>)request.getAttribute("Qusertions_list");%>
<!-- List.javaからのパラメータをArrayList<Correct_answersBaen>型の変数に取得する -->
<%ArrayList<Correct_answersBean> Correct_anser_list = (ArrayList<Correct_answersBean>)request.getAttribute("Correct_anser_list");%>



<!-- エラーメッセージが存在するときだけ表示する -->
<%if (failureMessage != null) {%>
	<%=failureMessage%>
<%}%>
  
  <script src="item.js"></script>
   <p></p>
<form action="./List_item" method="post">
<!-- hiddenで隠して渡したいパラメータを設定する -->
<!-- valueで1の初期値をしている -->

	<input type="hidden" name="parem" value="1">
	<!-- sumbitでは送信ボタンとしての機能、value="新規登録" で初期値を指定している-->
		<div class="buttonA">
		
		<button type="submit">新規登録</button>
		
		</div>
	<%//<input type="submit" value="新規登録"> %>
</form>


<!-- int型でquestion_no = 0の値を定義 -->
<%int question_no =0;%>

<!--Question_listの件数分のループ  QuestionBean型の変数にQuestion_listのn番目を取得 -->
<%for (QuestionsBean questionsBean : Question_list) {%>

<!-- question_noを一軒ずつ数字を増やしてる -->
	<%question_no =question_no +1;%>
<!-- 問題数字を定義している -->
<!-- value="questionsBean.getQuestion()"のvalueで問題文を初期値に指定している -->
<div class="boxwrap">
	<div class="questionDeploy">
	<p><font size="5"> 問題</font></p>
	<font size="4"><%=question_no%>：</font><input type="text" readonly="readonly"class="box11" value="<%=questionsBean.getQuestion()%>">
	
	</div>
	
	<div class="deploy">
	<!-- int型でanswer_noを値を0に定義 -->
	<%int answer_no =0;%>
	<!-- listは0からだから1番目からCorrect_anser_listをloopして一件づつ表示させる -->
	<!-- size()でCorrect_anser_listの要素数を調べている -->
	
	<%for (int i = 0; i < Correct_anser_list.size(); i++) {%>
	
		<!-- Correct_answersBean型の変数にCorrect_answer_listを取得している -->
		<!-- get(i)でCorrect_anser_listの要素を増やす -->
		<%Correct_answersBean  correct_answersBaen =  Correct_anser_list.get(i);%>
		<!-- questionsBean型のidとcorrect_answersBeanのQuestion_idが等しいとき -->
		<%  if (questionsBean.getId()==correct_answersBaen.getQuestion_id()){%>
			<%answer_no = answer_no +1; %>
		<!-- 答えのanswer_noが1づつ増える -->
		<!-- value="correct_answersBaen.getAnswer()"の答え文を初期化値に指定 -->
		<p>答え：<%=answer_no %><br><input type="text"readonly="readonly"class="boxA" value="<%=correct_answersBaen.getAnswer()%>"></p>
		<%} %>
	<%} %>
	</div>
</div>

<div class="center">
<form action="List_item" method="post">
<!-- hiddenで隠して渡したいパラメータを設定する -->
<!-- valueで2の初期値をしている -->
	<input type="hidden" name="parem" value="2">
	<!--  submitでは送信ボタンとしての機能、value="編集"で初期値を指定している -->
		
		
		<button type="submit">編集</button>
		
		
	<%//<input type="submit" value="編集"><br> %>
	<!-- value="questionsBean.getId()"で問題文の番号をとっている -->
	
	<input type="hidden" name="questions_id" value="<%=questionsBean.getId()%>">
		
</form>
<form action="List_item" method="post">
<!-- hiddenで隠して渡したいパラメータを設定する -->
<!-- valueで3の初期値をしている -->
	<input type="hidden" name="parem" value="3">
	<!--  submitでは送信ボタンとしての機能、value="削除"で初期値を指定している -->
		
		
		<button type="submit">削除</button>
		

	<%//<input type="submit" value="削除"> <br> %>
	<input type="hidden" name="questions_id" value="<%=questionsBean.getId()%>">
</form>
</div>
<%} %>


</body>
</html>