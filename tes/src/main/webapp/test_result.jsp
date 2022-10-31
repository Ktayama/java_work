<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%int user = (int)request.getAttribute("GetName");%>
<%int questions_id = (int)request.getAttribute("Question_cnt");%>
<%int point = (int)request.getAttribute("Point");%>
<%int result = (int)request.getAttribute("Result");%>
<%String date = (String)request.getAttribute("Date");%>


<form action="Test_result_item" method="post"><br>

		<input type="submit"name="prm_result"value="top">
		<input type="submit"name="prm_result"value="logout">
		
		<input type="text"size="100"value="テスト結果">
		
		<input type="text"name="uesrs"value="<%=user%>+さん;"><br>
		<input type="text"name="question_point"value="<%=questions_id%>+問中+<%=point%>+問正解です。;"><br>
		<input type="text"name="result"value="<%=result%>+点でした;"><br>
		<input type="text"name="dete"value="<%=date%>"><br>
		
		<input type="submit"name="prm_result"value="history">
		
</form>
</body>
</html>