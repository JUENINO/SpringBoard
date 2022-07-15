<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


  <script>
    var login = function(){
    	alert(123);
    	
        $("#login").submit();
    }
    </script>
<body onload="login">
    
    <form id="login" action="Login" method="post" name="login" >
      <input type="text" name="textb" id="textb"/>
    </form>
    
</body>
</html>



