package com.hotelroom.ordering.repository;

import com.hotelroom.ordering.entity.BeverageOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageOrderRepository extends JpaRepository<BeverageOrder, Long> {
}
