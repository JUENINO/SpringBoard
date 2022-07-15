package Pkg.Admin.Controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import Pkg.Admin.DTO.AuthMemberDTO;

public class Practice {

	@Autowired
	private SqlSessionTemplate sqlSession;
		
	public List<AuthMemberDTO> getAuthMemberList(String searchMName){
		
		
		Map<String,Object> map = new HashMap<>();
		
		
		map.put("searchMName",searchMName);
		
		sqlSession.selectList("SelectMemberList", map);
		
		List<AuthMemberDTO> arrlist = (List<AuthMemberDTO>)map.get("result");
		
		
		return arrlist;
	}
	
	
}
