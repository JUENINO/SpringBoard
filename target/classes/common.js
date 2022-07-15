/**
 * 
 */


	


	var ajaxObj2 = {
		
	}

    /*
		최초개발일 : 20220520
		최초개발자 : PL이름
		객체설명 : 
		수정내역
		-------------------------------------------------------------------
		수정일                  수정내용					 수정자
		20220525	   변수명 수정			     최유나
		-------------------------------------------------------------------
	*/
	var ajaxObj = function(url, type, vars, params, async, dataType, sucFunc, errFunc, data, contentType){
		this.url = url;
		this.type = type;
		this.data = data;
		this.vars = vars;
		this.params = params;
		this.async = async;
		this.dataType = dataType;
		this.sucFunc = sucFunc;
		this.errFunc = errFunc;
		this.contentType = contentType;

		this.toJson = function(){
			
			var strJson = "";
			strJson += "{";
				for(var i=0;i<vars.length;i++){
					strJson += "\"" + this.vars[i] + "\"";
					strJson += ":";
					strJson += "\"" + this.params[i] + "\"";
					if(i != vars.length - 1){
						strJson += ",";
					}
				}
			strJson += "}";
			
			this.data = JSON.parse(strJson);			
		};
		
		
		this.toJSONStringify = function(){
			this.data = JSON.stringify(this.data);
		};
		
		
		this.ajaxExec = function(){
			$.ajax(
					{
						url : this.url,
						data : this.data,//{sid: "", sname:""}
						type : this.type,
						async : this.async,
						dataType : this.dataType,
						contentType : this.contentType,
										
						success : this.sucFunc
						,
						error : this.errFunc
						
					} 
				); 
		};
		
	};
	
	
	
	 /*
		최초개발일 : 20220520
		최초개발자 : PL이름
		객체설명 : 
		수정내역
		-------------------------------------------------------------------
		수정일                  수정내용					 수정자
		20220525	   변수명 수정			     최유나
		-------------------------------------------------------------------
	*/
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
		
		this.formSubmit = function(){
			var strHiddenHTML = "";
			for(var i=0;i<this.hiddenNames.length;i++){
			
				strHiddenHTML += "<div>";
				strHiddenHTML += "<input type='hidden' name='" + this.hiddenNames[i] + "' value='" + this.hiddenVals[i] + "' />";
				strHiddenHTML += "</div>";
			}
			$("#" + this.formID).attr("method", this.formMethod);
			$("#" + this.formID).attr("action", this.formAction);
			$("#" + this.formID).append(strHiddenHTML);
			$("#" + this.formID).submit();
		}
	};
	
	
	
	