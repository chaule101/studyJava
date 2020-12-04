<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>​
<!DOCTYPE html>
<html>
<head>
<title>SHOW RECORD</title>
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
	font-size: 13px;
	}
	

</style>
</head>
<body>
	<h1>SHOW RECORD</h1><br>
	
	<form action="record/index.htm">
		<table class="table table-dark">
		<thead>
			<tr>
				<th>ID</th>
				<th>TYPE</th>
				<th>REASON</th>
				<th>DATE</th>
				<th>STAFF-ID</th>
				<th>STAFF-NAME</th>
				
				
				
			</tr>
		
		
			<c:forEach var="r" items="${records}">
				<tr>
					<td>${r.id}</td>
					<td>${r.type}</td>
					
					<td>${r.reason}</td>
					<td>${r.date}</td>					
					<td>${r.staff.id}</td>
					<td>${r.staff.name}</td>
					
					
					
				</tr>
			</c:forEach>
		
		</table>
		

	

	</form>

	<h4> <a href="record/insert.htm"><button>+</button></a> Bạn có muốn thêm mới???</h4>
	<a href="staff/report.htm">Tổng hợp thành tích cá nhân </a>
	
	
	

</body>
</html>