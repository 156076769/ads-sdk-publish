##SupserADS adsdk（Android） SDK 快速接入向导

---

###一、库文件导入

如果您使用Gradle编译Apk，我们强烈推荐您使用自动接入方式配置库文件（[JCenter仓库](https://dl.bintray.com/superads/maven/com/superads/android/adsdk/)）。

####方式1. 自动导入（推荐）

在Module的buid.gradle文件中添加依赖和属性配置：

```groovy
android {
    defaultConfig {
		ndk {
			// 设置支持的SO库架构
			abiFilters 'armeabi' //, 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
		}
	}
}

dependencies {
	compile 'com.superads.android:adsdk:0.0.1'
}
```

**后续更新SDK时，只需变更配置脚本中的版本号即可。**


> `注意：自动集成时会自动包含adsdk SO库，建议在Module的build.gradle文件中使用NDK的“abiFilter”配置，设置支持的SO库架构。`
> 
> 如果在添加**“abiFilter”**之后Android Studio出现以下提示：
> `NDK integration is deprecated in the current plugin.  Consider trying the new experimental plugin.`
> 
> 则在项目根目录的**gradle.properties**文件中添加：
> ```groovy
> android.useDeprecatedNdk=true
> ```

---

####方式2. 手动导入
在 http://www.superads.cn 上面下载aar

---

###二、参数配置

- 在AndroidManifest.xml中添加权限：
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```

- 请避免混淆adsdk，在Proguard混淆文件中增加一行配置：

```powershell
-keep class com.bumptech.** { *; }
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class okhttp3.** { *; }
-keep class retrofit2.** { *; }

-keep class com.superads.android.adsdk.ads.utils.CryptoUtils { *; }
-keep class com.superads.android.adsdk.ads.providers.SuperAds { *; }
-keep class com.superads.android.adsdk.ads.providers.models.AdRequest { *; }
-keep class com.superads.android.adsdk.ads.providers.models.AdRequest$Builder { *; }
-keep class com.superads.android.adsdk.ads.rendering.view.AdView { *; }
-keep class com.superads.android.adsdk.ads.rendering.view.InterstitialAd { *; }
-keep class com.superads.android.adsdk.ads.providers.models.NativeAdRequest { *; }
-keep class com.superads.android.adsdk.ads.providers.models.NativeAdRequest$Builder { *; }
-keep class com.superads.android.adsdk.ads.rendering.view.NativeAd { *; }
-keep class com.superads.android.adsdk.ads.rendering.view.AdListener { *; }
-keep class com.superads.android.adsdk.ads.providers.SuperAdsConfig { *; }
```

---

###三、最简单的初始化

获取Publisher Id和Application Id并将以下代码复制到项目Application类onCreate()中，adsdk会为自动检测环境并完成配置：

```java
SuperAds.init(this, "你的pulbisher Id", "你的application Id");
```

---

###四、测试


