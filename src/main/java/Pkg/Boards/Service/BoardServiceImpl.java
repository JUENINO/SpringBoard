package Pkg.Boards.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import Pkg.Boards.VO.BoardVO;



@Service
public class BoardServiceImpl implements BoardService{

	
	
	@Override
	public ArrayList<BoardVO> getBoardList(String idx){
		ArrayList<BoardVO> boardList = new ArrayList<>();
		BoardVO vo = new BoardVO();
		vo.setIdx("1");
		vo.setTitle("토비의 스프링 3.1");
		vo.setUserID("USER01");
		boardList.add(vo);
		
		BoardVO vo2 = new BoardVO();
		vo2.setIdx("2");
		vo2.setTitle("토비의 스프링 3.2");
		vo2.setUserID("USER02");
		boardList.add(vo2);
		
		return boardList;
	}
	
	@Override
	public void deleteBoard(String idx) {
		
	}
	
	@Override
	public void updateBoard(BoardVO vo) {
		
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		
	}
	
}
