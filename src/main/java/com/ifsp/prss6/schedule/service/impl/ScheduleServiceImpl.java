package com.ifsp.prss6.schedule.service.impl;

import com.ifsp.prss6.schedule.exception.BadRequestException;
import com.ifsp.prss6.schedule.exception.PreconditionException;
import com.ifsp.prss6.schedule.model.entity.Schedule;
import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.request.DoctorRequest;
import com.ifsp.prss6.schedule.model.request.ScheduleRequest;
import com.ifsp.prss6.schedule.model.response.ScheduleResponse;
import com.ifsp.prss6.schedule.repository.ScheduleRepository;
import com.ifsp.prss6.schedule.service.ScheduleService;
import com.ifsp.prss6.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.ifsp.prss6.schedule.model.entity.Schedule.fromScheduleRequest;
import static com.ifsp.prss6.schedule.model.entity.Schedule.fromScheduleResponse;
import static com.ifsp.prss6.schedule.model.entity.User.fromUserRequest;
import static com.ifsp.prss6.schedule.model.request.ClientRequest.fromClientResponse;
import static com.ifsp.prss6.schedule.model.request.DoctorRequest.fromDoctorResponse;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;
    private static final int MINUTES_MEDICAL_APPOINTMENT = 15;

    @Override
    public List<ScheduleResponse> findAll() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleResponse::fromSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ScheduleResponse> findAllPageable(Pageable pageable) {
        return scheduleRepository.findAll(pageable).map(ScheduleResponse::fromSchedule);
    }

    @Override
    public ScheduleResponse findById(String id) {
        return scheduleRepository.findById(id).map(ScheduleResponse::fromSchedule)
                .orElseThrow(() -> new BadRequestException("Schedule not found"));
    }

    @Override
    public List<ScheduleResponse> findByClient(ClientRequest clientRequest) {
        userService.findById(clientRequest.getId());
        return scheduleRepository.findByClient(fromUserRequest(clientRequest))
                .stream()
                .map(ScheduleResponse::fromSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleResponse> findByDoctor(DoctorRequest doctorRequest) {
        userService.findById(doctorRequest.getId());
        return scheduleRepository.findByDoctor(fromUserRequest(doctorRequest))
                .stream()
                .map(ScheduleResponse::fromSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public void save(ScheduleRequest scheduleRequest) {
        existClientAndDoctor(scheduleRequest);
        scheduleRequest.setId(null);
        scheduleRepository.save(fromScheduleRequest(scheduleRequest));
    }

    private void existClientAndDoctor(ScheduleRequest scheduleRequest){
        scheduleRequest.setClient(fromClientResponse(userService.findClientById(scheduleRequest.getClient().getId())));
        scheduleRequest.setDoctor(fromDoctorResponse(userService.findDoctorById(scheduleRequest.getDoctor().getId())));
    }

    @Override
    public void update(ScheduleRequest scheduleRequest) {
        if(scheduleRequest.getId() == null)
            throw new PreconditionException("Id schedule invalid");
        ScheduleResponse scheduleSave = findById(scheduleRequest.getId());
        Schedule scheduleUpdate = fromScheduleRequest(scheduleRequest);
        scheduleUpdate.set_id(scheduleSave.getId());
        scheduleRepository.save(scheduleUpdate);
    }

    @Override
    public void delete(String id) {
        scheduleRepository.delete(fromScheduleResponse(findById(id)));
    }
}
