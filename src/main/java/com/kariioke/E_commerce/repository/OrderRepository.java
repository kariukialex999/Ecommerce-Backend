package com.kariioke.E_commerce.repository;

import com.kariioke.E_commerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
