package com.ifsp.prss6.schedule.model.request;

import com.ifsp.prss6.schedule.model.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class request of User
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {

    private String id;

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

    public static UserRequest fromUser(User user){
        return UserRequest.builder()
                .id(user.get_id())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .name(user.getName())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .build();
    }
}
