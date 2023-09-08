package dev.brohit.productservice.models;

import lombok.Getter;

@Getter
public class Products extends BaseModel{

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
}
