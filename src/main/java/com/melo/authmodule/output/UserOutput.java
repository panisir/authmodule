package com.melo.authmodule.output;

import com.melo.authmodule.user.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserOutput {
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private UUID companyCode;


    public static List<UserOutput> from(List<User> users) {
        List<UserOutput> userOutputs = new ArrayList<>();
        for (User user : users) {
            userOutputs.add(UserOutput.builder()
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .role(user.getRole().name())
                    .companyCode(user.getCompany().getCompanyCode())
                    .build());
        }
        return userOutputs;
    }

    public static UserOutput from(User user) {
        return UserOutput.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole().name())
                .companyCode(user.getCompany().getCompanyCode())
                .build();
    }
}
