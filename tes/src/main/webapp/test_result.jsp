<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String user = (String)request.getAttribute("GetName");%>
<%int questions_id = (int)request.getAttribute("Question_cnt");%>
<%int point = (int)request.getAttribute("Point");%>
<%int result = (int)request.getAttribute("Result");%>
<%String date = (String)request.getAttribute("Date");%>


<form action="Test_result_item" method="post">
		
		<input type="hidden" name="prm_result"value="1">
		
		
		<input type="submit" value="top">
</form>
<form action="Test_result_item">
		
		<input type="hidden" name="prm_result"value="2">
		
		<input type="submit" value="logout"><br>
		
</form>

<form action="Test_result_item" method="post"><br>
		
		テスト結果<br>
		
		<%=user%>さん<br>
		<%=questions_id%>問中<%=point%>問正解です。<br>
		<%=result%>点でした<br>
		<%=date%><br>
		
		<input type="hidden" name="prm_result"value="3">
		<input type="submit"value="history">
		
</form>
</body>
</html>