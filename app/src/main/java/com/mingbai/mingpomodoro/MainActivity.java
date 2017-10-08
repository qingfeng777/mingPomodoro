package com.mingbai.mingpomodoro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mingbbai.javautil.CircleProgressBar;
import com.mingbbai.javautil.ClockSetter;
import com.mingbbai.javautil.TimeCountter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView remainTime,txtView;
    private Button tenBtn,twentyBtn,thrityBtn,fortyBtn,oneHourBtn,twoHourBtn;
    private Button setBtn,resetBtn;
    private Button startBtn,stopBtn;
    private String nowTime;
    public CircleProgressBar progressBar;
    private TimeCountter timeCountter;
    //让其他activity可调用此处方法。
    private static MainActivity mainActivity;

    public MainActivity(){
        mainActivity=this;
    }

    public static MainActivity getMainActivity(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://blog.csdn.net/zl18603543572/article/details/51250216
        //http://blog.csdn.net/liujiaoruiit/article/details/48517167

       // remainTime=(TextView) findViewById(R.id.textView);
        txtView=(TextView)findViewById(R.id.txtView);
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
        progressBar=(CircleProgressBar)findViewById(R.id.circleProgressbar);
        progressBar.setMaxProgress(60);
        progressBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.circleProgressbar:
                setPomodoro();
                break;
            case R.id.startButton:
                setPomodoro();
                break;
            case R.id.stopButton:
                timeCountter.cancel();
                break;
            case R.id.resetTimeBtn:

                break;
            case R.id.tenButton:
                tenBtn.setText(ClockSetter.getTotalTimeSet(this,10,1));
                break;
            case R.id.twentyButton:
                twentyBtn.setText(ClockSetter.getTotalTimeSet(this,20,2));
                break;
            case R.id.thirtyButton:
                thrityBtn.setText(ClockSetter.getTotalTimeSet(this,30,3));
                break;
            case R.id.fortyButton:
                fortyBtn.setText(ClockSetter.getTotalTimeSet(this,40,4));
                break;
            case R.id.oneHourButton:
                oneHourBtn.setText(ClockSetter.getTotalTimeSet(this,60,5));
                break;
            case R.id.twoHourButton:
                twoHourBtn.setText(ClockSetter.getTotalTimeSet(this,120,6));
                break;
            default:

                break;
        }
    }

    //判断番茄的状态
    private boolean circleTag=true;
    public void setPomodoro(){
        //http://blog.csdn.net/fu222cs98/article/details/21053491
        //25*60*100 or 5
        //这里25开始下，工具类里边结束处进行控制。
        //这几个可以设置的东西，后边可以考虑换成一个静态参数类。
        if(circleTag) {
            timeCountter = new TimeCountter(25 * 60 * 1000, 1000,this, progressBar, txtView);
            circleTag=false;
        }else {
            timeCountter = new TimeCountter(5 * 60 * 1000, 1000,this, progressBar, txtView);
            circleTag=true;
        }
        timeCountter.start();
    }

    //返回键进入后台
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

}
