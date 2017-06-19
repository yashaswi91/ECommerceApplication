<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script src="/js/addcart.js"></script>

</head>
<body style="background-color: gray;"><br>
	<h3 align="center">E-Commerce Application</h3>
	
	<div id="menuList">
		<ul>
			<li><input type="button" value="home" id="home"></li>
			<li><input type="button" value="viewCart" id="viewCart"></li>
			<li><input type="button" value="viewOrders" id="viewOrders"></li>
			<li><input type="button" value="Update User Profile" id="updateUser"></li>
			<li><input type="button" value="Update User Address" id="updateAddress"></li>
			<li><input type="button" value="Logout" id="logout"></li>
		</ul>
	</div><br>
	<h3>Welcome <%=request.getParameter("name")%></h3>
	<div align="left">
		<form>
				<input type="hidden" id="username" value="<%=request.getParameter("name")%>"></input>
				<input type="hidden" id="ID" value="${prod.productId}"></input>
				<input type="hidden" id="NAME" value="${prod.productName}"></input>
				<input type="hidden" id="Supplier" value="${prod.productsupplier}"></input>
				<input type="hidden" id="Price" value="${prod.productPrice}"></input>				
			<ul>
				<li><img src="/images/${prod.productId}.jpg" width="500" height="500"></li>
				<li>${prod.productId}</li>
				<li>${prod.productName}</li>
				<li>${prod.productsupplier}</li>
				<li>${prod.productPrice}</li>
				<li><input type="text" name="quantity" placeholder="Enter quantity" id="quantity"></li>
				<li><input type="button" value="Add To Cart" id="AddToCart"></li>
			</ul>
		</form>
	</div>
</body>
</html>