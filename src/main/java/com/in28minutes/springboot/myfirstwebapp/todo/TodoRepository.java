package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
	 @Query("SELECT t FROM Todo t WHERE t.username = ?1")
	  List<Todo> findTodoByUsername(String email);
}
