package cn.weicelove.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author QIU PANWEI Create in 2019/9/24 10:06
 */
@SpringBootApplication
//@MapperScan("cn.weicelove.test.dao")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestApplication.class);
        ConfigurableApplicationContext run = springApplication.run(args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("注册的bean: " + beanDefinitionName);
//        }
        //SpringApplication.run(TestApplication.class, args);
    }
}
