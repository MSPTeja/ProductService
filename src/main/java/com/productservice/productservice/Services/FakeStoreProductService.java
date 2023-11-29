package com.productservice.productservice.Services;

import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private final String getProductUrl = "https://fakestoreapi.com/products/{id}";
    private final String getProductUrl1 = "https://fakestoreapi.com/products/";


    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {

        this.restTemplateBuilder = restTemplateBuilder;
    }
//    private static GenericProductDto convertToGenericProductDto(FakeProductDto fakeProductDto) {
//        GenericProductDto genericProductDto = new GenericProductDto();
//        genericProductDto.setId(fakeProductDto.getId());
//        genericProductDto.setImage(fakeProductDto.getImage());
//        genericProductDto.setCategory(fakeProductDto.getCategory());
//        genericProductDto.setDescription(fakeProductDto.getDescription());
//        genericProductDto.setTitle(fakeProductDto.getTitle());
//        genericProductDto.setPrice(fakeProductDto.getPrice());
//
//        return genericProductDto;
//    }
    private GenericProductDto convertToGenericDto(FakeProductDto fakeProductDto)
    {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeProductDto.getId());
       genericProductDto.setImage(fakeProductDto.getImage());
        genericProductDto.setCategory(fakeProductDto.getCategory());
        genericProductDto.setDescription(fakeProductDto.getDescription());
        genericProductDto.setTitle(fakeProductDto.getTitle());
        genericProductDto.setPrice(fakeProductDto.getPrice());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {     //GenericProductDto

    RestTemplate resttemplate = restTemplateBuilder.build();

     ResponseEntity <FakeProductDto> responseEntity =
              resttemplate.getForEntity(getProductUrl,FakeProductDto.class,id);
         return convertToGenericDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeProductDto[]> responseEntity =
                restTemplate.getForEntity(getProductUrl1, FakeProductDto[].class);

        //ArrayList<Integer> => ArrayList.class -> Erasure

        List<GenericProductDto> result = new ArrayList<>();
        List<FakeProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
        for(FakeProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            result.add(convertToGenericDto(fakeStoreProductDto));
        }

        return result;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void updateProductById() {

    }


    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductDto> responseEntity =
                restTemplate.postForEntity(getProductUrl1, genericProductDto, FakeProductDto.class);

        return convertToGenericDto(responseEntity.getBody());
    }
}
