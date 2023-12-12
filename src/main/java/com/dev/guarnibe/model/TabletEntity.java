package com.dev.guarnibe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "TB_TABLET")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TabletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery")
    private int battery;

    @Column(name = "available", columnDefinition = "false")
    @Value(value = "false")
    private boolean available;


}
