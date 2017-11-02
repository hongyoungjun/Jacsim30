package com.cadi.jaeyeol.newselbar2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;


public class Calender extends Activity {


    GridView gridView;
    private PackageManager pm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        pm = getPackageManager();

        Button btnStart = (Button) findViewById(R.id.btnstart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calender.this, usage.class);
                startActivity(intent);
            }
        });

        gridView = (GridView) findViewById(R.id.mGridView);
        gridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        private Integer[] images = {R.drawable.celender_day_check_01,
                R.drawable.celender_day_check_02, R.drawable.celender_day_check_03,
                R.drawable.celender_day_check_04, R.drawable.celender_day_check_05,
                R.drawable.celender_day_check_06, R.drawable.celender_day_check_07,
                R.drawable.celender_day_check_08, R.drawable.celender_day_check_09,
                R.drawable.celender_day_check_10, R.drawable.celender_day_check_11,
                R.drawable.celender_day_check_12, R.drawable.celender_day_check_13,
                R.drawable.celender_day_check_14, R.drawable.celender_day_check_15,
                R.drawable.celender_day_today_16, R.drawable.celender_day_nomal_17,
                R.drawable.celender_day_nomal_18, R.drawable.celender_day_nomal_19,
                R.drawable.celender_day_nomal_20, R.drawable.celender_day_nomal_21,
                R.drawable.celender_day_nomal_22, R.drawable.celender_day_nomal_23,
                R.drawable.celender_day_nomal_24, R.drawable.celender_day_nomal_25,
                R.drawable.celender_day_nomal_26, R.drawable.celender_day_nomal_27,
                R.drawable.celender_day_nomal_28, R.drawable.celender_day_nomal_29,
                R.drawable.celender_day_nomal_30
        };

        public ImageAdapter(Context con) {
            this.context = con;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;

            if (view == null) {
                Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), images[i]);
                bmp = Bitmap.createScaledBitmap(bmp, 320, 240, false);

                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(160, 160));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) view;
            }
            imageView.setImageResource(images[i]);
            return imageView;
        }
    }
}

