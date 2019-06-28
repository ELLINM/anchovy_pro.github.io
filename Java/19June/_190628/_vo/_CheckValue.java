//CheckValue

package global.sesoc.vo;

public enum CheckValue {
	COMPLETE("완성"), PROCEED("진행중"), CANCEL("취소"),
	IMPORTANT("중요"), NORMAL("보통"), LOW("중요하지않음") ;
	
	private String checked;
	
	private CheckValue() {}
	private CheckValue(String checked) {
		this.checked = checked;
	}
	public String getChecked() {
		return checked;
	}
}
