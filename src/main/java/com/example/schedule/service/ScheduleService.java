package com.example.schedule.service;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.dto.GetScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getTitle(),
                request.getContents(), request.getName(),
                request.getPassword(), request.getDate());
        Schedule saveSchedule = scheduleRepository.save(schedule);
       return new CreateScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContents(),
                saveSchedule.getName(),
                saveSchedule.getPassword(),
                saveSchedule.getDate()
        );

    }
    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정 입니다.")
        );
        return  new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getName(),
                schedule.getPassword(),
                schedule.getDate()
        );


    }
}
