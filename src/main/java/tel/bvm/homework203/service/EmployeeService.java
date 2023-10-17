package tel.bvm.homework203.service;

import tel.bvm.homework203.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstname, String lastName);
    Employee remove(String firstname, String lastName);
    Employee find(String firstname, String lastName);
    Collection<Employee> findAll();
}
