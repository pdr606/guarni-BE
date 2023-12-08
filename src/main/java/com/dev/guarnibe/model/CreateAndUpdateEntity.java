package com.dev.guarnibe.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateAndUpdateEntity {

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updated;

    @CreatedDate
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created_at")
    private LocalDateTime created;

    @PrePersist
    private void setCreated(){
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    private void setUpdated(){
        this.updated = LocalDateTime.now();
    }
}
