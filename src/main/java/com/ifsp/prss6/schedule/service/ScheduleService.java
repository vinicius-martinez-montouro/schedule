package com.ifsp.prss6.schedule.service;

import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.request.DoctorRequest;
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
     * Search all Schedule of client
     * @param clientRequest
     * @return List of ScheduleResponse
     */
    List<ScheduleResponse> findByClient(ClientRequest clientRequest);

    /**
     * Search all Schedule of doctor
     * @param doctorRequest
     * @return List of ScheduleResponse
     */
    List<ScheduleResponse> findByDoctor(DoctorRequest doctorRequest);

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
