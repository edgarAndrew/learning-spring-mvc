package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class TodoService {

    private final TodoRepository repository;
    
    @Autowired
    public TodoService(TodoRepository repository) {
    	this.repository = repository;
    }
    
//	private static List<Todo> todos = new ArrayList<>();
//	static {
//		todos.add(new Todo(1,"edgar@xmail.com","Learn AWS",LocalDate.now().plusDays(10L),false));
//		todos.add(new Todo(2,"andrew@xmail.com","Learn AWS",LocalDate.now().plusDays(20L),false));
//		todos.add(new Todo(3,"edgar@xmail.com","Learn Docker",LocalDate.now().plusDays(10L),false));
//		todos.add(new Todo(4,"andrew@xmail.com","Learn Docker",LocalDate.now().plusDays(20L),true));
//	}
	
	public List<Todo> findByEmail(String email){
		List<Todo> todos = repository.findTodoByUsername(email); 
		
		return todos.stream()
	            .filter(todo -> todo.getUsername().equals(email))
	            .collect(Collectors.toList());
		
	}
	
//	private int generateTodoId() {
//        // Find the highest current ID and add 1 to it
//        int maxId = todos.stream().mapToInt(Todo::getId).max().orElse(0);
//        return maxId + 1;
//    }
	
	public void addTodo(String email, String description, LocalDate targetDate) {
        // Create a new Todo object
//        Todo newTodo = new Todo(generateTodoId(), email, description, targetDate, false);
//
//        // Add the new Todo to the list
//        todos.add(newTodo);

		Todo newTodo = new Todo(email, description, targetDate, false);
        repository.save(newTodo);
    }
	
	public void removeTodoById(int id) {
//        todos.removeIf(todo -> todo.getId() == id);
        repository.deleteById(id);
    }
	
	public Todo getTodoById(int id) {
		return repository.getReferenceById(id);
//        return todos.stream()
//            .filter(todo -> todo.getId() == id)
//            .findFirst()
//            .orElse(null);
    }
	
	@Transactional // transactional allows us to use the setters in the entity to update the value in db
	public void updateTodo(int id, String desc, LocalDate date, boolean status) {
		Todo todo = this.getTodoById(id);
		if(todo != null) {
			todo.setDescription(desc);
			todo.setTargetDate(date);
			todo.setDone(status);
		}	
    }
}
