package Pkg.Admin.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Pkg.Admin.DTO.MenuDTO;
import Pkg.Admin.Services.AuthMenuListService;

@Controller
public class AuthMenuListController {

	
	@Autowired
	AuthMenuListService authMenuListService;
	
	
	@RequestMapping("MenusList")
	public String showMenuList(String menuName, Model model) {
		
		
		
		List<MenuDTO> menuList  = authMenuListService.getMenuList(menuName);
		
		
		model.addAttribute("menuList", menuList);
		
		
		return "/Admin/MenuList/menuList";
	}
	
	
	@RequestMapping("SaveMenu")
	public String qegqe(String[] menuID, String[] menuName, String[] menuSeq, 
											String[] menuLvl, String[] parentID, String[] hidVal) {
		
		
		Map<String, String[]> params = new HashMap<>();
		
		params.put("menuID", menuID);
		params.put("menuName", menuName);
		params.put("menuSeq", menuSeq);
		params.put("menuLvl", menuLvl);
		params.put("parentID", parentID);
		params.put("hidVal", hidVal);
		
		authMenuListService.saveMenus(params);
		
		
		for(String str : menuID) {
			System.out.println(str);
		}
		
	
		//�꽭�씠釉뚰븯怨� 由ъ뒪�듃��怨� �룎�븘媛� �닔 �엳�룄濡�, 由ы꽩�뿉 �씠 媛믪쓣 �꽔�뼱�몺.
		return "redirect:MenusList";
		//return null;
	}
	
	
	@RequestMapping("delMenus")
	public String wdvwe(String[] delMenuID) {
		
		for(String str : delMenuID) {
		System.out.println("delMenus�븿�닔 �떎�뻾!! "  + str  +  " �엯�땲�떎.");
		}
		authMenuListService.delMenus(delMenuID);
				
		return "redirect:MenusList";
		
	}
	
	@ResponseBody
	@RequestMapping("SubMenuList")
	public String badb(String menuID) {
		System.out.println("SUBMENULIST -------------  "   +   menuID);
		
		List<MenuDTO> subMenuList = authMenuListService.getSubMenuList(menuID);
		
		JSONArray jarray  = new JSONArray();
		for(MenuDTO dto : subMenuList) {
		JSONObject jobj = new JSONObject();
		
		jobj.put("MENUID", dto.getMenuID());
		jobj.put("MENUNAME", dto.getMenuName());
		jobj.put("MENULVL", dto.getMenuLvl());
		jobj.put("MENUSEQ", dto.getMenuSeq());
		jobj.put("PARENTID", dto.getParentID());
		
		jarray.add(jobj);
		
		System.out.println(jarray.get(0));
		//System.out.println(jarray.get(1));
		}
		return jarray.toString();
	}
	
	//@ResponseBody
	@RequestMapping("saveSubMenu")
	public String submenu_wd1(@RequestBody Map<String,List<MenuDTO>> params) {
		
		
		List<MenuDTO> saveList = params.get("saveList");
		
		System.out.println(params + "params111111111");
		System.out.println(params.get("saveList"));
		for(MenuDTO dto : saveList) {
			System.out.println(dto.getMenuName());
		}
		for(MenuDTO dto: saveList) {
			System.out.println(saveList);
			System.out.println(dto.getMenuName());
		}
		authMenuListService.saveSubMenus(saveList);
		

		
		
		
		return "redirect:MenusList";
	}
	
	
	
	
}
