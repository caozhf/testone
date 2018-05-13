package com.caozhf.mulpagestudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.caozhf.mulpagestudy.presenter.IVP;
import com.caozhf.mulpagestudy.presenter.VIewPresenter;
import com.caozhf.mulpagestudy.utils.Constants;

public class MainActivity extends AppCompatActivity implements IVP{

    private VIewPresenter presenter = new VIewPresenter(MainActivity.this);

    private TextView textdata;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.viewGetData(Constants.Data);
            }
        });
    }

    private void initView() {
        textdata = (TextView) findViewById(R.id.textdata);
        but = (Button) findViewById(R.id.but);
    }

    @Override
    public void GetRequestData(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textdata.setText(string);
            }
        });
    }

    @Override
    public void FailureGetData(String message) {

    }
}
