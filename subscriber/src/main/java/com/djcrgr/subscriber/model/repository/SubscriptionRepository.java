package com.djcrgr.subscriber.model.repository;

import com.djcrgr.subscriber.model.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
