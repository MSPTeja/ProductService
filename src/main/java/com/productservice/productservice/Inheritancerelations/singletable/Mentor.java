package com.productservice.productservice.Inheritancerelations.singletable;

import com.productservice.productservice.Inheritancerelations.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
public class Mentor extends User {
    private double avg_rating;
}
