<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8" />
<title>ADD DEPART</title>
<style>
	h1{
	text-align: center;
	color:orange;
	 border: 2px solid  #CE5454;
	}
	h4{
	color:red;
	font-size: 15px;
	text-decoration: underline;
	}
	table{
	font-size: 12px;
	}

</style>

</head>
<body>
	<h1>ADD DEPART</h1>
	
	<form:form action="depart/insert.htm" modelAttribute="depart">
		<div>
			<label>ID</label>
			<form:input path="id" />
		</div>
		
		<div>
			<label>Depart Name</label>
			<form:input path="name" />
		</div>
		
		<div>
			<button class="btn btn-default">Insert</button>
		</div>
	</form:form>
	<h2>${message}</h2>
	<a href="depart/index.htm">Bấm để quay lại trang chủ</a>
</body>
</html>