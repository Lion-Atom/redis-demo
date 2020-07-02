package redis.mybatis.example.demo.myproject.secondproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.mybatis.example.demo.myproject.common.constant.ApiPathConstants;
import redis.mybatis.example.demo.myproject.common.utils.BeanMapper;
import redis.mybatis.example.demo.myproject.common.utils.EmptyUtil;
import redis.mybatis.example.demo.myproject.secondproject.controller.dto.QueryStuInfoInputDTO;
import redis.mybatis.example.demo.myproject.secondproject.controller.dto.StudentInfoInputDTO;
import redis.mybatis.example.demo.myproject.secondproject.controller.dto.StudentInfoOutputDTO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.GetStuInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.QueryStuInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.StudentInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.StudentInfoOutputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.service.StudentInfoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/7/2
 */
@RestController
public class StudentController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping(value = ApiPathConstants.GET_SINGLE_STUDENT_NFO)
    public StudentInfoOutputDTO getBySno(@RequestBody GetStuInfoInputDO inputDTO) {
        GetStuInfoInputDO inputDO = BeanMapper.map(inputDTO, GetStuInfoInputDO.class);
        StudentInfoOutputDO outputDO = studentInfoService.getStuInfoBySno(inputDO);
        if (EmptyUtil.isEmpty(outputDO)) {
            try {
                throw new Exception("查不到数据");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return BeanMapper.map(outputDO, StudentInfoOutputDTO.class);
    }

    @RequestMapping(value = ApiPathConstants.QUERY_SINGLE_STUDENT_NFO)
    public List<StudentInfoOutputDTO> queryBySnoList(@RequestBody QueryStuInfoInputDTO inputDTO) {
        List<StudentInfoOutputDTO> outputDTOS = new ArrayList<>();
        QueryStuInfoInputDO inputDO = BeanMapper.map(inputDTO, QueryStuInfoInputDO.class);
        List<StudentInfoOutputDO> list = studentInfoService.queryStuInfoBySnoList(inputDO);
        if (!EmptyUtil.isEmpty(list)) {
            outputDTOS = BeanMapper.mapList(list, StudentInfoOutputDTO.class);
        }
        return outputDTOS;
    }

    @RequestMapping(value = ApiPathConstants.SAVE_SINGLE_STUDENT_NFO)
    public void saveStudentInfo(@RequestBody StudentInfoInputDTO inputDTO) {
        StudentInfoInputDO inputDO = BeanMapper.map(inputDTO, StudentInfoInputDO.class);
        studentInfoService.saveStudentInfo(inputDO);
    }
}
