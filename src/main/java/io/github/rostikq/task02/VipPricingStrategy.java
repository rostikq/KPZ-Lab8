package io.github.rostikq.task02;

public class VipPricingStrategy implements IMembershipPricingStrategy {
    @Override
    public double calculateBaseCost(MembershipPlan plan, boolean trainer) {
        double cost = (plan.getBaseMonthlyRate() * plan.getMonthsDuration()) + 5000.0;
        return trainer ? cost + 3000.0 : cost;
    }
}