package cn.pro.service;

import cn.pro.Entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    int addTeacher(Teacher teacher);
    Teacher findTeacherById(int id);
    List<Teacher> findAllTeacher();
}
