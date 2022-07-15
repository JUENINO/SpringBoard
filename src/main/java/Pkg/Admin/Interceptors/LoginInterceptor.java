package Pkg.Admin.Interceptors;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




public class LoginInterceptor implements HandlerInterceptor {

	
	//�씠�젣 �뼱�뵜媛��뱺 �씠 �씤�꽣�뀎�듃 �럹�씠吏�瑜� �씠�슜�븳�떎 -->>>>>>>>>>>>>>>>>>>> preHandle�뿉�꽌 濡쒓렇�씤 �뿬遺�瑜� 怨꾩냽怨꾩냽 �솗�씤�빐以섏빞�븳�떎.
	
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        
		 
		 //System.out.println("----------preHandle �떆�옉---------");
		 
		
		 	HttpSession session = request.getSession(); 
		
		 	//�꽭�뀡�씠 �엳�떎硫� (濡쒓렇�씤�씠 �릺�뼱�엳�떎硫�) 洹몃깷 return true瑜� ��硫대맂�떎. --> AdminLogin�쑝濡� �씠�룞�맖.
		 	//null�씠硫� 洹몃깷 true濡� �넻怨쇱떆耳쒖꽌, 濡쒓렇�씤(�븘�씠�뵒,鍮꾨�踰덊샇)瑜� 鍮꾧탳�븯嫄곕굹, 濡쒓렇�씤李쎌쑝濡� 蹂대궡怨�.
		 	// null�씠 �븘�땲硫� 濡쒓렇�씤�씠 �릱�떎�뒗 �쑜�씠�땲, �쉶�썝�씠 �씠�슜�븷�닔 �엳寃� �빐以��떎.
		 	
		 			 	
		 	//System.out.println("泥ル쾲夷� �씤�꽣�뀎�듃�뿉�꽌 session�솗�씤 :  " + session.getAttribute("adminID"));
		 	
		 	String adminID = (String)session.getAttribute("adminID");
		 	
		 	if(adminID == null) {
		 		response.sendRedirect("MissLogin");
		 		return false;
		 	}
		 	
		 	//null �씠硫�.. 濡쒓렇�씤�씠 �릺�뼱�엳吏� �븡�떎硫�.. �듅�젙 �럹�씠吏�濡� 媛뺤젣�씠�룞
		
		 		
		 		
		 		return true;
		 		
		 	} 
		 	
		 	
		 	
		 	
		 	
	
	 
	 
	 @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        
		 //�쐞�뿉 泥ル쾲夷� preHandle�씠 �떎�뻾�릺怨�, controller媛� �뵒�뒪�뙣爾먯뿉寃� �젙蹂대�� 二쇨퀬, �뵒�뒪�뙣泥섍� �삉 �떎�떆 view�럹�씠吏��뿉 �젙蹂대�� �꽆寃⑥쨪�븣, 愿��뿬�븯�뒗 硫붿냼�뱶
		
		 //System.out.println("postHandler �떆�옉");
		 
		 
		 HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		 
		// ArrayList<String> arr = new ArrayList<>();
		 
		 
		 // 諛섎났�궗�슜�븯�뒗 媛믩뱾�쓣 postHandle �씤�꽣�뀎�듃�뿉 �꽔�뼱以뚯쑝濡쒖뜥, 洹�李��� 諛섎났�옉�뾽�쓣 以꾩뿬以��떎.
		 //arr.add("12345");
		 
		 
		 //modelAndView.addObject("commonValue", arr);
		 
		 //System.out.println(modelAndView.getModel());
		 //System.out.println(modelAndView.getModel().get("commonValue"));
		 
		 
		// System.out.println("postHandler �걹");
	        
	    }
	 
	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	    	
	    	
	    	// view�럹�씠吏�(jsp)�뿉�꽌 �옖�뜑留곷릺�뼱�꽌 �겢�씪�씠�뼵�듃濡� �꽆�뼱媛덈뻹(�쓳�떟�쓣 �븯湲� 吏곸쟾) 愿��뿬�븯�뒗 硫붿냼�뱶 -- 嫄곗쓽�븞��	
	    	
	    	
	    	
	    	//�샊�떆�씪�룄 �씠 硫붿냼�뱶瑜� �벐吏��븡�뒗�떎硫� �씠�윴�떇�쑝濡� super硫붿냼�뱶瑜� �떎�뻾�떆耳쒖��떎. --> �씠�쑀 李얠븘蹂닿린.
	    	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	        
	    	
	    	//System.out.println("afterCompletion �걹");
	        
	        
	    }
	 
	
}
