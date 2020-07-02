package redis.mybatis.example.demo.myproject.common.constant;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/7/2
 */
public class ApiPathConstants {

    /**
     * API-url头部
     */
    public static final String BASE_CONTEXT = "/api/v1/redis_demo";

    /*********************************用户信息模块*************************************/
    public static final String GET_SINGLE_USERINFO = BASE_CONTEXT + "/user_info/get/by_id";

    /*********************************学生信息模块*************************************/
    public static final String GET_SINGLE_STUDENT_NFO = BASE_CONTEXT + "/stu_info/get/by_sno";
    public static final String QUERY_SINGLE_STUDENT_NFO = BASE_CONTEXT + "/stu_info/query";
    public static final String SAVE_SINGLE_STUDENT_NFO = BASE_CONTEXT + "/stu_info/save";

}
