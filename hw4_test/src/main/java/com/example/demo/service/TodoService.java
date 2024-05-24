package com.example.demo.service;

import com.example.demo.dto.Task;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Task> getAll() {
        return todoRepository.findAll();
    }

    public Task add(String desc, String title) {
        Task newTask = new Task(desc, title);
        return todoRepository.save(newTask);
    }

    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }


}
