package cn.weicelove.util.http;

import cn.weicelove.util.constant.ConstantUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.Charsets;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/9/20 10:42
 */
public class HttpClientUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
    //httpClient单例
    private static CloseableHttpClient httpClient;
    private static RequestConfig       requestConfig;

    //连接池
    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(ConstantUtil.HttpConnection.Max_Connection_In_Pool);
        cm.setDefaultMaxPerRoute(ConstantUtil.HttpConnection.Max_Connection_Per_Route);

        httpClient = HttpClients.custom().setConnectionManager(cm).build();

        requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(ConstantUtil.HttpConnection.TimeOut)
            .setConnectTimeout(ConstantUtil.HttpConnection.TimeOut)
            .setSocketTimeout(ConstantUtil.HttpConnection.TimeOut).build();
    }

    /**
     * POST连接,默认application/x-www-form-urlencoded提交
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        setPostParams(httpPost, params);
        return doPost(httpPost);
    }

    /**
     * POST提交，以application/json方式请求
     * @param url
     * @param jsonParams json字符串参数
     * @return
     * @throws IOException
     */
    public static String postByJson(String url, String jsonParams) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        StringEntity entity = new StringEntity(jsonParams, Charsets.UTF_8);
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json;charset=utf-8");
        httpPost.setEntity(entity);
        return doPost(httpPost);
    }

    /**
     * GET连接
     * @param url
     * @return
     */
    public static String get(String url) {
        HttpGet httpget = new HttpGet(url);
        httpget.setConfig(requestConfig);
        return doGet(httpget);
    }

    public static String getAddHeader(String url, Header header) {
        HttpGet httpget = new HttpGet(url);
        httpget.setConfig(requestConfig);
        httpget.addHeader(header);
        return doGet(httpget);
    }

    private static String doGet(HttpGet httpget) {
        try (CloseableHttpResponse response = httpClient.execute(httpget, HttpClientContext.create())) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, Charsets.UTF_8);
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String doPost(HttpPost httpPost) {
        try (CloseableHttpResponse response = httpClient.execute(httpPost, HttpClientContext.create())) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, Charsets.UTF_8);
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置连接参数
     * @param httpost
     * @param params
     */
    private static void setPostParams(HttpPost httpost, Map<String, Object> params) {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("timeStamp",
            String.valueOf(System.currentTimeMillis() / 1000)));
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
        }
        httpost.setEntity(new UrlEncodedFormEntity(nvps, Charsets.UTF_8));
    }

    public static void main(String[] args) throws Exception {
        // get("http://www.baidu.com");
        Map<String, Object> para = new HashMap<>();
        para.put("mobile","17888888886");
        para.put("password","350b7f82c0e1f2acd757cdc18be09a94");
        // post("http://127.0.0.1:8081/ris/v1/user/login", para);
        postByJson("http://127.0.0.1:8081/ris/v1/user/login", JSONObject.toJSONString(para));
        // postWithJsonPara("http://127.0.0.1:8081/ris/v1/user/login", para);
    }
}