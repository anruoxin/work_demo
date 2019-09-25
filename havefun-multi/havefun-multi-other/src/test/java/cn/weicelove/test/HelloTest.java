package cn.weicelove.test;

import cn.weicelove.test.entity.Hello;
import cn.weicelove.test.service.HelloService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author QIU PANWEI Create in 2019/9/24 10:54
 */
@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void test() {
        Hello hello = new Hello();
        hello.setName("aaa");
        helloService.insertTest(hello);
        List<Hello> hellos = helloService.sel();
        System.out.println(hellos.size());
    }

}
