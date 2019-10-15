package cn.superads.app.fragments;

//
//  NativeFragment.java
//  SuperADS - DemoApp
//
//  Created by SuperADS on 01/10/2019.
//  Copyright © 2019 SuperADS. All rights reserved.
//

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import cn.superads.app.R;
import cn.superads.app.adapters.NativeBannerAdapter;
import cn.superads.app.adapters.NativeFeedAdapter;
import cn.superads.app.models.DataType;
import cn.superads.app.models.NativeData;
import cn.superads.sdk.sainterface.SAAdCard;
import cn.superads.sdk.sainterface.SuperAds;

public class NativeFragment<T> extends Fragment {
  private RecyclerView recycler;
  private NativeBannerAdapter _adapter;
  private DataType adType;

  public NativeFragment setType(DataType type) {
    adType = type;
    return this;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_native, container, false);

    recycler = rootView.findViewById(R.id.recycler);
    recycler.setHasFixedSize(true);
    recycler.setLayoutManager(new LinearLayoutManager(getContext()));

    switch (adType) {
      case NATIVE_BANNER:
        setNativeBannerRecyclerData();
        break;
      case NATIVE_FEED:
      default:
        setNativeFeedRecyclerData();
        break;
    }

    return rootView;
  }

  private void setNativeBannerRecyclerData() {
    List<T> items = new ArrayList<>();
    String[] titles = getResources().getStringArray(R.array.item_titles);
    String[] descriptions = getResources().getStringArray(R.array.item_descriptions);

    for (int i = 0; i < titles.length; i++) {
      NativeData data = new NativeData();
      data.setTitle(titles[i]);
      data.setDesc(descriptions[i]);
      data.setType(DataType.NORMAL);
      items.add((T) data);
    }

    int adDelimiter = 10;
    for (int i = 1; i < titles.length; i++) {
      if (i % adDelimiter == 0) {
        SAAdCard card = SuperAds.getInstance().createNativeAdCard(getActivity());
        card.setPlacementId("YOUR_PLACEMENT_ID")
          .setAdUnitId("YOUR_AD_UNIT_ID");
        items.add(i, (T) card);
      }
      _adapter = new NativeBannerAdapter(items);

    }
    recycler.setAdapter(_adapter);
  }

  private void setNativeFeedRecyclerData() {
    List<NativeData> items = new ArrayList<>();
    int[] imageRes = {R.drawable.product2, R.drawable.product3};

    for (int imageRe : imageRes) {
      NativeData data = new NativeData();
      data.setImgRes(imageRe);
      data.setType(DataType.NORMAL);
      items.add(data);
    }

    NativeData data = new NativeData();
    data.setType(DataType.NATIVE_FEED);
    items.add(1, data);
    recycler.setAdapter(new NativeFeedAdapter(items));
  }

}
