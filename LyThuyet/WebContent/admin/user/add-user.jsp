<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form html</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<jsp:include page="../menu.jsp" />
			</div>
			<div class="col-md-8">
				<form action="/LyThuyetTongHop/admin/user/add" method="post">
					<div class="form-group">
						<label>Ten:</label> <input class="form-control" type="text"
							name="name" placeholder="Nhap ten">
					</div>
					<div class="form-group">
						<label>Tuoi:</label> <input class="form-control" type="number"
							name="age" placeholder="Nhap tuoi">
					</div>
					<div class="form-group">
						<label>Tai khoan:</label> <input class="form-control" type="text"
							name="username" placeholder="Nhap username">
					</div>
					<div class="form-group">
						<label>Mat khau:</label> <input class="form-control"
							type="password" name="password" placeholder="Nhap mk">
					</div>
					<div class="form-group">
						<label>Goi tinh:</label> <input name="gen" checked="checked"
							value="M" type="radio">Nam <input name="gen" value="F"
							type="radio">Nu
					</div>
					<div class="form-group">
						<label>Anh URL:</label> <input class="form-control" type="text"
							name="image" placeholder="Nhap url anh" value="${user.image }">
					</div>
					<div class="form-group">
						<label>Role:</label> <select class="form-control" name="role">
							<option selected="selected" value="ROLE_ADMIN">ROLE_ADMIN</option>
							<option value="ROLE_MEMBER">ROLE_MEMBER</option>
						</select>
					</div>

					<div class="form-group">
						<input class="btn btn-primary" type="submit" value="Them moi">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>