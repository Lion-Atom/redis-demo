package redis.mybatis.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.mybatis.example.demo.myproject.common.utils.EmptyUtil;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.GetStuInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.QueryStuInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.StudentInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.StudentInfoOutputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.service.StudentInfoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentInfoService infoService;

    @Test
    public void getStuInfoBySno() {
        long startTime = System.currentTimeMillis();
        GetStuInfoInputDO inputDO = new GetStuInfoInputDO();
        inputDO.setSno("108");
        StudentInfoOutputDO outputDO = infoService.getStuInfoBySno(inputDO);
        System.out.println(outputDO.toString());
        System.out.println("执行耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void queryStuInfoBySnoList() {
        long startTime = System.currentTimeMillis();
        QueryStuInfoInputDO inputDO = new QueryStuInfoInputDO();
        List<String> snoList = new ArrayList<>();
        snoList.add("108");
        snoList.add("103");
        snoList.add("109");
        inputDO.setSnoList(snoList);
        List<StudentInfoOutputDO> outputDO = infoService.queryStuInfoBySnoList(inputDO);
        System.out.println(outputDO.toString());
        System.out.println("执行耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void saveStudent() throws Exception {
        long startAt = System.currentTimeMillis();
        StudentInfoInputDO infoInputDO = new StudentInfoInputDO();
        Date nowDate = new Date();
        infoInputDO.setSNo("110");
//        infoInputDO.setSNo("111");
        infoInputDO.setSName("王强");
        infoInputDO.setSSex("男");
        infoInputDO.setSBirthday(nowDate);
        infoInputDO.setClAss("95033");
        //保存前判断是更新还是新增
        GetStuInfoInputDO inputDO = new GetStuInfoInputDO();
        inputDO.setSno(infoInputDO.getSNo());
        StudentInfoOutputDO outputDO = infoService.getStuInfoBySno(inputDO);
        if (EmptyUtil.isEmpty(outputDO)) {
            infoService.insertStudentInfo(infoInputDO);
            System.out.print("新增成功！");
        } else {
            infoService.updateStuInfoBySno(infoInputDO);
            System.out.print("更新成功！");
        }
        System.out.print("执行耗时：" + (System.currentTimeMillis() - startAt) + "ms");

    }

}
