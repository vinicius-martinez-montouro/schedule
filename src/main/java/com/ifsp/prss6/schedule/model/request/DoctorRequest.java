package com.ifsp.prss6.schedule.model.request;

import com.ifsp.prss6.schedule.model.entity.User;
import com.ifsp.prss6.schedule.model.response.DoctorResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class request of Doctor
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {

    private String id;

    @NotBlank(message = "Performance area can't be white")
    private String performanceArea;

    private String additionalInformation;

    @EqualsAndHashCode.Include
    private String cpf;

    @NotBlank(message = "Name can't be white")
    private String name;

    @NotBlank(message = "Birth date can't be white")
    private LocalDate birthDate;

    @NotBlank(message = "Tel can't be white")
    private String tel;

    @Email
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0=9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email"
    )
    private String email;

    public static DoctorRequest fromDoctor(User doctor){
        return DoctorRequest.builder()
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

    public static DoctorRequest fromDoctorResponse(DoctorResponse doctorResponse){
        return DoctorRequest.builder()
                .id(doctorResponse.getId())
                .cpf(doctorResponse.getCpf())
                .email(doctorResponse.getEmail())
                .name(doctorResponse.getName())
                .birthDate(doctorResponse.getBirthDate())
                .email(doctorResponse.getEmail())
                .additionalInformation(doctorResponse.getAdditionalInformation())
                .performanceArea(doctorResponse.getPerformanceArea())
                .build();
    }

}
