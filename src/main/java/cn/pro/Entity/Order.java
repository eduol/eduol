package cn.pro.Entity;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private int id;
    private String ordFrom;
    private String teacher;
    private String phone;
    private String stuId;
    private String lesName;
    private int stuStatus;
    private double price;
    private int backStatus;
    private int originPlace;
    private int newPlace;
    private int judStatus;
    private int status;
    private Date date;
}
