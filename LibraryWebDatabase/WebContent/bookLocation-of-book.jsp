<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book - Location List</title>
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
</form>

</body>
</html>