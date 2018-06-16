package com.cjp.springboot.mapper;

import com.cjp.springboot.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id =#{id}")
    public int deleteDeptById(Integer id); //返回删除行数

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Delete("insert into  department(id,departmentName) values(#{id},#{departmentName})")
    public int insertDept(Department department); //返回插入的行数

    @Delete("update department set departmentName =#{departmentName} where id=#{id}")
    public int updateDeptById(Department department); //返回插入的行数

}
