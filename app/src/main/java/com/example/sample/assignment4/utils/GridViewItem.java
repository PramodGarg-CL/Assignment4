package com.example.sample.assignment4.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Custom Class that extends @{@link RelativeLayout}
 * make the height equivalent to its width
 */

public class GridViewItem extends RelativeLayout {
    /**
     * Constructor
     *
     * @param context : context
     */
    public GridViewItem(final Context context) {
        super(context);
    }

    /**
     * Constructor
     *
     * @param context : context
     * @param attrs   : attrs
     */
    public GridViewItem(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context  context
     * @param attrs    attrs
     * @param defStyle defStyle
     */
    public GridViewItem(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        /*
        This is the key that will make the height equivalent to its width
         */
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}