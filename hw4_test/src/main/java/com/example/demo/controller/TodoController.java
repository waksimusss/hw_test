package com.example.demo.controller;
import com.example.demo.dto.Task;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    public List<Task> getAllTasks() {
        return todoService.getAll();
    }

    public Task saveTask(String desc, String title){
        return todoService.add(desc, title);
    }

    public void deleteTaskById(Integer id) {
        todoService.delete(id);
    }
}
