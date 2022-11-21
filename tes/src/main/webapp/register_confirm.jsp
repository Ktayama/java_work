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
<body>
<!-- Rigister.jspからの入力されたパラメーターをString型の変数に取得する -->
<%String questions_text = (String)request.getAttribute("Qusertions_text");%>
<!-- Rigister.jspからの入力されたパラメーターをstring[]型の変数に取得する -->
<%String[] answer_text = (String[])request.getAttribute("Correct_anser_text[]");%>
<%String a_text = (String)request.getAttribute("a_text"); %>

<form action="Register_Confirm_item" method="post"> 

<label><% if (a_text != null) { %>
		 <div><%= a_text%></div>
		 <% } %></label>
	<div class="boxwrap">	 
		 <div class="questionDeploy">
		 <p><br><font size="5">問題</font>
		 <!-- type="text"でテキストボックスを生成している。value="questions_text"ではRigsterで入力の値を表示 -->
		 <br><input type="text"name=question class="box11"readonly="readonly" value="<%=questions_text%>">
		 </div>
		 <!-- //lengthで -->
		  <div class="deploy">
		 <!-- 配列の要素数分ループ -->
		 <%for (int i = 0; i < answer_text.length; i++) 
			{%>
			<!-- type="textでテキストボックスを生成している。value="answer_text[i]"ではRigsterで入力値を表示また追加した答えも表示 -->
			 <label>答え :</label><input type="text"name=answer class="boxA" readonly="readonly"value="<%=answer_text[i]%>" ><br>
			<% }%> 
			</div>
		 <!-- type="submit"では送信ボタンとしての機能、value="登録"で初期値を指定している-->
		 <!-- エラーメッセージがなければボタンを消す -->
		 <div class="center">
		
		 <%if (a_text == null) { %>
		 		<!-- <input type="submit" name="prm_confirm" value="登録" > -->
		 		<button type="submit"name="prm_confirm" value="登録">登録</button>
		
		 <%  } %>
		  <button type="submit"name="prm_confirm" value="戻る">戻る</button>
		 <!-- type="submit"では送信ボタンとしての機能、value="戻る"で初期値を指定している-->
		 <!-- <input type="submit" name="prm_confirm" value="戻る" > -->
		 </div>
	</div>
</form>



</body>
</html>