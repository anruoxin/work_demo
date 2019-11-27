package cn.weicelove.spring.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义注解
 * @author QIU PANWEI Create in 2019/11/25 16:10
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
// @Constraint注解表明这个注解是用于规则校验的，validatedBy属性表明用什么去校验
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {

    // 校验不通过时，提示语
    String messge();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
