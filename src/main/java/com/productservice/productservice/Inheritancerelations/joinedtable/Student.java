package com.productservice.productservice.Inheritancerelations.joinedtable;

import com.productservice.productservice.Inheritancerelations.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_student")
public class Student extends User {
    private double psp;
}
