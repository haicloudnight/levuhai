<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/LyThuyetTongHop/login" method="post">
		<div>
			<label>Username:</label> <input type='text' name='username' />
		</div>
		<div>
			<label>Password:</label><input type="password" name='password' />
		</div>
		<button type='submit'>Login</button>
	</form>
</body>
</html>