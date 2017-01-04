<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Event page</title>
	
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->

  <!-- <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->


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

</head>
<body>


<div class="container">


 <h1>Sport Quest</h1>
  <h2>${event.getEventName()} </h2>
  <ul class="list-group">
    <li class="list-group-item">${event.getSport().getSportName()}</li>
    <li class="list-group-item">${event.getDate()}</li>
    <li class="list-group-item">${event.getCity()}, ${event.getAddress()}</li>
    <li class="list-group-item">${event.getDescription()}</li>
    
   
  </ul>
  </div>
  
    <c:set var="Host" value="${host.getUserId()}"/>
<c:set var="user" value="${userId}"/>
<c:if test="${Host!=user}">

  <div class="container">
  


<form method="post"  role="form" action="${pageContext.request.contextPath}/joinEvent">
 <input type="hidden" id="eventId" name="eventId" value="${event.getEventId()}" />


<c:set var="joined" value="${joined}"/>
<c:set var="var1" value="true"/>
<c:set var="var2" value="false"/>
<c:if test="${joined==var1}">

  <input style="width: 100px;" type="submit"  value="Dołącz" disabled class="btn btn-success btn-change pull-center btn-back" > 

  
 </c:if>
 <c:if test="${joined==var2}">

  <input style="width: 100px;" type="submit"  value="Dołącz" class="btn btn-success btn-change pull-center btn-back" >   
 </c:if>

</form>

</div>
  <div class="container">
<form method="post"  role="form" action="${pageContext.request.contextPath}/exitEvent">
<input type="hidden" id="eventId" name="eventId" value="${event.getEventId()}" />
<c:if test="${joined==var1}">

  <input style="width: 100px;" type="submit"  value="Opuść"  class="btn btn-danger btn-change pull-center btn-back" > 
  
 </c:if>
 <c:if test="${joined==var2}">

  <input style="width: 100px;" type="submit"  value="Opuść" disabled class="btn btn-danger btn-change pull-center btn-back" > 
 </c:if>
</form>
</div>
<br></br>
</c:if>
  <div class="container">

<c:set var="Host" value="${host.getUserId()}"/>
<c:set var="user" value="${userId}"/>
<c:if test="${Host==user}">
 <form method="post"  role="form" action="${pageContext.request.contextPath}/deleteEvent">
  <input type="hidden" id="eventId" name="eventId" value="${event.getEventId()}" />
 <input  type="submit"  value="Usuń wydarzenie"  class="btn btn-danger btn-change pull-center btn-back" > 

</form>
</c:if>

 </div>
<div class="container">
  <h2>Uczestnicy</h2>
  <ul class="list-group">
    <li class="list-group-item active">${host.getName()} ${host.getSurname()}</li>
     <c:forEach var="participants" items="${participants}">
 <li class="list-group-item ">${participants.getName()} ${participants.getSurname()}</li>
 </c:forEach>
    
    
  </ul>

<a href="${pageContext.request.contextPath}/success-login"> <button class="btn btn-default " > Wstecz</button></a>

</div>
 



      





</body>
</html>