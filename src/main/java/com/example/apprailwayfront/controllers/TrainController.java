package com.example.apprailwayfront.controllers;

import com.example.apprailwayfront.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.schedule.ScheduleResponseDto;
import uz.pdp.model.train.TrainCreatedto;
import uz.pdp.model.train.TrainResponseDto;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @PostMapping("add")
    public String addTrain(@ModelAttribute TrainCreatedto trainCreatedto) {
        ApiResponse apiResponse = trainService.addTrain(trainCreatedto);
        return null;
    }

    @GetMapping("get/list")
    public String getTrains(Model model) {
        ApiResponse apiResponse = trainService.getTrains();
        List<TrainResponseDto> trains =(List<TrainResponseDto>) apiResponse.getData();
        model.addAttribute("status",apiResponse.getStatusCode());
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("trainList",trains);
        return null;
    }
}