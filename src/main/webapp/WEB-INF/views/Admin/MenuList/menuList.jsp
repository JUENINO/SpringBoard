<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, Pkg.Admin.DTO.MenuDTO" %>  

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴관리</title>

      <!-- 
		  <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  		  <link rel="stylesheet" href="/resources/demos/style.css">
 		-->

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="jscss/js/common.js"></script>
	


	<script>
	
		var rowObj = {
				menuID : "", menuLvl : "", rowIdx : ""
		};
		
	
	
	
	
		//저장하기 전에 값 유효성 체크 시작
		
		var checkVal = function(){
			var isResult = true;
			$("input[name='menuName']").each(
					function(){
						
						var chkInx = $("input[name='menuName']").index(this);
						var objSeq = $("input[name='menuSeq']").eq(chkInx);
						
		
						
						
						if($(this).val().trim().length <= 0 || objSeq.val().trim().length <= 0){
							isResult = false;
						}
						
						
						
					}
			); //each
			if(!isResult){
				alert("메뉴이름은 빈 값일 수 없습니다 !!");
				return;
			}
			
			
			
			
			/*
			$("input[name='menuSeq']").each(
					function(){
						
						var isResult = true;
						if($(this).val().trim().length <= 0 ){
							isResult = false;
						}
						
						if(!isResult){
							alert("메뉴순서는 빈 값일 수 없습니다 !!");
							return;
						}
						
					}
			); //each
			*/
			
			
			
		}
		
		//저장하기 전에 값 유효성 체크 끝
	
		$(document).ready(
			function(){
				
				//조회 버튼 Click Event 시작
				$("#btnSearch").click(
					function(){
						location.href = "MenusList?sMenuName=" + $("#sMenuName").val();
					}		
				);
				//조회 버튼 Click Event 끝
				
				//menuName textbox onchange event 시작
				$("input[name='menuName']").change(
					function(){
						var chgIdx = $("input[name='menuName']").index(this);
						
						$("input[name='hidVal']").eq(chgIdx).val("U");
					}		
				);
				//menuName textbox onchange event 끝
				
				//menuSeq textbox onchange event 시작
				$("input[name='menuSeq']").change(
					function(){
						var chgIdx = $("input[name='menuSeq']").index(this);
						
						$("input[name='hidVal']").eq(chgIdx).val("U");
					}		
				);
				//menuSeq textbox onchange event 끝
				
				//추가버튼 Click Event 시작
				$("#btnAdd").click(
					function(){
						var strHTML = "";
						
						strHTML += '<tr>';
						strHTML += '<td width="50px" height="30px" align="center">';
						strHTML += '	<input type="checkbox" name="chk" />';
						strHTML += '</td>';
						strHTML += '<td width="150px" height="30px" align="center">';
						strHTML += '	<input type="text" name="menuID" value="" style="width:150px;height:30px;" readonly/>';
						strHTML += '</td>';
						strHTML += '<td width="250px" height="30px" align="center">';
						strHTML += '	<input type="text" name="menuName" value="" style="width:250px;height:30px;"/>';
						strHTML += '</td>';
						strHTML += '<td width="75px" height="30px" align="center">';
						strHTML += '	<input type="text" name="menuSeq" value="" style="width:75px;height:30px;"/>';
						strHTML += '</td>';
						strHTML += '<td width="75px" height="30px" align="center">';
						strHTML += '	<input type="text" name="menuLvl" value="" style="width:75px;height:30px;" readonly/>';
						strHTML += '</td>';
						strHTML += '<td width="150px" height="30px" align="center">';
						strHTML += '	<input type="text" name="parentID" value="" style="width:150px;height:30px;" readonly/>';
						strHTML += '</td>';
						strHTML += '<td width="0px" height="30px" align="center">';
						strHTML += '	<input type="hidden" name="hidVal" value="I"/>';
						strHTML += '</td>';
						strHTML += '</tr>';
						
						$("#menuTbl tbody").append(strHTML);
					}		
				);
				//추가버튼 Click Event 끝
				
				
				//저장버튼 Click 시작
				$("#btnSave").click(
						function(){
							checkVal();
							$("#menuForm").submit();
						}
				); //click
				
				//저장버튼 Click 끝
				
				
				//all Chk Event 시작
				
				$("#allChk").click(
						function(){
							var isAllChk = $(this).prop("checked");
							
							if(isAllChk){
						     	$("input[name='chk']").prop("checked", true);
							} else{
								$("input[name='chk']").prop("checked", false);
							}
						}
				); // click
				
				//all Chk Event 끝
				
				
				//삭제버튼 Click 시작 
				
				$("#btnDel").click(
						function(){
							
							/*
							var isConfirm = confirm("정말 삭제하시겠습니까??");
							
							if(!isConfirm){
								return;
							}
							*/
						
							    //$( "#dialog" ).dialog();
						
							
							
							var chkValues = [];
							$("input[name=chk]").each(
									function(){
										if($(this).prop("checked")){
											chkValues.push($(this).val());
										}									
									}						
							); //each 
							
							alert("delFunc");
							
							var strHTML ="";
							strHTML += "<form id='delForm' action='delMenus' method='post'>";
							for(var i=0; i<chkValues.length; i++){
								strHTML += "<input type='hidden' name='delMenuID' value'" + chkValues[i] +"' />"; 
							}
							
							strHTML += "</form>";
							
							$("body").append(strHTML);
							$('#delForm').submit();
							
							console.log(strHTML);
							
							
							
							
							
						}
				); //click
				
				//삭제버튼 Click 끝
				
				//row Click Event 시작
				
				$("tr[name='row']").click(
						function(){

							//tr 이벤트 전에, 우리는 선택된 row의 menuID를 찾아야한다.
							
							var selectIndex = $(this).index();
							var selectedMenuID = $("input[name='menuID']").eq(selectIndex - 2).val();
							
							alert(selectedMenuID);
							
							
							$.ajax(
									{
										url : "SubMenuList",
										data : {menuID : selectedMenuID},
										type : "post",
										async : true,
										dataType : "json",
										//contentType : "application/json",
										success : function(datas){
											alert("성공!");
											var strHTML ="";
											$(datas).each(
													function(){				
														var eachLvl = (this.MENULVL-1) * 30;
														strHTML += '<tr name="subRow" onclick="rowChk(this)">';
														strHTML += '<td width="50px" height="30px" align="center">';
														strHTML += '	<input type="checkbox" name="allSubChk" id="subChk" />';
														strHTML += '</td>';
														strHTML += '<td width="150px" height="30px" align="center">';
														strHTML += '		<input type="text" name="subMenuID" value="' + this.MENUID +  '" style="width:100%;height:100%;" />';
														strHTML += '</td>';
														strHTML += '<td width="250px" height="30px" align="center">';
													    strHTML += '	<input type="text" name="subMenuName" value="' + this.MENUNAME +  '" style="width:100%;height:100%;padding-left:'+ eachLvl +  'px;" onchange="updateHid(this)" />';
														strHTML += '</td>';
														strHTML += '<td width="75px" height="30px" align="center">';
														strHTML += '	<input type="text" name="subMenuSeq" value="' + this.MENUSEQ +  '" style="width:100%;height:100%" onchange="updateHid(this)"/>';
														strHTML += '</td>';
														strHTML += '<td width="75px" height="30px" align="center">';
														strHTML += '	<input type="text" name="subMenuLvl" value="' + this.MENULVL +  '" style="width:100%;height:100%" onchange="updateHid(this)"/>';
														strHTML += '</td>';
														strHTML += '<td width="150px" height="30px" align="center">';
														strHTML += '	<input type="text" name="subParentID" value="' + this.PARENTID +  '" style="width:100%;height:100%" />';
										            	strHTML += '</td>';
												    	strHTML += '<td width="0px" height="30px" align="center">';
														strHTML += '<input type="text" name="subHidVal" value="" style="width:100%;height:100%" />';
														strHTML += '</td>';
							      						strHTML += '</tr>';
													}
													
											);//each
											
											$("#subMenuTbl tbody").append(strHTML);
											
											
											
										},
										error : function(){
											alert("실패");
										}
									}	
								  )
								  
						}
				); //click
				
				// row Click Event 끝
				
				/************* 주메뉴 관련 이벤트 끝 ****************************************************************************************/
				/*****************************************************************************************************/
				/************ 서브메뉴 관련 이벤트 시작 *****************************************************************************************/
				
				
				
				
				
				
				
				
				
				//btnSubAdd Click Event 시작
				$("#btnSubAdd").click(
						function(){
							
							var objSelectedRow = $("tr[name='subRow']").eq(rowObj.rowIdx);
							var addsubMenuLvl = parseInt(rowObj.menuLvl) + 1;
							
							
							var addParentID =  rowObj.menuID;
							
							var strHTML = "";
							strHTML += '<tr name="subRow" onclick="rowChk(this)" >';
							strHTML += '<td width="50px" height="30px" align="center">';
							strHTML += '	<input type="checkbox" name="allSubChk" id="subChk" />';
							strHTML += '</td>';
							strHTML += '<td width="150px" height="30px" align="center">';
							strHTML += '		<input type="text" name="subMenuID" value="" style="width:100%;height:100%;" readonly  />';
							strHTML += '</td>';
							strHTML += '<td width="250px" height="30px" align="center">';
						    strHTML += '	<input type="text" name="subMenuName" value="" style="width:100%;height:100%;" />';
							strHTML += '</td>';
							strHTML += '<td width="75px" height="30px" align="center">';
							strHTML += '	<input type="text" name="subMenuSeq" value="" style="width:100%;height:100%" />';
							strHTML += '</td>';
							strHTML += '<td width="75px" height="30px" align="center">';
							strHTML += '	<input type="text" name="subMenuLvl" value="' + addsubMenuLvl +  ' " style="width:100%;height:100%" />';
							strHTML += '</td>';
							strHTML += '<td width="150px" height="30px" align="center">';
							strHTML += '	<input type="text" name="subParentID" value="' + rowObj.menuID + '" style="width:100%;height:100%" />';
			            	strHTML += '</td>';
					    	strHTML += '<td width="0px" height="30px" align="center">';
							strHTML += '<input type="text" name="subHidVal" value="I" style="width:100%;height:100%" />';
							strHTML += '</td>';
      						strHTML += '</tr>';
      						$("#subMenuTbl tbody").append(strHTML);
						}
				)// click
					
				
				//btnSubAdd Click Event 끝
				/******************************************************************************************************/
				/***************subHidVal***************************************************************************************/
				$("input[name='subMenuName']").change(
					function(){
						var chgIdx = $("input[name='subMenuName']").index(this);
						
						$("input[name='subHidVal']").eq(chgIdx).val("U");
					}		
				);
				//menuName textbox onchange event 끝
				
				//menuSeq textbox onchange event 시작
				$("input[name='subMenuSeq']").change(
					function(){
						var chgIdx = $("input[name='subMenuSeq']").index(this);
						
						$("input[name='subHidVal']").eq(chgIdx).val("U");
					}		
				);
				
				/******************************************************************************************************/
				
				
				
				//  btnSubSave Click event 시작
				 
				
				$("#btnSubSave").click(
						function(){
							/*
							var datas = 
						[	
							
							{									
								 menuID : "", menuName : "",  menuSeq : "", menuLvl : "", parentID : "", hidVal : "" 										
							}
						
						]	
							
							*/
							
							var sendJsonDatas = {};
							var sendDatas = [];
							for(var i = 0; i<$("input[name='subMenuID']").length; i++){
								var eachRowData = {};
								eachRowData.menuID = $("input[name='subMenuID']").eq(i).val();
								eachRowData.menuName = $("input[name='subMenuName']").eq(i).val();
								eachRowData.menuSeq = $("input[name='subMenuSeq']").eq(i).val();
								eachRowData.menuLvl = $("input[name='subMenuLvl']").eq(i).val();
								eachRowData.parentID = $("input[name='subMenuLvl']").eq(i).val();
								eachRowData.hidVal = $("input[name='subHidVal']").eq(i).val();
								
								
							
							
								
								
								
								// 아직 hidVal에 U를 주는 로직을 처리 안했다.
								if(eachRowData.hidVal == "U" || eachRowData.hidVal == "I" ){
									
									sendDatas.push(eachRowData);
							
								}
							}
							
							
							sendJsonDatas.saveList = sendDatas;
							alert(sendJsonDatas);
							console.log(JSON.stringify(sendJsonDatas));
							
							
							
							$.ajax(
									
										{
											url : "saveSubMenu",
											data : JSON.stringify(sendJsonDatas),
											type : "post",
											async : true,
											dataType : "html",
											contentType : "application/json",
											success : function(datas){
												alert("성공!");			
											},
											error : function(){
												alert("실패");
											}				
										}	 // ajax {}
									  
							
									) // ajax
						}
				);  //click
				
								
				//  btnSubSave Click event 끝
				
				/***************서브메뉴 관련 이벤트 끝**************************************************************************************/
				/*****************************************************************************************************/
				
				
			}	//document function
		);  	//document 
		
		
		var updateHid = function(eventObj){
			var selectedIdx = $("input[name='" + eventObj.name + "']").index(eventObj);
			
			$("input[name='subHidVal']").eq(selectedIdx).val("U");
		}
		
		
		//	menuID : "", menuLvl : "", rowIdx : ""
		var rowChk = function(selectedObj){
			var selectedIdx = $("tr[name='subRow']").index(selectedObj);
			rowObj.menuID = $("input[name='subMenuID']").eq(selectedIdx).val();
			rowObj.menuLvl = $("input[name='subMenuLvl']").eq(selectedIdx).val();
			rowObj.rowIdx = selectedIdx;
			
			alert(rowObj.menuID + " - " + rowObj.menuLvl  + " - " + rowObj.rowIdx); 
		};
		
	
		
		
		
		
		 
		
		
		
	</script>

</head>
 

<%
	List<MenuDTO> menuList = (List<MenuDTO>)request.getAttribute("menuList");
%>

<body>


	<table border="1px" width="1500px" align="center" cellpadding="0" cellspacing="0" >
		<tr>
			<td width="750px" align="center" valign="top">
			<form name="menuForm" id="menuForm" action="SaveMenu" method="post" >
				<table border="1px" width="750px" align="center" cellpadding="0" cellspacing="0" id="menuTbl">
					<tr>
						<td width="750px" colspan="7" height="30px">
							<input type="text" name="sMenuName" id="sMenuName" />
							<input type="button" value="조회" id="btnSearch"/>
							<input type="button" value="저장" id="btnSave" />
							<input type="button" value="추가" id="btnAdd" />
							<input type="button" value="삭제" id="btnDel" />
						</td>
					</tr>
					<tr>
						<td width="50px" height="30px" align="center">
							<input type="checkbox" name="allChk" id="allChk" />
						</td>
						<td width="150px" height="30px" align="center">
							메뉴아이디
						</td>
						<td width="250px" height="30px" align="center">
							메뉴명
						</td>
						<td width="75px" height="30px" align="center">
							순서
						</td>
						<td width="75px" height="30px" align="center">
							레벨
						</td>
						<td width="150px" height="30px" align="center">
							부모아이디
						</td>
						<td width="0px" height="30px" align="center">
							
						</td>
					</tr>
					
					<% 
						for(MenuDTO dto : menuList){
					%>
					<tr name="row">
						<td width="50px" height="30px" align="center">
							<input type="checkbox" name="chk" value="<%=dto.getMenuID() %>"/>
						</td>
						<td width="150px" height="30px" align="center">
							<input type="text" name="menuID" value="<%=dto.getMenuID() %>" style="width:150px;height:30px;" readonly/>
						</td>
						<td width="250px" height="30px" align="center">
							<input type="text" name="menuName" value="<%=dto.getMenuName() %>" style="width:250px;height:30px;"/>
						</td>
						<td width="75px" height="30px" align="center">
							<input type="text" name="menuSeq" value="<%=dto.getMenuSeq() %>" style="width:75px;height:30px;"/>
						</td>
						<td width="75px" height="30px" align="center">
							<input type="text" name="menuLvl" value="<%=dto.getMenuLvl() %>" style="width:75px;height:30px;" readonly/>
						</td>
						<td width="150px" height="30px" align="center">
							<input type="text" name="parentID" value="<%=dto.getParentID() %>" style="width:150px;height:30px;" readonly/>
						</td>
						<td width="0px" height="30px" align="center">
							<input type="hidden" name="hidVal" />
						</td>
					</tr>
					<%
						}
					%>
					
					
				</table> 
				</form>
			</td>
			
			<td width="750px" align="center" valign="top">
			<!--  서브메뉴 시작  -->
				<table border="1px" width="750px" align="center" cellpadding="0" cellspacing="0" id="subMenuTbl">
					<tr>
						<td width="750px" colspan="7" height="30px">
							<input type="text" name="sSubMenuName" id="sSubMenuName" />
							<input type="button" value="조회" id="btnSubSearch"/>
							<input type="button" value="저장" id="btnSubSave" />
							<input type="button" value="추가" id="btnSubAdd" />
							<input type="button" value="삭제" id="btnSubDel" />
						</td>
					</tr>
					<tr>
						<td width="50px" height="30px" align="center">
							<input type="checkbox" name="allSubChk" id="allSubChk" />
						</td>
						<td width="150px" height="30px" align="center">
							메뉴아이디
						</td>
						<td width="250px" height="30px" align="center">
							메뉴명
						</td>
						<td width="75px" height="30px" align="center">
							순서
						</td>
						<td width="75px" height="30px" align="center">
							레벨
						</td>
						<td width="150px" height="30px" align="center">
							부모아이디
						</td>
						<td width="0px" height="30px" align="center">
							
						</td>
					</tr>
					
					<!--  
					<tr>
						<td width="50px" height="30px" align="center">
							<input type="checkbox" name="chk" />
						</td>
						<td width="150px" height="30px" align="center">
							<input type="text" name="menuID" value="" style="width:100%;height:100%"/>
						</td>
						<td width="250px" height="30px" align="center">
							<input type="text" name="menuName" value="" style="width:100%;height:100%"/>
						</td>
						<td width="75px" height="30px" align="center">
							<input type="text" name="menuSeq" value="" style="width:100%;height:100%"/>
						</td>
						<td width="75px" height="30px" align="center">
							<input type="text" name="menuLvl" value="" style="width:100%;height:100%"/>
						</td>
						<td width="150px" height="30px" align="center">
							<input type="text" name="parentID" value="" style="width:100%;height:100%"/>
						</td>
						<td width="0px" height="30px" align="center">
							<input type="text" name="hidVal" value="" style="width:100%;height:100%"/>
						</td>
					</tr>
					-->
					
				</table>
			<!--  서브메뉴 끝 -->	
			</td>
		</tr>
		
		      
					
				
	</table>
	
	<!--  
	<div id="dialog" title="Basic dialog">
 
	</div>
   -->
</body>
</html>