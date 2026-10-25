package io.github.rostikq.task02;

public class Subscription {
    private final int id;
    private final Member member;
    private final MembershipPlan plan;
    private final boolean personalTrainerIncluded;
    private final double baseAmount;
    private final double discountAmount;
    private final double finalCost;
    private final String startDate;
    private final String status;

    private Subscription(int id, Member member, MembershipPlan plan, boolean personalTrainerIncluded,
                         IMembershipPricingStrategy pricingStrategy, String startDate) {
        this.id = id;
        this.member = member;
        this.plan = plan;
        this.personalTrainerIncluded = personalTrainerIncluded;
        this.startDate = startDate;

        // Information Expert: сутність сама обчислює власну вартість за допомогою стратегії
        this.baseAmount = pricingStrategy.calculateBaseCost(plan, personalTrainerIncluded);
        this.discountAmount = member.isHasDiscountCard() ? this.baseAmount * 0.10 : 0.0;
        this.finalCost = this.baseAmount - this.discountAmount;
        this.status = "Active";
    }

    // Static Factory Method (Creator)
    public static Subscription create(int id, Member member, MembershipPlan plan,
                                      boolean personalTrainerIncluded, String startDate) {
        IMembershipPricingStrategy strategy;
        switch (plan.getCode().toUpperCase()) {
            case "VIP": strategy = new VipPricingStrategy(); break;
            case "DAY": strategy = new DayPricingStrategy(); break;
            default: strategy = new FullPricingStrategy(); break;
        }
        return new Subscription(id, member, plan, personalTrainerIncluded, strategy, startDate);
    }

    public int getId() { return id; }
    public Member getMember() { return member; }
    public MembershipPlan getPlan() { return plan; }
    public double getBaseAmount() { return baseAmount; }
    public double getDiscountAmount() { return discountAmount; }
    public double getFinalCost() { return finalCost; }
    public String getStatus() { return status; }
}