package redis.mybatis.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.mybatis.example.demo.myproject.firstproject.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private UserService service;

    @Test
    public void getUserInfoById() {
        int id = 1;
        List<Map> mapList = service.getById(id);
        System.out.println(mapList);
    }

    @Test
    public void getUserInfoByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Map> mapList = service.getByIds(ids);
        System.out.println(mapList);
    }

    @Test
    void contextLoads() {
        System.out.print("启动成功");
    }

}
