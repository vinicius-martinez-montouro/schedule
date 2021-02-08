package com.ifsp.prss6.schedule.service.impl;

import com.ifsp.prss6.schedule.exception.BadRequestException;
import com.ifsp.prss6.schedule.exception.PreconditionException;
import com.ifsp.prss6.schedule.model.entity.Schedule;
import com.ifsp.prss6.schedule.model.request.ScheduleRequest;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.ScheduleResponse;
import com.ifsp.prss6.schedule.repository.ScheduleRepository;
import com.ifsp.prss6.schedule.service.ScheduleService;
import com.ifsp.prss6.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ifsp.prss6.schedule.model.entity.Schedule.fromScheduleRequest;
import static com.ifsp.prss6.schedule.model.entity.Schedule.fromScheduleResponse;
import static com.ifsp.prss6.schedule.model.entity.User.fromUserRequest;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

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
    public List<ScheduleResponse> findByUser(UserRequest userRequest) {
        userService.findById(userRequest.getId());
        return scheduleRepository.findByUser(fromUserRequest(userRequest))
                .stream()
                .map(ScheduleResponse::fromSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleResponse> findByUserId(String userId) {
        userService.findById(userId);
        return scheduleRepository.findByUserId(userId)
                .stream()
                .map(ScheduleResponse::fromSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public void save(ScheduleRequest scheduleRequest) {
        scheduleRequest.setId(null);
        scheduleRepository.save(fromScheduleRequest(scheduleRequest));
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
