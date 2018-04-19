package com.example.onkarpande.speednet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

public class SpeedGraph extends Activity {

    private WifiManager wifiManager;
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_graph);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();

        mChart=findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(true);
        mChart.getDescription().setText("Wifi Signal Strength Chart");

        mChart.setTouchEnabled(false);
        mChart.setDragEnabled(false);
        mChart.setPinchZoom(false);
        mChart.setScaleEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.setBackgroundColor(Color.WHITE);

        LineData data=new LineData();
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (wifiManager.getDhcpInfo()!=null)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
