package com.liketivist.portalman;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity
{
   private static final String TAG = "MainActivity";

   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setContentView(new MainGamePanel(this));
      Log.d(TAG, "onCreate");
      //setContentView(R.layout.main);
   }

   @Override
   protected void onDestroy() {
      // TODO Auto-generated method stub
      super.onDestroy();
      Log.d(TAG, "onDestroy");
   }

   @Override
   protected void onPause() {
      // TODO Auto-generated method stub
      super.onPause();
      Log.d(TAG, "onPause");
   }

   @Override
   protected void onResume() {
      // TODO Auto-generated method stub
      super.onResume();
      Log.d(TAG, "onResume");
   }
}
