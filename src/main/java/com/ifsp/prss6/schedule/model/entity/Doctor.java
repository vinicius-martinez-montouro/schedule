package com.ifsp.prss6.schedule.model.entity;

import com.ifsp.prss6.schedule.model.request.DoctorRequest;
import com.ifsp.prss6.schedule.model.response.DoctorResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author vinicius.montouro
 * Class model of Doctor
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Doctor extends User{

    private String performanceArea;

    private String additionalInformation;

    public static Doctor fromDoctorRequest(DoctorRequest doctorRequest){
        return Doctor.builder()
                ._id(doctorRequest.getId())
                .cpf(doctorRequest.getCpf())
                .name(doctorRequest.getName())
                .birthDate(doctorRequest.getBirthDate())
                .tel(doctorRequest.getTel())
                .email(doctorRequest.getEmail())
                .performanceArea(doctorRequest.getPerformanceArea())
                .additionalInformation(doctorRequest.getAdditionalInformation())
                .build();
    }

    public static Doctor fromDoctorResponse(DoctorResponse doctorResponse){
        return Doctor.builder()
                ._id(doctorResponse.getId())
                .cpf(doctorResponse.getCpf())
                .name(doctorResponse.getName())
                .birthDate(doctorResponse.getBirthDate())
                .tel(doctorResponse.getTel())
                .email(doctorResponse.getEmail())
                .performanceArea(doctorResponse.getPerformanceArea())
                .additionalInformation(doctorResponse.getAdditionalInformation())
                .build();
    }

}
