package com.productservice.productservice.Inheritancerelations.tableperclass;

import com.productservice.productservice.Inheritancerelations.tableperclass.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);
}