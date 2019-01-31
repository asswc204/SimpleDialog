package com.chiu.zfz.simpledialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chiu.dialoglibrary.SimpleTipDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTipsdialog(View view) {
        new SimpleTipDialog(this).setTitle("提示").setMsg("内容内容").show();
    }

}
