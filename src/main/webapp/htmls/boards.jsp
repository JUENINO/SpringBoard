<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


	<style>
	
		.bRow{
			width:510px;
			height:30px;
			border: 0px solid #777;
			clear:both;			
		}
		
		.col1{
			width:50px;
			font-size:12px;
			text-align:center;
			padding:6px 0px 5px 0px;
			border:1px solid #999;
			display: block;
			float: left;
		}
		.col2{
			width:100px;
			font-size:12px;
			text-align:center;
			padding:8px 0px 5px 0px;
			border:1px solid #999;
			display: block;
			float: left;
		}
		.col3{
			width:200px;
			font-size:12px;
			text-align:center;
			padding:8px 0px 5px 0px;
			border:1px solid #999;
			display: block;
			float: left;
		}
		.col4{
			width:150px;
			font-size:12px;
			text-align:center;
			padding:8px 0px 5px 0px;
			border:1px solid #999;
			display: block;
			float: left;
		}
	
	</style>

</head>
<body>

		<div>
			<input type="button" value="조회" id="btnSearch" />
			<input type="button" value="추가" id="btnAdd"/>
			<input type="button" value="저장" id="btnSave"/>
			<input type="button" value="삭제" id="btnDelete"/>
		</div>

		<div id="board" class="">
			<div id="boardTitle" class="bRow">
				<span class="col1"><input type="checkbox" /></span>
				<span class="col2">글번호</span>
				<span class="col3">글제목</span>
				<span class="col4">작성자</span>
			</div>
			
			<div name="boardRow" class="bRow">
				<span class="col1"><input type="checkbox" /></span>
				<span class="col2">1</span>
				<span class="col3">안녕하세요</span>
				<span class="col4">
					<select>
						<option value="USER01">HONG</option>
						<option value="USER02">KANG</option>
						<option value="USER03">CHOI</option>
						<option value="USER04">LEE</option>
					</select>
				</span>
			</div>
		</div>
</body>
</html>