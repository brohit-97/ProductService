package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.FakeStoreApiProductDto;
import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreApiProductService")
public class FakeStoreApiProductService implements ProductService{

    private String urlByProductById = "https://fakestoreapi.com/products/{id}";
    private String genericUrl = "https://fakestoreapi.com/products";
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreApiProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<GenericProductResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto[]> response = restTemplate.getForEntity(genericUrl, FakeStoreApiProductDto[].class);
        if(response.getStatusCode() == HttpStatus.OK){
            FakeStoreApiProductDto[] fakeStoreApiProductDtos = response.getBody();
            List<GenericProductResponseDto> genericProductResponseDtoList = new ArrayList<>();
            for(int i = 0; i< fakeStoreApiProductDtos.length; i++){
                genericProductResponseDtoList.add(GenericProductResponseDto.builder()
                                .id(fakeStoreApiProductDtos[i].getId())
                                .description(fakeStoreApiProductDtos[i].getDescription())
                                .imageUrl(fakeStoreApiProductDtos[i].getImage())
                                .price(fakeStoreApiProductDtos[i].getPrice())
                                .title(fakeStoreApiProductDtos[i].getTitle())
                                .build());
            }
            return genericProductResponseDtoList;
        }
        return null;
    }

    @Override
    public GenericProductResponseDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto> response = restTemplate.getForEntity(urlByProductById, FakeStoreApiProductDto.class, id);
        if(response.getStatusCode() == HttpStatus.OK){
             FakeStoreApiProductDto fakeStoreApiProductDto = response.getBody();
            return GenericProductResponseDto.builder()
                     .id(fakeStoreApiProductDto.getId())
                     .title(fakeStoreApiProductDto.getTitle())
                     .description(fakeStoreApiProductDto.getDescription())
                     .imageUrl(fakeStoreApiProductDto.getImage())
                     .price(fakeStoreApiProductDto.getPrice())
                     .category(fakeStoreApiProductDto.getCategory())
                     .build();
        }
        return null;
    }

    @Override
    public GenericProductResponseDto createProduct(GenericProductsRequestDto genericProductsRequestDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreApiProductDto fakeStoreApiProductDto = FakeStoreApiProductDto.builder()
                .category(genericProductsRequestDto.getCategory())
                .description(genericProductsRequestDto.getDescription())
                .image(genericProductsRequestDto.getImageUrl())
                .title(genericProductsRequestDto.getTitle())
                .price(genericProductsRequestDto.getPrice())
                .build();

        ResponseEntity<FakeStoreApiProductDto> response =  restTemplate.postForEntity(genericUrl, fakeStoreApiProductDto, FakeStoreApiProductDto.class);

        if(response.getStatusCode() == HttpStatus.OK){
            FakeStoreApiProductDto fakeStoreApiProductDtoResponse = response.getBody();
            return GenericProductResponseDto.builder()
                    .title(fakeStoreApiProductDtoResponse.getTitle())
                    .category(fakeStoreApiProductDtoResponse.getCategory())
                    .imageUrl(fakeStoreApiProductDtoResponse.getImage())
                    .description(fakeStoreApiProductDtoResponse.getDescription())
                    .id(fakeStoreApiProductDtoResponse.getId())
                    .price(fakeStoreApiProductDtoResponse.getPrice())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(urlByProductById,id);
    }

    @Override
    public void updateProductById(Long id, GenericProductsRequestDto genericProductsRequestDto ) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreApiProductDto fakeStoreApiProductDto = FakeStoreApiProductDto.builder()
                .category(genericProductsRequestDto.getCategory())
                .title(genericProductsRequestDto.getTitle())
                .price(genericProductsRequestDto.getPrice())
                .description(genericProductsRequestDto.getDescription())
                .image(genericProductsRequestDto.getImageUrl())
                .build();
        restTemplate.put(urlByProductById, fakeStoreApiProductDto, id);

    }
}
