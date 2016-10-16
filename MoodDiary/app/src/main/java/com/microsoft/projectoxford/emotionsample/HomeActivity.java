package com.microsoft.projectoxford.emotionsample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.microsoft.projectoxford.emotionsample.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by lenovo1 on 2016/10/15.
 */

public class HomeActivity extends Activity {

    private LinearLayout home;
    private LinearLayout analysis;
    private LinearLayout picture;
    private LinearLayout getPhoto;

    private ImageButton button;

    @Override
    public void onCreate(Bundle saveInsanceState) {
        super.onCreate(saveInsanceState);
        setContentView(R.layout.home);

        home = (LinearLayout) findViewById(R.id.id_tab_home);
        analysis = (LinearLayout) findViewById(R.id.id_tab_analysis);
        picture = (LinearLayout) findViewById(R.id.id_tab_picture);
        button = (ImageButton)findViewById(R.id.takePhoto);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(HomeActivity.this, HomeActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });

        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(HomeActivity.this, AnalysisActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(HomeActivity.this, PictureActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(HomeActivity.this, RecognizeActivity.class);
                startActivity(intent);
            }
        });


    }

}


