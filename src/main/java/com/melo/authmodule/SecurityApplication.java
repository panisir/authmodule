package com.melo.authmodule;

import com.melo.authmodule.auth.AuthenticationService;
import com.melo.authmodule.auth.RegisterRequest;
import com.melo.authmodule.company.Company;
import com.melo.authmodule.company.CompanyService;
import com.melo.authmodule.company.CreateCompanyRequest;
import com.melo.authmodule.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service,
            CompanyService companyService
    ) {
        return args -> {

            var company = CreateCompanyRequest.builder()
                    .name("DataSentor")
                    .mqttPassword("123456")
                    .build();
            Company companyEnt = companyService.createCompany(company);
            System.out.println("Company token: " + companyEnt);

            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .company(companyEnt)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .company(companyEnt)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }
}
