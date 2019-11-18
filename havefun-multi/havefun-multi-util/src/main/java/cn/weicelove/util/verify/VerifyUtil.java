package cn.weicelove.util.verify;

import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/11/7 14:11
 */
public class VerifyUtil {

    private static final String REGEX_EMAIL = "^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\\.)+(com|cn|net|org)$";

    public static void main(String[] args) {
        System.out.println(beEmail("6.1@qq.com"));
        System.out.println(beEmail("6@qq.com.cn"));
        System.out.println(beEmail("1_-@qq.com"));
    }

    public static boolean beEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        return Pattern.matches(REGEX_EMAIL, email);
    }
}
