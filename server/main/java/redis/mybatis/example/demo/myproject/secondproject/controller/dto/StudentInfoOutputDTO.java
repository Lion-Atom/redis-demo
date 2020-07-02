package redis.mybatis.example.demo.myproject.secondproject.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Data
public class StudentInfoOutputDTO {
    private String sNo;
    private String sName;
    private String sSex;
    private Date sBirthday;
    private String clAss;
}
