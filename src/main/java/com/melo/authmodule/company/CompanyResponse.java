package com.melo.authmodule.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {

    private String name;
    private String mqttPassword;
    private UUID companyCode;
}
