package cn.weicelove.ticketbuy.sqlopt.dao;

import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.sqlopt.base.BaseCustomMyDao;
import cn.weicelove.ticketbuy.sqlopt.mapper.StationMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:01
 */
@Repository
public class StationDao  extends BaseCustomMyDao<StationMapper, StationDO> {

    /**
     * 功能描述:
     *  批量插入或更新车站名称
     * @Param: [stationDOS]
     * @Return: void
     * @Author: QIU PANWEI
     * @Date: 2019/9/23 17:15
     */
    public int insertDownLoadStationNames(List<StationDO> stationDOS) {
        return this.mapper.insertDownLoadStationNames(stationDOS);
    }
}
