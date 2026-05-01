package com.example.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor // Injeção de dependência
public class TodoController {
    private final TodoRepository  repository;

    @GetMapping
    public List<Todo> listar(){
        //buscar todas as tarefas na tabela todos
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Todo buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Todo criar(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
    
    
}
