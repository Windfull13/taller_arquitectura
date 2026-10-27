package co.edu.taller.structural;

public class PaymentGatewayAdapter {
    public interface PaymentPort {
        String charge(String orderId, long pesos);
    }

    public static class LegacyGateway {
        public String chargeInCents(String id, long cents) {
            return "LEGACY:" + id + ":" + cents;
        }
    }

    private final LegacyGateway legacy;

    public PaymentGatewayAdapter(LegacyGateway legacy) {
        if (legacy == null) {
            throw new IllegalArgumentException("Legacy gateway is required");
        }
        this.legacy = legacy;
    }

    public String charge(String orderId, long pesos) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID is required");
        }
        if (pesos <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        try {
            return legacy.chargeInCents(orderId, Math.multiplyExact(pesos, 100));
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("Amount is too large", exception);
        }
    }
}