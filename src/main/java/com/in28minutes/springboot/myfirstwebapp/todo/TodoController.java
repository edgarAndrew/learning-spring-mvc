package com.in28minutes.springboot.myfirstwebapp.todo;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("email")
public class TodoController {
	
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model){
		String email = (String)model.get("email");
		//List<Todo> todos =  todoService.findByEmail(email);
		List<Todo> todos =  todoService.findByEmail(getLoggedInUser());
		model.addAttribute("todos",todos);
		
		logger.debug("This is a debug message.");
		
		return "listTodos";
	}
	
	@RequestMapping(value="addTodo",method=RequestMethod.GET)
	public String getAddTodoPage(){
		return "addTodo";
	}
	
	@RequestMapping(value="addTodo",method=RequestMethod.POST)
	public String addTodoPost(@SessionAttribute("email") String email,@RequestParam String desc,@RequestParam LocalDate date){
		
		todoService.addTodo(email, desc, date);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("removeTodo")
	public String removeTodo(@RequestParam int id){
		todoService.removeTodoById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="updateTodo",method=RequestMethod.GET)
	public String getUpdateTodoPage(@RequestParam int id,ModelMap model){
		Todo todo = todoService.getTodoById(id);
		model.addAttribute("todo",todo);
		return "updateTodo";
	}
	
	@RequestMapping(value="updateTodo",method=RequestMethod.POST)
	public String updateTodoPost(@RequestParam int id,@RequestParam String desc,@RequestParam LocalDate date,@RequestParam Boolean status){
		todoService.updateTodo(id, desc, date, status);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	
}
