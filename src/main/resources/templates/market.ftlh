<!DOCTYPE html>
<html>
<head>
	<title>market hey</title>
</head>
<body>
<h1>Market</h1><hr>
<#if user.email??>
<h3>Привет, <i>${user.name}</i></h3>
<form action="/logout" method="post">
	<input type="hidden" name="_csrf" value="${_csrf.token}">
	<input type="submit" value="Выход">
</form>
	<#if user.isAdmin()>
		<a href="/admin">Панель администратора</a>
	</#if>
<#else>
<a href="/login">Вход</a></h1><hr>
</#if>
<h4>Товары со всей России</h4>
<form action="/" method="get">
	Поиск по названию объявления: <input type="text" name="title"><br>
	<input type="submit" value="Поиск"/>
</form>

<#list products as product>
	<div>
		<p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.productId}">Подробнее...</a></p>
	</div>
	<#else>
	<h3>Товаров нет</h3>
</#list>
<#if user.email??>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="POST" enctype="multipart/form-data">
	Название объявления: <input type="text", name="title"/><br><br>
	Описание объявления: <input type="text", name="description"/><br><br>
	Цена: <input type="number", name="price"/><br><br>
	Город: <input type="text", name="city"/><br><br>
	Фото 1: <input type="file", name="file" multiple/><br><br>
	<input type"hidden" name="_csrf" value="${_csrf.token}"/>
	<input type="submit" value="Добавить товар"/>
</form>
</#if>
</body>
</html>
