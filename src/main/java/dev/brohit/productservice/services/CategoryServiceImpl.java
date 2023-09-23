package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.models.Category;
import dev.brohit.productservice.models.Product;
import dev.brohit.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import dev.brohit.productservice.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<String> getAllCategories() {
        List<String> listOfCategories = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> listOfCategories.add(category.getName()));
        return listOfCategories;
    }

    @Override
    public List<GenericProductResponseDto> getCategoryProduct(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        List<Product> products =  productRepository.findAllByCategory(category);
        return products.stream().map(this::convertProductToGenericProductResponseDto).toList();
    }

    private GenericProductResponseDto convertProductToGenericProductResponseDto(Product product){
        return GenericProductResponseDto.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .build();
    }
}
