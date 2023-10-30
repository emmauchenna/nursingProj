package com.kloudvista.nursingProj.repository;

import com.kloudvista.nursingProj.domain.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    Nurse findByEmail(String email);

}
