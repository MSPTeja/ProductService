package com.productservice.productservice.Inheritancerelations.singletable;

import com.productservice.productservice.Inheritancerelations.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
public class TA extends User {
    private String ta_session;

}
