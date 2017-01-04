<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Add sport</title>
	
	
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
            
			<a href="${pageContext.request.contextPath}/change"><button type="button" class="btn btn-info">Zmień hasło</button></a>
			
	<a href="<c:url value="/j_spring_security_logout" />"><button type="button" class="btn btn-danger">Wyloguj</button></a>
			
        </div>
    </div>
</div>

<style>
.center {
    margin: auto;
    width: 40%;
    
    padding: 10px;
}
</style>
</head>
<body>


<center>
	<h1>Propozycja sportu </h1>
	
	
	
	<br></br>
	
		<h1>Nazwa dyscypliny sportowej:</h1>
		<br>
		
		
	<div class="center">
	
	
<form method="post"  role="form" action="${pageContext.request.contextPath}/addSport">
		<input type="text"  class="form-control" name="sportName"  size="30" maxlength="40"  placeholder="nazwa" required />

	
	<br></br>

	<input  type="submit" style="width: 120px;"  value="Wyślij prośbę " class="btn btn-primary " > 
</form>

 <a href="${pageContext.request.contextPath}/addEvent"><input style="width: 120px;" class="btn btn-default btn-change pull-back btn-back" value="Wstecz"/></a>
 </center>
 </div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>