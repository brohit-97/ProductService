package dev.brohit.productservice.repositories;

import dev.brohit.productservice.models.Category;
import dev.brohit.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByCategory(Category category);
}
