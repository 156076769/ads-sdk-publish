# SuperAds ad-sdk Android SDK 接入指南

SuperADS广告sdk提供了横幅广告（Banner），插屏广告（Interstital），原生广告（Native Banner, Native Feed），视频广告（Video）等4种广告形式，通过集成广告sdk展示广告可以获得收益。本文描述了Android开发者如何集成sdk和展示广告。

详细的接入demo示例代码可以：https://github.com/156076769/superads_standalone_demo
Demo APK: https://raw.githubusercontent.com/156076769/superads_standalone_demo/master/demo.apk

---

**1)	集成前获取PublisherId和AppId**
SuperADS为每个开发者分配一个Publisher Id。在集成sdk前，请联系SuperADS运营获取此Id。

**2)	依赖sdk和初始化**
```
//SuperADS广告SDK需要的
implementation 'com.superads.android:adsdk:0.2.7'
implementation 'com.squareup.retrofit2:retrofit:2.6.0'
implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
```

**3)	混淆配置**
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
-keep class cn.superads.sdk.rendering.view.RewardedVideoAd { *; }

```

**4)	 初始化**
```
SuperAds.init(context, "分配给你的publisherId", "分配给你的AppId"); 
```
建议在application的onCreate里面调用此初始化

**5)	 请求和展示横幅广告**

![Image text](https://raw.githubusercontent.com/hongmaju/light7Local/master/img/productShow/20170518152848.png)

第一步：在你要展示广告的页面布局中加入容纳广告的FrameLayout，并且将此FrameLayout放在顶部或者底部。
```
    <FrameLayout
        android:id="@+id/card_banner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true" />
```
第二步：调用请求接口，在回调中展示view
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

**5)	 请求和展示插屏广告**
插屏广告是1024*768（竖屏下）的广告，全屏显示。

![Image text](https://raw.githubusercontent.com/hongmaju/light7Local/master/img/productShow/20170518152848.png)

请求广告：
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
请求成功后展示广告
```
            if (interstitialAd != null)
                interstitialAd.show();
```

**6)	 请求和展示原生广告（信息流）**
原生广告是嵌入到你的feed流中的广告样式，也叫信息流广告，分为Native Banner和Native Feed两种。

![Image text](https://raw.githubusercontent.com/hongmaju/light7Local/master/img/productShow/20170518152848.png)

服务器返回的原生广告Ad素材包含下面4或者3个元素：
1. App Icon：应用小图标
2. APP Title：应用名称
3. APP Description：应用描述
4. APP Big Image：应用大图（Banner形式没有，Feed形式有）
开发者可以用这4或者3个元素来构建一个Recycle View Item，嵌入到自己原来的list中，选择合适的位置展示，并且适配成自己UI风格使其显示自然。
下面是一个接入实例：
第一步：定义一个符合自己UI风格的item layout用来容纳原生广告素材的4元素
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
第二步：定义一个container layout来容纳这个ad item
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
第三步，请求原生广告并显示
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

**7)	 请求和展示视频广告**
视频广告一个全屏播放的广告形式。

![Image text](https://raw.githubusercontent.com/hongmaju/light7Local/master/img/productShow/20170518152848.png)

请求广告
```
            AdRequest.Builder builder = new AdRequest.Builder("YOUR_PLACEMENT_ID_HERE");
            builder.adSize(VideoSize.VIDEO_1280x720);
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
展示广告
```
            if (videoAdLoader != null)
                videoAdLoader.show();
```
