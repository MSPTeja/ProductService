package com.productservice.productservice.Inheritancerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_studentrepo")
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    <S extends Student> S save(S entity);
}
