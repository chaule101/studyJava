<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>​
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<title>SHOW STAFF</title>
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
	img{
	width: 60px;
	}
	

</style>
</head>
<body>
	<h1>SHOW STAFF</h1><br>
	<form action ="staff/insert.htm" enctype="multipart/form-data">
		<table class="table table-hover" border="1" width="130%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Birthday</th>	
				<th>Photo</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Salary</th>	
				<th>Notes</th>	
				<th>DepartID</th>	
				<th>UPDATE</th>				
				<th>DELETE</th>				

			</tr>
			
			<c:forEach var="s" items="${staffs}">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.gender?'Nam':'Nữ'}</td>
					<td>${s.birthday}</td>
					<td><img src="files/${s.photo}"></td>
					<!-- > 
					<td>${s.photo}</td>
					-->
					<td>${s.email}</td>
					<td>${s.phone}</td>
					<td><f:formatNumber value="${s.salary }"
									type="currency" /></td>
					
					<td>${s.notes}</td>
					<td>${s.depart.name}</td>
							
					<td><a href="staff/${s.id}update.htm">Sửa</a></td>
					<td><a href="staff/${s.id}delete.htm">Xóa</a></td>
					
				</tr>
			</c:forEach>
		
		</table>
		</form>
		<h4><a href="staff/report.htm">Xem Thành Tích</h4></a>
		<h4> <a href="staff/insert.htm"><button>+</button></a> Bạn có muốn thêm mới???</h4>
	






</body>
</html>