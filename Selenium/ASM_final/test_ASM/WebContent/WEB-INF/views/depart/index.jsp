<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>​
<!DOCTYPE html>
<html>
<head>
<title>SHOW DEPART</title>
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
	<h1>SHOW DEPART</h1><br>
	<form action="depart/index.htm">
		<table class="table table-hover" border="1" width="100%">
			<tr>
				<th>ID DEPART</th>
				<th>DEPART NAME</th>								
				<th>UPDATE</th>
				<th>DELETE</th>				

			</tr>
			<c:forEach var="d" items="${departs}">
				<tr>
					<td>${d.id}</td>
					<td>${d.name}</td>
									
					<td><a href="depart/${d.id}update.htm">Sửa</a></td>
					<td><a href="depart/${d.id}delete.htm">Xóa</a></td>
					
				</tr>
			</c:forEach>
		</table>
		 </form>
		<h4> <a href="depart/insert.htm"><button>+</button></a> Bạn có muốn thêm mới???</h4>
	






</body>
</html>