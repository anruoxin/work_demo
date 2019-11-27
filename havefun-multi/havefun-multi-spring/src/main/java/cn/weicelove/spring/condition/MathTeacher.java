package cn.weicelove.spring.condition;

/**
 * @author QIU PANWEI Create in 2019/11/25 11:47
 */
public class MathTeacher implements Teacher{

    @Override
    public void teach() {
        System.out.println("教数学");
    }
}
