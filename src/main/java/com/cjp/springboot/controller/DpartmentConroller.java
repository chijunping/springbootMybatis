package com.cjp.springboot.controller;

import com.cjp.springboot.entity.Department;
import com.cjp.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DpartmentConroller {

    @Autowired
    private DepartmentMapper mapper;

    @GetMapping("getDeptById")
    public Department getDeptById(Integer id) {
        return mapper.getDeptById(id);
    }

    @GetMapping("deleteDeptById")
    public Integer deleteDeptById(Integer id) {
        return mapper.deleteDeptById(id);
    }

    @PostMapping("insertDept")
    public Department insertDept(@RequestBody Department department) {
        mapper.insertDept(department);
        return department;
    }

    @RequestMapping("updateDeptById")
    public Integer updateDeptById(@RequestBody Department department) {
        return mapper.updateDeptById(department);
    }
}
