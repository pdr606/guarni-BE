package com.dev.guarnibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Table(name = "TB_TABLE")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "column", nullable = false)
    private Integer number;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "uses_count", nullable = true, columnDefinition = "0")
    @Value(value = "0")
    private Integer uses;
}
