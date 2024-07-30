package com.melo.authmodule.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company createCompany(CreateCompanyRequest createCompanyRequest);
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(Long id);
    Optional<Company> updateCompany(Long id, Company companyDetails);
    boolean deleteCompany(Long id);
}