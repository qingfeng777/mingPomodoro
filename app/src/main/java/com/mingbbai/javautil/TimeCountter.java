package com.mingbbai.javautil;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.mingbai.mingpomodoro.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by mingbai on 17-10-8.
 */

public class TimeCountter extends CountDownTimer {
    private CircleProgressBar progressBar;
    private TextView textView;
    private Context con;


    public TimeCountter(long millisInFuture, long countDownInterval, Context con, CircleProgressBar progressBar, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.progressBar=progressBar;
        this.textView=textView;
        this.con=con;
    }

    @Override
    public void onTick(long remainMillis) {
        //更新界面时间段
        String string = new SimpleDateFormat("mm:ss").format(new Date(
                remainMillis));
        textView.setText(string);
        progressBar
                .setProgressNotInUiThread((int) (remainMillis / 1000));

    }

    @Override
    public void onFinish() {
        //结束时提示，再创建一个，让主函数去建吧。
        MainActivity.getMainActivity().setPomodoro();
        //放个短音乐。
        Singer.playMusic(con);
    }
}
