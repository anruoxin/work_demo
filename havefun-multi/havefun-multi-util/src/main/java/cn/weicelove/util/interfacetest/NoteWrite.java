package cn.weicelove.util.interfacetest;

/**
 * @author QIU PANWEI Create in 2020/1/2 21:38
 */
public class NoteWrite implements Write, Write1{

    @Override
    public void writeName3() {
        System.out.println("类实现的接口方法");
    }

    @Override
    public void writeName2() {
        System.out.println("chongxi");
    }

    @Override
    public void writeName4() {
        System.out.println("这只重写fangfa4");
    }
}
