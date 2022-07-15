package Pkg.Boards.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Pkg.Boards.Service.BoardService;
import Pkg.Boards.VO.BoardVO;




public class BoardController2 {

	
		//boardService를 가지고 되었다. --> DI(의존주입)
		//곧바로 boardService. 메소드 사용가능.
		//하지만 지금 빈 목록에 존재하는 인스턴스 중에 BoardService(인터페이스)형을 만족하는것은 BoardServiceImpl이니깐
	// BoardServiceImpl이 메모리에 올라온다.
		@Autowired
		public BoardService boardService;
	
		@RequestMapping("/helloSpring")
		public ModelAndView ninonino() {
						
			
			// TODO Auto-generated method stub
			System.out.println("날 불러줘!");
			
			String data1 = "Hello WebSpring";
			String data2 = "Hello @@@@@@@@@@@@";
			String jspPage = "Practice";
			
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("data1", data1);
			mv.addObject("data2", data2);
			mv.setViewName(jspPage);
			
			
			return mv;
		}
		
		
		@RequestMapping("/aaaa.dddd")
		public ModelAndView getHello() {
			ModelAndView mv = new ModelAndView();
			String jspPage = "list";
			mv.addObject("data1", "안녕하세요");
			mv.setViewName(jspPage);
			
			return mv;
		}
		
		
		@RequestMapping("/boardList")
		public String getBoardList( Model model) {
	
			ArrayList<BoardVO> boardList = boardService.getBoardList("");

			model.addAttribute("boardList", boardList);
			
			return "/Boards/list";
		}

		@RequestMapping("/writeForm")
		public String goWrite() {
			
			return "/Boards/write";
		}
		
		
		//매개변수에 BoardVO를 해놓으면 알아서 저장을 해준다???
		//insert 하고 list로 돌아가자!
		@RequestMapping("/insertBoard")
		public String sdnjfowjdnfjowqnfwofnjwd(BoardVO vo, Model model) {
			System.out.println(vo.getIdx() + " - "  +  vo.getUserID() + "  -  " +  vo.getTitle());
			
			//0525 15: 44 boardService를 DI로 받아놨으니 그냥 곧바로 CRUD이용가능. 
			//이 와중에 매개변수로 VO에 데이터가 다 저장되어있으니, vo를 집어넣으면됨
			boardService.insertBoard(vo);
			
			ArrayList<BoardVO> boardList = boardService.getBoardList("");
			model.addAttribute("boardList", boardList);
			
			return "/Boards/list";
		}
	
		@RequestMapping("/deleteBoard")
		public String dqwdqwnojdqwnojdqwnojdqwnoj(String idx, Model model) {
			boardService.deleteBoard(idx);
			
			
			//지우고, 리스트가져오고, 리스트로 가기. 끝
			ArrayList<BoardVO> boardList = boardService.getBoardList("");
			model.addAttribute("boardList", boardList);
			
			return "/Boards/list";
		}
		
		@RequestMapping("/updateForm")
		public String updateForm(String idx, Model model) {
			
			//list.jsp (뷰)에서 "수정" 버튼 클릭 시 idx를 get방식으로 updateForm?idx=""로 값을 보내준다.
			//가져온 idx를 DI되어있는, boardService인스턴스 내의 메소드에서 리스트를 찾아오는 메소드 호출.
			ArrayList<BoardVO> boardList = boardService.getBoardList(idx);
			
			//임시로 리스트 중 하나를 가져온다.
			BoardVO boardVO = boardList.get(0);
			
			//리스트를 Model객체에 저장해서  update로 넘겨준다. --> WEB-INF안의 views폴더안에 있는 jsp파일을 불러오기로 약속.
			model.addAttribute("boardVO", boardVO);
			
			return "/Boards/update";
		}
		
		@RequestMapping("/updateBoard")
		public String updateBoard(BoardVO vo , Model model) {
			
			//DI되어있는 boardService인스턴스(서비스객체) 내의 update메소드를 호출하고, 
			//update.jsp의 form태그로 받은 값들을 updateBoard 매개변수로 보내준다.
			//★★★ tip: 전달된 값들은 매개변수로 "변수명"을 동일시키고 String idx, String title로 받아지기도 하고,
			// VO클래스를 따로 만들어서, 위와같이 매개변수를 VO클래스로 쓰면, 스프링이 알아서 변수명이 일치하면 저장을 시켜준다.
			//jsp에서 액션태그의 setPropery * 한것과 동일한 효과.
			
			
			//update.jsp에서 받은 값들을 updateBoard에 넘겨준다.
			boardService.updateBoard(vo);
			
			//업데이트 후 다시 리스트를 받아서
			ArrayList<BoardVO> boardList = boardService.getBoardList("");
			model.addAttribute("boardList", boardList);
			
			//리스트로
			return "/Boards/list";
			
			
		}
		
		
}
