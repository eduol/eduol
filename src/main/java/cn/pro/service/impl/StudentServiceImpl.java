package cn.pro.service.impl;

import cn.pro.Entity.Student;
import cn.pro.Entity.User;
import cn.pro.mapper.StudentMapper;
import cn.pro.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;
    @Override
    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }

    @Override
    public List<Student> findStudentsByNameAndPhoneAndFieldId(String name, String phone, int fieldId) {
        return studentMapper.findStudentsByNameAndPhoneAndFieldId(name,phone,fieldId);
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.findStudentById(id);
    }
}
