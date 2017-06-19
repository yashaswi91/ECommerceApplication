$(document).ready(function () {  
$("#register").click(function () {
        var username = $("#username").val();
        var pass = $("#pwd").val();
        var email = $("#email").val();
        var msg;
        var json = {"userName":username, "password":pass,"email":email};
        
        $.ajax({
    		type: 'POST',
    		contentType: 'application/json',
    		url: "http://localhost:8080/registeruser",
    		//dataType: "json",
    		data: JSON.stringify(json),
    		success: function(data){
    			msg = "Registration Successful";
    			window.location = '/login';
    		},
    		error: function(data){
    			msg = "Data entered is incorrect";
    			window.location = '/register';
    			alert("A username already exists");
    		}
    	});
        $("#message2").html(msg);
    });
});
