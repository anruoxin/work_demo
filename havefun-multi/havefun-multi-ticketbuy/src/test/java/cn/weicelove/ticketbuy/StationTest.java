package cn.weicelove.ticketbuy;

import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.service.StationService;
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
}
