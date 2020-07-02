package redis.mybatis.example.demo.myproject.secondproject.service.service;

import org.apache.commons.collections.ListUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import redis.mybatis.example.demo.myproject.common.utils.BeanMapper;
import redis.mybatis.example.demo.myproject.common.utils.EmptyUtil;
import redis.mybatis.example.demo.myproject.secondproject.dao.StudentService;
import redis.mybatis.example.demo.myproject.secondproject.entity.StudentEntity;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.GetStuInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.QueryStuInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.StudentInfoInputDO;
import redis.mybatis.example.demo.myproject.secondproject.service.dto.StudentInfoOutputDO;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Service
public class StudentInfoService {
    @Autowired
    private StudentService studentService;

    public StudentInfoOutputDO getStuInfoBySno(GetStuInfoInputDO inputDO) {
        StudentInfoOutputDO outputDO = null;
        String sno = inputDO.getSno();
        StudentEntity entity = studentService.getStuInfoBySno(sno);
        if (entity != null) {
            //使用BeanUtils拷贝
//            BeanUtils.copyProperties(entity,outputDO);
            //使用dozer拷贝
//            DozerBeanMapper mapper = new DozerBeanMapper();
//            outputDO = mapper.map(entity,StudentInfoOutputDO.class);
            //使用封装工具BeanMapper拷贝
            outputDO = BeanMapper.map(entity, StudentInfoOutputDO.class);
        }
        return outputDO;
    }

    public List<StudentInfoOutputDO> queryStuInfoBySnoList(QueryStuInfoInputDO inputDO) {
        List<StudentInfoOutputDO> outputDOList = new ArrayList<>();
        List<String> snoList = inputDO.getSnoList();
        List<StudentEntity> entityList = studentService.getStuInfoBySnoList(snoList);
        //判空，封装判空类
        if (!EmptyUtil.isEmpty(entityList)) {
            outputDOList = BeanMapper.mapList(entityList, StudentInfoOutputDO.class);
        }
        return outputDOList;
    }

    public Integer saveStudentInfo(StudentInfoInputDO inputDO) {
        int count = 0;
        if (!EmptyUtil.isEmpty(inputDO)) {
            StudentEntity entity = BeanMapper.map(inputDO, StudentEntity.class);
            String sno = entity.getSNo();
            StudentEntity info = studentService.getStuInfoBySno(sno);
            if (EmptyUtil.isEmpty(info)) {
                studentService.insertStudent(entity);
            }
            studentService.updateStuInfo(entity);
            count = 1;
        } else {
            try {
                throw new Exception("保存数据不可为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public void insertStudentInfo(StudentInfoInputDO inputDO) throws Exception {
        if (!EmptyUtil.isEmpty(inputDO)) {
            StudentEntity entity = BeanMapper.map(inputDO, StudentEntity.class);
            studentService.insertStudent(entity);
        } else {
            throw new Exception("保存数据不可为空");
        }
    }

    public void updateStuInfoBySno(StudentInfoInputDO infoInputDO) throws Exception {
        if (!EmptyUtil.isEmpty(infoInputDO)) {
            StudentEntity entity = BeanMapper.map(infoInputDO, StudentEntity.class);
            studentService.updateStuInfo(entity);
        } else {
            throw new Exception("更新数据不可为空");
        }
    }
}
