<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit A Customer!</title>
</head>
<body>
<h1>Edit A Customer</h1>
<form action = "EditCustomerServlet" method="post">
Name: <input type ="text" name = "name" value= "${itemToEdit.name}">
Date: <input type ="text" name = "date" value= "${itemToEdit.checkoutDate }">
<input type = "hidden" name = "id" value ="${itemToEdit.id}">
<table>
<tr>
<th/>
<th>Id</th>
<th>Title</th>
<th>Author</th>
<th>Call</th>
<th>Purchased Date</th>
</tr>
<c:forEach var = "bookList" items="${requestScope.allLists}" >
<tr>
 <td><input type="radio" name="bookId" value="${bookList.bookId}"> </td>
 					<td>${bookList.bookId}</td>
 					<td>${bookList.title}</td>
 					<td>${bookList.author}</td>
 					<td>${bookList.callNbrText}</td>
 					<td>${bookList.purchasedDate}</td>
					
 </tr>
</c:forEach>
</table>
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>