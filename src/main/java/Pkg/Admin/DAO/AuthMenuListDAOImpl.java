package Pkg.Admin.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Pkg.Admin.DTO.MenuDTO;



@Repository
public class AuthMenuListDAOImpl implements AuthMenuListDAO{

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	@Override
	public List<MenuDTO> getMenuList(String menuName){
		
		Map<String, Object> map = new HashMap<>();
		
		
		map.put("menuName", menuName);
		
		sqlSession.selectList("Pkg.Admin.MenuList.selectMenuList", map);
		
		List<MenuDTO> menuList = (List<MenuDTO>)map.get("result");
				
		return menuList;
	}
	
	
	
	@Override
	public void saveMenus(Map<String,String[]> params) {
		
	
		
		
		String[] menuID = params.get("menuID");
		String[] menuName = params.get("menuName");
		String[] menuSeq = params.get("menuSeq");
		String[] menuLvl = params.get("menuLvl");
		String[] parentID = params.get("parentID");
		String[] hidVal = params.get("hidVal");
		
	
		
		
	
		// 많은 요소 중 하나만 골라서 그 길이만큼 반복하게 한다.
		for(int i = 0; i<parentID.length; i++) {
			 
			//hidVal이 null이 아닐떄
			if(hidVal[i].equals("")) {
				
			
			
			Map<String, Object> map = new HashMap<>();
			map.put("menuID", menuID[i]);
			map.put("menuName", menuName[i]);
			map.put("menuSeq", menuSeq[i]);
			//map.put("menuLvl", menuLvl[i]);
			//map.put("parentID", parentID[i]);
			//map.put("hidVal", hidVal[i]);
			
			sqlSession.selectList("Pkg.Admin.MenuList.saveMenus", map);
			
			}
			
		}
		
		
		
	}



	@Override
	public void delMenus(String[] params) {
		
		
		
		
		for(String menuID : params) {
			
			Map<String, Object> map = new HashMap<>();
			map.put("menuID", menuID);
			sqlSession.selectList("Pkg.Admin.MenuList.delMenus" , map);		
		}
		
		
		
	}
	
	
	@Override
	public List<MenuDTO> getSubMenuList(String menuID){
		
		//System.out.println("SubMenuListDAO시작----------------------------------");
		Map<String, Object> map = new HashMap<>();
		map.put("menuID", menuID);
		sqlSession.selectList("Pkg.Admin.MenuList.selectSubMenuList" , map);	
		List<MenuDTO> subMenuList = (List<MenuDTO>)map.get("result");
		//System.out.println("SubMenuListDAO끝----------------------------------");
		return subMenuList;
		
		}



	@Override
	public void saveSubMenus(List<MenuDTO> params) {
		

		// 많은 요소 중 하나만 골라서 그 길이만큼 반복하게 한다.
		for(MenuDTO dto : params) {
			Map<String, Object> map = new HashMap<>();
			map.put("menuID", dto.getMenuID());
			map.put("menuName", dto.getMenuName());
			map.put("menuSeq", dto.getMenuSeq());
			map.put("menuLvl", dto.getMenuLvl());
			map.put("parentID", dto.getParentID());

			
			sqlSession.selectList("Pkg.Admin.MenuList.saveSubMenus", map);
			
			}
			
		}
		
		
	}	

