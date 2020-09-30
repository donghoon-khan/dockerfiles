package com.khan.antapp.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AntMediaBroadcastResponse {
    private String streamId;
    private String status;
    private String type;
    private String name;
    private String description;
    private boolean publish;
    private long date;
    private long plannedStartDate;
    private long plannedEndDate;
    private long duration;
    private List<AntMediaEndpoint> endPointList;
    private boolean publicStream;     
    private boolean is360;
    private String listenerHookURL;
    private String category;
    private String ipAddr;
    private String username;
    private String password;
    private String quality;
    private double speed;
    private String streamUrl;
    private String originAdress;
    private int mp4Enabled;
    private int webMEnabled;
    private int expireDurationMS;
    private String rtmpURL;
    private boolean zombi;
    private int pendingPacketSize;
    private int hlsViewerCount;
    private int webRTCViewerCount;
    private int rtmpViewerCount;
    private long startTime;
    private long receivedBytes;
    private long bitrate;
    private String userAgent;
    private String latitude;
    private String longitude;
    private String altitude;
    private String mainTrackStreamId;
    private List<String> subTrackStreamIds;
    private long absoluteStartTimeMs;
}