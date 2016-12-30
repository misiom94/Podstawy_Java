<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
 
  <div class="panel panel-default" >
    
    <div class="panel-heading clearfix" style="background-color: #333333">
		<img src="/resources/img/Logo.jpg" width="40" height="40" />
	<font face="Impact" color="white" size="5"  >SPORTS QUEST</font>
        <div class="pull-right">
            
			<a href="${pageContext.request.contextPath}/change"><button type="button" class="btn btn-info">Zmień hasło</button></a>
			
	<a href="<c:url value="/j_spring_security_logout" />"><button type="button" class="btn btn-danger">Wyloguj</button></a>
			
        </div>
    </div>
</div>

  <link rel="stylesheet" type="text/css" href="dist/bootstrap-clockpicker.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Utwórz</title>



<style>
.error {
	color: red;
}
</style>
</head>

<body style='background: url("/resources/img/Background.jpg"); background-size:cover'>


<center>
<h1>Sports Quest</h1>
<h2>Utwórz Sport Quest</h2>

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


<form method="post"  role="form" action="${pageContext.request.contextPath}/addingEvent">
<table>
<tbody>
<tr>
<td></br></td>
</tr>

<tr>
<td><label for="surname">Nazwa</label> <input type="text"  class="form-control" name="name"  id="name" size="30" maxlength="40" placeholder="nazwa" required /></td>
</tr>

<tr>
<td>
<label for="surname">Miasto</label> <input type="text"  class="form-control"  name="city" id="surname" size="30" maxlength="40" placeholder="miasto" required /></td>
</tr>
<tr>
<td>
<label for="surname">Adres</label> <input type="text"  class="form-control"  name="address" size="30" maxlength="40" placeholder="adres" required /></td>
</tr>
<tr>			
<td>       
<label for="sport">Sport</label>

  <select class="form-control" name="sport">
 <c:forEach var="sports" items="${sports}">
  <option name = "chosenSport" value="${sports.getSportId()}"  >
<c:out value="${sports.getSportName()}" />
 </option>
  </c:forEach>
</select>
		<center>     
<a href="${pageContext.request.contextPath}/sport-add"><input class="btn btn-primary btn-change pull-back btn-back" value="Zaproponuj nową dyscypline"/></a>   
</center>
</td>

</tr>


<tr>
<td><label for="login">Opis</label> <textarea type="text"  class="form-control"  name="desc"  id="login" size="50" maxlength="150" rows="7" placeholder="opis" required></textarea></td>
</tr>

<tr>			
<td>       
<label for="datetimepicker">Data</label>

 
   <div id="datetimepicker" class="input-append date">
      <input class="form-control"   readonly type="text" name="date"></input>
      <span class="add-on">
        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
      </span>
    </div>
 
							        
</td>
</tr>

</tbody>
</table>
 
<br></br>
<input style="width: 100px;" type="submit"  value="Utwórz" class="btn btn-primary btn-change pull-center btn-back" > 
</form>


<a href="${pageContext.request.contextPath}/success-login"><input style="width: 100px;" class="btn btn-default btn-change pull-back btn-back" value="Wstecz"/></a>
<p>
<br>
 		      
</p>
</center>




	  <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pl-PL.js">
    </script>
    <script type="text/javascript">
      $('#datetimepicker').datetimepicker({
        format: 'dd-MM-yyyy hh:mm:ss',
        language: 'pl-PL'
      });
    </script>


</body>
</html>