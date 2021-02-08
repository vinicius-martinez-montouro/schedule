package com.ifsp.prss6.schedule.model.request;

import com.ifsp.prss6.schedule.model.entity.Doctor;
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

    public static DoctorRequest fromDoctor(Doctor doctor){
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

}
