package cn.pro.controller;

import cn.pro.Entity.Dto;
import cn.pro.Entity.Order;
import cn.pro.service.OrderService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "订单接口Api")
@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @ApiOperation(value = "查询所有普通订单",httpMethod = "POST")
    @RequestMapping(value = "/findAllNorOrder")
    public Dto findAllNorOrder(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size,@RequestParam(value = "ordFrom",required = false)String ordFrom,@RequestParam(value = "phone",required = false)String phone,@RequestParam(value = "date",required = false)String date){
        PageHelper.startPage(start, size,"id desc");
        List<Order> orderList = orderService.findAllNorOrder(ordFrom,phone,date);
        PageInfo<Order> page = new PageInfo<>(orderList);
        return DtoUtil.returnSuccess("成功",page);
    }

    @ApiOperation(value = "查询所有退费订单",httpMethod = "POST")
    @RequestMapping(value = "/findAllBackOrder")
    public Dto findAllBackOrder(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size,@RequestParam(value = "phone",required = false)String phone,@RequestParam(value = "backStatus",required = false)int backStatus){
        PageHelper.startPage(start, size,"id desc");
        List<Order> orderList = orderService.findAllBackOrder(phone,backStatus);
        PageInfo<Order> page = new PageInfo<>(orderList);
        return DtoUtil.returnSuccess("成功",page);
    }

    @ApiOperation(value = "查询所有转校订单",httpMethod = "POST")
    @RequestMapping(value = "/findAllChangePlace")
    public Dto findAllChangePlace(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size){
        PageHelper.startPage(start, size,"id desc");
        List<Order> orderList = orderService.findAllChangePlace();
        PageInfo<Order> page = new PageInfo<>(orderList);
        return DtoUtil.returnSuccess("成功",page);
    }

    @ApiOperation(value = "根据Id查订单",httpMethod = "POST")
    @RequestMapping(value = "/findOrderById")
    public Dto findOrderById(@RequestParam(value = "id",required = false)int id){
        Order order = orderService.findOrderById(id);
        return DtoUtil.returnSuccess("成功",order);
    }

    @ApiOperation(value = "根据Id退费",httpMethod = "POST")
    @RequestMapping(value = "/backOrder")
    public Dto backOrder(@RequestParam(value = "id")int id){
        int num = orderService.backOrder(id);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }

    @ApiOperation(value = "审核转校",httpMethod = "POST")
    @RequestMapping(value = "/judOrder")
    public Dto judOrder(@RequestParam(value = "id")int id,@RequestParam(value = "status")int status){
        int num = orderService.judOrder(id,status);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
    @ApiOperation(value = "新增转校",httpMethod = "POST")
    @RequestMapping(value = "/changeOrder")
    public Dto changeOrder(@RequestParam(value = "id")int id,@RequestParam(value = "teacher")String teacher,@RequestParam(value = "originPlace")int originPlace,@RequestParam(value = "newPlace")int newPlace){
        int num = orderService.changeOrder(teacher,originPlace,newPlace,id);
        if(num>0){
            return DtoUtil.returnSuccess("成功");
        }else {
            return DtoUtil.returnFail("失败","114514");
        }
    }
}
