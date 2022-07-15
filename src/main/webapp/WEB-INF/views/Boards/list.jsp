<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, Pkg.Boards.VO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%

ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("boardList");
for(BoardVO vo : list){
out.println("<div>" + vo.getIdx() + " -  " +  vo.getTitle() +  "  -  "  +   vo.getUserID() +  "<a href='deleteBoard?idx=" + vo.getIdx() + "'>삭제</a><a href='updateForm?idx=" + vo.getIdx()+ "'>수정</a></div>");
}

%>


<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="writeForm">글쓰기</a>
	</div>
</body>
</html>