package com.safety.officemanagement.controllers;

import com.safety.officemanagement.models.Office;
import com.safety.officemanagement.models.SafetyInstruction;
import com.safety.officemanagement.services.OfficeService;
import com.safety.officemanagement.services.SafetyInstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @GetMapping("/offices")
    public String offices(Model model) {
        model.addAttribute("offices", officeService.listOffices());
        return "offices";
    }

    @GetMapping("/offices/{id}")
    public String officeInfo(@PathVariable Long id, Model model) {
        Office office = officeService.getOfficeById(id);
        if (office != null) {
            List<SafetyInstruction> safetyInstructions = safetyInstructionService.getSafetyInstructionsByOfficeId(id);
            model.addAttribute("office", office);
            model.addAttribute("safetyInstructions", safetyInstructions);
            return "office-info";
        }
        return "redirect:/offices";
    }

    @PostMapping("/offices/delete/{id}")
    public String deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
        return "redirect:/offices";
    }

    @Autowired
    private SafetyInstructionService safetyInstructionService;

    @PostMapping("/offices/create")
    public String createOffice(Office office) {
        officeService.addOffice(office);
        return "redirect:/offices";
    }

    @PostMapping("/offices/{id}/add-safety-instructions")
    public String addSafetyInstructionsToOffice(@PathVariable Long id, @RequestParam List<Long> safetyInstructionsIds) {
        officeService.addSafetyInstructionsToOffice(id, safetyInstructionsIds);
        return "redirect:/offices/" + id;
    }

}
