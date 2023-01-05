<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<%String userId =(String)request.getAttribute("UserId"); %>
<%String userName=(String)request.getAttribute("UserName");%>
<%String userPass=(String)request.getAttribute("UserPass");%>
<%String userPassCheck=(String)request.getAttribute("UserPassCheck");%>
<%byte adminFlag =(byte)request.getAttribute("AdminFlagByte");%>


<form action="UserEdit" method="post">
<script src="item.js"></script>
   <p></p>
<div class="boxwrap">
	<p>
	ID
	<!--IDをtextで入力欄を作成し中にUsersEditで入力された値を表示  -->
	<input type="text"name="userId"class="boxA"readonly="readonly"value="<%=userId%>">
	</p>
	<p>
	ユーザ名
	<!--ユーザ名をtextで入力欄を作成し中にUsersEditで入力された値を表示  -->
	<input type="text"name="userName"class="boxA"readonly="readonly"value="<%=userName%>">
	</p>
	<p>
	PW
	<!--パスワード入力欄を作成し中にUsersEditで入力された値を表示  -->
	<input type="password"name="userPass"class="boxA"readonly="readonly"value="<%=userPass%>">
	</p>
	<p>
	PW確認
	<!--パスワードの確認用に入力欄を作成し中にUsersEditで入力された値を表示  -->
	<input type="password"name="userPassCheck"class="boxA"readonly="readonly"value="<%=userPassCheck%>">
	</p>
	<p>
	<!-- UsersRegister.jspでcheckされた値を「あり」か「なし」で表示 -->
	管理者<input type="text"name="adminFlag"class="boxA"readonly="readonly"value="<%if(adminFlag ==1) {%>あり<%}else{%>なし<% }%>">
	</p>
	</div>
<div class="center">
	<!-- type="submit"では送信ボタンとしての機能-->
	<p><button type="submit"name="prm_edit_confirm"value="更新">更新</button></p>
	
	
</div>	
</form>
<form action="UserEditConncetion" method="post">
	<div class="center">
	<button type="submit"name="prm_edit_confirm"value="戻る">戻る</button>
	<input type="hidden"name="user_id"value="<%=userId%>">
	</div>
</form>
</body>
</html>