package cn.pro.controller;

import cn.pro.Entity.Active;
import cn.pro.Entity.Dto;
import cn.pro.service.ActiveService;
import cn.pro.utils.DtoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xalan.internal.xsltc.trax.DOM2TO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value = "活动管理测试接口")
@RestController
public class ActiveController {
    @Resource
    ActiveService activeService;

    @ApiOperation(value = "查询所有",httpMethod = "POST")
    @RequestMapping(value = "/findAllActive")
    public Dto findAllActive(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size, @RequestParam(value = "type")Integer type){
        PageHelper.startPage(start, size,"id desc");
        List<Active> al = activeService.findAll(type);
        PageInfo<Active> page = new PageInfo<>(al);
        return DtoUtil.returnSuccess("成功",page);
    }
    @ApiOperation(value = "新增活动",httpMethod = "POST")
    @RequestMapping(value = "/addActive")
    public Dto AddActive(@RequestParam(value = "name")String name,@RequestParam(value = "starterTime")String starterTime,@RequestParam(value = "endTime")String endTime,@RequestParam(value = "type")int type){
        Active active = new Active();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = simpleDateFormat.parse(starterTime);
            Date date2 = simpleDateFormat.parse(endTime);
            active.setName(name);
            active.setStartTime(date1);
            active.setEndTime(date2);
            active.setType(type);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(activeService.addActive(active)>0) {
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
    @ApiOperation(value = "修改活动",httpMethod = "POST")
    @RequestMapping(value = "/updActive")
    public Dto UpdActive(@RequestParam(value = "id")int id,@RequestParam(value = "name")String name,@RequestParam(value = "starterTime")String starterTime,@RequestParam(value = "endTime")String endTime,@RequestParam(value = "type")int type) {
        Active active = new Active();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = simpleDateFormat.parse(starterTime);
            Date date2 = simpleDateFormat.parse(endTime);
            active.setName(name);
            active.setStartTime(date1);
            active.setEndTime(date2);
            active.setType(type);
            active.setId(id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(activeService.updActive(active)>0) {
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
    @ApiOperation(value = "根据Id查活动",httpMethod = "POST")
    @RequestMapping(value = "/findById")
    public Dto findById(@RequestParam(value = "id")int id){
        Active active = activeService.findById(id);
        if(active!=null){
            return DtoUtil.returnSuccess("成功",active);
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }

    }
