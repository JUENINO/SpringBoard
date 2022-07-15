<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>



	<style>
		body{
			margin:0px;
			font-size:12px;
		}
	
		.search{
			width:700px;
			border:0px solid red;
			padding: 4px 0px 4px 0px;
			clear: both;
		}
		.row{
			width:700px;
			border:0px solid yellow;
			/*padding: 4px 0px 4px 0px;*/
			clear: both;
		}
		
		.col1{
			border: 1px solid #444;
			width:50px;
			padding: 2px 0px 3px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col2{
			border: 1px solid #444;
			width:170px;
			padding: 4px 0px 4px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col3{
			border: 1px solid #444;
			width:170px;
			padding: 4px 0px 5px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col4{
			border: 1px solid #444;
			width:290px;
			padding: 4px 0px 5px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col5{
			border: 1px solid #444;
			width:10px;
			padding: 4px 0px 5px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		
		
		#wrap{
		
		}
		
	
	</style>
	
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="jscss/js/common.js"></script> 
	<script>
	
	
	
	
	
	
	
	
	
		var selectMembetList = function(){
			var url = "JsonMemberList";
			var type = "post";
			var vars = ["searchMName"];  // 값을 받을 변수명
			var params = [$("input[name='searchMName']").val()];    // 전달한 값(데이터)		
			var async = false;
			var dataType ="json";
			//var dataType = null;
			var sucFunc = function(data){
				
				
				$(data).each(
						function(){					
							var members = this.MemberList;
							var authes = this.AuthList;			
							var strHTML = "";
							var i  = 0;
							$(this.MemberList).each(
									function(){
										alert(this.MID);
										alert(this.MNAME);
									}) // each
							$(members).each(
									function(){
										strHTML += '<div class="row">';
										strHTML += '<span class="col1"><input type="checkbox" name="chk" value="" /></span>';
										strHTML += '<span><input type="text" name="mID" value="' + this.MID + '"  class="col2"  readonly  /></span>';
										strHTML += '<span><input type="text" data="' + i + '" name="mName" value="' + this.MNAME +  '"  class="col3" /></span>';
										strHTML += '<span>';
										strHTML += '	<select name="authID" class="col4" data="' +  i  +'">';
								//0606 현재, 멤버리스트가 가지고 있는 authID와 권한관리가 가지고 있는 authID를 비교해서, 권한을 보여준다.
								// --> 이걸 위해서,memberList를 가져올떄, authID와 authNAme을 챙겨서 가져온것.
										var memberAuth = this.AUTHID;
										$(authes).each(function(){			
											strHTML += '<option value="' +  this.AUTHID +  '"';
											if(memberAuth==this.AUTHID){ strHTML += ' selected';}
											strHTML += '>'+ this.AUTHNAME +  '</option>';
										}); // authes each문
										
										strHTML += '	</select>';
										strHTML += '</span>';
										strHTML += '<span><input type="hidden" name="hiddenVal" value=""  class="col5"  style="width:0px;" /></span>';		
										strHTML += ' <span><input type="hidden" name="mthID" value="' + this.MTHID + '"  class="col5" style="width:0px;" /></span>';
										strHTML += '</div>';
										
										i += 1;
									}
									
							); //members each문	
							$("#showList").html(strHTML);
						}
				); // $(data)  each문		
			
				
		} //suncfuntion 끝
			
			
			var errFunc = function(err){
				alert("통신 실패");
				alert(err);
			}
			
				
			var obj = new ajaxObj(url,type,vars, params,async, dataType,sucFunc, errFunc );
			obj.toJson();
			obj.ajaxExec();
		}//끝
			
		
		
		
		$(document).ready(
				function(){
					selectMembetList();
					
					//조회(btnSearch) 클릭시
					$("#btnSearch").click(
							function(){
								selectMembetList();
							}
					); // btnSearch click
					// 조회(btnSearch) 끝
					
					// 추가(btnAdd) 클릭 시작
					$("#btnAdd").click(
							
							function(){
							
								//1. ajax를 발동해서, data 가져오자.
								var url = "JsonAuthList";
								var type = "post";
								var vars = ["authName"];
								var params = [$("input[name='searchMName']").val()];		
								var async = true;
								var dataType ="json";
								
								var sucFunc = function(data){
									var strHTML = "";
									/*
									$.each(data,
										function(index, item){
										alert(index + " -  "  +  item.AUTHID); 
									}	
									);//each
									*/
									
							
											strHTML += '<div class="row">';
											strHTML += '<span class="col1"><input type="checkbox" name="chk" value="" /></span>';
											strHTML += '<span><input type="text" name="mID" value="NEW MEMBER"  class="col2"  readonly  /></span>';
											strHTML += '<span><input type="text" name="mName" value="" placeholder="회원이름을 입력해주세요" class="col3" /></span>';
											strHTML += '<span>';
											strHTML += '<select name="authID" class="col4">';
											$(data).each( function(){
											strHTML += '	<option value="' + this.AUTHID + '">' + this.AUTHNAME + '</option>';
											});
											strHTML += '</select>';
											strHTML += '</span>';
											strHTML += '<span><input type="hidden" name="hiddenVal" value="I"  class="col5" style="width:0px;" /></span>';
											
											strHTML += '</div>';
											
											$("#showList").append(strHTML);
											}

								var errFunc = function(err){
									alert("통신 실패");
									alert(err);
								}
								var obj = new ajaxObj(url,type,vars, params,async, dataType,sucFunc, errFunc );
								obj.toJson();
								obj.ajaxExec();
								
							}
					); //btnAdd click
					// 추가(btnAdd) 클릭 끝
					
					// "input[name='mName'change 시작
					$("input[name='mName'], select[name='authID']").on("change",
					    	function(){		
					         //var changedIndex = $("input[name='mName']").index(this);
					        var changedIndex = $(this).attr("data");	
					        $("input[name='hiddenVal']").eq(changedIndex).val("U");
					       
					        
					}
					); //on
					// "input[name='mName'change 끝
					
					
						$("#btnSave").click(
								function(){
							$("#memberForm").submit();	
								}
						);
						
						
				} // document.ready function
		); // document ready
		
	</script>

</head>
 <body>
		
		<div id="wrap">
			<div class="search">
				<input type="text" id="search" name="searchMName" value="" />
				<input type="button" value="조회" id="btnSearch" />
				<input type="button" value="추가" id="btnAdd" />
				<input type="button" value="저장" id="btnSave" />
				<input type="button" value="삭제" id="btnDel" />
			</div>
			<div class="row">
				<span  class="col1"><input type="checkbox" name="chkAll" value="" /></span>
				<span class="col2">회원아이디</span>
				<span class="col3">회원이름</span>
				<span class="col4" style="width:288px;">권한</span>
				<span><input type="hidden" name="memberID" value=""  class="col5" style="width:0px;"/></span>
			</div>
			
			<form name="memberForm" id="memberForm" method="post" action="MemberSave">
				<div id="showList"></div>
			</form>

			<!-- 회원리스트 반복구간 시작  -->
			<!-- 
			<div class="row">
				<span class="col1"><input type="checkbox" name="chk" value="" /></span>
				<span><input type="text" name="mID" value=""  class="col2"  readonly  /></span>
				<span><input type="text" name="mName" value=""  class="col3" /></span>
				<span>
					<select name="authID" class="col4">
						<option value=""></option>
						<option value=""></option>
					</select>
				</span>
				<span><input type="text" name="memberID" value=""  class="col5" /></span>		
			</div>
	   		-->
			<!-- 회원리스트 반복구간 끝  -->
			
			
		</div>
			
	
</body>
</html>