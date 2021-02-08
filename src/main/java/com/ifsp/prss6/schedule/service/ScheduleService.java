package com.ifsp.prss6.schedule.service;

import com.ifsp.prss6.schedule.model.request.ScheduleRequest;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.ScheduleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author vinicius.montouro
 */
public interface ScheduleService {
    /**
     * Search all schedule
     * @return List of ScheduleResponse
     */
    List<ScheduleResponse> findAll();

    /**
     * Search all schedule pageable
     * @param pageable
     * @return Page of Schedule Response
     */
    Page<ScheduleResponse> findAllPageable(Pageable pageable);

    /**
     * Serach Schedule by id
     * @param id
     * @return ScheduleResponse
     */
    ScheduleResponse findById(String id);

    /**
     * Search all Schedule of user
     * @param userRequest
     * @return List of ScheduleResponse
     */
    List<ScheduleResponse> findByUser(UserRequest userRequest);
    /**
     * Search all Schedule of user id
     * @param userRequest
     * @return List of ScheduleResponse
     */
    List<ScheduleResponse> findByUserId(String userId);

    /**
     * Save new Schedule
     * @param scheduleRequest
     */
    void save(ScheduleRequest scheduleRequest);
    /**
     * Update Schedule
     * @param scheduleRequest
     */
    void update(ScheduleRequest scheduleRequest);
    /**
     * Delete Schedule
     * @param id
     */
    void delete(String id);
}
