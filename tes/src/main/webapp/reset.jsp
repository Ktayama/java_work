<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="reset.css">
<body>
<h2>リセット前</h2>
<div>
  <a href="#">リンク</a>
</div>
<div>
  <button>ボタン要素</button>
</div>
<div>
  <input type="button" value="ボタン">
</div>
<div>
  <input type="submit" value="送信ボタン">
</div>
<div>
  <input type="reset" value="リセットボタン">
</div>

<h2>リセット後</h2>
<div>
  <a href="#" class="reset">リンク</a>
</div>
<div>
  <button class="reset">ボタン要素</button>
</div>
<div>
  <input type="button" class="reset" value="ボタン">
</div>
<div>
  <input type="submit" class="reset" value="送信ボタン">
</div>
<div>
  <input type="reset" class="reset" value="リセットボタン">
</div>
</body>
</html>