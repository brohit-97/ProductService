package dev.brohit.productservice.controllers;

import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.exceptions.EntityCreationFailed;
import dev.brohit.productservice.exceptions.NotFoundException;
import dev.brohit.productservice.services.ProductService;
import dev.brohit.productservice.services.ProductServiceDBBased;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductServiceDBBased productService;

    public ProductController( ProductServiceDBBased productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductResponseDto> getAllProducts() throws NotFoundException{
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductResponseDto getProductById(@PathVariable UUID id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public GenericProductResponseDto createProduct(@RequestBody GenericProductsRequestDto genericProductsRequestDto) throws EntityCreationFailed {
        return productService.createProduct(genericProductsRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable UUID id){
         productService.deleteProductById(id);

    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable UUID id, @RequestBody GenericProductsRequestDto genericProductsRequestDto){
         productService.updateProductById(id, genericProductsRequestDto);
    }
}
