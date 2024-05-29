package com.safety.officemanagement.services;

import com.safety.officemanagement.models.SafetyInstruction;
import com.safety.officemanagement.repository.SafetyInstructionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SafetyInstructionService {

    private final SafetyInstructionRepository safetyInstructionRepository;

    public void addSafetyInstruction(SafetyInstruction safetyInstruction) {
        safetyInstructionRepository.save(safetyInstruction);
    }

    public void deleteSafetyInstruction(Long id) {
        safetyInstructionRepository.deleteById(id);
    }

    public SafetyInstruction getSafetyInstructionById(Long id) {
        return safetyInstructionRepository.findById(id).orElse(null);
    }
    public List<SafetyInstruction> getSafetyInstructionsByOfficeId(Long officeId) {
        return safetyInstructionRepository.findByOfficeId(officeId);
    }
    public List<SafetyInstruction> listSafetyInstructions() {
        return safetyInstructionRepository.findAll();
    }
}