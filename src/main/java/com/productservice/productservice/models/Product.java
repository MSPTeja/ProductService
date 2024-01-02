package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{

    private String title;
    private String description;
//    private int price;
    private String image;
    // Category is not primitive datatype so need to map.
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;


   @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;
    /*
       1            1
      Product      Price ==> 1:1
         1            1
     */
}
