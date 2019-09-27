package cn.weicelove.ticketbuy.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author QIU PANWEI Create in 2019/9/20 20:08
 */
public class UrlConstant {

    @Getter
    @AllArgsConstructor
    public enum DownLoadInfoUrlEnum {
        STATION_NAME_URL("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js"),
        TRAIN_LIST_INFO_URL("https://kyfw.12306.cn/otn/resources/js/query/train_list.js?scriptVersion=1.0");
        private String url;
    }

    @Getter
    @AllArgsConstructor
    public enum TrainInfoUrlEnum {
        TRAIN_INFO_URL("https://kyfw.12306.cn/otn/leftTicket/queryA"),
        TRAIN_INFO_DETAIL_URL("https://kyfw.12306.cn/otn/czxx/queryByTrainNo");
        private String url;
    }

}
