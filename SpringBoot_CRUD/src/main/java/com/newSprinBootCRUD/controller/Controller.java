package com.newSprinBootCRUD.controller;

import com.newSprinBootCRUD.entity.Entity;
import com.newSprinBootCRUD.service.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;

    // Add entry mapping
    @PostMapping("/departments")
    public Entity saveDepartment(@Valid @RequestBody Entity entity) {
        return service.saveDepartment(entity);

        /*
        @Autowired  // @Autowired is not applicable to local variable, can only be used with instance variable
        private Service service;
        or
        Service service = new ServiceImpl();
        */

    }

    // Get all entry mapping
    @GetMapping("/departments")
    public List<Entity> fetchAllDepartment() {
        return service.fetchAllDepartment();
    }

    // Get entry by id mapping
    @GetMapping("/departments/id/{id}")
    public Entity fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return service.fetchDepartmentById(departmentId);
    }

    // Get entry by name mapping
    @GetMapping("/departments/name/{name}")
    public List<Entity> fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return service.fetchDepartmentByName(departmentName);
    }

    // Delete Entry mapping
    @DeleteMapping("/departments/id/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        service.deleteDepartmentById(departmentId);
        return "departmentId: " + departmentId + ", data deleted successfully...";
    }

    // Update entry mapping
    @PutMapping("/departments/id/{id}")
    public String updateById(@PathVariable("id") Long departmentId, @RequestBody Entity entity) {
        service.updateById(departmentId, entity);
        return "departmentId: " + departmentId + ", data updated successfully...";
    }

}