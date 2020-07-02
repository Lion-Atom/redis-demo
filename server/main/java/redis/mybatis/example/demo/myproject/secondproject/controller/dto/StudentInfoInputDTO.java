package redis.mybatis.example.demo.myproject.secondproject.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Data
public class StudentInfoInputDTO {
    /**
     * 学生学号
     */
    private String sNo;

    /**
     * 学生姓名
     */
    private String sName;

    /**
     * 学生性别
     */
    private String sSex;

    /**
     * 学生生日
     */
    private Date sBirthday;

    /**
     * 学生所在班级
     */
    private String clAss;
}
