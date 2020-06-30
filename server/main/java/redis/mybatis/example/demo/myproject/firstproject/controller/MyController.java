package redis.mybatis.example.demo.myproject.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.mybatis.example.demo.myproject.firstproject.dto.GetUserInfoByIdInputDTO;
import redis.mybatis.example.demo.myproject.firstproject.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@RestController
@RequestMapping("/myproject/firstproject")
public class MyController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public List<Map> getUserById(@RequestBody @Validated GetUserInfoByIdInputDTO inputDTO) {
        return userService.getById(inputDTO.getId());
    }
}
