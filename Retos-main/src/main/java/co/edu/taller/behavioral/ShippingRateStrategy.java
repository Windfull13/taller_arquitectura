package co.edu.taller.behavioral;

public class ShippingRateStrategy {
    public interface Rate {
        long calculate(long base);
    }

    public enum Mode {STANDARD, EXPRESS, NIGHT}

    public long quote(Mode mode, long base) {
        if (mode == null) {
            throw new IllegalArgumentException("Shipping mode is required");
        }
        if (base <= 0) {
            throw new IllegalArgumentException("Base cost must be positive");
        }
        Rate strategy = switch (mode) {
            case STANDARD -> value -> value;
            case EXPRESS -> value -> value * 18 / 10;
            case NIGHT -> value -> value * 15 / 10;
        };
        return strategy.calculate(base);
    }
}