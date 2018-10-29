package com.salesforce.keenaspace.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

public class RestCaller {

  public static void main(String[] args) throws Exception {
    getUserEmail();
  }

  public static String getUserEmail() throws Exception {

    String targetURL = "";
    String responseBody = RestCaller.execute(targetURL);
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(responseBody);
    String accessToken = jsonNode.get("access_token").asText();
    String serviceResponse = RestCaller.getUserDetails(
            jsonNode.get("instance_url").asText() + "/services/apexrest/getLoggedInUserDetails",
            accessToken);
    objectMapper = new ObjectMapper();
    jsonNode = objectMapper.readTree(serviceResponse);
    return jsonNode.get("Email").asText();
  }

  public static String execute(String targetURL) {
    HttpHeaders headers = new HttpHeaders();
    //    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

    HttpEntity<MultiValueMap<String, String>> entity =
        new HttpEntity<MultiValueMap<String, String>>(map, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.postForEntity(targetURL, entity, String.class);
    return response.getBody();
  }

  public static String getUserDetails(String url, String accessToken) throws URISyntaxException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Authorization", "Bearer " + accessToken);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    HttpEntity<MultiValueMap<String, String>> entity =
        new HttpEntity<MultiValueMap<String, String>>(map, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity =
        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    return responseEntity.getBody();
  }
}
