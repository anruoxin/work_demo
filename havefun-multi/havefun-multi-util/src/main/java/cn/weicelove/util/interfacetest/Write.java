package cn.weicelove.util.interfacetest;

/**
 * @author QIU PANWEI Create in 2020/1/2 21:36
 */
public interface Write {

    public static void writeName() {
        System.out.println("这是接口静态方法");
    }

    default void writeName1() {
        System.out.println("这是接口默认方法1");
    }

    default void writeName2() {
        System.out.println("这是接口默认方法2");
    }

    default void writeName4() {
        System.out.println("这是接口默认方法4");
    }

    void writeName3();

}
