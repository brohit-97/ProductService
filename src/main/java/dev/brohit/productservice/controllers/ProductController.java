package dev.brohit.productservice.controllers;

import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.exceptions.NotFoundException;
import dev.brohit.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController( ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductResponseDto getProductById(@PathVariable Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public GenericProductResponseDto createProduct(@RequestBody GenericProductsRequestDto genericProductsRequestDto){
        return productService.createProduct(genericProductsRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
         productService.deleteProductById(id);

    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable Long id, @RequestBody GenericProductsRequestDto genericProductsRequestDto){
         productService.updateProductById(id, genericProductsRequestDto);
    }
}
