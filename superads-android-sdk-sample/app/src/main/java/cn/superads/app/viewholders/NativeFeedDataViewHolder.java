package cn.superads.app.viewholders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import cn.superads.app.R;
import cn.superads.app.models.NativeData;

public class NativeFeedDataViewHolder extends RecyclerView.ViewHolder {

  private ImageView imgItem;

  public NativeFeedDataViewHolder(View v) {
    super(v);
    imgItem = v.findViewById(R.id.imgItem);
  }

  public void bindData(NativeData data) {
    Drawable drawable = ContextCompat.getDrawable(itemView.getContext(), data.getImgRes());
    if (drawable != null) {
      imgItem.setImageDrawable(drawable);
    }
  }
}
