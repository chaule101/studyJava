<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8" />
<title>ADD USER</title>
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
	<h1>ADD USER</h1>
	
	<form:form action="user/insert.htm" modelAttribute="user">
		<div >
			<label>Username</label>
			<form:input class="name" path="username" name="userName" /><br>
			<form:errors class="error_name" path="username"/> 
			
			
		</div>
		
		<div>
			<label>Password</label>
			<form:input class="pass" path="password" />
			<form:errors class="error_pass" path="password"/> 
			
		</div>
		<div>
			<label>Fullname</label>
			<form:input class="full_name" path="fullname"  />
			<form:errors class="error_fullname" path="fullname"/> 
		</div>
		<div>
			<button class="btn btn-default" name="btnInsert">Insert</button>
		</div>
	</form:form>
	<h2>${message}</h2>
	<a href="user/index.htm">Bấm để quay lại trang chủ</a>
</body>
</html>