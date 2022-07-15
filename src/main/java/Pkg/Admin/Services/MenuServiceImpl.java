package Pkg.Admin.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pkg.Admin.DAO.MenuDAO;
import Pkg.Admin.DTO.MenuDTO;


@Service
public class MenuServiceImpl implements MenuService {

	
	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public List<MenuDTO> getMenuList() {
		
		
		return menuDAO.getMenuList();
		
		
		
	}
	
	

	
	
	
}
