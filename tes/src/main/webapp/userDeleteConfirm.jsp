<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- java.util.ArrayLisクラスをインポートする -->
<%@ page import="java.util.ArrayList"%>
<!-- tes.UsersBeanクラスをインポートする -->
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

<body>

<%UsersBean userBean = (UsersBean)request.getAttribute("UsersBean"); %>

<script src="item.js"></script>
   <p></p>
<form action="UserDelete"method="post">
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
管理者
<!-- UsersList.jspでcheckされた値を1なら「あり」それ以外は「なし」で表示 -->
<% if (userBean.getAdminflag() == 1) { %>
<input type="text"name="admin_flag"class="boxA"readonly="readonly"value=あり >
<% } else { %>
    <input type="text"name="admin_flag"class="boxA"readonly="readonly"value=なし>
<% }%>
</p>
</div>
<div class="center">
<!-- type="submit"では送信ボタンとしての機能、onClick="return DeleteCheck()"でUserDeleteCheck.jsで行った処理が実行される-->
<button type="submit">削除</button>

</div>
</form>
<form action="UserConnection"method="post">
<div class="center">
<!-- type="submit"では送信ボタンとしての機能-->
<button type="submit"name="pram_delete">戻る</button>

</div>
</form>
</body>
</html>

