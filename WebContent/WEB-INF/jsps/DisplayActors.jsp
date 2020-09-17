<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Display Actors</h1>
<a href="openAddActorView">Click here to add Actors</a><br>


<h1>List of actors</h1>
<c:forEach var="bean" items="${listactors}" >
		 <c:out value="${bean.uname}"/> 
		  <c:out value="${bean.fname}"/><a href="deleteActor?id=${bean.id}">Delete</a>  <a href="openUpdateActor?id=${bean.id}">Update</a><br>
	</c:forEach>

</body>
</html>