package Pkg.Boards.DAO;

import java.util.ArrayList;

import Pkg.Boards.VO.BoardVO;
import Pkg.Boards.VO.MemberVO;

public interface BoardDAO {

		ArrayList<BoardVO> getBoardsList(String idx);
		
		ArrayList<MemberVO> getMembersList(String userID);
		
	    void saveBoard(String[] idx, String[] title, String[] userID, String[] status);
		    
	    public void deleteBoard(String[] idx);
	    
	    
}
