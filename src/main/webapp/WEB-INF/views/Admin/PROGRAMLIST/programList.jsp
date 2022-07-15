<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List , Pkg.Admin.DTO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProgramList</title>

	
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
			width:900px;
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
			width:150px;
			padding: 4px 0px 4px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col3{
			border: 1px solid #444;
			width:150px;
			padding: 4px 0px 5px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col4{
			border: 1px solid #444;
			width:230px;
			padding: 4px 0px 5px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		.col5{
			border: 1px solid #444;
			width:150px;
			padding: 4px 0px 5px 0px;
			display:block;
			text-align:center;
			float: left;
		}
		
		
		#wrap{
		
		}
		
	
	</style>
	
	<%
		List<ProgramDTO> programList = (List<ProgramDTO>)request.getAttribute("programList");
		List<MenuDTO> menuList = (List<MenuDTO>)request.getAttribute("menuList");
	   
	%>
	
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="jscss/js/common.js"></script> 
		<script>
		
			
			var getMenuList = function(){
				
				var menuList = null;
				
				$.ajax(
						{
							url : "MenuList",
							//data : "",//{sid: "", sname:""}
							type : "post",
							async : false,
							dataType : "json",
							//contentType : this.contentType,
											
							success : function(resultData){
								menuList = resultData;
								alert(menuList);
								alert(1);
							}
							,
							error : function(){
								alert("err");
							}
							,
							complete : function(){
	
							}
							
						} 
					); //ajax 닫는 괄호
			}
		
		
		
			$(document).ready(
					function(){
						$("#btnSave").click(
								function(){
								var sendData = {};	
										/*
									datas : [
										
										{pid : "", menuID : "", fileName : "", fileUrl:""},
										{pid : "", menuID : "", fileName : "", fileUrl:""},
										{pid : "", menuID : "", fileName : "", fileUrl:""}
										
									]
								*/
								
								
							var datas = new Array();
								
								var pid="";
								var menuID = "";
								var fileName = "";
								var fileUrl = "";
								var hiddenVal = "";
								for(var i = 0 ; i<$("input[name='pid']").length; i++){
									var objRow = {}
									hiddenVal = $("input[name='hidVal']").eq(i).val();
									//hiddenVal의 I와 U는 merge into를 사용하기때문에 쓸모가없다.
									// 바로 아래에 보이는 if문에서 hiddenVal가 있을때에만 저장을 한다는 조건으로 쓰기 위한것.
									
									if(hiddenVal != ""){
										objRow.pID = $("input[name='pid']").eq(i).val();
										objRow.pName = $("input[name='pName']").eq(i).val();
										objRow.menuID = $("select[name='selMenus']").eq(i).val();
										objRow.pFileName = $("input[name='fileName']").eq(i).val();
										objRow.fileUrl = $("input[name='fileUrl']").eq(i).val();
										datas.push(objRow);	
									}
								}
			
						
								sendData.datas = datas;
console.log(JSON.stringify(sendData));
								
								
								
								//	var ajaxObj = function(url, type, vars, params, async, dataType, sucFunc, errFunc, data, contentType)
								
								var suncFunc = function(data){
									if(data.result == "success"){
										alert("저장에 성공!");
									}
								};
								
								var errFunc = function(){
									 alert("Err");
								};
								
								
								var objAjax = new ajaxObj("SaveProgramList" ,"post", "", "", true, "json", suncFunc, errFunc, JSON.stringify(sendData), "application/json")
								
								objAjax.ajaxExec();
								
console.log(objAjax);
								
								}		
						); //  save  click
					
						
				//change Event 시작-------------------------------------------------------------------------------		
						$("select[name='selMenus']").change(
								function(){
									var selectedIdx = $(this).attr("idx");
									
									$("input[name='hidVal']").eq(selectedIdx).val("U");
								}
						); // select change
						
						
						$("input[name='fileName']").change(
								function(){
									var selectedIdx = $(this).attr("idx");
									
									$("input[name='hidVal']").eq(selectedIdx).val("U");
								}
						); // input fileName change
						
						
						$("input[name='fileUrl']").change(
								function(){
									var selectedIdx = $(this).attr("idx");
									
									$("input[name='hidVal']").eq(selectedIdx).val("U");
								}
						); // input fileUrl change
				//change Event 끝-------------------------------------------------------------------------------	
						
				
				
				
				//btnAdd 추가 시작
				$("#btnAdd").click(
						
						//AJAX를 활용해서 이 menuData를 실시간으로 가져오자. --> 홈페이지 오랫동안 머문 사이에 데이터가 추가되면 데이터를 못보는 경우를 방지.
						
						function(){
						//var menuList = 	getMenuList();
						//alert(menuList);
							$.ajax(
						{
							url : "MenuList",
							//data : "",//{sid: "", sname:""}
							type : "post",
							async : false,
							dataType : "json",
							//contentType : this.contentType,
											
							success : function(result){
								//alert(result);

								var rowHTML = "";	
								rowHTML += '<div class="row">';
								rowHTML += '<span class="col1"><input type="checkbox" name="chk" /></span>';
								rowHTML += '<span class="col2"><input type="text" name="pid" value=""  class="col2"/></span>';
								rowHTML += '<span class="col4"><input type="text" value="" class="col2"/></span>';
								rowHTML += '<span class="col2">';									
								rowHTML += '<select name="selMenus">';
								rowHTML += '	 <option value="">---선택해주세요---</option>';
								$(result).each(
										function(){
											rowHTML += ' <option value="' + this.menuID + '">'+ this.menuName + '</option>';
										}
								); //each
								rowHTML += '</select>';
								rowHTML += '</span>';
								rowHTML += '<span class="col2"><input type="text"  name="fileName"   class="col2" /></span>';
								rowHTML += '<span class="col2"><input type="text" name="fileUrl"  class="col2" /></span>';
								rowHTML += '<span><input type="hidden" name="hidVal" value="I" /></span>';
								rowHTML += '</div>';
								
								$("#rows").append(rowHTML);
								
							}
							,
							error : function(){
								alert("err");
							}
							,
							complete : function(){
	
							}
							
						} 
					); //ajax 닫는 괄호
						
						
						
						
						
						
							
						
						
						} //btnAdd click function
				); // btnAdd click
				
	
				$("#btnSearch").click(
						function(){
							
							var value = [];
								
							value[0] = $("#search").val();

							

							//var pName = [];
							//pName[0] = "pName";
							var pName = ["pName"];
							
							
							var result = new objectSubmit("searchID", "ProgramList", "post", pName, value );
							
							result.linkSubmit();

					
							
						
							
						
							/*
							var objectSubmit = function(formID, formAction, formMethod, hiddenNames, hiddenVals){
							this.formID = formID;     			 //단일값
							this.formAction = formAction;		//단일값
							this.formMethod = formMethod;		//단일값
							this.hiddenNames = hiddenNames;		//배열값
							this.hiddenVals = hiddenVals;	    //배열값
							
							this.linkSubmit = function(){
								var strHTML = "<form action='" + this.formAction + "' method='" + this.formMethod + "' id='" + this.formID + "'>";
								for(var i=0;i<this.hiddenNames.length;i++){
									strHTML += "<div>";
									strHTML += "<input type='hidden' name='" + this.hiddenNames[i] + "' value='" + this.hiddenVals[i] + "' />";
									strHTML += "</div>";
								}
								strHTML += "</form>";
								
								$("body").append(strHTML);
								$("#" + this.formID).submit();
							};
						*/
							}
				); // btnSearch click 끝
				
				
				//allChk 체크 시작 
				$("#allChk").click(
						function(){
							if($(this).prop("checked")){
								$("input[name='chk']").prop("checked", true);
							} else{
								$("input[name='chk']").prop("checked", false);
							}
						
						}
				); // allChk click			
				//allChk 체크 끝 
				
				
				//btnDel() click Event 시작
				$("#btnDel").on("click", 
						function(){
							
							//1. 유효성 검사. 체크된게 하나도 없다면 경고창.
							
							if(!$("input[name='chk']").prop("checked")){
								alert("삭제할 데이터가 없습니다.");
								return;
							} else{
								
							
								var sendDatas = {};
								var arrDatas = [];
							$("input[name='chk']").each(
									function(){
										if($(this).prop("checked")){
											var rowData = {};
											
											rowData.pID = $(this).val();
											arrDatas.push(rowData);

										}
									}
							); //each
											
							sendDatas.delpID = arrDatas;
											
							$.ajax(
									{
										url : "MenuDel",
										data : JSON.stringify(sendDatas),
										type : "post",
										async : true,
										dataType : "json",
										contentType : "application/json",
										
										success : function(datas){
											alert("통신 성공");
											
											console.log(JSON.stringify(datas));
											//$("#btnSearch").click();
											var strHTML = "";
											
											var i = 0;
											
											$(datas).each(
												function(){
													var menus = this.menus;
													var menuID = this.menuID;
													strHTML += '<div class="row">';
													strHTML += '<span class="col1"><input type="checkbox" name="chk" value=" '+ this.pID +  '" /></span>';
													strHTML += '<span class="col2"><input type="text" name="pid" value="'+ this.pID + '"  class="col2"/></span>';
													strHTML += '<span class="col4"><input type="text" value="'+ this.pName + '"  class="col2" name="pName"/></span>';
													strHTML += '<span class="col2">';

													strHTML += ' <select name="selMenus" idx="'+ i + '">';
													strHTML += '<option>---선택해주세요---</option'>;
													$(menus).each(
															
													strHTML +=  '<option value="' + this.menuID + '"
													if( menuID == this.menuID){
														strHTML += 'selected';
													}												
													strHTML += '>' + this.menuName + '</option>';
													)
													strHTML += ' </select>';
													strHTML += ' </span>';
													strHTML += '<span class="col2"><input type="text" idx="'+ i + '" name="fileName" value="'+ this.pFileName + '"  class="col2" /></span>';
													strHTML += '<span class="col2"><input type="text" idx="'+ i + '" name="fileUrl" value="'+ this.fileUrl + '"  class="col2" /></span>';
													strHTML += '<span><input type="hidden" name="hidVal" value="" /></span>';
													strHTML += '</div>';
													i++;
												}
											); //each
											
											//$()
											
											
											/*
											내가 짠 로직, 메뉴리스트 다시 보여주기 위해서
											var result = new objectSubmit("return", "ProgramList", "post", "", "" );							
											result.linkSubmit();
										   */
										},
											
											
										error : function(){
											alert("통신 에러");
										}
									}	
								 ); // ajax 끝 			
							
							}
					
						}
						
				); // on
				//btnDel() click Event 끝
				
						
					}
			); //ready
		
			
			
		</script>
	
	
	
	
	
	
	


</head>
<body>
	
		<div>
		
			<input type="text" name="search" id="search" />
			<input type="button" name="btnSearch" id="btnSearch" value="조회" />
			<input type="button" name="btnAdd" id="btnAdd" value="추가" />
			<input type="button" name="btnSave" id="btnSave" value="저장" />
			<input type="button" name="btnDel" id="btnDel" value="삭제" />
		</div>
	
	
			<div class="row">		
				<span class="col1"><input type="checkbox" name="allChk" id="allChk" /></span>
				<span class="col2">아이디</span>
				<span class="col4">프로그램명</span>
				<span class="col2">연결메뉴</span>
				<span class="col2">JSP 파일명</span>
				<span class="col2">URL</span>
				<span></span>
			</div>	
			
		
		<div id="rows">
		<% 
		int i = 0;
		for(ProgramDTO dto : programList){ 		
		%>
	
			<div class="row">
				<span class="col1"><input type="checkbox" name="chk" value="<%=dto.getpID() %>" /></span>
				<span class="col2"><input type="text" name="pid" value="<%=dto.getpID() %>"  class="col2"/></span>
				<span class="col4"><input type="text" value="<%=dto.getpName() %>"  class="col2" name="pName"/></span>
				<span class="col2">
				 <!--  select 할 곳 -->
				 	<select name="selMenus" idx="<%=i%>">
				 		<option value="">---선택해주세요---</option>
				 		<%for(MenuDTO mdto : menuList){ %>
				 		<option value="<%=mdto.getMenuID()%>" <% if(dto.getMenuID().equals(mdto.getMenuID())){ %> selected <% } %> ><%= mdto.getMenuName() %></option>
				 		<%} %>
				 	</select>
				</span>
				<span class="col2"><input type="text" idx="<%=i%>" name="fileName" value="<%=dto.getpFileName() %>"  class="col2" /></span>
				<span class="col2"><input type="text" idx="<%=i%>" name="fileUrl" value="<%=dto.getFileUrl() %>"  class="col2" /></span>
				<span><input type="hidden" name="hidVal" value="" /></span>
			</div>	
			
		<%
		
		i += 1;
		} %>
		</div>	

		




</body>
</html>