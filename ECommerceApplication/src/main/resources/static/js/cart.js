$(document).ready(function () {
    $("#updateLine").click(function () {
    	var username = $("#username").val();
    	var lineId = $("#lineId").val();
    	var prodId = $("#prodId").val();
    	var prodName = $("#prodName").val();
    	var prodSupplier = $("#prodSupplier").val();
    	var prodPrice = $("#prodPrice").val();
    	var quantity = $("#Quantity").val();
    	var linePrice = $("#linePrice").val();
    	var json = {"cartId":lineId,"product":{"productId":prodId,"productName":prodName,"productsupplier":prodSupplier,"productPrice":prodPrice},"quantity":quantity,"price_per_line":linePrice};
    	$.ajax({
    		type: 'PUT',
    		contentType: 'application/json',
    		url: "http://localhost:8080/updatecart/"+lineId,
    		data:JSON.stringify(json),
    		success: function(data){
    			alert("Line updated successfully");
    			window.location = '/viewCart/'+username+"?name="+username;
    		},
    		error: function(data){
    			alert("Data entered is incorrect");
    			window.location = '/viewCart/'+username+"?name="+username;
    		}
    	});
    });
    $("#deleteLine").click(function () {
    	var username = $("#username").val();
    	var lineId = $("#lineId").val();
    	var prodId = $("#prodId").val();
    	var prodName = $("#prodName").val();
    	var prodSupplier = $("#prodSupplier").val();
    	var prodPrice = $("#prodPrice").val();
    	var quantity = $("#lineQuantity").val();
    	var linePrice = $("#linePrice").val();

    	var json = {"cartId":lineId,"product":{"productId":prodId,"productName":prodName,"productsupplier":prodSupplier,"productPrice":prodPrice},"quantity":quantity,"price_per_line":linePrice};
    	$.ajax({
    		type: 'DELETE',
    		contentType: 'application/json',
    		url: "http://localhost:8080/deleteCartLine/"+username+"/"+lineId,
    		data:JSON.stringify(json),
    		success: function(data){
    			alert("Product removed from the cart");
    			window.location = '/viewCart/'+username+"?name="+username;
    		},
    		error: function(data){
    			alert("Data entered is incorrect");
    			window.location = '/viewCart/'+username+"?name="+username;
    		}
    	});
    });
    
    $("#deleteCart").click(function () {
    	var username = $("#username").val();
    	$.ajax({
    		type: 'DELETE',
    		contentType: 'application/json',
    		url: "http://localhost:8080/deletecarts/"+username,
    		success: function(){
    			alert("Cart is deleted for the user");
    			window.location = '/viewCart/'+username+"?name="+username;
    		},
    		error: function(){
    			alert("Cart delete unsuccessful");
    			window.location = '/viewCart/'+username+"?name="+username;
    		}
    	});
    });
});