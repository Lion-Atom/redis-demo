package redis.mybatis.example.demo.myproject.firstproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户标识查询用户信息
     *
     * @param id 用户标识
     * @return 用户信息
     */
    List<Map> getById(@Param("id") Integer id);

    /**
     * 根据用户标识集合批量查询用户信息
     *
     * @param ids 用户标识集合
     * @return 用户信息
     */
    List<Map> getByIds(List<Integer> ids);
}
