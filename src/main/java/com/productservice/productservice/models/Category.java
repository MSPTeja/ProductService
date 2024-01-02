package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{


    @Column(nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category") //to avoid extra creation of table we this mappedby
    private List<Product> products;
    /*
WA group -
    - Creator
    - Admin
    - Members
Student ----- Batch
    1             1
Student -------- Batch (current batch) => M:1
   M                1
   1              M
Student -------- Batch (previous batch) => M:M
   M               1
 - current batch
 - previous batch
 */
//Category ------ Product
}
