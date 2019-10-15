package cn.superads.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import cn.superads.app.R;
import cn.superads.app.models.DataType;
import cn.superads.app.models.NativeData;
import cn.superads.app.viewholders.NativeAdViewHolder;
import cn.superads.app.viewholders.NativeFeedDataViewHolder;
import cn.superads.sdk.logs.Logger;
import cn.superads.sdk.providers.models.NativeAdRequest;
import cn.superads.sdk.rendering.view.AdListener;
import cn.superads.sdk.rendering.view.NativeAd;

public class NativeFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final int NORMAL = 0;
  private final int AD = 1;
  private List<NativeData> list;

  public NativeFeedAdapter(List<NativeData> items) {
    list = items;
  }

  @Override
  public int getItemViewType(int position) {
    return (list.get(position).getType() == DataType.NORMAL) ? NORMAL : AD;
  }


  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v;
    if (viewType == NORMAL) {
      v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.native_feed_item, parent, false);
      return new NativeFeedDataViewHolder(v);
    } else {
      v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.native_banner_ad, parent, false);
      final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_ad_example_feed_ad, null);
      NativeAdRequest.Builder builder = new NativeAdRequest.Builder(adView, "YOUR_PLACEMENT_ID_HERE")
        .mainTextLabelId(R.id.ad_txt_title)
        .descriptionsTextViewId(R.id.ad_txt_description)
        .callToActionTextViewId(R.id.ad_txt_cta)
        .mainImageViewId(R.id.ad_img)
        .privacyInformationIconImageId(R.id.privacy_icon_2)
        .iconImageViewId(R.id.ad_img_icon);

      final NativeAd feedAd = new NativeAd();
      feedAd.loadAd(builder.build(), new AdListener() {
        @Override
        public void onAdLoaded() {
          Logger.i("native ad loaded");
        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
          Logger.e("error generating ad, error code=" + errorCode);
        }
      });
      return new NativeAdViewHolder(v, adView);
    }
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    NativeData data = list.get(position);
    if (data.getType() == DataType.NORMAL) {
      ((NativeFeedDataViewHolder) holder).bindData(data);
    }
  }

  @Override
  public int getItemCount() {
    return list.size();
  }
}
