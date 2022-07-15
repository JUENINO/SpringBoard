package Pkg.Admin.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import Pkg.Admin.DTO.AuthMemberDTO;

@Service
public interface AuthMemeberService {

	List<AuthMemberDTO> getAuthMemberList(String searchMName);
	
	void saveMemberList(Map<String, String[]> map);
	
}
