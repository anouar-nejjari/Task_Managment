package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Repository.TaskRepository;
import com.demo.dto.TaskRequest;
import com.demo.model.Task;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskRequest req) {
        // Création de l'entité Task à partir de la requête (TaskRequest)
        Task task = new Task();
        task.setName((String) req.getName());  // Exemple d'attribut "name" pour la tâche
        task.setDescription(req.getDescription());  // Exemple d'attribut "description"
        task.setDueDate(req.getDueDate());  // Exemple d'attribut "dueDate"
        
        // Sauvegarde de la tâche dans la base de données
        return taskRepository.save(task);  // Retourne la tâche enregistrée
    }
}
