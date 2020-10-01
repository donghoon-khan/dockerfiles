package com.khan.antapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import com.khan.antapp.model.AntMediaBroadcast;
import com.khan.antapp.model.AntMediaResult;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class AntAppApplicationTests {

	@Value("${antMediaServerAddr}")
    private String antMediaServerAddr;

	private RestTemplate restTemplate;
	
	private static AntMediaBroadcast broadcast;

    @Autowired
    public AntAppApplicationTests(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
	}

	@BeforeAll
	public static void createTestBroadcast() {
		broadcast = new AntMediaBroadcast("test", "test", "rtsp://3.84.6.190/vod/mp4:BigBuckBunny_115k.mov");
	}
	
	@Test
	public void createStream() {
		URI uri = URI.create(antMediaServerAddr + "/LiveApp/rest/v2/broadcasts/create");
		ResponseEntity<AntMediaBroadcast> response = restTemplate.postForEntity(uri, broadcast, AntMediaBroadcast.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void updateStream() {

		AntMediaBroadcast updateBroadcast = 
				new AntMediaBroadcast(broadcast.getStreamId(), "test2", broadcast.getStreamUrl());
		updateBroadcast.setStatus("finished");

		URI uri = URI.create(antMediaServerAddr + "/LiveApp/rest/v2/broadcasts/" + broadcast.getStreamId());
		
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AntMediaBroadcast> httpEntity = new HttpEntity<>(updateBroadcast, httpHeaders);

		ResponseEntity<AntMediaResult> response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, AntMediaResult.class);
  		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().getSuccess());
	}

	@Test
	public void deleteStream() {
		URI uri = URI.create(antMediaServerAddr + "/LiveApp/rest/v2/broadcasts/" + broadcast.getStreamId());
		ResponseEntity<AntMediaResult> response = restTemplate.exchange(uri, HttpMethod.DELETE, null, AntMediaResult.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().getSuccess());
	}
}
