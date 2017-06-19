$(document).ready(function () {
    $("#login").click(function () {
        var username = $("#username").val();
        var pass = $("#pass").val();
        var url = "http://localhost:8080/getusername/"+username;
        
        $.get(url, function(data, status){
            	if(data.userName==username && data.password==pass){
            		window.location = "/home"+"?name="+username;
            	}
            	else{
                    alert("Invalid username/password");            		
            	}
        });
    });
});