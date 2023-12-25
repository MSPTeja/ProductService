package com.productservice.productservice.Controller;

import com.productservice.productservice.Dtos.ExceptionDto;
import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @Qualifier("name")
    private ProductService productService;
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService)
    {
        this.productService = productService;
    }
    //constructor Injection
//    ProductController(ProductService productService)
//    {
//        this.productService = productService;
//    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException //GenericProductDto
    {
//          return "Scaler Product fectched with id:" +id;
        return productService.getProductById(id) ;
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts()
    {
          return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable Long id)
    {
        return productService.deleteProductById(id);
    }
    @PatchMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable Long id,@RequestBody GenericProductDto genericProductDto)
    {
         return productService.updateProductById(id,genericProductDto);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto)

    {
        return productService.createProduct(genericProductDto);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
//    {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        ResponseEntity responseEntity = new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }

}
