<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<a href="/Store/admin/product/add" class="btn btn-primary">Them moi</a>
				<form class="form-inline" action="/Store/admin/product/search" method="post">
					<input class="form-control" name="keyword" type="text" placeholder="Tim theo ten">
					</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
						<th>description</th>
						<th>Image</th>
						<th>Danh muc</th>
						<th>Option</th>
					</tr>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.name }</td>
							<td>${product.price }</td>
							<td>${product.description }</td>
							<td><img src="/Store/download?image=${product.image }" width="100" /></td>
							<td>${product.category.name }</td>
							<td><a class="btn btn-success" href="/Store/admin/product/update?id=${product.getId() }">Sua</a> | <a class="btn btn-danger"
								href="/Store/admin/product/delete?id=${product.getId() }">Xoa</a></td>
						</tr>
					</c:forEach>
					<button type="" class="btn btn-danger">Xemthem</button>
				</table>
			</div>
		</div>
	</div>
</body>
</html>