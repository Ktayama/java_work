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
<!-- UsersRigister.jspからの入力されたパラメーターを各々取得して格納させる-->
<%String userName=(String)request.getAttribute("UserName");%>
<%String userPass=(String)request.getAttribute("UserPass");%>
<%String userPassCheck=(String)request.getAttribute("UserPassCheck");%>
<%byte adminFlag =(byte)request.getAttribute("AdminFlagByte");%>

<script src="item.js"></script>
   <p></p>
<form action="UserRegisterConfirmItem" method="post">
<div class="boxwrap">
	<p>
	ユーザ名
	<!--ユーザ名をtextで入力欄を作成し中にUsersReigsterで入力された値を表示  -->
	<input type="text"name="userName"class="boxA"readonly="readonly"value="<%=userName%>">
	</p>
	<p>
	PW
	<!-- パスワード入力欄作成し中にUsersReigsterで入力された値を表示  --> 
	<input type="password"name="userPass"class="boxA"readonly="readonly"value="<%=userPass%>">
	</p>
	<p>
	PW確認
	<!-- パスワードの再確認用に入力欄を作成し中にUsersReigsterで入力された値を表示 -->
	<input type="password"name="userPassCheck"class="boxA"readonly="readonly"value="<%=userPassCheck%>">
	</p>
	<p>
	<!-- UsersRegister.jspでcheckされた値を「あり」か「なし」で表示 -->
	管理者<input type="text"name="adminFlag"class="boxA"readonly="readonly"value="<%if(adminFlag ==1) {%>あり<%}else{%>なし<% }%>">
	</p>
</div>
<div class="center">
	<!-- type="submit"では送信ボタンとしての機能-->
	<p><button type="submit"name="prm_confirm"value="登録">登録</button></p>
	
	<button type="submit"name="prm_confirm"value="戻る">戻る</button>
</div>	
</form>

</body>
</html>
