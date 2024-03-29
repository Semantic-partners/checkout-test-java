package com.semanticpartners.checkout;

public final class PricingRule {

    public static class PricingRuleBuilder {

        private final Item item;

        public PricingRuleBuilder(final Item item) {
            super();
            this.item = item;
        }

        public PricingRule atPrice(long price) {
            return new PricingRule(item, price);
        }
    }

    public static PricingRuleBuilder pricingRuleFor(Item item) {
        return new PricingRuleBuilder(item);
    }

    private final Item item;
    private final long price;

    private PricingRule(final Item item, final long price) {
        super();
        this.item = item;
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public Unit apply(final long amount) {
        return new Unit(amount * price, 0);
    }

    public class Unit {
        private final long price;
        private final long remainder;

        public Unit(final long price, final long remainder) {
            super();
            this.price = price;
            this.remainder = remainder;
        }

        long getPrice() {
            return price;
        }

        long getRemainder() {
            return remainder;
        }

        @Override
        public String toString() {
            return "Unit [price=" + price + "p, remainder=" + remainder + "]";
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + (int) (price ^ (price >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PricingRule other = (PricingRule) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "item " + item + " at " + price + "p each";
    }

}
