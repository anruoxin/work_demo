package cn.weicelove.ticketbuy.sqlopt.mapper;

import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.sqlopt.base.BaseCustomMyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:02
 */
@Mapper
public interface StationMapper extends BaseCustomMyMapper<StationDO> {
    int insertDownLoadStationNames(List<StationDO> stationDOS);
}
