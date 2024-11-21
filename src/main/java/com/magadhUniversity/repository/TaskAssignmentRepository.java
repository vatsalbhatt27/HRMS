package com.magadhUniversity.repository;


import com.magadhUniversity.model.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment,Long> {
}
