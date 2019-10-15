package cn.superads.app.fragments;

//
//  MainFragment.java
//  SuperADS - DemoApp
//
//  Created by SuperADS on 01/10/2019.
//  Copyright © 2019 SuperADS. All rights reserved.
//

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import cn.superads.app.BuildConfig;
import cn.superads.app.R;
import cn.superads.app.activities.MainActivity;
import cn.superads.app.models.DataType;
import cn.superads.sdk.sainterface.SuperAds;

public class MainFragment extends Fragment {
  private MainActivity activity;
  private TextView versionText;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    activity = (MainActivity)getActivity();
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    rootView.findViewById(R.id.btn_banner).setOnClickListener(view -> activity.gotoFragment(new BannerFragment()));
    rootView.findViewById(R.id.btn_interstitial).setOnClickListener(view -> activity.gotoFragment(new InterstitialFragment()));
    rootView.findViewById(R.id.btn_video).setOnClickListener(view -> activity.gotoFragment(new VideoFragment()));
    rootView.findViewById(R.id.btn_native_ad).setOnClickListener(view -> activity.gotoFragment(new NativeFragment().setType(DataType.NATIVE_BANNER)));

    versionText = rootView.findViewById(R.id.version_text);
    versionText.setText(String.format(getString(R.string.version),SuperAds.getVersion()));

    return rootView;
  }

}
