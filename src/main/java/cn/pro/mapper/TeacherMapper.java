package cn.pro.mapper;

import cn.pro.Entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    int addTeacher(Teacher teacher);
    Teacher findTeacherById(@Param(value = "id")int id);
    List<Teacher> findAllTeacher();
}
