<!DOCTYPE html>
<html>
<head>
	<title>FleaMarket</title>
</head>
<body>
<h1>FleaMarket</h1><hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Вход">
</form>
Нет аккаунта ? <a href="/registration">Зарегистрируйся</a>
</body>
</html>