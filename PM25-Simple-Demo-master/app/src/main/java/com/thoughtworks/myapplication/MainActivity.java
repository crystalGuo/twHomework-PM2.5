package com.thoughtworks.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thoughtworks.myapplication.domain.PM25;
import com.thoughtworks.myapplication.service.AirServiceClient;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText cityEditText;
    private ProgressDialog loadingDialog;
    private String cityName,positionQuality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityEditText = (EditText) findViewById(R.id.edit_view_input);
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setMessage(getString(R.string.loading_message));


        findViewById(R.id.button_query_pm25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onQueryPM25Click();
//                activityJump();
            }
        });
    }

    public void queryPM25ClickByButton(View v) {
        switch (v.getId()) {
            case R.id.button_beijing:
                cityEditText.setText("beijing");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_xian:
                cityEditText.setText("xian");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_shanghai:
                cityEditText.setText("shanghai");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_chengdu:
                cityEditText.setText("chengdu");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_shenzhen:
                cityEditText.setText("shenzhen");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_nanjing:
                cityEditText.setText("nanjing");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_tianjin:
                cityEditText.setText("tianjin");
                onQueryPM25Click();
//                activityJump();
                break;
            case R.id.button_wuhan:
                cityEditText.setText("wuhan");
                onQueryPM25Click();
//                activityJump();
                break;
        }
    }

    //界面跳转函数
    public void activityJump() {
        Intent myIntent = new Intent();
        Bundle myBundle = new Bundle();
        myBundle.putString("positionName",cityName);
        myBundle.putString("positionQuality",positionQuality);
        myIntent.putExtras(myBundle);
        myIntent.setClass(MainActivity.this, ouputActivity.class);
        startActivity(myIntent);
    }
    private void onQueryPM25Click() {
        final String city = cityEditText.getText().toString();
        if (!TextUtils.isEmpty(city)) {
            showLoading();
            AirServiceClient.getInstance().requestPM25(city, new Callback<List<PM25>>() {
                @Override
                public void onResponse(Response<List<PM25>> response, Retrofit retrofit) {
                    showSuccessScreen(response);
                    activityJump();
                }

                @Override
                public void onFailure(Throwable t) {
                    showErrorScreen();
                }
            });
        }
    }

    private void showSuccessScreen(Response<List<PM25>> response) {
        hideLoading();
        if (response != null) {
            populate(response.body());
        }
    }

    private void showErrorScreen() {
        hideLoading();
//        pm25TextView.setText(R.string.error_message_query_pm25);
    }

    private void showLoading() {
        loadingDialog.show();
    }

    private void hideLoading() {
        loadingDialog.dismiss();
    }

    private void populate(List<PM25> data) {
        if (data != null && !data.isEmpty()) {
            PM25 pm25 = data.get(0);
//            pm25TextView.setText(pm25.getPositionName() + pm25.getQuality()+pm25.getPm2_5_24h());
            cityName = pm25.getArea();
            positionQuality = pm25.getQuality();
        }
    }
}
