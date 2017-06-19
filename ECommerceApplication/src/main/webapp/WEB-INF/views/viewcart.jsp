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

<script type="text/javascript"></script>

<title>ECommerce Portal</title>
<style>
#menuList ul li {
	display: inline;
	position: relative;
	text-decoration: none;
}
h2 {
	font-size: 80px;
	margin: 2px 0 -20px 0 !important;
}
table {
    border-collapse: collapse;
}
th, td {
    text-align: left;
    padding: 8px;
}
tr:nth-child(even){background-color: #f2f2f2}
th {
    background-color: #4CAF50;
    color: white;
}
</style>
<script src="/js/home.js"></script>
<script src="/js/cart.js"></script>

</head>
<body style="background-color: gray;"><br>
	<h3 align="center">E-Commerce Application Home Page</h3>
	<br>
	
	<div id="menuList">
		<ul>
			<li><input type="button" value="home" id="home"></li>
			<li><input type="button" value="viewCart" id="viewCart"></li>
			<li><input type="button" value="viewOrders" id="viewOrders"></li>
			<li><input type="button" value="Update User Profile" id="updateUser"></li>
			<li><input type="button" value="Update User Address" id="updateAddress"></li>
			<li><input type="button" value="Logout" id="logout"></li>
		</ul>
	</div>
	<br>
	<div align="left">
		<form>
			<input type="hidden" id="username" value="<%=request.getParameter("name")%>"></input>

			<c:forEach var="line" items="${list2}">
				<input type="hidden" id="lineId" value="${line.cartId}"></input>
				<input type="hidden" id="prodId" value="${line.product.productId}"></input>
				<input type="hidden" id="prodName" value="${line.product.productName}"></input>
				<input type="hidden" id="prodSupplier" value="${line.product.productsupplier}"></input>
				<input type="hidden" id="prodPrice" value="${line.product.productPrice}"></input>				
				<input type="hidden" id="lineQuantity" value="${line.quantity}"></input>				
				<input type="hidden" id="linePrice" value="${line.price_per_line}"></input>				
				
			<ul>
				
					<li><img src="/images/${line.product.productId}.jpg" width="500" height="500"></li>
					<li>Line ID : ${line.cartId}</li>
					<li>Product ID : ${line.product.productId}</li>
					<li>Product Name : ${line.product.productName}</li>
					<li>Product Supplier : ${line.product.productsupplier}</li>
					<li>Product Price : ${line.product.productPrice}</li>
					<li>Quantity : ${line.quantity}</li>
					<li>Price : ${line.price_per_line}</li>
					<li><input type="number" id="Quantity"></input>&nbsp &nbsp			
					<input type ="button" value="Update Line" id="updateLine"></input></li>
					<li><input type ="button" value="Delete Line" id="deleteLine"></li>
					<p>-------------------------------------------------------------------------------------------------</p>
			</ul>
		</c:forEach>
			<br><input type ="button" value="Checkout" id="Checkout">
		</form>
	</div>

</body>
</html>