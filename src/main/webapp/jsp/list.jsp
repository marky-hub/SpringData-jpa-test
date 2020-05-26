<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers List</title>
</head>
<body>
	<h2>ข้อมูลลูกค้า</h2>
	<table border="1">
		<tr>
			<th>รหัส</th>
			<th>ชื่อ</th>
			<th>นามสกุล</th>
			<th></th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.id}</td>
				<td><a href="/customer/${customer.id}">${customer.firstName}</a></td>
				<td>${customer.lastName}</td>
				<td><a href="/customer/editform/${customer.id}">แก้ไข</a> <a
					href="/customer/delete/${customer.id}">ลบ</a></td>
		</c:forEach>
	</table>
</body>
</html>