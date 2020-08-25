package cn.pro.service.impl;

import cn.pro.Entity.Teacher;
import cn.pro.mapper.TeacherMapper;
import cn.pro.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return teacherMapper.findTeacherById(id);
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }
}
