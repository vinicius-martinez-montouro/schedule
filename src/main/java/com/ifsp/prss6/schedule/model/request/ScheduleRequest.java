package com.ifsp.prss6.schedule.model.request;

import com.ifsp.prss6.schedule.model.entity.Schedule;
import lombok.*;

import java.time.LocalDateTime;

import static com.ifsp.prss6.schedule.model.request.ClientRequest.fromClient;
import static com.ifsp.prss6.schedule.model.request.DoctorRequest.fromDoctor;

/**
 * @author vinicius.montouro
 * Class request of Schedule
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {

    private String id;

    private ClientRequest client;

    private DoctorRequest doctor;

    private LocalDateTime schedule;

    public static ScheduleRequest fromSchedule(Schedule schedule){
        return ScheduleRequest.builder()
                .client(schedule.getClient() != null ? fromClient(schedule.getClient()) : null)
                .doctor(schedule.getDoctor() != null ? fromDoctor(schedule.getDoctor()) : null)
                .id(schedule.get_id())
                .schedule(schedule.getSchedule())
                .build();
    }
}
