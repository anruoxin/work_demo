package cn.weicelove.ticketbuy.model;

import java.io.Serializable;
import lombok.Data;

/**
 * @author QIU PANWEI Create in 2019/9/27 19:42
 */
@Data
public class SearchTrainDetailInfo implements Serializable {

    private static final long serialVersionUID = -6621295727072851796L;

    /**
     * 列车号
     */
    private String trainNo;

    /**
     * 出发站编码
     */
    private String fromStationTelecode;

    /**
     * 到达站编码
     */
    private String toStationTelecode;

    /**
     * 出发日期
     */
    private String departDate;
}
