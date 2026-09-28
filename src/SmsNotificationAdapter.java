public class SmsNotificationAdapter implements IPushNotifier {
    private ThirdPartySmsProvider smsProvider;

    public SmsNotificationAdapter(ThirdPartySmsProvider smsProvider) {
        this.smsProvider = smsProvider;
    }

    public void notify(AlertMessage alert) {
        if (alert == null) {
            throw new IllegalArgumentException();
        }

        String phone = alert.userPhone();
        if (phone != null && !phone.startsWith("+")) {
            phone = "+" + phone;
        }

        String text = "[" + alert.title() + "] " + alert.body();

        smsProvider.sendSms(phone, text);
    }
}