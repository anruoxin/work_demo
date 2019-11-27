package cn.weicelove.spring.external;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author QIU PANWEI Create in 2019/11/25 14:42
 */
@Configuration
//加载外部配置文件
@PropertySource("classpath:student.properties")
public class StudentConfig {

    //注入Spring环境对象
    @Autowired
    private Environment env;

    @Bean(name = "student")
    public Student student() {
        String name = env.getProperty("student.name");
        Integer age = Integer.valueOf(Objects.requireNonNull(env.getProperty("student.age")));
        return new Student(name, age);
    }
}
