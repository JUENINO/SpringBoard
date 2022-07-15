package Pkg.Admin.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor{
	
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        
		 
		 //DispatcherServlet이 호출되고 Controller가 호출되기 직전에 호출된다.
	        System.out.println("preHandle");
	        
	        // preHandle에서 활용할 사례/ 기능
	        // 1. login관리 (체크)
	        // 2. page logger 관리
	        
	        
	        
	        
	        
	        return true;
	    }
	 
	 
	 @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        
		 //위에 첫번쨰 preHandle이 실행되고, controller가 디스패쳐에게 정보를 주고, 디스패처가 또 다시 view페이지에 정보를 넘겨줄때, 관여하는 메소드
		 
		 System.out.println(modelAndView.getViewName());
		 System.out.println(modelAndView.getModel().get("data")); //getModel메소드의 return 타입은 Map<String,Object>형
	        System.out.println("postHandle");
	        
	    }
	 
	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	    	
	    	
	    // view페이지(jsp)에서 랜더링되어서 클라이언트로 넘어갈떄(응답을 하기 직전) 관여하는 메소드	
	    	
	        
	        System.out.println("afterCompletion");
	        
	        
	    }
	 
	 
	 
	 
	
}
