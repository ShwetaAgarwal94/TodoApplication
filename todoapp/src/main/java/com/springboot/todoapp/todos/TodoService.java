package com.springboot.todoapp.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    public static int totalCount = 0;

    static{
        todos.add(new Todo(++totalCount, "Shweta", "Get AWS certification 1",
                            LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++totalCount, "Shweta", "Learn Full Stack 1",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++totalCount, "Shweta", "Learn Devops 1",
                LocalDate.now().plusYears(3), false));
    }
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++totalCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
