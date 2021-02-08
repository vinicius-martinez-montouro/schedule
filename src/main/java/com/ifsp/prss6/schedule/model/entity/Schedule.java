package com.ifsp.prss6.schedule.model.entity;

import com.ifsp.prss6.schedule.model.request.ScheduleRequest;
import com.ifsp.prss6.schedule.model.response.ScheduleResponse;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static com.ifsp.prss6.schedule.model.entity.Client.fromClientRequest;
import static com.ifsp.prss6.schedule.model.entity.Client.fromClientResponse;
import static com.ifsp.prss6.schedule.model.entity.Doctor.fromDoctorRequest;
import static com.ifsp.prss6.schedule.model.entity.Doctor.fromDoctorResponse;

/**
 * @author vinicius.montouro
 * Class model of Schedule
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Schedule {

    @Id
    private String _id;

    private Client client;

    private Doctor doctor;

    private LocalDateTime schedule;

    public static Schedule fromScheduleRequest(ScheduleRequest scheduleRequest){
        return Schedule.builder()
                ._id(scheduleRequest.getId())
                .client(fromClientRequest(scheduleRequest.getClient()))
                .doctor(fromDoctorRequest(scheduleRequest.getDoctor()))
                .schedule(scheduleRequest.getSchedule())
                .build();
    }

    public static Schedule fromScheduleResponse(ScheduleResponse scheduleResponse){
        return Schedule.builder()
                ._id(scheduleResponse.getId())
                .client(fromClientResponse(scheduleResponse.getClient()))
                .doctor(fromDoctorResponse(scheduleResponse.getDoctor()))
                .schedule(scheduleResponse.getSchedule())
                .build();
    }

}
