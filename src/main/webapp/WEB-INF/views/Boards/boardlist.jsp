<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List, Pkg.Boards.VO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");

	for(BoardVO vo : list){
		out.println(vo.getTitle() + "<br/>");
	}
	
%>


</body>
</html>