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
}
