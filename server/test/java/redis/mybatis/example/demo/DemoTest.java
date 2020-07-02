package redis.mybatis.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: tmj
 * @date: 2020/7/1
 */
@RunWith(SpringRunner.class) //标识为JUnit的运行环境
@SpringBootTest  //获取启动类、加载配置，确定装载Spring Boot
public class DemoTest {

    /**
     * 注解说明
     *
     * .@Runwith(SpringRunner.class): 标识为JUnit的运行环境
     * .@SpringBootTest:获取启动类、加载配置，确定装载Spring Boot
     * .@Test:声明需要测试的方法
     * .@BeforeClass:针对所有测试，只执行一次，且必须是static void
     * .@AfterClass:针对所有测试，只执行一次，且必须是static void
     * .@Before:每个测试方法前都会执行的方法
     * .@After:每个测试方法都会执行的方法
     * .@Ignore:忽略方法
     */
    @Test(timeout = 1000) //声明需要测试的方法
    public void doTest() {
        int num = new Integer(1);
        Assert.assertEquals(num, 1);
    }

    /**
     *断言测试
     *Assert.assertEquals 对比两个值相等
     *Assert.assertNotEquals 对比两个值相等
     *Assert.assertSame 对比两个对象的引用相等
     *Assert.assertArrayEquals 对比两个数组相等
     *Assert.assertTrue 验证返回是否为真
     * Assert.assertFlase 验证返回是否为假
     * Assert.assertNull 验证null
     * Assert.assertNotNull 验证非null
     */
    @Test
    public void assertTest(){
        String[] str1= {"1","2"};
        String[] str2 = str1;
        String[] str3 = {"1","2"};

        Assert.assertEquals(str1,str3);
        Assert.assertEquals(str2,str3);
        Assert.assertSame(str1, str2);
        Assert.assertSame(str2, str3); // 引用不同，此处会报错
    }
}
