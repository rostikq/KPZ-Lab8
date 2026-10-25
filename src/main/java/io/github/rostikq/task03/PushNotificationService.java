package io.github.rostikq.task03;

public class PushNotificationService implements INotificationService {
    @Override
    public void sendPush(String phone, String message) {
        System.out.println("[Push Notification] Повідомлення надіслано на номер " + phone + ": " + message);
    }
}
