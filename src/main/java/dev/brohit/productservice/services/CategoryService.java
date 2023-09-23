package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.models.Product;

import java.util.List;

public interface CategoryService {

    List<String> getAllCategories();
    List<GenericProductResponseDto> getCategoryProduct(String categoryName);

}
