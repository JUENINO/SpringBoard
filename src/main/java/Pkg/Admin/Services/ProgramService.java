package Pkg.Admin.Services;

import java.util.ArrayList;
import java.util.List;

import Pkg.Admin.DTO.ProgramDTO;

public interface ProgramService {

	
	
	public List<ProgramDTO> getProgramList(String pName);
	
	
	public void savePrograms(ArrayList<ProgramDTO> params);
	
	
	public void delPrograms(ArrayList<ProgramDTO> params);
}
