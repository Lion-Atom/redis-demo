package redis.mybatis.example.demo.myproject.secondproject.service.dto;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Data
public class QueryStuInfoInputDO {
    /**
     * 学号列表
     */
    @Size(min=1, max=500, message="snoList参数至少有一个有效参数且参数数量不能多于500个")
    private List<String> snoList;
}
