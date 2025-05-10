package com.demo.Repository;
import com.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.demo.model.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedTo(User user);
}
