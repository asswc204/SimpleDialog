package com.chiu.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


/**
 * Created by zfz on 2019/1/30.
 * simple tips dialog(imitate ios)
 */

public class SimpleTipDialog implements View.OnClickListener {

    private Dialog dialog;
    private Context context;
    private TextView mTitleTv;
    private TextView mContentTv;
    private TextView mNavTv;
    private TextView mPosTv;
    private onButtonClickListener posClickListener;
    private onButtonClickListener navClickListener;
    private View mBottomDivider;


    public SimpleTipDialog(Context context) {
        this.context = context;
        initDilaog();
    }

    /**
     * init the dialog
     *
     * @return SimpleTipDialog
     */
    private void initDilaog() {
        dialog = new Dialog(context, R.style.FullDialog);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_simple_tip, null);
        mTitleTv = view.findViewById(R.id.mTitleTv);
        mContentTv = view.findViewById(R.id.mContentTv);
        mNavTv = view.findViewById(R.id.mNavTv);
        mPosTv = view.findViewById(R.id.mPosTv);
        mBottomDivider = view.findViewById(R.id.mBottomDivider);
        dialog.setContentView(view);
        mPosTv.setOnClickListener(this);
        mNavTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.mPosTv)
            if (posClickListener != null)
                posClickListener.onButtonClick();
            else dismiss();
        else if (i == R.id.mNavTv)
            if (navClickListener != null)
                navClickListener.onButtonClick();
            else dismiss();
    }

    public void show() {
        if (dialog != null) dialog.show();
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) dialog.dismiss();
    }

    public SimpleTipDialog setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        dialog.setCancelable(canceledOnTouchOutside);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        return this;
    }

    public SimpleTipDialog setTitle(@NonNull String titleText) {
        mTitleTv.setText(titleText);
        return this;
    }

    public SimpleTipDialog setMsg(@NonNull String msg) {
        mContentTv.setText(msg);
        return this;
    }

    public SimpleTipDialog setPosButtonText(@NonNull String posText, @Nullable onButtonClickListener posClickListener) {
        this.posClickListener = posClickListener;
        mPosTv.setText(posText);
        return this;
    }

    /**
     * @param color A color value in the form 0xAARRGGBB.
     *              Do not pass a resource ID. To get a color value from a resource ID
     * @return SimpleTipDialog
     */
    public SimpleTipDialog setPosTextColor(@ColorInt int color) {
        mPosTv.setTextColor(color);
        return this;
    }

    /**
     * @param size the unit of scaled pixel
     * @return SimpleTipDialog
     */
    public SimpleTipDialog setPosTextSize(int size) {
        mPosTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        return this;
    }

    public SimpleTipDialog setNavButtonText(@NonNull String navText, @Nullable onButtonClickListener navClickListener) {
        this.navClickListener = navClickListener;
        mNavTv.setText(navText);
        mNavTv.setVisibility(View.VISIBLE);
        mBottomDivider.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * @param color A color value in the form 0xAARRGGBB.
     *              Do not pass a resource ID. To get a color value from a resource ID
     * @return SimpleTipDialog
     */
    public SimpleTipDialog setNavTextColor(@ColorInt int color) {
        mNavTv.setTextColor(color);
        return this;
    }

    /**
     * @param size the unit of scaled pixel
     * @return SimpleTipDialog
     */
    public SimpleTipDialog setNavTextSize(int size) {
        mPosTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        return this;
    }

    public interface onButtonClickListener {
        void onButtonClick();
    }
}
