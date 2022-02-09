package com.example.springsecurityasm.entity;

import com.example.springsecurityasm.StreetStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate createdAt;
    private String description;
    private StreetStatus status;

    @Column(name = "district_id")
    private Integer district_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    private District district;

    public Street(String name, LocalDate createdAt, String description, StreetStatus status, Integer district_id) {
        this.name = name;
        this.createdAt = createdAt;
        this.description = description;
        this.status = status;
        this.district_id = district_id;
    }
}
