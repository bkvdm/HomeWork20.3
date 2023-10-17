package tel.bvm.homework203.service;

import org.springframework.stereotype.Service;
import tel.bvm.homework203.exception.EmployeeAlreadyAddedException;
import tel.bvm.homework203.exception.EmployeeNotFoundException;
import tel.bvm.homework203.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
        employeeList.add(employee);
        }
        return employee;
    }

    @Override
    public Employee remove(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
//        return employeeList;
//        return new ArrayList<>(employeeList);
        return Collections.unmodifiableList(employeeList);
    }
}
