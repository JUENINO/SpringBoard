<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList, Pkg.Boards.VO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



	<%
	
	

	
	
	
	
		ArrayList<BoardVO> boardList = (ArrayList<BoardVO>)request.getAttribute("boardList");
		ArrayList<MemberVO> memberList = (ArrayList<MemberVO>)request.getAttribute("memberList");
	
	%>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		

		<%--<link rel="stylesheet" href="jscss/css/test.css">  --%>
		<script src="jscss/js/common.js"></script> 
		
		<script>
		
		$(document).ready(
				function(){
					addRowFunc();	   // btnAdd클릭 시 이벤트를 실행하는 함수가 들어있다.
					saveBoardFunc();   //btnSave클릭 시 이벤트 + btnDelete클릭 시 이벤트 가 담겨져있다.
					chkClickFunc();
				}	
			); 
		
		
		
		
		
		
		var addRowFunc = function(){			
					$("#btnAdd").on("click", function(){
						//var Cnt = parseInt($("input[name='idx']:last").val()) + 1 
						var strHTML = "";
						strHTML += '<div name="boardRow" class="bRow">';
						strHTML += '<span class="col1"><input type="checkbox" name="chk"/></span>';
						strHTML += '<span class="col2"><input type="text" name="idx" style="width:90px" /></span>';
						strHTML += '<span class="col3"><input type="text" name="title" style="width:180px" /></span>';
						strHTML += '<span class="col4">';
						strHTML += '<select name="userID">';
						<%
  //★★ 일단 추가하는 행에도, 멤버들을 selectbox로 보내주기 위해서, 컨트롤러에서 받는 값은 맨 위로 올려서, 여기서 쓸 수 있게한다.						
							for(MemberVO mvo : memberList){
						%>
						
							strHTML += '<option value="<%=mvo.getUserID()%>"><%=mvo.getUserName()%></option>';
						
						<% 
							}
						%>
						strHTML += '</select>';
						strHTML += '</span>';					
						strHTML += '<span><input type="hidden" style="width:90px" name="status" value="I" /></span>'
						strHTML += '</div>';
						
						
						$("#board").append(strHTML);
					}); //on	
		} //end
			
			
			
		//기존에 존재하는 리스트의 title과 selectBox에  onchange가 실행되면,  실행되는 함수.
			var titleChg = function(chgNumber){
				var objStatus = document.getElementsByName("status");
				objStatus[chgNumber].value = "U";
			} 
		
		
		//input name=chk 이벤트 함수 // 전체체크 기능 활성화
		var chkClickFunc = function(){
			$("input[name='headChk']").on("click", function(){
			  	if($(this).is(":checked")){
			  		$("input[name='chk']").prop("checked", true);
			  	} else{
			  		$("input[name='chk']").prop("checked", false);
			  	}
			}
		   );//click
		}
			
		
		//document.ready에 붙어있는 함수들
		var saveBoardFunc = function(){
			$("#btnSave").click(					
					function(){
						$("#boardForm").attr("action", "saveBoard");
						$("#boardForm").submit();						
					}
			); //click
			$("#btnDelete").click(					
					function(){
						btnDelClick();	
					}
			); //click
		}
		
		
		
		//바로 위 btnDelete클릭 시 호출되는 함수
		var btnDelClick = function(){	
			
			/*/////////////////////////////////////////////////////////////
			var chkCnt = document.getElementsByName("chk");
			
			var ischk = false;
			for(var i = 0; i<chkCnt.length;i++){
				if(chkCnt[i].checked == true){
					
				} 
			}
			*///////////////////////////////////////////////////////////////////
			
			isCheck = false;
			//하나라도 있으면 true를 만들자, 하나라도없으면 삭제할데이터가 없다고 경고.
			$("input[name='chk']").each(
				function(){
					if($(this).is(":checked")){
						isCheck = true;
					}
				}
			); //each
			
			if(!isCheck){
				//console.log("!@#123");
				alert("삭제할 데이터가 없습니다.");
				return;
			}
			
			
			var formID = "delForm";
			var formAction = "deleteBoard";
			var formMethod = "post";
			var formNames = [];
			var formvals = [];
			
			var i = 0;
			$("input[name='chk']").each(
					function(){ 
					if($(this).is(":checked")){
						formvals[i] = $(this).val(); //히든박스 값
						formNames[i] = "delChk";     //히든박스 이름
						i += 1;
					}			
				}	
			); // each
			
			var submitObj = new objectSubmit(formID, formAction, formMethod, formNames, formvals);
			submitObj.linkSubmit();
			
			//즉, delete버튼 클릭 시 , '체크'되어 있는, 값들을 히든박스에 숨겨서, form태그 action="deleteBoard"에 의해 보낸다.
		}
		
					
			
		
		</script>

    


	<style>
	
		.bRow{
			width:610px;
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
	<form name="boardForm"  method="post" id="boardForm">
		<div>
			<input type="button" value="조회" id="btnSearch" />
			<input type="button" value="추가" id="btnAdd"/>
			<input type="button" value="저장" id="btnSave"/>
			<input type="button" value="삭제" id="btnDelete"/>
		</div>

		<div id="board" class="">
			<div id="boardTitle" class="bRow">
				<span class="col1"><input type="checkbox" name="headChk"/></span>
				<span class="col2">글번호</span>
				<span class="col3">글제목</span>
				<span class="col4">작성자</span>
				<span></span>
			</div>
			
			<%
			int i = 0;
			for(BoardVO vo : boardList){ 
				
			%>
			<div name="boardRow" class="bRow">
				<span class="col1"><input type="checkbox" name="chk" value="<%=vo.getIdx()%>"/></span>
				<span class="col2"><input type="text" name="idx" style="width:90px" value="<%=vo.getIdx()%>" readonly /></span>
				<span class="col3"><input type="text" name="title" style="width:180px" value="<%=vo.getTitle()%>" onchange="titleChg(<%=i%>);"/></span>
				<span class="col4">
					<select name="userID" onchange="titleChg(<%=i%>);">
					<% for(MemberVO mvo : memberList) {%>
						<option value="<%=mvo.getUserID()%>"
						<%if (vo.getUserID().equals(mvo.getUserID())){ %>
						selected
						<%} %>
						
						><%=mvo.getUserName() %></option>
					<%} %>
					</select>
				</span>
				<span><input type="hidden" style="width:90px" name="status"/></span>
			</div>
			<%
				i = i + 1;
			} %>
			
		</div>
	</form>	
		<p>
		
		
		
		
		<%-- 
		<div>
			<input type="button" value="조회" id="btnSearch" />
			<input type="button" value="추가" id="btnAdd"/>
			<input type="button" value="저장" id="btnSave"/>
			<input type="button" value="삭제" id="btnDelete"/>
		</div>
		
		
		
		<div id="board2" class="">
			<div id="boardTitle2" class="bRow">
				<span class="col1"><input type="checkbox" /></span>
				<span class="col2">글번호</span>
				<span class="col3">글제목</span>
				<span class="col4">작성자</span>
				<span class="col2">&nbsp;</span>
			</div>
			
			<%
			
			for(BoardVO vo : boardList){ 
				
			%>
			<div name="boardRow2" class="bRow">
				<span class="col1"><input type="checkbox" name="chk2"/></span>
				<span class="col2"><input type="text" name="idx2" style="width:90px" value="<%=vo.getIdx()%>" readonly /></span>
				<span class="col3"><input type="text" name="title2" style="width:200px" value="<%=vo.getTitle()%>"/></span>
				<span class="col4">
					<select name="userID2" ">
					<% for(MemberVO mvo : memberList) {%>
						<option value="<%=mvo.getUserID()%>"
						<%if (vo.getUserID().equals(mvo.getUserID())){ %>
						selected
						<%} %>
						
						><%=mvo.getUserName() %></option>
					<%} %>
					</select>
				</span>
				<span class="col2"><input type="text" style="width:90px" name="status2"/></span>
			</div>
			<%
			} %>
		</div>
		--%>
</body>
</html>