package com.ifsp.prss6.schedule.model.entity;

import com.ifsp.prss6.schedule.model.request.ScheduleRequest;
import com.ifsp.prss6.schedule.model.response.ScheduleResponse;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static com.ifsp.prss6.schedule.model.entity.User.fromUserRequest;
import static com.ifsp.prss6.schedule.model.entity.User.fromUserResponse;

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

    private User client;

    private User doctor;

    private LocalDateTime schedule;

    public static Schedule fromScheduleRequest(ScheduleRequest scheduleRequest){
        return Schedule.builder()
                ._id(scheduleRequest.getId())
                .client(fromUserRequest(scheduleRequest.getClient()))
                .doctor(fromUserRequest(scheduleRequest.getDoctor()))
                .schedule(scheduleRequest.getSchedule())
                .build();
    }

    public static Schedule fromScheduleResponse(ScheduleResponse scheduleResponse){
        return Schedule.builder()
                ._id(scheduleResponse.getId())
                .client(fromUserResponse(scheduleResponse.getClient()))
                .doctor(fromUserResponse(scheduleResponse.getDoctor()))
                .schedule(scheduleResponse.getSchedule())
                .build();
    }

}
