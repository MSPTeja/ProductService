package com.productservice.productservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeProductDto {
    //DTO --> Data transfer objects
    private Long Id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;

}
