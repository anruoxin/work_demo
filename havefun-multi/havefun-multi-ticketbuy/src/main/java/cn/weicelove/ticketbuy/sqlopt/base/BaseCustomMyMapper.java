package cn.weicelove.ticketbuy.sqlopt.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author QIU PANWEI Create in 2019/9/23 14:22
 */
public interface BaseCustomMyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
