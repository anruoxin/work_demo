package cn.weicelove.ticketbuy.model;

import java.io.Serializable;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/9/21 10:58
 */
@Data
public class SearchInfo implements Serializable{

    private static final long serialVersionUID = 7041162036580529766L;
    /**
     * leftTicketDTO.train_date: 2019-09-21
     * leftTicketDTO.from_station: SHH
     * leftTicketDTO.to_station: BJP
     * purpose_codes: ADULT
     */

    /**
     * 出发日期
     */
    private String trainDate;

    /**
     * 出发站
     */
    private String fromStation;

    /**
     * 达到站
     */
    private String toStation;

    /**
     * 出发人身份，大人，学生
     */
    private String purposeCodes;

    private boolean checkAnyPropertyValueBlank() {
        return StringUtils.isBlank(this.trainDate) || StringUtils.isBlank(this.fromStation) ||
        StringUtils.isBlank(this.purposeCodes) || StringUtils.isBlank(this.purposeCodes);
    }

    @Override
    public String toString() {
        if (checkAnyPropertyValueBlank()) {
            throw new NullPointerException("SearchInfo Object's property is null");
        }
        return "leftTicketDTO.train_date=" + this.trainDate + "&leftTicketDTO.from_station="
                + this.fromStation + "&leftTicketDTO.to_station=" + this.toStation + "&purpose_codes=" + this.purposeCodes;
    }

    public static void main(String[] args) {
        SearchInfo searchInfo = new SearchInfo();
//        searchInfo.setFromStation("a");
//        searchInfo.setPurposeCodes("a");
//        searchInfo.setToStation("a");
//        searchInfo.setTrainDate("a");
        System.out.println(searchInfo);
    }


}
