package com.ethanco.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Title Bar
 *
 * @author EthanCo
 * @since 2017/7/4
 * -     ┌─┐       ┌─┐
 * -  ┌──┘ ┴───────┘ ┴──┐
 * -  │                 │
 * -  │       ───       │
 * -  │  ─┬┘       └┬─  │
 * -  │                 │
 * -  │       ─┴─       │
 * -  │                 │
 * -  └───┐         ┌───┘
 * -      │         │
 * -      │         │
 * -      │         │
 * -      │         └──────────────┐
 * -      │                        │
 * -      │                        ├─┐
 * -      │                        ┌─┘
 * -      │                        │
 * -      └─┐  ┐  ┌───────┬──┐  ┌──┘
 * -        │ ─┤ ─┤       │ ─┤ ─┤
 * -        └──┴──┘       └──┴──┘
 * --------------- 神兽保佑 ---------------
 * --------------- 永无BUG! ---------------
 */
public class TitleBar extends RelativeLayout {
    public static final int DEFAULT_ITEM_PADDING = 0;

    private TextView tvTitle;
    private TextView tvLeft;
    private TextView tvRight;
    private ViewGroup layoutLeft;
    private ViewGroup layoutRight;
    private ImageView imgLeft;
    private ImageView imgRight;
    private View dividerBottom;

    public TitleBar(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        findView();

        TypedArray ta = getTitleBarTypedArray(context, attrs);
        initCommon(ta);
        initTitleText(ta);
        initLeftIc(ta);
        initLeftText(ta);
        initRightIc(ta);
        initRightText(ta);
        initBottomDivider(ta);
        ta.recycle();
    }

    private TypedArray getTitleBarTypedArray(Context context, AttributeSet attrs) {
        return context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
    }

    private void findView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View root = inflater.inflate(R.layout.layout_ethanco_title_bar, this);
        tvTitle = (TextView) root.findViewById(R.id.tv_title);
        tvLeft = (TextView) root.findViewById(R.id.tv_left);
        tvRight = (TextView) root.findViewById(R.id.tv_right);
        layoutLeft = (ViewGroup) root.findViewById(R.id.layout_left);
        layoutRight = (ViewGroup) root.findViewById(R.id.layout_right);
        imgLeft = (ImageView) root.findViewById(R.id.img_left);
        imgRight = (ImageView) root.findViewById(R.id.img_right);
        dividerBottom = root.findViewById(R.id.view_bottom_divider);
    }

    private void initCommon(TypedArray ta) {
        int textSize = (int) ta.getDimension(R.styleable.TitleBar_common_textSize, getResources().getDimension(R.dimen.titlebar_common_text_size));
        int textColor = ta.getColor(R.styleable.TitleBar_bar_text_color, Color.BLACK);
        setCommonTextSize(DensityUtil.px2sp(getContext(),textSize));
        setTextColor(textColor);
    }

    private void initBottomDivider(TypedArray ta) {
        int dividerColor = ta.getColor(R.styleable.TitleBar_bottom_divider_color,
                getResources().getColor(R.color.titlebar_bottom_divider_color));
        boolean dividerVisible = ta.getBoolean(R.styleable.TitleBar_bottom_divider_visible, false);
        dividerBottom.setBackgroundColor(dividerColor);
        dividerBottom.setVisibility(dividerVisible ? View.VISIBLE : View.GONE);
    }

    private void initRightText(TypedArray ta) {
        String rightText = ta.getString(R.styleable.TitleBar_rightText);
        int leftPadding = (int) ta.getDimension(
                R.styleable.TitleBar_rightText_LeftPadding, DEFAULT_ITEM_PADDING);
        int rightPadding = (int) ta.getDimension(
                R.styleable.TitleBar_rightText_RightPadding, DEFAULT_ITEM_PADDING);
        tvRight.setPadding(leftPadding, 0, rightPadding, 0);
        tvRight.setText(rightText);
    }

    private void initRightIc(TypedArray ta) {
        Drawable rightIc = ta.getDrawable(R.styleable.TitleBar_rightIc);
        int leftPadding = (int) ta.getDimension(
                R.styleable.TitleBar_rightIc_LeftPadding, DEFAULT_ITEM_PADDING);
        int rightPadding = (int) ta.getDimension(
                R.styleable.TitleBar_rightIc_RightPadding, DEFAULT_ITEM_PADDING);
        imgRight.setPadding(leftPadding, 0, rightPadding, 0);
        imgRight.setImageDrawable(rightIc);
    }

    private void initLeftText(TypedArray ta) {
        String leftText = ta.getString(R.styleable.TitleBar_leftText);
        int leftPadding = (int) ta.getDimension(
                R.styleable.TitleBar_leftText_LeftPadding, DEFAULT_ITEM_PADDING);
        int rightPadding = (int) ta.getDimension(
                R.styleable.TitleBar_leftText_RightPadding, DEFAULT_ITEM_PADDING);
        tvLeft.setPadding(leftPadding, 0, rightPadding, 0);
        tvLeft.setText(leftText);
    }

    private void initLeftIc(TypedArray ta) {
        Drawable leftIc = ta.getDrawable(R.styleable.TitleBar_leftIc);
        int leftIcLeftPadding = (int) ta.getDimension(
                R.styleable.TitleBar_leftIc_LeftPadding, DEFAULT_ITEM_PADDING);
        int leftIcRightPadding = (int) ta.getDimension(
                R.styleable.TitleBar_leftIc_RightPadding, DEFAULT_ITEM_PADDING);
        imgLeft.setImageDrawable(leftIc);
        imgLeft.setPadding(leftIcLeftPadding, 0, leftIcRightPadding, 0);
    }

    private void initTitleText(TypedArray ta) {
        String title = ta.getString(R.styleable.TitleBar_title);
        int titleTextSize = (int) ta.getDimension(R.styleable.TitleBar_title_textSize,
                getResources().getDimension(R.dimen.titlebar_title_text_size));
        tvTitle.setText(title);
        tvTitle.setTextSize(DensityUtil.px2sp(getContext(),titleTextSize));
    }

    public void setOnLeftClickListener(View.OnClickListener listener) {
        layoutLeft.setOnClickListener(listener);
    }

    public void setOnRightClickListener(View.OnClickListener listener) {
        layoutRight.setOnClickListener(listener);
    }

    public void setTitle(CharSequence title) {
        tvTitle.setText(title);
    }

    public void setTitleTextSize(int textSize) {
        tvTitle.setTextSize(textSize);
    }

    public void setTextColor(@ColorInt int textColor) {
        tvLeft.setTextColor(textColor);
        tvRight.setTextColor(textColor);
        tvTitle.setTextColor(textColor);
    }

    private void setCommonTextSize(int textSize) {
        tvLeft.setTextSize(textSize);
        tvRight.setTextSize(textSize);
    }

    public void setLeftText(CharSequence text) {
        tvLeft.setText(text);
    }

    public void setRightText(CharSequence text) {
        tvRight.setText(text);
    }
}
