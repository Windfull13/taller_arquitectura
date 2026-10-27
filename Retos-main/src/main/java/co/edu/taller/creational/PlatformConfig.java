package co.edu.taller.creational;

public class PlatformConfig {
    private static final class Holder {
        private static final PlatformConfig INSTANCE = new PlatformConfig();
    }

    private PlatformConfig() {
    }

    public static PlatformConfig instance() {
        return Holder.INSTANCE;
    }

    public String get(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Configuration key is required");
        }
        return switch (key) {
            case "environment" -> "production";
            default -> null;
        };
    }
}