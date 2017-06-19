$(document).ready(function () {
    $("#updateUser1").click(function () {
        var username = $("#username").val();
        var pwd = $("#pwd").val();
        var email = $("#email").val();
        
        var street = $("#street").val();
        var city = $("#city").val();
        var state = $("#state").val();
        var country = $("#country").val();

        var json = {"userName":username,"password":pwd,"email":email,"address":{"street":street,"city":city,"state":state,"country":country}}
        $.ajax({
    		type: 'PUT',
    		contentType: 'application/json',
    		url: "http://localhost:8080/updateUser/"+username,
    		data:JSON.stringify(json),
    		success: function(data){
    			alert("User profile updated");
    			window.location = '/updateUser/'+username+"?name="+username;
    		},
    		error: function(data){
    			alert("Data entered is incorrect");
    			window.location = '/updateUser/'+username+"?name="+username;
    		}
    	});
    });
    
    $("#updateAddress1").click(function () {
        var username = $("#username").val();
        var pwd = $("#pwd").val();
        
        var email = $("#email").val();
   
        var street = $("#street").val();
        var city = $("#city").val();
        var state = $("#state").val();
        var country = $("#country").val();

        var json = {"userName":username,"password":pwd,"email":email,"address":{"street":street,"city":city,"state":state,"country":country}}
        var msg="";

        $.ajax({
        	type: 'PUT',
        	contentType: 'application/json',
        	url: "http://localhost:8080/updateuseraddress/"+username,
        	data:JSON.stringify(json),
        	success: function(data){
        		alert("User address updated successfully");
        		window.location = '/updateuseraddress/'+username+"?name="+username;
        	},
        	error: function(data){
        		alert("Data entered is incorrect");
        		window.location = '/updateuseraddress/'+username+"?name="+username;
        	}
        });
    });
});