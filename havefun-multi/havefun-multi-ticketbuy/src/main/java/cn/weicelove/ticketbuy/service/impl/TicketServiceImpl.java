package cn.weicelove.ticketbuy.service.impl;

import cn.weicelove.ticketbuy.model.SearchInfo;
import cn.weicelove.ticketbuy.service.TicketService;
import cn.weicelove.ticketbuy.util.TicketHttpUtil;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author QIU PANWEI Create in 2019/9/25 19:11
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public List<String> searchTrainInfo(SearchInfo searchInfo) {
        String trainInfo = TicketHttpUtil.getTrainInfo(searchInfo);
        System.out.println(trainInfo);
        return null;
    }
}
