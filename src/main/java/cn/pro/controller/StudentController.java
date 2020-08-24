package cn.pro.controller;

import cn.pro.Entity.Dto;
import cn.pro.Entity.Student;
import cn.pro.service.StudentService;
import cn.pro.utils.DtoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "学生api")
@RestController
public class StudentController {
    @Resource
    StudentService studentService;

    @ApiOperation(value = "查询所有学生",httpMethod = "GET")
    @RequestMapping(value = "/findAllStudent")
    public Dto findAllStudents(){
        List<Student> studentList = studentService.findAllStudents();
        return DtoUtil.returnDataSuccess(studentList);
    }
    @ApiOperation(value = "根据Id查询学生",httpMethod = "POST")
    @RequestMapping(value = "/findStudentById")
    public Dto findStudentById(@RequestParam(value = "id")int id){
        Student student = studentService.findStudentById(id);
        if(student!=null){
            return DtoUtil.returnSuccess("成功",student);
        }else{
            return DtoUtil.returnFail("失败","114514");
        }
    }
    @ApiOperation(value = "查询所有学生根据奇奇怪怪的条件",httpMethod = "POST")
    @RequestMapping(value = "/findAllByStrange")
    public Dto findAllByStrange(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size,@RequestParam(value = "name",required = false)String name,@RequestParam(value = "phone",required = false)String phone,@RequestParam(value = "fieldId",defaultValue = "0")String fieldId){
        PageHelper.startPage(start, size,"id desc");
        List<Student> studentList = studentService.findStudentsByNameAndPhoneAndFieldId(name,phone,Integer.parseInt(fieldId));
        PageInfo<Student> page = new PageInfo<>(studentList);
        return DtoUtil.returnDataSuccess(page);
    }
}
