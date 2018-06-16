package com.cjp.springboot.controller;

import com.cjp.springboot.entity.Employee;
import com.cjp.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("getEmpById")
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @RequestMapping("insertEmp")
    public int insertEmp(@RequestBody Employee employee) {
        return employeeMapper.insertEmp(employee);
    }
}
