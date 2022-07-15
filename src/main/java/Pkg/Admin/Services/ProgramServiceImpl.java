package Pkg.Admin.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pkg.Admin.DAO.ProgramDAO;
import Pkg.Admin.DTO.ProgramDTO;

@Service
public class ProgramServiceImpl implements ProgramService{

	@Autowired
	private ProgramDAO programDAO;
	
	
	
	
	@Override
	public List<ProgramDTO> getProgramList(String pName) {
	
		//가져온 데이터를 가지고 업무를 추가합니다.
		
		
		return programDAO.getProgramList(pName);
	}
	
	
	@Override
	public void savePrograms(ArrayList<ProgramDTO> params) {
		
		
		
		 programDAO.savePrograms(params);
		
	}
	
	@Override
	public void delPrograms(ArrayList<ProgramDTO> params) {
		
		programDAO.delPrograms(params);
	}

}
