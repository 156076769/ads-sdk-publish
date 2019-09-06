### 5. **Request Video Ad**
#### POST Request URL：https://superads-sdk-gateway.superadsprod.net/api/bid/video
#### request headers：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| Content-Type     | application/json |        |
#### request body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@8a41d830-1505-45a8-9315-d49b396590c9",
    "app": {
        "bundle": "com.aitype.android.ads",
        "id": "31",
        "name": "App_Name",
        "publisher": {
            "id": "1140",
            "name": "Publisher_Name"
        },
        "storeurl": "https://play.google.com/store/apps/details?id=com.aitype.android&hl=en",
        "ver": 1
    },
    "device": {
        "connectiontype": 2,
        "devicetype": 1,
        "w": 1080,
        "h": 1794,
        "hwv": "walleye",
        "carrier": "",
        "language": "zh_CN_#Hans",
        "model": "Pixel 2",
        "os": "Android",
        "osv": "8.1.0",
        "pxratio": 2.625,
        "make": "google",
        "ua": "Mozilla/5.0 (Linux; Android 8.1.0; Pixel 2 Build/OPM2.171026.006.G1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.98 Mobile Safari/537.36",
        "geo": {
            "country": "CN"
        }
    },
    "imp": [
        {
            "video": {
                "mimes": [
                    "VIDEO_X_FLV",
                    "VIDEO_MP4"
                ],
                "boxingallowed": true,
                "w": 560,
                "h": 320,
                "linearity": 1,
                "maxbitrate": 1500,
                "maxduration": 30,
                "maxextended": 0,
                "minbitrate": 300,
                "minduration": 5,
                "pos": 1,
                "protocol": [
                    2,
                    3
                ],
                "companiontype": [
                    2,
                    3
                ],
                "skip": 1,
                "skipmin": 15,
                "skipafter": 5
            },
            "displaymanagerver": "18",
            "instl": 0
        }
    ],
    "user": {
        "id": "af49bdc2-b63d-4980-b74d-2f346efd43c3"
    }
}
```

#### response body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@8a41d830-1505-45a8-9315-d49b396590c9",
    "seatbid": [
        {
            "bid": [
                {
                    "id": "YOUR_PLACEMENT_ID_HERE@8a41d830-1505-45a8-9315-d49b396590c9",
                    "price": 0,
                    "nurl": null,
                    "adm": "<VAST version=\"3.0\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n    <Ad id=\"20009\">\n        <InLine>\n            <AdSystem version=\"4.0\">iabtechlab</AdSystem>\n            <AdTitle>iabtechlab video ad</AdTitle>\n            <Pricing model=\"cpm\" currency=\"USD\">\n                <![CDATA[ 25.00 ]]>\n            </Pricing>\n            <Error>http://example.com/error</Error>\n            <Impression id=\"Impression-ID\">http://example.com/track/impression</Impression>\n            <Creatives>\n                <Creative id=\"5480\" sequence=\"1\">\n                    <Linear>\n                        <Duration>00:00:16</Duration>\n\n                        <TrackingEvents>\n                            <Tracking event=\"start\">http://example.com/tracking/start</Tracking>\n                            <Tracking event=\"firstQuartile\">http://example.com/tracking/firstQuartile</Tracking>\n                            <Tracking event=\"midpoint\">http://example.com/tracking/midpoint</Tracking>\n                            <Tracking event=\"thirdQuartile\">http://example.com/tracking/thirdQuartile</Tracking>\n                            <Tracking event=\"complete\">http://example.com/tracking/complete</Tracking>\n                            <Tracking event=\"progress\" offset=\"00:00:10\">http://example.com/tracking/progress-10</Tracking>\n                        </TrackingEvents>\n\n                        <VideoClicks>\n                            <ClickThrough id=\"blog\">\n                                <![CDATA[https://iabtechlab.com]]>\n                            </ClickThrough>\n                            <ClickTracking>\n                                <![CDATA[http://example.com/trackingurl/clickTracking]]>\n                            </ClickTracking>\n                        </VideoClicks>\n\n                        <MediaFiles>\n                            <MediaFile id=\"5241\" delivery=\"progressive\" type=\"video/mp4\" bitrate=\"500\" width=\"400\" height=\"300\" minBitrate=\"360\" maxBitrate=\"1080\" scalable=\"1\" maintainAspectRatio=\"1\" codec=\"0\">\n                                <![CDATA[https://iab-publicfiles.s3.amazonaws.com/vast/VAST-4.0-Short-Intro.mp4]]>\n                            </MediaFile>\n                        </MediaFiles>\n\n                    </Linear>\n                </Creative>\n            </Creatives>\n            <Extensions>\n                <Extension type=\"iab-Count\">\n                    <total_available>\n                        <![CDATA[ 2 ]]>\n                    </total_available>\n                </Extension>\n            </Extensions>\n        </InLine>\n    </Ad>\n</VAST>\n",
                    "ext": {
                        "eventsUrls": {
                            "impression": "https://superads-sdk-gateway.superads-staging.net/api/tracking/impression?pbu=aHR0cDovL3Nka3RyYWNraW5nLnN1cGVyYWRzLmNuL3JlY29yZEltcHJlc3Npb24_Y2FtcD0xJmNyZWF0aXZlX2lkPTE3NCZhcHBfaWQ9MjcmYWRfc2V0X2lkPTQ2JmNoX2lkPTEwNjkmdXNlcl9pZD1hZjQ5YmRjMi1iNjNkLTQ5ODAtYjc0ZC0yZjM0NmVmZDQzYzM=",
                            "click": "https://superads-sdk-gateway.superads-staging.net/api/tracking/click?pbu=aHR0cHM6Ly9jbG91ZC10cmFjay5zdXBlcmFkcy5jbi9pbmRleC5waHA_Y2FtcD0xJmNyZWF0aXZlX2lkPTE3NCZhcHBfaWQ9MjcmYWRfc2V0X2lkPTQ2JmNoX2lkPTEwNjkmdXNlcl9pZD1hZjQ5YmRjMi1iNjNkLTQ5ODAtYjc0ZC0yZjM0NmVmZDQzYzM="
                        }
                    },
                    "impid": null
                }
            ]
        }
    ]
}
```
VAST：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| MediaFiles     | media file url, video length, video width/height, bit rate |       |