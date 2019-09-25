package cn.weicelove.test.service;

import cn.weicelove.test.entity.Hello;
import java.util.List;

/**
 * @author QIU PANWEI Create in 2019/9/24 10:06
 */
public interface HelloService {

    List<Hello> sel();

    int insertTest(Hello hello);
}
