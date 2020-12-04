<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>​
<!DOCTYPE html>
<html>
<head>
<title>SHOW USER</title>
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
	<h1>SHOW USER</h1><br>
	<label>SEARCH</label>
	<form action="user/search.htm" modelAtribute="user"  >
	
	
		<table class="table table-hover" border="1" width="100%">
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Fullname</th>				
				<th>UPDATE</th>
				<th>DELETE</th>				

			</tr>
			<c:forEach var="u" items="${users}">
				<tr>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td>${u.fullname}</td>					
					<td><a href="user/${u.username}update.htm">Sửa</a></td>
					<td><a href="user/${u.username}delete.htm">Xóa</a></td>
					
				</tr>
			</c:forEach>
		</table>
		</form>
		<h4> <a href="user/insert.htm"><button>+</button></a> Bạn có muốn thêm mới???</h4>
	






</body>
</html>