package cn.weicelove.ticketbuy.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 * @author QIU PANWEI Create in 2019/9/23 11:33
 */
@Data
@Table(name = "t_station")
public class StationDO implements Serializable {

    private static final long serialVersionUID = 3037791075566759118L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 站名
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 站缩写
     */
    @Column(name = "station_abbr")
    private String stationAbbr;

    /**
     * 站拼音
     */
    @Column(name = "station_pin_yin")
    private String stationPinYin;

    /**
     * 站拼音缩写
     */
    @Column(name = "station_pin_yin_abbr")
    private String stationPinYinAbbr;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
