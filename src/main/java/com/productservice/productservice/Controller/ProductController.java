package com.productservice.productservice.Controller;

import com.productservice.productservice.Dtos.FakeProductDto;
import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
//    @Qualifier("name")
    private ProductService productService;
    //constructor Injection
//    ProductController(ProductService productService)
//    {
//        this.productService = productService;
//    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) //GenericProductDto
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

}
