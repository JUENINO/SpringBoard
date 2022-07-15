<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form name="boardForm" method="post" action="insertBoard">
			<div>
				작성자 : <input type="text" name="userID" />
			</div>
			<div>
				글제목 : <input type="text" name="title" />
			</div>
			<div>
				글번호 : <input type="text" name="idx" />
			</div>
			<div>
				 <input type="submit" value="확인" />
			</div>
		</form>
	</div>
</body>
</html>