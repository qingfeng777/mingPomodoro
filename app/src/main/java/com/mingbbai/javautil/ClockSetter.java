package com.mingbbai.javautil;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by mingbai on 17-10-8.
 */

public class ClockSetter {

    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    private static String[] times;
    private static String nowTime;
    //private static boolean tenTag=true,twentyTag=true,thirtyTag=true,fortyTag=true,oneHourTag=true,twoHourTag=true;
    private static int ringType=1;

    //根据推迟时间返回目标时间对应的时间点的hh:mm数组.并设置闹钟:context,分钟数，id
    //**有六种闹钟，需要判断设置的是哪一种，存起来。取消的时候判断是哪一个再判断是取消还是新建。
    //可以考虑传按钮的名字，换成阿拉伯数字。判断方便些。
    //可能还需要6个值去存六个闹钟的id值。******换id。
    public static String getTotalTimeSet(Context con,int delayTime,int id){
        //获取当前时间加上延迟的分钟时间，eg:600 000ms为十分钟;×60×1000
        nowTime=format.format(new Date().getTime() + delayTime*60*1000);
        times= nowTime.split(":");
        AlarmManagerUtil.setAlarm(con,1,Integer.parseInt(times[0]),Integer.parseInt(times[1]),id,0,"Wake up",ringType);
        Toast.makeText(con,"闹钟已设置",Toast.LENGTH_LONG).show();
        return  nowTime;
    }
}
