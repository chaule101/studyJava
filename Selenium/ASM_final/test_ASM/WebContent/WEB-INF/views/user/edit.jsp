<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8" />
<title>UPDATE USER</title>
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
	*[id$=errors]{
	color:red;
	font-style: italic;
}

</style>

</head>
<body>
	<h1>UPDATE USER</h1>
	<h2>${message}</h2>
	<form:form action="user/update.htm" modelAttribute="user">
		<div>
			<label>Username</label>
			
			<form:input path="username" readonly="true" />
		 
			
			
		</div>
		
		<div>
			<label>Password</label>
			<form:input path="password" />
			<form:errors path="password"/> 
		</div>
		<div>
			<label>Fullname</label>
			<form:input path="fullname" />
			<form:errors path="fullname"/> 
		</div>
		<div>
			<button type="submit" name="btnUpdate">Update</button>
		</div>
	</form:form>
	
	<a href="user/index.htm">Bấm để quay lại trang chủ</a>
</body>
</html>