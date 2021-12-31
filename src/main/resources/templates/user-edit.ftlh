<!DOCTYPE html>
<html>
<head>
	<title>market hey</title>
</head>
<body>
<h1>Market</h1><hr>
<h4>Редактирование пользователя ${user.name}</h4>
<form action="/admin/user/edit" method="post">
	<#list roles as role>
	<div>
		<label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
	</div>
	</#list>>
	<input type="hidden" value="${user.userId}" name="userId">
	<input type="hiden" value="${_csrf.token}" name="_csrf">
	<input type="submit"></input>	
</form>
</body>
</html>
