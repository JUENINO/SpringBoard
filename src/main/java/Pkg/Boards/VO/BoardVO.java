package Pkg.Boards.VO;

import org.springframework.stereotype.Service;


public class BoardVO {

		private String idx;
		private String title;
		private String userID;
		public String getIdx() {
			return idx;
		}
		public void setIdx(String idx) {
			this.idx = idx;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
	
		
}
