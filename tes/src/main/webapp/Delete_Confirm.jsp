<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.QuestionsBean"%>
<%@ page import="tes.Correct_answersBean"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<body>

<%
QuestionsBean questionsBean = (QuestionsBean)request.getAttribute("Questions_list");
%>
<%ArrayList<Correct_answersBean> Correct_answer_list = (ArrayList<Correct_answersBean>)request.getAttribute("Answers_list");%>




<form action="./Delete" method="post">
 <script src="item.js"></script>
<div class="boxwrap">
 <div class="questionDeploy">
		  <!-- type="text"でテキストボックスを生成している。value="questions"ではEditで入力の値を表示 -->
		<p><br><font size="5">問題</font></p>
		<font size="4">番号<%=questionsBean.getId()%></font>
		
		<input type="text"name=delete_questions class="box11" readonly="readonly"value="<%=questionsBean.getQuestion()%>"><br>
		<input type="hidden" name="delete_questions_id" value="<%=questionsBean.getId()%>">
		</div>
		
		<div class="deploy">
		<%int answer_no =0; %>
		
		<%for (int i = 0; i < Correct_answer_list.size(); i++) 
			{%>               
		<%answer_no = answer_no +1;%>
		<p>答え <%=answer_no %><input type="text"name="delete_answers" class="boxA"readonly="readonly"value="<%=Correct_answer_list.get(i).getAnswer()%>" ><br>         
		
		<input type="hidden"name="delete_answers_id" value="<%=Correct_answer_list.get(i).getId()%>" >
		<% }%> 
	</div>
</div>
	
		<div class="center">
		<!-- <input type="submit" name="delete_prm_confirm" value="削除" > -->
		<!-- <input type="submit" name="delete_prm_confirm" value="戻る" > -->
		<button type="submit"name="delete_prm_confirm" value="削除">削除</button>
		
		
		</div>
	
</form>

<form action="./List_Connection" method="post">
	<div class="center">
	
	<button type="submit"name="delete_prm_confirm" value="戻る">戻る</button>
	
	</div>
</form>
</body>
</html>