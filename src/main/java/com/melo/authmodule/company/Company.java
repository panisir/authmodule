package com.melo.authmodule.company;

import com.melo.authmodule.base.BaseEntity;
import com.melo.authmodule.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "mqtt_password")
    private String mqttPassword;

    @Column(name = "company_code", updatable = false, unique = true)
    private UUID companyCode;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<User> users;

    @Override
    protected void prePersist() {
        super.prePersist();
        if (companyCode == null) {
            companyCode = UUID.randomUUID();
        }
    }
}
