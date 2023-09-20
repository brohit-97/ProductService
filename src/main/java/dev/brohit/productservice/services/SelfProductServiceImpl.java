package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import dev.brohit.productservice.exceptions.EntityCreationFailed;
import dev.brohit.productservice.exceptions.NotFoundException;
import dev.brohit.productservice.models.Product;
import dev.brohit.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class SelfProductServiceImpl implements ProductServiceDBBased{

    ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<GenericProductResponseDto> getAllProducts() throws NotFoundException {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertProductToGenericProductResponseDto).toList();
    }


    public GenericProductResponseDto getProductById(UUID id) throws NotFoundException {
         Optional<GenericProductResponseDto> product = productRepository.findById(id).map(this::convertProductToGenericProductResponseDto);
            if(product.isPresent()){
                return product.get();
            }else{
                throw new NotFoundException("Product with id " + id + " not found");
            }
    }

    @Override
    public GenericProductResponseDto createProduct(GenericProductsRequestDto genericProductsRequestDto) throws EntityCreationFailed {
        Product product = Product.builder()
                .title(genericProductsRequestDto.getTitle())
                .description(genericProductsRequestDto.getDescription())
                .imageUrl(genericProductsRequestDto.getImageUrl())
                .price(genericProductsRequestDto.getPrice())
                .build();
        productRepository.save(product);
        return convertProductToGenericProductResponseDto(product);
    }

    @Override
    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProductById(UUID id, GenericProductsRequestDto genericProductsRequestDto) {
        Product product = productRepository.findById(id).get();
        product.setTitle(genericProductsRequestDto.getTitle());
        product.setDescription(genericProductsRequestDto.getDescription());
        product.setImageUrl(genericProductsRequestDto.getImageUrl());
        product.setPrice(genericProductsRequestDto.getPrice());
        productRepository.save(product);

    }

    public GenericProductResponseDto convertProductToGenericProductResponseDto(Product product){
        return GenericProductResponseDto.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .build();
    }
}
