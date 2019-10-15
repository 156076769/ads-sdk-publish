package cn.superads.app.fragments;

//
//  InterstitialFragment.java
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
import android.widget.Button;
import android.widget.EditText;
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

public class InterstitialFragment extends Fragment {
  private SAAdCard adCard;
  private Switch playableSwitch;
  private Button btnShow;
  private EditText sizeWidth, sizeHeight, customCountry;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_intertitial, container, false);

    playableSwitch = rootView.findViewById(R.id.intertitial_playable_switch);
    playableSwitch.setOnCheckedChangeListener((compoundButton, b) -> btnShow.setEnabled(false));
    btnShow = rootView.findViewById(R.id.intertitial_btn_show);
    rootView.findViewById(R.id.intertitial_btn_load).setOnClickListener(view -> loadInterstitial());
    btnShow.setOnClickListener(view -> showInterstitial());

    sizeWidth = rootView.findViewById(R.id.width_edit);
    sizeHeight = rootView.findViewById(R.id.height_edit);
    customCountry = rootView.findViewById(R.id.country_edit);
    sizeWidth.setText("768");
    sizeHeight.setText("1024");

    return rootView;
  }

  private void loadInterstitial() {

    AdSize adSize = new AdSize(
      sizeWidth.getText().toString(),
      sizeHeight.getText().toString());

//    if (BuildConfig.DEBUG)
      SuperAds.getInstance().setCustomCountry(customCountry.getText().toString());

    adCard = SuperAds.getInstance().createInterstitialAdCard(adSize, getActivity());

    adCard.setContentType( (playableSwitch.isChecked() ? AdContentType.PLAYABLE : AdContentType.ALL) )
      .setPlacementId("PLACEMENT_ID")
      .setAdListener(new SaAdListener() {
        @Override
        public void onAdLoaded(SAAdCard card) {
          if (getActivity() == null) return;

          ((MainActivity)getActivity()).setLoading(false);
          Logger.v("Interstitial ad loaded.");
          Toast.makeText(getActivity().getApplicationContext(),"Interstitial ad loaded.",Toast.LENGTH_LONG).show();
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
        public void onVideoCompleted(SAAdCard card) {}

        @Override
        public void onVideoRewarded(SAAdCard card) {}
      });

    ((MainActivity)getActivity()).setLoading(true);
    adCard.load();
  }

  private void showInterstitial() {
    adCard.show();
  }

}
