package Pkg.Admin.ErrorHandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandleController {

	
	@RequestMapping("errorHandle")
	public String goErrorPage(String errorCode, String errorMsg, Model model) {
		
		if(errorCode.equals("404")) {
			errorMsg = "요청하신 페이지는 없는 페이지 입니다.!!";
		}
		if(errorCode.equals("500")) {
			errorMsg = "500 Server Error !!";
		}
		
		model.addAttribute("errorCode", errorCode);
		model.addAttribute("errorMsg", errorMsg);
		
		return "/Admin/AdminError/err";
	}
	
}
