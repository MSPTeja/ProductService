package com.productservice.productservice.Services;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.Repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

    @Primary
    @Service
    public class SelfProductServiceImpl implements ProductService {
        private ProductRepository productRepository;

        SelfProductServiceImpl(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
            //Make a DB call & get the product with given id.
            GenericProductDto genericProductDto = new GenericProductDto();
            Optional<Product> optionalProduct = productRepository.findById(UUID.fromString("9fa06bde-3787-4199-88a3-98d8d3ccbee7"));

            Product product = optionalProduct.get();

            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setCategory(product.getCategory().toString());
            return genericProductDto;
        }

        @Override
        public List<GenericProductDto> getAllProducts() {
            return null;
        }
        @Override
        public GenericProductDto deleteProductById(Long id) {
            return null;
        }

        @Override
        public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
            return null;
        }

        @Override
        public GenericProductDto createProduct(GenericProductDto genericProductDto) {
            return null;
        }


    }

