package Pkg.Admin.DAO;

import java.util.ArrayList;
import java.util.List;

import Pkg.Admin.DTO.ProgramDTO;

public interface ProgramDAO {

	
	
	public List<ProgramDTO> getProgramList(String pName);
	
	
	public void savePrograms(ArrayList<ProgramDTO> params);
	
	
	public void delPrograms(ArrayList<ProgramDTO> params);
	
}
