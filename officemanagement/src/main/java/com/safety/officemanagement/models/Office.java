package com.safety.officemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "office_Tkachyshchen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "room_number", nullable = false, length = 10)
    private String roomNumber;

    @ElementCollection
    @Column(name = "safety_instruction", columnDefinition = "text")
    private List<SafetyInstruction> safetyInstructions = new ArrayList<>();

    @Column(name = "responsible_person", nullable = false, length = 100)
    private String responsiblePerson;

}




