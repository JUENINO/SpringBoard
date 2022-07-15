package Pkg.Admin.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Pkg.Admin.DTO.ProgramDTO;

@Repository
public class ProgramDAOImpl implements ProgramDAO{

	
	@Autowired
	public SqlSessionTemplate sqlSession;
	
	@Override
	public List<ProgramDTO> getProgramList(String pName) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("pName", pName );
		
		sqlSession.selectList("Pkg.Admin.ProgramList.selectProgramList", map);
		
	    List<ProgramDTO> programList  = (List<ProgramDTO>)map.get("result");
	
	    
	    //data에 관련된 추가 업무가 있다면 여기다 코딩
	    
		return programList;
	}
	//public ArrayList<>
	
	
	
	@Override
	public void savePrograms(ArrayList<ProgramDTO> params) {
		
		String pID = "";
		String menuID = "";
		String pName = "";
		String pFileName ="";
		String fileUrl = "";
		String result ="";
	try {	
		for(ProgramDTO dto : params) {
			pID = dto.getFileUrl();
			menuID = dto.getMenuID();
			pName = dto.getpName();
			pFileName = dto.getpFileName();
			fileUrl = dto.getFileUrl();
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("pID", pID);
			map.put("menuID", menuID);
			map.put("pName", pName);
			map.put("pFileName", pFileName);
			map.put("fileUrl", fileUrl);
			System.out.println("111111");
			System.out.println(map);
			System.out.println(map.get("fileUrl"));
			
			
			sqlSession.selectList("Pkg.Admin.ProgramList.savePrograms", map);
			
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		result = "success";
	}
	}
	
	
	
	
	@Override
	public void delPrograms(ArrayList<ProgramDTO> params) {
		
		ArrayList<ProgramDTO> delList = params;
		String pID = "";
		
		for(ProgramDTO dto : delList) {
			System.out.println("DAO!!!!!");
			pID = dto.getpID();
			System.out.println(pID);
			Map<String, Object> map = new HashMap<>();
			map.put("pID", pID );
			
			sqlSession.selectList("Pkg.Admin.ProgramList.delPrograms", map);			
		}
		
		
		
		
	}
	
	
	

	
}
