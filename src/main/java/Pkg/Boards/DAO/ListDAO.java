package Pkg.Boards.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Pkg.Boards.VO.BoardVO;

public interface ListDAO {

	public List<BoardVO> getBoardList(String idx);
	
	public List<BoardVO> getProcBoardList(String idx); 
	
}
