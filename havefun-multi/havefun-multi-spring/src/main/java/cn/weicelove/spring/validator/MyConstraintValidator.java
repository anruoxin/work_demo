package cn.weicelove.spring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 新建一个注解校验类，实现 ConstraintValidator<自定义注解名称, Object>
 * @author QIU PANWEI Create in 2019/11/25 16:08
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    /**
     *
     * 校验前的初始化步骤
     * @param 
     * @return void
     * @author QIU PANWEI
     */
    @Override
    public void initialize(MyConstraint constraintAnnotation) {

    }

    /**
     * 校验方法
     * @param o 参数为需要校验的值
     * @param constraintValidatorContext 校验上下文
     * @return boolean
     * @author QIU PANWEI
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
