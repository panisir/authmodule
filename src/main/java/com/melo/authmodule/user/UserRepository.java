package com.melo.authmodule.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  List<User> findByCompany_CompanyCode(UUID companyCode);
}
