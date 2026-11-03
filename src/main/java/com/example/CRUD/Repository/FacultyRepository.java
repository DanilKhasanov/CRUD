package com.example.CRUD.Repository;

import com.example.CRUD.Entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
