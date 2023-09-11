package dev.brohit.productservice.thirdpartyclients.productservice;

import dev.brohit.productservice.exceptions.EntityCreationFailed;
import dev.brohit.productservice.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
    * Wrapper class for the FakeStoreApi
 */
@Service
public class FakeStoreProductServiceClient{

    @Value("${fakestoreapi.baseurl}")
    private String baseUrl;

    @Value("${fakestoreapi.resource.product.path}")
    private String productResourcePath;

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreApiProductDto> getAllProducts() throws NotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto[]> response = restTemplate.getForEntity(baseUrl+productResourcePath, FakeStoreApiProductDto[].class);
        if(response.getStatusCode() == HttpStatus.OK){
            FakeStoreApiProductDto[] fakeStoreApiProductDtos = response.getBody();
            assert fakeStoreApiProductDtos != null;
            return new ArrayList<>(Arrays.asList(fakeStoreApiProductDtos));
        }else{
            throw new NotFoundException("No products found");
        }
    }

    public FakeStoreApiProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto> response = restTemplate.getForEntity(baseUrl + productResourcePath + "/{id}", FakeStoreApiProductDto.class, id);
        if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null){
            return response.getBody();
        }else{
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }

    public FakeStoreApiProductDto createProduct(FakeStoreApiProductDto fakeStoreApiProductDto) throws EntityCreationFailed{
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto> response =  restTemplate.postForEntity(baseUrl+productResourcePath, fakeStoreApiProductDto, FakeStoreApiProductDto.class);

        if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null){
            FakeStoreApiProductDto fakeStoreApiProductDtoResponse = response.getBody();
            return fakeStoreApiProductDtoResponse;
        }else{
            throw new EntityCreationFailed("Product not created");
        }
    }

    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(baseUrl + productResourcePath + "/{id}",id);
    }

    public void updateProductById(Long id, FakeStoreApiProductDto fakeStoreApiProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(baseUrl + productResourcePath + "/{id}", fakeStoreApiProductDto, id);
    }
}