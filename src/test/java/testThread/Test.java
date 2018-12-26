package testThread;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        System.out.println("a".charAt(0)+"="+(int)"a".charAt(0));
        System.out.println(new Date(2035,1,1).getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2035,1,1);
        long millis = calendar.getTimeInMillis();
        System.out.println(millis);

       /* String  str = "Problem started at 14:19:44 on 2018.12.07\r\nProblem name: 测试-网卡传输速率\r\nHost: 172.16.11.205\r\nSeverity: Warning\r\nOriginal problem ID: 8888\r\n\r\nnet.if.out[em1]:4.12 Kbps\r\n*UNKNOWN*:*UNKNOWN*\r\n*UNKNOWN*:*UNKNOWN*\r\n*UNKNOWN*:*UNKNOWN*";

        String[] ss = str.split( "\r" );
        Arrays.stream(ss).forEach(s ->System.out.println(s));*/

        int a = 0;
        a = 2/3;
        System.out.println(a);
        System.out.println(new BigDecimal(0.000045d));
    }


}