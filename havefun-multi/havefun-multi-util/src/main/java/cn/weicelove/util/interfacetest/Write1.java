package cn.weicelove.util.interfacetest;

/**
 * @author QIU PANWEI Create in 2020/1/2 21:45
 */
public interface Write1 {

    default void writeName4() {
        System.out.println("这是Write1接口默认方法4");
    }

}
