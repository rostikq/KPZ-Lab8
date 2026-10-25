package io.github.rostikq.task03;

import io.github.rostikq.task02.Member;
import io.github.rostikq.task02.MembershipPlan;
import io.github.rostikq.task02.Subscription;

public class SubscriptionController {
    private final ISubscriptionRepository repository;
    private final INotificationService notificationService;

    public SubscriptionController(ISubscriptionRepository repository, INotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public String registerSubscription(String clientName, String planCode) {
        Member member = new Member(42, clientName, "+380509998877", true);
        MembershipPlan plan = new MembershipPlan(planCode, "Річний абонемент", 1200.0, 12);

        // Створення через Creator всередині сутності
        Subscription sub = Subscription.create(1002, member, plan, true, "2026-11-01");

        // Indirection & Persistence
        repository.save(sub);
        notificationService.sendPush(member.getPhone(), "Ваш абонемент активирован!");

        return "Договір #" + sub.getId() + " з " + sub.getMember().getName() +
                "\nТариф: " + sub.getPlan().getCode() +
                "\nБазова вартість: " + sub.getBaseAmount() + " грн" +
                "\nЗнижка: " + sub.getDiscountAmount() + " грн" +
                "\nДо сплати: " + sub.getFinalCost() + " грн";
    }
}
