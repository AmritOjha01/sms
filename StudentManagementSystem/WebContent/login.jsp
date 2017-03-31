<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="resources/customcss/demo.css">
<script type="text/javascript">
	function validateForm() {
		if (document.login_form.uName.value == "") {
			alert("Username should not be left blank");
			document.login_form.uName.focus();
			return false;
		}else if (document.login_form.pass.value
				.search(/^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/)) {
			alert("Password does not match");
			return false;
		}

	}
</script>
</head>
<body>
	<div class="login">
		<form name="login_form" action="LoginController" method="post"
			onsubmit="return validateForm()">
			<input type="text" placeholder="Username" name="uName"> <input
				type="password" placeholder="password" name="pass"> <a
				href="LoginController?action=getpassword" class="forgot">forgot
				password?</a> <input type="submit" value="Log In">
		</form>
	</div>
</body>
</html>