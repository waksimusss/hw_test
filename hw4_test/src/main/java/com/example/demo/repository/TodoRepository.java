package com.example.demo.repository;
import com.example.demo.dto.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Integer> {
}
