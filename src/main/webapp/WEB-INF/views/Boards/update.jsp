<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="Pkg.Boards.VO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>

	<%
		
			//임시로 보내준 리스트 한 줄을 받는다.
			//밑에서 리스트에서 가져온 정보를 textbox에 보여주고, idx는 수정불가.
			//자연스럽게 수정이 완료되고 제출을 하면, updateBoard로 값을 post방식으로 던져준다.
			
			//●●●●●●●●●●
			//jsp에서 updateBoard를 치면 '컨트롤러'에 Mapping되어있는 메소드로 가고,
			//'컨트롤러'에서 updateBoard를 치면 servlet.xml에 지정해놓은 WEB-INF폴더안의 jsp를 찾아간다.
			// 이제 구분이 되도록 servlet.xml이 수정되엇는데, /Boards/updateBoard를 쳐야 jsp파일을 찾아간다.
		BoardVO boardVO = (BoardVO)request.getAttribute("boardVO");
	
	%>


	<div>
		<form name="boardUpdateForm" method="post" action="updateBoard">
			<div>
				작성자 : <input type="text" name="userID" value="<%=boardVO.getUserID()%>" readonly/>
			</div>
			<div>
				글제목 : <input type="text" name="title" value="<%=boardVO.getTitle()%>"/>
			</div>
			<div>
				글번호 : <input type="text" name="idx" value="<%=boardVO.getIdx()%>"/>
			</div>
			<div>
				 <input type="submit" value="확인" />
			</div>
		</form>
	</div>
</body>
</html>