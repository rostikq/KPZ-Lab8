package io.github.rostikq.task02;

public class DayPricingStrategy implements IMembershipPricingStrategy {
    @Override
    public double calculateBaseCost(MembershipPlan plan, boolean trainer) {
        double cost = (plan.getBaseMonthlyRate() * plan.getMonthsDuration()) * 0.8;
        return trainer ? cost + 3000.0 : cost;
    }
}