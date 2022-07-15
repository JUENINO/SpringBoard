<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


			

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="jscss/js/common.js"></script> 
		
		
		<script>
		 
		
		
			var firstPage = function(){
				
			}
			
			
		</script>
 


</head>

	


<body onload="firstPage()">


	<table cellpadding="0" cellspacing="0" width="1250px" height="630px" align="center" border="1px">
		<tr>
			<td width="1250px" height="40px" align="center">
				<table cellpadding="0" cellspacing="0" width="600px">
					<tr>
						<td width="120px" height="40px" align="center">
							<a href="AuthList" target="bodyFrame">권한관리</a>
						</td>
						<td width="120px" height="40px" align="center">
							<a href="MemberList" target="bodyFrame">회원관리</a>
						</td>
						<td width="120px" height="40px" align="center">
							<a href="MenusList" target="bodyFrame">메뉴관리</a>
						</td>
						<td width="120px" height="40px" align="center">
							<a href="ProgramList" target="bodyFrame">프로그램관리</a>
						</td>
						<td width="120px" height="40px" align="center">
							권한별 상세관리
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="1250px" height="40px" align="center">
				<%
					String adminID = (String)session.getAttribute("adminID");
				if(adminID != null){
				%>
				
						<%= adminID %>
						<a href="AdminLogout">로그아웃</a>
					
				<%
				    } 
						else {
										
					}
				%>
				
			</td>
		</tr>
		
		<tr>
			<td width="1250px" height="590px" align="center">
				<iframe name="bodyFrame" src=""
				style="width:1250px;height:580px;border:1px solid red;"></iframe>
			</td>
		</tr>
	</table>


</body>
</html>