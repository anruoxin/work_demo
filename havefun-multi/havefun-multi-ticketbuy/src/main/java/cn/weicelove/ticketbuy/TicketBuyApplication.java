package cn.weicelove.ticketbuy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author QIU PANWEI Create in 2019/9/17 16:00
 */
@Slf4j
@SpringBootApplication
public class TicketBuyApplication {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(TicketBuyApplication.class);
//        ConfigurableApplicationContext run = app.run(args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        SpringApplication.run(TicketBuyApplication.class, args);
        log.info("================TicketBuyApplication Run SUCCESS===========");
    }

//    public static void getData() {
//        try {
//            Map<String, String> property = new HashMap<>();
//            // property.put("Cookie", "RAIL_EXPIRATION=1568997803744; RAIL_DEVICEID=eX0WoidMzk1GubWs4524wNfD4HnFLA4VqhVc3QFU8dv9W1OKniFwjvPZtJ-oSrcbb4lGYGFrdYwhPpiO16G6LFkT423ZzhfMMTa6Hhggoz3KBbjpUIVWBgTHOpjwHud1d5_YT3zmbglwzI0_ZJiLXNhk2Pj4CQgm; BIGipServerpool_index=821035530.43286.0000; route=9036359bb8a8a461c164a04f8f50b252; BIGipServerotn=116392458.24610.0000");
//            // property.put("Cookie", "JSESSIONID=61F55A7A453BB423B9CFA7388B76FAC9; RAIL_EXPIRATION=1568997803744; RAIL_DEVICEID=eX0WoidMzk1GubWs4524wNfD4HnFLA4VqhVc3QFU8dv9W1OKniFwjvPZtJ-oSrcbb4lGYGFrdYwhPpiO16G6LFkT423ZzhfMMTa6Hhggoz3KBbjpUIVWBgTHOpjwHud1d5_YT3zmbglwzI0_ZJiLXNhk2Pj4CQgm; _jc_save_toStation=%u91D1%u534E%2CJBH; _jc_save_wfdc_flag=dc; _jc_save_fromStation=%u676D%u5DDE%2CHZH; _jc_save_fromDate=2019-09-20; _jc_save_toDate=2019-09-20; BIGipServerpool_passport=300745226.50215.0000; route=6f50b51faa11b987e576cdb301e545c4; BIGipServerotn=871367178.50210.0000");
//            // property.put("Cookie", "tk=2VqUmKZyLl5aCesk8zJX9XgaTLzotzutdEQWjELHFSwrw1110; JSESSIONID=D93D87FDAFE88F23867184FC76C00C93; RAIL_EXPIRATION=1568997803744; RAIL_DEVICEID=eX0WoidMzk1GubWs4524wNfD4HnFLA4VqhVc3QFU8dv9W1OKniFwjvPZtJ-oSrcbb4lGYGFrdYwhPpiO16G6LFkT423ZzhfMMTa6Hhggoz3KBbjpUIVWBgTHOpjwHud1d5_YT3zmbglwzI0_ZJiLXNhk2Pj4CQgm; BIGipServerpool_passport=384631306.50215.0000; route=6f50b51faa11b987e576cdb301e545c4; _jc_save_toStation=%u91D1%u534E%2CJBH; _jc_save_wfdc_flag=dc; BIGipServerpassport=988283146.50215.0000; BIGipServerotn=854589962.38945.0000; _jc_save_fromStation=%u676D%u5DDE%2CHZH; _jc_save_fromDate=2019-09-20; _jc_save_toDate=2019-09-20");
//            property.put("Cookie", "JSESSIONID=F962BAD7C7AF21AB23E6D86EC662AD38; route=c5c62a339e7744272a54643b3be5bf64; BIGipServerotn=49283594.50210.0000; _jc_save_toDate=2019-09-21; _jc_save_wfdc_flag=dc; RAIL_EXPIRATION=1569340381451; RAIL_DEVICEID=acTrEFbQSa9gaVb3-UKT1La4xqMV44fgxnhicaVScUmb575LdTKo3udD01FaSKKGRDYUUxloezEqpcXyGLOPgiyL-71pcibOxIEN1goudqrhHG8IUy0TtJQsOP_uQ3E3cWU4ueDxaxzBkyV_JpiuI_BslDGynufJ; _jc_save_toStation=%u91D1%u534E%2CJBH; _jc_save_fromStation=%u676D%u5DDE%2CHZH; _jc_save_fromDate=2019-09-21");
//           // NativeHttpUtil.setRequestProperty(property);
//            NativeHttpUtil.get("https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2019-09-20&leftTicketDTO.from_station=HZH&leftTicketDTO.to_station=JBH&purpose_codes=ADULT");
//            // BasicHeader basicHeader = new BasicHeader("Cookie","tk=2VqUmKZyLl5aCesk8zJX9XgaTLzotzutdEQWjELHFSwrw1110; JSESSIONID=15700A78BAE266E07B1AD546080FCC1A; RAIL_EXPIRATION=1568997803744; RAIL_DEVICEID=eX0WoidMzk1GubWs4524wNfD4HnFLA4VqhVc3QFU8dv9W1OKniFwjvPZtJ-oSrcbb4lGYGFrdYwhPpiO16G6LFkT423ZzhfMMTa6Hhggoz3KBbjpUIVWBgTHOpjwHud1d5_YT3zmbglwzI0_ZJiLXNhk2Pj4CQgm; BIGipServerpool_passport=384631306.50215.0000; route=6f50b51faa11b987e576cdb301e545c4; _jc_save_toStation=%u91D1%u534E%2CJBH; _jc_save_wfdc_flag=dc; BIGipServerpassport=988283146.50215.0000; BIGipServerotn=854589962.38945.0000; _jc_save_fromStation=%u676D%u5DDE%2CHZH; _jc_save_fromDate=2019-09-20; _jc_save_toDate=2019-09-20");
//
//            // HttpClientUtil.getAddHeader("https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2019-09-20&leftTicketDTO.from_station=HZH&leftTicketDTO.to_station=JBH&purpose_codes=ADULT", basicHeader);
//            // HttpClientUtil.get("https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2019-09-20&leftTicketDTO.from_station=HZH&leftTicketDTO.to_station=JBH&purpose_codes=ADULT");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void getCookie() {
//        HttpClientUtil.get("https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc&fs=%E6%9D%AD%E5%B7%9E,HZH&ts=%E9%87%91%E5%8D%8E,JBH&date=2019-09-20&flag=N,N,Y");
//    }
//    public static void main(String[] args) throws Exception {
////         getData();
//
////        SearchInfo searchInfo = new SearchInfo();
////        searchInfo.setTrainDate("2019-09-22");
////        searchInfo.setToStation("JBH");
////        searchInfo.setPurposeCodes("ADULT");
////        searchInfo.setFromStation("HZH");
////        String trainInfo = TicketHttpUtil.getTrainInfo("https://kyfw.12306.cn/otn/leftTicket/queryA", searchInfo);
////        System.out.println(trainInfo);
//        // NativeHttpUtil.get("https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2019-09-20&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=SHH&purpose_codes=ADULT");
//        //HttpClientUtil.get("https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2019-09-20&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=SHH&purpose_codes=ADULT");
////        NativeHttpUtil.setRequestProperty(new HashMap<String, String>(){
////            {put("Cookie", "RAIL_EXPIRATION=1569313411136;");}
////        });
////        NativeHttpUtil.get("https://kyfw.12306.cn/otn/leftTicket/init");
//
////         BasicHeader basicHeader = new BasicHeader("Cookie","RAIL_EXPIRATION=1569313411136;");
////         HttpClientUtil.getAddHeader("https://kyfw.12306.cn/otn/leftTicket/init", basicHeader);
//        TicketHttpUtil.downLoadStationNameInfo();
//        //init();
//    }



}
