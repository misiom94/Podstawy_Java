<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Spots Quest logowanie</title>
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
<h2>Zaloguj się !</h2>

<p>

<c:if test="${error == true}">
	<b class="error">Niepoprawny login lub hasło.</b>
</c:if>
</p>


<form method="post" action="<c:url value='j_spring_security_check'/>" >
<table>
<tbody>
<tr>
<td></br></td>
</tr>
<tr>
<td><input class="form-control"   type="text" name="j_username" id="j_username"size="30" maxlength="40" placeholder="login" required /></td>
</tr>

<tr>
<td><input class="form-control"  type="password" name="j_password" id="j_password" size="30" maxlength="32" placeholder="hasło" required/></td>
</tr>

</tbody>
</table>
<br></br>



<input style="width: 100px;" type="submit"  value="Login" class="btn btn-primary btn-change pull-center btn-back" > 
<a href="${pageContext.request.contextPath}/register"><input style="width: 100px;" class="btn btn-default btn-change pull-back btn-back" value="Rejestracja"/></a>


</form>	

<p>
<br>
 		      
</p>
</center>
</body>
</html>