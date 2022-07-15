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
	
	
	
	
	 var goJSON = function(){
		 

		 var member = {
				 id : "123",
				 name : "abc"
		 }
		 
		 var stringJSONData = JSON.stringify(member);
		 
		 document.getElementById("member").value= stringJSONData;
		 
		 
		 $("input[name=member]").serializeArray(); 
		 
		 document.getElementById("myForm").submit();
		 
		 
	 }
	
	</script>
<%
	  List<PersonVO> members = ( List<PersonVO>)map.get("members");

	매개변수( @RequestBody Map<String, Object> map){ ; ; ; ; };
	
	
	List<PersonVO> memberList = (List<PersonVO>)map.get("members");
	
	map.get("sutdents");


%>


</head>
<body>

	<form name="myForm" action="test2" method="post" id="myForm" enctype="multipart/form-data">
	<!-- 
	<div>
		<input type="text" name="name" value="" />
		<input type="text" name="id" value="" />
	</div>
	<div>
		<input type="text" name="name" value="" />
		<input type="text" name="id" value="" />
	</div>
	<div>
		<input type="text" name="name" value="" />
		<input type="text" name="id" value="" />
	</div>
	
	-->
	<div>
		<input type="hidden" name="member" id="member" />
		<input type="button" value="확인"  onclick= "goJSON()"/>
	</div>
	</form>
</body>
 </html>