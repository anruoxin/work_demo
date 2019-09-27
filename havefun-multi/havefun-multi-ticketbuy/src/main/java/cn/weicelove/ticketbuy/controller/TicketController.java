package cn.weicelove.ticketbuy.controller;

import cn.weicelove.ticketbuy.model.SearchInfo;
import cn.weicelove.ticketbuy.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QIU PANWEI Create in 2019/9/25 19:09
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/search")
    public List<String> searchTrainInfo(@RequestBody SearchInfo searchInfo) {
        return ticketService.searchTrainInfo(searchInfo);
    }
}
