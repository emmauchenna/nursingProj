package com.kloudvista.nursingProj.repository;

import com.kloudvista.nursingProj.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
