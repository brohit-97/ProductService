package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import dev.brohit.productservice.exceptions.EntityCreationFailed;
import dev.brohit.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductServiceDBBased {
    public List<GenericProductResponseDto> getAllProducts() throws NotFoundException;

    public GenericProductResponseDto getProductById(UUID id) throws NotFoundException;

    public GenericProductResponseDto createProduct(GenericProductsRequestDto genericProductsRequestDto) throws EntityCreationFailed;

    public void deleteProductById(UUID id);

    public void updateProductById(UUID id, GenericProductsRequestDto genericProductsRequestDto);
}
