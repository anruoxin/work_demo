package cn.weicelove.test.dao.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author QIU PANWEI Create in 2019/9/24 14:01
 */
public interface MyBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
