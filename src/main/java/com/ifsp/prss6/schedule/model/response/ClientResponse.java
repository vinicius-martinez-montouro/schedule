package com.ifsp.prss6.schedule.model.response;

import com.ifsp.prss6.schedule.model.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * @author vinicius.montouro
 * Class response of Client
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private String id;

    private String healthInsurance;

    private String cpf;

    private String name;

    private LocalDate birthDate;

    private String tel;

    private String email;

    public static ClientResponse fromClient(Client client){
        return ClientResponse.builder()
                .id(client.get_id())
                .cpf(client.getCpf())
                .email(client.getEmail())
                .name(client.getName())
                .birthDate(client.getBirthDate())
                .email(client.getEmail())
                .healthInsurance(client.getHealthInsurance())
                .build();
    }
}
