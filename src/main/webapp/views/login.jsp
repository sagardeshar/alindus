<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>Login | Cubic Report App</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous" />
<style type="text/css">
.loginform {
	width: 350px;
	margin: 150px auto;
	padding: 25px 30px;
	font-family: sans-serif;
	color: #333;
}

.loginform h1 {
	margin: 0px 0px 20px 0px;
	font-size: 27px;
}

.loginform .btn-default {
	width: 100%;
	background: #D4001C;
	color: #fff;
	padding: 10px;
	border: 1px solid #D4001C;
}

#logo {
	padding-bottom: 15px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 30px;
}

.loginform p {
	color: #666;
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<div class="loginform">
		<div id="logo">
			<img src="../static/images/logo.png" alt="Cubic App" />
		</div>
		<p>Login to Cubic App</p>
		<span class="text-danger" th:if="${param.error}">Invalid username
			and password.</span>
		<span class="text-danger" th:if="${param.logout}">You have been
			logged out.</span>

		<form th:action="@{/login}" method="post">
			<div class="form-group">
				<input type="email" class="form-control" placeholder="Email"
					name="username" />
			</div>
			<div class="form-group">
				<input type="password" name="password" class="form-control"
					placeholder="Password" />
			</div>
			<button type="submit" class="btn btn-default">Login</button>
		</form>
	</div>
</body>
</html>