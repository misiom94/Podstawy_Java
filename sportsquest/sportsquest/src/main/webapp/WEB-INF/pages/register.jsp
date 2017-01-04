<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Rejestracja</title>
	<!-- <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<center>
<h1>Sports Quest</h1>
<h2>Utwórz konto</h2>

<p>
<c:if test="${passwordError == true}">
	<b class="error">Hasła nie są takie same.</b>
</c:if>
</p>
<p>
<c:if test="${loginError == true}">
	<b class="error">Login zajęty</b>
</c:if>
</p>


<form method="post"  role="form" action="${pageContext.request.contextPath}/registered">
<table>
<tbody>
<tr>
<td></br></td>
</tr>

<tr>
<td><label for="surname">Imię</label> <input type="text"  class="form-control" name="name"  id="name" size="30" maxlength="40" placeholder="imie" required /></td>
</tr>

<tr>
<td>
<label for="surname">Nazwisko</label> <input type="text"  class="form-control"  name="surname" id="surname" size="30" maxlength="40" placeholder="nazwisko" required /></td>
</tr>

<tr>
<td><label for="login">Login</label> <input type="text"  class="form-control"  name="login"  id="login" size="30" maxlength="40" placeholder="login" required /></td>
</tr>

<tr>
<td><label for="password">Hasło</label><input type="password" class="form-control" name="password"  id="password" size="30" maxlength="32" placeholder="hasło" required/></td>
</tr>

<tr>
<td><label for="password2">Powtórz hasło</label> <input type="password" class="form-control" name="password2" id="password2" size="30" maxlength="32" placeholder="hasło" required/></td>
</tr>

<tr>
<td><label for="city">Miasto zamieszkania</label> <input type="text"  class="form-control" name="city"  id="city" size="30" maxlength="40" placeholder="miasto"  required/></td>
</tr>
</tbody>
</table>
<br></br>
<input style="width: 100px;" type="submit"  value="Rejestracja" class="btn btn-primary btn-change pull-center btn-back" > 
</form>


<a href="${pageContext.request.contextPath}/"><input style="width: 100px;" class="btn btn-default btn-change pull-back btn-back" value="Wstecz"/></a>
<p>
<br>
 		      
</p>
</center>
</body>
</html>