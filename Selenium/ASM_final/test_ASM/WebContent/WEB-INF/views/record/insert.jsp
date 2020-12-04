<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	padding: 15px;
}
</style>
</head>
<body>
	<form:form action="record/insert.htm" modelAttribute="record">
		<div>
			<label>Nhân viên</label>
			<form:select path="staff.id" items="${staffs}" itemValue="id"
				itemLabel="name"/>
		</div>
		<div>
			<label>Loại</label>
			<form:radiobuttons path="type" items="${types}"/>
			
		</div>
		<div>
			<label>Lý do</label>
			<form:textarea path="reason" rows="3"/>
		</div>
		<div>
			<button>Insert</button>
		</div>
	</form:form>


</body>
</html>