package dev.brohit.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@Builder
public class Product extends BaseModel{

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Category category;

}
