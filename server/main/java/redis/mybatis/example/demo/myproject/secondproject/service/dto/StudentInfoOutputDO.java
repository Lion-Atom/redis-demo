package redis.mybatis.example.demo.myproject.secondproject.service.dto;

import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Data
public class StudentInfoOutputDO {
    private String sNo;
    private String sName;
    private String sSex;
    private Date sBirthday;
    private String clAss;
}
