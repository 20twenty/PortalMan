package com.liketivist.portalman;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {

   private static final String TAG = "MainGamePanel";
   private MainThread thread;

   public MainGamePanel(Context context) {
      super(context);
      getHolder().addCallback(this);

      // create the game loop thread
      thread = new MainThread(getHolder(), this);

      setFocusable(true);
   }

   
   public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
      
   }

   
   public void surfaceCreated(SurfaceHolder holder) {
      thread.setRunning(true);
      thread.start();
   }

   
   public void surfaceDestroyed(SurfaceHolder holder) {
      boolean retry = true;
      while (retry) {
         try {
            thread.join();
            retry = false;
         } catch (InterruptedException e) {
            // try again shutting down the thread
         }
      }
   }

   @Override
   public boolean onTouchEvent(MotionEvent event) {
      if (event.getAction() == MotionEvent.ACTION_DOWN) {
         if (event.getY() > getHeight() - 50) {
            thread.setRunning(false);
            ((Activity) getContext()).finish();
         } else {
            Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
         }
      }
      return super.onTouchEvent(event);
   }

   @Override
   protected void onDraw(Canvas canvas) {
   }
}
