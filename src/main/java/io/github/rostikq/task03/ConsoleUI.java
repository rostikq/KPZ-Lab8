package io.github.rostikq.task03;

import java.util.Scanner;

public class ConsoleUI {
    private final SubscriptionController controller;

    public ConsoleUI(SubscriptionController controller) {
        this.controller = controller;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Реєстрація абонемента фітнес-клубу ===");
        System.out.print("Введіть ім'я клієнта: ");
        String name = scanner.nextLine();
        System.out.print("Введіть тип абонемента (Day/Full/VIP): ");
        String planType = scanner.nextLine();

        String resultContract = controller.registerSubscription(name, planType);
        System.out.println(resultContract);
    }
}
