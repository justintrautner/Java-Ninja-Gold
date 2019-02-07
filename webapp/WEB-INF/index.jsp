<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body>
	<h3>Your Gold: <c:out value="${ gold }"/> </h3>
	<h3>High score: <c:out value="${ max }"/></h3>

<div class="row">
<div class="col-md-3">
	<form method="post" action="/farm">
	<h3>Farm</h3>
	<p>Earns 10-20 gold</p>
	<input type="submit">
	</form>
	</div>
	<div class="col-md-3">
	<form method="post" action="/cave">
	<h3>Cave</h3>
	<p>Earns 5-10 gold</p>
	<input type="submit">
	</form>
	</div>
	<div class="col-md-3">
	<form method="post" action="/house">
	<h3>House</h3>
	<p>Earns 2-5 gold</p>
	<input type="submit">
	</form>
	</div>
	<div class="col-md-3">
	<form method="post" action="/casino">
	<h3>Casino</h3>
	<p>Earns/Takes 0-50 gold</p>
	<input type="submit">
	</form>
	</div>
	</div>
	

	<c:forEach items="${activity}" var="act">
	<p><c:out value="${act}"/></p>
	</c:forEach>
	
	
</body>
</html>