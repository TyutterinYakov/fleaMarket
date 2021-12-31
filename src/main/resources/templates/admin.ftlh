<!DOCTYPE html>
<html>
<head>
	<title>market hey</title>
</head>
<body>
<h1>Market</h1><hr>
<h4>Панель администратора</h4>
<table border="1">
	<tr>
		<th>Email</th>
		<th>Телефон</th>
		<th>Активность</th>
		<th>Роль</th>
		<th>Бан</th>
		<th>Редактирование</th>
		<th>Информация</th>
	</tr>
	<#list users as user>
	<tr>
		<th>${user.email}</th>
		<th>${user.mobile}</th>
		<th><#if user.active>true<#else>false</#if></th>
		<th><#list user.roles as role>
				${role}<#sep>, 
			</#list>
		</th>
		<th>
			<form action="/admin/user/ban/${user.userId}" method="post">
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<input type="submit" value="Бан/Разбан">
			</form>
		</th>
		<th><a href="/admin/user/edit/${user.userId}">Ред.</a></th>
		
		<th><a href="/user/${user.userId}">Инфо</a></th>
			</tr>	
	<#else>
		<h3>Пользователи не найдены</h3>
	</#list>
	
</table>


</body>
</html>
