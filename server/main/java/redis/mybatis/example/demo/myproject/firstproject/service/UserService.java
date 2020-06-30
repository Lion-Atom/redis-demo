package redis.mybatis.example.demo.myproject.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.mybatis.example.demo.myproject.firstproject.dao.UserDao;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<Map> getById(Integer id) {
        return userDao.getById(id);
    }

    public List<Map> getByIds(List<Integer> ids) {
        return userDao.getByIds(ids);
    }
}
