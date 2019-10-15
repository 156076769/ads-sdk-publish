package cn.superads.app.viewholders;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.superads.app.R;

public class NativeAdViewHolder extends RecyclerView.ViewHolder {

  public NativeAdViewHolder(View v, View adView) {
    super(v);
    ViewGroup container = v.findViewById(R.id.adContainer);
    container.addView(adView);
  }
}
