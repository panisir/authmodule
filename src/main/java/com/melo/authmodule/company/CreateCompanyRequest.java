package com.melo.authmodule.company;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateCompanyRequest {
    private String name;
    private String mqttPassword;
}