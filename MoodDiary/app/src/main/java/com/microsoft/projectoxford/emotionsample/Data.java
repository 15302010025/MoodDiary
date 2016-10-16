package com.microsoft.projectoxford.emotionsample;

import android.app.Activity;
import android.content.Context;

import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.util.EncodingUtils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yangsen on 16-10-16.
 */
public class Data extends Activity{
    private String[] des = {"angrt", "contempt", "disgust", "fear", "happiness", "neutral","sadness","surprise"};
    private String[] date = new String[365];
    private int[] time = new int[365];
    private double[][] emotion = new double[8][365];
    /*private double[] angry = new double[365];
    private double[] contempt = new double[365];
    private double[] disgust = new double[365];
    private double[] fear = new double[365];
    private double[] happiness = new double[365];
    private double[] neutral = new double[365];
    private double[] sadness = new double[365];
    private double[] surprise = new double[365];
    */
    public Data(){

        try {
            int i = 0;
            FileInputStream fis;
            fis = openFileInput("output.txt");
            DataInputStream dataIO = new DataInputStream(fis);//读取文件数据流
            String strLine = null;
            while((strLine =  dataIO.readLine()) != null) {//通过readline按行读取
                if (strLine.equals(date[i])){
                    for (int j = 0; j < 8; j++){
                        strLine =  dataIO.readLine();
                        emotion[j][i] = ((emotion[j][i] * time[i]) + Double.parseDouble(strLine)) / (i + 1);
                    }
                    time[i]++;
                }
                else {
                    i++;
                    date[i] = strLine;
                    for (int j = 0; j < 8; j++){
                        strLine =  dataIO.readLine();
                        emotion[j][i] = Double.parseDouble(strLine);
                    }

                }
            }
            dataIO.close();
            fis.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public double[] getWeekData(int day, int type){
        double[] week;
        week = getSeven(emotion[type], day);
        return week;
    }

    public double[] getSeven(double[] array, int begin){
        double[] ret = new double[7];
        for (int i = 0; i < 7; i++){
            if (begin + i < array.length){
                ret[i] = array[i + begin];
            }
        }
        return ret;
    }

    public String[] getDes(){
        return des;
    }

    public double getDay(int type, int day){
        return emotion[type][day];
    }

}

