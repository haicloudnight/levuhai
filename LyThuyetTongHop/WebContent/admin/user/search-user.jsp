<%@page import="com.trungtamjava.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>danh sach nguoi dung</h1>

	<form action="/LyThuyetTongHop/admin/user/search" method="get">
		<input type="text" placeholder="Search...." name="name"/>
		<button type="submit">Search</button>
	</form>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Button</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td><a href="/LyThuyetTongHop/admin/user/delete?id=${user.id}">Xoa</a>
					<a href="/LyThuyetTongHop/admin/user/update?id=${user.id}">Edit</a>
				 </td>
			</tr>
		</c:forEach>
	</table>


	<%-- <%
		List<User> users = (List<User>)request.getAttribute("users");
	%>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<% 
			for (User user : users) {
		%>
			<tr>
				<th><%=user.getId() %></th>
				<th><%=user.getName() %></th>
				<th><%=user.getAge()%></th>
			</tr>
		<%
			}
		%>
		
	</table> --%>
</body>
</html>