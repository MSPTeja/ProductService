package com.productservice.productservice.Inheritancerelations.tableperclass;

import com.productservice.productservice.Inheritancerelations.tableperclass.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    <S extends Student> S save(S entity);
}