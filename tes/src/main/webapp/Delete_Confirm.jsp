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
<body>

<%
QuestionsBean questionsBean = (QuestionsBean)request.getAttribute("Questions_list");
%>
<%ArrayList<Correct_answersBean> Correct_answer_list = (ArrayList<Correct_answersBean>)request.getAttribute("Answers_list");%>


<form action="./Delete_Confirm_item" method="post"> 

		<label>番号<%=questionsBean.getId()%></label>	<br>
		
		<label>問題 :</label><input type="text"name=delete_questions value="<%=questionsBean.getQuestion()%>"><br>
		<input type="hidden" name="delete_questions_id" value="<%=questionsBean.getId()%>">
		
		<%int question_no =0; %>
		
		<%for (int i = 0; i < Correct_answer_list.size(); i++) 
			{%>               
		
		<label>答え :</label><input type="text"name="delete_answers" value="<%=Correct_answer_list.get(i).getAnswer()%>" ><br>         
		
		<input type="hidden"name="delete_answers_id" value="<%=Correct_answer_list.get(i).getId()%>" >
		<% }%> 
		
		<input type="submit" name="delete_prm_confirm" value="削除" >
		<input type="submit" name="delete_prm_confirm" value="戻る" >
		
</form>

</body>
</html>