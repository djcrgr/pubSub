package com.djcrgr.subscriber.model.repository;

import com.djcrgr.subscriber.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
