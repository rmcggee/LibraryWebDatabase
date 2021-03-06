<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book - Location List</title>
<style>
table, th, td {
  border: 1px solid black;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
<form method="post" action="navigationServlet">


<table>
<tr>
<th/>
<th>Title</th>
<th>Author</th>
<th>Call</th>
<th>Purchased</th>
<th>Section</th>
<th>Shelf</th>
<th>Shelved</th>

</tr>
<c:forEach var = "bookList" items="${requestScope.allLists}" >
<tr>
 <td><input type="radio" name="id" value="${bookList.locationId}"> </td>
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
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
<input type="submit" value = "edit" name = "doThisToList">

<h1>Checkout a Book </h1>
Your Name: <input type ="text" name = "name">
<input type="submit" value = "checkout" name = "doThisToList">
<a href = "viewCustomersServlet">View the complete list of Customers</a> <br/>
</form>
<img src="https://thumbs.dreamstime.com/b/bookshelf-full-books-icon-cartoon-colorful-isolated-vector-illustration-graphic-design-149682816.jpg" alt="" width="200"
         height="300">
</body>
</html>