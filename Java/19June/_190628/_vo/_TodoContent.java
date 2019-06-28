//TodoContent

package global.sesoc.vo;

public class TodoContent {
	private String contents;
	private CheckValue checked;

	public TodoContent() {
		// TODO Auto-generated constructor stub
	}
	public TodoContent(String contents, CheckValue checked) {
		super();
		this.contents = contents;
		this.checked = checked;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public CheckValue getChecked() {
		return checked;
	}
	public void setChecked(CheckValue checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return "TodoList [contents=" + contents + ", checked=" + checked + "]";
	}
}
