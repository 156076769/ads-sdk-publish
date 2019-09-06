### 1. **First, When SDK is installed(App installed)，this request sends to server, and response a user_id which is saved in phone and used for device id later**

#### GET Request URL：https://superads-sdk-gateway.superadsprod.net/api/meta/user/id
#### Request Headers：empty
#### Request Body：empty

#### Response body：
```
{
    "id": "fd3f0775-9000-412a-be70-374b2d6cfe6f"
}
```

### 2. **Get a Banner Ad**
#### POST Request URL：https://superads-sdk-gateway.superadsprod.net/api/bid/banner
#### Request Headers：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| Content-Type     | application/json |        |
#### Request Body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@7c7d7f43-7118-4e3c-8595-12eea5337e28",
    "app": {
        "bundle": "com.superads.android.adsdkdemostandalone",
        "name": "SuperADS Demo",
        "ver": 1,
        "id": "123456",
        "publisher": {
            "id": 1140
        }
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
            "country": "ID"
        }
    },
    "imp": [
        {
            "banner": {
                "w": 728,
                "h": 90
            },
            "displaymanagerver": "20",
            "instl": 0
        }
    ],
    "user": {
        "id": "e6a89007-0cf7-42cc-a5f0-8d501284c10f"
    }
}
```

request：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| id     | id_xxx | the request id       |

app：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| bundle     | com.superads.android.adsdkdemostandalone | app package name       |
| name     | SuperADS Demo | app name       |
| ver     | 1 | app version       |
| id     | 27 | app id in platform.superads.cn       |

publisher：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| id     | 1069 | publisher id in platform.superads.cn       |

device：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| connectiontype     | 2 | -1:unknown, 2:wifi, 3:mobile       |
| devicetype     | 1 | 1:Mobile/Tablet       |
| w     | 1080 | screen width of device       |
| h     | 1794 | creen height of device      |
| hwv     | walleye | device internal model      |
| carrier     | CMCC | carrier       |
| language     | zh_CN_#Hans | language of device os       |
| model     | Pixel 2 | device external model      |
| os     | Android | device os       |
| osv     | 8.1.0 | device os version       |
| pxratio     | 2.625 | device screen density       |
| make     | google | device manufactory       |
| ua     | Mozilla/5.0 (Linux; Android 8.1.0; Pixel 2 Build/OPM2.171026.006.G1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.98 Mobile Safari/537.36 | user agent       |

geo：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| country     | ID | ISO 3166-1 country code       |

imp：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| displaymanagerver     | 20 |        |
| instl     | 0 | 0：no intestitial，1：interstitial       |

banner：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| w     | 728 | banner width       |
| h     | 90 | banner height       |

#### response body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@7c7d7f43-7118-4e3c-8595-12eea5337e28",
    "seatbid": [
        {
            "bid": [
                {
                    "id": "YOUR_PLACEMENT_ID_HERE@7c7d7f43-7118-4e3c-8595-12eea5337e28",
                    "price": 0,
                    "nurl": null,
                    "adm": "<a href=\"https://superads-sdk-gateway.superads-staging.net/api/tracking/click?pbu=aHR0cHM6Ly9jbG91ZC10cmFjay5zdXBlcmFkcy5jbi9pbmRleC5waHA_Y2FtcD00JmNyZWF0aXZlX2lkPTEwOCZhcHBfaWQ9MjUmYWRfc2V0X2lkPTQ3JmNoX2lkPTEwNjkmdXNlcl9pZD1ZT1VSX1BMQUNFTUVOVF9JRF9IRVJFQDdjN2Q3ZjQzLTcxMTgtNGUzYy04NTk1LTEyZWVhNTMzN2UyOA==\"><img src=\"https://d3niwjjcw9coqg.cloudfront.net/19d05e35f303c501d639a7c8c57757ca.jpg\" height=\"90\" width=\"728\" /></a>",
                    "ext": {
                        "eventsUrls": {
                            "impression": "https://superads-sdk-gateway.superads-staging.net/api/tracking/impression?pbu=aHR0cDovL3Nka3RyYWNraW5nLnN1cGVyYWRzLmNuL3JlY29yZEltcHJlc3Npb24_Y2FtcD00JmNyZWF0aXZlX2lkPTEwOCZhcHBfaWQ9MjUmYWRfc2V0X2lkPTQ3JmNoX2lkPTEwNjkmdXNlcl9pZD1ZT1VSX1BMQUNFTUVOVF9JRF9IRVJFQDdjN2Q3ZjQzLTcxMTgtNGUzYy04NTk1LTEyZWVhNTMzN2UyOA==",
                            "click": "https://superads-sdk-gateway.superads-staging.net/api/tracking/click?pbu=aHR0cHM6Ly9jbG91ZC10cmFjay5zdXBlcmFkcy5jbi9pbmRleC5waHA_Y2FtcD00JmNyZWF0aXZlX2lkPTEwOCZhcHBfaWQ9MjUmYWRfc2V0X2lkPTQ3JmNoX2lkPTEwNjkmdXNlcl9pZD1ZT1VSX1BMQUNFTUVOVF9JRF9IRVJFQDdjN2Q3ZjQzLTcxMTgtNGUzYy04NTk1LTEyZWVhNTMzN2UyOA=="
                        }
                    },
                    "impid": null
                }
            ]
        }
    ]
}
```

| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| id     | YOUR_PLACEMENT_ID_HERE@xxx | the id in the request       |
| price     | 0 | Ad price      |
| adm     | 0 | Ad creatives in html format, find image url in "img src=", and then you can download it       |

eventsUrls：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| impression     |  | when you show Ad successfully, send this impression url to report server the events       |
| click     |  | when use click the Ad, open this click_url in broswer or Play store to jump the target       |

### 3. **Request Interstitial Ad**
#### POST Request URL：https://superads-sdk-gateway.superadsprod.net/api/bid/banner
#### Request Headers：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| Content-Type     | application/json |        |
#### Request Body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@d0ef1135-02a0-471d-8219-4162d71ecf1a",
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
            "banner": {
                "w": 1024,
                "h": 768
            },
            "displaymanagerver": "18",
            "instl": 1
        }
    ],
    "user": {
        "id": "af49bdc2-b63d-4980-b74d-2f346efd43c3"
    }
}
```

imp：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| displaymanagerver     | 20 |        |
| instl     | 1 | 0：no interstitial(banner), 1：interstitial       |

banner：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| w     | 1024 | interstitial ad width       |
| h     | 768 | interstitial ad height       |

#### reponse body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@d0ef1135-02a0-471d-8219-4162d71ecf1a",
    "seatbid": [
        {
            "bid": [
                {
                    "id": "YOUR_PLACEMENT_ID_HERE@d0ef1135-02a0-471d-8219-4162d71ecf1a",
                    "price": 0,
                    "nurl": null,
                    "adm": "<a href=\"https://superads-sdk-gateway.superads-staging.net/api/tracking/click?pbu=aHR0cHM6Ly9jbG91ZC10cmFjay5zdXBlcmFkcy5jbi9pbmRleC5waHA_Y2FtcD03NiZjcmVhdGl2ZV9pZD0yOTAmYXBwX2lkPTMzJmFkX3NldF9pZD0xMjMmY2hfaWQ9MTE1NSZ1c2VyX2lkPWFmNDliZGMyLWI2M2QtNDk4MC1iNzRkLTJmMzQ2ZWZkNDNjMw==\"><img src=\"https://d3niwjjcw9coqg.cloudfront.net/95e478c4d986ca4d7979c57160f45277.jpg\" /></a>",
                    "ext": {
                        "eventsUrls": {
                            "impression": "https://superads-sdk-gateway.superads-staging.net/api/tracking/impression?pbu=aHR0cDovL3Nka3RyYWNraW5nLnN1cGVyYWRzLmNuL3JlY29yZEltcHJlc3Npb24_Y2FtcD03NiZjcmVhdGl2ZV9pZD0yOTAmYXBwX2lkPTMzJmFkX3NldF9pZD0xMjMmY2hfaWQ9MTE1NSZ1c2VyX2lkPWFmNDliZGMyLWI2M2QtNDk4MC1iNzRkLTJmMzQ2ZWZkNDNjMw==",
                            "click": "https://superads-sdk-gateway.superads-staging.net/api/tracking/click?pbu=aHR0cHM6Ly9jbG91ZC10cmFjay5zdXBlcmFkcy5jbi9pbmRleC5waHA_Y2FtcD03NiZjcmVhdGl2ZV9pZD0yOTAmYXBwX2lkPTMzJmFkX3NldF9pZD0xMjMmY2hfaWQ9MTE1NSZ1c2VyX2lkPWFmNDliZGMyLWI2M2QtNDk4MC1iNzRkLTJmMzQ2ZWZkNDNjMw=="
                        }
                    },
                    "impid": null
                }
            ]
        }
    ]
}
```

### 4. **Request Native Ad**
#### POST Request URL：https://superads-sdk-gateway.superadsprod.net/api/bid/native
#### request headers：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| Content-Type     | application/json |        |
#### request body：
```
{
    "id": "YOUR_PLACEMENT_ID_HERE@29935051-bd32-4509-bcf8-9fe448ef1af8",
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
            "country": "ID"
        }
    },
    "imp": [
        {
            "native": {
                "api": [
                    "1",
                    "2"
                ],
                "battr": [
                    "1",
                    "2"
                ],
                "request": "request",
                "ver": "1"
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
    "id": "YOUR_PLACEMENT_ID_HERE@29935051-bd32-4509-bcf8-9fe448ef1af8",
    "seatbid": [
        {
            "bid": [
                {
                    "id": "YOUR_PLACEMENT_ID_HERE@29935051-bd32-4509-bcf8-9fe448ef1af8",
                    "price": 0,
                    "nurl": null,
                    "adm": "{\"link\":\"https://superads-sdk-gateway.superads-staging.net/api/tracking/click?pbu=aHR0cHM6Ly9jbG91ZC10cmFjay5zdXBlcmFkcy5jbi9pbmRleC5waHA_Y2FtcD0yOCZjcmVhdGl2ZV9pZD0xNTkmYXBwX2lkPTI1JmFkX3NldF9pZD03NiZjaF9pZD0xMDY5JnVzZXJfaWQ9YWY0OWJkYzItYjYzZC00OTgwLWI3NGQtMmYzNDZlZmQ0M2Mz\",\"assets\":[{\"id\":\"1\",\"required\":1,\"data\":{\"value\":\"test\"}},{\"id\":\"2\",\"required\":1,\"title\":{\"text\":\"test\"}},{\"id\":\"3\",\"required\":1,\"image\":{\"url\":\"https://d3niwjjcw9coqg.cloudfront.net/de83293a05ea670362a728656a8f1082.png\"}},{\"id\":\"4\",\"required\":1,\"image\":{\"url\":\"http://sdksoure.s3-ap-southeast-1.amazonaws.com/a17660577836e9e1d18055dc0193a2b7.png\"}},{\"id\":\"5\",\"required\":1,\"data\":{\"value\":\"test\"}}],\"imptrackers\":[\"https://superads-sdk-gateway.superads-staging.net/api/tracking/impression?pbu=aHR0cDovL3Nka3RyYWNraW5nLnN1cGVyYWRzLmNuL3JlY29yZEltcHJlc3Npb24_Y2FtcD0yOCZjcmVhdGl2ZV9pZD0xNTkmYXBwX2lkPTI1JmFkX3NldF9pZD03NiZjaF9pZD0xMDY5JnVzZXJfaWQ9YWY0OWJkYzItYjYzZC00OTgwLWI3NGQtMmYzNDZlZmQ0M2Mz\"]}",
                    "ext": null,
                    "impid": null
                }
            ]
        }
    ]
}
```
adm：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| link     | url_xxx | click url       |
| imptrackers     | url_xxx | impression url       |

assets：
| KEY        | VALUE   |  DESCRIPTION  |
| --------   | -----:  | :----:  |
| id     | creative id, you can ignore |       |
| require     | 1 | is this asset required       |
| data     |  | Ad describtion       |
| title     |  | Ad title      |
| image     |  | id 4 image: Ad icon image, id 3 image: big image image       |

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

### 6. **impression event report url**

#### GET Request URL：https://superads-sdk-gateway.superadsprod.net/api/tracking/impression?pbu=xxxxx
#### request headers：empty
#### request body：empty
#### response: 200 OK
#### pbu is in get_xxx_ad interface response->eventsUrls->impression, which is base64 encode url.

### 7. **click url to jump**

#### GET Request URL：https://superads-sdk-gateway.superadsprod.net/api/tracking/click?pbu=xxxxx
#### request headers：empty
#### request body：empty
#### response 200 OK
#### pbu is in get_xxx_ad interface response->eventsUrls->impression, which is base64 encode url.
