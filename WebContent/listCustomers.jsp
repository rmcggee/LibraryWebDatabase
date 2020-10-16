<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<h1> List Of Current Book's checked out</h1>
<form method="post" action="CustomerNavigationServlet">
<table>
<c:forEach var = "customerList" items="${requestScope.allLists}" >
<tr>
 <td><input type="radio" name="id" value="${customerList.id}"> </td>
 <td>${customerList.name}</td>
 <td>${customerList.checkoutDate}</td>
 <td>${customerList.book.bookId}</td>
 <td>${customerList.book.title}</td>
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href = "index.html">Return Home</a> <br/>
</body>
</html>