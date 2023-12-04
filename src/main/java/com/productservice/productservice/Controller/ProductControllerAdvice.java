package com.productservice.productservice.Controller;


import com.productservice.productservice.Dtos.ExceptionDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody()
    private ResponseEntity<ExceptionDto> handleProductNotFoundExeception(
            ProductNotFoundException productNotFoundException)

    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
           return  new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);

    }

}
