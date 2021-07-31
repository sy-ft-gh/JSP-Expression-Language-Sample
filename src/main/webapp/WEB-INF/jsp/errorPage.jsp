<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>エラー発生</title>
	</head>
	<body>
		<p>
			エラーが発生しました。再度実行してください。
		</p>
		<p><%= request.getAttribute("msg") %></p>
		<a href="<%= request.getContextPath() %>/formSample.html">戻る</a>
	</body>
</html>