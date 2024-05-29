package com.safety.officemanagement.controllers;

import com.safety.officemanagement.models.SafetyInstruction;
import com.safety.officemanagement.services.SafetyInstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SafetyInstructionController {
    private final SafetyInstructionService safetyInstructionService;

    @GetMapping("/safety-instructions")
    public String listSafetyInstructions(Model model) {
        model.addAttribute("safetyInstructions", safetyInstructionService.listSafetyInstructions());
        return "safetyInstructions";
    }
    @GetMapping("/safety-instructions/all")
    public String listAllSafetyInstructions(Model model) {
        model.addAttribute("allSafetyInstructions", safetyInstructionService.listSafetyInstructions());
        return "safety-instructions-list";
    }
    @PostMapping("/safety-instructions")
    public String createSafetyInstruction(SafetyInstruction safetyInstruction) {
        safetyInstructionService.addSafetyInstruction(safetyInstruction);
        return "redirect:/safety-instructions";
    }

    @PostMapping("/safety-instructions/delete/{id}")
    public String deleteSafetyInstruction(@PathVariable("id") Long id) {
        safetyInstructionService.deleteSafetyInstruction(id);
        return "redirect:/safety-instructions";
    }
}