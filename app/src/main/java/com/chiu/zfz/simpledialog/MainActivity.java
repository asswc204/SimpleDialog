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
        new SimpleTipDialog(this).setTitle("温馨提示").setContent("您的配件额度不足，您可以通过缴纳\n" +
                "保证金的方式来增加配件额度 ").setNavButtonText("仍要申请", null).
                setPosButtonText("一键退配", null).show();
    }

}
