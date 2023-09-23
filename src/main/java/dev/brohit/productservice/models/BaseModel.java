package dev.brohit.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private UUID id;

    @LastModifiedDate
    @ColumnDefault("CURRENT_TIMESTAMP")
    LocalDateTime updatedAt;

    @CreatedDate
    @ColumnDefault("CURRENT_TIMESTAMP")
    LocalDateTime createdAt;

}
