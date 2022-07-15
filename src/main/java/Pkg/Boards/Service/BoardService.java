package Pkg.Boards.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import Pkg.Boards.VO.BoardVO;


public interface BoardService {

	
		public ArrayList<BoardVO> getBoardList(String idx);
		
		
		public void deleteBoard(String idx);
		
		//idx와 내용(VO)를 받아야한다.
		public void updateBoard(BoardVO vo);
		
		
		public void insertBoard(BoardVO vo);
	
}
