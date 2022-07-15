package Pkg.Admin.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Pkg.Admin.DTO.AuthDTO;

public interface AuthListDAO {

	public List<AuthDTO> getAuthList(String authName);
	
	
	public Map<String, ArrayList<String>> saveAuthList( Map<String, String[]> paramsMap);
	
	public Map<String, ArrayList<String>> delAuthList(String[] authID);
	
}
