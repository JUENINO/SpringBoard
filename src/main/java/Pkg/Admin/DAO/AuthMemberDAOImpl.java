package Pkg.Admin.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Pkg.Admin.DTO.AuthMemberDTO;

@Repository
public class AuthMemberDAOImpl implements AuthMemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<AuthMemberDTO> getAuthMemberList(String searchMName) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("searchMName", searchMName);
		System.out.println("AuthMemberDAO의 searchMName 값 : " + searchMName);
		
		sqlSession.selectList("Pkg.Admin.AuthMember.selectAuthMemberList", map);
	
		List<AuthMemberDTO> authMemberList = (List<AuthMemberDTO>)map.get("result");
		
		//이게 잘못됐다면, searchMName이라는 변수명으로 전달이 되는지 의문을 가지자
		for(AuthMemberDTO dto : authMemberList) {
			System.out.println("result - DTO - getMID  : "  +  dto.getmID());
			System.out.println("result - DTO - getMName  : "  +  dto.getmName());
			System.out.println("result - DTO - getAuthID  : "  +  dto.getAuthID());
			System.out.println("result - DTO - getMthID  : "  +  dto.getMthID());
		}
		return authMemberList;
		
	}


	@Override
	public void saveMemberList(Map<String, String[]> map) {
		
		//Pkg.Admin.DTO.AuthMemberDTO.saveMemberList;
		
		String[] mID = map.get("mID");
		String[] mName = map.get("mName");
		String[] authID = map.get("authID");
		String[] mthID = map.get("mthID");
		String[] hiddenVal = map.get("hiddenVal");
		System.out.println("DAO에서 받았따 : mID값은 :  "  + mID[0]  );
		System.out.println("DAO에서 받았따 : hval값은 :  "  + mID[0]  );
		System.out.println("DAO에서 mID의 length는? " +  mID.length);
		System.out.println("DAO에서 hval의 length는? " + hiddenVal.length);
		System.out.println("DAO에서 mthID의 length는 ? " +  mthID.length);
		
		Map<String, Object> params = null;
		
		String errCode = "";
		String errMsg = "";
		
		
		for(int i = 0; i<mID.length; i++) {
			if(hiddenVal[i].equals("")) {
				params = new HashMap<>();
				params.put("mID", mID[i]);
				params.put("mName", mName[i]);
				params.put("authID", authID[i]);
				params.put("mthID", mthID[i]);
				params.put("hval", hiddenVal[i]);
				
				sqlSession.selectList("Pkg.Admin.AuthMember.saveMemberList", params);
				
				errCode = (String)params.get("errCode");
				errMsg = (String)params.get("errMsg");
			}
		}
		
		
		//Map<String, Object> map2 = new HashMap<>();
		
		//map.put("searchMName", m);
		
	}

}
