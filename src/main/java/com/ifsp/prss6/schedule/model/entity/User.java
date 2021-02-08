package com.ifsp.prss6.schedule.model.entity;

import com.ifsp.prss6.schedule.model.request.UserRequest;
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
@Document(collation = "users")
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
}
