<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
</head>
<body>
	<form action="/customer/edit" method="post">
		<input type="hidden" name="id" value="${customer.id}"> 
		ชื่อ :		<input type="text" name="firstName" value="${customer.firstName}"><br>
		นามสกุล : <input type="text" name="lastName"value="${customer.lastName}"><br>
				<input type="submit" value="แก้ไข">
	</form>
</body>
</html>