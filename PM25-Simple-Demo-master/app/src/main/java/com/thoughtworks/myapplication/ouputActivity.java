package com.thoughtworks.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ouputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome);
        Bundle bundle = this.getIntent().getExtras();
        String positionCity =  bundle.getString("positionName");
        String positionQuality = bundle.getString("positionQuality");
        TextView city = (TextView) findViewById(R.id.text_view_city);
        TextView quality = (TextView) findViewById(R.id.text_view_qulity);
        TextView health = (TextView) findViewById(R.id.text_view_health);
        TextView advice = (TextView) findViewById(R.id.text_view_advice);
        if (positionQuality.equals("优")) {
            city.setText(positionCity);
            quality.setText(positionQuality);
            health.setText(getString(R.string.text_view_health0));
            advice.setText(getString(R.string.text_view_advice0));
        } else if (positionQuality.equals("良")) {
            city.setText(positionCity);
            quality.setText(positionQuality);
            health.setText(getString(R.string.text_view_health1));
            advice.setText(getString(R.string.text_view_advice1));
        } else if (positionQuality.equals("轻度污染")) {
            city.setText(positionCity);
            quality.setText(positionQuality);
            health.setText(getString(R.string.text_view_health2));
            advice.setText(getString(R.string.text_view_advice2));
        } else if (positionQuality.equals("中度污染")) {
            city.setText(positionCity);
            quality.setText(positionQuality);
            health.setText(getString(R.string.text_view_health3));
            advice.setText(getString(R.string.text_view_advice3));
        } else if (positionQuality.equals("重度污染")) {
            city.setText(positionCity);
            quality.setText(positionQuality);
            health.setText(getString(R.string.text_view_health4));
            advice.setText(getString(R.string.text_view_advice4));
        } else if (positionQuality.equals("严重污染")) {
            city.setText(positionCity);
            quality.setText(positionQuality);
            health.setText(getString(R.string.text_view_health5));
            advice.setText(getString(R.string.text_view_advice5));
        } else {
            Toast.makeText(getApplicationContext(),"Please try again",Toast.LENGTH_SHORT).show();
        }
    }

}
