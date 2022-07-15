package Pkg.Boards.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pkg.Boards.DAO.ListDAO;
import Pkg.Boards.VO.BoardVO;

@Controller
public class ListController {
	
	
	@Autowired
	private ListDAO listDAO;
	
	@RequestMapping("list")
	public String boardList(String idx, Model model) {
		
		List<BoardVO> list = listDAO.getProcBoardList("");
		
		model.addAttribute("list", list);
		
		return "/Boards/boardlist";
		
	}
	
}
