package com.cadi.jaeyeol.newselbar2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Plank extends AppCompatActivity {
    TextView txtTime, txtTime2;
    Button btnStop;
    boolean flag = true;
    boolean flag1 = true;
    Handler handler = new Handler();
    String squart_count, temp;
    int i, plank_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plank);
        txtTime = (TextView)findViewById(R.id.mPcount);
        txtTime2 = (TextView)findViewById(R.id.guideTxt);
        btnStop = (Button)findViewById(R.id.btnStop);
        ((MainActivity)MainActivity.mContext).sendMessage("iiiii");
        i = 0;
        ready_time();
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                Intent intent = new Intent(Plank.this, Complete.class);
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
                                    txtTime2.setText("5초후 시작");
                                }
                                else if(i == 2){
                                    txtTime2.setText("4초후 시작");
                                }
                                else if(i == 3){
                                    txtTime2.setText("3초후 시작");
                                }
                                else if(i == 4){
                                    txtTime2.setText("2초후 시작");
                                }
                                else if(i == 5){
                                    txtTime2.setText("1초후 시작");
                                }
                                else if(i == 6) {
                                    txtTime2.setText("운동중");
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
                plank_time = 0;
                ((MainActivity)MainActivity.mContext).sendMessage("iiiii");
                while(flag) {
                    try {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                plank_time += 1;
                                txtTime.setText(""+plank_time);
                                if (plank_time >= 10)
                                {
                                    btnStop.setVisibility(View.VISIBLE);
                                    txtTime2.setText("운동완료");
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

}
