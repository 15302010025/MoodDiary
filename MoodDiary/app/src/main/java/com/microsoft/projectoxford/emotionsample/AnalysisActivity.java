package com.microsoft.projectoxford.emotionsample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.microsoft.projectoxford.emotionsample.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by lenovo1 on 2016/10/15.
 */
public class AnalysisActivity extends Activity {
    private Button year;
    private Button month;
    private Button day;
    private LineChart mLineChart;
    private Data data = new Data();


    private LinearLayout home;
    private LinearLayout analysis;
    private LinearLayout picture;
    //private LinearLayou


    @Override
    public void onCreate(Bundle saveInsanceState) {
        super.onCreate(saveInsanceState);
        setContentView(R.layout.analysis);

        year = (Button) findViewById(R.id.month);
        month = (Button) findViewById(R.id.week);
        day = (Button) findViewById(R.id.day);

        home = (LinearLayout)findViewById(R.id.id_tab_home);

        analysis = (LinearLayout)findViewById(R.id.id_tab_analysis);

        picture = (LinearLayout) findViewById(R.id.id_tab_picture);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(AnalysisActivity.this, HomeActivity.class);
                //启动Activity
                startActivity(intent);
            }
        }

        );
        analysis.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(AnalysisActivity.this, AnalysisActivity.class);
                //启动Activity
                startActivity(intent);
            }
        }

        );

        picture.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的class属性，跳转到SecondActivity
                intent.setClass(AnalysisActivity.this, PictureActivity.class);
                //启动Activity
                startActivity(intent);
            }
        }

        );
        mLineChart = (LineChart) findViewById(R.id.lineChart);

        XAxis xAxis = mLineChart.getXAxis();

        //设置X轴的文字在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //设置描述文字
        mLineChart.setDescription("一日心情变化");

        //模拟一个x轴的数据  12/1 12/2 ... 12/7
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            xValues.add(data.getDes()[i]);
        }

        //Log.e("wing", xValues.size() + "");



        //模拟一组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一

        ArrayList<Entry> yValue = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            yValue.add(new Entry((float)data.getDay(i, 0), i));
        }


        //构建一个LineDataSet 代表一组Y轴数据 （比如不同的彩票： 七星彩  双色球）
        /*LineDataSet[] dataSet = {new LineDataSet(yValue, "愤怒"), new LineDataSet(yValue, "鄙视")
        ,new LineDataSet(yValue, "厌恶"), new LineDataSet(yValue, "害怕"),new LineDataSet(yValue, "喜悦"),new LineDataSet(yValue, "中性"),
        new LineDataSet(yValue, "悲伤"), new LineDataSet(yValue, "惊喜")};
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一*/




        //构建一个LineDataSet 代表一组Y轴数据 （比如不同的彩票： 七星彩  双色球）

        LineDataSet dataSet = new LineDataSet(yValue, "日心情");
        dataSet.setColor(Color.RED);
        //构建一个类型为LineDataSet的ArrayList 用来存放所有 y的LineDataSet   他是构建最终加入LineChart数据集所需要的参数
        ArrayList<LineDataSet> dataSets = new ArrayList<>();

        //将数据加入dataSets
        dataSets.add(dataSet);


        //构建一个LineData  将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);

        //将数据插入
        mLineChart.setData(lineData);


    }


}


