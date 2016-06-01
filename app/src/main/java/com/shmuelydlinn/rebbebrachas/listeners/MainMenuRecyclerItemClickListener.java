package com.shmuelydlinn.rebbebrachas.listeners;

/**
 * Created by shmueldlinn on 5/30/16.
 * This class handles the touch events for the main menu recycler view
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainMenuRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private final OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final GestureDetector mGestureDetector;

    /**
     *
     * @param context
     * @param listener
     */
    public MainMenuRecyclerItemClickListener(Context context, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}