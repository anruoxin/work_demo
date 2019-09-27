package cn.weicelove.ticketbuy.util;

import cn.weicelove.ticketbuy.constant.UrlConstant.DownLoadInfoUrlEnum;
import cn.weicelove.ticketbuy.constant.UrlConstant.TrainInfoUrlEnum;
import cn.weicelove.ticketbuy.entity.StationDO;
import cn.weicelove.ticketbuy.model.SearchInfo;
import cn.weicelove.ticketbuy.model.TrainInfo;
import cn.weicelove.util.http.NativeHttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/9/20 20:06
 */
public class TicketHttpUtil {

    private static final Logger log = LoggerFactory.getLogger(TicketHttpUtil.class);

    public static String getTrainInfo(SearchInfo searchInfo) {
        Map<String, String> property = new HashMap<>();
        property.put("Cookie", "JSESSIONID=1;");
        try {
            String result = NativeHttpUtil
                    .getWithSetOtherProperty(getUrlWithPara(TrainInfoUrlEnum.TRAIN_INFO_URL.getUrl(), searchInfo), property);
            dealTrainInfo(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("get train info failed. url: {}, property: {}", TrainInfoUrlEnum.TRAIN_INFO_URL.getUrl(), searchInfo);
        }
        return null;
    }

    private static List<String> dealTrainInfo(String trainInfo) {
        if (StringUtils.isBlank(trainInfo)) {
            return null;
        }
        JSONObject trains = JSONObject.parseObject(trainInfo);
        if (trains == null) {
            return null;
        }

        if (trains.containsKey("httpstatus")) {
            Integer httpStatus = trains.getInteger("httpstatus");
            if (httpStatus == 200) {
                if (trains.containsKey("data")) {

                    // 获取火车班次数据
                    JSONObject data = trains.getJSONObject("data");
                    if (data.containsKey("map") && data.containsKey("result")) {
                        JSONObject map = data.getJSONObject("map");
                        JSONArray result = data.getJSONArray("result");
                        if (result != null && result.size() > 0) {
                            List<TrainInfo> trainList = result.stream().map(e -> string2TrainInfoEntity((String) e, map))
                                    .collect(Collectors.toList());
                             System.out.println(trainList.toString());
                        }

                    } else {
                        log.info("not find any trains");
                    }

                } else {
                    log.info("request data failed.");
                }

            } else {
                log.info("request failed with status: {}, message: {}", httpStatus, trains.getString("messages"));
            }
        }

        return null;

        /**
         * {
         * 	"data": {
         * 		"flag": "1",
         * 		"map": {
         * 			"HGH": "杭州东",
         * 			"HZH": "杭州",
         * 			"JBH": "金华",
         * 			"RNH": "金华南"
         *                },
         * 		"result": ["9%2Fdhjk35Zbe7SCOudAag%2FN913WpMzARvKLduOcuYiK46M8gtFus6hE%2Byld3OjYH%2FgXWAE7yxWKZ2%0Ag1JU5138C5zGJKLf%2Bhks%2ByzYlZVVBHslVmMl6PAbfxT9wK7zesnYsMbYBRNTuOstWJUfabl5ILDS%0A7cn6NFOCac6wnvi2xE52M%2F7CPVE92Z%2BT5YnSDkkPU1hmFDd4Cf1WYlnIf9qU46SaOASnBv6sgoeJ%0ADZsd2zrx8s6QUvDR%2F%2FqwtQ%2F9L3Y6aBH55g%2FhQpuEHkvIrlFooul2CH4zgfo0t%2FLN%2BoO3VC436bLA%0APO9r9%2F45HHc%3D|预订|630000K5280Q|K528|GZQ|NJH|JBH|HGH|00:17|02:12|01:55|Y|Qwa%2B%2Fv5NIrPAzwwkznZ8YeeQxG1rL5ru5AEWC3j%2BC7iKrf4Fe6gPXZMC5Dg%3D|20190927|3|QZ|17|19|0|0||||2|||有||1|有|||||10401030|1413|1|0|"]* 	},
         * 	"httpstatus": 200,
         * 	"messages": "",
         * 	"status": true
         * }
         */
    }

    private static TrainInfo string2TrainInfoEntity(String data, JSONObject map) {
        String[] split = data.split("\\|");
        if (split != null && split.length > 0) {
            TrainInfo trainInfo = new TrainInfo();
            trainInfo.setRemark(split[1]);
            trainInfo.setTrainNo(split[2]);
            trainInfo.setTrainNumber(split[3]);
            trainInfo.setDepartureStationTelecode(split[4]);
            trainInfo.setDepartureStation(map.containsKey(split[4]) ? map.getString(split[4]) : split[4]);
            trainInfo.setArrivalStationTelecode(split[5]);
            trainInfo.setArrivalStation(map.containsKey(split[5]) ? map.getString(split[5]) : split[5]);
            trainInfo.setDepartureTime(split[8]);
            trainInfo.setArrivalTime(split[9]);
            trainInfo.setTotalTime(split[10]);
            trainInfo.setArrivalDate(split[11]);
            trainInfo.setDepartDate(split[13].substring(0,4) + "-" + split[13].substring(4,6) +"-" + split[13].substring(6,8));
            trainInfo.setAdvancedSoftSleeper(split[21]);
            trainInfo.setFirstClassSoftSleeper(split[23]);
            trainInfo.setNoSeat(split[26]);
            trainInfo.setSecondClassHardSleeper(split[28]);
            trainInfo.setHardSeat(split[29]);
            trainInfo.setSecondClass(split[30]);
            trainInfo.setFirstClass(split[31]);
            trainInfo.setBusinessClass(split[32]);
             return trainInfo;
        }
        for (int i = 0; i < split.length; i++) {
            System.out.println(i+": " + split[i]);
        }
        return null;
    }

    public static void downLoadTrainInfo() {
        try {
            String fileUrl = "c:/anruoxin/train.txt";
            final boolean andSaveFile = NativeHttpUtil
                    .getAndSaveFile(DownLoadInfoUrlEnum.TRAIN_LIST_INFO_URL.getUrl(), fileUrl);
            log.info("download train info success, path: {}" ,fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("download train info failed.");
        }
    }

    public static List<StationDO> downLoadStationNameInfo() {
        try {
            String stationName = NativeHttpUtil
                    .get(DownLoadInfoUrlEnum.STATION_NAME_URL.getUrl());
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
