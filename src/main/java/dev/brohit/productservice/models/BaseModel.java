package dev.brohit.productservice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private UUID id;

}
