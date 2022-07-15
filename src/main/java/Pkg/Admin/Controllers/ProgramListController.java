package Pkg.Admin.Controllers;

import java.util.ArrayList;
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

import Pkg.Admin.DAO.ProgramDAO;
import Pkg.Admin.DTO.MenuDTO;
import Pkg.Admin.DTO.ProgramDTO;
import Pkg.Admin.Services.MenuService;
import Pkg.Admin.Services.ProgramService;

@Controller
public class ProgramListController {

	
	

	@Autowired
	private ProgramService programSerivce;
	@Autowired
	private MenuService menuService;
	
	
	@RequestMapping("ProgramList")
	public String asd(String pName, Model model) {
		
		List<ProgramDTO> programList = programSerivce.getProgramList(pName);
		model.addAttribute("programList", programList);
		List<MenuDTO> menuList = menuService.getMenuList();
		model.addAttribute("menuList", menuList);
		
		//�뿬湲곗꽌 servlet.xml�뿉 �꽕�젙�븳, resolver��濡� �럹�씠吏�媛� �씠�룞�맂�떎. --> �꽌踰꾨떒�뿉�꽌�뒗 WEB-INF�뿉 �젒洹쇱씠 媛��뒫�븯�떎�뒗 �쓽誘�.
		return "/Admin/PROGRAMLIST/programList";
	}
	
	
	@ResponseBody  //ResponseBody瑜� �꽑�뼵�븿�쑝濡쒖뜥, return�뿉 蹂대궪 �뜲�씠�꽣瑜� �떎�쓣 �닔 �엳�떎.
	@RequestMapping("SaveProgramList")
	public String aa(@RequestBody Map<String, ArrayList<ProgramDTO>> MenuDatas) {
		
		ArrayList<ProgramDTO> params =  MenuDatas.get("datas");
		
		programSerivce.savePrograms(params);
		
		System.out.println(params.get(0).getMenuID());
		System.out.println(params.get(0).getpName()  +   "  --------- pName");
		System.out.println(params.get(0).getpID() + "   ----pid");
		System.out.println("");
		
		JSONObject jObj = new JSONObject();
		jObj.put("result", "success");
		
		
		
		
		return jObj.toString();
	}
	
	
	@ResponseBody  //ajax媛믪쑝濡� 由ы꽩�븯寃좊떎.
	@RequestMapping("MenuList")
	public String asd(){
		
		List<MenuDTO> mList = menuService.getMenuList();
		
		
		
		
		String menuID = "";
		String menuName = "";
		JSONArray jArray = new JSONArray();
		for(MenuDTO dto : mList) {
		       menuID = dto.getMenuID();
		       menuName = dto.getMenuName();
		       
		       JSONObject JmenuObj = new JSONObject();
		
		       JmenuObj.put("menuID", menuID);
		       JmenuObj.put("menuName", menuName);
			        
			   jArray.add(JmenuObj);
		}
		
		return jArray.toString();
	}
	
	@ResponseBody
	@RequestMapping("MenuDel")
	public String asd뻾(@RequestBody Map<String, ArrayList<ProgramDTO>> map) {
		
		
		ArrayList<ProgramDTO> arrDelList = (ArrayList<ProgramDTO>)map.get("delpID");
		
		for(ProgramDTO dto : arrDelList) {
			System.out.println(dto.getpID() + "pID!!");
		}
		
		
		
		

		programSerivce.delPrograms(arrDelList);
		
		
		JSONObject resultJSONObj = new JSONObject();
		
		JSONArray pArray = new JSONArray();
		List<ProgramDTO> programList = programSerivce.getProgramList("");
		List<MenuDTO> menuList = menuService.getMenuList();
		for(ProgramDTO pDto : programList) {
			JSONObject programJSONObj = new JSONObject();
			programJSONObj.put("pID", pDto.getpID());
			programJSONObj.put("pName", pDto.getpName());
			programJSONObj.put("pFileName", pDto.getpFileName());
			programJSONObj.put("fileUrl", pDto.getFileUrl());
			programJSONObj.put("menuID", pDto.getMenuID());
			
			
			
			
			JSONArray mArray = new JSONArray();
			for(MenuDTO mDto : menuList ) {
				JSONObject menuJSONObj = new JSONObject();
				menuJSONObj.put("menuID", mDto.getMenuID());
				menuJSONObj.put("menuName", mDto.getMenuName());
				mArray.add(menuJSONObj);
			}
			programJSONObj.put("menus", mArray);
			
			pArray.add(programJSONObj);		
		}
		
		//resultJSONObj.put("result", pArray);
		
		
		
		
		
		//jObj.put("result", "success");
		 return pArray.toString();
		//return resultJSONObj.toString();
	}
	
	
	
}
