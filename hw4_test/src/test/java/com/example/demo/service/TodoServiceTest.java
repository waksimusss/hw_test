package com.example.demo.service;

import com.example.demo.dto.Task;
import com.example.demo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;
    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAll_Test() {
        Task task1 = new Task("Онжумания", "Тренировка каждый день");
        Task task2 = new Task("Пресс качат", "Упражнения");

        when(todoRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = todoService.getAll();
        assertEquals(2, tasks.size());
        assertEquals("Онжумания", tasks.get(0).getDesc());
        assertEquals("Тренировка каждый день", tasks.get(0).getTitle());
        assertEquals("Пресс качат", tasks.get(1).getDesc());
        assertEquals("Упражнения", tasks.get(1).getTitle());
    }

    @Test
    public void add_Test() {
        Task task = new Task("Руки 50 дней подряд", "Качалка");

        when(todoRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = todoService.add("Description", "Title");
        assertNotNull(createdTask);
        assertEquals("Руки 50 дней подряд", createdTask.getDesc());
        assertEquals("Качалка", createdTask.getTitle());
    }

    @Test
    public void deleteById_Test() {
        Integer ID = 1;

        doNothing().when(todoRepository).deleteById(ID);

        todoService.delete(ID);

        verify(todoRepository, times(1)).deleteById(ID);
    }
}
