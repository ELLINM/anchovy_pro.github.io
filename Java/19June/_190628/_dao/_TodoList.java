//TodoList

package global.sesoc.manager;

import java.util.List;

import global.sesoc.vo.CheckValue;
import global.sesoc.vo.MyTodoList;

public interface TotoList {
	// 등록
	public int registTodo();
	
	// 삭제
	public int deleteTodo();
	
	// 수정
	public int updateTodo();
	
	// 특정 일자 조회
	public List<MyTodoList> selectOne(String today);
	
	// 등록된 모든 todoList 조회
	public List<MyTodoList> selectAll(String today);
	
	// 특정 항목의 todoList 조회
	public List<MyTodoList> selectAll(CheckValue checkValue);
}
