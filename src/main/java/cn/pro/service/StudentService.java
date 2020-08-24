package cn.pro.service;

import cn.pro.Entity.Student;
import cn.pro.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    List<Student> findStudentsByNameAndPhoneAndFieldId(String name,String phone,int fieldId);
    Student findStudentById(int id);
}
