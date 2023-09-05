package dev.brohit.productservice.dtos;

import lombok.Data;

@Data
public class GenericProductsRequestDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
}
