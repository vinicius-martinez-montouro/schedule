package com.ifsp.prss6.schedule.model.entity;

import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.request.DoctorRequest;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.ClientResponse;
import com.ifsp.prss6.schedule.model.response.DoctorResponse;
import com.ifsp.prss6.schedule.model.response.UserResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class model of User
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class User {
    @Id
    private String _id;

    @Indexed
    @EqualsAndHashCode.Include
    private String cpf;

    private String name;

    private LocalDate birthDate;

    private String tel;

    private String email;

    private String healthInsurance;

    private String performanceArea;

    private String additionalInformation;

    public static User fromUserRequest(UserRequest userRequest){
        return User.builder()
                ._id(userRequest.getId())
                .cpf(userRequest.getCpf())
                .name(userRequest.getName())
                .birthDate(userRequest.getBirthDate())
                .tel(userRequest.getTel())
                .email(userRequest.getEmail())
                .build();
    }

    public static User fromUserResponse(UserResponse userResponse){
        return User.builder()
                ._id(userResponse.getId())
                .cpf(userResponse.getCpf())
                .name(userResponse.getName())
                .birthDate(userResponse.getBirthDate())
                .tel(userResponse.getTel())
                .email(userResponse.getEmail())
                .build();
    }

    public static User fromUserRequest(ClientRequest clientRequest){
        return User.builder()
                ._id(clientRequest.getId())
                .cpf(clientRequest.getCpf())
                .name(clientRequest.getName())
                .birthDate(clientRequest.getBirthDate())
                .tel(clientRequest.getTel())
                .email(clientRequest.getEmail())
                .healthInsurance(clientRequest.getHealthInsurance())
                .build();
    }

    public static User fromUserResponse(ClientResponse clientResponse){
        return User.builder()
                ._id(clientResponse.getId())
                .cpf(clientResponse.getCpf())
                .name(clientResponse.getName())
                .birthDate(clientResponse.getBirthDate())
                .tel(clientResponse.getTel())
                .email(clientResponse.getEmail())
                .healthInsurance(clientResponse.getHealthInsurance())
                .build();
    }


    public static User fromUserRequest(DoctorRequest doctorRequest){
        return User.builder()
                ._id(doctorRequest.getId())
                .cpf(doctorRequest.getCpf())
                .name(doctorRequest.getName())
                .birthDate(doctorRequest.getBirthDate())
                .tel(doctorRequest.getTel())
                .email(doctorRequest.getEmail())
                .additionalInformation(doctorRequest.getAdditionalInformation())
                .performanceArea(doctorRequest.getPerformanceArea())
                .build();
    }

    public static User fromUserResponse(DoctorResponse doctorResponse){
        return User.builder()
                ._id(doctorResponse.getId())
                .cpf(doctorResponse.getCpf())
                .name(doctorResponse.getName())
                .birthDate(doctorResponse.getBirthDate())
                .tel(doctorResponse.getTel())
                .email(doctorResponse.getEmail())
                .additionalInformation(doctorResponse.getAdditionalInformation())
                .performanceArea(doctorResponse.getPerformanceArea())
                .build();
    }

}
