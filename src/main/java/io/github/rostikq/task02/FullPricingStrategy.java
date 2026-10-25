package io.github.rostikq.task02;

public class FullPricingStrategy implements IMembershipPricingStrategy {
    @Override
    public double calculateBaseCost(MembershipPlan plan, boolean trainer) {
        double cost = plan.getBaseMonthlyRate() * plan.getMonthsDuration();
        return trainer ? cost + 3000.0 : cost;
    }
}