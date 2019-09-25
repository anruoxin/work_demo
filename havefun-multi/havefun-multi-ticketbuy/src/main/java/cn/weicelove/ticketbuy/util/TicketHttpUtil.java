package cn.weicelove.ticketbuy.util;

import cn.weicelove.ticketbuy.constant.UrlConstant;
import cn.weicelove.ticketbuy.constant.UrlConstant.DownLoadInfoUrl;
import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.model.SearchInfo;
import cn.weicelove.util.http.NativeHttpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/9/20 20:06
 */
public class TicketHttpUtil {

    private static final Logger log = LoggerFactory.getLogger(TicketHttpUtil.class);

    public static String getTrainInfo(String url, SearchInfo searchInfo) {
        Map<String, String> property = new HashMap<>();
        property.put("Cookie", "JSESSIONID=1;");
        try {
            String result = NativeHttpUtil
                    .getWithSetOtherProperty(getUrlWithPara(url, searchInfo), property);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("get train info failed. url: {}, property: {}", url, searchInfo);
        }
        return null;
    }

    public static void downLoadTrainInfo() {
        try {
            String fileUrl = "c:/anruoxin/train.txt";
            final boolean andSaveFile = NativeHttpUtil
                    .getAndSaveFile(DownLoadInfoUrl.TRAIN_INFO_URL.getUrl(), fileUrl);
            log.info("download train info success, path: {}" ,fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("download train info failed.");
        }
    }

    /**
     * 功能描述:
     *  下载12306所有站点信息，并保存至数据库
     * @Param: []
     * @Return: java.util.List<cn.weicelove.ticketbuy.entity.StationDO>
     * @Author: QIU PANWEI
     * @Date: 2019/9/24 15:51
     */
    public static List<StationDO> downLoadStationNameInfo() {
        try {
            String stationName = NativeHttpUtil
                    .get(DownLoadInfoUrl.STATION_NAME_URL.getUrl());
            List<StationDO> stationDOS = initStationName(stationName);
            return stationDOS;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("download station name failed.");
        }
        return null;
    }

    private static List<StationDO> initStationName(String stationName) {
        if (StringUtils.isBlank(stationName)) {
            return new ArrayList<>();
        }

        List<StationDO> stationVOS = new ArrayList<>();
        Pattern compile = Pattern.compile("'(.+)'");
        Matcher matcher = compile.matcher(stationName);
        if (matcher.find()) {
            String allStations = matcher.group(1);
            if (!StringUtils.isBlank(allStations)) {
                // @bjb|北京北|VAP|beijingbei|bjb|0@bjd|北京东|BOP|beijingdong|bjd|1
                String[] stations = allStations.split("\\d"); // 根据|分割station
                if (stations != null && stations.length > 0) {
                    for (String station : stations) {
                        if (StringUtils.isBlank(station)) {
                            continue;
                        }
                        //  @bjb|北京北|VAP|beijingbei|bjb|
                        String[] split_station = station.split("\\|");
                        StationDO stationVO = new StationDO();
                        stationVO.setStationName(split_station[1]);
                        stationVO.setStationAbbr(split_station[2]);
                        stationVO.setStationPinYin(split_station[3]);
                        stationVO.setStationPinYinAbbr(split_station[4]);
                        stationVOS.add(stationVO);
                    }
                }
            }
        }
        log.info("总车站数：" + 2872);
        log.info("获取车站信息，处理成功车站数： " + stationVOS.size());
        return stationVOS;
    }

    private static String getUrlWithPara(String url, SearchInfo searchInfo) {
        return url + "?" + searchInfo.toString();
    }

}
