package cn.pro.controller;


import cn.pro.Entity.Dto;
import cn.pro.Entity.Try;
import cn.pro.service.TryService;
import cn.pro.utils.DtoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

@Api(value = "试学测试接口api")
@RestController
public class TryController {
    @Resource
    TryService tryService;

    @ApiOperation(value = "查询所有",httpMethod = "POST")
    @RequestMapping(value = "/findAllTry")
    public Dto findAllTry(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size, @RequestParam(value = "type")Integer type){
        PageHelper.startPage(start, size,"id desc");
        List<Try> tl = tryService.findAll(type);
        PageInfo<Try> page = new PageInfo<>(tl);
        return DtoUtil.returnSuccess("成功",page);
    }
    @ApiOperation(value = "新增试学",httpMethod = "POST")
    @RequestMapping(value = "/addTry")
    public Dto AddTry(@RequestParam(value = "name")String name,@RequestParam(value = "starterTime")String starterTime,@RequestParam(value = "endTime")String endTime,@RequestParam(value = "type")int type){
        Try trys = new Try();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = simpleDateFormat.parse(starterTime);
            Date date2 = simpleDateFormat.parse(endTime);
            trys.setName(name);
            trys.setStartTime(date1);
            trys.setEndTime(date2);
            trys.setType(type);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(tryService.addTry(trys)>0) {
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
    @ApiOperation(value = "修改试学",httpMethod = "POST")
    @RequestMapping(value = "/updTry")
    public Dto UpdTry(@RequestParam(value = "id")int id,@RequestParam(value = "name")String name,@RequestParam(value = "starterTime")String starterTime,@RequestParam(value = "endTime")String endTime,@RequestParam(value = "type")int type) {
        Try active = new Try();
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
        if(tryService.updTry(active)>0) {
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
    @ApiOperation(value = "根据Id查试学",httpMethod = "POST")
    @RequestMapping(value = "/findTryById")
    public Dto findTryById(@RequestParam(value = "id")int id){
        Try active = tryService.findById(id);
        if(active!=null){
            return DtoUtil.returnSuccess("成功",active);
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
}
