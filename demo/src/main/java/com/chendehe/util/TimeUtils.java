package com.chendehe.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public final class TimeUtils {

  private TimeUtils() {
  }

  public static final String DEFAULT_TYPE = "yyyy-MM-dd";
  public static final String TYPE_01 = "yyyy-MM-dd HH:mm:ss";

  /**
   * 获取当前时间字符串（日期＋时间）.
   * 返回时间格式是：yyyy-MM-dd HH:mm:ss.
   *
   * @return String
   */
  public static String getCurrentDate() {
    return getDate(new Date());
  }

  /**
   * 获取当前时间指定格式字符串（日期＋时间）.
   * 返回时间格式是：yyyy-MM-dd HH:mm:ss.
   *
   * @return String
   */
  public static String getCurrentDate(String format) {
    return getDate(new Date(), format);
  }

  /**
   * 获取指定时间字符串（日期＋时间）.
   * 返回时间格式是：yyyy-MM-dd HH:mm:ss.
   *
   * @return String
   */
  public static String getDate(Date date) {
    return new SimpleDateFormat(DEFAULT_TYPE).format(date);
  }

  /**
   * 获取指定时间和格式字符串.
   *
   * @return String
   */
  public static String getDate(Date date, String format) {
    return new SimpleDateFormat(format).format(date);
  }

  public static void main(String[] args) {
    test();
  }

  private static void test() {
    System.out.println(LocalDate.now());
    System.out.println(LocalTime.now());
    System.out.println(LocalDateTime.now());
    System.out.println(Instant.now());
    System.out.println(Duration.ofSeconds(3));
    System.out.println(Period.ofDays(3));
    System.out.println(LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
    String strDate = LocalDateTime.now().format(dtf);
    System.out.println(strDate);
    LocalDateTime newLdt = LocalDateTime.parse(strDate, dtf);
    System.out.println(newLdt);

    System.out.println(LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
    System.out.println(ZonedDateTime.now(ZoneId.of("US/Pacific")));

    Date date = Date.from(Instant.now());
    ZoneId defaultZoneId = ZoneId.systemDefault();
    // Date to LocalDate
    LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();
    System.out.println(localDate);
    // LocalDate to Date
    Date from = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    System.out.println(from);

    // Date to LocalDateTime
    LocalDateTime localDateTime = date.toInstant().atZone(defaultZoneId).toLocalDateTime();
    System.out.println(localDateTime);
    // LocalDateTime to Date
    Date out = Date.from(localDateTime.atZone(defaultZoneId).toInstant());
    System.out.println(out);
  }
}
