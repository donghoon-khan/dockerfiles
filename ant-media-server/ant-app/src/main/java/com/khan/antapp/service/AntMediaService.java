package com.khan.antapp.service;

import com.khan.antapp.model.AntMediaBroadcastResponse;
import com.khan.antapp.model.AntMediaStreamRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AntMediaService {
    
    @Value("${antMediaServerAddr}")
    private String antMediaServerAddr;

    private RestTemplate restTemplate;

    @Autowired
    public AntMediaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AntMediaBroadcastResponse createStream(AntMediaStreamRequest streamRequest) {
        String url = antMediaServerAddr + "/LiveApp/rest/v2/broadcasts/create";

        return restTemplate.postForObject(url, streamRequest, AntMediaBroadcastResponse.class);
    }
}
