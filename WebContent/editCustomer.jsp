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
<th>Title</th>
<th>Author</th>
<th>Call</th>
<th>Purchased Date</th>
<th>Section Name</th>
<th>shelf Name</th>
<th>create Date</th>
</tr>
<c:forEach var = "bookList" items="${requestScope.allLists}" >
<tr>
 <td><input type="radio" name="bookId" value="${bookList.locationId}"> </td>
 					<td>${bookList.myBook.title}</td>
 					<td>${bookList.myBook.author}</td>
 					<td>${bookList.myBook.callNbrText}</td>
 					<td>${bookList.myBook.purchasedDate}</td>
					<td>${bookList.sectionName}</td>
					<td>${bookList.shelfName}</td>
					<td>${bookList.createDate}</td>			
 </tr>
</c:forEach>
</table>
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>