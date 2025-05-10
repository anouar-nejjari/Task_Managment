package com.demo.Controller;

import com.demo.dto.TaskRequest;
import com.demo.model.Statut;
import com.demo.service.TaskService;
import com.demo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequest req) {
        taskService.createTask(req);
        return ResponseEntity.ok("Task created successfully");
    }

    @GetMapping("/mine")
    public ResponseEntity<?> getMyTasks() {
        return ResponseEntity.ok("Get current user tasks");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok("Get all tasks");
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestBody Statut newStatus) {
        // implémenter la mise à jour de statut
    }
}
