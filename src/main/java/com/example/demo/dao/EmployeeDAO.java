package com.example.demo.dao;

import com.example.demo.models.Employee;
import com.example.demo.models.Reviews;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int EMPLOYEE_COUNT;
    private final List<Employee> employee;

    {
        employee = new ArrayList<>();

        employee.add(new Employee(++EMPLOYEE_COUNT, "Витя", "продавец", "1000", "123"));
        employee.add(new Employee(++EMPLOYEE_COUNT, "Антон", "эксперт", "2000", "2323"));
        employee.add(new Employee(++EMPLOYEE_COUNT, "Егор", "грузчик", "99999", "321"));
    }

    public List<Employee> index() {
        return employee;
    }

    public Employee show(int id) {
        return employee.stream().filter(employee -> employee.getId() == id).findAny().orElse(null);
    }

    public void save(Employee employe) {
        employe.setId(++EMPLOYEE_COUNT);
        employee.add(employe);
    }

    public void update(int id, Employee updatedEmployee) {
        Employee employeeToBeUpdated = show(id);

        if (employeeToBeUpdated != null) {
            employeeToBeUpdated.setName(updatedEmployee.getName());
            employeeToBeUpdated.setDolznost(updatedEmployee.getDolznost());
            employeeToBeUpdated.setZp(updatedEmployee.getZp());
            employeeToBeUpdated.setPremiya(updatedEmployee.getPremiya());
        }
    }

    public void delete(int id) {
        employee.removeIf(p -> p.getId() == id);
    }
}
