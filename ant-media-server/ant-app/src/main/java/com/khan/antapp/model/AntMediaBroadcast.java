package com.khan.antapp.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AntMediaBroadcast {

	private String streamId;

	/**
	 * "finished", "broadcasting", "created"
	 */
	private String status;

	/**
	 * "liveStream", "ipCamera", "streamSource", "VoD"
	 */
	private String type;

	/**
	 * name of the broadcast
	 */
	private String name;

	/**
	 * description of the broadcast
	 */
    private String description;
    
	private Boolean publish = true;
	private long date;
	private long plannedStartDate;
	private long plannedEndDate;
	private long duration;
	private List<AntMediaEndpoint> endPointList;
	private Boolean publicStream = true;
	private Boolean is360 = false;
	private String listenerHookURL;
	private String category;
	private String ipAddr;
	private String username;
	private String password;
	private String quality;
	private double speed;
	private String streamUrl;
	private String originAdress;
	private int mp4Enabled = 0;
	private int webMEnabled = 0;
	private int expireDurationMS;
	private String rtmpURL;
	private Boolean zombi = false;
	private int pendingPacketSize = 0;
	private int hlsViewerCount = 0;
	private int webRTCViewerCount = 0;
	private int rtmpViewerCount = 0;
	private long startTime = 0;
	private long receivedBytes = 0;
	private long bitrate = 0;
	private String userAgent = "N/A";
	private String latitude;
	private String longitude;
	private String altitude;
	private String mainTrackStreamId;
	private List<String> subTrackStreamIds;
    private long absoluteStartTimeMs;
    
    public AntMediaBroadcast(String id, String name, String rtspUrl) {
        this.streamId = id;
        this.name = name;
        this.streamUrl = rtspUrl;
        this.type = "streamSource";
    }
}
