<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<!-- <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


  <div class="panel panel-default" >
    
    <div class="panel-heading clearfix" style="background-color: #333333">

	<font face="Impact" color="white" size="5"  >SPORTS QUEST</font>
        <div class="pull-right">
        <c:set var="rola" scope="session" value="${rola}"/>
			<c:set var="admin" scope="session" value="admin"/>
            <c:if test="${rola == admin }" >
				<a href="${pageContext.request.contextPath}/adminpanel"><button type="button" class="btn btn-info">Panel admina</button></a>
			</c:if>
            
			<a href="${pageContext.request.contextPath}/change"><button type="button" class="btn btn-info">Zmień haslo</button></a>
			
	<a href="<c:url value="/j_spring_security_logout" />"><button type="button" class="btn btn-danger">Wyloguj</button></a>
			
        </div>
    </div>
</div>

<title>Change password</title>
<style>
.error1 {
	color: red;
}
</style>
<style>
.error2 {
	color: red;
}
</style>
<style>
.error3 {
	color: red;
}
</style>
</head>
<body>


<center>
<h1>Change password</h1>

		<p>
		<c:if test="${error1 == true}">
			<b class="error">Stare hasło jest niepoprawne.</b>
		</c:if>
		</p>

		<p>
		<c:if test="${error2 == true}">
			<b class="error">Nowe hasło jest takie same jak stare</b>
		</c:if>
		</p>

		<p>
		<c:if test="${error3 == true}">
			<b class="error">Nowe hasła nie są takie same</b>
		</c:if>
		</p>
		
		<p>
		<c:if test="${correct == true}">
			<b class="correct">Hasło zmienione.</b>
		</c:if>
		</p>
		

	<form method="post" action="${pageContext.request.contextPath}/password-verify">
		<table>
		<tbody>
		<tr>
			<td><label for="oldpassword">Stare hasło </label></td>
			<td><input class="form-control"   type="password" name="oldpassword" id="oldpassword"size="30" maxlength="40"  /></td>
				</br>
		</tr>
		<tr>
			<td><label for="newpassword1">Nowe hasło </label></td>
			<td><input class="form-control"   type="password" name="newpassword1" id="newpassword1" size="30" maxlength="32" /></td>
				</br>
		</tr>
		<tr>
			<td><label for="newpassword2">Powtórz nowe hasło </label></td>
			<td><input class="form-control"   type="password" name="newpassword2" id="newpassword2" size="30" maxlength="32" /></td>
				</br>
		</tr>
		<tr>
			
		</tr>
		</tbody>
		</table>
		</br>
		<input style="width: 100px;" type="submit"  value="Zmień" class="btn btn-primary btn-change pull-center btn-back" > 
		<a href="${pageContext.request.contextPath}/success-login"><input style="width: 100px;" class="btn btn-default btn-change pull-back btn-back" value="Wstecz"/></a>
		
		
	</form>
	
	</center>
<p>

</p>
</body>
</html>