package Pkg.Admin.Controllers;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import Pkg.Admin.DTO.AuthDTO;
import Pkg.Admin.DTO.AuthMemberDTO;
import Pkg.Admin.Services.AuthListService;
import Pkg.Admin.Services.AuthMemeberService;

@Controller
public class AuthMemberController {

	
	
	
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private AuthMemeberService authMemberService;
	
	@Autowired
	private AuthListService authService;
	
	
	
	//以묒슂�븳嫄� �뿬湲곗꽌 memberList�� return�뿉 �엳�뒗 memberList�뒗 �떎瑜대떎.
	
	@RequestMapping("MemberList")
	public String f31f31컂oMemberList() {
	
		return "/Admin/AuthList/MemberList";
		
		
	}
	
	
	@RequestMapping("JsonMemberList")
	@ResponseBody
	public String Memberf131f3( HttpServletRequest request, HttpServletResponse response, String searchMName) {

			System.out.println("searchMName :  "   +  searchMName);

				System.out.println("肄섑뀗�듃 ���엯 : "  +  request.getContentType());
			
			
	//�뿈�뿈�뿈�뿈�뿈�뿈�뿈�뿈�뿈�뿈�뿈�뿈�뿈 searchMName留� 諛쏄퀬, memberList留� 蹂댁뿬二쇰㈃ �걹�씤寃껋씠 �븘�땲�씪, AuthList�룄 媛��졇���꽌 selectBox�뿉 �꽆寃⑥쨾�빞�븳�떎. 
			// �씠�븣 �옒 �깮媛곹빐蹂대㈃, AuthList�뒗 議곌굔�뾾�씠, �씪�떒 紐⑤뱺 沅뚰븳�쓣 由ъ뒪�듃�뿉 �떞�븘�꽌 蹂댁뿬以섏빞�븳�떎. (利�, �쟾�떖諛쏆쓣 媛믪씠 �븘�슂�뾾�떎 )
		List<AuthMemberDTO> memberList = authMemberService.getAuthMemberList(searchMName);		
		List<AuthDTO> authList = authService.getAuthList("");

		
		
		
		
		JSONArray MemberListJsonArray = new JSONArray();
		//�쁾MEMBER�뱾�쓣 蹂댁뿬以� JSON�뜲�씠�꽣瑜� �떞�쓣 JSON諛곗뿴媛앹껜 �깮�꽦!
		
		
		for(AuthMemberDTO dto : memberList) {
			JSONObject jobj = new JSONObject();
			jobj.put("MID", dto.getmID());
			jobj.put("MNAME", dto.getmName());
			jobj.put("AUTHID", dto.getAuthID());
			jobj.put("AUTHNAME", dto.getAuthName());
			jobj.put("MTHID", dto.getMthID());
			MemberListJsonArray.add(jobj);
		 	
		}
		
		
		
		
		
		//select box�뿉 �벝 JSON �뜲�씠�꽣�뱾..
		// �뿬湲곗꽌�뒗 member媛� 二쇰찓�씤�씠怨�, 硫ㅻ쾭蹂꾨줈 沅뚰븳�쓣 蹂댁뿬二쇨린 �쐞�빐 auth 由ъ뒪�듃瑜� ���옣�븳�떎.
		// �꽑�깮�븯�꽭�슂... AUTH由ъ뒪�듃...(愿�由ъ옄沅뚰븳, 硫붾돱1沅뚰븳 �벑�벑...)
		
		JSONArray AuthListJsonArray = new JSONArray();
		//�쁾select box瑜� �떞�떦�븷 JSON�뜲�씠�꽣瑜� �떞�쓣 JSON諛곗뿴媛앹껜 �깮�꽦!
		
		
		
		
		JSONObject empty = new JSONObject();
		empty.put("AUTHNAME", "�꽑�깮�빐二쇱꽭�슂");
		empty.put("AUTHID", "");
		AuthListJsonArray.add(empty);
		
		
		for(AuthDTO dto : authList) {			
			JSONObject jobj = new JSONObject();
			jobj.put("AUTHID", dto.getAuthID());
			jobj.put("AUTHNAME", dto.getAuthName());			
			AuthListJsonArray.add(jobj);
		}
		
		
		
////////////////////////////////////////////�븘�슂�븳 �뜲�씠�꽣�뒗 紐⑤몢 �떞�븯�떎. �떎留�, 臾몄젣�씤寃껋� JSON踰좎뿴媛앹껜媛� 珥� 2媛쒖씤�뜲, �씠 2媛� �씠�긽�쓽 JSON諛곗뿴 �뜲�씠�꽣瑜� �뼱�뼸寃� 蹂대궪寃껋씤媛� �씠�떎.
		
		
		
		
		JSONObject resultObj = new JSONObject();
		//�떎�젣濡� �쟾�떖�븷 JSON 媛앹껜.
		//�뼳�뼳�뼳 �쐞�뿉�꽌�뒗 JSON媛앹껜媛� �븳媛� �씠�긽�씠湲곕뻹臾몄뿉, 媛곴컖 memberlist�� authlist瑜� JSON諛곗뿴�뿉 �떞�븯�떎.
		
		
		

			System.out.println("MemberList �궡�슜 : "  +  MemberListJsonArray);
			System.out.println("AuthList �궡�슜 : "  +  AuthListJsonArray);
			
			
			resultObj.put("MemberList", MemberListJsonArray);
			resultObj.put("AuthList", AuthListJsonArray);
			
			System.out.println("理쒖쥌 �궡�슜 : "  +  resultObj);
	// List2媛쒖쓽 JSON諛곗뿴�쓣 JSON媛앹껜�뿉 ���옣�븯怨�, �씠 JSON媛앹껜 �븯�굹瑜� �쟾�넚�븳�떎.
	//JSON諛곗뿴濡� �궇�씪�삩 諛곗뿴媛앹껜 媛곴컖 �씠由꾩쓣 遺��뿬�빐�꽌 ���옣�빐蹂댁옄.
			
			
			System.out.println(resultObj);
		
		return resultObj.toString();
		//String g1 = new Gson().toJson(memberList);		
	}
	
	
	@RequestMapping("JsonAuthList")
	@ResponseBody
	public String qwdwq(String authName){
		
		List<AuthDTO> authList = authService.getAuthList(authName);
		
		JSONArray jarray = new JSONArray();
		JSONObject empty = new JSONObject();
		empty.put("AUTHNAME", "�꽑�깮�빐二쇱꽭�슂");
		empty.put("AUTHID", "");
		jarray.add(empty);
		//empty �씪�뒗 json �삤釉뚯젥�듃瑜� JSON諛곗뿴�뿉 �꽔�뿀�떎.
		
		for(AuthDTO dto : authList) {
			JSONObject jobj = new JSONObject();
			jobj.put("AUTHID", dto.getAuthID());
			jobj.put("AUTHNAME", dto.getAuthName());
			jarray.add(jobj);
		//jobj�씪�뒗 json �삤釉뚯젥�듃瑜� JSON諛곗뿴�뿉 �꽔�뿀�떎.
		}
//�뼳�뼳�뼳 JSON 諛곗뿴�뿉, empty 媛앹껜, jobj 媛앹껜瑜� �븯�굹�뵫 �꽔�뿀�떎.		
		return jarray.toString();
		
	}
	
	
	
	@RequestMapping("MemberSave") 
	public String asdqwdn(String[] mID, String[] mName, String[] authID, String[] hiddenVal, String[] mthID) {
		
		System.out.println("���옣踰꾪듉 �닃�졇�쓬 : " +  mID[0]);
		System.out.println("���옣踰꾪듉 �닃�졇�쓬2 : " +  mName[0]);
		System.out.println("���옣踰꾪듉 �닃�졇�쓬3: " +  authID[0]);
		System.out.println("���옣踰꾪듉 �닃�졇�쓬4: " +  hiddenVal[0]);
		System.out.println("���옣踰꾪듉 �닃�졇�쓬5: " +  mthID[0]);
		Map<String, String[]> map = new HashMap<>();
		
		map.put("mID", mID);
		map.put("mName", mName);
		map.put("authID", authID);
		map.put("hiddenVal", hiddenVal);
		map.put("mthID", mthID);
		
		authMemberService.saveMemberList(map);
		
		return "/Admin/AuthList/MemberList";
		//MemberList �럹�씠吏�濡� 媛�硫�, onload�뿉 �쓽�빐�꽌, �옄�룞�쑝濡� 由ъ뒪�듃瑜� 媛��졇�삩�떎.
	}

	
	//�럹�씠吏�濡쒕뵫 �썑, �씪�떒 memberList �럹�씠吏�濡� 媛��뒗 濡쒖쭅�씠 諛쒕룞�릺�뒗嫄� �럺�듃. 
	// 嫄곌린�꽌 onload瑜� �넻�빐, �옄�룞�쑝濡� 由ъ뒪�듃瑜� 媛��졇�삤�뒗 肄붾뵫�쓣 援ъ궗�븳寃�.
	@RequestMapping("memberList")
	public String getAjaxJson(String searchMName) {
		
		List<AuthMemberDTO> memberList = authMemberService.getAuthMemberList(searchMName);
		List<AuthDTO> authList = authService.getAuthList("");
		
		
		// memberLIst�뿉�꽌 ajax濡� �뜲�씠�꽣瑜� 蹂대궡以��떎. json�삎�떇�쑝濡� 蹂대궡吏�留�, 諛쏅뒗履쎌뿉�꽌�뒗 text/html , form�깭洹� �삎�떇�씠�떎. 
		
		
		
		JSONArray memberListJSON = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		for(AuthMemberDTO dto : memberList) {
			jsonObj.put("MID", dto.getmID());   // --> �씠寃� JSONObject瑜� �솢�슜�븯硫�, �옄�룞�쑝濡� {"MID" : "M00001"}  �씠 ���옣 �맆寃껋씠�떎..
			jsonObj.put("MNAME", dto.getmName());
			jsonObj.put("AUTHID", dto.getAuthID());
			jsonObj.put("AUTHNAME", dto.getAuthName());
			memberListJSON.add(jsonObj);
		}
		
		JSONArray authListJSON = new JSONArray();
		JSONObject authJSON = new JSONObject();
		
		authJSON.put("AUTHID", "" );
		authJSON.put("AUTHNAME", "�꽑�깮�빐二쇱꽭�슂");
		for(AuthDTO dto : authList) {
			authJSON.put("AUTHID", dto.getAuthID() );
			authJSON.put("AUTHNAME", dto.getAuthName() );
			
			authListJSON.add(authJSON);
		}
		
		
		JSONObject resultObj =  new JSONObject();
		
		resultObj.put("memberList", memberList);
		/* JSON Object�뿉 �쓽�빐�꽌, 
		  memberList : [
		  					{"MID" : "M0001" , "MNAME" : "�솉湲몃룞" , "AUTHID" , "AUTH001", },
		  					{"MID" : "M0002" ,  ""~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    }		  
		  			   ]
		  	濡� �옄�룞�쑝濡� JSON �삎�떇�뿉 留욊쾶 媛믪씠 ���옣�맂�떎.
		*/
		resultObj.put("authList", authList);
		
		
		
		
		return null;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
		
		
	
	
}
