package com.newSprinBootCRUD.service;

import com.newSprinBootCRUD.entity.Entity;
import com.newSprinBootCRUD.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    private Repository repository;

    // Add entry
    @Override
    public Entity saveDepartment(Entity entity) {
        return repository.save(entity);
    }

    // Get all entry
    @Override
    public List<Entity> fetchAllDepartment() {
        return repository.findAll();
    }

    // Get entry using id
    @Override
    public Entity fetchDepartmentById(Long departmentId) {
        return repository.findById(departmentId).get();
    }

    // Delete entry
    @Override
    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    // Update entry
    @Override
    public Entity updateById(Long departmentId, Entity entity) {
        Entity depDB = repository.findById(departmentId).get();

        if (Objects.nonNull(entity.getDepartmentName())
                && !"".equalsIgnoreCase(entity.getDepartmentName())) {
            depDB.setDepartmentName(entity.getDepartmentName());
        }

        if (Objects.nonNull(entity.getDepartmentAddress())
                && !"".equalsIgnoreCase(entity.getDepartmentAddress())) {
            depDB.setDepartmentAddress(entity.getDepartmentAddress());
        }

        if (Objects.nonNull(entity.getDepartmentCode())
                && !"".equalsIgnoreCase(entity.getDepartmentCode())) {
            depDB.setDepartmentCode(entity.getDepartmentCode());
        }

        return repository.save(depDB);
    }

    @Override
    public List<Entity> fetchDepartmentByName(String departmentName) {
        return repository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
