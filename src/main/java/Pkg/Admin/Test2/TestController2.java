package Pkg.Admin.Test2;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController2 {
	
	
	
	@RequestMapping("test2")
	public String testFunc(@RequestBody TestVO vo) {
		
		
		//System.out.println(name[2]);
		/*
		for(TestVO vos : vo) {
			System.out.println(vos.getName());
		}
		*/
		
		System.out.println(vo.getName());
		
		return "abc";
		
	}
}
