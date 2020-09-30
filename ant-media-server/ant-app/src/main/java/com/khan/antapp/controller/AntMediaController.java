package com.khan.antapp.controller;

import com.khan.antapp.model.AntMediaBroadcastResponse;
import com.khan.antapp.model.AntMediaStreamRequest;
import com.khan.antapp.service.AntMediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AntMediaController {

    @Autowired
    private AntMediaService antMediaService;

    @GetMapping("/create")
    public ResponseEntity<AntMediaBroadcastResponse> createMediaStream(
                @RequestParam(required = true, value = "streamId")String streamId,
                @RequestParam(required = true, value = "streamName")String streamName,
                @RequestParam(required = true, value = "streamUrl")String streamUrl) {
        
        return ResponseEntity.ok().body(
            antMediaService.createStream(AntMediaStreamRequest.builder()
                    .streamId(streamId)
                    .name(streamName)
                    .type("streamSource")
                    .streamUrl(streamUrl)
                    .build())
        );
    }
}
