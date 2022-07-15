package Pkg.Admin.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Pkg.Admin.DTO.AuthDTO;

@Repository
public class AuthListDAOImpl implements AuthListDAO{
  
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<AuthDTO> getAuthList(String authName) {
		//Map에 전달할 값은 value에 넣고, 매칭할 변수명은 key에 입력한다.
		//지금 여기서는 Mybatis에 매핑되어있는 곳에 authName이라는 변수명에 authName(권한이름)을 전달한다.
		Map<String, Object> map = new HashMap<>();
		map.put("authName", authName);
		
		//마이바티스의 selectAuthList라는 메소드에 map의 데이터를 보내준다.
		sqlSession.selectList("Pkg.Admin.AuthList.selectAuthList", map);
		
		
		//마이바티스에서 DB연동 후 결과값은, map.get('key')을 통해 받아낸다. 
		//위에서 보낸 값도 마이바티스 쪽에서는 map.get("authName")이런식으로 받아낼것이다.
		
		// 여러 개(List)의 AuthDTO에 있는 변수명만큼 다양한 데이터들이 테이블로 다시 리턴되니깐, 당연히 List<AuthDTO>로 받아줘야한다.
		List<AuthDTO> authList = (List<AuthDTO>)map.get("result");
		
		
		return authList;
	}
	
	
	@Override
	public Map<String, ArrayList<String>> saveAuthList(Map<String, String[]> paramsMap) {
		
		String[] authID = paramsMap.get("authID");
		String[] authName = paramsMap.get("authName");
		String[] gbn = paramsMap.get("gbn");
		
		Map<String, ArrayList<String>> errMap = new HashMap<>();
		
		ArrayList<String> arrErrCode = new ArrayList<>();
		ArrayList<String> arrErrMsg = new ArrayList<>();
		
		for(int i=0; i<authName.length; i++) {
			Map<String,Object> map = new HashMap<>();
			//for문 안에서 authID,authName, gbn을 하나씩 하나씩 보낸다. --> Map<String,Object>로 값을 받아낼 수 있다.
			map.put("authID", authID[i]);
			map.put("authName", authName[i]);
			map.put("gbn", gbn[i]);
			
			if(gbn[i] != null) {
				sqlSession.selectList("Pkg.Admin.AuthList.saveAuthList", map);
			}
			arrErrCode.add((String)map.get("errCode"));
			arrErrMsg.add((String)map.get("errMsg"));
		}
		
		errMap.put("errCode", arrErrCode);
		errMap.put("errMsg", arrErrMsg);
		
		return errMap;
		
	}

	@Override
	public Map<String, ArrayList<String>> delAuthList(String[] authID){
		
	
		Map<String, ArrayList<String>> errMap = new HashMap<>();
		
		ArrayList<String> arrErrCode = new ArrayList<>();
		ArrayList<String> arrErrMsg = new ArrayList<>();
		
		for(int i=0; i<authID.length; i++) {
			Map<String,Object> map = new HashMap<>();
			map.put("authID", authID[i]);
			
			if(authID[i] != null) {
				sqlSession.selectList("Pkg.Admin.AuthList.delAuthList", map);
			}
			arrErrCode.add((String)map.get("errCode"));
			arrErrMsg.add((String)map.get("errMsg"));
		}
		
		errMap.put("errCode", arrErrCode);
		errMap.put("errMsg", arrErrMsg);
		
		return errMap;
	}

}
