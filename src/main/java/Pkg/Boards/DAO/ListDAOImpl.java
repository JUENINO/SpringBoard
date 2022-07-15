package Pkg.Boards.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Pkg.Boards.VO.BoardVO;

@Repository
public class ListDAOImpl implements ListDAO{

	@Autowired
	public SqlSessionTemplate sqlSession;
	

	@Override
	public List<BoardVO> getBoardList(String idx) {
		
		List<BoardVO> boardList = sqlSession.selectList("Pkg.boards.list.selectBoard", idx);
		return boardList;
	}

	@Override
	public List<BoardVO> getProcBoardList(String idx) {
		
		 Map<String, Object> map = new HashMap<>();
		 //map.put에서 key에 해당하는 값은 list.xml에서 받아주는 mode=IN의 변수명과 일치해야한다.
		 map.put("idx", idx);
		 
		 sqlSession.selectList("Pkg.boards.list.procSelectBoard",map);
		 
		//map = HashMap<"result", ArrayList<BoardVO>>로 전달이 된다.
		 
		 
		 List<BoardVO> list = (List<BoardVO>)map.get("result");
		 
		 return list;
		 
		
	}

}
