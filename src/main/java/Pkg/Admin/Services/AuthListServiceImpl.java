package Pkg.Admin.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pkg.Admin.DAO.AuthListDAO;
import Pkg.Admin.DTO.AuthDTO;

@Service
public class AuthListServiceImpl implements AuthListService{

	@Autowired
	private AuthListDAO authListDAO;
	
	@Override
	public List<AuthDTO> getAuthList(String authName) {
	 
		return  authListDAO.getAuthList(authName);
	}

	@Override
	public Map<String, ArrayList<String>> saveAuthList(Map<String, String[]> paramsMap) {
		
		return authListDAO.saveAuthList(paramsMap);
		
	}
	
	@Override
	public Map<String, ArrayList<String>> delAuthList(String[] authID){
		return authListDAO.delAuthList(authID);
	}
	
	
}
