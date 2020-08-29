package com.wns.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wns.assessment.model.CritExtnBO;
import com.wns.assessment.model.CritIdentity;

public interface MigrateRepository extends JpaRepository<CritExtnBO, CritIdentity>{

}
