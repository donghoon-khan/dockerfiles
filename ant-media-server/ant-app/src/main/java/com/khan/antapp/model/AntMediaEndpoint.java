package com.khan.antapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AntMediaEndpoint {
    
	/* Service name like facebook, periscope, youtube or generic */
	private String type;

	private String broadcastId;
	private String streamId;
	private String rtmpUrl;
	private String name;
	private String endpointServiceId;
	private String serverStreamId;
}
