 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, Pkg.Admin.DTO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권한관리</title>

	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="jscss/js/common.js"></script> 
		<%
						
						List<AuthDTO> authList = (List<AuthDTO>)request.getAttribute("authList");
						String SauthName = (String)request.getAttribute("authName");
						
						SauthName = (SauthName == null) ? "" : SauthName;
						
			%>
		
		<script>
			$(document).ready(
				function(){
					$("#btnSearch").on("click", function(){
						location.href="AuthList?SauthName=" + $("#SauthName").val();
					}
					); //on
					
					$("#btnAdd").click(
						function(){
							var strHTML = "";
							
							strHTML += "<tr>";
							strHTML += '<td width="100px" height="30px" align="center" >';
							strHTML += '<input type="checkbox" name="chk" id="" value="" />';
							strHTML += '<td width="200px" height="30px" align="center" >';
							strHTML += '<input type="text" name="authID" value="NEW AUTHID" style="width:98%; height:98%" readonly />';
							strHTML += '</td>';
							strHTML += '<td width="400px" height="30px" align="center" >';
							strHTML += '<input type="text" name="authName" '; 
							strHTML += 'style="width:98%;height:100%"';
							strHTML += ' />';
							strHTML += '</td>';	
							strHTML += '<td width="0px" height="30px" align="center" >';
							strHTML += '<input type="hidden" name="gbn"  value="I" '; 
							strHTML += 'style="width:0px;"';
							strHTML += ' />';
							strHTML += '</td>';
							strHTML += "</tr>";
							$("#authTbl tbody").append(strHTML);
							
						}		
					); // click 
					
					// authName에 대한 change Event 시작!
					$("input[name='authName']").change(
						function(){
							var selectedNum = $(this).attr("data");
							$("input[name='gbn']").eq(selectedNum).val("U");
						}	//change 안의 function	
					); 
					// authName에 대한 change Event 끝!
				
			    //저장버튼(btnSave 클릭이벤트)
				$("#btnSave").click(
						function(){
							var isChk = true;
							$("input[name='authName']").each(
								function(){
									
									if($(this).val() == ""){
										isChk = false;
										
									}
								}	//each function
							); //each
							if(!isChk){
								alert("권한명을 정확하게 입력하세요");
								return;
							}
							$("#authListForm").attr("action", "SaveAuthList");
							$("#authListForm").attr("method", "post");
							$("#authListForm").submit();
						}
				); //btnSave click
				
					//chkAll -- checkbox이벤트 시작!
					$("#chkAll").on("click", function(){
							
							if($(this).prop("checked")){
								$("input[name='chk']").prop("checked", true);								
							} else {
								$("input[name='chk']").prop("checked", false);	
							}
							
					}); // chkAll의 on 이벤트
					/*
					var objectSubmit = function(formID, formAction, formMethod, hiddenNames, hiddenVals){
						this.formID = formID;     			 //단일값
						this.formAction = formAction;		//단일값
						this.formMethod = formMethod;		//단일값
						this.hiddenNames = hiddenNames;		//배열값
						this.hiddenVals = hiddenVals;	    //배열값
				    */
				    $("#btnDelete").click(
				    	function(){
				    		  var hiddenNames = [];
		    				  var hiddenVals = [];
				    	
		    				 var i = 0;
				    		$("input[name='chk']").each(
				    				function(index){
				    				 if($(this).prop("checked")){
				    				
				    					 hiddenNames[i] = "authID";
				    					 hiddenVals[i] = $(this).val();
				    					i = i+1;
				    				 }
				    				}
				    				
				    		); // btnDelete each
				    		 var obj = new objectSubmit("chkForm","DeleteAuth","post", hiddenNames , hiddenVals )
	    					 obj.linkSubmit();
				    	}
				    ); // btnDelete click
				    
				} //ready function()		
			) // ready
			
			
			
		</script>
		

			

</head>
<body>
 	    <form name="authListForm" id="authListForm" action="" method="" >
 	 	<table cellpadding="0" cellspacing="0" width="700px" align="center" border="1" id="authTbl">
 	 		<tr>
 	 			<td width="700px" height="30px" align="center" colspan="4">
 	 				<input type="text" name="SauthName" id="SauthName" value="<%=SauthName %>" />
 	 				&nbsp;&nbsp;&nbsp;
 	 				<input type="button" value="조회" id="btnSearch" />
 	 				<input type="button" value="추가" id="btnAdd" />
 	 				<input type="button" value="저장" id="btnSave" />
 	 				<input type="button" value="삭제" id="btnDelete" />
 	 			</td>
 	 		</tr>
 	 		<tr>
 	 			<td width="100px" height="30px" align="center" >
 	 				<input type="checkbox" name="chkAll" id="chkAll" value="" />
 	 			</td>
 	 			<td width="200px" height="30px" align="center" >
 	 			        권한아이디
 	 			</td>
 	 			<td width="400px" height="30px" align="center" >
 	 				권한이름
 	 			</td>
 	 			<td width="0px" height="30px" align="center" >
 	 				<input type="hidden" />
 	 			</td>
 	 		</tr>
 	 		
 	 		
 	 		<%
 	 		int i = 0;
 	 		for(AuthDTO dto : authList){ 
 	 			
 	 		%>
 	 	      <tr>
 	 			<td width="100px" height="30px" align="center" >
 	 				<input type="checkbox" name="chk" id="" value="<%=dto.getAuthID() %>" />
 	 			</td>
 	 			<td width="200px" height="30px" align="center" >
 	 			      <input type="text" name="authID" value="<%= dto.getAuthID() %>" style="width:98%; height:98%" readonly />
 	 			</td>
 	 			<td width="400px" height="30px" align="center" >
 	 				 <input type="text" data="<%= i %>" name="authName" id="" value="<%= dto.getAuthName() %>" 
 	 				 style="width:98%;height:100%"
 	 				 />
 	 			</td>
 	 			<td width="0px" height="30px" align="center" >
 	 				<input type="hidden" name="gbn" value="" style="width:30px;" />
 	 			</td>
 	 		 </tr>	 		
 	 		<%
 	 			i += 1;
 	 		} %>
 	 		
 	 	</table>
 	    </form>
 	 
</body>
</html>