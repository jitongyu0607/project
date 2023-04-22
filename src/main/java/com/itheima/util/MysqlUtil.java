package com.itheima.util;

import com.itheima.pojo.Emp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MysqlUtil {


    /**
     * 寫一個工具欄，直接設置當前日期
     */
    public static void setUpdateDate(Emp emp){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String detetime = simpleDateFormat.format(date);
        emp.setUpdatedate(detetime);
    }


    public static void setJoinDate(Emp emp){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String detetime = simpleDateFormat.format(date);
        emp.setJoindate(detetime);
    }
}
