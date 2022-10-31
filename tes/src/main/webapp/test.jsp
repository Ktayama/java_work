<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- java.util.ArrayListクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- QuestionBeanクラスをインポートする -->
<%@ page import="tes.QuestionsBean"%>
<!-- Correct_answersBeanクラスをインポートする -->
<%@ page import="tes.Correct_answersBean"%>

<%ArrayList<QuestionsBean> Question_list = (ArrayList<QuestionsBean>)request.getAttribute("Qusertions_list");%>
<!-- List.javaからのパラメータをArrayList<Correct_answersBaen>型の変数に取得する -->
<%ArrayList<Correct_answersBean> Correct_answer_list = (ArrayList<Correct_answersBean>)request.getAttribute("Correct_anser_list");%>
  
  
 
<form action="./Test_item" method="post">

<!-- int型でquestion_no = 0の値を定義 -->
<%int question_no =0;%>
<!--Question_listの件数分のループ  QuestionBean型の変数にQuestion_listのn番目を取得 -->
<%for (QuestionsBean questionsBean : Question_list) {%>
<!-- question_noを一軒ずつ数字を増やしてる -->
	<%question_no =question_no +1;%>
<!-- 問題数字を定義している -->
<!-- value="questionsBean.getQuestion()"のvalueで問題文を初期値に指定している -->

		
		
	<p><%=question_no%>：<br><input type="text" name="" value="<%=questionsBean.getQuestion()%>"></p>
	<input type="hidden" name="questions_id" value="<%=questionsBean.getId()%>">
		<!-- int型でanswer_noを値を0に定義 -->
		<%int answer_no =0;%>
		<!-- listは0からだから1番目からCorrect_anser_listをloopして一件づつ表示させる -->
		<!-- size()でCorrect_anser_listの要素数を調べている -->
		
		
		
		
		<!-- 答えのanswer_noが1づつ増える -->
		<!-- value="correct_answersBaen.getAnswer()"の答え文を初期化値に指定 -->
		<p>回答<br><input type="text"name="correct_answer"></p>
		<%} %>
		<p>回答<br><input type="submit"name="Test_result"value="採点"></p>
</form>
</body>
</html>