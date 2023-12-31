package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import dev.brohit.productservice.exceptions.EntityCreationFailed;
import dev.brohit.productservice.exceptions.NotFoundException;


import java.util.List;

public interface ProductService {
    public List<GenericProductResponseDto> getAllProducts() throws NotFoundException;

    public GenericProductResponseDto getProductById(Long id) throws NotFoundException;

    public GenericProductResponseDto createProduct(GenericProductsRequestDto genericProductsRequestDto) throws EntityCreationFailed;

    public void deleteProductById(Long id);

    public void updateProductById(Long id, GenericProductsRequestDto genericProductsRequestDto);
}
