package cn.pro.mapper;

import cn.pro.Entity.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LessonMapper {
    List<Lesson> findByType(@Param(value = "type")Integer type);
    int addLesson(Lesson lesson);
    int updLesson(Lesson lesson);
    Lesson findById(@Param(value = "id")int id);
    int pauseLesson(Lesson lesson);
    int consumeLesson(@Param(value = "id")int id);
}
