# XCode command cheat sheet

- https://medium.com/@ankitkumargupta/ios-simulator-command-line-tricks-ee58054d30f4
- https://www.iosdev.recipes/simctl/
- https://sarunw.com/posts/take-screenshot-and-record-video-in-ios-simulator/
- https://medium.com/xcblog/simctl-control-ios-simulators-from-command-line-78b9006a20dc

### Simulator: List all / Boot / 

```
xcrun simctl list --json
xcrun simctl boot 12F3C6FB-1A8A-4D20-922F-2DB485F58F0F
```

### Record Video / Capture Screenshot

```
xcrun simctl io booted recordVideo — type=mp4 ./test.mp4
// Press Ctrl+C to stop recording
xcrun simctl io booted screenshot ./screen.png
```

### **Open URL in simulator [Deeplinks/URL scheme]**

```
xcrun simctl openurl booted https://google.com
xcrun simctl openurl booted myapp://
```

### Add media file to photos app

```
xcrun simctl addmedia booted ./myVideo.mp4
xcrun simctl addmedia booted ./myImage.png
```

###  Find the app container

```
xcrun simctl get_app_container booted com.bundle.identifier
```

### Stream simulator logs

This command will save the output in test.log file and open mac console app to view log stream

```
xcrun simctl spawn booted log stream > test.log
open test.log
```

```
xcrun simctl spawn booted log stream --style=json
```

Filter log

```
xcrun simctl spawn booted log stream --predicate 'eventMessage contains "com.itkan.awesome"'
```

### Push Notification

```
xcrun simctl push <device> <bundle-identifier> <path-to-apns-file>
Ex:
xcrun simctl push 630C50A1-1BE5-4BED-BD32-AF0D85C00498 com.sarunw.example-xcode-11-4 payload.apns
```

##### payload.apns

```json
{
    "aps" : {
        "alert" : {
            "title" : "sarunw.com",
            "body" : "A weekly blog about iOS development"
        },
        "badge" : 5
    }
}
```

### Erase 

```
xcrun simctl erase <device UDID>
xcrun simctl erase all
```

