package cn.pro.controller;

import cn.pro.Entity.Dto;
import cn.pro.Entity.Filed;
import cn.pro.service.FiledService;
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

@Api(value = "校区管理Api")
@RestController
public class FiledController {
    @Resource
    FiledService filedService;

    @ApiOperation(value = "查询所有校区",httpMethod = "POST")
    @RequestMapping(value = "/findAllFiled")
    public Dto findAllFiled(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size){
        PageHelper.startPage(start, size,"id desc");
        List<Filed> filedList = filedService.findAllFiled();
        PageInfo<Filed> page = new PageInfo<>(filedList);
        return DtoUtil.returnDataSuccess(page);
    }

    @ApiOperation(value = "新增校区",httpMethod = "POST")
    @RequestMapping(value = "/addFiled")
    public Dto addFiled(@RequestParam(value = "name")String name,@RequestParam(value = "address")String address,@RequestParam(value = "phone")String phone){
        Filed filed = new Filed();
        filed.setName(name);
        filed.setAddress(address);
        filed.setPhone(phone);
        int num = filedService.addFiled(filed);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }{
            return DtoUtil.returnFail("失败","114514");
        }
    }

    @ApiOperation(value = "修改校区",httpMethod = "POST")
    @RequestMapping(value = "/updFiled")
    public Dto updFiled(@RequestParam(value = "id")int id,@RequestParam(value = "name")String name,@RequestParam(value = "address")String address,@RequestParam(value = "phone")String phone){
        Filed filed = new Filed();
        filed.setId(id);
        filed.setName(name);
        filed.setAddress(address);
        filed.setPhone(phone);
        int num = filedService.updFiled(filed);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }{
            return DtoUtil.returnFail("失败","114514");
        }
    }

    @ApiOperation(value = "根据Id查校区",httpMethod = "POST")
    @RequestMapping(value = "/findFiledById")
    public Dto findFiledById(@RequestParam(value = "id",defaultValue = "0")int id){
        Filed filed = filedService.findFiledById(id);
        if(filed!=null) {
            return DtoUtil.returnDataSuccess(filed);
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }

}
