<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit A Customer</title>
</head>
<body>
<h1>Edit A Book Location</h1>
<form action = "editBookLocationServlet" method="post">
Section: <input type ="text" name = "section" value= "${itemToEdit.sectionName}">
Shelf: <input type ="text" name = "shelf" value= "${itemToEdit.shelfName }">
<input type = "hidden" name = "id" value ="${itemToEdit.locationId}">
<table>
<tr>
<th>Section</th>
<th>Shelf</th>
</tr>
</table>
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>