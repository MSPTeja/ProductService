package com.productservice.productservice.Services;
import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Services.ProductService;
import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.FakeStoreClient.FakeStoreClientAdapter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreClientAdapter fakeStoreAdapter;
    FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter) {
        this.fakeStoreAdapter = fakeStoreAdapter;
    }
    private static GenericProductDto convertToGenericProductDto(FakeProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API.
        //RestTemplate
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeProductDto> responseEntity =
//                restTemplate.getForEntity(specificProductUrl, FakeProductDto.class, id);
//
//        FakeProductDto fakeStoreProductDto = responseEntity.getBody();
//
//        if (fakeStoreProductDto == null) {
//            //Throw an exception.
//            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist.");
//        }
//
//        //Convert FakeStoreProductDto to GenericProductDto before returning.
//        return fakeStoreProductDto;
        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<FakeProductDto[]> responseEntity =
//                restTemplate.getForEntity(genericProductUrl, FakeProductDto[].class);
//
//        //ArrayList<Integer> => ArrayList.class -> Erasure
//
//        return List.of(responseEntity.getBody());
       List<FakeProductDto> fakeProductDtos = fakeStoreAdapter.getAllProducts();

       List<GenericProductDto> genericProductDtos = new ArrayList<>();
       for(FakeProductDto fakeProductDto : fakeProductDtos)
       {
           genericProductDtos.add(convertToGenericProductDto(fakeProductDto));
       }
       return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeProductDto>> responseExtractor =
//                restTemplate.responseEntityExtractor(FakeProductDto.class);
//        ResponseEntity<FakeProductDto> responseEntity =
//                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
//
//        return responseEntity.getBody();
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//
//        FakeProductDto fakeProductDtos =  restTemplate.patchForObject(specificProductUrl,genericProductDto,FakeProductDto.class,id);
//
//        return new ResponseEntity<FakeProductDto>(fakeProductDtos, HttpStatus.OK).getBody();
        return convertToGenericProductDto(fakeStoreAdapter.updateProductById(id,genericProductDto));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeProductDto> responseEntity =
//                restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeProductDto.class);
//
//        return responseEntity.getBody();
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }


}