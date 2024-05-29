package com.safety.officemanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity
@Table(name = "office_news_Tkachyshchen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

