package com.productservice.productservice.Services;

import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException;
    public List<GenericProductDto> getAllProducts();
    public GenericProductDto deleteProductById(Long id);
    public GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto);
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
}
