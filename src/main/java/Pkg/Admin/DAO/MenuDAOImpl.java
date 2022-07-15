package Pkg.Admin.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Pkg.Admin.DTO.MenuDTO;


@Repository
public class MenuDAOImpl implements MenuDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<MenuDTO> getMenuList() {
		
		
		Map<String, Object> map = new HashMap<>();
		
		sqlSession.selectList("Pkg.Admin.ProgramList.selectSUBMenuList", map);
		
		List<MenuDTO> menuList = (List<MenuDTO>)map.get("result");
		
		
		return menuList;
	}

}
