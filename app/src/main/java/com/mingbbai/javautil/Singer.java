package com.mingbbai.javautil;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.mingbai.mingpomodoro.R;

/**
 * Created by mingbai on 17-10-9.
 */

public class Singer {
    //当前系统的SDK版本大于等于21(Android 5.0)时
    private static SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

    public static void playMusic(Context con){
        int soundID1 = soundPool.load(con, R.raw.spring, 1);
        if(soundID1==1){
            //判断错误
        }
        soundPool.play(soundID1,1,1,0,0,1);
    }

}


