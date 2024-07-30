package com.melo.authmodule.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody CreateCompanyRequest createCompanyRequest) {
        Company company = companyService.createCompany(createCompanyRequest);
        CompanyResponse response = mapToCompanyResponse(company);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyResponse> responses = companies.stream()
                .map(this::mapToCompanyResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id)
                .map(this::mapToCompanyResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private CompanyResponse mapToCompanyResponse(Company company) {
        return new CompanyResponse(company.getName(), company.getMqttPassword(), company.getCompanyCode());
    }
}