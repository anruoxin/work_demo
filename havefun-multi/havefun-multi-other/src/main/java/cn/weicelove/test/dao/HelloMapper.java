package cn.weicelove.test.dao;

import cn.weicelove.test.dao.base.MyBaseMapper;
import cn.weicelove.test.entity.Hello;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author QIU PANWEI Create in 2019/9/24 10:50
 */
@Mapper
public interface HelloMapper extends MyBaseMapper<Hello> {

    List<Hello> getAll();
}
