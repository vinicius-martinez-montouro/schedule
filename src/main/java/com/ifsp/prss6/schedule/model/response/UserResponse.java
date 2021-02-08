package com.ifsp.prss6.schedule.model.response;

import com.ifsp.prss6.schedule.model.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class response of User
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserResponse {
    private String id;

    private String cpf;

    private String name;

    private LocalDate birthDate;

    private String tel;

    private String email;

    public static UserResponse fromUser(User user){
        return UserResponse.builder()
                .id(user.get_id())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .name(user.getName())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .build();
    }
}
