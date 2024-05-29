package com.safety.officemanagement.services;

import com.safety.officemanagement.models.Office;
import com.safety.officemanagement.models.SafetyInstruction;
import com.safety.officemanagement.repository.OfficeRepository;
import com.safety.officemanagement.repository.SafetyInstructionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final SafetyInstructionRepository safetyInstructionRepository;
    private final SafetyInstructionService safetyInstructionService;

    public void addOffice(Office office) {
        officeRepository.save(office);
    }

    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElse(null);
    }

    public void addSafetyInstructionsToOffice(Long officeId, List<Long> safetyInstructionsIds) {
        Office office = officeRepository.findById(officeId).orElse(null);
        if (office != null) {
            List<SafetyInstruction> safetyInstructions = new ArrayList<>();
            for (Long instructionId : safetyInstructionsIds) {
                SafetyInstruction instruction = safetyInstructionService.getSafetyInstructionById(instructionId);
                if (instruction != null) {
                    safetyInstructions.add(instruction);
                }
            }
            office.setSafetyInstructions(safetyInstructions);
            officeRepository.save(office);
        }
    }


    public List<Office> listOffices() {
        return officeRepository.findAll();
    }
}