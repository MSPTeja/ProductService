package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name = "orders")
public class Orders extends BaseModel{
    @ManyToMany
    List<Product> products;
    /*
         1         M
        Order --> Product ==> M:M
          M          1
     */
}
