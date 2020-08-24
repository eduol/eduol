package cn.pro.mapper;

import cn.pro.Entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> findAllNorOrder(@Param(value = "ordFrom")String ordFrom,@Param(value = "phone")String phone,@Param(value = "date") String date);
    List<Order> findAllBackOrder(@Param(value = "phone")String phone,@Param(value = "status")int status);
    List<Order> findAllChangePlace();
    Order findOrderById(@Param(value = "id")int id);
    int backOrder(@Param(value = "id")int id);
    int judOrder(@Param(value = "id")int id,@Param(value = "judStatus")int judStatus);
    int changeOrder(@Param(value = "teacher")String teacher,@Param(value = "originPlace")int  originPlace,@Param(value = "newPlace")int  newPlace,@Param(value = "id")int id);
}
