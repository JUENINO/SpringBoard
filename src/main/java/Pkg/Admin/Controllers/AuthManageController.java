package Pkg.Admin.Controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AuthManageController {

	
	
	@RequestMapping("index")
	public String goIndex() {
		return "/index";
	}
	
	
	
	
	@RequestMapping("AuthManager")
	public String goAuthManager(Model model)  {
		 
		
		//System.out.println("---------------AuthManager�떆�옉---------------");
		
		
		
		//HttpSession session = request.getSession();
		
		model.addAttribute("data", "data�쟾�떖");
		//String adminID = (String)model.getAttribute("adminID");
		
		
		
		
		
		//System.out.println("---------------AuthManager�걹---------------");
		
		
		return "/Admin/Auth_Manage";
	}
	
	
	
	
}




