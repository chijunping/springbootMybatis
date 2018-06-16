package com.cjp.springboot.mapper;

import com.cjp.springboot.entity.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public int insertEmp(Employee employee);

}
