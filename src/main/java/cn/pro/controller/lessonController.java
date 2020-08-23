package cn.pro.controller;

import cn.pro.Entity.Dto;
import cn.pro.Entity.Lesson;
import cn.pro.service.LessonService;
import cn.pro.utils.DtoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

@Api(value = "课程管理api")
@RestController
public class lessonController {
    @Resource
    LessonService lessonService;

    @ApiOperation(value = "根据类型查询课程",httpMethod = "POST")
    @RequestMapping(value = "/findLessonByType")
    public Dto findLessonByType(@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "2")int size,@RequestParam(value = "type")Integer type){
        PageHelper.startPage(start, size,"id desc");
        List<Lesson> ll = lessonService.findByType(type);
        PageInfo<Lesson> page = new PageInfo<>(ll);
        return DtoUtil.returnSuccess("成功",page);
    }
    @ApiOperation(value = "根据Id查询课程",httpMethod = "POST")
    @RequestMapping(value = "/findLessonById")
    public Dto findLessonById(@RequestParam(value = "id")int id){
        Lesson lesson = lessonService.findById(id);

        return DtoUtil.returnSuccess("成功",lesson);
    }

    @ApiOperation(value = "新增课程",httpMethod = "POST")
    @RequestMapping(value = "/addLesson")
    public Dto addLesson(@RequestParam(value = "code")String code, @RequestParam(value = "name")String name, @RequestParam(value = "grades")String grades, @RequestParam(value = "price")double price, @RequestParam(value = "personNum")int personNum, @RequestParam(value = "type")int type, @RequestParam(value = "fieldId")int fieldId, MultipartFile path, HttpServletRequest request){
        Lesson lesson = new Lesson();
        lesson.setCode(code);
        lesson.setName(name);
        lesson.setGrades(grades);
        lesson.setPrice(price);
        lesson.setPersonNum(personNum);
        lesson.setFieldId(fieldId);
        lesson.setType(type);
        if(path!=null){
            String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
            File folder = new File(realPath);
            if(!folder.isDirectory()){
                folder.mkdirs();
            }
            String oldName = path.getOriginalFilename();
            String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
            try {
                path.transferTo(new File(folder,newName));
                String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/uploadFile/" +newName;
                lesson.setPath(filePath);
                lessonService.addLesson(lesson);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
                lessonService.addLesson(lesson);

        }
        return DtoUtil.returnSuccess("应该成功了");
    }
    @ApiOperation(value = "编辑课程",httpMethod = "POST")
    @RequestMapping(value = "/updLesson")
    public Dto updLesson(@RequestParam(value = "id")int id,@RequestParam(value = "code")String code, @RequestParam(value = "name")String name, @RequestParam(value = "grades")String grades, @RequestParam(value = "price")double price, @RequestParam(value = "personNum")int personNum, @RequestParam(value = "type")int type, @RequestParam(value = "fieldId")int fieldId){
        Lesson lesson = new Lesson();
        lesson.setId(id);
        lesson.setCode(code);
        lesson.setName(name);
        lesson.setGrades(grades);
        lesson.setPrice(price);
        lesson.setPersonNum(personNum);
        lesson.setFieldId(fieldId);
        lesson.setType(type);
        int num = lessonService.updLesson(lesson);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","10086");
        }
    }
    @ApiOperation(value = "停课开课",httpMethod = "GET")
    @RequestMapping(value = "/pauseLesson")
    public Dto pauseLesson(@RequestParam(value = "id")int id){
        Lesson lesson = lessonService.findById(id);
        int status = lesson.getStatus();
        if(status==0){
            lesson.setStatus(1);
        }else{
            lesson.setStatus(0);
        }
        lessonService.pauseLesson(lesson);
        return DtoUtil.returnSuccess("成功");
    }
    @ApiOperation(value = "课时消耗",httpMethod = "GET")
    @RequestMapping(value = "/consumeLesson")
    public Dto consumeLesson(@RequestParam(value = "id")int id){
        int num = lessonService.consumeLesson(id);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","10086");
        }
    }
    @ApiOperation(value = "批量消耗",httpMethod = "POST")
    @RequestMapping(value = "/consumeBatch")
    public Dto consumeBatch(@RequestParam(value = "id")String[] ids){
        for (String id : ids){
            int di = Integer.parseInt(id);
            lessonService.consumeLesson(di);
        }
        return DtoUtil.returnSuccess("成功");
    }

}
