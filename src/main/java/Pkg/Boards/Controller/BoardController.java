package Pkg.Boards.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class BoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("날 불러줘!");
		
		String data1 = "Hello WebSpring";
		String data2 = "Hello !!!!!!!!!!!!!!!!!!!!!";
		String jspPage = "index.jsp";
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("data1", data1);
		mv.addObject("data2", data2);
		mv.setViewName(jspPage);
		
		
		return mv;
	}
	*/

}
