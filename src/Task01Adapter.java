import java.math.BigDecimal;

public class Task01Adapter implements IPaymentGateway {
    private final LegacyBillingSystem legacyBillingSystem;

    public Task01Adapter(LegacyBillingSystem legacyBillingSystem) {
        if (legacyBillingSystem == null) {
            throw new IllegalArgumentException("LegacyBillingSystem cannot be null");
        }
        this.legacyBillingSystem = legacyBillingSystem;
    }

    @Override
    public void processPayment(int customerId, BigDecimal amountInDollars) {
        if (amountInDollars == null || amountInDollars.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        long amountInCents = amountInDollars.multiply(BigDecimal.valueOf(100)).longValueExact();
        legacyBillingSystem.chargeCustomerInCents(customerId, amountInCents);
    }
}