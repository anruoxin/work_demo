package cn.weicelove.ticketbuy.service;

import cn.weicelove.ticketbuy.entity.StationDO;
import java.util.List;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:07
 */
public interface StationService {

    int insertDownLoadStationNames(List<StationDO> stationDOS);
}
