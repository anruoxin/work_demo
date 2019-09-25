package cn.weicelove.test.service.impl;

import cn.weicelove.test.dao.HelloMapper;
import cn.weicelove.test.entity.Hello;
import cn.weicelove.test.service.HelloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author QIU PANWEI Create in 2019/9/24 10:06
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public List<Hello> sel() {
        return helloMapper.getAll();
    }

    @Override
    public int insertTest(Hello hello) {
        return helloMapper.insert(hello);
    }
}
