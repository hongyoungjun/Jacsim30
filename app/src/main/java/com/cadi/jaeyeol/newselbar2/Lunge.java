package com.cadi.jaeyeol.newselbar2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lunge extends AppCompatActivity {
    TextView txtTime, txtTime1;
    int i;
    Button btnStop;
    boolean flag = true;
    boolean flag1  = true;
    Handler handler = new Handler();
    String lunge_count;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunge);
        txtTime = (TextView)findViewById(R.id.mLcount);
        txtTime1 = (TextView)findViewById(R.id.guideTxt);
        btnStop = (Button)findViewById(R.id.btnStop);
        ((MainActivity)MainActivity.mContext).sendMessage("iiiii");
        i = 0;
        ready_time();
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                Intent intent = new Intent(Lunge.this, Plank.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void ready_time(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                flag1 = true;
                while(flag1) {
                    try {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                i += 1;
                                if(i == 1){
                                    txtTime1.setText("5초후 시작");
                                }
                                else if(i == 2){
                                    txtTime1.setText("4초후 시작");
                                }
                                else if(i == 3){
                                    txtTime1.setText("3초후 시작");
                                }
                                else if(i == 4){
                                    txtTime1.setText("2초후 시작");
                                }
                                else if(i == 5){
                                    txtTime1.setText("1초후 시작");
                                }
                                else if(i == 6) {
                                    txtTime1.setText("운동중");
                                    start_squart();
                                    flag1 = false;
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }
    public void start_squart() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                flag = true;
                ((MainActivity)MainActivity.mContext).sendMessage("iiiii");
                while(flag) {
                    try {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                temp = MainActivity.Counter;
                                lunge_count = temp.substring(1,4);
                                txtTime.setText(lunge_count);
                                double i = Double.valueOf(lunge_count).doubleValue();
                                if (i >= 5)
                                {
                                    btnStop.setVisibility(View.VISIBLE);
                                    txtTime1.setText("운동완료");
                                }
                            }
                        });
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

}
