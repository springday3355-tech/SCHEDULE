package com.example.schedule.controller;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.dto.GetScheduleResponse;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/memos")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));

    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOneSchedule(@PathVariable Long scheduleId){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));

    }

}
