<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin page</title>

<!-- <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<div class="panel panel-default">

		<div class="panel-heading clearfix" style="background-color: #333333">

	<font face="Impact" color="white" size="5"  >SPORTS QUEST</font>
    
			<div class="pull-right">
				<c:set var="rola" scope="session" value="${rola}" />
				<c:set var="admin" scope="session" value="admin" />
				<c:if test="${rola == admin }">
					<a href="${pageContext.request.contextPath}/adminpanel"><button
							type="button" class="btn btn-info">Panel admina</button></a>
				</c:if>

				<a href="${pageContext.request.contextPath}/change"><button
						type="button" class="btn btn-info">Zmień hasło</button></a> <a
					href="<c:url value="/j_spring_security_logout" />"><button
						type="button" class="btn btn-danger">Wyloguj</button></a>

			</div>
		</div>
	</div>
	
	<style>
.container{
    margin: auto;
    width: 60%;
    
    padding: 10px;
}

</style>
</head>
<body>

	<div class="container";>
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
					<th></th>
				</tr>
			</thead>

			<tbody>
				<form method="post" role="form"
					action="${pageContext.request.contextPath}/event">
					<c:forEach var="event" items="${eventList}">
						<tr>
							<td>${event.getEventName()}</td>
							<td>${event.getCity()}</td>
							<td>${event.getSport().getSportName()}</td>
							<td>${event.getDate()}</td>
							<td><button style="width: 100px;" type="submit"
									name="buttonInfo" value="${event.getEventId()}"
									class="btn btn-primary btn-change pull-center btn-back">
									Szczegóły</button></td>
							<td><button style="width: 100px;" type="submit"
									name="buttonDelete" value="${event.getEventId()}"
									class="btn btn-primary btn-change pull-center btn-danger">
									Usuń</button></td>
						</tr>
					</c:forEach>
				</form>
			</tbody>
		</table>
		


			<div class="row">
			
				
					<center>
						<h3>Użytkownicy</h3>
					</center>

					<table class="table">
						<thead>
							<tr>
								<th>Login</th>
								<th>Imie</th>
								<th>Nazwisko</th>
								<th></th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<form method="post" role="form"
								action="${pageContext.request.contextPath}/menageUser">
								<c:forEach var="list" items="${userList}">
									<tr>
										<td>${list.getLogin()}</td>
										<td>${list.getName()}</td>
										<td>${list.getSurname()}</td>

										<c:set var="blocked" scope="session"
											value="${list.getBlocked()}" />
										<c:set var="block0" scope="session" value="0" />
										<c:if test="${blocked == block0 }">

											<td><button style="width: 100px;" type="submit"
													name="buttonBlock" value="${list.getUserId()}"
													class="btn btn-warning btn-change pull-center btn-back">
													Zablokuj</button></td>
										</c:if>
										<c:set var="blocked" scope="session"
											value="${list.getBlocked()}" />
										<c:set var="block1" scope="session" value="1" />
										<c:if test="${blocked == block1 }">

											<td><button style="width: 100px;" type="submit"
													name="buttonActivate" value="${list.getUserId()}"
													class="btn btn-warning btn-change pull-center btn-back">
													Odblokuj</button></td>
										</c:if>

										<td><button style="width: 100px;" type="submit"
												name="buttonDelUser" value="${list.getUserId()}"
												class="btn btn-danger btn-change pull-center btn-back">
												Usuń</button></td>
									</tr>
								</c:forEach>
							</form>
						</tbody>
					</table>
				</div>
			
		

	
			<div class="col-sm-6">
				<center>
					<h3>Aktywne dyscypliny sportu</h3>
				</center>
				<table class="table">
					<thead>
						<tr>
							<th>Nazwa</th>
							<th></th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<form method="post" role="form"
							action="${pageContext.request.contextPath}/menageSport">
							<c:forEach var="sport" items="${sportList}">
								<tr>
									<td>${sport.getSportName()}</td>


									<td><button style="width: 100px;" type="submit"
											name="buttonDel" value="${sport.getSportId()}"
											class="btn btn-danger btn-change pull-center btn-back">
											Usuń</button></td>
								</tr>
							</c:forEach>
						</form>
					</tbody>
				</table>
			</div>
			<div class="col-sm-6">
				<center>
					<h3>Proponowane dyscypliny sportu</h3>
				</center>
				<table class="table">
					<thead>
						<tr>
							<th>Nazwa</th>
							<th></th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<form method="post" role="form"
							action="${pageContext.request.contextPath}/menageSport">
							<c:forEach var="sport" items="${sportListNot}">
								<tr>

									<td>${sport.getSportName()}</td>

									<td><button style="width: 100px;" type="submit"
											name="buttonAdd" value="${sport.getSportId()}"
											class="btn btn-primary btn-change pull-center btn-back">
											Dodaj</button></td>


									<td><button style="width: 100px;" type="submit"
											name="buttonDel" value="${sport.getSportId()}"
											class="btn btn-danger btn-change pull-center btn-back">
											Usuń</button></td>

								</tr>
							</c:forEach>
						</form>
					</tbody>
				</table>
			</div>
			</div>
			</div>
		</div>
</body>
</html>