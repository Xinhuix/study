import org.junit.Test;

import java.lang.reflect.Method;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @ClassName JKD8TimeAPI
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月10日 12:54
 **/
public class JKD8TimeAPI {

    /** DateTimeFormatter*/
    @Test
    public void Test7( ){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();

        String format = now.format(isoDateTime);
        System.out.println(format);
        //指定日期转换格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        //转换字符串
        String dateTimeForamt = now.format(dateTimeFormatter);
        System.out.println(dateTimeForamt);
        //将字符串日期转换回时间
        LocalDateTime parse = now.parse(dateTimeForamt, dateTimeFormatter);
        System.out.println(parse);
    }

    /**
     * 1.LocalData LocalTime LocalDateTime
     */

    @Test
    public void Test1( ){
        /** 获取当前时间 */
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        /** 获取指定时间 */
        LocalDateTime of = LocalDateTime.of(2015, 11, 1, 13, 56);
        System.out.println(of);

        /** 当前时间加2年 */
        LocalDateTime plusYears = now.plusYears(2);
        System.out.println(plusYears);

        /** 当前时间减2月 */
        LocalDateTime minusMonths = now.minusMonths(2);
        System.out.println(minusMonths);
    }

    /**
     * 2.Duration:计算两个时间之间的间隔
     *  Period: 计算两个日期之间的间隔
     */
    @Test
    public void Test2( ){
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime plusDays = LocalDateTime.now().plusYears(2).plusDays(2);
        Duration between = Duration.between(now, plusDays);
        System.out.println(between.toHours());

        LocalDate localDate = LocalDate.now();

        LocalDate of = LocalDate.of(2015, 1, 1);

        Period between1 = Period.between(localDate, of);
        System.out.println(between1.getYears());
    }

    /** TemporalAdjuster 时间较正器*/
    @Test
    public void Test4( ){
        LocalDateTime now = LocalDateTime.now();
        //将时间的天数指定为任意天(1-31)
        LocalDateTime localDateTime = now.withDayOfMonth(11);
        System.out.println(localDateTime);

        //获取第当前年的第一天
        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfYear());
        System.out.println(with);

    }
    /** ZonedDate ZonedTime ZonedDateTime*/
    @Test
    public void Test9( ){
        //获取当前地区时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        //获取全部地区标识
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        //availableZoneIds.forEach(System.out::println);

        //获取指定地区时间
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Australia/Queensland"));
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = now1.format(pattern);
        System.out.println(format);

    }

    @Test
    public void Test91( ) throws NoSuchMethodException {
        Class<JKD8TimeAPI> apiClass = JKD8TimeAPI.class;

        Method test9 = apiClass.getMethod("test9");

        Test[] annotationsByType = test9.getAnnotationsByType(Test.class);
        for (Test test : annotationsByType) {
            System.out.println(test);
        }

    }
}
