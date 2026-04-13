package com.example.schedule.service;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getTitle(),
                request.getContents(), request.getName(),
                request.getPassword());
        Schedule saveSchedule = scheduleRepository.save(schedule);
       return new CreateScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContents(),
                saveSchedule.getName(),
                saveSchedule.getPassword()
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
                schedule.getCreatedAt(),
                schedule.getUpdateAt()
        );


    }
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<GetScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getUpdateAt()
            );
            dtos.add(dto);
        }
        return  dtos;

    }
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(Long.valueOf(scheduleId)).orElseThrow(
                () -> new IllegalStateException("없는 일정 입니다.")
        );
        schedule.updateTitle(request.getTitle());
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getName()
        );




    }
    @Transactional
    public void delete(Long scheduleId, String password) {
        // 1. 일정 조회
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정 입니다.")
        );

        // 2. 비밀번호 검증(DB에 저장된것과 입력받는것)
        if (!schedule.getPassword().equals(password)){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        // 3. 일치하면 삭제
        scheduleRepository.delete(schedule);
    }
    
    
    }
