package Pkg.Boards.Service;

import java.util.ArrayList;

import Pkg.Boards.VO.BoardVO;
import Pkg.Boards.VO.MemberVO;

public interface BoardsService {

		public ArrayList<BoardVO> getBoardList(String idx);
		
		public ArrayList<MemberVO> getMemberList(String userID);
		
		public void saveBoard(String[] idx, String[] title, String[] userID, String[] status);
	
		
		public void deleteBoard(String[] idx);
		
}
