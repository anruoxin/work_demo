package cn.weicelove.spring.aop.operation;

/**
 * @author QIU PANWEI Create in 2019/11/25 10:54
 */
public class AddMethodImpl implements AddMethod{

    @Override
    public void print() {
        System.out.println("这是新添加的方法");
    }
}
