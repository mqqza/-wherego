package com.wherego.soulq.wherego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

    private Runnable scrollerTask;
    private int initialPosition;
    private int newCheck = 100;
    private float mLastY = 0;


    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scrollerTask = new Runnable() {
            public void run() {
                int newPosition = getScrollY();
                if (initialPosition - newPosition != 0) {
                    initialPosition = getScrollY();
                    CustomScrollView.this.postDelayed(scrollerTask, newCheck);
                }
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                final int threashold = 70;
                if (mLastY - ev.getY() > threashold) {
                    getRootView().findViewById(R.id.footer).setVisibility(VISIBLE);
                    mLastY = ev.getY();
                } else if (mLastY - ev.getY() < -threashold) {
                    getRootView().findViewById(R.id.footer).setVisibility(GONE);
                    mLastY = ev.getY();
                }
        }
        return super.onTouchEvent(ev);
    }
}