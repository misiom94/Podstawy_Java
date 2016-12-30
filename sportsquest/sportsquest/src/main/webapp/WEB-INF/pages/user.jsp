<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>User page</title>
	
	
<!-- <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <div class="panel panel-default" >
    
    <div class="panel-heading clearfix" style="background-color: #333333">
    <img src="/resources/img/Logo.jpg" width="40" height="40" />
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
</head>
<body style='background: url("resources/img/Background_user.jpg"); background-size:cover'>

<center>
	<h1>Witaj ${name} </h1>
	
	
	
	<br></br>
	
	

	<br></br>
	<a href="${pageContext.request.contextPath}/addEvent"><button type="button" class="btn btn-success btn-lg">Utwórz Sport Quest</button></a>
	
</center>
	
	<div class="container">
	
<center>
  <h2>Nadchodzące wydarzenia</h2>

</center>
  <table class="table">
    <thead>
      <tr>
        <th>Nazwa</th>
        <th>Miasto</th>
        <th>Sport</th>
        <th>Data</th>
        <th></th>
      </tr>
    </thead>
    
    <tbody>
    <form method="post"  role="form" action="${pageContext.request.contextPath}/event">
    <c:forEach var="event" items="${eventList}">
      <tr>
        <td>${event.getEventName()}</td>
        <td>${event.getCity()}</td>
        <td>${event.getSport().getSportName()}</td>
        <td>${event.getDate()}</td>
         <td><button style="width: 100px;" type="submit"  name="buttonInfo" value="${event.getEventId()}" class="btn btn-primary btn-change pull-center btn-back" > Szczegóły</button></td>
      </tr>
      </c:forEach>
    </form>
    </tbody>
  </table>
</div>
	


	


	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>