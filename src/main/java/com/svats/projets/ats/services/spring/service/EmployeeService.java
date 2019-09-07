package com.svats.projets.ats.services.spring.service;

import com.svats.projets.ats.services.entity.Employee;

public interface EmployeeService {

    Iterable<Employee> findAll();

    Employee findById(final Long id);

    void save(Employee employee);

    void delete(final Long id);
}
