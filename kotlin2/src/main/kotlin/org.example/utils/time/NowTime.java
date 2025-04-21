package org.example.utils.time;

import java.time.Instant;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NowTime {

    public static void main(String[] args) {
        instantToString();
    }

    // Instant
    public static String instantToString() {
        Instant instant = Instant.now();
        instant.toString();
        String instantStr = instant.toString();
        System.out.println("instantStr : "+instantStr); // 2025-04-18T02:28:55.084660800Z
        return instantStr;
    }

    public void date() {

        /*-------------------- java 8 이전 --------------------*/
        java.util.Date date = new java.util.Date();
        java.util.Calendar calendar; //추상클래스로 초기화 불가

        date(); //Thu Aug 25 18:30:01 KST 2022
        date.getDate(); //25

        // dateFormat 공식 문서 : https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일"); //java7이하에서는 yyyy
        String now = dateFormat.format(date); //2022년 08월 25일

        dateFormat = new SimpleDateFormat("오늘은 E요일 입니다."); //영어는 불가능
        dateFormat.format(date); //오늘은 목요일 입니다.

        /*-------------------- java 8 이후 --------------------*/
        // java.time.LocalDateTime : https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
        // java.time.format.DateTimeFormatter : https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

        java.time.LocalDate localDate; //yyyy.MM.dd
        java.time.LocalTime localTime; //HH.mm.ss
        LocalDateTime localDateTime = LocalDateTime.now(); //yyyy.MM.dd HH.mm.ss.SSS
        DateTimeFormatter formatter;

        // LocalDateTime > String
//        LocalDateTime localDt = LocalDateTime.now(); //2022-08-25T18:25:26.834
//        formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        String formedDt = localDt.format(formatter); //20220825182526
        String formedDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")); //20220825182526


        // String > LocalDateTime
        formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String dateTime = "2017년 05월 23일 11시 23분 32초";
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime, formatter); //2017-05-23T11:23:32

        // 날짜연산 : 1시간 뒤 구하기
        LocalDateTime after1hr = localDateTime.plusHours(1);

        // 날짜비교
        LocalDateTime A = LocalDateTime.now();
        LocalDateTime B = A.plusHours(1);
        A.isBefore(B); //A가 B보다 이전인가? TRUE
        A.isAfter(B); //A가 B보다 이후인가? FALSE

    }
}
