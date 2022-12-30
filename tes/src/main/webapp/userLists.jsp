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
<!-- java.util.ArrayListクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- UsersBeanクラスをインポートする -->
<%@ page import="tes.UsersBean"%>

<!-- リクエストスコープからエラーメッセージを受け取る -->
<%String failureMessage = (String)request.getAttribute("loginFailure");%> 

<!-- UserConnectionからのパラメータをArrayList<UsersBean>型の変数に取得する -->
<%ArrayList<UsersBean> usersList = (ArrayList<UsersBean>)request.getAttribute("UsersList"); %>
<%System.out.println((ArrayList<UsersBean>)request.getAttribute("UsersList")); %>

<!-- エラーメッセージが存在するときだけ表示する -->
<%if (failureMessage != null) {%>
	<%=failureMessage%>
<%}%>
<script src="item.js"></script>
   <p></p>
<form action="./UserItem" method="post">
<!-- hiddenで隠して渡したいパラメータを設定する -->
<input type="hidden" name="parem"value="1">
	<!-- sumbitでは送信ボタンとしての機能 -->
	<div class="buttonA">
		<button type="submit">新規登録</button>

	</div>
</form>
<!--usersListの件数分のループ -->
<%for (UsersBean usersBean : usersList) {%>
<div class="boxwrap">
	<div class="questionDeploy">
		<!-- usersBean変数のuseridの値を表示させる -->
		<p><font size="4">ID:<%=usersBean.getId()%></font></p>
		
		<!-- usersBean変数のadminflagの値が1なら管理者、それ以外は一般を表示させる -->
		<% if(usersBean.getAdminflag()==1){%>
		<font size="3">管理者:</font> 
		 <%}else{%>
		<font size="3"> 一般:</font>
		 <%} %>
		<!-- usersBean変数のnameの値を表示させる -->
		<font size="5"><%=usersBean.getName()%></font>
	</div>
</div>	
<div class="center">
		<form action="./UserItem" method="post">
			<!-- hiddenで隠して渡したいパラメータを設定する -->
			<input type="hidden" name="parem"value="2">
			<!-- hiddenで渡すuserBean変数のuseridを設定する -->
			<input type="hidden" name="user_id" value="<%=usersBean.getId()%>">
			<!--  submitでは送信ボタンとしての機能 -->
			<button type="submit"> 編集 </button>
		</form>
		
		
		<form action="./UserItem" method="post">
			<!-- hiddenで隠して渡したいパラメータを設定する -->
			<input type="hidden" name="parem"value="3">
			<!-- hiddenで渡すuserBean変数のuseridを設定する -->
			<input type="hidden" name="user_id" value="<%=usersBean.getId()%>">
			<!--  submitでは送信ボタンとしての機能 -->
			<button type="submit">削除</button>
			
		</form>
</div>		
	<%} %>
	
</body>
</html>