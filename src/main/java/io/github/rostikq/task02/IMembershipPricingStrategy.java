package io.github.rostikq.task02;

public interface IMembershipPricingStrategy {
    double calculateBaseCost(MembershipPlan plan, boolean personalTrainerIncluded);
}