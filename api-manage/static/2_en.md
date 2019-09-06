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