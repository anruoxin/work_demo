package cn.weicelove.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author QIU PANWEI Create in 2019/11/25 11:45
 */
public class MathTeacherCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment env = context.getEnvironment();
        if (env != null) {
            String teacher = env.getProperty("teacher");
            return "math".equals(teacher.toLowerCase().trim());
        }
        return false;
    }
}
