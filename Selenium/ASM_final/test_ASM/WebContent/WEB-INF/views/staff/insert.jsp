
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8" />
<title>UPDATE STAFF</title>
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
	<h1>UPDATE STAFF</h1>
	<h2>${message}</h2>
	<form:form action="staff/insert.htm" modelAttribute="staff" >
		<div>
			<label>ID :</label>			
			<form:input path="id"/>
			<form:errors path="id"/>	
		
		</div>			
		<div>
			<label>Name :</label>
			<form:input path="name" />
			<form:errors path="name"/>
			
		</div>
		<div>
			<label>Gender :</label>
			<form:radiobutton path="gender" value="true" label="Nam"/>
		<form:radiobutton path="gender" value="false" label="Nữ"/>
		</div>				
		<div>
			<label>Birthday :</label>
			<form:input path="birthday" placeholder="MM/dd/yyyy"/> 	
			${message}
		</div>		
		<div>
			<label>Photo :</label>			
				<form:input type="file" path="photo"/>	
				<form:errors path="photo"/>
				
		</div>		
		<div>
			<label>Email :</label>
			<form:input path="email" />
			<form:errors path="email"/>
		</div>		
		<div>
			<label>Phone :</label>
			<form:input path="phone" />
			<form:errors path="phone"/>
		</div>		
		<div>
			<label>Salary :</label>
			<form:input path="salary" />
			<form:errors path="salary"/>
		
		</div>		
		<div>
			<label>Notes :</label>
			<form:input path="notes" />
		</div>		
		<div>
			<label>Depart Name :</label> <hr>
			<form:select path="depart.id"
	items="${departs}" itemValue="id" itemLabel="name"/> <br>
		</div>			
		<div id="registerbtn">
			<button type="submit" name="btnInsert">Insert</button> <br>
		</div>
	</form:form>	
	
	<a href="staff/index.htm">Bấm để quay lại trang chủ</a>
</body>
</html>