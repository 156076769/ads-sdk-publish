package cn.superads.app.fragments;

//
//  VideoFragment.java
//  SuperADS - Sample App
//
//  Created by SuperADS on 01/10/2019.
//  Copyright © 2019 SuperADS. All rights reserved.
//

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import cn.superads.app.R;
import cn.superads.app.activities.MainActivity;
import cn.superads.sdk.logs.Logger;
import cn.superads.sdk.providers.AdSize;
import cn.superads.sdk.sainterface.SAAdCard;
import cn.superads.sdk.sainterface.SaAdListener;
import cn.superads.sdk.sainterface.SuperAds;

public class VideoFragment extends Fragment {
  private SAAdCard adCard;

  private Switch rewardedSwitch;
  private Button btnShow;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_video, container, false);

    rewardedSwitch = rootView.findViewById(R.id.video_rewarded_switch);
    rewardedSwitch.setOnCheckedChangeListener((compoundButton, b) -> btnShow.setEnabled(false));

    rootView.findViewById(R.id.video_btn_load).setOnClickListener(view -> loadVideo());

    btnShow = rootView.findViewById(R.id.video_btn_show);
    btnShow.setOnClickListener(view -> showVideo());

    return rootView;
  }

  private void loadVideo() {

    if (rewardedSwitch.isChecked())
      adCard = SuperAds.getInstance().createRewardedVideoAdCard(new AdSize("1280", "720"), getActivity());
    else
      adCard = SuperAds.getInstance().createVideoAdCard(new AdSize("1280", "720"), getActivity());

      adCard.setPlacementId("PLACEMENT_ID");
      adCard.setAdListener(new SaAdListener() {

      @Override
      public void onAdLoaded(SAAdCard card) {
        if (getActivity() == null) return;

        ((MainActivity)getActivity()).setLoading(false);
        Logger.v("Video ad loaded.");
        Toast.makeText(getActivity().getApplicationContext(),"Video ad loaded.",Toast.LENGTH_LONG).show();
        btnShow.setEnabled(true);
      }

      @Override
      public void onAdFailedToLoad(int errorCode, SAAdCard card) {
        if (getActivity() == null) return;

        Logger.e("Error generating ad, error code=" + errorCode);
        Toast.makeText(getActivity().getApplicationContext(),"Error generating ad, error code=" + errorCode,Toast.LENGTH_LONG).show();
        ((MainActivity)getActivity()).setLoading(false);
      }

      @Override
      public void onAdClosed(SAAdCard card) {}

      @Override
      public void onAdLeftApplication(SAAdCard card) {}

      @Override
      public void onAdOpened(SAAdCard card) {}

      @Override
      public void onAdClicked(SAAdCard card) {}

      @Override
      public void onAdImpression(SAAdCard card) {}

      @Override
      public void onVideoCompleted(SAAdCard card) {
        Logger.i("Video completed.");
      }

      @Override
      public void onVideoRewarded(SAAdCard card) {
        Logger.i("Video rewarded!");
      }
    });

    ((MainActivity)getActivity()).setLoading(true);
    adCard.load();
  }

  private void showVideo() {
    adCard.show();
  }

}
