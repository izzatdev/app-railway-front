package com.example.apprailwayfront.service;

import com.example.apprailwayfront.utils.URLS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.train.TrainCreatedto;

@Service
@RequiredArgsConstructor
public class TrainService implements URLS {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final Gson gson;

    public ApiResponse addTrain(TrainCreatedto trainCreatedto) {

        String response = restTemplate.postForObject(BASE_URL + ADD_TRAIN_URL, trainCreatedto, String.class);
        try {
            return objectMapper.readValue(response, ApiResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ApiResponse getTrains() {
        String response = restTemplate.getForObject(BASE_URL + GET_TRAINS_URL, String.class);
       try {
           return gson.fromJson(response,ApiResponse.class);
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }
}