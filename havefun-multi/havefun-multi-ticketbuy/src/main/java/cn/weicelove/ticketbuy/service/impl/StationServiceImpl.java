package cn.weicelove.ticketbuy.service.impl;

import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.service.StationService;
import cn.weicelove.ticketbuy.sqlopt.dao.StationDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:07
 */
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertDownLoadStationNames(List<StationDO> stationDOS) {
        return stationDao.insertDownLoadStationNames(stationDOS);
    }

}
