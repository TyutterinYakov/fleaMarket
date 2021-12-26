<!DOCTYPE html>
<html>
<head>
	<title>market hey</title>
</head>
<body>
<h1>Market</h1><hr>
<h4>Подробная информация</h4><br><br>
<b>Название товара: </b>${product.title}<br><br>
<b>Описание товара: </b>${product.description}<br><br>
<b>Цена товара: </b>${product.price}<br><br>
<b>Город: </b>${product.city}<br><br>
<b>Автор: </b>${product.author}<br><br>

<hr>
<h3>Создать новый товар</h3>
<form action="/product/remove/${product.productId}" method="POST">
	<input type="submit" value="Удалить товар"/>
</form>	
	
</body>
</html>
