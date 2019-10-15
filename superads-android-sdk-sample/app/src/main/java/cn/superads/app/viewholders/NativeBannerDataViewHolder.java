package cn.superads.app.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.superads.app.R;
import cn.superads.app.models.NativeData;

public class NativeBannerDataViewHolder extends RecyclerView.ViewHolder {

  private TextView tvTitle;
  private TextView tvDesc;

  public NativeBannerDataViewHolder(View v) {
    super(v);
    tvTitle = v.findViewById(R.id.tvTitle);
    tvDesc = v.findViewById(R.id.tvDesc);
  }

  public void bindData(NativeData data) {
    tvTitle.setText(data.getTitle());
    tvDesc.setText(data.getDesc());
  }
}
