package com.safety.officemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safety.officemanagement.models.SafetyInstruction;

import java.util.List;


@Repository
public interface SafetyInstructionRepository extends JpaRepository<SafetyInstruction, Long> {
    List<SafetyInstruction> findByOfficeId(Long officeId);
}
