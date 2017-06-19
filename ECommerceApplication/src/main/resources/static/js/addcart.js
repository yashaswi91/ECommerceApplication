$(document).ready(function () {
$("#AddToCart").click(function () {
    	var username = $("#username").val();
    	var quantity = $("#quantity").val();
    	var id = $("#ID").val();
    	var name = $("#NAME").val();
    	var supplier = $("#Supplier").val();
    	var price = $("#Price").val();
    	var json = {"product":{"productId":id,"productName":name,"productsupplier":supplier,"productPrice":price},"quantity":quantity};
    	$.ajax({
    		type: 'POST',
    		contentType: 'application/json',
    		url: "http://localhost:8080/addCart/"+username,
    		data:JSON.stringify(json),
    		success: function(data){
    			alert("Product added to the cart");
    			window.location = "/viewCart/"+username+"?name="+username;
    		},
    		error: function(data){
    			alert("Data entered is incorrect");
    			window.location = "/home"+"?name="+username;
    		}
    	});
    });
});