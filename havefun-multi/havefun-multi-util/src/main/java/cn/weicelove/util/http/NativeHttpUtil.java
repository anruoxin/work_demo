package cn.weicelove.util.http;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/9/20 10:42
 */
public class NativeHttpUtil {

    private static final Logger log = LoggerFactory.getLogger(NativeHttpUtil.class);

    private static final Map<String, String> property = new HashMap<>();

    private static void setRequestProperty(Map<String, String> para) {
        property.clear();
        property.putAll(para);
    }

    public static String getWithSetOtherProperty(String urlStr, Map<String, String> property) throws Exception {
        setRequestProperty(property);
        return get(urlStr);
    }

    public static boolean getAndSaveFile(String urlStr, String fileName) throws IOException {
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))) {
            byte[] content = new byte[1024 * 1024];
            while(bufferedInputStream.read(content) > 0) {
                fileOutputStream.write(content);
            }
            return Boolean.TRUE;
        }
    }
    /**
     * 使用URLConnection实现GET请求
     *
     * 1.实例化一个java.net.URL对象；
     * 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection;
     * 3.通过URLConnection对象的getInputStream()方法获得输入流；
     * 4.读取输入流；
     * 5.关闭资源；
     */
    public static String get(String urlStr) throws Exception {

        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection(); // 打开连接

        // urlConnection.setRequestProperty("Cookie", "tk=2VqUmKZyLl5aCesk8zJX9XgaTLzotzutdEQWjELHFSwrw1110; JSESSIONID=15700A78BAE266E07B1AD546080FCC1A; RAIL_EXPIRATION=1568997803744; RAIL_DEVICEID=eX0WoidMzk1GubWs4524wNfD4HnFLA4VqhVc3QFU8dv9W1OKniFwjvPZtJ-oSrcbb4lGYGFrdYwhPpiO16G6LFkT423ZzhfMMTa6Hhggoz3KBbjpUIVWBgTHOpjwHud1d5_YT3zmbglwzI0_ZJiLXNhk2Pj4CQgm; BIGipServerpool_passport=384631306.50215.0000; route=6f50b51faa11b987e576cdb301e545c4; _jc_save_toStation=%u91D1%u534E%2CJBH; _jc_save_wfdc_flag=dc; BIGipServerpassport=988283146.50215.0000; BIGipServerotn=854589962.38945.0000; _jc_save_fromStation=%u676D%u5DDE%2CHZH; _jc_save_fromDate=2019-09-20; _jc_save_toDate=2019-09-20");
        //必须设置false，否则会自动redirect到重定向后的地址
        // urlConnection.setInstanceFollowRedirects(false);
//        urlConnection.setRequestProperty("Accept", "*/*");
//        urlConnection.setRequestProperty("Connection", "Keep-Alive");
//        urlConnection.setRequestProperty("User-Agent",
//                "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");

        StringBuilder content = new StringBuilder(); // 保存的内容
        getInputContent(urlConnection, content);
        return content.toString();
    }

    private static void getInputContent(URLConnection urlConnection, StringBuilder content) throws IOException {
        setURLConnectionRequestProperty(urlConnection);
        try(BufferedReader inputContent = new BufferedReader( // 获取的字符流
                new InputStreamReader(urlConnection.getInputStream(), "utf-8"))) {
            String line;
            while ((line = inputContent.readLine()) != null) {
                content.append(line + '\n');
            }
        }
        log.info("返回的结果： {}", content.toString());
    }

    /**
     * 功能描述:
     *  设置一些自定义的属性值,例如Cookie
     * @Param: [urlConnection]
     * @Return: void
     * @Author: QIU PANWEI
     * @Date: 2019/9/20 16:12
     */
    private static void setURLConnectionRequestProperty(URLConnection urlConnection) {
//        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//        for (Entry<String, List<String>> stringListEntry : headerFields.entrySet()) {
//            System.out.println(stringListEntry.getKey() + ": " + Arrays.toString(stringListEntry.getValue().toArray()));
//        }
        for (Entry<String, String> val : property.entrySet()) {
            urlConnection.setRequestProperty(val.getKey(), val.getValue());
        }
    }

    /**
     * 使用HttpURLConnection实现POST请求
     *  x-www-form-urlencoded
     * 1.实例化一个java.net.URL对象；
     * 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection;
     * 3.通过URLConnection对象的getOutputStream()方法获得输出流；
     * 4.向输出流中写数据；
     * 5.关闭资源；
     */
    public static String post(String urlStr, Map<String, String> param) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("charset", "utf-8");
        setURLConnectionRequestProperty(urlConnection);
        // urlConnection.setRequestProperty("Accept", "*/*");
        // urlConnection.setRequestProperty("Connection", "Keep-Alive");
        // urlConnection.setRequestProperty("User-Agent",
        //        "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
        try(PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(urlConnection.getOutputStream()))) {
            StringBuffer paraStr = new StringBuffer();
            for (Entry<String, String> para : param.entrySet()) {
                paraStr.append("&" + para.getKey() + "=" + para.getValue());
            }
            String para = paraStr.toString();
            if (!StringUtils.isBlank(para)) {
                log.info("post: 参数字符串 -> {}", para);
                printWriter.write(para.substring(1, para.length()));
                printWriter.flush();
            }
        }

        StringBuilder content = new StringBuilder(); // 保存的内容
        getInputContent(urlConnection, content);

        return content.toString();
    }

    /**
     * 使用HttpURLConnection实现POST请求  JSON类型参数
     *  json
     * 1.实例化一个java.net.URL对象；
     * 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection;
     * 3.通过URLConnection对象的getOutputStream()方法获得输出流；
     * 4.向输出流中写数据；
     * 5.关闭资源；
     */
    public static String postWithJsonPara(String urlStr, Map<String, Object> params) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        setURLConnectionRequestProperty(urlConnection);
        // urlConnection.setRequestProperty("Accept", "*/*");
        // urlConnection.setRequestProperty("Connection", "Keep-Alive");
        // urlConnection.setRequestProperty("User-Agent",
        //        "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
        urlConnection.setRequestProperty("charset", "utf-8");
        urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8"); // 设置文件类型
        try(PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(urlConnection.getOutputStream()))) {
            StringBuffer paraStr = new StringBuffer();
            String para = map2JsonString(params);
            if (!StringUtils.isBlank(para)) {
                log.info("post: 参数字符串 -> {}", para);
                printWriter.write(para);
                printWriter.flush();
            }
        }
        StringBuilder content = new StringBuilder(); // 保存的内容
        getInputContent(urlConnection, content);

        return content.toString();

    }

    private static String map2JsonString(Map<String, Object> params) {
        String result = JSONObject.toJSONString(params);
        return result;
    }



    public static void main(String[] args) throws Exception {
        // get("http://www.baidu.com");
        Map<String, String> para = new HashMap<>();
        para.put("mobile","17888888886");
        para.put("password","350b7f82c0e1f2acd757cdc18be09a94");
        // post("http://127.0.0.1:8081/ris/v1/user/login", para);
        // postWithJsonPara("http://127.0.0.1:8081/ris/v1/user/login", para);
    }

}
