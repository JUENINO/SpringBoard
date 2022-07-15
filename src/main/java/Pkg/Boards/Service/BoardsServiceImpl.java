package Pkg.Boards.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pkg.Boards.DAO.BoardDAO;
import Pkg.Boards.VO.BoardVO;
import Pkg.Boards.VO.MemberVO;

@Service
public class BoardsServiceImpl implements BoardsService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public ArrayList<BoardVO> getBoardList(String idx) {
		
		return boardDAO.getBoardsList(idx);
	}

	@Override
	public ArrayList<MemberVO> getMemberList(String userID) {
		
		return boardDAO.getMembersList(userID);
	}
	
	
	@Override
	public void saveBoard(String[] idx, String[] title, String[] userID, String[] status) {
		
		
		
		boardDAO.saveBoard(idx, title, userID, status);
		
		
		
	}

	
	@Override
	public void deleteBoard(String[] idx) {
		boardDAO.deleteBoard(idx);
	}
	
		
	
}
