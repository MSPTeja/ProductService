package com.productservice.productservice.thirdPartyClients.FakeStoreClient;
import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreUrl;
    private String pathForProducts;
    private String specificProductUrl;

    private String genericProductUrl;

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder,
                    @Value("${fakestore.api.url}") String fakeStoreUrl,
                    @Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.genericProductUrl = fakeStoreUrl + pathForProducts;
        this.specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
    }

    public FakeProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API.
        //RestTemplate
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeProductDto.class, id);
        FakeProductDto fakeStoreProductDto = responseEntity.getBody();
        if (fakeStoreProductDto == null) {
            //Throw an exception.
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist.");
        }
        //Convert FakeStoreProductDto to GenericProductDto before returning.
        return fakeStoreProductDto;
    }
    public List<FakeProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl, FakeProductDto[].class);
        //ArrayList<Integer> => ArrayList.class -> Erasure
        return List.of(responseEntity.getBody());
    }
    public FakeProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeProductDto.class);
        ResponseExtractor<ResponseEntity<FakeProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeProductDto.class);
        ResponseEntity<FakeProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }
    public FakeProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductDto> responseEntity =
                restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeProductDto.class);
        return responseEntity.getBody();
    }
    public FakeProductDto updateProductById(Long id,GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();


        FakeProductDto fakeProductDtos =  restTemplate.patchForObject(specificProductUrl,genericProductDto,FakeProductDto.class,id);

        return new ResponseEntity<FakeProductDto>(fakeProductDtos, HttpStatus.OK).getBody();
    }
}