package com.ifsp.prss6.schedule.model.request;

import com.ifsp.prss6.schedule.model.entity.User;
import com.ifsp.prss6.schedule.model.response.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class request of Client
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private String id;

    private String healthInsurance;

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

    public static ClientRequest fromClient(User client){
        return ClientRequest.builder()
                .id(client.get_id())
                .cpf(client.getCpf())
                .email(client.getEmail())
                .name(client.getName())
                .birthDate(client.getBirthDate())
                .email(client.getEmail())
                .healthInsurance(client.getHealthInsurance())
                .build();
    }

    public static ClientRequest fromClientResponse(ClientResponse clientResponse){
        return ClientRequest.builder()
                .id(clientResponse.getId())
                .cpf(clientResponse.getCpf())
                .email(clientResponse.getEmail())
                .name(clientResponse.getName())
                .birthDate(clientResponse.getBirthDate())
                .email(clientResponse.getEmail())
                .healthInsurance(clientResponse.getHealthInsurance())
                .build();
    }

}
