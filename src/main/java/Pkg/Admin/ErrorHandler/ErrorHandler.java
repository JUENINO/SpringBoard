package Pkg.Admin.ErrorHandler;

import java.util.ArrayList;
import java.util.Map;

public class ErrorHandler {

	//db에러처리 하는 로직. 그 전에는 그냥 404,500 많이 나오는 에러를 처리하는 컨트롤러를 'ErrorHandleController'에 로직을 짜놨따.
	public void goErrorPage(Map<String, ArrayList<String>> map ) {
		
		for( String strKey : map.keySet() ){
			ArrayList<String> err = map.get(strKey);
			System.out.println( strKey +":"+ err );
			
			if(strKey.equals("errCode")) {
				for(String strRst : err) {
					if(!(strRst.equals("suc"))) {
						
					}
				}
			}
			
		}
	
		
	}
	
}
