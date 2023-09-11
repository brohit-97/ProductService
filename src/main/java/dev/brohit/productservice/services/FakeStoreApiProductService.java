package dev.brohit.productservice.services;

import dev.brohit.productservice.dtos.GenericProductResponseDto;
import dev.brohit.productservice.dtos.GenericProductsRequestDto;
import dev.brohit.productservice.exceptions.EntityCreationFailed;
import dev.brohit.productservice.exceptions.NotFoundException;
import dev.brohit.productservice.thirdpartyclients.productservice.FakeStoreApiProductDto;
import dev.brohit.productservice.thirdpartyclients.productservice.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("fakeStoreApiProductService")
public class FakeStoreApiProductService implements ProductService {

    /**
     * This is the client that we will use to make calls to the FakeStoreApi
     * We are using fakeStoreApiProductServiceClient to make calls to the FakeStoreApi directly.
     * Alternatively, we can use the thirdPartyProductServicesClient to make calls to the FakeStoreApi
     * Lose coupling
     */
    FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreApiProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public List<GenericProductResponseDto> getAllProducts() throws NotFoundException {
        return fakeStoreProductServiceClient.getAllProducts().stream().map(fakeStoreApiProductDto -> convertFakeStoreApiProductDtoToGenericProductResponseDto(fakeStoreApiProductDto)).toList();
    }

    @Override
    public GenericProductResponseDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreApiProductDtoToGenericProductResponseDto(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductResponseDto createProduct(GenericProductsRequestDto genericProductsRequestDto) throws EntityCreationFailed {
        return convertFakeStoreApiProductDtoToGenericProductResponseDto(fakeStoreProductServiceClient.createProduct(convertGenericProductRequestDtoToFakeStoreApiProductDto(genericProductsRequestDto)));
    }

    @Override
    public void deleteProductById(Long id) {
        fakeStoreProductServiceClient.deleteProductById(id);
    }

    @Override
    public void updateProductById(Long id, GenericProductsRequestDto genericProductsRequestDto) {
        fakeStoreProductServiceClient.updateProductById(id, convertGenericProductRequestDtoToFakeStoreApiProductDto(genericProductsRequestDto));
    }

    public GenericProductResponseDto convertFakeStoreApiProductDtoToGenericProductResponseDto(FakeStoreApiProductDto fakeStoreApiProductDto){
        return GenericProductResponseDto.builder()
                .id(fakeStoreApiProductDto.getId())
                .title(fakeStoreApiProductDto.getTitle())
                .description(fakeStoreApiProductDto.getDescription())
                .imageUrl(fakeStoreApiProductDto.getImage())
                .price(fakeStoreApiProductDto.getPrice())
                .category(fakeStoreApiProductDto.getCategory())
                .build();
    }

    public FakeStoreApiProductDto convertGenericProductRequestDtoToFakeStoreApiProductDto(GenericProductsRequestDto genericProductsRequestDto){
        return FakeStoreApiProductDto.builder()
                .title(genericProductsRequestDto.getTitle())
                .description(genericProductsRequestDto.getDescription())
                .image(genericProductsRequestDto.getImageUrl())
                .price(genericProductsRequestDto.getPrice())
                .category(genericProductsRequestDto.getCategory())
                .build();
    }
}