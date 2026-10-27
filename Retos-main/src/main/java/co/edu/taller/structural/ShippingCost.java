package co.edu.taller.structural;

public interface ShippingCost {
    long cost();

    class Standard implements ShippingCost {
        @Override
        public long cost() {
            return 12000;
        }
    }

    class Insurance implements ShippingCost {
        private final ShippingCost delegate;

        public Insurance(ShippingCost delegate) {
            if (delegate == null) {
                throw new IllegalArgumentException("Shipping cost is required");
            }
            this.delegate = delegate;
        }

        @Override
        public long cost() {
            return delegate.cost() + 3000;
        }
    }

    class Priority implements ShippingCost {
        private final ShippingCost delegate;

        public Priority(ShippingCost delegate) {
            if (delegate == null) {
                throw new IllegalArgumentException("Shipping cost is required");
            }
            this.delegate = delegate;
        }

        @Override
        public long cost() {
            return delegate.cost() + 6500;
        }
    }
}
