package com.mingbai.mingpomodoro;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mingbbai.javautil.AlarmManagerUtil;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView remainTime;
    private Button tenBtn,twentyBtn,thrityBtn,fortyBtn,oneHourBtn,twoHourBtn;
    private Button setBtn,resetBtn;
    private Button startBtn,stopBtn;
    private int ringType;
    private String nowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://blog.csdn.net/zl18603543572/article/details/51250216
        //http://blog.csdn.net/liujiaoruiit/article/details/48517167

        remainTime=(TextView) findViewById(R.id.textView);
        startBtn=(Button)findViewById(R.id.startButton);
        startBtn.setOnClickListener(this);
        stopBtn=(Button)findViewById(R.id.stopButton);
        stopBtn.setOnClickListener(this);
        setBtn=(Button)findViewById(R.id.setButton);
        resetBtn=(Button)findViewById(R.id.resetTimeBtn);
        resetBtn.setOnClickListener(this);
        tenBtn=(Button)findViewById(R.id.tenButton);
        tenBtn.setOnClickListener(this);
        twentyBtn=(Button)findViewById(R.id.twentyButton);
        twentyBtn.setOnClickListener(this);
        thrityBtn=(Button)findViewById(R.id.thirtyButton);
        thrityBtn.setOnClickListener(this);
        fortyBtn=(Button)findViewById(R.id.fortyButton);
        fortyBtn.setOnClickListener(this);
        oneHourBtn=(Button)findViewById(R.id.oneHourButton);
        oneHourBtn.setOnClickListener(this);
        twoHourBtn=(Button)findViewById(R.id.twoHourButton);
        twoHourBtn.setOnClickListener(this);
    }

    @Override
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.startButton:

                break;
            case R.id.stopButton:

                break;
            case R.id.resetTimeBtn:

                break;
            case R.id.tenButton:

                break;
            case R.id.twentyButton:

                break;
            case R.id.thirtyButton:

                break;
            case R.id.fortyButton:

                break;
            case R.id.oneHourButton:

                break;
            case R.id.twoHourButton:

                break;
            default:

                break;
        }
    }

    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    String[] times;
    //根据推迟时间返回目标时间对应的时间点的hh:mm数组.并设置闹钟
    public String[] getTotalTimeSet(int delayTime){
        nowTime=format.format(new Date());
        //给时间做个加法。
        times= nowTime.split(":");
        AlarmManagerUtil.setAlarm(this,);


    }
}
