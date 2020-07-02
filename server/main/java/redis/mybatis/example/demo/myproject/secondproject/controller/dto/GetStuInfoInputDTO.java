package redis.mybatis.example.demo.myproject.secondproject.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Data
public class GetStuInfoInputDTO {

    /**
     * 学号
     */
    @NotBlank
    public String sno;
}
