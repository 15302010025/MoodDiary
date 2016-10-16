package com.microsoft.projectoxford.emotionsample;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.microsoft.projectoxford.emotionsample.R;

/**
 * Created by lenovo1 on 2016/10/15.
 */
public class PictureActivity extends Activity{
    private TextView date;
    private Button mood;
    private LinearLayout home;
    private LinearLayout analysis;
    private LinearLayout picture;

    @Override
    public void onCreate(Bundle saveInsanceState){
        super.onCreate(saveInsanceState);
        setContentView(R.layout.picture);

        date = (TextView) findViewById(R.id.textView2);
       // mood = (Button) findViewById(R.id.roundBtn);

        home = (LinearLayout)

                findViewById(R.id.id_tab_home);

        analysis = (LinearLayout)

                findViewById(R.id.id_tab_analysis);

        picture = (LinearLayout) findViewById(R.id.id_tab_picture);




        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(PictureActivity.this, HomeActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(PictureActivity.this,AnalysisActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
    picture.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            //设置Intent的class属性，跳转到SecondActivity
            intent.setClass(PictureActivity.this, PictureActivity.class);
            //启动Activity
            startActivity(intent);
        }
    });
    }




}
