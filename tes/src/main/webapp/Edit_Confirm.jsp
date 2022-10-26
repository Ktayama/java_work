<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Edit.jspから入力されたパラメータをString型の変数に取得する -->
<%String questions = (String)request.getAttribute("Questions");%>
<!-- Edit.jspから入力されたパラメータをString[]型の変数に取得する -->
<%String[] answer = (String[])request.getAttribute("Answer[]");%>
<!-- Edit.jspから取得された問題番号のパラメータをString型の変数に取得する -->
<%String questions_id = (String)request.getAttribute("Questions_id");%>
<!-- Edit.jspから取得された答え番号のパラメータをString型の変数に取得する -->
<%String[] answer_id = (String[])request.getAttribute("Answer_id[]");%>
<%String a_text = (String)request.getAttribute("a_text"); %>

<form action="Edit_Confirm_item" method="post"> 
	 </label><% if (a_text != null) { %>
		 <div><%= a_text%></div>
		 <% } %></div><br>
		  <!-- type="text"でテキストボックスを生成している。value="questions"ではEditで入力の値を表示 -->
		 <label>問題 :</label><input type="text"name=edit_questions value="<%=questions%>"><br>
		  <!-- hiddenで隠して渡したいパラメータを設定する。value="questions_id"では問題のidを指定している -->
		  <input type ="hidden" name="edit_questions_id" value=<%=questions_id %>>
		 <%//lengthで %>
		 <!-- 答えの配列の要素数分ループ -->
		 <%for (int i = 0; i < answer.length; i++) 
			{%>
			<!-- type="textでテキストボックスを生成している。value="answer[i]"ではEditで入力値を表示また追加した答えも表示 -->
			 <label>答え :</label><input type="text"name=edit_answer value="<%=answer[i]%>" ><br>
			   <!-- hiddenで隠して渡したいパラメータを設定する。value="answer_id[i]"では答えのidを指定している -->
			 <input type="hidden"name=edit_answer_id value="<%=answer_id[i]%>" >
		<% }%>
		 
		<!-- type="submit"では送信ボタンとしての機能、value="更新"で初期値を指定している-->
		 <input type="submit" name="prm_edit_confirm" value="更新" >
		 <!-- type="submit"では送信ボタンとしての機能、value="戻る"で初期値を指定している-->
		 <input type="submit" name="prm_edit_confirm" value="戻る" >
		 
</form>



</body>
</html>