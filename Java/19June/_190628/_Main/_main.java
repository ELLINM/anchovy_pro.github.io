//main

package global.sesoc.test;

import global.sesoc.manager.TodoListManager;
import global.sesoc.ui.TodoListUI;

public class Main {
	public static void main(String[] args) {
		TodoListManager manager = new TodoListManager();
		new TodoListUI(manager);
	}
}
