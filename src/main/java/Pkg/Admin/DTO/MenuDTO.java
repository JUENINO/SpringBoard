package Pkg.Admin.DTO;

public class MenuDTO {

	private String menuID;
	private String menuName;
	private String menuSeq;
	private String menuLvl;
	private String parentID;

	private String hidVal;
	
	
	public String getHidVal() {
		return hidVal;
	}
	public void setHidVal(String hidVal) {
		this.hidVal = hidVal;
	}
	public String getMenuID() {
		return menuID;
	}
	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuSeq() {
		return menuSeq;
	}
	public void setMenuSeq(String menuSeq) {
		this.menuSeq = menuSeq;
	}
	public String getMenuLvl() {
		return menuLvl;
	}
	public void setMenuLvl(String menuLvl) {
		this.menuLvl = menuLvl;
	}
	public String getParentID() {
		return parentID;
	}
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	
	
	
	
}
