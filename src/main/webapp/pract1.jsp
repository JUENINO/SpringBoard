<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="jscss/js/common.js"></script>
	
	
	<script>
	
	var test = function(){
		var strHTML = '<tr id="row1"><td width="750px" colspan="7" height="30px">안녕하세요	</td></tr>';
		
		
		$("#row1").appendTo(append(strHTML));
	}
	
	</script>


</head>
<body>




		<table border="1px" width="750px" align="center" cellpadding="0" cellspacing="0" id="subMenuTbl">
					<tr id="row1">
						<td width="750px" colspan="7" height="30px">
						
						안녕하세요
						
						</td>
					</tr>
					<tr>
						<td width="750px" colspan="7" height="30px">
						
						반갑습니다.
						
						</td>
					</tr>
					<tr>
						<td width="750px" colspan="7" height="30px">
						
									<input type="button" onclick="test();" />
						
						</td>
					</tr>
					
					</table>


</body>
</html>