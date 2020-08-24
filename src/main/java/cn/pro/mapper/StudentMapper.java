package cn.pro.mapper;

import cn.pro.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAllStudents();
    List<Student> findStudentsByNameAndPhoneAndFieldId(@Param(value = "name")String name,@Param(value = "phone")String phone,@Param(value = "fieldId")int fieldId);
    Student findStudentById(@Param(value = "id")int id);
}
