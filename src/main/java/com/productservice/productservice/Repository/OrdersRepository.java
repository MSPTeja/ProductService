package com.productservice.productservice.Repository;

import com.productservice.productservice.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, UUID> {
}