package com.ifsp.prss6.schedule.model.entity;

import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.response.ClientResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author vinicius.montouro
 * Class model of Client
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client extends User{

    private String healthInsurance;

    public static Client fromClientRequest(ClientRequest clientRequest){
        return Client.builder()
                ._id(clientRequest.getId())
                .cpf(clientRequest.getCpf())
                .name(clientRequest.getName())
                .birthDate(clientRequest.getBirthDate())
                .tel(clientRequest.getTel())
                .email(clientRequest.getEmail())
                .healthInsurance(clientRequest.getHealthInsurance())
                .build();
    }

    public static Client fromClientResponse(ClientResponse clientResponse){
        return Client.builder()
                ._id(clientResponse.getId())
                .cpf(clientResponse.getCpf())
                .name(clientResponse.getName())
                .birthDate(clientResponse.getBirthDate())
                .tel(clientResponse.getTel())
                .email(clientResponse.getEmail())
                .healthInsurance(clientResponse.getHealthInsurance())
                .build();
    }
}
