package com.melo.authmodule.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(CreateCompanyRequest createCompanyRequest) {
        Company company = new Company();
        company.setName(createCompanyRequest.getName());
        company.setMqttPassword(createCompanyRequest.getMqttPassword());
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<Company> updateCompany(Long id, Company companyDetails) {
        return companyRepository.findById(id).map(company -> {
            company.setName(companyDetails.getName());
            company.setMqttPassword(companyDetails.getMqttPassword());
            // Update other fields as needed
            return companyRepository.save(company);
        });
    }

    @Override
    public boolean deleteCompany(Long id) {
        return companyRepository.findById(id).map(company -> {
            companyRepository.delete(company);
            return true;
        }).orElse(false);
    }
}