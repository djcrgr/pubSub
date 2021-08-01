package com.djcrgr.subscriber.model.entity;

public enum Action {
    PURCHASE,
    SUBSCRIPTION;

    public static Action getAction(String action) {
        return action.equals(PURCHASE.name()) ? PURCHASE : SUBSCRIPTION;
    }
}
