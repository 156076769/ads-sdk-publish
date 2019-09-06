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