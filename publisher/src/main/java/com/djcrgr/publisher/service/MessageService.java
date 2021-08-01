package com.djcrgr.publisher.service;

import com.djcrgr.publisher.entity.Action;
import com.djcrgr.publisher.entity.MessageBean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {

    private static final AtomicLong id = new AtomicLong(); // concurency

    public synchronized static MessageBean getMessage() {
        return MessageBean.builder()
                .id(id.incrementAndGet())
                .msisdn(getMsisdn())
                .action(getAction())
                .timestamp((int) (System.currentTimeMillis()))
                .build();
    }

    private static Action getAction() {
        return new Random().nextBoolean() ? Action.SUBSCRIPTION : Action.PURCHASE;
    }

    private static int getMsisdn() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
