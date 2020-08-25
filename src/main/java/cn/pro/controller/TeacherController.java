package cn.pro.controller;

import cn.pro.Entity.Dto;
import cn.pro.Entity.Teacher;
import cn.pro.service.TeacherService;
import cn.pro.utils.DtoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(value = "教师测试接口Api")
@RestController
public class TeacherController {
    @Resource
    TeacherService teacherService;

    @ApiOperation(value = "新增教师",httpMethod = "POST")
    @RequestMapping(value = "/addTeacher")
    public Dto addTeacher(@RequestParam(value = "name")String name,@RequestParam(value = "phone")String phone,@RequestParam(value = "type")int type,@RequestParam(value = "fieldId")int fieldId, MultipartFile path, HttpServletRequest request){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setPhone(phone);
        teacher.setFieldId(fieldId);
        teacher.setType(type);
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
                teacher.setPath(filePath);
                teacherService.addTeacher(teacher);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            teacherService.addTeacher(teacher);

        }
        return DtoUtil.returnSuccess("应该成功");
    }
    @ApiOperation(value = "查询所有教师",httpMethod = "POST")
    @RequestMapping(value = "/findAllTeacher")
    public Dto findAllTeacher(@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "2")int size){
        PageHelper.startPage(start, size,"id desc");
        List<Teacher> teacherList = teacherService.findAllTeacher();
        PageInfo<Teacher> page = new PageInfo<>(teacherList);
        return DtoUtil.returnDataSuccess(page);
    }
    @ApiOperation(value = "根据Id查询教师",httpMethod = "POST")
    @RequestMapping(value = "/findTeacherById")
    public Dto findTeacherById(@RequestParam(value = "start")int id){
        Teacher page = teacherService.findTeacherById(id);
        if(page!=null) {
            return DtoUtil.returnDataSuccess(page);
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
}
