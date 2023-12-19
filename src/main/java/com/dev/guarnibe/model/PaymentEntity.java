package com.dev.guarnibe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Table(name = "TB_PAYMENT")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "finished")
    private boolean finished;

    @OneToOne
    @MapsId
    private OrderEntity order;

    @Embedded
    private CreateAndUpdateEntity dateTime;

    @PrePersist
    private void initializeCreateAndUpdate(){
        this.dateTime = new CreateAndUpdateEntity();
    }

}
