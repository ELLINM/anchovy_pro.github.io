package global.sesoc.vo;

import java.util.ArrayList;

public class MyTodoList {
	private String today;
	private ArrayList<TodoContent> todos;
	public MyTodoList() {
		// TODO Auto-generated constructor stub
	}
	public MyTodoList(String today, ArrayList<TodoContent> todos) {
		super();
		this.today = today;
		this.todos = todos;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public ArrayList<TodoContent> getTodos() {
		return todos;
	}
	public void setTodos(ArrayList<TodoContent> todos) {
		this.todos = todos;
	}
	@Override
	public String toString() {
		return "MyTodoList [today=" + today + ", todos=" + todos + "]";
	}
	
}
