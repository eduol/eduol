package cn.pro.service;

import cn.pro.Entity.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LessonService {
    public List<Lesson> findByType(Integer type);
    int addLesson(Lesson lesson);
    int updLesson(Lesson lesson);
    Lesson findById(int id);
    int pauseLesson(Lesson lesson);
    int consumeLesson(int id);
}
