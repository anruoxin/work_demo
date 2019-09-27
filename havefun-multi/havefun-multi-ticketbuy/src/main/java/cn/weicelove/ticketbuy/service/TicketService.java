package cn.weicelove.ticketbuy.service;

import cn.weicelove.ticketbuy.model.SearchInfo;
import java.util.List;

/**
 * @author QIU PANWEI Create in 2019/9/25 19:11
 */
public interface TicketService {

    List<String> searchTrainInfo(SearchInfo searchInfo);
}
