package com.newSprinBootCRUD.repository;

import com.newSprinBootCRUD.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Entity, Long> {
    List<Entity> findByDepartmentNameIgnoreCase(String departmentName);

}
