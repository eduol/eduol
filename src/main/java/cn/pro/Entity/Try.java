package cn.pro.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Try {
    private int id;
    private String name;
    private Date startTime;
    private Date endTime;
    private int type;
}
