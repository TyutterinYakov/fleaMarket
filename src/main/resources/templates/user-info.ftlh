<!DOCTYPE html>
<html>
<head>
	<title>FleaMarket</title>
</head>
<body>
<h1>FleaMarket</h1>
<h4>Продавец: ${user.name}</h4>
<b>Номер телефона: ${user.mobile}</b>
<h3>Товары продавца:</h3>
<#list products as product>
	<div>
		<p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.productId}">Подробнее...</a></p>
	</div>
	<#else>
	<h3>Товаров нет</h3>

</#list>
</form>
</body>
</html>