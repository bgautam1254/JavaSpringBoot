package com.newSprinBootCRUD.service;
import com.newSprinBootCRUD.entity.Entity;

import java.util.List;

public interface Service {
    Entity saveDepartment(Entity entity);

    List<Entity> fetchAllDepartment();

    Entity fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Entity updateById(Long departmentId, Entity entity);

//    Department fetchDepartmentByName(String departmentName);
    List<Entity> fetchDepartmentByName(String departmentName);
}
