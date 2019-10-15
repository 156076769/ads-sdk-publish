package cn.superads.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.superads.app.R;
import cn.superads.app.models.NativeData;
import cn.superads.app.viewholders.NativeBannerDataViewHolder;
import cn.superads.sdk.logs.Logger;
import cn.superads.sdk.sainterface.SAAdCard;
import cn.superads.sdk.sainterface.SANativeAdCard;
import cn.superads.sdk.sainterface.SaAdListener;

public class NativeBannerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final int NORMAL = 0;
  private final int AD = 1;
  private List<T> _items;

  public NativeBannerAdapter(List<T> items) {
    _items = items;
  }

  @Override
  public int getItemViewType(int position) {
    return (_items.get(position) instanceof NativeData) ? NORMAL : AD;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v;
    if (viewType == NORMAL) {
      v = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_banner_item, parent, false);
      return new NativeBannerDataViewHolder(v);
    }

    if (viewType == AD) {
      final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_ad_example_banner_ad, null);
      return new CardViewHolder(adView);
    }
    throw new IllegalStateException("Wrong type of item received. Please make sure you put only NativeData and SAAdCard objects!");
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    if (getItemViewType(position) == NORMAL)
      ((NativeBannerDataViewHolder) holder).bindData((NativeData) _items.get(position));
    else { // Ad
      CardViewHolder cardHolder = (CardViewHolder) holder;
      SANativeAdCard card = (SANativeAdCard) _items.get(position);
      cardHolder.card = card;
      card.setAdListener(cardHolder);
      card.setView(cardHolder.itemView);
      if (card.isReady()) {
        card.show();
      } else {
        //card not ready yet !! load ad!
        card.setMainTextLabelId(R.id.ad_txt_title)
          .setDescriptionTextLabelId(R.id.ad_txt_description)
          .setCallToActionTextViewId(R.id.ad_txt_cta)
          .setIconImageViewId(R.id.ad_img_icon)
          .setPrivacyInformationImageView(R.id.privacy_icon_2);
        card.load();
      }
    }
  }

  @Override
  public int getItemCount() {
    return _items.size();
  }

  class CardViewHolder extends RecyclerView.ViewHolder implements SaAdListener {

    public SANativeAdCard card;

    public CardViewHolder(@NonNull View itemView) {
      super(itemView);
    }

    @Override
    public void onAdLoaded(SAAdCard card) {
      card.show();
      itemView.findViewById(R.id.loading_progress).setVisibility(View.GONE);
      //card.getAdView().findViewById(R.id.loading_progress).setVisibility(View.GONE);
    }

    @Override
    public void onAdFailedToLoad(int errorCode, SAAdCard card) {
      Logger.e("Native ad could not be loaded. Error code: " + errorCode + ".  this is your chance to handle this view holder.");
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
  }

}
