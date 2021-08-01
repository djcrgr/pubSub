package com.djcrgr.subscriber.model.service;

import com.djcrgr.subscriber.model.entity.MessageBean;
import com.djcrgr.subscriber.model.entity.Purchase;
import com.djcrgr.subscriber.model.entity.Subscription;
import com.djcrgr.subscriber.model.repository.PurchaseRepository;
import com.djcrgr.subscriber.model.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriptionRepository subscriptionRepository;

    public MessageService(PurchaseRepository purchaseRepository,
                          SubscriptionRepository subscriptionRepository) {
        this.purchaseRepository = purchaseRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public void save(MessageBean message) {
        switch (message.getAction()) {
            case PURCHASE:
                purchaseRepository.save(getPurchase(message));
                break;
            case SUBSCRIPTION:
                subscriptionRepository.save(getSubscription(message));
                break;
        }
    }

    private Purchase getPurchase(MessageBean message) {
        return Purchase.builder()
                .id(message.getId())
                .msisdn(message.getMsisdn())
                .action(message.getAction().name())
                .timestamp(message.getTimestamp()).build();
    }

    private Subscription getSubscription(MessageBean message) {
        return Subscription.builder()
                .id(message.getId())
                .msisdn(message.getMsisdn())
                .action(message.getAction().name())
                .timestamp(message.getTimestamp()).build();
    }
}
