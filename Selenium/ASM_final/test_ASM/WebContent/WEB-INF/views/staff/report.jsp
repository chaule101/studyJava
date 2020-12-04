<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<meta charset="UTF-8">
<title>Insert title here</title>
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
<form action ="staff/report.htm">

	<h1>SHOW RECORD BY STAFF-ID</h1><br>
	<table class="table table-dark">
		<tr>
		<thead>
			
			<th>Mã NV </th>	
			<th>Tên NV</th>
			<th>Tổng Kỉ Luật</th>
			<th>Tong Thành Tích</th>
			<th>Tổng Kết</th>
			<th>Quyết Định</th>
		</thead>
		</tr>
	<c:forEach var="a" items="${arrays}">
		<tr>
			<th>${a[0]}</th>
			<th>${a[1]}</th>
			<th>${a[2]}</th>
			<th>${a[3]}</th>			
			<th>${a[3]-a[2]}</th>
			<th>
		<c:choose>
		<c:when test="${a[3]-a[2]>'0'}">
			Thưởng
		
		</c:when>
		<c:when test="${a[3]-a[2]<'0'}">
			Phạt
		
		</c:when>
		
		<c:otherwise>
		Bình thường
		</c:otherwise>
		
		</c:choose>
		</th>
		</tr>
	 </c:forEach>


		
	 
	</table>




 </form>
</body>
</html>