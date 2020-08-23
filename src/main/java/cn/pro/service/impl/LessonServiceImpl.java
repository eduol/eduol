package cn.pro.service.impl;

import cn.pro.Entity.Lesson;
import cn.pro.mapper.LessonMapper;
import cn.pro.service.LessonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Resource
    LessonMapper lessonMapper;
    @Override
    public List<Lesson> findByType(Integer type) {
        return lessonMapper.findByType(type);
    }

    @Override
    public int addLesson(Lesson lesson) {
        return lessonMapper.addLesson(lesson);
    }

    @Override
    public int updLesson(Lesson lesson) {
        return lessonMapper.updLesson(lesson);
    }


    @Override
    public Lesson findById(int id) {
        return lessonMapper.findById(id);
    }

    @Override
    public int pauseLesson(Lesson lesson) {
        return lessonMapper.pauseLesson(lesson);
    }

    @Override
    public int consumeLesson(int id) {
        return lessonMapper.consumeLesson(id);
    }
}
