package dev.brohit.productservice.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
}
