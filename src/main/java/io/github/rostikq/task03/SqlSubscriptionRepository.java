package io.github.rostikq.task03;

import io.github.rostikq.task02.Subscription;

public class SqlSubscriptionRepository implements ISubscriptionRepository {
    @Override
    public void save(Subscription subscription) {
        System.out.println("[База даних] Абонемент #" + subscription.getId() + " додано до таблиці subscriptions.");
    }
}
