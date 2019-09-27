package cn.weicelove.ticketbuy;

import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.model.SearchInfo;
import cn.weicelove.ticketbuy.service.StationService;
import cn.weicelove.ticketbuy.service.TicketService;
import cn.weicelove.ticketbuy.util.TicketHttpUtil;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TicketBuyApplication.class)
public class StationTest {

    @Resource
    private StationService stationService;

    @Resource
    private TicketService ticketService;

    @Test
    public void downLoadStationName() {
        List<StationDO> stationDOS = TicketHttpUtil.downLoadStationNameInfo();
        int i = stationService.insertDownLoadStationNames(stationDOS);
        System.out.println("结果：" + i);
    }

    @Test
    public void downLoadTrainInfo() {
        TicketHttpUtil.downLoadTrainInfo();
    }

    @Test
    public void getTrainInfo() {
        SearchInfo searchInfo = new SearchInfo();
        searchInfo.setFromStation("BJP");
        searchInfo.setPurposeCodes("ADULT");
        searchInfo.setToStation("SHH");
        searchInfo.setTrainDate("2019-09-28");
        ticketService.searchTrainInfo(searchInfo);
    }
}
