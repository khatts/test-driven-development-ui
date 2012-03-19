<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>TDD - Equity Order Management Manager</title>
</head>
<style>
</style>
<body>
<div id="dialog-form" title="Create new user">
	<form>
	<fieldset>
		<label for="name">Name</label>
		<input type="text" name="name" id="name" />
		<label for="email">Email</label>
		<input type="text" name="email" id="email" value="" />
		<label for="password">Password</label>
		<input type="password" name="password" id="password" value="" />
	</fieldset>
	</form>
</div>
</body>
</html>