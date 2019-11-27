package cn.weicelove.spring.condition;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author QIU PANWEI Create in 2019/11/25 11:45
 */
public class EnglishTeacherCondition implements Condition {

    /*
    通过ConditionContext，我们可以做到如下几点：

    1.借助getRegistry()返回的BeanDefinitionRegistry检查bean定义；

    2.借助getBeanFactory()返回的ConfigurableListableBeanFactory检查bean是否存在，甚至探查bean的属性；

    3.借助getEnvironment()返回的Environment检查环境变量是否存在以及它的值是什么；

    4.读取并探查getResourceLoader()返回的ResourceLoader所加载的资源；

    5.借助getClassLoader()返回的ClassLoader加载并检查类是否存在。

    AnnotatedTypeMetadata则能够让我们检查带有@Bean注解的方法上还有什么其他的注解。

    借助isAnnotated()方法，我们能够判断带有@Bean注解的方法是不是还有其他特定的注解。借助其他的那些方法，我们能够检查@Bean注解的方法上其他注解的属性。
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment env = context.getEnvironment();
        if (env != null) {
            String teacher = env.getProperty("teacher");
            return "english".equals(teacher.toLowerCase().trim());
        }
        return false;
    }
}
