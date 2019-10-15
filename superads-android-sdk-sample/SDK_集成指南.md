# Android SDK - SuperADS
**Latest Version:** 0.2.9

**Release Date:** 19.09.19

SuperADS SDK 可以为你的App添加横幅，插屏，视频，奖励视频和原生（信息流）广告。
这个SDK可以运行在Android Phone和Tablets上面。
 
## Requirements
Android Studio 3.4+

Android device or emulator with Android SDK v4.1+

### Table of Contents
1. [ Setup - Add SuperADS SDK to your project ](#1)
2. [ Integrate the SDK with your code ](#2)
3. [ Types of Advertisements (examples) ](#3)
4. [ Demo app ](#4)


<a name="1"></a>
## Setup

在你的build.gradle里面添加以下库依赖
```java
dependencies {
    implementation 'com.superads.android:adsdk:0.2.9'
}
```

<a name="2"></a>
## Integrate the SDK with your code
初始化SDK，在你的App运行周期内初始化只能调用一次，建议在MainActivity的onCreate里面初始化
```java
SuperAds.initialize(this, <Your_publisher_id>, <Your_app_id>);
```
<a name="3"></a>
## Types of Advertisements (examples)
- ### Banner Ad 横幅广告 
 ##### 横幅广告通常出现在应用一屏的顶部或者底部。添加以下代码可以展示横幅广告。

Create banner ad instance:
```java
AdSize adSize = new AdSize("320","50"); // Size of the banner
SAAdCard adCard = SuperAds.getInstance().createBannerAdCard(adSize, this);
```
如果是试玩广告请设置下面的可选参数:
```java
adCard.setContentType(AdContentType.PLAYABLE);
```
设置广告位:
```java
adCard.setPlacementId("PLACEMENT_ID")
```
设置广告加载的回调:
```java
adCard.setAdListener(new SaAdListener() {  
  @Override  
  public void onAdLoaded(SAAdCard card) {  
    bannerContainer.addView(adCard.getAdView());  //Adding the view to container to show on the screen
  }  
  
  @Override  
  public void onAdFailedToLoad(int errorCode, SAAdCard card) {  
    Logger.e("Error generating ad, error code=" + errorCode);  
  }  
});
```

- ### Interstitial Ad 插屏广告
 ##### 插屏广告是一种全屏广告，提供高清体验，一般用在App的场景切换之间展示，比如游戏过关，等在进度。

Create interstitial ad instance:
```java
AdSize adSize = new AdSize("768","1024"); // Size of the banner
SAAdCard adCard = SuperAds.getInstance().createInterstitialAdCard(adSize, this);
```
如果是试玩广告请设置下面的可选参数:
```java
adCard.setContentType(AdContentType.PLAYABLE);
```
设置广告位:
```java
adCard.setPlacementId("PLACEMENT_ID")
```
设置广告加载的回调:
```java
adCard.setAdListener(new SaAdListener() {  
  @Override  
  public void onAdLoaded(SAAdCard card) {  
	adCard.show(); // Show the ad
  }  
  
  @Override  
  public void onAdFailedToLoad(int errorCode, SAAdCard card) {  
    Logger.e("Error generating ad, error code=" + errorCode);  
  }  
});
```

- ### Video Ad 视频广告
 ##### 全屏播放的视频广告

Create video ad instance:
```java
AdSize adSize = new AdSize("1280","720"); // Size of the video
SAAdCard adCard = SuperAds.getInstance().createVideoAdCard(adSize, this);
```
设置广告位:
```java
adCard.setPlacementId("PLACEMENT_ID")
```
设置广告加载的回调:
```java
adCard.setAdListener(new SaAdListener() {  
  @Override  
  public void onAdLoaded(SAAdCard card) {  
    adCard.show(); // Start playing the video ad
  }  
  
  @Override  
  public void onAdFailedToLoad(int errorCode, SAAdCard card) {  
    Logger.e("Error generating ad, error code=" + errorCode);  
  }
  
  @Override  
  public void onVideoCompleted(SAAdCard card) {  
    Logger.i("Video completed.");  
  }  
});
```

- ### Rewarded Video Ad 奖励视频广告
 ##### 奖励视频可以让你的用户参与到应用中，完成任务后，获得某种形式的奖励比如游戏币，积分等。


Create video ad instance:
```java
AdSize adSize = new AdSize("1280","720"); // Size of the video
SAAdCard adCard = SuperAds.getInstance().createRewardedVideoAdCard(adSize, this);
```
设置广告位:
```java
adCard.setPlacementId("PLACEMENT_ID")
```
设置广告加载的回调:
```java
adCard.setAdListener(new SaAdListener() {  
  @Override  
  public void onAdLoaded(SAAdCard card) {  
    adCard.show(); // Start playing the video ad
  }  
  
  @Override  
  public void onAdFailedToLoad(int errorCode, SAAdCard card) {  
    Logger.e("Error generating ad, error code=" + errorCode);  
  }
  
  @Override  
  public void onVideoCompleted(SAAdCard card) {  
    Logger.i("Video completed.");  
  }  
  @Override  
  public void onVideoRewarded(SAAdCard card) {  
    Logger.i("Video rewarded!");  
  }
});
```
- ### Native Ad 原生广告（信息流）
 ##### 原生广告可以和你App的原有体验很好的融合，你可以定制自己的布局和风格来使得广告和App的体验一致。
 ##### Native ads make it easy for you to monetize your app in a way that’s consistent with its existing design. The SuperADS SDK gives you access to an ad’s individual assets so you can design the ad layout to be consistent with the look and feel of your app.

Create NativeAd instance:
```java
SAAdCard adCard = SuperAds.getInstance().createNativeAdCard(this);
```
```java
adCard.setPlacementId("PLACEMENT_ID")
```
设置UI field来容纳原生广告:
```java
  adCard.titleTextViewId(R.id.ad_txt_title)  
  adCard.privacyInformationIconImageId(R.id.privacy_icon_2)  
  adCard.descriptionsTextViewId(R.id.ad_txt_description)  
  adCard.callToActionTextViewId(R.id.ad_txt_cta)  
  adCard.iconImageViewId(R.id.ad_img_icon)
  adCard.bigImageViewId(R.id.ad_img)
  ```
设置广告加载的回调:
```java
adCard.setAdListener(new SaAdListener() {  
  @Override  
  public void onAdLoaded(SAAdCard card) {  
    adCard.show(); // Show just loaded ad
  }  
  
  @Override  
  public void onAdFailedToLoad(int errorCode, SAAdCard card) {  
    Logger.e("Error generating ad, error code=" + errorCode);  
  }  
});
```

## List of events:
##### 下面是广告加载展示点击等行为的回调
```java
void onAdLoaded(SAAdCard card) // Ad was loaded successfully and ready to be shown
void onAdFailedToLoad(int errorCode, SAAdCard card)
void onAdClosed(SAAdCard card)
void onAdLeftApplication(SAAdCard card) 
void onAdOpened(SAAdCard card)
void onAdClicked(SAAdCard card)
void onAdImpression(SAAdCard card)
void onVideoCompleted(SAAdCard card)
void onVideoRewarded(SAAdCard card)
```

<a name="4"></a>
## Demo App
##### A demo app with a simple usage of the SDK can be found in the following
Github repository: [Link](http://www.google.co.il "Link")

The demo app contains several types of advertisements:
**Banner** Ad, **Interstitial** Ad, **Video** Ad, **Rewarded Video** Ad and a **Native** Ad.


