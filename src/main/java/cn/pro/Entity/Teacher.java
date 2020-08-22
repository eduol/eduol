package cn.pro.Entity;

import lombok.Data;

@Data
public class Teacher {
    private int id;
    private int type;
    private int fieldId;
    private String phone;
    private String grade;
    private String subjects;
    private String name;
}
