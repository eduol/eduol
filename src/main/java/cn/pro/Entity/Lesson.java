package cn.pro.Entity;

import lombok.Data;

@Data
public class Lesson {
    private int id;
    private String code;
    private String name;
    private String grades;
    private double price;
    private int personNum;
    private int status;
    private int type;
    private int fieldId;
    private int lesTime;
    private String path;
}
