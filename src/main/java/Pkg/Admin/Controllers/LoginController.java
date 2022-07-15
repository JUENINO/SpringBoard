package Pkg.Admin.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	
	@RequestMapping("/start")
	public String indexasd() {
		return "/index";
	}
	
	
	@RequestMapping("/MissLogin")
	public String MissLogin_qffq() {
		return "/index";
	}
	
	
	
	@RequestMapping("AdminLogin")
	public String indexqwfqw(String adminID , String adminPass, HttpSession session) {
	
		
		
		// 濡쒓렇�씤 泥섎━.
		String dbId = "admin";
		String dbPass = "1234";
		
		
		
		String  page ="";
		if(adminID.equals(dbId) && adminPass.equals(dbPass)) {
			session.setAttribute("adminID", adminID);
		     page = "redirect:AuthManager";
		     System.out.println("濡쒓렇�씤 �젙蹂� �룞�씪�븯�떎�뒗嫄� �솗�씤!");

		} else {
			 page= "/index";
			 System.out.println("濡쒓렇�씤 �젙蹂닿� �떎由낅땲�떎.");
		}
		
		
		
		
		//System.out.println("AdminLogin留ㅽ븨硫붿냼�뱶 : " + adminID);
		//System.out.println("AdminLogin留ㅽ븨硫붿냼�뱶 : " + adminPass);
		
		return page;
	}
	
	
	//濡쒓렇�븘�썐 踰꾪듉 �겢由� �떆 ! 
	@RequestMapping("AdminLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
	
	
	
	/*
	@RequestMapping("Login")
	public String �븘吏곸슜�룄瑜쇰え瑜닿쿋�떎() {
		System.out.println("Login�쑝濡� 吏꾩엯�셿猷�  -- 濡쒓렇�씤�씠 �븞�릱�떎�뒗 �쓽誘�.");
		
		return "/login";
	}
	*/
	

	
	
}
