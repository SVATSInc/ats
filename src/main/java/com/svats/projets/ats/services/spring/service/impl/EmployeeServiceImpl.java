package com.svats.projets.ats.services.spring.service.impl;

import com.svats.projets.ats.services.entity.Employee;
import com.svats.projets.ats.services.spring.repository.EmployeeRepository;
import com.svats.projets.ats.services.spring.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(final EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void delete(final Long id) {

    }
}
