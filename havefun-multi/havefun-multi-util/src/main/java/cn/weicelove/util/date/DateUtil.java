package cn.weicelove.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author QIU PANWEI Create in 2019/11/26 13:59
 */
public class DateUtil {

    public static final DateTimeFormatter DATE_FORMAT_1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日", Locale.CHINA);
    public static final DateTimeFormatter DATE_FORMAT_2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm", Locale.CHINA);
    public static final DateTimeFormatter DATE_FORMAT_3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm", Locale.CHINA);
    public static final DateTimeFormatter DATE_FORMAT_4 = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.CHINA);
    public static final DateTimeFormatter DATE_FORMAT_5 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
    /** 日期格式：yyyy-MM-dd HH:mm:ss.SSS*/
    public static final DateTimeFormatter DATE_FORMAT_6  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS",
            Locale.CHINA);

    public static final DateTimeFormatter[] FORMATTERS = {DATE_FORMAT_1, DATE_FORMAT_2, DATE_FORMAT_3, DATE_FORMAT_4, DATE_FORMAT_5,DATE_FORMAT_6};
    private static DateTimeFormatter FormatTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    /**
     * date转localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * localDateTime转date
     * @param localDateTime
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前时间的秒数
     * @param date 日期
     * @return long 返回秒数
     * @author QIU PANWEI
     */
    public static long dateToSecond(Date date) {
        return date == null ? 0 : date.getTime() / 1000;
    }

    /**
     * 对日期进行格式化并输出"yyyy-MM-dd HH:mm:ss"格式字符串
     * @param date
     * @return date string
     */
    public static String getNewFormatDateString(Date date) {
        return getDateString(date, FormatTimeStamp);
    }

    /**
     * 以特定格式对某日期进行格式化，并以String形式返回
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDateString(Date date, DateTimeFormatter dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }
        return dateFormat.format(date2LocalDateTime(date));
    }

    /**
     * 以特定格式对某日期进行格式化，并以String形式返回
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDateString(Date date, DateFormat dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }

        return dateFormat.format(date);
    }

    public static String formatDate(Date date) {
        return DATE_FORMAT_1.format(date2LocalDateTime(date));
    }
    public static String formatDateTime(Date date) {
        return DATE_FORMAT_2.format(date2LocalDateTime(date));
    }
    public static String formatDownloadDateTime(Date date) {
        return DATE_FORMAT_3.format(date2LocalDateTime(date));
    }
//    public static String formatDatePlus100Year(Date date) {
//        GregorianCalendar gc =new GregorianCalendar(Locale.CHINA);
//        gc.setTime(date);
//        gc.add(Calendar.YEAR, 100); //add 100 years
//        return DATE_FORMAT_1.format(date2LocalDateTime(gc.getTime()));
//    }
//    public static String formatTimePlus100Year(Date date) {
//        GregorianCalendar gc =new GregorianCalendar(Locale.CHINA);
//        gc.setTime(date);
//        gc.add(Calendar.YEAR, 100); //add 100 years
//        return DATE_FORMAT_2.format(date2LocalDateTime(gc.getTime()));
//    }
//    public static GregorianCalendar parseFromDatePlus100Year(String dateStr){
//        try {
//            Date date=  localDateTime2Date(LocalDateTime.parse(dateStr, DATE_FORMAT_1));
//            GregorianCalendar gc =new GregorianCalendar(Locale.CHINA);
//            gc.setTime(date);
//            gc.add(Calendar.YEAR, -100); //add -100 years
//            return gc;
//        } catch (Exception e) {
//            return null;
//        }
//    }


    /**
     *
     * 获取明天的日期
     * @param date 当前日期
     * @return java.util.Date 明天的日期
     * @author QIU PANWEI
     */
    public static Date getNextDay(Date date) {
        GregorianCalendar gc = new GregorianCalendar(Locale.CHINA);
        gc.setTime(date);
        gc.add(Calendar.DATE, 1);
        return gc.getTime();
    }

    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, FORMATTERS);
    }

    public static Date parseDate(String dateStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        SimpleDateFormat[] formatters = {formatter};
        return parseDate(dateStr, formatters);
    }

    public static Date parseDate(String dateStr, SimpleDateFormat formatter) {
        SimpleDateFormat[] formatters = {formatter};
        return parseDate(dateStr, formatters);
    }

    public static Date parseDate(String dateStr, DateTimeFormatter[] formatters) {
        Date returnDate = null;
        if((dateStr != null) && (dateStr.length() > 0)) {
            for (int i = 0; i < formatters.length; i++) {
                DateTimeFormatter formatter = formatters[i];
                try {
                    returnDate = localDateTime2Date(LocalDateTime.parse(dateStr, formatter));
                    break;
                }
                catch (Exception e) {
                    // try the next format
                    returnDate = null;
                }
                try {
                    // 只有日期没有时间的字符串解析
                    LocalDate ld = LocalDate.parse(dateStr, formatter);
                    returnDate = localDateTime2Date(ld.atStartOfDay());
                    break;
                }
                catch (Exception e) {
                    // try the next format
                    returnDate = null;
                }
            }
        }
        return returnDate;
    }

    public static Date parseDate(String dateStr, SimpleDateFormat[] formatters) {
        Date returnDate = null;
        if((dateStr != null) && (dateStr.length() > 0)) {
            for (int i = 0; i < formatters.length; i++) {
                try {
                    SimpleDateFormat formatter = formatters[i];
                    formatter.setLenient(false);
                    returnDate = formatter.parse(dateStr);
                    break;
                }
                catch (ParseException e) {
                    // try the next format
                    returnDate = null;
                }
            }
        }

        return returnDate;
    }
}
