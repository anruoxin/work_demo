package cn.weicelove.util.string;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/11/13 13:37
 */
public class StringUtil {

    public static void main(String[] args) {
        String data = "[{\"password\":\"d0b16053b3cc49178c68eb98ab1d598b\",\"oldPassword\":\"72cb6548eb741ffadfbfc1071d5ddb10\",\"mobile\":\"19900000005\"}]";
        System.out.println(filterSensitiveInfo(data));
        System.out.println(filterSensitiveInfo1(data));
    }

    public static String filterSensitiveInfo(String jsonStr) {
        JSONArray objects = JSONArray.parseArray(jsonStr);
        for (int i = 0; i < objects.size(); i++) {
            JSONObject jsonObject = objects.getJSONObject(i);
            if (jsonObject.containsKey("password")) {
                jsonObject.remove("password");
            }
            if (jsonObject.containsKey("oldPassword")) {
                jsonObject.remove("oldPassword");
            }
            jsonObject.remove("asdasd");
        }
        return JSONObject.toJSONString(objects);
    }

    public static String filterSensitiveInfo1(String jsonStr) {
        JSONArray collect = JSONArray.parseArray(jsonStr).stream().filter(obj -> {
            ((JSONObject) obj).remove("password");
            ((JSONObject) obj).remove("oldPassword");
            return true;
        }).collect(Collectors.toCollection(JSONArray::new));
        return JSONObject.toJSONString(collect);
    }

}
