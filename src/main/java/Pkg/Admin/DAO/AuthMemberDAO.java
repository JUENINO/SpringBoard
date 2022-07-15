package Pkg.Admin.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Pkg.Admin.DTO.AuthMemberDTO;

@Repository
public interface AuthMemberDAO {

	
	public List<AuthMemberDTO> getAuthMemberList(String searchMName);
	
	public void saveMemberList(Map<String, String[]> map);
	
}
