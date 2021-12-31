<!DOCTYPE html>
<html>
<head>
	<title>FleaMarket</title>
</head>
<body>
<h1>FleaMarket</h1>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    Эл. почта: <input type="email" name="email"><br><br>
    Номер телефона: <input type="text" name="mobile"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
</body>
</html>