<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録結果</title>
</head>
<body>
<%-- c:if でJSTLを使用したif文が記述できる --%>
<%-- NULLまたはブランクを検出する empty 演算子が使用可能 --%>
<c:if test="${!empty errorMsg}">
	<h1>エラーが発生しました</h1>
<%-- c:out　にて出力するとHTMLのタグエスケープなどを実施し無害化してくれる --%>
	<h2><c:out value="${errorMsg}"/></h2>
</c:if>
<c:if test="${empty errorMsg}">
	<h1>以下の情報を登録しました</h1>
	<h2>名前：</h2>
<%-- EL式で記述する場合、ページ～アプリケーションスコープの変数を名前で探しに行く。uInputはリクエストスコープ --%>
	<h3>${uInput.name}</h3>
	<h2>住所：</h2>
<%-- メソッドを多く持つfunctionsにはArrasy.join()に代わるjoin()等メソッドが多く存在する --%>
	<h3>${fn:join(uInput.addr,'</br>') }</h3>
	<h2>性別：</h2>
<%-- eq(equals)演算も存在し三項分岐が記載できる --%>
	<h3>${'0' eq uInput.gender ? '男性':'女性'}</h3>
</c:if>
	<h5>現在処理時刻</h5>	
	<%-- Dateクラスのインスタンスを新規に生成し、現在のスコープ上のJavaBeansとして登録 --%>
	<jsp:useBean id="now" class="java.util.Date" />
	<h6><fmt:formatDate value="${now}" pattern="yyyy年MM月dd日（E） a KK時mm分ss秒" /></h6>
</body>
</html>