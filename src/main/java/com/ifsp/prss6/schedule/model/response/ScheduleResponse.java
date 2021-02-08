package com.ifsp.prss6.schedule.model.response;

import com.ifsp.prss6.schedule.model.entity.Schedule;
import lombok.*;

import java.time.LocalDateTime;

import static com.ifsp.prss6.schedule.model.response.ClientResponse.fromClient;
import static com.ifsp.prss6.schedule.model.response.DoctorResponse.fromDoctor;

/**
 * @author vinicius.montouro
 * Class response of Schedule
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {

    private String id;

    private ClientResponse client;

    private DoctorResponse doctor;

    private LocalDateTime schedule;

    public static ScheduleResponse fromSchedule(Schedule schedule){
        return ScheduleResponse.builder()
                .client(schedule.getClient() != null ? fromClient(schedule.getClient()) : null)
                .doctor(schedule.getDoctor() != null ? fromDoctor(schedule.getDoctor()) : null)
                .id(schedule.get_id())
                .schedule(schedule.getSchedule())
                .build();
    }

}
