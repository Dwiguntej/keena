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

    String urlParameters =
        "?grant_type=password&client_id=3MVG9d3kx8wbPieF4xQoFOpXR2aRGDhd4WfEPWC3slu5il.H1ZJc5LuxDD_vpajQ2IiYdR.X3d3XdZrhcXaP5&client_secret=4868920179566624296&username=rnemani@salesforce.com.fy19hack1&password=$HackathonWork123";
    String responseBody =
        RestCaller.execute("https://test.salesforce.com/services/oauth2/token", urlParameters);
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(responseBody);
    String accessToken = jsonNode.get("access_token").asText();
    String serviceResponse =
        RestCaller.getUserDetails(
            jsonNode.get("instance_url").asText() + "/services/apexrest/getLoggedInUserDetails",
            accessToken,
            urlParameters);
      objectMapper = new ObjectMapper();
      jsonNode = objectMapper.readTree(responseBody);
      return jsonNode.get("Email").asText();
  }

  public static String execute(String targetURL, String urlParameters) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

    HttpEntity<MultiValueMap<String, String>> entity =
        new HttpEntity<MultiValueMap<String, String>>(map, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response =
        restTemplate.postForEntity(targetURL + urlParameters, entity, String.class);
    return response.getBody();
  }

  public static String getUserDetails(String url, String accessToken, String urlParams)
      throws URISyntaxException {
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
