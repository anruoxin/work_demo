package cn.weicelove.ticketbuy.model;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * @author QIU PANWEI Create in 2019/9/27 15:57
 */
@Data
@ToString
public class TrainInfo implements Serializable {

    private static final long serialVersionUID = 6515489409083248371L;

    /**
     * 车次
     */
    private String trainNumber;

    /**
     * 车编号
     */
    private String trainNo;

    /**
     * 出发站
     */
    private String departureStation;

    /**
     * 出发站编号
     */
    private String departureStationTelecode;

    /**
     * 到达站
     */
    private String arrivalStation;

    /**
     * 到达站编码
     */
    private String arrivalStationTelecode;

    /**
     * 出发时间
     */
    private String departureTime;

    /**
     * 到达时间
     */
    private String arrivalTime;

    /**
     * 花费时间
     */
    private String totalTime;

    /**
     * 到达日子
     */
    private String arrivalDate;

    /**
     * 出发日期
     */
    private String departDate;

    /**
     * 商务座或特等座
     */
    private String businessClass;

    private String firstClass;

    private String secondClass;

    /**
     * 高级软卧
     */
    private String advancedSoftSleeper;

    /**
     * 一等软卧
     */
    private String firstClassSoftSleeper;

    /**
     * 动卧
     */
    private String recumbent;

    /**
     * 二等硬卧
     */
    private String secondClassHardSleeper;

    /**
     * 软卧
     */
    private String softSeat;

    /**
     * 硬卧
     */
    private String hardSeat;

    /**
     * 无座
     */
    private String noSeat;

    /**
     * 其他
     */
    private String other;

    /**
     * 备注
     */
    private String remark;
}
