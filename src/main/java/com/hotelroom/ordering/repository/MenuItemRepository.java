package com.hotelroom.ordering.repository;

import com.hotelroom.ordering.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    Optional<MenuItem> findByCodeIgnoreCase(String code);
}
