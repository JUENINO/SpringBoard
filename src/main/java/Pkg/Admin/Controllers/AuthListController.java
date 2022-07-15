package Pkg.Admin.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pkg.Admin.DTO.AuthDTO;
import Pkg.Admin.Services.AuthListService;

@Controller
public class AuthListController {

	@Autowired
	private AuthListService authService;
	
	
	// Auth_Manage.jsp에서 target을 목적으로 넘어왔다. --> jsp를 넘겨주는것이 이 컨트롤러의 책임. --> return값으로 jsp페이지를 적어준다.
	@RequestMapping("AuthList")
	public String getAuthList(String SauthName, Model model) {
		
		//System.out.println("AuthList 인터셉트체크");
		List<AuthDTO> authList = null;
				
		
		if(SauthName == null) {
			authList = authService.getAuthList(""); // 홈페이지 처음 접속할때는 값이 비어있다.
		} else {
			authList = authService.getAuthList(SauthName);
		}
		
		//authList는 List<AuthDTO>형.     
		//authName은 조회버튼 옆에 있는 텍스트박스에 넣어줄 값 ..
		model.addAttribute("authList", authList);
		model.addAttribute("authName", SauthName);
		
		
		return "/Admin/AuthList/AuthList";
	}
	
	
	
	// Save(저장)하는 로직을 담당하는 컨트롤러
	@RequestMapping("SaveAuthList")
	public String saveAuthlist(String[] authID, String[] authName, String[] gbn) {
		
		System.out.println(authID.length + "authID");
		System.out.println(authName.length + "authName");
		System.out.println(gbn.length + "gbn");
		Map<String, String[]> paramsMap = new HashMap<>();
		paramsMap.put("authID", authID);
		paramsMap.put("authName", authName);
		paramsMap.put("gbn", gbn);
		for(String mapstr : paramsMap.keySet()) {
			String[] strPract = paramsMap.get(mapstr);			
			 System.out.println("Key값 = '" + mapstr + "'");
			 for( String gogo : strPract) {
			 System.out.println(mapstr + "의 value = " + gogo);
			 }
			 System.out.println();
			 System.out.println();
			 System.out.println();
		}
		//실행한 결과 즉, 에러값을 받아낸다.
		Map<String, ArrayList<String>> errMap = authService.saveAuthList(paramsMap);
		System.out.println(errMap);
		
		
		//error 처리 
		return "redirect:AuthList?SauthName=";
	}
	
	
	
	
	//체크박스 안에 name을 다주고, value값도 vo.getID로 값을 입력해놓는다. 
	// --> if($(this).attr("checked")를 이용해서, 체크된 값만 가져온다.   
	// 이 deleteAuth의 경우는, 기존에 commons.js에서 만들어놓은, hidden box 생성기능을 이용해서, form submit으로 값을 가져온 케이스.
	@RequestMapping("DeleteAuth")
	public String deleteAuth(String[] authID) {
		
		
		//삭제기능만 완수하면 return으로 AuthList로 redirect해준다. 
		Map<String, ArrayList<String>> errmap = authService.delAuthList(authID);
		
		
		//기존에 board본문으로 갈떄, 항상 list를 생성하는 로직을 붙여준것을 대체하는 로직.
		return "redirect:AuthList?SauthName=";
	}
	
	
	
}
