package Pkg.Admin.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pkg.Admin.DAO.AuthMenuListDAO;
import Pkg.Admin.DTO.MenuDTO;

@Service
public class AuthMenuListServiceImpl implements AuthMenuListService{

	@Autowired
	AuthMenuListDAO authMenuDAO;
	
	
	@Override
	public List<MenuDTO> getMenuList(String menuName) {
		
		
		return authMenuDAO.getMenuList(menuName);
		
	
	}
	
	@Override
	public void saveMenus(Map<String,String[]> params){
		
		authMenuDAO.saveMenus(params);
		
	}

	@Override
	public void delMenus(String[] params) {
		
		authMenuDAO.delMenus(params);
		
	}

	@Override
	public List<MenuDTO> getSubMenuList(String menuID) {
		
		return authMenuDAO.getSubMenuList(menuID);
	}

	@Override
	public void saveSubMenus(List<MenuDTO> params) {
		// TODO Auto-generated method stub
		authMenuDAO.saveSubMenus(params);
	}

	
	
	

}
