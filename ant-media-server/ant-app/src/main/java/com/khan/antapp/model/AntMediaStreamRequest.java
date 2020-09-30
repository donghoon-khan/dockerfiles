package com.khan.antapp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AntMediaStreamRequest {

    private String streamId;
    private String name;
    private String type;
    private String streamUrl;    
}
