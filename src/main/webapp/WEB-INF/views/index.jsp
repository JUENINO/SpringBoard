
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList" 
 %><!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">


<title>Insert title here</title>


	<style>
		body{
			margin:0px;
			
		}
	</style>




</head>


<body>
 
 	<table cellpadding="0" cellspacing="0" width="1250px" height="630px" align="center" border="1px">
 		<tr>
 			<td width="700px" align="center" valign="middle">
 			    <form name="loginForm" action="AdminLogin" method="post">
 			    	<table cellpadding="0" cellspacing="0" width="400px" align="center" border="1px" >
 						<tr>
 							<td width="100px" height="30px" align="center">
 								아이디
 							</td>
 							<td width="300px" height="30px" align="center">
 								<input type="text" name="adminID" />
 							</td>
 						
 						</tr>
 						<tr>
 							<td width="100px" height="30px" align="center">
 								패스워드
 							</td>
 							<td width="300px" height="30px" align="center">
 								<input type="text" name="adminPass" />
 							</td>
 						</tr>
 						<tr>
 							<td width="400px" height="30px" align="center" colspan="2">
 								<input type="submit" value="로그인" />
 								<a href="AuthManager">로그인</a>
 							</td>
 						</tr>				    	
 			    	</table>
 			    </form>			
 			</td>
 		</tr>
 	</table>
 
</body>
</html>