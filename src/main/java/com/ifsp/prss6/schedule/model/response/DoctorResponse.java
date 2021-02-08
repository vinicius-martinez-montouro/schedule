package com.ifsp.prss6.schedule.model.response;

import com.ifsp.prss6.schedule.model.entity.Doctor;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class response of Doctor
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {

    private String id;

    private String performanceArea;

    private String additionalInformation;

    private String cpf;

    private String name;

    private LocalDate birthDate;

    private String tel;

    private String email;

    public static DoctorResponse fromDoctor(Doctor doctor){
        return DoctorResponse.builder()
                .id(doctor.get_id())
                .cpf(doctor.getCpf())
                .email(doctor.getEmail())
                .name(doctor.getName())
                .birthDate(doctor.getBirthDate())
                .email(doctor.getEmail())
                .additionalInformation(doctor.getAdditionalInformation())
                .performanceArea(doctor.getPerformanceArea())
                .build();
    }
}
