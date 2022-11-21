<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="wrap.css">
<link rel="stylesheet" href="common_center.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<body>

<%String user = (String)request.getAttribute("GetName");%>
<%int questions_id = (int)request.getAttribute("Question_cnt");%>
<%int point = (int)request.getAttribute("Point");%>
<%int result = (int)request.getAttribute("Result");%>
<%String date = (String)request.getAttribute("Date");%>



<form action="Test_result_item" method="post"><br>

 <script src="item.js"></script>
<div class="boxwrap">
		
		<h2 >テスト結果</h2><br>
		
		<div class="wrap pattern-1 mgb-20" > <%=user%>さん</div><br>
		<div class="result pattern-2 mgb-10"><%=questions_id%>問中<%=point%>問正解です。<br>
		<%=result%>点でした<br></div>
		<div class="time pattern-4"><%=date%></div><br>
		
</div>

<div class="center">
		
		<input type="hidden" name="prm_result"value="3">
		<!-- <input type="submit"value="history"> -->
		<button type="submit">history</button>
</div>		
</form>
</body>
</html>