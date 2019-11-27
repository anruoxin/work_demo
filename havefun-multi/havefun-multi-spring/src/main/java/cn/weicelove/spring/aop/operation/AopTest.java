package cn.weicelove.spring.aop.operation;

import org.springframework.stereotype.Component;

/**
 * @author QIU PANWEI Create in 2019/11/23 17:16
 */
@Component
public class AopTest {

    public void testLog() {
        System.out.println("这是测试方法");
    }

    public void testLogPara(String name) {
        System.out.println("这是参数" + name);
    }

}
