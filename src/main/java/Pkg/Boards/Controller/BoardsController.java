	
package Pkg.Boards.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pkg.Boards.Service.BoardsService;
import Pkg.Boards.VO.BoardVO;
import Pkg.Boards.VO.MemberVO;

@Controller
public class BoardsController {
	
	@Autowired
	private BoardsService boardsService;
	
	@RequestMapping("boardsList")
	public String wfemkpfwefefwekpfemkefwkmpfekwpfmpkwefkpwefpkwemfpwemfkpeqmfkpqef(Model model) {
		//1.리스트 보여줄 데이터 가져와야한다.
		ArrayList<BoardVO> boardList = boardsService.getBoardList("");
		ArrayList<MemberVO> memberList = boardsService.getMemberList("");
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("memberList", memberList);
		
		
		return "/Boards/boards";
	}
	
	
	
	@RequestMapping("saveBoard")
	public String sndjqonsdjoqdnsqo(String[] idx, String[] title, String[] userID, String[] status, Model model) {
		System.out.println(123);
		System.out.println("컨트롤러!!" +  idx[0] + " ---  " +  idx[1] + " ---" + idx[2] +  " ---- " );
		System.out.println(idx.length);
		System.out.println(title.length);
		System.out.println(status);
		//수정 insert 처리하기.
		boardsService.saveBoard(idx, title, userID, status);
		
		
		// 로직이 끝나면 리스트 가지고 다시 가야한다.
		ArrayList<BoardVO> boardList = boardsService.getBoardList("");
		ArrayList<MemberVO> memberList = boardsService.getMemberList("");
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("memberList", memberList);
		
		return "/Boards/boards";
	}
	
	
	
	@RequestMapping("deleteBoard")
	public String deleteBoard(String[] delChk, Model model) {
		
		boardsService.deleteBoard(delChk);
		
		
		ArrayList<BoardVO> boardList = boardsService.getBoardList("");
		ArrayList<MemberVO> memberList = boardsService.getMemberList("");
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("memberList", memberList);
		
		return "/Boards/boards";
		
	}
	
}
