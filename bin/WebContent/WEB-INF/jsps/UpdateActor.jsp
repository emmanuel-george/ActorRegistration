<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update</h1>
<s:form action="updateActor" modelAttribute="actor">
              Enter the name:<s:input path="uname"/><s:errors path="uname"/><br><br>
              Enter the Famous Character played by the Actor:<s:input path="fname"/><s:errors path="fname"/><br><br>
              Load the pic:<input type="file" name="pic"/><br><br>
              Enter the id:<s:input path="id"/><s:errors path="id"/><br><br>
            <input type="submit" value="Update"/>

             </s:form>

</body>
</html>