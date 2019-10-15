package cn.superads.app.fragments;

//
//  BannerFragment.java
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import cn.superads.app.R;
import cn.superads.app.activities.MainActivity;
import cn.superads.sdk.events.enums.AdContentType;
import cn.superads.sdk.logs.Logger;
import cn.superads.sdk.providers.AdSize;
import cn.superads.sdk.sainterface.SAAdCard;
import cn.superads.sdk.sainterface.SaAdListener;
import cn.superads.sdk.sainterface.SuperAds;

public class BannerFragment extends Fragment {
  private SAAdCard adCard;
  private Switch playableSwitch;
  private EditText sizeWidth, sizeHeight, customCountry;
  private FrameLayout bannerContainer;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_banner, container, false);

    playableSwitch = rootView.findViewById(R.id.banner_playable_switch);
    sizeWidth = rootView.findViewById(R.id.width_edit);
    sizeHeight = rootView.findViewById(R.id.height_edit);
    customCountry = rootView.findViewById(R.id.country_edit);
    bannerContainer = rootView.findViewById(R.id.banner_container);

    rootView.findViewById(R.id.banner_btn_load).setOnClickListener(view -> showBanner());

    return rootView;
  }

  private void showBanner() {
    bannerContainer.removeAllViews();

    AdSize adSize = new AdSize(
      sizeWidth.getText().toString(),
      sizeHeight.getText().toString());

    adCard = SuperAds.getInstance().createBannerAdCard(adSize, getActivity());

    adCard.setContentType( playableSwitch.isChecked() ? AdContentType.PLAYABLE : AdContentType.ALL)
      .setPlacementId("PLACEMENT_ID")
      .setAdListener(new SaAdListener() {
        @Override
        public void onAdLoaded(SAAdCard card) {
          if (getActivity() == null) return;

          ((MainActivity)getActivity()).setLoading(false);
          bannerContainer.addView(adCard.getAdView());
        }

        @Override
        public void onAdFailedToLoad(int errorCode, SAAdCard card) {
          if (getActivity() == null) return;

          ((MainActivity)getActivity()).setLoading(false);
          Logger.e("Error generating ad, error code=" + errorCode);
          Toast.makeText(getActivity().getApplicationContext(),"Error generating ad, error code=" + errorCode,Toast.LENGTH_LONG).show();
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
        public void onVideoCompleted(SAAdCard card) {}

        @Override
        public void onVideoRewarded(SAAdCard card) {}
      });

    ((MainActivity)getActivity()).setLoading(true);
    adCard.load();
  }

}
