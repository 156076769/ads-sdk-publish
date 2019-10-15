package cn.superads.app.activities;

//
//  MainActivity.java
//  SuperADS - DemoApp
//
//  Created by SuperADS on 01/10/2019.
//  Copyright © 2019 SuperADS. All rights reserved.
//

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cn.superads.app.R;
import cn.superads.app.fragments.MainFragment;
import cn.superads.sdk.sainterface.SuperAds;

public class MainActivity extends FragmentActivity {
  private View loadingOverlay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
      WebView.setWebContentsDebuggingEnabled(true);

    SuperAds.initialize(this, "1156", "34"); //YOUR_PUBLISHER_ID_HERE

    loadingOverlay = findViewById(R.id.loading_overlay);

    if (getSupportFragmentManager().getBackStackEntryCount() == 0)
      gotoFragment(new MainFragment());
  }

  public void gotoFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction()
      .add(R.id.fragment_holder,fragment)
      .addToBackStack(fragment.getTag())
      .commit();
  }

  public void setLoading(boolean on) {
    loadingOverlay.setVisibility( on ? View.VISIBLE : View.GONE);
  }

  @Override
  public void onBackPressed() {
    if (getSupportFragmentManager().getBackStackEntryCount()>1)
      getSupportFragmentManager().popBackStackImmediate();
    else
      finish();
  }

}
