package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.dtos.GenericProductsRequestDto;


import java.util.List;

public interface ProductService {
    public List<GenericProductResponseDto> getAllProducts();

    public GenericProductResponseDto getProductById(Long id);

    public GenericProductResponseDto createProduct(GenericProductsRequestDto genericProductsRequestDto);

    public void deleteProductById(Long id);

    public void updateProductById(Long id, GenericProductsRequestDto genericProductsRequestDto);
}
