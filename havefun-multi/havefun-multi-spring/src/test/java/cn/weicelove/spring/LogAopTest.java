package cn.weicelove.spring;

import cn.weicelove.spring.aop.operation.AddMethod;
import cn.weicelove.spring.aop.operation.AopTest;
import cn.weicelove.spring.condition.Teacher;
import cn.weicelove.spring.config.ApplicationContextRegister;
import cn.weicelove.spring.external.Student;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author QIU PANWEI Create in 2019/11/23 17:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= cn.weicelove.spring.Test.class)
public class LogAopTest {

    @Autowired
    private AopTest aopTest;

    @Resource
    private Teacher teacher;

    @Autowired
    private Student student;

    @Test
    public void test() {
        aopTest.testLog();
        aopTest.testLogPara("你是煞笔");
        AddMethod addMethod = (AddMethod)ApplicationContextRegister.getApplicationContext().getBean("aopTest");
        addMethod.print();
    }


    @Test
    public void testCondition() {
        teacher.teach();
    }

    @Test
    public void testStudent(){
        System.out.println(student);
    }
}
