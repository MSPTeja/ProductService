package com.productservice.productservice.Inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity(name = "ms_ta")
public class TA extends User{
    private String ta_session;

}
