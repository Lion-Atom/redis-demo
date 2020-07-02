package redis.mybatis.example.demo.myproject.secondproject.dao;

import org.apache.ibatis.annotations.Mapper;
import redis.mybatis.example.demo.myproject.secondproject.entity.StudentEntity;

import java.util.List;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/6/30
 */
@Mapper
public interface StudentService {
    /**
     * 根据学号查询学生信息
     *
     * @param sno 学号
     * @return 学生信息
     */
    StudentEntity getStuInfoBySno(String sno);

    /**
     * 根据学号集合查询学生信息
     *
     * @param snoList 学号列表
     * @return 学生信息列表
     */
    List<StudentEntity> getStuInfoBySnoList(List<String> snoList);

    /**
     * 新增学生信息
     *
     * @param entity 新增学生信息
     */
    void insertStudent(StudentEntity entity);

    /**
     * 更新学生信息
     *
     * @param entity 学生新的信息
     */
    void updateStuInfo(StudentEntity entity);
}
