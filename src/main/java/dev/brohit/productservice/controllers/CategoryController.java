package dev.brohit.productservice.controllers;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryName}")
    public List<GenericProductResponseDto> getCategoryProduct(@PathVariable("categoryName") String categoryName){
        return categoryService.getCategoryProduct(categoryName);
    }
}

