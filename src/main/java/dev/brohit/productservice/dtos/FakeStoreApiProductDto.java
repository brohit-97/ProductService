package dev.brohit.productservice.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeStoreApiProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
