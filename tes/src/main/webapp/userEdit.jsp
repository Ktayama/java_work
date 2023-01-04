<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tes.UsersBean"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="answerList.css">
<link rel="stylesheet" href="common_center.css">
<link rel="stylesheet" href="questions_border.css">
<link rel="stylesheet" href="wrap.css">
<script src="UserEditCheck.js"></script>
<body>

<!-- UserConnectionからのパラメータをArrayList<UsersBean>型の変数に取得する -->
<%UsersBean userBean = (UsersBean)request.getAttribute("UsersBean"); %>

<script src="item.js"></script>
   <p></p>
   
<form action="UserEditItem"method="post"name="form">
<div class="boxwrap">

<p>
番号
<!--番号をtextで入力欄を作成し中にUsersBean変数のidの値を表示させる -->
<input type="text"name="userId"class="boxA"readonly="readonly"value=<%=userBean.getId()%>>
</p>
<p>
ユーザー名
<!--ユーザ名をtextで入力欄を作成し中にUsersBean変数のnameの値を表示させる  -->
<input type="text"name="userName"class="boxA"readonly="readonly"value="<%=userBean.getName() %>">
</p>
<p>
PW
<!--パスワード入力欄作成し中にUsersBean変数のpasswordの値を表示させる  -->
<input type="password"name="userPass" class="boxA"value="<%=userBean.getPassword() %>">
</p>
<p>
<!--パスワードの確認用に入力欄作成し中にUsersBean変数のpasswordの値を表示させる  -->
PW再確認
<input type="password" name="userPassCheck"class="boxA"value="<%=userBean.getPassword()%>">
</p>
<p>
管理者
<!-- UsersList.jspでcheckされた値を1なら「あり」それ以外は「なし」で表示 -->
<% if (userBean.getAdminflag() == 1) { %>
<input type="checkbox"name="admin_flag"class="boxA"value=<%=userBean.getAdminflag() %> checked="checked">
<% } else { %>
    <input type="checkbox"name="admin_flag"class="boxA"value=<%=userBean.getAdminflag()%>>
<% }%>
</p>
</div>
<div class="center">
<!-- type="submit"では送信ボタンとしての機能、onClick="return EditCheck()"でUserEditCheck.jsで行った処理が実行される-->
<button type="submit"onClick="return EditCheck();">確認</button>

</div>
</form>
<form action ="UserConnection"method="post">
<div class="center">
<!-- type="submit"では送信ボタンとしての機能-->
<p><button type="submit"name="prm">戻る</button></p>
</div>
</form>
</body>
</html>