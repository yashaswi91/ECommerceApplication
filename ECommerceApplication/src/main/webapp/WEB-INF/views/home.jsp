<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<title>Your Home Page</title>
<style>
#menuList ul li {
	display: inline;
	position: relative;
	text-decoration: none;
}

</style>
<script src="/js/cart.js"></script>
<script src="/js/home.js"></script>
<script src="/js/addcart.js"></script>
</head>
<body style="background-color: gray;" onLoad="noBack();">

	<div id="menuList">
		<ul>
			<li><input type="button" value="Home" id="home"></li>
			<li><input type="button" value="ViewCart" id="viewCart"></li>
			<li><input type="button" value="ViewOrders" id="viewOrders"></li>
			<li><input type="button" value="Update User Profile" id="updateUser"></li>
			<li><input type="button" value="Update User Address" id="updateAddress"></li>
			<li><input type="button" value="Logout" id="logout"></li>
		</ul>
	</div>
	<div>
		<h1>
			Welcome <%=request.getParameter("name")%></h1>
		<br>
		<br>

		<form>
		<input type="hidden" value="<%=request.getParameter("name")%>" id="username"></input>
			<c:forEach var="product" items="${list}">

				<input type="hidden" id="ID" value="${product.productId}"></input>
				<input type="hidden" id="NAME" value="${product.productName}"></input>
				<input type="hidden" id="Supplier" value="${product.productsupplier}"></input>
				<input type="hidden" id="Price" value="${product.productPrice}"></input>				
				<ul>

					<li><img src="/images/${product.productId}.jpg" style="richness: inherit;" width="200" height="200"></li>
					<li>${product.productId}</li>
					<li>${product.productName}</li>
					<li>${product.productsupplier}</li>
					<li>${product.productPrice}</li>
					<li><a href="/viewProduct/${product.productId}/?name=<%=request.getParameter("name")%>">Check this Product</a></li>
					<p>-------------------------------------------------------------------------------------------------</p>
				</ul>
			</c:forEach>

		</form>
	</div>
</body>
</html>