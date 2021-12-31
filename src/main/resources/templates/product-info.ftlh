<!DOCTYPE html>
<html>
<head>
	<title>market hey</title>
</head>
<body>
<h1>Market</h1><hr>
<h4>Подробная информация</h4><br><br>

<div>
<#list images as img>
            <img height="100px" src="../productImages/${img.originalName}"/>
</#list>
</div>
<b>Название товара: </b>${product.title}<br><br>
<b>Описание товара: </b>${product.description}<br><br>
<b>Цена товара: </b>${product.price}<br><br>
<b>Город: </b>${product.city}<br><br>
<b>Телефон: </b><a value="${product.user.mobile}" href="/user/${product.user.userId}"><br><br>
<b>Автор: </b>${product.user.name}<br><br>
</body>
</html>
