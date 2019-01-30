package com.example.zfz.simpledialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.zfz.simpledialog.R;

/**
 * Created by zfz on 2019/1/30.
 */

public class SimpleTipDialog {

    private Dialog dialog;
    private Context context;
    private TextView mTitleTv;
    private TextView mContentTv;
    private TextView mNavTv;
    private TextView mPosTv;

    public SimpleTipDialog(Context context) {
        this.context = context;
    }

    public SimpleTipDialog builder() {
        dialog = new Dialog(context, R.style.FullDialog);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_simple_tip, null);
        mTitleTv = view.findViewById(R.id.mTitleTv);
        mContentTv = view.findViewById(R.id.mContentTv);
        mNavTv = view.findViewById(R.id.mNavTv);
        mPosTv = view.findViewById(R.id.mPosTv);
        dialog.setContentView(view);
        return this;
    }

    public void show() {
        if (dialog != null) dialog.show();
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) dialog.dismiss();
    }
}
