package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{


    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category") //to avoid extra creation of table we this mappedby
    private List<Product> products;
}
