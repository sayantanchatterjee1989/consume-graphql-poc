package com.graphql.utility;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GitUtilityTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenRecordExists_whenInfoIsRetrieved_then200IsReceived()
			throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet("https://api.github.com/repos/sayantanchatterjee1989/TollManagement/pulls?state=all");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test
	public void givenRecordDoesNotExists_whenInfoIsRetrieved_then404IsReceived()
			throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet("https://api.github.com/repos/sayantanchatterjee/TollManagement/pulls?state=all");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
	}
}
