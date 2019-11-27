package cn.weicelove.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author QIU PANWEI Create in 2019/11/25 13:34
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(MathTeacherCondition.class)
    public Teacher mathTeacher() {
        return new MathTeacher();
    }

    @Bean
    @Conditional(EnglishTeacherCondition.class)
    public Teacher englishTeacher() {
        return new EnglishTeacher();
    }

}
