package Pkg.Admin.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pkg.Admin.DAO.AuthMemberDAO;
import Pkg.Admin.DTO.AuthMemberDTO;

@Service
public class AuthMemeberServiceImpl implements AuthMemeberService{

	
	@Autowired
	AuthMemberDAO authMemberDAO;
	
	
	
	@Override
	public List<AuthMemberDTO> getAuthMemberList(String searchMName) {
		
		
		return authMemberDAO.getAuthMemberList(searchMName);
		
		
	}
	
	
	@Override
	public void saveMemberList(Map<String, String[]> map) {
	
		
		authMemberDAO.saveMemberList(map);
		
	}

}
