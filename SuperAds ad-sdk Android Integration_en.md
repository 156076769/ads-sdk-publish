# SuperAds ad-sdk Android SDK Integration Document

SuperADS ad-sdk SDK provides Banner Ad, Interstital Ad, Native Banner, Native Feed Ad, Video Ad.

You can see a full demo with source codes in github: https://github.com/156076769/superads_standalone_demo
Demo APK: https://raw.githubusercontent.com/156076769/superads_standalone_demo/master/demo.apk

---

**1)	First of all you MUST apply a publisher id and application id from SuperADS**

**2)	Dependences**
```
implementation 'com.superads.android:adsdk:0.2.7'
```

**3)	Proguard**
```
-keep class cn.superads.sdk.providers.SuperAds { *; }
-keep class cn.superads.sdk.providers.models.AdRequest { *; }
-keep class cn.superads.sdk.providers.models.AdRequest$Builder { *; }
-keep class cn.superads.sdk.rendering.view.AdView { *; }
-keep class cn.superads.sdk.rendering.view.InterstitialAd { *; }
-keep class cn.superads.sdk.providers.models.NativeAdRequest { *; }
-keep class cn.superads.sdk.providers.models.NativeAdRequest$Builder { *; }
-keep class cn.superads.sdk.rendering.view.NativeAd { *; }
-keep class cn.superads.sdk.rendering.view.VideoAd { *; }
-keep class cn.superads.sdk.rendering.view.AdListener { *; }
-keep class cn.superads.sdk.providers.models.BannerSize { *; }
-keep class cn.superads.sdk.providers.models.InterstitialSize { *; }
-keep class cn.superads.sdk.providers.models.VideoSize { *; }

```

**4)	 SDK Initial**
```
SuperAds.init(context, "your publisherId", "your AppId"); 
```
We sugguest you invoke it in Application onCreate

**5)	 Request and show a Banner Ad**

![Image text](https://cloud-creative.superads.cn/fb0331acd93698371a54710293453a5b.png)

Step 1: add a FrameLayout in where you show the banner
```
    <FrameLayout
        android:id="@+id/card_banner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true" />
```
Step 2: call the request interface, when callback, show the Ad
```
final AdView adView = new AdView(this);
            AdRequest.Builder builder = new AdRequest.Builder("YOUR_PLACEMENT_ID_HERE");
            builder.adSize(BannerSize.MOBILE_BANNER_728x90);
            adView.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    bannerContainer.addView(adView);
                    bannerContainer.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }
            });
```

**5)	 Request and show a Interstital Ad**
Interstital Ad is showing in the full screen.

![Image text](https://cloud-creative.superads.cn/6db9ca8f93abc8c7f240aa7e8ab0a425.png)

Step 1: equest the Ad from server
```
            AdRequest.Builder builder = new AdRequest.Builder("YOUR_PLACEMENT_ID_HERE");
            builder.adSize(InterstitialSize.TABLET_INTERSTITIAL_1024x768);
            this.interstitialAd = new InterstitialAd(this);
            interstitialAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Toast.makeText(InterstitialActivity.this, "interstitial Ad load successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }
            });
```
Step 2: when getting response successfully, show the Ad
```
            if (interstitialAd != null)
                interstitialAd.show();
```

**6)	 Request a Native Ad(Feed Ad)**
Native Ad(Feed Ad) is a Ad that embedding in your origin listview/recycleview


![Image text](https://cloud-creative.superads.cn/480bf8127ef241d7d3b80004b0b53cae.png)

Super Ads Server response you 4 or 3 elements when you request a Native Ad
1. App Icon
2. APP Title
3. APP Description
4. APP Big Image (this maybe empty)
The publisher can use these elements to build a recycleview item and inser into the origin list.

Step 1: define a recycleview item layout to contains the 4 or 3 Native Ad elements.
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:background="@color/white">

    <TextView
        android:id="@+id/ad_txt_ad_indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:background="@drawable/ad_indication_square"
        android:gravity="center"
        android:text="Ad"
        android:textColor="@color/blue"
        android:textSize="12sp"
        tools:ignore="HardcodedText,RtlHardcoded" />

    <ImageView
        android:id="@+id/ad_img_icon"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_below="@+id/ad_txt_ad_indicator"
        android:layout_alignParentLeft="true"
        android:layout_marginLeft="3dp"
        android:layout_marginRight="3dp"
        android:scaleType="fitXY"
        android:contentDescription=""
        tools:ignore="RtlHardcoded" />

    <TextView
        android:id="@+id/ad_txt_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/ad_img_icon"
        android:layout_toRightOf="@+id/ad_img_icon"
        android:layout_margin="3dp"
        android:textColor="#006064"
        android:maxLines="2"
        android:textSize="20sp"
        tools:text="Awesome application that you have to try is now available for free download"
        tools:ignore="RtlHardcoded" />

    <TextView
        android:id="@+id/ad_txt_description"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/ad_img_icon"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="3dp"
        android:layout_marginRight="3dp"
        android:ellipsize="end"
        android:textColor="#009688"
        android:maxLines="3"
        android:textSize="15sp"
        tools:text="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." />

    <TextView
        android:id="@+id/ad_txt_cta"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/ad_txt_description"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="3dp"
        android:layout_marginRight="3dp"
        android:background="@drawable/cta_square_green"
        android:gravity="center"
        android:paddingStart="10dp"
        android:paddingLeft="10dp"
        android:paddingTop="5dp"
        android:paddingEnd="10dp"
        android:paddingRight="10dp"
        android:paddingBottom="5dp"
        android:textAllCaps="true"
        android:textColor="@color/white"
        android:textSize="14sp"
        android:textStyle="bold"
        tools:text="Download now" />

    <ImageView
        android:id="@+id/privacy_icon_2"
        android:layout_width="20dp"
        android:layout_height="20dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="10dp"
        android:layout_marginRight="5dp" />
		
</RelativeLayout>
```
Step 2: define a container layout to contain the recycleview item
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="2dp">

    <FrameLayout
        android:id="@+id/adContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```
Step 3: request and show the Native Ad
```
        if (viewType == NATIVE_AD_BANNER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.superads_native_ad_container, parent, false);
            final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_banner, null);
            NativeAdRequest.Builder builder = new NativeAdRequest.Builder(adView, "YOUR_PLACEMENT_ID_HERE")
                    .titleTextViewId(R.id.ad_txt_title)
					.privacyInformationIconImageId(R.id.privacy_icon_2)
                    .descriptionsTextViewId(R.id.ad_txt_description)
                    .callToActionTextViewId(R.id.ad_txt_cta)
                    .iconImageViewId(R.id.ad_img_icon);
            final NativeAd nativeAd = new NativeAd();
            nativeAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.i("NativeAdapter2","native ad loaded");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeAdapter2", "error generating ad, error code=" + errorCode);
                }
            });
            return new NativeAdViewHolder2(v, adView);
        } else if (viewType == NATIVE_AD_FEED) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.superads_native_ad_container, parent, false);
            final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_feed, null);
            NativeAdRequest.Builder builder = new NativeAdRequest.Builder(adView, "YOUR_PLACEMENT_ID_HERE")
                    .titleTextViewId(R.id.ad_txt_title)
					.privacyInformationIconImageId(R.id.privacy_icon_2)
                    .descriptionsTextViewId(R.id.ad_txt_description)
                    .callToActionTextViewId(R.id.ad_txt_cta)
                    .bigImageViewId(R.id.ad_img)
                    .iconImageViewId(R.id.ad_img_icon);
            final NativeAd feedAd = new NativeAd();
            feedAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.i("NativeAdapter2","native ad loaded");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeAdapter2","error generating ad, error code=" + errorCode);
                }
            });
            return new NativeAdViewHolder2(v,adView);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(v);
        }
```

**7)	 Request a video Ad**
Video Ad is playing in the full screen.

![Image text](https://cloud-creative.superads.cn/9af2e06d206b8c3abbf2bf455fc91f7f.png)

Step 1: request Ad
```
            AdRequest.Builder builder = new AdRequest.Builder("YOUR_PLACEMENT_ID_HERE");
            builder.adSize(VideoSize.VIDEO_560x320);
            this.videoAdLoader = new VideoAd(this);
            videoAdLoader.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Toast.makeText(VideoActivity.this, "video Ad load successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }
            });
```
Step 2: play video
```
            if (videoAdLoader != null)
                videoAdLoader.show();
```
