package cn.weicelove.util.constant;

public interface ConstantUtil {

    interface HttpConnection {
        /** 连接池最大连接数 */
        int Max_Connection_In_Pool   = 200;
        /** 默认的每个路由的最大连接数*/
        int Max_Connection_Per_Route = 20;
        /** 超时设置*/
        int TimeOut                  = 5000;
    }

}
